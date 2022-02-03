package Exceptions;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;

public class UncheckedException {
    public static void main(String[] args) {

        boolean continueLooping = true;
        do {

            String a = JOptionPane.showInputDialog("Numerador: ");
            String b = JOptionPane.showInputDialog("Denominador");

            try {
                int resultado = dividir(Integer.parseInt(a), Integer.parseInt(b));
                System.out.println("Resultado: " + resultado);
                continueLooping = false;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada Invalida. Informe um número inteiro." + e.getMessage());
                e.printStackTrace();
            } catch (ArithmeticException e) {
                JOptionPane.showMessageDialog(null, "Impossivel dividir por zero." + e.getMessage());
                e.printStackTrace();
            } finally {
                System.out.println("Chegou no Finally.");
            }

        } while (continueLooping);


        System.out.println("Chegou até aqui!");
    }

    public static int dividir (int a, int b) { return a / b; }


}
