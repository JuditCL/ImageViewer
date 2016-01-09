/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewermodular;

import imageviewermodular.model.Image;
import imageviewermodular.view.ImageDisplay;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 *
 * @author Universidad
 */
public class ImagePanel extends JPanel implements ImageDisplay{
    private Image image;

    public ImagePanel(Image image) {
        this.image = image;
    }
       
    @Override
    public Image image() {
        return this.image;
    }

    @Override
    public void show(Image image) {
        this.image = image;
        this.repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage((BufferedImage) image.bitmap(), 0, 0,this.getWidth(), this.getHeight(), this.getBackground(), this);
    }

}
