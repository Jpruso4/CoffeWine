/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPI.Controladores;

import PPI.Modelos.ModeloProducto;
import PPI.Utils.Archivo;
import PPI.Vistas.Interfaces.InterfazProductos;
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
public class ControladorProductos {

    public File archivoProducto;
    Archivo utilArchivo = new Archivo();
    Gson gson;
    InterfazProductos listener;

    public ControladorProductos(InterfazProductos listenerMostrarProducto) {
        gson = new Gson();
        archivoProducto = new File("producto.txt");
        listener = listenerMostrarProducto;
    }

    public List<ModeloProducto> VerificarProductos() {
        String informacionDelArchivo = utilArchivo.obtenerInformacionArchivo(archivoProducto);
        List<ModeloProducto> listFromGson = new ArrayList<ModeloProducto>();
        List<ModeloProducto> listProductoGson = new ArrayList<ModeloProducto>();
        if (informacionDelArchivo != null) {
            Type userListType = new TypeToken<List<ModeloProducto>>() {
            }.getType();
            listFromGson = gson.fromJson(informacionDelArchivo, userListType);
        }
        if (listFromGson.size() != 0) {
            for (int i = 0; i < listFromGson.size(); i++) {
                listProductoGson.add(listFromGson.get(i));
            }
            return listProductoGson;
        }
        return null;
    }

    public ModeloProducto ObtenerProductoModificar(int idProducto) {
        String informacionDelArchivo = utilArchivo.obtenerInformacionArchivo(archivoProducto);
        List<ModeloProducto> listFromGson = new ArrayList<ModeloProducto>();

        if (informacionDelArchivo != null) {
            Type userListType = new TypeToken<List<ModeloProducto>>() {
            }.getType();
            listFromGson = gson.fromJson(informacionDelArchivo, userListType);
        }
        if (listFromGson.size() != 0) {
            for (int i = 0; i < listFromGson.size(); i++) {
                if (listFromGson.get(i).getIdProducto()== idProducto) {
                    ModeloProducto productoModificar = new ModeloProducto();
                    productoModificar.setNombreProducto(listFromGson.get(i).getNombreProducto());
                    productoModificar.setCantidad(listFromGson.get(i).getCantidad());
                    productoModificar.setPrecio(listFromGson.get(i).getPrecio());
                    productoModificar.setReferencia(listFromGson.get(i).getReferencia());
                    productoModificar.setImagen(listFromGson.get(i).getImagen());
                    productoModificar.setIdProducto(listFromGson.get(i).getIdProducto());
                    return productoModificar;
                }
            }
        }
        return null;
    }

    public boolean EliminarProducto(int idProductoEliminado) {
        String informacionDelArchivo = utilArchivo.obtenerInformacionArchivo(archivoProducto);
        List<ModeloProducto> listFromGson = new ArrayList<ModeloProducto>();
        if (informacionDelArchivo != null) {
            Type userListType = new TypeToken<List<ModeloProducto>>() {
            }.getType();
            listFromGson = gson.fromJson(informacionDelArchivo, userListType);
        }
        if (listFromGson.size() != 0) {
            for (int i = 0; i < listFromGson.size(); i++) {
                if (listFromGson.get(i).getIdProducto() == idProductoEliminado) {
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
            BufferedWriter bw = new BufferedWriter(new FileWriter(archivoProducto));
            FileWriter file = new FileWriter(archivoProducto, true);
            PrintWriter printer = new PrintWriter(file);
            printer.println(gson.toJson(listFromGsonEliminado));
            bw.write("");
            file.close();
        } catch (Exception ex) {

        }
    }
}
