package principal;

import com.client.Client;
import common.Group;
import common.Player;
import controller.SimpleActionCommunication;
import controller.SimpleApplicationController;
import controller.SimpleExecute;
import controller.SimpleSynchronizer;
import executors.response.CommandResponse;
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

            Scanner sc = new Scanner(System.in);
            System.out.println("Creador (yes|no): ");
            String linea = sc.nextLine();
            String idGroup;
            Player player;
            Group group;
            boolean creator = false;
            if (linea.equals("yes")) {
                CommandResponse cr = cl.send("CREATE_GROUP 'g'");
                idGroup = cr.getValue("id_group");
                System.out.println("Grupo creado con id: " + idGroup);
                creator = true;
            } else {
                System.out.println("Grupo a unirse: ");
                idGroup = sc.nextLine();
                cl.send("JOIN '" + idGroup + "'");
            }
            System.out.println("Ingrese su nombre: ");
            String name = sc.nextLine();
            player = new Player(cl.getId(), name);
            player.setCreator(creator);

            group = new Group(idGroup);

            SimpleActionCommunication com = new SimpleActionCommunication(cl, idGroup);
            SimpleApplicationController con = new SimpleApplicationController(com);
            con.setCurrentPlayer(player);
            con.addPlayer(player);
            con.setGroup(group);

            MouseMove mm = new MouseMove(con);
            SimpleExecute simpleExecute = new SimpleExecute() {

                @Override
                public void execute() {
                    System.out.println("Comenzar");
                    
                    mm.start();
                }
            };
            
            SimpleSynchronizer ss = new SimpleSynchronizer(con, simpleExecute);
            ss.start();
            
            if(!player.isCreator()){
                ss.sendToken();
            }

        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
