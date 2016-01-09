package imageviewermodular;
/**************************************************/
/*Imageviewer por Judit del Carmen Correa Luciano */
/**************************************************/
import imageviewermodular.model.Image;
import imageviewermodular.view.ImageReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FileImageReader implements ImageReader{
    private final File[] files;
    private static final String[] ImageEstensions = {".jpg",".png",".gift"};

    public FileImageReader(String path) {
        this(new File(path));
    }
    
    public FileImageReader(File folder) {
        this.files = folder.listFiles(whithImageExtension());
    }

    
    @Override
    public Image read() {
        return imageAt(0);
        
    }

    private FilenameFilter whithImageExtension() {
        return new FilenameFilter() {
            @Override
            public boolean accept(File file, String name) {
                for (String extension : ImageEstensions) {
                    if(name.endsWith(extension)) return true;
                }
                    return false;
            }
        };
    }

    private Image imageAt(final int index) {
        return new Image() {
            @Override
            public Object bitmap() {
                try {
                    return ImageIO.read(files[index]);
                } catch (IOException ex) {
                    return null; //Devolver un map vacio =)
                }
            };

            @Override
            public Image prev() {
                return imageAt(index > 0 ? index - 1 : files.length-1);
            }

            @Override
            public Image next() {
                return imageAt(index < files.length - 1 ? index + 1 : 0);
            }
        };
    }
    
}
