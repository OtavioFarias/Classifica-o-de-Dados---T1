import matplotlib.pyplot as plt
import pandas as pd


'''=(SUM(A2:AE2) - MAX(A2:AE2) - MIN(A2:AE2)) / (COUNT(A2:AE2) - 2)'''

# Carregar os dados do CSV
dados = pd.read_csv('Tempos/Tempos Formatados/Tempos Totais (desordenado).csv')

# Extrair os tamanhos das entradas e os tempos de execução
tamanhos = ['10 entradas', '100 entradas', '1000 entradas', '10000 entradas', '100000 entradas']
tempos_insertion_sort = dados.loc[dados['Métodos de Ordenação'] == 'Insertion Sort', tamanhos].values.flatten()

# Converter os tamanhos das entradas para valores inteiros para o eixo X
tamanhos_int = [10, 100, 1000, 10000, 100000]

# Criar o gráfico
plt.figure(figsize=(10, 6))
plt.scatter(tamanhos_int, tempos_insertion_sort, label='Insertion Sort', marker='o', color='b')

# Definir o gráfico em escala logarítmica para o eixo Y
plt.yscale('log')

# Títulos e rótulos
plt.xlabel('Tamanho da Entrada')
plt.ylabel('Tempo de Execução (log scale)')
plt.title('Tempo de Execução do Insertion Sort para Diferentes Tamanhos de Entrada')
plt.grid(True, which="both", linestyle="--", linewidth=0.5)
plt.legend()

# Mostrar o gráfico
plt.show()