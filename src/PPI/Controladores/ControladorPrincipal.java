/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPI.Controladores;

import PPI.Modelos.ModeloSesion;
import PPI.Utils.Archivo;
import PPI.Vista.VistaPrincipal;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.lang.reflect.Type;

/**
 *
 * @author Personal
 */
public class ControladorPrincipal {
    public File archivo;
    public File archivoLibro;
    Archivo utilArchivo = new Archivo();
    Gson gson;

    public ControladorPrincipal(VistaPrincipal aThis) {
        archivo = new File("iniciosesion.txt");
        gson = new Gson();
    }

    public boolean VerificarSesion(ModeloSesion sesion) {
        String informacionDelArchivo = utilArchivo.obtenerInformacionArchivo(archivo);
        ModeloSesion sesionJson = new ModeloSesion();

        if (informacionDelArchivo != null && !informacionDelArchivo.isEmpty()) {
            Type sesionActiva = new TypeToken<ModeloSesion>() {
            }.getType();
            sesionJson = gson.fromJson(informacionDelArchivo, sesionActiva);
            return sesionJson.isSesionActiva();
        }
        return false;
    }
}
