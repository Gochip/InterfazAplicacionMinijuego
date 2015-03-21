package common;

import java.io.Serializable;

/**
 *
 * @author Parisi Germán
 */
public interface Communication {
    public void sendToAll(String message);
    public void sendObjectToAll(Serializable object);
    public void sendToPlayer(String message, Player player);
    public void sendObjectToPlayer(Serializable object, Player player);
}
