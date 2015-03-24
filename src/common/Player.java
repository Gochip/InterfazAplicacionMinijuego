package common;

import java.util.Objects;

/**
 *
 * @author Parisi Germán
 */
public class Player {

    private String name;
    private int pos;
    private final String id;
    private boolean creator;

    public Player(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPos() {
        return pos;
    }

    public boolean isCreator() {
        return this.creator;
    }

    public void setCreator(boolean creator) {
        this.creator = creator;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Player other = (Player) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    
}
