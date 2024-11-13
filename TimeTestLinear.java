package test;

import sort.Sorting;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import test.SuportArray;
import java.util.ArrayList;
import java.util.List;

public class TimeTestLinear {
    public static void main(String[] args) { 
        // args[0]: quantidade de elementos no array
        // args[1]: quantidade de testes
        // args[2]: tipo de array

        int k = 0; // contador para os testes

        List<Long> temposCounting = new ArrayList<>();
        List<Long> temposRadix = new ArrayList<>();
        List<Long> temposBucket = new ArrayList<>();

        while (k < Integer.parseInt(args[1])) {
            int[] arrayTest = SuportArray.arrayRInt(Integer.parseInt(args[0]), Integer.parseInt(args[2]));
            float[] arrayBucket =  SuportArray.convertToFloatInRange(arrayTest);
            
	    long t_ini, t_fim;

            // Couting Sort
            int[] arrayCounting = arrayTest.clone();
            t_ini = System.nanoTime();
            Sorting.counting(arrayCounting);
            t_fim = System.nanoTime();
            temposCounting.add(t_fim - t_ini);

            // Radix Sort
            int[] arrayRadix = arrayTest.clone();
            t_ini = System.nanoTime();
            Sorting.radix(arrayRadix);
            t_fim = System.nanoTime();
            temposRadix.add(t_fim - t_ini);

            // Selection Bucket
            t_ini = System.nanoTime();
            Sorting.bucket(arrayBucket);
            t_fim = System.nanoTime();
            temposBucket.add(t_fim - t_ini);


            k++;
        }

       
        String nomeArquivoCSV = "TemposExecucaoLinear" + args[0] + "entradas" + "tipoArray" + args[2] + ".csv";

	
        try (PrintWriter writer = new PrintWriter(new File(nomeArquivoCSV))) {
           
            writer.print("Método de Ordenação");
            for (int i = 0; i < Integer.parseInt(args[1]); i++) {
                writer.print(",Teste " + (i + 1));
            }
            writer.println();

           
            writer.print("Counting Sort");
            for (Long tempo : temposCounting) writer.print("," + tempo);
            writer.println();

            writer.print("Radix Sort");
            for (Long tempo : temposRadix) writer.print("," + tempo);
            writer.println();

            writer.print("Bucket Sort");
            for (Long tempo : temposBucket) writer.print("," + tempo);
            writer.println();

        } catch (FileNotFoundException e) {
            System.err.println("Erro ao criar o arquivo CSV: " + e.getMessage());
        }
    }
}
