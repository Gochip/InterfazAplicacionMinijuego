package controller;

import common.ActionCommunication;
import common.GameOptions;
import common.Group;
import common.Player;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Parisi Germán
 */
public class SimpleApplicationController implements ApplicationController {

    private SimpleActionCommunication com;
    private ArrayList<Player> players;
    private Group group;
    private Player player;
    private JFrame gameWindows;
    private GameOptions gameOptions;

    public SimpleApplicationController(SimpleActionCommunication com) {
        this.com = com;
        this.players = new ArrayList<>();
        this.gameOptions = new GameOptions();
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    @Override
    public ArrayList<Player> getPlayers() {
        return this.players;
    }

    @Override
    public Group getGroup() {
        return this.group;
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

    @Override
    public Player getCurrentPlayer() {
        return this.player;
    }

    public void setCurrentPlayer(Player player) {
        this.player = player;
    }

    @Override
    public Player getPlayerById(String id) {
        for (Player p : players) {
            if (p.getId().equals(id)) {
                return p;
            }
        }
        return null;
    }

    public void setGameWindows(JFrame gameWindows) {
        this.gameWindows = gameWindows;
    }

    @Override
    public JFrame getGameWindow() {
        return this.gameWindows;
    }

    public void setGameOptions(GameOptions gameOptions) {
        this.gameOptions = gameOptions;
    }

    @Override
    public GameOptions getGameOptions() {
        return this.gameOptions;
    }
}
