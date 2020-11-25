package PPI.Utils;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 *
 * @author Personal
 */
public class Archivo {

    Gson gson = new Gson();

    public String obtenerInformacionArchivo(File archivo) {
        String cadenaADevolver = "";
        try {
            FileReader FileR = new FileReader(archivo);
            BufferedReader Bufffered = new BufferedReader(FileR);
            String cadena;
            while ((cadena = Bufffered.readLine()) != null) {
                if (cadena != null) {
                    cadenaADevolver += cadena;
                }
            }
        } catch (Exception ex) {
            return null;
        }
        return cadenaADevolver;
    }
}
