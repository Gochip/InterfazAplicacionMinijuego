package test;

import com.client.Client;
import executors.response.CommandResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Parisi Germán
 */
public class principal {

    public static void main(String[] args) {
        try {
            Client cl = Client.getInstance("localhost", 20202, "123");
            
            Usuario usuario = new Usuario();
            usuario.master = true;
            
            CommandResponse cr = cl.send("CREATE_GROUP 'G1' -n '3'");
            String idGrupo = cr.getValue("id_group");
            usuario.idGrupo = idGrupo;
            
            MiSincronizador s = new MiSincronizador(cl, usuario);
            s.start();

        } catch (IOException ex) {
            Logger.getLogger(principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
}
