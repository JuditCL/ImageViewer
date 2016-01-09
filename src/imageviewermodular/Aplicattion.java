package imageviewermodular;
/**************************************************/
/*Imageviewer por Judit del Carmen Correa Luciano */
/**************************************************/
import imageviewermodular.control.MenuImageCommand;
import imageviewermodular.control.NextImageCommand;
import imageviewermodular.control.PrevImageCommand;
import imageviewermodular.control.MasImageCommand;
import imageviewermodular.control.MenosImageCommand;
import imageviewermodular.control.Command;
import imageviewermodular.model.Image;
import imageviewermodular.view.ImageDisplay;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Aplicattion extends JFrame implements MouseListener,MouseWheelListener {

    private final Map<String, Command> commands = new HashMap<>();
    private ImageDisplay imageDisplay;
    private File file2;
    private Point ini;
    private Point fin;

    public static void main(String[] args) {
        new Aplicattion().setVisible(true);

    }

    public Aplicattion() {
        this.createChooser();
        this.deployUI();
        this.createCommands();
        this.addMouseListener(this);
        this.addMouseWheelListener(this);
        KeyListener listener = (KeyListener) new MyKeyListener(commands);
	this.addKeyListener(listener);
	this.setFocusable(true);
    }

    private void deployUI() {
        this.setTitle("Image viewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500, 500));
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imagePanel());
        this.getContentPane().add(toolbar(), BorderLayout.SOUTH);
        this.getContentPane().add(new MenuBar().addMenu(), BorderLayout.NORTH);
    }

    private void createCommands() {
        commands.put("menu", new MenuImageCommand());
        commands.put("next", new NextImageCommand(imageDisplay));
        commands.put("prev", new PrevImageCommand(imageDisplay));
        commands.put("mas", new MasImageCommand(imageDisplay));
        commands.put("menos", new MenosImageCommand(imageDisplay));
    }

    private ImagePanel imagePanel() {
        ImagePanel imagePanel = new ImagePanel(image());
        imageDisplay = imagePanel;
        return imagePanel;
    }

    private Image image() {
        return new FileImageReader(file2.getAbsolutePath()).read();
    }

    private Component toolbar() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panel.add(menuButton());
        panel.add(prevButton());
        panel.add(nextButton());
        panel.add(masButton());
        panel.add(menosButton());
        return panel;
    }

    private JButton nextButton() {
        JButton button = new JButton(">");
        button.addActionListener(doCommand("next"));
        return button;
    }

    private JButton prevButton() {
        JButton button = new JButton("<");
        button.addActionListener(doCommand("prev"));
        return button;
    }

    private JButton menuButton() {
        JButton button = new JButton("|||");
        button.addActionListener(doCommand("menu"));
        return button;
    }
    
    private JButton masButton() {
        JButton button = new JButton("+");
        button.addActionListener(doCommand("mas"));
        return button;
    }

    private JButton menosButton() {
        JButton button = new JButton("-");
        button.addActionListener(doCommand("menos"));
        return button;
    }

    
    private ActionListener doCommand(final String operation) {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                commands.get(operation).execute();
            }
        };
    }

    private void createChooser() {
        JFileChooser chooser = new JFileChooser();
        File file = chooser.getCurrentDirectory();
        chooser.setCurrentDirectory(file);
        if ((chooser.showOpenDialog(this)) != JFileChooser.APPROVE_OPTION) {
            return;
        }
        file2 = chooser.getCurrentDirectory();
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        
    }

    @Override
    public void mousePressed(MouseEvent me) {
        ini = me.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        fin = me.getPoint();
        if ((fin.x - ini.x) < 0) {
            commands.get("next").execute();
        } else {
            commands.get("prev").execute();
        }
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mwe) {
        if(mwe.getUnitsToScroll()>0){
            commands.get("menos").execute();
        }else if(mwe.getUnitsToScroll()<0){
            commands.get("mas").execute();
        }
    }

    
}
