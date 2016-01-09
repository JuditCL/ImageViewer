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
public class ImagePanel extends JPanel implements ImageDisplay {

    private Image image;
    private int escala;

    public ImagePanel(Image image) {
        this.image = image;
        escala = 0;
    }

    @Override
    public void setEscala(int escala) {
        if(escala == 0){
            this.escala = 0;
        }else{
           this.escala = this.escala + escala; 
        }
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
    public void paintComponent(Graphics g) {
        if (this.getWidth() + escala >= 500 && this.getHeight() + escala >= 500) {
            g.drawImage((BufferedImage) image.bitmap(), 0, 0, this.getWidth() + escala, this.getHeight() + escala, this.getBackground(), this);
        } else {
            g.drawImage((BufferedImage) image.bitmap(), 0, 0, 500, 500, this.getBackground(), this);
        }
    }

}
