package controller;

import common.ActionCommunication;
import common.Group;
import common.Player;
import java.util.ArrayList;

/**
 *
 * @author Parisi Germán
 */
public class SimpleApplicationController implements ApplicationController{

    private SimpleActionCommunication com;
    public SimpleApplicationController(SimpleActionCommunication com){
        this.com = com;
    }
    
    @Override
    public ArrayList<Player> getPlayers() {
        return null;
    }

    @Override
    public Group getGroup() {
        return null;
    }

    @Override
    public ActionCommunication getCommunication() {
        return this.com;
    }

    @Override
    public void startMiniGame() {
        
    }

    @Override
    public void finishMiniGame() {
        
    }
    
}
