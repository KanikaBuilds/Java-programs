import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class PixelSketch extends JFrame {
    private DrawArea drawArea;
    private JButton colorButton, clearButton, saveButton;
    private Color currentColor = Color.BLACK;

    public PixelSketch() {
        setTitle("PixelSketch - Drawing App");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Drawing area
        drawArea = new DrawArea();
        add(drawArea, BorderLayout.CENTER);

        // Control buttons
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        panel.setBackground(new Color(230, 230, 230));

        colorButton = new JButton("Choose Color");
        clearButton = new JButton("Clear");
        saveButton = new JButton("Save Drawing");

        panel.add(colorButton);
        panel.add(clearButton);
        panel.add(saveButton);

        add(panel, BorderLayout.SOUTH);

        // Button Actions
        colorButton.addActionListener(e -> chooseColor());
        clearButton.addActionListener(e -> drawArea.clear());
        saveButton.addActionListener(e -> drawArea.saveImage());

        setVisible(true);
    }

    private void chooseColor() {
        Color chosen = JColorChooser.showDialog(this, "Select Brush Color", currentColor);
        if (chosen != null) {
            currentColor = chosen;
            drawArea.setBrushColor(chosen);
        }
    }

    // Inner class for drawing
    private class DrawArea extends JPanel implements MouseListener, MouseMotionListener {
        private BufferedImage canvas;
        private Graphics2D g2d;
        private int prevX, prevY;

        public DrawArea() {
            setDoubleBuffered(false);
            addMouseListener(this);
            addMouseMotionListener(this);
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (canvas == null) {
                canvas = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
                g2d = canvas.createGraphics();
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setPaint(Color.WHITE);
                g2d.fillRect(0, 0, getWidth(), getHeight());
                g2d.setPaint(currentColor);
            }
            g.drawImage(canvas, 0, 0, null);
        }

        public void setBrushColor(Color c) {
            g2d.setPaint(c);
        }

        public void clear() {
            g2d.setPaint(Color.WHITE);
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g2d.setPaint(currentColor);
            repaint();
        }

        public void saveImage() {
            try {
                File file = new File("PixelSketch_Drawing.png");
                ImageIO.write(canvas, "png", file);
                JOptionPane.showMessageDialog(this, "Drawing saved as: " + file.getAbsolutePath());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Error saving image!");
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
            prevX = e.getX();
            prevY = e.getY();
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            g2d.drawLine(prevX, prevY, x, y);
            repaint();
            prevX = x;
            prevY = y;
        }

        @Override
        public void mouseReleased(MouseEvent e) {}
        @Override
        public void mouseClicked(MouseEvent e) {}
        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}
        @Override
        public void mouseMoved(MouseEvent e) {}
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PixelSketch());
    }
}
