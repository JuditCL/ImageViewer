package imageviewermodular;
/**************************************************/
/*Imageviewer por Judit del Carmen Correa Luciano */
/**************************************************/
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuBar extends JMenuBar{
    public MenuBar() {
        
    }
    public JMenuBar addMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        menuBar.add(menu);
        JMenuItem menuItem = new JMenuItem("A cerca de",
                new ImageIcon("signo-de-interrogacion.jpg"));
        ActionListener botonabout = new botonabout();
        menuItem.addActionListener(botonabout);
        menu.add(menuItem);
        menuItem = new JMenuItem("Ayuda",
                new ImageIcon("ayuda.jpg"));
        ActionListener botonhelp = new botonhelp();
        menuItem.addActionListener(botonhelp);
        menu.add(menuItem);
        menuBar.add(menu);
        return menuBar;
    }
    
    class botonabout implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            JOptionPane.showOptionDialog(null, "Este es un visor de imagenes, permite visualizar la imagen de una caerpeta seleccionada y avanzar o retroceder para así navegar por toda la carpeta y ha sido realizado por Judit del Carmen Correa Luciano", "Acerca de MoneyCalculator", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{" OK "}, "OK");
        }
    }
    
    class botonhelp implements ActionListener {

        public botonhelp() {
        }

        @Override
        public void actionPerformed(ActionEvent ae) {
            JOptionPane.showOptionDialog(null, "Después de elegir la carpeta de donde se visualizarán los archivos: \n"
                    + "1º- Puede avanzar o retrocedes usando los botones de la interfaz, clicando y arrastrando la imagen o con los cursores\n"
                    + "2º- Puede aumentar o disminuir la imagen con la rueda del ratón, con los botones de la interfaz o con los cursores \n"
                    + "3º- Puede seleccionar otra carpeta para visualizar dandole a: |||", "Cómo usar", JOptionPane.INFORMATION_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, new Object[]{" OK "}, "OK");
        }
    }
}
