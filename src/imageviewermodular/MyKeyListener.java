package imageviewermodular;

import imageviewermodular.control.Command;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;
import java.util.Map;

class MyKeyListener implements KeyListener {
    
    private Map<String, Command> commands = new HashMap<>();


    public MyKeyListener(Map<String, Command> commands) {
        this.commands = commands;
    }

    
    

    @Override
    public void keyTyped(KeyEvent ke) {
    }

    @Override
    public void keyPressed(KeyEvent ke) {
        switch (ke.getKeyCode()){
            case 39:
                commands.get("next").execute();
            break;
            case 37:
                commands.get("prev").execute();
            break;
            case 38:
                commands.get("mas").execute();
            break;
            case 40:
                commands.get("menos").execute();
            break;
        }
    }

    @Override
    public void keyReleased(KeyEvent ke) {
    }
    
}
