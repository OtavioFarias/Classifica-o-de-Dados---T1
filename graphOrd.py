import matplotlib.pyplot as plt
import pandas as pd

dados = pd.read_csv('Tempos/Tempos Formatados/Tempos Totais Ord.csv')


metodos = ['Insertion Sort', 'Bubble Sort', 'Selection Sort', 'Shell Sort', 'Heap Sort', 
           'Merge Sort', 'Quick Sort', 'Quick Sem Recurssão', 'Counting Sort', 
           'Radix Sort', 'Bucket Sort']


tamanhos = ['Crescente', 'Decrescente', 'Iguais'
]


for tamanho in tamanhos:
    dados[tamanho] = dados[tamanho].str.replace(',', '.').astype(float)

def salvar_grafico(tamanho):
    plt.figure(figsize=(12, 6)) 
    
   
    tempos = []
    for metodo in metodos:
        tempo = dados.loc[dados['Métodos de Ordenação'] == metodo, tamanho].values.flatten()
        tempos.append(tempo[0])
    
  
    cores = ['#1f77b4', '#ff7f0e', '#2ca02c', '#d62728', '#9467bd', 
             '#8c564b', '#e377c2', '#7f7f7f', '#bcbd22', '#17becf', '#9eeb75'] 
 
    plt.bar(metodos, tempos, color=cores[:len(metodos)], width=0.5)
    
  
    plt.yscale('log')
    
  
    plt.xlabel('Métodos de Ordenação')
    plt.ylabel('Tempo de Execução (log scale)')
    plt.title(f'Tempo de Execução para {tamanho}')
    
  
    plt.grid(True, which="both", linestyle="--", linewidth=0.5)
    
  
    plt.xticks(rotation=45, ha='right')

    # Ajusta automaticamente o layout
    plt.tight_layout()

   
    nome_arquivo = f'{tamanho}.png' 
    plt.savefig(nome_arquivo) 
    plt.close()  

for tamanho in tamanhos:
    salvar_grafico(tamanho)

print("Gráficos salvos com sucesso!")
