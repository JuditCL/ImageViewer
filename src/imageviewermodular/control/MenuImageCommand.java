package imageviewermodular.control;
/**************************************************/
/*Imageviewer por Judit del Carmen Correa Luciano */
/**************************************************/
import imageviewermodular.Aplicattion;

public class MenuImageCommand implements Command{

    @Override
    public void execute() {
        new Aplicattion().setVisible(true);
    }
}
