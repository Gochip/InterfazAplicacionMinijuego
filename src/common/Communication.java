package common;

import com.client.Client;
import com.difusion.Diffusion;

/**
 *
 * @author Parisi Germán
 */
public interface Communication {
    public void sendToAll(String message);
    public void sendObjectToAll(Diffusion object);
    public Client getClient();
    public void sendToPlayer(String message, Player player);
    public void sendObjectToPlayer(Diffusion object, Player player);
}
