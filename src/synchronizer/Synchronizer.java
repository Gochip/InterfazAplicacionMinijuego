package synchronizer;

/**
 * Esta clase permite determinar cuando todo el grupo está en cierto estado.
 * @author Parisi Germán
 * @version 1.0
 */
public abstract class Synchronizer {
    public abstract void sendToken();
    public abstract boolean isCorrectState();
    public abstract void execute();
    public abstract void receiveToken();
    public void start(){
        receiveToken();
    }
}
