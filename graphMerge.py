import matplotlib.pyplot as plt
import pandas as pd

# Carregar os dados do CSV
dados = pd.read_csv('merge/merges.csv')

# Lista de tamanhos de entrada (de 10 a 10000)
tamanhos = ['10 entradas', '100 entradas', '1000 entradas', '10000 entradas']

# Substituir vírgulas por pontos e converter colunas para números
for tamanho in tamanhos:
    # Converter para string, substituir vírgula por ponto e converter para float
    dados[tamanho] = dados[tamanho].astype(str).str.replace(',', '.').astype(float)

# Obter os tempos para cada um dos métodos de ordenação especificados
metodos = [
    'Merge Comparable',
    'Merge Int',
    'Merge Insertion 5',
    'Merge Insertion 10',
    'Merge Insertion 50'
]

# Tamanhos das entradas em formato numérico para o eixo X
tamanhos_int = [10, 100, 1000, 10000]

# Criar o gráfico de linha
plt.figure(figsize=(12, 8))

# Cores para cada método
cores = ['b', 'g', 'r', 'c', 'm']

# Plotar cada método de ordenação
for metodo, cor in zip(metodos, cores):
    tempos = dados.loc[dados['Métodos de Ordenação'] == metodo, tamanhos].values.flatten()
    plt.plot(tamanhos_int, tempos, label=metodo, marker='o', color=cor, linestyle='-', linewidth=2)

# Definir a escala logarítmica para o eixo Y
plt.yscale('log')

# Títulos e rótulos
plt.xlabel('Tamanho da Entrada')
plt.ylabel('Tempo de Execução (log scale)')
plt.title('Comparação de Métodos de Ordenação Merge')

# Adicionar legenda
plt.legend()

# Adicionar grid
plt.grid(True, which="both", linestyle="--", linewidth=0.5)

# Ajustar layout
plt.tight_layout()

# Salvar o gráfico como arquivo PNG
plt.savefig('comparacao_metodos_merge.png', format='png')

plt.close()
