import matplotlib.pyplot as plt
import pandas as pd


dados = pd.read_csv('Tempos/Tempos Formatados/Tempos Totais (desordenado).csv')

tamanhos = ['10 entradas', '100 entradas', '1000 entradas', '10000 entradas', '100000 entradas', '1000000 entradas']

dados[tamanhos] = dados[tamanhos].replace({',': '.'}, regex=True)
dados[tamanhos] = dados[tamanhos].apply(pd.to_numeric)

tamanhos_int = [10, 100, 1000, 10000, 100000, 1000000]

cores = ['tab:blue', 'tab:orange', 'tab:green', 'tab:red', 'tab:purple', 
         '#A52A2A', '#FFC0CB', '#808080', '#6B8E23', '#00FFFF', '#00FF00']


metodos = [
    ('Insertion Sort', cores[0]),
    ('Bubble Sort', cores[1]),
    ('Selection Sort', cores[2]),
    ('Shell Sort', cores[3]),
    ('Heap Sort', cores[4]),
    ('Merge Sort', cores[5]),
    ('Quick Sem Recurssão', cores[7]),
    ('Counting Sort', cores[8]),
    ('Radix Sort', cores[9]),
    ('Bucket Sort', cores[10])
]

plt.figure(figsize=(12, 8))

for metodo, cor in metodos:
    tempos = dados.loc[dados['Métodos de Ordenação'] == metodo, tamanhos].values.flatten()
    plt.plot(tamanhos_int, tempos, label=metodo, marker='o', color=cor, linestyle='-', linewidth=2)


plt.yscale('log')
plt.xscale('log')

plt.xlabel('Tamanho da Entrada (log scale)')
plt.ylabel('Tempo de Execução (log scale)')
plt.title('Comparação de Tempo de Execução para Diferentes Métodos de Ordenação')

plt.legend()
plt.grid(True, which="both", linestyle="--", linewidth=0.5)

plt.tight_layout()
plt.savefig("comparacao_metodos_ordenacao_all.png")
plt.close()
