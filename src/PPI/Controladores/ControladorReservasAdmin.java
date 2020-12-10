/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPI.Controladores;

import PPI.Modelos.ModeloReserva;
import PPI.Utils.Archivo;
import PPI.Vistas.Interfaces.InterfazReservasAdmin;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Personal
 */
public class ControladorReservasAdmin {

    public File archivoReserva;
    Archivo utilArchivo = new Archivo();
    Gson gson;
    InterfazReservasAdmin listener;

    public ControladorReservasAdmin(InterfazReservasAdmin listenerMostrarReservas) {
        gson = new Gson();
        archivoReserva = new File("reserva.txt");
        listener = listenerMostrarReservas;
    }

    public List<ModeloReserva> VerificarReservas() {
        String informacionDelArchivo = utilArchivo.obtenerInformacionArchivo(archivoReserva);
        List<ModeloReserva> listFromGson = new ArrayList<ModeloReserva>();
        List<ModeloReserva> listReservaGson = new ArrayList<ModeloReserva>();
        if (informacionDelArchivo != null) {
            Type userListType = new TypeToken<List<ModeloReserva>>() {
            }.getType();
            listFromGson = gson.fromJson(informacionDelArchivo, userListType);
        }
        if (listFromGson.size() != 0) {
            for (int i = 0; i < listFromGson.size(); i++) {
                listReservaGson.add(listFromGson.get(i));
            }
            return listReservaGson;
        }
        return null;
    }

    public ModeloReserva ObtenerReservaModificar(int idReserva) {
        String informacionDelArchivo = utilArchivo.obtenerInformacionArchivo(archivoReserva);
        List<ModeloReserva> listFromGson = new ArrayList<ModeloReserva>();

        if (informacionDelArchivo != null) {
            Type userListType = new TypeToken<List<ModeloReserva>>() {
            }.getType();
            listFromGson = gson.fromJson(informacionDelArchivo, userListType);
        }
        if (listFromGson.size() != 0) {
            for (int i = 0; i < listFromGson.size(); i++) {
                if (listFromGson.get(i).getIdReserva() == idReserva) {
                    ModeloReserva reservaModificar = new ModeloReserva();
                    reservaModificar.setNombreProducto(listFromGson.get(i).getNombreProducto());
                    reservaModificar.setCantidadDeReserva(listFromGson.get(i).getCantidadDeReserva());
                    reservaModificar.setPrecio(listFromGson.get(i).getPrecio());
                    reservaModificar.setReferencia(listFromGson.get(i).getReferencia());
                    reservaModificar.setImagen(listFromGson.get(i).getImagen());
                    reservaModificar.setIdProducto(listFromGson.get(i).getIdProducto());
                    reservaModificar.setIdUsuario(listFromGson.get(i).getIdUsuario());
                    reservaModificar.setCorreo(listFromGson.get(i).getCorreo());
                    return reservaModificar;
                }
            }
        }
        return null;
    }

    public boolean EliminarReserva(int idReservaEliminado) {
        String informacionDelArchivo = utilArchivo.obtenerInformacionArchivo(archivoReserva);
        List<ModeloReserva> listFromGson = new ArrayList<ModeloReserva>();
        if (informacionDelArchivo != null) {
            Type userListType = new TypeToken<List<ModeloReserva>>() {
            }.getType();
            listFromGson = gson.fromJson(informacionDelArchivo, userListType);
        }
        if (listFromGson.size() != 0) {
            for (int i = 0; i < listFromGson.size(); i++) {
                if (listFromGson.get(i).getIdReserva() == idReservaEliminado) {
                    listFromGson.remove(i);
                    guardarListJson(listFromGson);
                    return true;
                }
            }
        }
        return false;
    }

    public void guardarListJson(List listFromGsonEliminado) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoReserva));
            FileWriter file = new FileWriter(archivoReserva, true);
            PrintWriter printer = new PrintWriter(file);
            printer.println(gson.toJson(listFromGsonEliminado));
            bw.write("");
            file.close();
        } catch (Exception ex) {

        }
    }
}
