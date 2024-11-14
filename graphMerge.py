import matplotlib.pyplot as plt
import pandas as pd

dados = pd.read_csv('merge/merges.csv')

tamanhos = ['10 entradas', '100 entradas', '1000 entradas', '10000 entradas']

for tamanho in tamanhos:

    dados[tamanho] = dados[tamanho].astype(str).str.replace(',', '.').astype(float)


metodos = [
    'Merge Comparable',
    'Merge Int',
    'Merge Insertion 5',
    'Merge Insertion 10',
    'Merge Insertion 50'
]


tamanhos_int = [10, 100, 1000, 10000]


plt.figure(figsize=(12, 8))

cores = ['b', 'g', 'r', 'c', 'm']

for metodo, cor in zip(metodos, cores):
    tempos = dados.loc[dados['Métodos de Ordenação'] == metodo, tamanhos].values.flatten()
    plt.plot(tamanhos_int, tempos, label=metodo, marker='o', color=cor, linestyle='-', linewidth=2)


plt.yscale('log')


plt.xlabel('Tamanho da Entrada')
plt.ylabel('Tempo de Execução (log scale)')
plt.title('Comparação de Métodos de Ordenação Merge')


plt.legend()


plt.grid(True, which="both", linestyle="--", linewidth=0.5)


plt.tight_layout()


plt.savefig('comparacao_metodos_merge.png', format='png')

plt.close()
