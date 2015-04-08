package controller;

import com.client.Client;
import com.client.listener.MessageListener;
import common.Action;
import common.ActionCommunication;
import common.Player;
import executors.response.MessageResponse;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import synchronizer.Synchronizer;

/**
 *
 * @author Parisi Germán
 * @version 1.0
 */
public class SimpleSynchronizer extends Synchronizer {

    private final ActionCommunication com;
    private final SimpleApplicationController controller;
    private final Client cl;
    private static String GAME_DATA = "GAME_DATA";
    private static String JOINING = "JOINING";
    private AbstractSyncExecutor simpleExecute;

    public SimpleSynchronizer(SimpleApplicationController controller, AbstractSyncExecutor simpleExecute) {
        this.controller = controller;
        this.com = this.controller.getCommunication();
        this.cl = this.com.getClient();
        this.simpleExecute = simpleExecute;
    }

    @Override
    public void sendToken() {
        String name = this.controller.getCurrentPlayer().getName();
        this.controller.addPlayer(this.controller.getCurrentPlayer());
        Action action = new Action(JOINING);
        action.addValue("name", name);
        com.sendActionToAll(action);
        if (isCorrectState()) {
            execute();
        }
    }

    @Override
    public boolean isCorrectState() {
        int n = 4;
        //System.out.println("Cantidad de players: " + controller.getPlayers().size());
        return controller.getPlayers().size() == n;
    }

    @Override
    public void execute() {
        try {
            Thread.sleep(1000);
            simpleExecute.execute();
        } catch (InterruptedException ex) {
            Logger.getLogger(SimpleSynchronizer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void receiveToken() {
        cl.addEventListener(new MessageListener() {

            @Override
            public void messageReceived(MessageResponse response) {
                Action action = Action.getAction(response);
                if (action.getName().equals(JOINING)) {
                    // Obtengo el nombre del jugador que se unió.
                    String name = action.getValue("name");
                    System.out.println("Uniéndose: " + name);

                    // Obtengo el id del jugador que se unió.
                    String id = response.getId();
                    Player player = new Player(id, name);
                    // Agrego el nuevo player.
                    controller.addPlayer(player);
                    // Si soy creador entonces respondo con los datos de la partida.
                    if (controller.getCurrentPlayer().isCreator()) {
                        Action actionCreatorResponse = new Action(GAME_DATA);

                        ArrayList<Player> players = controller.getPlayers();
                        StringBuilder sb = new StringBuilder();
                        for (Player p : players) {
                            sb.append(p.getId()).append(",").append(p.getName()).append(",").append(p.isCreator()).append(";");
                        }

                        actionCreatorResponse.addValue("players", sb.toString());

                        actionCreatorResponse.addValue("count", String.valueOf(controller.getPlayers().size()));
                        com.sendActionToPlayer(actionCreatorResponse, player);
                    }
                    if (isCorrectState()) {
                        execute();
                    }
                } else if (action.getName().equals(GAME_DATA)) {
                    String count = action.getValue("count");
                    System.out.println("Cantidad: " + count);

                    controller.getPlayers().clear();
                    String players[] = action.getValue("players").split(";");
                    for (String pl : players) {
                        if (!pl.equals("")) {
                            String parts[] = pl.split(",");
                            addPlayer(parts[0], parts[1], Boolean.parseBoolean(parts[2]));
                        }
                    }

                    if (isCorrectState()) {
                        execute();
                    }
                }
            }

            public void addPlayer(String id, String name, boolean isCreator) {
                Player player = new Player(id, name);
                controller.addPlayer(player);
            }
        });
    }

}
