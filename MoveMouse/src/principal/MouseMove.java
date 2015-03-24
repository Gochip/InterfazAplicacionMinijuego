package principal;

import com.client.listener.MessageListener;
import common.Action;
import common.ActionCommunication;
import common.Player;
import controller.ApplicationController;
import executors.response.MessageResponse;

/**
 *
 * @author Parisi Germán
 */
public class MouseMove {

    private ApplicationController controlador;
    private ActionCommunication com;

    public MouseMove(ApplicationController controlador) {
        this.controlador = controlador;
        this.com = this.controlador.getCommunication();

        this.com.getClient().addEventListener(new MessageListener() {

            @Override
            public void messageReceived(MessageResponse response) {
                Action action = Action.getAction(response);
                if (action.getName().equals("Posicion")) {
                    System.out.println(response.getId());
                    
                    Player player = controlador.getPlayerById(response.getId());
                    
                    System.out.println("El jugador " + player.getName() + " (" + player.getId() + ")");
                    System.out.println("x: " + action.getValue("x"));
                    System.out.println("y: " + action.getValue("y"));
                    System.out.println("********************");
                }
            }
        });

    }

    public void start() {
        Action action = new Action("Posicion");
        action.addValue("x", "200");
        action.addValue("y", "400");

        this.com.sendActionToAll(action);
    }
}
