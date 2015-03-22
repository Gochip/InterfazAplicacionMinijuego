package principal;

import com.client.Client;
import com.client.listener.MessageListener;
import common.Action;
import controller.SimpleActionCommunication;
import controller.SimpleApplicationController;
import executors.response.CommandResponse;
import executors.response.MessageResponse;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Parisi Germán
 */
public class Principal {

    public static void main(String[] args) {
        try {
            Client cl = Client.getInstance("localhost", 20202, "123");
            cl.addEventListener(new MessageListener() {

                @Override
                public void messageReceived(MessageResponse response) {
                    Action action = Action.getAction(response);
                    System.out.println(action.getName());
                    System.out.println(action.getValue("x"));
                    System.out.println(action.getValue("y"));
                }
            });

            Scanner sc = new Scanner(System.in);
            System.out.println("Creador (yes|no): ");
            String linea = sc.nextLine();
            String idGroup;
            if (linea.equals("yes")) {
                CommandResponse cr = cl.send("CREATE_GROUP 'g'");
                idGroup = cr.getValue("id_group");
                System.out.println("Grupo creado con id: " + idGroup);
            } else {
                System.out.println("Grupo a unirse: ");
                idGroup = sc.nextLine();
                cl.send("JOIN '" + idGroup + "'");
            }
            SimpleActionCommunication com = new SimpleActionCommunication(cl, idGroup);
            SimpleApplicationController con = new SimpleApplicationController(com);

            MouseMove mm = new MouseMove(con);
            mm.start();

        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
