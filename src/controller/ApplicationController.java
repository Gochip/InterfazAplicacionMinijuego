package controller;

import common.ActionCommunication;
import common.Group;
import common.Player;
import java.util.ArrayList;

/**
 *
 * @author Parisi Germán
 * @version 1.0
 */
public interface ApplicationController {
    public ArrayList<Player> getPlayers();
    public Group getGroup();
    public ActionCommunication getCommunication();
    public void startMiniGame();
    public void finishMiniGame();
    
}
