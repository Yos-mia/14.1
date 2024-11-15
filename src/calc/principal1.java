package calc;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class principal1 {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            CalculadoraBasica basica = new CalculadoraBasica();
            basica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            basica.setVisible(true);

            CalculadoraCientifica cientifica = new CalculadoraCientifica();
            cientifica.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            cientifica.setVisible(true);

            CalculadoraCientificaGraficadora graficadora = new CalculadoraCientificaGraficadora();
            graficadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            graficadora.setVisible(true);
        });
    }
}
