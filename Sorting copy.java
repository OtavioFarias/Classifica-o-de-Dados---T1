package sort;

public class Sorting {

    public static <T extends Comparable<T>> void insertion(T[] A, int n){
        for(int i=1; i<n; i++){
            
            T key = A[i];
            int j = i - 1;
            
            while(j>=0 && A[j].compareTo(key) > 0){
            
                A[j+1] = A[j];
                j--;

            }

            A[j+1] = key;
        
        }
    }

}