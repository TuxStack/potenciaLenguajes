package potencia_de_lenguajes.gui;

import potencia_de_lenguajes.model.GeneradorDePotencias;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTextField campoLenguaje;
    private JTextField campoPotencia;

    // Constructor de la clase
    public VentanaPrincipal() {
        setTitle("Generador de potencias de lenguajes");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Título superior
        JPanel panelTitulo = new JPanel();
        panelTitulo.setLayout(new BorderLayout());
        JLabel etiquetaTitulo = new JLabel("<html><div style='text-align: center;'>José Enrique González Sánchez<br/>Teoría de autómatas</div></html>", JLabel.CENTER);
        etiquetaTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        panelTitulo.add(etiquetaTitulo, BorderLayout.CENTER);
        add(panelTitulo, BorderLayout.NORTH);

        // Creación de botones
        JButton botonCalcular = new JButton("Calcular");
        JButton botonLimpiar = new JButton("Limpiar");
        JButton botonInstrucciones = new JButton("Instrucciones"); 

        // Panel de botones
        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 0));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panelBotones.add(botonCalcular);
        panelBotones.add(botonLimpiar);
        panelBotones.add(botonInstrucciones);

        add(panelBotones, BorderLayout.SOUTH);

        // Panel de entradas y resultados
        JPanel panelEntradas = new JPanel();
        panelEntradas.setLayout(new BorderLayout(10, 10));
        panelEntradas.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Panel para las etiquetas y campos de texto
        JPanel panelEtiquetas = new JPanel(new GridLayout(2, 1, 10, 10));
        JPanel panelCampos = new JPanel(new GridLayout(2, 1, 10, 10));

        // Etiquetas y campos de texto
        JLabel etiquetaLenguaje = new JLabel("Lenguaje:");
        campoLenguaje = new JTextField();
        campoLenguaje.setHorizontalAlignment(JTextField.CENTER);

        JLabel etiquetaPotencia = new JLabel("Potencia:");
        campoPotencia = new JTextField();
        campoPotencia.setHorizontalAlignment(JTextField.CENTER);

        // Añadir componentes a los paneles de etiquetas y campos
        panelEtiquetas.add(etiquetaLenguaje);
        panelEtiquetas.add(etiquetaPotencia);

        panelCampos.add(campoLenguaje);
        panelCampos.add(campoPotencia);

        // Añadir los paneles de etiquetas y campos al panel de entradas
        panelEntradas.add(panelEtiquetas, BorderLayout.WEST);
        panelEntradas.add(panelCampos, BorderLayout.CENTER);

        add(panelEntradas, BorderLayout.CENTER);

        // Eventos de los botones
        botonCalcular.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener el lenguaje y la potencia ingresados por el usuario
                String[] lenguaje = campoLenguaje.getText().split(",\\s*");
                int potenciaMaxima;
                try {
                    potenciaMaxima = Integer.parseInt(campoPotencia.getText());
                    // Llamar al método que genera las potencias
                    GeneradorDePotencias.generarPotencias(lenguaje, potenciaMaxima);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(VentanaPrincipal.this, "Por favor, ingrese un número válido para la potencia.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        botonLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                campoLenguaje.setText("");
                campoPotencia.setText("");
            }
        });
        
        botonInstrucciones.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mostrar un cuadro de diálogo con las instrucciones
                JOptionPane.showMessageDialog(VentanaPrincipal.this,
                        "Ingrese el lenguaje (separando cada elemento con comas) y la potencia deseada.\n" +
                        "Luego presione 'Calcular' para obtener el resultado.\n" +
                        "Presione 'Limpiar' para resetear los campos.",
                        "Instrucciones",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
        this.setResizable(false);
        setVisible(true);
    }
}




