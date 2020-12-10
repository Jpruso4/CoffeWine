/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPI.Vistas.Interfaces;

import javax.swing.Icon;

/**
 *
 * @author Personal
 */
public interface InterfazProductos {
    
    public void setTextLblImagenPublicar(String texto);

    public void setIconLblImagenPublicar(Icon icono);

    public void setTextLblNombreProducto(String texto);
    
    public void setTextLblCantidad(String texto);
    
    public void setTextLblReferencia(String texto);
    
    public void setTextLblPrecio(String texto);
    
    public int getWidthImagen();

    public int getHeightImagen();
    
    public void productoClickedModificar(int idProducto);
    
    public void productoClickedEliminar(int idProducto);
}
