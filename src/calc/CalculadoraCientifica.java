package calc;

import javax.swing.*;
import java.awt.*;



public class CalculadoraCientifica extends JFrame {

    public CalculadoraCientifica() {
        setTitle("Calculadora Científica");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la ventana correctamente
        setLocationRelativeTo(null); // Centra la ventana en la pantalla

        // Crear el área de pantalla superior
        JLabel pantalla = new JLabel("0", SwingConstants.RIGHT);
        pantalla.setFont(new Font("Arial", Font.BOLD, 25));
        pantalla.setForeground(Color.GREEN);  // Texto verde
        pantalla.setBackground(Color.BLACK);  // Fondo negro
        pantalla.setOpaque(true);  // Hacer visible el fondo negro
        pantalla.setPreferredSize(new Dimension(400, 70));

        // Panel de botones con diseño de cuadrícula
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(6, 4, 5, 5));
        panelBotones.setBackground(Color.BLACK);

        // Definir los botones y añadirlos al panel
        String[] botones = {"sin", "cos", "tan", "log", "7", "8", "9", "÷", "4", "5", "6", "×", "1", "2", "3", "-", "0", ".", "=", "+", "(", ")", "^", "√"};
        for (String texto : botones) {
            JButton boton = new JButton(texto);
            boton.setFont(new Font("Arial", Font.BOLD, 18));
            boton.setForeground(Color.GREEN);  // Texto verde
            boton.setBackground(Color.DARK_GRAY);  // Fondo oscuro
            boton.setFocusPainted(false);  // Sin borde de enfoque
            panelBotones.add(boton);
        }

        // Configuración del layout principal
        setLayout(new BorderLayout());
        add(pantalla, BorderLayout.NORTH);      // Agregar pantalla en la parte superior
        add(panelBotones, BorderLayout.CENTER); // Agregar panel de botones en el centro
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CalculadoraCientifica calculadora = new CalculadoraCientifica();
            calculadora.setVisible(true);
        });
    }
}
