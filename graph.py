import matplotlib.pyplot as plt
import pandas as pd


dados = pd.read_csv('Tempos/Tempos Formatados/Tempos Totais (desordenado).csv')


tamanhos = ['10 entradas', '100 entradas', '1000 entradas', '10000 entradas', '100000 entradas', '1000000 entradas']


tempos_insertion_sort = dados.loc[dados['Métodos de Ordenação'] == 'Insertion Sort', tamanhos].values.flatten()
tempos_bubble_sort = dados.loc[dados['Métodos de Ordenação'] == 'Bubble Sort', tamanhos].values.flatten()
tempos_selection_sort = dados.loc[dados['Métodos de Ordenação'] == 'Selection Sort', tamanhos].values.flatten()
tempos_shell_sort = dados.loc[dados['Métodos de Ordenação'] == 'Shell Sort', tamanhos].values.flatten()
tempos_heap_sort = dados.loc[dados['Métodos de Ordenação'] == 'Heap Sort', tamanhos].values.flatten()
tempos_merge_sort = dados.loc[dados['Métodos de Ordenação'] == 'Merge Sort', tamanhos].values.flatten()
tempos_quick_sort = dados.loc[dados['Métodos de Ordenação'] == 'Quick Sort', tamanhos].values.flatten()
tempos_quick_sem_recurssao = dados.loc[dados['Métodos de Ordenação'] == 'Quick Sem Recurssão', tamanhos].values.flatten()
tempos_counting_sort = dados.loc[dados['Métodos de Ordenação'] == 'Counting Sort', tamanhos].values.flatten()
tempos_radix_sort = dados.loc[dados['Métodos de Ordenação'] == 'Radix Sort', tamanhos].values.flatten()
tempos_bucket_sort = dados.loc[dados['Métodos de Ordenação'] == 'Bucket Sort', tamanhos].values.flatten()

dados[tamanhos] = dados[tamanhos].replace({',': '.'}, regex=True)
dados[tamanhos] = dados[tamanhos].apply(pd.to_numeric)

tamanhos_int = [10, 100, 1000, 10000, 100000, 1000000]

plt.figure(figsize=(10, 6))

cores = ['tab:blue', 'tab:orange', 'tab:green', 'tab:red', 'tab:purple', 
         '#A52A2A', '#FFC0CB', '#808080', '#6B8E23', '#00FFFF', '#00FF00'] 


def plot_grafico(metodo, tempos, cor):
    print(tempos)
    plt.figure(figsize=(10, 6))
    plt.scatter(tamanhos_int, tempos, label=metodo, marker='o', color=cor)
    plt.yscale('log') 
    plt.xscale('log') 
    plt.xlabel('Tamanho da Entrada (log scale)')
    plt.ylabel('Tempo de Execução (log scale)')
    plt.title(f'Tempo de Execução do {metodo} para Diferentes Tamanhos de Entrada')
    plt.grid(True, which="both", linestyle="--", linewidth=0.5)
    plt.legend()
    plt.savefig(f"{metodo}.png")  
    plt.close()  


plot_grafico('Insertion Sort', tempos_insertion_sort, cores[0])
plot_grafico('Bubble Sort', tempos_bubble_sort, cores[1])
plot_grafico('Selection Sort', tempos_selection_sort, cores[2])
plot_grafico('Shell Sort', tempos_shell_sort, cores[3])
plot_grafico('Heap Sort', tempos_heap_sort, cores[4])
plot_grafico('Merge Sort', tempos_merge_sort,cores[5])
plot_grafico('Quick Sort', tempos_quick_sort, cores[6])
plot_grafico('Quick Sem Recurssão', tempos_quick_sem_recurssao, cores[7])
plot_grafico('Counting Sort', tempos_counting_sort, cores[8])
plot_grafico('Radix Sort', tempos_radix_sort, cores[9])
plot_grafico('Bucket Sort', tempos_bucket_sort, cores[10])
