package test;

import sort.Sorting;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import test.SuportArray;
import java.util.ArrayList;
import java.util.List;

public class TimeTestInt {
    public static void main(String[] args) { 
        // args[0]: quantidade de elementos no array
        // args[1]: quantidade de testes
        // args[2]: tipo de array

        int k = 0; // contador para os testes

        // Listas para armazenar os tempos de cada método
        List<Long> temposMergeInt = new ArrayList<>();

        // Loop para os testes
        while (k < Integer.parseInt(args[1])) {
            int[] arrayTest = SuportArray.arrayRInt(Integer.parseInt(args[0]), Integer.parseInt(args[2]));
	
	    long t_ini, t_fim;

            // Quick Sort
            int[] arrayMergeInt = arrayTest.clone();
            t_ini = System.nanoTime();
            Sorting.mergeSortInt(arrayMergeInt);
            t_fim = System.nanoTime();
            temposMergeInt.add(t_fim - t_ini);
            

            k++;
        }

        // Nome do arquivo CSV
        String nomeArquivoCSV = "TemposExecucaoMergeInt" + args[0] + "entradas" + "tipoArray" + args[2] + ".csv";

        // Salvar os dados no arquivo CSV
        try (PrintWriter writer = new PrintWriter(new File(nomeArquivoCSV))) {
            // Cabeçalho
            writer.print("Método de Ordenação");
            for (int i = 0; i < Integer.parseInt(args[1]); i++) {
                writer.print(",Teste " + (i + 1));
            }
            writer.println();

            // Escrever os tempos para cada método
            writer.print("MergeInt");
            for (Long tempo : temposMergeInt) writer.print("," + tempo);
            writer.println();

        } catch (FileNotFoundException e) {
            System.err.println("Erro ao criar o arquivo CSV: " + e.getMessage());
        }
    }
}
