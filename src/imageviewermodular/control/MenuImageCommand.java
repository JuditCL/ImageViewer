package imageviewermodular.control;

import imageviewermodular.Aplicattion;

public class MenuImageCommand implements Command{

    @Override
    public void execute() {
        new Aplicattion().setVisible(true);
    }
}
