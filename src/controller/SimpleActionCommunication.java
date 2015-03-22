package controller;

import com.client.Client;
import com.difusion.Diffusion;
import common.Action;
import common.ActionCommunication;
import common.Player;

/**
 *
 * @author Parisi Germán
 */
public class SimpleActionCommunication implements ActionCommunication{

    private Client cl;
    private String idGroup;
    private final String MESSAGE_GROUP = "MESSAGE_GROUP";
    private final String MESSAGE_CLIENT = "MESSAGE_CLIENT";
    
    public SimpleActionCommunication(Client cl, String idGroup){
        this.cl = cl;
        this.idGroup = idGroup;
    }
    
    @Override
    public void sendActionToAll(Action action) {
        sendToAll(action.toString());
    }

    @Override
    public void sendActionToPlayer(Action action, Player player) {
        sendToPlayer(action.toString(), player);
    }

    @Override
    public void sendToAll(String message) {
        cl.send(MESSAGE_GROUP + " '" + idGroup + "' '" + message + "'");
    }

    @Override
    public void sendToPlayer(String message, Player player) {
        cl.send(MESSAGE_CLIENT + " '" + player.getId() + "' '" + message + "'");
    }

    @Override
    public void sendObjectToAll(Diffusion object) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void sendObjectToPlayer(Diffusion object, Player player) {
        throw new UnsupportedOperationException();
    }
    
}
