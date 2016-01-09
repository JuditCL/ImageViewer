/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewermodular.view;

import imageviewermodular.model.Image;

/**
 *
 * @author Universidad
 */
public interface ImageDisplay {
    public Image image();
    public void show(Image image);
    public void setEscala(int escala);
}
