package calc;


import javax.swing.*;
import java.awt.*;

public class CalculadoraCientificaGraficadora extends JFrame {

    public CalculadoraCientificaGraficadora() {
        setTitle("Calculadora Científica Graficadora");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel para el plano cartesiano (en la parte superior)
        JPanel panelGrafico = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLACK);
                int width = getWidth();
                int height = getHeight();

                // Dibuja los ejes
                g.drawLine(width / 2, 0, width / 2, height); // Eje Y
                g.drawLine(0, height / 2, width, height / 2); // Eje X

                // Etiquetas de los ejes
                g.drawString("X", width - 10, height / 2 - 10);
                g.drawString("Y", width / 2 + 10, 10);

                // Dibuja la cuadrícula
                g.setColor(Color.LIGHT_GRAY);
                for (int i = 1; i < width / 2; i += 20) {
                    g.drawLine(width / 2 + i, 0, width / 2 + i, height); // Líneas verticales
                    g.drawLine(width / 2 - i, 0, width / 2 - i, height); // Líneas verticales
                }
                for (int i = 1; i < height / 2; i += 20) {
                    g.drawLine(0, height / 2 + i, width, height / 2 + i); // Líneas horizontales
                    g.drawLine(0, height / 2 - i, width, height / 2 - i); // Líneas horizontales
                }

                // Dibujar marcas y números en los ejes X e Y
                g.setColor(Color.BLACK);
                for (int i = 1; i <= 10; i++) {
                    g.drawString(Integer.toString(i), width / 2 + i * 20, height / 2 + 15); // Marcas X positivas
                    g.drawString(Integer.toString(-i), width / 2 - i * 20, height / 2 + 15); // Marcas X negativas
                    g.drawString(Integer.toString(i), width / 2 + 5, height / 2 - i * 20); // Marcas Y positivas
                    g.drawString(Integer.toString(-i), width / 2 + 5, height / 2 + i * 20); // Marcas Y negativas
                }

                // Dibuja una figura (círculo centrado en el origen)
                g.setColor(Color.RED);
                int radius = 40; // Radio del círculo
                g.drawOval(width / 2 - radius, height / 2 - radius, radius * 2, radius * 2);

                // Muestra los puntos clave de la figura en la esquina superior izquierda
                g.setColor(Color.BLACK);
                String[] puntos = {
                    "Puntos del círculo:",
                    "(0, " + (-radius) + ")",
                    "(" + radius + ", 0)",
                    "(0, " + radius + ")",
                    "(" + (-radius) + ", 0)"
                };

                int xOffset = 10; // Margen desde la esquina
                int yOffset = 20; // Espaciado entre líneas
                for (int i = 0; i < puntos.length; i++) {
                    g.drawString(puntos[i], xOffset, yOffset + i * 15);
                }
            }
        };
        panelGrafico.setPreferredSize(new Dimension(400, 200));
        
        // Panel para los botones de la calculadora (en la parte inferior)
        JPanel panelCalculadora = new JPanel();
        panelCalculadora.setLayout(new GridLayout(6, 4, 5, 5));

        // Botones de la calculadora
        String[] botones = {"sin", "cos", "tan", "log", "7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+", "(", ")", "^", "sqrt"};
        for (String texto : botones) {
            JButton boton = new JButton(texto);
            boton.setFont(new Font("Arial", Font.PLAIN, 15));
            panelCalculadora.add(boton);
        }

        // Agregar el panel gráfico en la parte superior y el panel de calculadora en la parte inferior
        add(panelGrafico, BorderLayout.NORTH);
        add(panelCalculadora, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CalculadoraCientificaGraficadora().setVisible(true);
        });
    }
}
