package imageviewermodular.view;
/**************************************************/
/*Imageviewer por Judit del Carmen Correa Luciano */
/**************************************************/
import imageviewermodular.model.Image;

public interface ImageDisplay {
    public Image image();
    public void show(Image image);
    public void setEscala(int escala);
}
