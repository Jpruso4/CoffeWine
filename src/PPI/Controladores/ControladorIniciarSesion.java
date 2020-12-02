/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPI.Controladores;

import PPI.Modelos.ModeloSesion;
import PPI.Modelos.ModeloUsuario;
import PPI.Utils.Archivo;
import PPI.Utils.Sesion;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Personal
 */
public class ControladorIniciarSesion {

    public File archivo;
    Gson gson;

    Archivo utilArchivo = new Archivo();
    
    public  ControladorIniciarSesion(){
        archivo = new File("usuario.txt");
        gson = new Gson();
    }
    
    public boolean iniciarSesion (ModeloUsuario usuario){
        
        String informacionDelArchivo = utilArchivo.obtenerInformacionArchivo(archivo);
        List<ModeloUsuario> listFromGson =  new ArrayList<ModeloUsuario>();
        
         if (informacionDelArchivo != null) {
            Type userListType = new TypeToken<List<ModeloUsuario>>() {
            }.getType();
            listFromGson = gson.fromJson(informacionDelArchivo, userListType);
        }
        if (listFromGson.size()!= 0) {
            for (int i = 0; i < listFromGson.size(); i++) {
                if (listFromGson.get(i).getCorreo().equals(usuario.getCorreo()) && listFromGson.get(i).getContrasena().equals(usuario.getContrasena())) {
                    ModeloSesion sesion = new ModeloSesion();
                    sesion.setCorreo(listFromGson.get(i).getCorreo());
                    sesion.setNick(listFromGson.get(i).getNick());
                    sesion.setIdUsuario(listFromGson.get(i).getIdUsuario());
                    sesion.settipoUsuario(listFromGson.get(i).getTipoUsuario());
                    sesion.setSesionActiva(true);
                    Sesion actualizar = new Sesion();
                    actualizar.ActualizarSesion(sesion);
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
