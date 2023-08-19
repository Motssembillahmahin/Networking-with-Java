package lab;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;
public class ImageDisplayer {
    public static void main(String[] args) {
        // Create a JFrame to display the images in.
        JFrame frame = new JFrame("Image Displayer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create a JPanel to hold the images.
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        // Load the images.
        BufferedImage image1 = loadImage("C:\\Users\\Mahin\\Python\\Image Lab\\image_1.jpeg");
        BufferedImage image2 = loadImage("C:\\Users\\Mahin\\Python\\Image Lab\\image_2.jpeg");
        BufferedImage image3 = loadImage("C:\\Users\\Mahin\\Python\\Image Lab\\image_3.jpeg");
        // Add the images to the panel.
        panel.add(new JLabel(new ImageIcon(image1)));
        panel.add(new JLabel(new ImageIcon(image2)));
        panel.add(new JLabel(new ImageIcon(image3)));
        // Add the panel to the frame.
        frame.add(panel);
        // Pack the frame and make it visible.
        frame.pack();
        frame.setVisible(true);
    }
    private static BufferedImage loadImage(String filename) {
        try {
            return ImageIO.read(new File(filename));
            
        } catch (IOException e) {
            System.err.println("Error loading image: " + filename);
            e.printStackTrace();
            return null;
        }
    }
}