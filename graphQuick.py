import matplotlib.pyplot as plt
import pandas as pd

# Carregar os dados do CSV
dados = pd.read_csv('Tempos/Tempos Formatados/Tempos Totais (desordenado).csv')

# Lista de tamanhos de entrada que vamos usar (de 10 a 10000)
tamanhos = ['10 entradas', '100 entradas', '1000 entradas', '10000 entradas']

# Substituir as vírgulas por pontos e converter as colunas para números
for tamanho in tamanhos:
    dados[tamanho] = dados[tamanho].str.replace(',', '.').astype(float)

# Obter os tempos para Quick Sort e Quick Sem Recursão
quick_sort_tempos = dados.loc[dados['Métodos de Ordenação'] == 'Quick Sort', tamanhos].values.flatten()
quick_sem_recurssao_tempos = dados.loc[dados['Métodos de Ordenação'] == 'Quick Sem Recurssão', tamanhos].values.flatten()

# Tamanhos das entradas em formato numérico para o eixo X
tamanhos_int = [10, 100, 1000, 10000]

# Criar o gráfico de linha
plt.figure(figsize=(10, 6))

# Plotar Quick Sort
plt.plot(tamanhos_int, quick_sort_tempos, label='Quick Sort', marker='o', color='b', linestyle='-', linewidth=2)

# Plotar Quick Sem Recursão
plt.plot(tamanhos_int, quick_sem_recurssao_tempos, label='Quick Sem Recursão', marker='o', color='r', linestyle='-', linewidth=2)

# Definir a escala logarítmica para o eixo Y
plt.yscale('log')

# Títulos e rótulos
plt.xlabel('Tamanho da Entrada')
plt.ylabel('Tempo de Execução (log scale)')
plt.title('Comparação de Quick Sort e Quick Sem Recursão')

# Adicionar legenda
plt.legend()

# Adicionar grid
plt.grid(True, which="both", linestyle="--", linewidth=0.5)

# Ajustar layout
plt.tight_layout()

# Salvar o gráfico como arquivo PNG
plt.savefig('comparacao_quick_sort_quick_sem_recurssao.png', format='png')

plt.close()