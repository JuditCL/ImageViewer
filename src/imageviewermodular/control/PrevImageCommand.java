/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewermodular.control;

import imageviewermodular.view.ImageDisplay;

/**
 *
 * @author Universidad
 */
public class PrevImageCommand implements Command{
    private final ImageDisplay imageDisplay;

    public PrevImageCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }

    @Override
    public void execute() {
        imageDisplay.show(imageDisplay.image().prev());
    }
    
}