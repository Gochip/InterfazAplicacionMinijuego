package principal;

import common.Action;
import common.ActionCommunication;
import controller.ApplicationController;

/**
 *
 * @author Parisi Germán
 */
public class MouseMove {
    private ApplicationController controlador;
    private ActionCommunication com;
    public MouseMove(ApplicationController controlador){
        this.controlador = controlador;
        this.com = this.controlador.getCommunication();
        
        
    }
    
    public void start(){
        Action action = new Action("Posicion");
        action.addValue("x", "200");
        action.addValue("y", "400");
        
        this.com.sendActionToAll(action);
    }
}
