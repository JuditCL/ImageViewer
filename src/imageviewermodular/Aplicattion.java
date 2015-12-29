/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewermodular;

import imageviewermodular.control.Command;
import imageviewermodular.control.MenuImageCommand;
import imageviewermodular.control.NextImageCommand;
import imageviewermodular.control.PrevImageCommand;
import imageviewermodular.model.Image;
import imageviewermodular.view.ImageDisplay;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Universidad
 */
public class Aplicattion extends JFrame{

    private final Map<String,Command> commands = new HashMap<>();
    private ImageDisplay imageDisplay;
    private File file2;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Aplicattion().setVisible(true);
        
    }

    public Aplicattion() {
        this.createChooser();
        this.deployUI();
        this.createCommands();
    }

    private void deployUI() {
        this.setTitle("Image viewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setMinimumSize(new Dimension(500,500));
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imagePanel());
        this.getContentPane().add(toolbar(),BorderLayout.SOUTH);
    }

    private void createCommands() {
        commands.put("menu", new MenuImageCommand());
        commands.put("next", new NextImageCommand(imageDisplay));
        commands.put("prev", new PrevImageCommand(imageDisplay));
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
        if ((chooser.showOpenDialog(this))!=JFileChooser.APPROVE_OPTION) return;
        file2 = chooser.getCurrentDirectory();
        //this.setText(file2.getName());
    }

}
