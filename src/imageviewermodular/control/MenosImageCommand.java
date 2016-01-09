package imageviewermodular.control;

import imageviewermodular.model.Image;
import imageviewermodular.view.ImageDisplay;

public class MenosImageCommand implements Command {

    private final ImageDisplay imageDisplay;

    public MenosImageCommand(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
    }

    @Override
    public void execute() {
        imageDisplay.setEscala(-100);
        imageDisplay.show(imageDisplay.image());
    }

}
