/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPI.Controladores;

import PPI.Modelos.ModeloUsuario;
import PPI.Modelos.ModeloUsuario;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Personal
 */
public class ControladorRegistrarse {
        public File archivo;
    Gson gson;

    public ControladorRegistrarse() {
        archivo = new File("usuario.txt");
        gson = new Gson();
    }

    public boolean guardarUsuario(ModeloUsuario usuario) {
        try {
            String informacionDelArchivo = obtenerInformacionArchivo();
            List<ModeloUsuario> listFromGson = new ArrayList<ModeloUsuario>();

            if (informacionDelArchivo != null) {
                Type userListType = new TypeToken<List<ModeloUsuario>>() {
                }.getType();
                listFromGson = gson.fromJson(informacionDelArchivo, userListType);
            }

            if (listFromGson.size() == 0) {
                usuario.setIdUsuario(1);
            } else {
                usuario.setIdUsuario(listFromGson.get(listFromGson.size() - 1).getIdUsuario() + 1);
            }

            listFromGson.add(usuario);

            BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
            FileWriter file = new FileWriter(archivo, true);
            PrintWriter printer = new PrintWriter(file);
            printer.println(gson.toJson(listFromGson));
            bw.write("");
            file.close();
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    private String obtenerInformacionArchivo() {
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
    public boolean validarContrasena(ModeloUsuario usuario) {
        return usuario.getContrasena().matches("^(?=.{8,}$)(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).*$");
    }

    public boolean validarCorreoElectronico(ModeloUsuario usuario) {
        return usuario.getCorreo().matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])");
    }
}
