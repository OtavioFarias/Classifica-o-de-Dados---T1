package test;

import sort.Sorting;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import test.SuportArray;
import java.util.ArrayList;
import java.util.List;

public class TimeTestQuick {
    public static void main(String[] args) { 
        // args[0]: quantidade de elementos no array
        // args[1]: quantidade de testes
        // args[2]: tipo de array

        int k = 0; // contador para os testes

        // Listas para armazenar os tempos de cada método
        List<Long> temposQuick = new ArrayList<>();

        // Loop para os testes
        while (k < Integer.parseInt(args[1])) {
            Integer[] arrayTest = SuportArray.arrayInt(Integer.parseInt(args[0]), Integer.parseInt(args[2]));
	
	    long t_ini, t_fim;

            // Quick Sort
            Integer[] arrayQuick = arrayTest.clone();
            t_ini = System.nanoTime();
            Sorting.quickNR(arrayQuick, 0, Integer.parseInt(args[0]) - 1);
            t_fim = System.nanoTime();
            temposQuick.add(t_fim - t_ini);
            

            k++;
        }

        // Nome do arquivo CSV
        String nomeArquivoCSV = "TemposExecucaoQuick" + args[0] + "entradas" + "tipoArray" + args[2] + ".csv";

        // Salvar os dados no arquivo CSV
        try (PrintWriter writer = new PrintWriter(new File(nomeArquivoCSV))) {
            // Cabeçalho
            writer.print("Método de Ordenação");
            for (int i = 0; i < Integer.parseInt(args[1]); i++) {
                writer.print(",Teste " + (i + 1));
            }
            writer.println();

            // Escrever os tempos para cada método
            writer.print("Quick Sort");
            for (Long tempo : temposQuick) writer.print("," + tempo);
            writer.println();

        } catch (FileNotFoundException e) {
            System.err.println("Erro ao criar o arquivo CSV: " + e.getMessage());
        }
    }
}
