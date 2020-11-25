package PPI.Utils;

import PPI.Modelos.ModeloSesion;
import com.google.gson.Gson;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author Personal
 */
public class Sesion {

    File inicSesion;
    Gson gson;

    public Sesion() {
        inicSesion = new File("iniciosesion.txt");
        gson = new Gson();
    }

    public boolean ActualizarSesion(ModeloSesion sesion) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(inicSesion));
            FileWriter file = new FileWriter(inicSesion, true);
            PrintWriter printer = new PrintWriter(file);
            printer.println(gson.toJson(sesion));
            bw.write("");
            file.close();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }
}
