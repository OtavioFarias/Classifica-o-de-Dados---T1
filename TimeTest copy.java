package test;
import sort.Sorting;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import test.CriaArray;

public class TimeTest {
    public static void main(String[] args) { // arg[0] quantidade de elementos no array de test arg[1] quantidade de testes args[2] tipo de array

        int k = 0; // quantidade de teste
       
        String nomePasta1 = "Tamanho" + args[0];

        File folder1 = new File(nomePasta1);
        folder1.mkdir();
        
        
        while(k < Integer.parseInt(args[1])){
            Integer [] arrayTest = CriaArray.arrayInt(Integer.parseInt(args[0]), Integer.parseInt(args[2]));

            ///////////////////////////////////
            Integer [] arrayInsertion = arrayTest;
            long t_ini = System.nanoTime();

            Sorting.insertion(arrayInsertion, Integer.parseInt(args[0]) - 1);

            long t_fim = System.nanoTime();
            long tempoTotalInsertion = t_fim - t_ini;
            System.out.printf("\nInsertion Sort: %d nanossegundos\n", tempoTotalInsertion);
            ///////////////////////////////////

            ///////////////////////////////////
            Integer [] arrayBubble = arrayTest;
            t_ini = System.nanoTime();

            Sorting.bubble(arrayBubble, Integer.parseInt(args[0]) - 1);

            t_fim = System.nanoTime();
            long tempoTotalBubble = t_fim - t_ini;
            System.out.printf("\nBubble Sort: %d nanossegundos\n", tempoTotalBubble);
            ///////////////////////////////////
        
            ///////////////////////////////////
            Integer [] arraySelection = arrayTest;
            t_ini = System.nanoTime();

            Sorting.selection(arraySelection, Integer.parseInt(args[0]) - 1);

            t_fim = System.nanoTime();
            long tempoTotalSelection = t_fim - t_ini;
            System.out.printf("\nSelection Sort: %d nanossegundos\n", tempoTotalSelection);
            ///////////////////////////////////
            
            ///////////////////////////////////
            Integer [] arrayShell = arrayTest;
            t_ini = System.nanoTime();

            Sorting.shell(arrayShell, Integer.parseInt(args[0]) - 1);

            t_fim = System.nanoTime();
            long tempoTotalShell = t_fim - t_ini;
            System.out.printf("\nShell Sort: %d nanossegundos\n", tempoTotalShell);
            /////////////////////////////////// 
            
            ///////////////////////////////////
            Integer [] arrayHeap = arrayTest;
            t_ini = System.nanoTime();

            Sorting.heap(arrayHeap, Integer.parseInt(args[0]) - 1);

            t_fim = System.nanoTime();
            long tempoTotalHeap = t_fim - t_ini;
            System.out.printf("\nHeap sort: %d nanossegundos\n", tempoTotalHeap);
            ///////////////////////////////////  

            ///////////////////////////////////
            Integer [] arrayMerge = arrayTest;
            t_ini = System.nanoTime();

            Sorting.mergeSort(arrayMerge);

            t_fim = System.nanoTime();
            long tempoTotalMerge = t_fim - t_ini;
            System.out.printf("\nMerge Sort: %d nanossegundos\n", tempoTotalMerge);
            ///////////////////////////////////  

            ///////////////////////////////////
            Integer [] arrayQuick = arrayTest;
            t_ini = System.nanoTime();

            Sorting.quick(arrayQuick, 0, Integer.parseInt(args[0]) - 1);

            t_fim = System.nanoTime();
            long tempoTotalQuick = t_fim - t_ini;
            System.out.printf("\nQuick Sort: %d nanossegundos\n", tempoTotalQuick);
            ///////////////////////////////////  
            
            String nomePasta = folder1 + File.separator + "Tempo" + k;

            File folder = new File(nomePasta);
            folder.mkdir();

            String nomeArquivo = folder + File.separator + "TipoArray" + t +"TemposExecucaoTamanhoDoArray" + args[0] + "Teste" + k + ".txt";

            try (PrintWriter writer = new PrintWriter(new File(nomeArquivo))) {

                writer.println("Insertion Sort: " +  tempoTotalInsertion + " nanossegundos");
                writer.println("Bubble Sort: " +  tempoTotalBubble + " nanossegundos");
                writer.println("Selection Sort: " +  tempoTotalSelection + " nanossegundos");
                writer.println("Shell Sort: " +  tempoTotalShell + " nanossegundos");
                writer.println("Heap Sort: " +  tempoTotalHeap + " nanossegundos");
                writer.println("Merge Sort: " +  tempoTotalMerge + " nanossegundos");
                writer.println("Quick Sort: " +  tempoTotalQuick + " nanossegundos");
                
            } catch (FileNotFoundException e) {
                System.err.println("Erro ao criar o arquivo: " + e.getMessage());
            }

            k++;
        }
    k = 0;
    }
}


