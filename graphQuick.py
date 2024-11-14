import matplotlib.pyplot as plt
import pandas as pd

dados = pd.read_csv('Tempos/Tempos Formatados/Tempos Totais (desordenado).csv')

tamanhos = ['10 entradas', '100 entradas', '1000 entradas', '10000 entradas']

for tamanho in tamanhos:
    dados[tamanho] = dados[tamanho].str.replace(',', '.').astype(float)

quick_sort_tempos = dados.loc[dados['Métodos de Ordenação'] == 'Quick Sort', tamanhos].values.flatten()
quick_sem_recurssao_tempos = dados.loc[dados['Métodos de Ordenação'] == 'Quick Sem Recurssão', tamanhos].values.flatten()

tamanhos_int = [10, 100, 1000, 10000]

plt.figure(figsize=(10, 6))

plt.plot(tamanhos_int, quick_sort_tempos, label='Quick Sort', marker='o', color='b', linestyle='-', linewidth=2)

plt.plot(tamanhos_int, quick_sem_recurssao_tempos, label='Quick Sem Recursão', marker='o', color='r', linestyle='-', linewidth=2)

plt.yscale('log')


plt.xlabel('Tamanho da Entrada')
plt.ylabel('Tempo de Execução (log scale)')
plt.title('Comparação de Quick Sort e Quick Sem Recursão')

plt.legend()

plt.grid(True, which="both", linestyle="--", linewidth=0.5)

plt.tight_layout()

plt.savefig('comparacao_quick_sort_quick_sem_recurssao.png', format='png')

plt.close()
