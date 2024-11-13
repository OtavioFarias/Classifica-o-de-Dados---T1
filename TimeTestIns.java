package test;

import sort.Sorting;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import test.SuportArray;
import java.util.ArrayList;
import java.util.List;

public class TimeTestIns {
    public static void main(String[] args) { 
        // args[0]: quantidade de elementos no array
        // args[1]: quantidade de testes
        // args[2]: tipo de array
        // args[3]: quanado chamar o insertion

        int k = 0; // contador para os testes

        // Listas para armazenar os tempos de cada método
        List<Long> temposMerge = new ArrayList<>();

        // Loop para os testes
        while (k < Integer.parseInt(args[1])) {
            Integer[] arrayTest = SuportArray.arrayInt(Integer.parseInt(args[0]), Integer.parseInt(args[2]));
	
	    long t_ini, t_fim;

            // Quick Sort
            Integer[] arrayMerge = arrayTest.clone();
            t_ini = System.nanoTime();
            Sorting.mergeIns(arrayMerge, Integer.parseInt(args[3]));
            t_fim = System.nanoTime();
            temposMerge.add(t_fim - t_ini);
            

            k++;
        }

        // Nome do arquivo CSV
        String nomeArquivoCSV = "TemposExecucaoMergeIns" + args[0] + "entradas" + "tipoArray" + args[2] + "chamado" + args[3] + ".csv";

        // Salvar os dados no arquivo CSV
        try (PrintWriter writer = new PrintWriter(new File(nomeArquivoCSV))) {
            // Cabeçalho
            writer.print("Método de Ordenação");
            for (int i = 0; i < Integer.parseInt(args[1]); i++) {
                writer.print(",Teste " + (i + 1));
            }
            writer.println();

            // Escrever os tempos para cada método
            writer.print("MergeIns");
            for (Long tempo : temposMerge) writer.print("," + tempo);
            writer.println();

        } catch (FileNotFoundException e) {
            System.err.println("Erro ao criar o arquivo CSV: " + e.getMessage());
        }
    }
}
