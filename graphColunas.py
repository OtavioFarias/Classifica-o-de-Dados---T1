import matplotlib.pyplot as plt
import pandas as pd

# Carregar os dados do CSV
dados = pd.read_csv('Tempos/Tempos Formatados/Tempos Totais (desordenado).csv')

# Lista de métodos de ordenação
metodos = ['Insertion Sort', 'Bubble Sort', 'Selection Sort', 'Shell Sort', 'Heap Sort', 
           'Merge Sort', 'Quick Sort', 'Quick Sem Recurssão', 'Counting Sort', 
           'Radix Sort', 'Bucket Sort']

# Lista de tamanhos de entrada
tamanhos = ['10 entradas', '100 entradas', '1000 entradas', '10000 entradas', 
            '100000 entradas', '1000000 entradas']

# Substituir as vírgulas por pontos e converter as colunas para números
for tamanho in tamanhos:
    dados[tamanho] = dados[tamanho].str.replace(',', '.').astype(float)

# Função para gerar gráficos e salvar como PNG
def salvar_grafico(tamanho):
    plt.figure(figsize=(12, 6))  # Define o tamanho da figura
    
    # Extrair os tempos de execução de cada método para o tamanho especificado
    tempos = []
    for metodo in metodos:
        tempo = dados.loc[dados['Métodos de Ordenação'] == metodo, tamanho].values.flatten()
        tempos.append(tempo[0])
    
    # Definir uma lista de cores distintas para as barras usando RGB
    cores = ['#1f77b4', '#ff7f0e', '#2ca02c', '#d62728', '#9467bd', 
             '#8c564b', '#e377c2', '#7f7f7f', '#bcbd22', '#17becf', '#9eeb75']  # Hexadecimal
    
    # Criar o gráfico de barras com cores distintas
    plt.bar(metodos, tempos, color=cores[:len(metodos)], width=0.5)
    
    # Definir a escala logarítmica para o eixo Y
    plt.yscale('log')
    
    # Títulos e rótulos
    plt.xlabel('Métodos de Ordenação')
    plt.ylabel('Tempo de Execução (log scale)')
    plt.title(f'Tempo de Execução para {tamanho}')
    
    # Adicionar grid
    plt.grid(True, which="both", linestyle="--", linewidth=0.5)
    
    # Rotaciona os nomes dos métodos para melhor leitura
    plt.xticks(rotation=45, ha='right')

    # Ajusta automaticamente o layout
    plt.tight_layout()

    # Salvar o gráfico como PNG
    nome_arquivo = f'{tamanho}.png'  # Nome do arquivo com base no tamanho da entrada
    plt.savefig(nome_arquivo)  # Salva o gráfico
    plt.close()  # Fecha a figura para liberar memória

# Gerar gráficos para cada tamanho de entrada
for tamanho in tamanhos:
    salvar_grafico(tamanho)

print("Gráficos salvos com sucesso!")
