package test;

import sort.Sorting;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import test.SuportArray;
import java.util.ArrayList;
import java.util.List;

public class TimeTest {
    public static void main(String[] args) { 
        // args[0]: quantidade de elementos no array
        // args[1]: quantidade de testes
        // args[2]: tipo de array

        int k = 0; // contador para os testes

        // Listas para armazenar os tempos de cada método
        List<Long> temposInsertion = new ArrayList<>();
        List<Long> temposBubble = new ArrayList<>();
        List<Long> temposSelection = new ArrayList<>();
        List<Long> temposShell = new ArrayList<>();
        List<Long> temposHeap = new ArrayList<>();
        List<Long> temposMerge = new ArrayList<>();
        List<Long> temposQuick = new ArrayList<>();

        // Loop para os testes
        while (k < Integer.parseInt(args[1])) {
            Integer[] arrayTest = SuportArray.arrayInt(Integer.parseInt(args[0]), Integer.parseInt(args[2]));
	
	    long t_ini, t_fim;

            // Insertion Sort
            Integer[] arrayInsertion = arrayTest.clone();
            t_ini = System.nanoTime();
            Sorting.insertion(arrayInsertion, Integer.parseInt(args[0]));
            t_fim = System.nanoTime();
            temposInsertion.add(t_fim - t_ini);

            // Bubble Sort
            Integer[] arrayBubble = arrayTest.clone();
            t_ini = System.nanoTime();
            Sorting.bubble(arrayBubble, Integer.parseInt(args[0]));
            t_fim = System.nanoTime();
            temposBubble.add(t_fim - t_ini);

            // Selection Sort
            Integer[] arraySelection = arrayTest.clone();
            t_ini = System.nanoTime();
            Sorting.selection(arraySelection, Integer.parseInt(args[0]));
            t_fim = System.nanoTime();
            temposSelection.add(t_fim - t_ini);

            // Shell Sort
            Integer[] arrayShell = arrayTest.clone();
            t_ini = System.nanoTime();
            Sorting.shell(arrayShell, Integer.parseInt(args[0]));
            t_fim = System.nanoTime();
            temposShell.add(t_fim - t_ini);

            // Heap Sort
            Integer[] arrayHeap = arrayTest.clone();
            t_ini = System.nanoTime();
            Sorting.heap(arrayHeap, Integer.parseInt(args[0]));
            t_fim = System.nanoTime();
            temposHeap.add(t_fim - t_ini);

            // Merge Sort
            Integer[] arrayMerge = arrayTest.clone();
            t_ini = System.nanoTime();
            Sorting.mergeSort(arrayMerge);
            t_fim = System.nanoTime();
            temposMerge.add(t_fim - t_ini);

            // Quick Sort
            Integer[] arrayQuick = arrayTest.clone();
            t_ini = System.nanoTime();
//            Sorting.quick(arrayQuick, 0, Integer.parseInt(args[0]) - 1);
            t_fim = System.nanoTime();
            temposQuick.add(t_fim - t_ini);
            

            k++;
        }

        // Nome do arquivo CSV
        String nomeArquivoCSV = "TemposExecucao" + args[0] + "entradas" + "tipoArray" + args[2] + ".csv";

        // Salvar os dados no arquivo CSV
        try (PrintWriter writer = new PrintWriter(new File(nomeArquivoCSV))) {
            // Cabeçalho
            writer.print("Método de Ordenação");
            for (int i = 0; i < Integer.parseInt(args[1]); i++) {
                writer.print(",Teste " + (i + 1));
            }
            writer.println();

            // Escrever os tempos para cada método
            writer.print("Insertion Sort");
            for (Long tempo : temposInsertion) writer.print("," + tempo);
            writer.println();

            writer.print("Bubble Sort");
            for (Long tempo : temposBubble) writer.print("," + tempo);
            writer.println();

            writer.print("Selection Sort");
            for (Long tempo : temposSelection) writer.print("," + tempo);
            writer.println();

            writer.print("Shell Sort");
            for (Long tempo : temposShell) writer.print("," + tempo);
            writer.println();

            writer.print("Heap Sort");
            for (Long tempo : temposHeap) writer.print("," + tempo);
            writer.println();

            writer.print("Merge Sort");
            for (Long tempo : temposMerge) writer.print("," + tempo);
            writer.println();

            writer.print("Quick Sort");
            for (Long tempo : temposQuick) writer.print("," + tempo);
            writer.println();

        } catch (FileNotFoundException e) {
            System.err.println("Erro ao criar o arquivo CSV: " + e.getMessage());
        }
    }
}
