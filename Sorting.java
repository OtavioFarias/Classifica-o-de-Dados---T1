package sort;
import java.util.Stack;
import java.util.Arrays;
import java.util.Collections;
import java.util.ArrayList;

public class Sorting {

    // Insertion Sort
    public static <T extends Comparable<T>> void insertion(T[] A, int n) {
        for (int i = 1; i < n; i++) {
            T key = A[i];
            int j = i - 1;

            while (j >= 0 && A[j].compareTo(key) > 0) {
                A[j + 1] = A[j];
                j--;
            }
            A[j + 1] = key;
        }
    }

    // Bubble Sort
    public static <T extends Comparable<T>> void bubble(T[] A, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (A[j].compareTo(A[j + 1]) > 0) {
                    // Troca A[j] e A[j+1]
                    T temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort
    public static <T extends Comparable<T>> void selection(T[] A, int n) {
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (A[j].compareTo(A[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            // Troca A[i] e A[minIndex]
            T temp = A[i];
            A[i] = A[minIndex];
            A[minIndex] = temp;
        }
    }

    // Shell Sort
    public static <T extends Comparable<T>> void shell(T[] A, int n) {
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                T temp = A[i];
                int j;
                for (j = i; j >= gap && A[j - gap].compareTo(temp) > 0; j -= gap) {
                    A[j] = A[j - gap];
                }
                A[j] = temp;
            }
        }
    }

    // Heap Sort
    public static <T extends Comparable<T>> void heap(T[] A, int n) {
        // Constrói um heap máximo
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(A, n, i);
        }

        // Um a um, extrai elementos do heap
        for (int i = n - 1; i > 0; i--) {
            // Move a raiz atual para o final
            T temp = A[0];
            A[0] = A[i];
            A[i] = temp;

            // Chama heapify no heap reduzido
            heapify(A, i, 0);
        }
    }

    private static <T extends Comparable<T>> void heapify(T[] A, int n, int i) {
        int largest = i; // Inicializa largest como raiz
        int left = 2 * i + 1; // filho da esquerda
        int right = 2 * i + 2; // filho da direita

        // Se o filho da esquerda for maior que a raiz
        if (left < n && A[left].compareTo(A[largest]) > 0) {
            largest = left;
        }

        // Se o filho da direita for maior que a raiz
        if (right < n && A[right].compareTo(A[largest]) > 0) {
            largest = right;
        }

        // Se largest não for raiz
        if (largest != i) {
            T swap = A[i];
            A[i] = A[largest];
            A[largest] = swap;

            // Chama heapify recursivamente na subárvore afetada
            heapify(A, n, largest);
        }
    }

    // Merge Sort
    public static <T extends Comparable<T>> void mergeSort(T[] A) {
        if (A.length < 2) {
            return; // Caso base
        }

        int mid = A.length / 2;
        T[] left = (T[]) new Comparable[mid]; // Cria array da metade esquerda
        T[] right = (T[]) new Comparable[A.length - mid]; // Cria array da metade direita

        for (int i = 0; i < mid; i++) {
            left[i] = A[i];
        }
        for (int i = mid; i < A.length; i++) {
            right[i - mid] = A[i];
        }

        mergeSort(left); // Ordena a metade esquerda
        mergeSort(right); // Ordena a metade direita

        merge(A, left, right); // Mescla as duas metades
    }

    private static <T extends Comparable<T>> void merge(T[] A, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                A[k++] = left[i++];
            } else {
                A[k++] = right[j++];
            }
        }
        while (i < left.length) {
            A[k++] = left[i++];
        }
        while (j < right.length) {
            A[k++] = right[j++];
        }
    }

    // Quick Sort
    public static <T extends Comparable<T>> void quick(T[] A, int low, int high) {
        if (low < high) {
            // Partitiona o array
            int pi = partition(A, low, high);

            // Ordena os elementos antes e depois da partição
            quick(A, low, pi - 1);
            quick(A, pi + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] A, int low, int high) {
        T pivot = A[high]; // Pivô
        int i = (low - 1); // Índice do menor elemento

        for (int j = low; j < high; j++) {
            // Se o elemento atual for menor ou igual ao pivô
            if (A[j].compareTo(pivot) <= 0) {
                i++;

                // Troca A[i] e A[j]
                T temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        // Troca A[i + 1] e A[high] (ou pivô)
        T temp = A[i + 1];
        A[i + 1] = A[high];
        A[high] = temp;

        return i + 1;
    }

    public static <T extends Comparable<T>> void quickNR(T[] A, int low, int high) {
        // Stack to store subarray start and end indices
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] { low, high });

        // Process the stack until it is empty
        while (!stack.isEmpty()) {
            // Pop high and low for the current subarray
            int[] range = stack.pop();
            low = range[0];
            high = range[1];

            // Partition the array and get the pivot index
            if (low < high) {
                int pi = partition(A, low, high);

                // Push left subarray to stack if it has more than one element
                if (pi - 1 > low) {
                    stack.push(new int[] { low, pi - 1 });
                }

                // Push right subarray to stack if it has more than one element
                if (pi + 1 < high) {
                    stack.push(new int[] { pi + 1, high });
                }
            }
        }
    }



    // Radix Sort
    public static void radix(int[] array) {
        int max = Arrays.stream(array).max().getAsInt(); // Encontra o maior número para saber o número de dígitos

        // Aplica o Counting Sort para cada dígito, começando do menos significativo
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(array, exp);
        }
    }

    private static void countingSortByDigit(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n]; // Array de saída para valores ordenados
        int[] count = new int[10]; // Array de contagem para cada dígito (0 a 9)

        // Conta a ocorrência de cada dígito
        for (int i = 0; i < n; i++) {
            int digit = (array[i] / exp) % 10;
            count[digit]++;
        }

        // Ajusta o array de contagem para acumular posições dos elementos
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Constrói o array de saída
        for (int i = n - 1; i >= 0; i--) {
            int digit = (array[i] / exp) % 10;
            output[count[digit] - 1] = array[i];
            count[digit]--;
        }

        // Copia o array de saída para o original
        System.arraycopy(output, 0, array, 0, n);
    }

    // Bucket Sort
    public static void bucket(float[] array) {
        int n = array.length;
        if (n <= 0) return;
        // Cria buckets e os inicializa
        ArrayList<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }
        // Distribui os elementos para os buckets
        for (float value : array) {
            int bucketIndex = Math.min((int) (value * n), n - 1);
            buckets[bucketIndex].add(value);
        }
        // Ordena cada bucket e combina os resultados
        int index = 0;
        for (ArrayList<Float> bucket : buckets) {
           insertion(bucketArray, bucketArray.length);
            for (float value : bucket) {
                array[index++] = value;
            }
        }
    }

    // Counting Sort
    public static void counting(int[] array) {
        int max = Arrays.stream(array).max().getAsInt();
        int min = Arrays.stream(array).min().getAsInt();
        int range = max - min + 1;

        int[] count = new int[range];
        int[] output = new int[array.length];

        // Conta a ocorrência de cada elemento
        for (int i : array) {
            count[i - min]++;
        }

        // Modifica o array de contagem para acumular as posições dos elementos
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Constrói o array de saída
        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i] - min] - 1] = array[i];
            count[array[i] - min]--;
        }

        // Copia o array de saída para o original
        System.arraycopy(output, 0, array, 0, array.length);
    }

        // Merge Sort para int[]
    public static void mergeSortInt(int[] A) {
        if (A.length < 2) {
            return; // Caso base
        }

        int mid = A.length / 2;
        int[] left = new int[mid]; // Cria array da metade esquerda
        int[] right = new int[A.length - mid]; // Cria array da metade direita

        // Copia os elementos para os arrays left e right
        for (int i = 0; i < mid; i++) {
            left[i] = A[i];
        }
        for (int i = mid; i < A.length; i++) {
            right[i - mid] = A[i];
        }

        mergeSortInt(left); // Ordena a metade esquerda
        mergeSortInt(right); // Ordena a metade direita

        mergeInt(A, left, right); // Mescla as duas metades
    }

    // Função de merge para arrays de inteiros
    private static void mergeInt(int[] A, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                A[k++] = left[i++];
            } else {
                A[k++] = right[j++];
            }
        }
        // Copia os elementos restantes de left, se houver
        while (i < left.length) {
            A[k++] = left[i++];
        }
        // Copia os elementos restantes de right, se houver
        while (j < right.length) {
            A[k++] = right[j++];
        }
    }

    public static <T extends Comparable<T>> void mergeIns(T[] A, int THRESHOLD) {
        if (A.length < 2) {
            return; // Caso base, vetor já está ordenado
        }
        
        // Se o tamanho do vetor for menor que o limite, usamos Insertion Sort
        if (A.length <= THRESHOLD) {
            insertion(A, A.length);  // Chama Insertion Sort
            return;
        }

        int mid = A.length / 2;
        T[] left = (T[]) new Comparable[mid]; // Cria array da metade esquerda
        T[] right = (T[]) new Comparable[A.length - mid]; // Cria array da metade direita

        for (int i = 0; i < mid; i++) {
            left[i] = A[i];
        }
        for (int i = mid; i < A.length; i++) {
            right[i - mid] = A[i];
        }

        mergeIns(left, THRESHOLD); // Ordena a metade esquerda
        mergeIns(right, THRESHOLD); // Ordena a metade direita

        mergeInsArrays(A, left, right); // Mescla as duas metades
    }

    private static <T extends Comparable<T>> void mergeInsArrays(T[] A, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                A[k++] = left[i++];
            } else {
                A[k++] = right[j++];
            }
        }
        while (i < left.length) {
            A[k++] = left[i++];
        }
        while (j < right.length) {
            A[k++] = right[j++];
        }
    }
}
