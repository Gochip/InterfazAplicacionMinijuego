package common;

import com.difusion.Diffusion;

/**
 *
 * @author Parisi Germán
 */
public interface Communication {
    public void sendToAll(String message);
    public void sendObjectToAll(Diffusion object);
    public void sendToPlayer(String message, Player player);
    public void sendObjectToPlayer(Diffusion object, Player player);
}
