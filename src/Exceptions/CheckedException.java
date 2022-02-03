package Exceptions;

import javax.swing.*;
import java.io.*;

public class CheckedException {
    public static void main(String[] args) { //criando o main
        String nomeDoArquivo = "Harry- Potter.txt"; // criando uma variável String e alimentando com nome do documento

        try {
            imprimirArquivoNoConsole(nomeDoArquivo); // chamando o método imprimirMensagemNoConsole (utilizando nome do documento como parâmentro)
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null,
                    "Revise o nome do Arquivo que deseja imprimir." + e.getCause());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Ocorreu um erro inesperado. Entre em contato com suporte." + e.getCause());
            e.printStackTrace();
        } finally {
            System.out.println("Chegou no finally.");
        }

        System.out.println("Apesar da exception ou não, o programa continua..."); // impriminto msg na tela
    }

    public static void imprimirArquivoNoConsole(String nomeDoArquivo) throws IOException { //criando método imprimirMensagemNoConsole
        File file = new File(nomeDoArquivo);

        BufferedReader br = new BufferedReader(new FileReader(file.getName()));
        String line = br.readLine();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        do {
            bw.write(line);
            bw.newLine();
            line=br.readLine();
        } while (line != null);
        bw.flush();
        br.close();
    }

}
