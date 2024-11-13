package test;

import java.util.Random;

public class SuportArray {
    public static Integer[] arrayInt(int n, int type) {
        Integer[] array = new Integer[n]; // Inicializa o array com o tamanho n
        Random random = new Random(); // Instancia um gerador de números aleatórios

        switch (type) {
            case 0: // array em ordem crescente
                for (int i = 0; i < n; i++) {
                    array[i] = i; // Preenche com valores de 0 a n-1
                }
                break;

            case 1: // array em ordem decrescente
                for (int i = 0; i < n; i++) {
                    array[i] = n - 1 - i; // Preenche com valores de n-1 a 0
                }
                break;

            case 2: // array com elementos repetidos
                int valorRepetido = random.nextInt(100); // Gera um valor aleatório para repetir
                for (int i = 0; i < n; i++) {
                    array[i] = valorRepetido; // Preenche todo o array com o mesmo valor
                }
                break;

            case 3: // array aleatório
                for (int i = 0; i < n; i++) {
                    array[i] = random.nextInt(n); // Gera números aleatórios de 0 a 99
                }
                break;

            default:
            break;
        }
        
        return array; // Retorna o array gerado
    }

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

    public static int[] arrayRInt(int n, int type) {
        int[] array = new int[n]; // Initialize the array with size n
        Random random = new Random(); // Instantiate a random number generator

        switch (type) {
            case 0: // array in ascending order
                for (int i = 0; i < n; i++) {
                    array[i] = i; // Fill with values from 0 to n-1
                }
                break;

            case 1: // array in descending order
                for (int i = 0; i < n; i++) {
                    array[i] = n - 1 - i; // Fill with values from n-1 to 0
                }
                break;

            case 2: // array with repeated elements
                int valorRepetido = random.nextInt(100); // Generate a random value to repeat
                for (int i = 0; i < n; i++) {
                    array[i] = valorRepetido; // Fill the entire array with the same value
                }
                break;

            case 3: // random array
                for (int i = 0; i < n; i++) {
                    array[i] = random.nextInt(n); // Generate random numbers from 0 to n-1
                }
                break;

            default:
                break;
        }

        return array; // Return the generated array
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


    public static float[] convertToFloatInRange(int[] intArray) {
        // Encontra o valor mínimo e máximo no array de inteiros
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // Determina os valores mínimo e máximo no array
        for (int num : intArray) {
            if (num < min) {
                min = num;
            }
            if (num > max) {
                max = num;
            }
        }

        // Cria o array de floats normalizados
        float[] floatArray = new float[intArray.length];

        // Converte cada inteiro para um valor no intervalo [0, 1]
        for (int i = 0; i < intArray.length; i++) {
            floatArray[i] = (float) (intArray[i] - min) / (max - min);  // Normaliza o valor
        }

        return floatArray;
    }
}

