package test;

import test.Usuario;
import com.client.Client;
import com.client.listener.InformationListener;
import executors.response.CommandResponse;
import executors.response.InformationResponse;
import receivers.Interpreter;
import synchronizer.Synchronizer;

/**
 *
 * @author Parisi Germán
 * @version 1.0
 */
public class MiSincronizador extends Synchronizer {

    private final Client cl;
    private final Usuario usuario;

    public MiSincronizador(Client cl, Usuario usuario) {
        this.cl = cl;
        this.usuario = usuario;
    }

    @Override
    public void sendToken() {
        cl.send("JOIN '" + usuario.idGrupo + "'");
        if (isCorrectState()) {
            execute();
        }
    }

    @Override
    public boolean isCorrectState() {
        CommandResponse cr = cl.send("SHOW_GROUP '" + usuario.idGrupo + "'");
        int maxNum = Integer.parseInt(cr.getValue("max_num"));
        int cantJug = cr.getValue("id_clients").split(",").length;
        return cantJug == maxNum;
    }

    @Override
    public void execute() {
        System.out.println("Comenzar");
    }

    @Override
    public void receiveToken() {
        cl.addEventListener(new InformationListener() {

            @Override
            public void informationReceived(InformationResponse response) {
                Interpreter interpreter = new Interpreter(response);
                if (interpreter.isJoin()) {
                    if (isCorrectState()) {
                        execute();
                    }
                }
            }
        });
    }

}
