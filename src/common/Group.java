package common;

import java.util.ArrayList;

/**
 *
 * @author Parisi Germán
 */
public class Group {
    private final String id;
    private final ArrayList<Player> players;
    public Group(String id){
        this.id = id;
        this.players = new ArrayList<>();
    }
    
    public void addPlayer(Player player){
        this.players.add(player);
    }
    
    public ArrayList<Player> getPlayers(){
        return this.players;
    }
    
    public String getId(){
        return id;
    }
}
