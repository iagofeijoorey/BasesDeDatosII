package gui;

import javax.swing.*;
import java.awt.*;

public class ImagePanel extends JPanel {

    private Image image;

    public ImagePanel(String imagePath) {
        // Carga la imagen
        ImageIcon imageIcon = new ImageIcon(imagePath);
        this.image = imageIcon.getImage();
        Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));
        setPreferredSize(size);
        setMinimumSize(size);
        setMaximumSize(size);
        setSize(size);
        setLayout(null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibuja la imagen en todo el panel
        g.drawImage(image, 0, 0, null);

    }
}
