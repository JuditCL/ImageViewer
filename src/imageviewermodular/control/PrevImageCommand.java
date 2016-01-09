package imageviewermodular.control;
/**************************************************/
/*Imageviewer por Judit del Carmen Correa Luciano */
/**************************************************/
import imageviewermodular.view.ImageDisplay;

public class PrevImageCommand implements Command{
    private final ImageDisplay imageDisplay;

    public PrevImageCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }

    @Override
    public void execute() {
        imageDisplay.setEscala(0);
        imageDisplay.show(imageDisplay.image().prev());
    }
    
}
