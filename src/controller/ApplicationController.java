package controller;

import com.client.Client;
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
    public Player getCurrentPlayer();
    public Player getPlayerById(String id);
    public Group getGroup();
    public ActionCommunication getCommunication();
    public void startMiniGame();
    public void finishMiniGame();
    
}
