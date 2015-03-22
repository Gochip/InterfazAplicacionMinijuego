package common;

/**
 *
 * @author Parisi Germán
 */
public interface ActionCommunication extends Communication{
    public void sendActionToAll(Action action);
    public void sendActionToPlayer(Action action, Player player);
}
