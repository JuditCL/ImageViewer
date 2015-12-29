/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageviewermodular.control;

import imageviewermodular.Aplicattion;

/**
 *
 * @author Universidad
 */
public class MenuImageCommand implements Command{

    @Override
    public void execute() {
        new Aplicattion().setVisible(true);
    }
}
