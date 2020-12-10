/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPI.Controladores;

import PPI.Modelos.ModeloProducto;
import PPI.Utils.Archivo;
import PPI.Vistas.Interfaces.InterfazSubirProducto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Personal
 */
public class ControladorCrudProducto {

    public File archivo;
    Gson gson;
    Archivo utilArchivo = new Archivo();
    InterfazSubirProducto listener;
    File selectedFile;
    BufferedImage bufferedImage;

    public ControladorCrudProducto(InterfazSubirProducto listenerProducto) {
        archivo = new File("producto.txt");
        gson = new Gson();
        listener = listenerProducto;
    }

    public boolean guardarProducto(ModeloProducto producto, boolean esModificacion) {
        try {
            String informacionDelArchivo = utilArchivo.obtenerInformacionArchivo(archivo);
            List<ModeloProducto> listFromGson = new ArrayList<ModeloProducto>();
            if (informacionDelArchivo != null) {
                Type userListType = new TypeToken<List<ModeloProducto>>() {
                }.getType();
                listFromGson = gson.fromJson(informacionDelArchivo, userListType);
            }
            if (esModificacion) {
                if (listFromGson.size() != 0) {
                    for (int i = 0; i < listFromGson.size(); i++) {
                        if (listFromGson.get(i).getIdProducto() == producto.getIdProducto()) {
                            listFromGson.get(i).setCantidad(producto.getCantidad());
                            listFromGson.get(i).setNombreProducto(producto.getNombreProducto());
                            listFromGson.get(i).setPrecio(producto.getPrecio());
                            listFromGson.get(i).setReferencia(producto.getReferencia());
                            if (selectedFile != null) {
                                listFromGson.get(i).setImagen(guardarImagen());
                            } else {
                                if (listFromGson.get(i).getImagen().equals(producto.getImagen())) {
                                    listFromGson.get(i).setImagen(producto.getImagen());
                                }
                            }
                        }
                    }
                }
            } else {
                if (listFromGson.isEmpty()) {
                    producto.setIdProducto(1);
                } else {
                    producto.setIdProducto(listFromGson.get(listFromGson.size() - 1).getIdProducto()+ 1);
                }
                producto.setImagen(guardarImagen());
                listFromGson.add(producto);
            }
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

    public String guardarImagen() {
        try {
            bufferedImage = ImageIO.read(selectedFile);
            String path = System.getProperty("user.dir") + "\\Imagen\\" + selectedFile.getName();
            File fileImage = new File(path);
            ImageIO.write(bufferedImage, selectedFile.getName().split("\\.")[1], fileImage);
            return "\\Imagen\\" + selectedFile.getName();
        } catch (Exception ex) {

        }
        return null;
    }
    
        public void capturarImagen() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter extensionesArchivo = new FileNameExtensionFilter("JPG y PNG", "jpg", "png");
        fileChooser.setFileFilter(extensionesArchivo);

        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            selectedFile = fileChooser.getSelectedFile();
            try {
                ImageIcon icon = new ImageIcon(selectedFile.toString());
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(listener.getWidthImagen(), listener.getHeightImagen(), Image.SCALE_DEFAULT));
                listener.setTextLblImagenPublicar(null);
                listener.setIconLblImagenPublicar(icono);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error abriendo la imagen " + ex);
            }
        }
    }
}
