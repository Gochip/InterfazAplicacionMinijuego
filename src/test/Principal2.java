package test;

import com.client.Client;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Parisi Germán
 */
public class Principal2 {

    public static void main(String[] args) {
        try {
            Client cl = Client.getInstance("localhost", 20202, "123");

            Usuario usuario = new Usuario();
            usuario.master = false;
            usuario.idGrupo = "000";
            
            MiSincronizador s = new MiSincronizador(cl, usuario);
            s.start();
            s.sendToken();
            
        } catch (IOException ex) {
            Logger.getLogger(Principal2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
