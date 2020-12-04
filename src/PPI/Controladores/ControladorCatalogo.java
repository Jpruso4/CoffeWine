package PPI.Controladores;

import PPI.Modelos.ModeloSesion;
import PPI.Utils.Archivo;
import PPI.Vista.VistaCatalogo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.lang.reflect.Type;

/**
 *
 * @author Personal
 */
public class ControladorCatalogo {

    public File archivo;
    Archivo utilArchivo = new Archivo();
    Gson gson;

    public ControladorCatalogo(VistaCatalogo aThis) {
        archivo = new File("iniciosesion.txt");
        gson = new Gson();
    }

    public int RetornarTipoUsuario(ModeloSesion sesion) {
        String informacionDelArchivo = utilArchivo.obtenerInformacionArchivo(archivo);
        ModeloSesion sesionJson = new ModeloSesion();

        if (informacionDelArchivo != null && !informacionDelArchivo.isEmpty()) {
            Type tipoUsuario = new TypeToken<ModeloSesion>() {
            }.getType();
            sesionJson = gson.fromJson(informacionDelArchivo, tipoUsuario);
            return sesionJson.gettipoUsuario();
        }
        return 0;
    }
}
