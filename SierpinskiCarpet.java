import java.awt.*;
import javax.swing.*;

public class SierpinskiCarpet extends JPanel {
    private final int dim = 513;  // Dimensión total
    private final int margin = 20;  // Margen del dibujo

    public SierpinskiCarpet() {
        setPreferredSize(new Dimension(dim + 2 * margin, dim + 2 * margin));
        setBackground(Color.white);  // Fondo| blanco
        setForeground(Color.black);  // Color de dibujo negro
    }

    // Método recursivo para dibujar el tapete
    void paint(Graphics2D g, int x, int y, int size) {
        if (size < 3)  // Condición de terminación para recursividad
            return;

        size /= 3;  // Dividimos el tamaño en 3 partes
        for (int i = 0; i < 9; i++) {
            if (i == 4) {
                // Rellenar el cuadrado del centro
                g.fillRect(x + size, y + size, size, size);
            } else {
                // Llamada recursiva para los 8 cuadrados que faltan
                paint(g, x + (i % 3) * size, y + (i / 3) * size, size);
            }
        }
    }

    @Override
    public void paintComponent(Graphics gg) {
        super.paintComponent(gg);
        Graphics2D g = (Graphics2D) gg;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);  
        g.translate(margin, margin);  
        paint(g, 0, 0, dim);  // Llamada inicial para dibujar el tapete
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame();
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setResizable(false);
            f.add(new SierpinskiCarpet(), BorderLayout.CENTER);
            f.pack();  
            f.setLocationRelativeTo(null);  
            f.setVisible(true);  
        });
    }
}
