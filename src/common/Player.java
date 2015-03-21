package common;

/**
 *
 * @author Parisi Germán
 */
public class Player {

    private String name;
    private final int pos;
    private final String id;

    public Player(String id, String name, int pos) {
        this.id = id;
        this.name = name;
        this.pos = pos;
    }
    
    public String getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPos() {
        return pos;
    }
    
    public void setName(String name){
        this.name = name;
    }

}
