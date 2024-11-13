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
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (A[j].compareTo(A[min]) < 0) {
                    min = j;
                }
            }
            T temp = A[i];
            A[i] = A[min];
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
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(A, n, i);
        }
        
        for (int i = n - 1; i > 0; i--) {
            T temp = A[0];
            A[0] = A[i];
            A[i] = temp;

            heapify(A, i, 0);
        }
    }

    private static <T extends Comparable<T>> void heapify(T[] A, int n, int i) {
        int largest = i; 
        int left = 2 * i + 1; 
        int right = 2 * i + 2; 

        if (left < n && A[left].compareTo(A[largest]) > 0) {
            largest = left;
        }

        if (right < n && A[right].compareTo(A[largest]) > 0) {
            largest = right;
        }

        if (largest != i) {
            T swap = A[i];
            A[i] = A[largest];
            A[largest] = swap;

            heapify(A, n, largest);
        }
    }

    // Merge Sort
    public static <T extends Comparable<T>> void mergeSort(T[] A) {
        if (A.length < 2) {
            return; 
        }

        int mid = A.length / 2;
        T[] left = (T[]) new Comparable[mid];
        T[] right = (T[]) new Comparable[A.length - mid]; 

        for (int i = 0; i < mid; i++) {
            left[i] = A[i];
        }
        for (int i = mid; i < A.length; i++) {
            right[i - mid] = A[i];
        }

        mergeSort(left);
        mergeSort(right); 
        merge(A, left, right); 
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
            int pi = partition(A, low, high);

            quick(A, low, pi - 1);
            quick(A, pi + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] A, int low, int high) {
        T pivot = A[high]; 
        int i = (low - 1); 

        for (int j = low; j < high; j++) {
            if (A[j].compareTo(pivot) <= 0) {
                i++;
                
                T temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            }
        }

        T temp = A[i + 1];
        A[i + 1] = A[high];
        A[high] = temp;

        return i + 1;
    }

    public static <T extends Comparable<T>> void quickNR(T[] A, int low, int high) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] { low, high });

        while (!stack.isEmpty()) {
            int[] range = stack.pop();
            low = range[0];
            high = range[1];

            if (low < high) {
                int pi = partition(A, low, high);

                if (pi - 1 > low) {
                    stack.push(new int[] { low, pi - 1 });
                }

                if (pi + 1 < high) {
                    stack.push(new int[] { pi + 1, high });
                }
            }
        }
    }



    // Radix Sort
    public static void radix(int[] array) {
        int max = Arrays.stream(array).max().getAsInt(); 
        
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(array, exp);
        }
    }

    //CoutingSort -> RadixSort    
    private static void countingSortByDigit(int[] array, int exp) {
        int n = array.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            int digit = (array[i] / exp) % 10;
            count[digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (array[i] / exp) % 10;
            output[count[digit] - 1] = array[i];
            count[digit]--;
        }

        System.arraycopy(output, 0, array, 0, n);
    }

    // Bucket Sort
    public static void bucket(float[] array) {
        int n = array.length;
        if (n <= 0) return;
    
        ArrayList<Float>[] buckets = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            buckets[i] = new ArrayList<>();
        }
      
        for (float value : array) {
            int bucketIndex = Math.min((int) (value * n), n - 1);
            buckets[bucketIndex].add(value);
        }
        
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

       
        for (int i : array) {
            count[i - min]++;
        }

       
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

       
        for (int i = array.length - 1; i >= 0; i--) {
            output[count[array[i] - min] - 1] = array[i];
            count[array[i] - min]--;
        }

        System.arraycopy(output, 0, array, 0, array.length);
    }

    
    // Merge Sort para int[]
    public static void mergeSortInt(int[] A) {
        if (A.length < 2) {
            return; 
        }

        int mid = A.length / 2;
        int[] left = new int[mid];
        int[] right = new int[A.length - mid]; 

        for (int i = 0; i < mid; i++) {
            left[i] = A[i];
        }
        for (int i = mid; i < A.length; i++) {
            right[i - mid] = A[i];
        }

        mergeSortInt(left);
        mergeSortInt(right); 
        mergeInt(A, left, right); 
    }

    //Função de merge para arrays de inteiros
    private static void mergeInt(int[] A, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
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

    //MergSort com InsertionSort
    public static <T extends Comparable<T>> void mergeIns(T[] A, int n) {
        if (A.length < 2) {
            return; 
        }
        
       
        if (A.length <= n) {
            insertion(A, A.length);  
            return;
        }

        int mid = A.length / 2;
        T[] left = (T[]) new Comparable[mid]; 
        T[] right = (T[]) new Comparable[A.length - mid]; 

        for (int i = 0; i < mid; i++) {
            left[i] = A[i];
        }
        for (int i = mid; i < A.length; i++) {
            right[i - mid] = A[i];
        }

        mergeIns(left, n); 
        mergeIns(right, n); 
        mergeInsArrays(A, left, right); 
    }

}
