package PPI.Controladores;

import PPI.Modelos.ModeloProducto;
import PPI.Modelos.ModeloSesion;
import PPI.Utils.Archivo;
import PPI.Vista.VistaCatalogo;
import PPI.Vistas.Interfaces.InterfazCatalogo;
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
public class ControladorCatalogo {

     public File archivo;
    public File archivoLibro;
    Archivo utilArchivo = new Archivo();
    Gson gson;
    InterfazCatalogo listener;

    public ControladorCatalogo(InterfazCatalogo listenerMostrarProductoCatalogo) {
        archivo = new File("iniciosesion.txt");
        gson = new Gson();
        archivoLibro = new File("producto.txt");
        listener = listenerMostrarProductoCatalogo;
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

    public List<ModeloProducto> MostrarProducto() {
        String informacionDelArchivo = utilArchivo.obtenerInformacionArchivo(archivoLibro);
        List<ModeloProducto> listFromGson = new ArrayList<ModeloProducto>();

        if (informacionDelArchivo != null) {
            Type userListType = new TypeToken<List<ModeloProducto>>() {
            }.getType();
            listFromGson = gson.fromJson(informacionDelArchivo, userListType);
        }
        if (listFromGson.size() != 0) {
            return listFromGson;
        }
        return null;
    }
}
