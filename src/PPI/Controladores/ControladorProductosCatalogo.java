/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPI.Controladores;

import PPI.Modelos.ModeloProducto;
import PPI.Modelos.ModeloReserva;
import PPI.Modelos.ModeloSesion;
import PPI.Utils.Archivo;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;

/**
 *
 * @author Personal
 */
public class ControladorProductosCatalogo {

    public File archivo;
    public File archivoProducto;
    public File archivoSesion;
    Archivo utilArchivo = new Archivo();
    Gson gson;
    Gson gsonSesion;
    ModeloProducto producto;
    ModeloReserva reserva;
    boolean reservaSucces;

    public ControladorProductosCatalogo() {
        gson = new Gson();
        gsonSesion = new Gson();
        archivo = new File("reserva.txt");
        archivoProducto = new File("producto.txt");
        archivoSesion = new File("iniciosesion.txt");
        producto = new ModeloProducto();
        reserva = new ModeloReserva();
    }

    public ModeloProducto mostrarComponentes(int idProducto) {
        String informacionDelArchivo = utilArchivo.obtenerInformacionArchivo(archivoProducto);
        List<ModeloProducto> listFromGson = new ArrayList<ModeloProducto>();

        if (informacionDelArchivo != null) {
            Type userListType = new TypeToken<List<ModeloProducto>>() {
            }.getType();
            listFromGson = gson.fromJson(informacionDelArchivo, userListType);
        }
        if (listFromGson.size() != 0) {
            for (int i = 0; i < listFromGson.size(); i++) {
                if (listFromGson.get(i).getIdProducto() == idProducto) {
                    producto.setNombreProducto(listFromGson.get(i).getNombreProducto());
                    producto.setCantidad(listFromGson.get(i).getCantidad());
                    producto.setReferencia(listFromGson.get(i).getReferencia());
                    producto.setPrecio(listFromGson.get(i).getPrecio());
                    producto.setImagen(listFromGson.get(i).getImagen());
                    return producto;
                }
            }
        }
        return null;
    }

    public boolean guardarReserva(int idProducto, String cantidad) {
        String informacionDelArchivo = utilArchivo.obtenerInformacionArchivo(archivoProducto);
        List<ModeloProducto> listFromGson = new ArrayList<ModeloProducto>();

        if (informacionDelArchivo != null) {
            Type userListType = new TypeToken<List<ModeloProducto>>() {
            }.getType();
            listFromGson = gson.fromJson(informacionDelArchivo, userListType);
        }
        if (listFromGson.size() != 0) {
            for (int i = 0; i < listFromGson.size(); i++) {
                if (listFromGson.get(i).getIdProducto() == idProducto) {
                    reserva.setIdProducto(idProducto);
                    reserva.setCantidadDeReserva(cantidad);
                    reserva.setNombreProducto(listFromGson.get(i).getNombreProducto());
                    reserva.setPrecio(listFromGson.get(i).getPrecio());
                    reserva.setReferencia(listFromGson.get(i).getReferencia());
                    reserva.setImagen(listFromGson.get(i).getImagen());
                }
            }
        }
        reserva.setIdUsuario(idUsuario());
        reserva.setCorreo(correo());
        reservaSucces = guardarReservaArchivo(reserva);
        if (reservaSucces) {
            return true;
        }
        return false;
    }

    public int idUsuario() {
        String informacionDelArchivo = utilArchivo.obtenerInformacionArchivo(archivoSesion);
        ModeloSesion sesionJson = new ModeloSesion();

        if (informacionDelArchivo != null && !informacionDelArchivo.isEmpty()) {
            Type idSesion = new TypeToken<ModeloSesion>() {
            }.getType();
            sesionJson = gson.fromJson(informacionDelArchivo, idSesion);
            return sesionJson.getIdUsuario();

        }
        return 0;
    }

    public String correo() {
        String informacionDelArchivo = utilArchivo.obtenerInformacionArchivo(archivoSesion);
        ModeloSesion correoJson = new ModeloSesion();

        if (informacionDelArchivo != null && !informacionDelArchivo.isEmpty()) {
            Type correo = new TypeToken<ModeloSesion>() {
            }.getType();
            correoJson = gson.fromJson(informacionDelArchivo, correo);
            return correoJson.getCorreo();
        }
        return null;
    }

    public boolean guardarReservaArchivo(ModeloReserva reservaArchivo) {
        try {
            String informacionDelArchivo = utilArchivo.obtenerInformacionArchivo(archivo);
            List<ModeloReserva> listFromGson = new ArrayList<ModeloReserva>();
            if (informacionDelArchivo != null) {
                Type userListType = new TypeToken<List<ModeloReserva>>() {
                }.getType();
                listFromGson = gson.fromJson(informacionDelArchivo, userListType);
            }

            if (listFromGson.isEmpty()) {
                reservaArchivo.setIdReserva(1);
            } else {
                reservaArchivo.setIdReserva(listFromGson.get(listFromGson.size() - 1).getIdReserva()+ 1);
            }
            listFromGson.add(reservaArchivo);

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

    public boolean guardarReserva(int idDelProducto, JTextField txtCantidad) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
