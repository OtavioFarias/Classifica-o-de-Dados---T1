package test;

import java.util.Random;

public class SuportArray {
    //Criar diferentes tipos de array, type: 0-Crescente, 1-Decrescente, 2-Elementos Iguais, 3-Desordenados
    public static Integer[] arrayInt(int n, int type) {
        Integer[] array = new Integer[n]; 
        Random random = new Random(); /

        switch (type) {
            case 0: 
                for (int i = 0; i < n; i++) {
                    array[i] = i;
                }
                break;

            case 1: 
                for (int i = 0; i < n; i++) {
                    array[i] = n - 1 - i; 
                }
                break;

            case 2: 
                int valorRepetido = random.nextInt(100); 
                for (int i = 0; i < n; i++) {
                    array[i] = valorRepetido; 
                }
                break;

            case 3: // array aleatório
                for (int i = 0; i < n; i++) {
                    array[i] = random.nextInt(n); 
                }
                break;

            default:
            break;
        }
        
        return array;

    //Mostra todo o array
    public static void mostrarArray(Integer[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

     //Criar diferentes tipos de array(int), type: 0-Crescente, 1-Decrescente, 2-Elementos Iguais, 3-Desordenados
    public static int[] arrayRInt(int n, int type) {
        int[] array = new int[n]; 
        Random random = new Random(); 

        switch (type) {
            case 0: 
                for (int i = 0; i < n; i++) {
                    array[i] = i; 
                }
                break;

            case 1:
                for (int i = 0; i < n; i++) {
                    array[i] = n - 1 - i; 
                }
                break;

            case 2: 
                int valorRepetido = random.nextInt(100); 
                for (int i = 0; i < n; i++) {
                    array[i] = valorRepetido;
                }
                break;

            case 3: // random array
                for (int i = 0; i < n; i++) {
                    array[i] = random.nextInt(n); 
                }
                break;

            default:
                break;
        }

        return array; 
    }

      public static void mostrarRArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }


    //Converte array de Int para um equivalente em Flot, utilizado para testes do BucketSort
    public static float[] convertToFloatInRange(int[] intArray) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

   
        for (int num : intArray) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        float[] floatArray = new float[intArray.length];

        for (int i = 0; i < intArray.length; i++) {
            floatArray[i] = (float) (intArray[i] - min) / (max - min);  
        }

        return floatArray;
    }
}

