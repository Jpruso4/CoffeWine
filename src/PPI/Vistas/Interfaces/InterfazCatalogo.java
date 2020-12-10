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
public interface InterfazCatalogo {

    public void setTextLblImagenPrincipal(String texto);

    public void setIconLblImagenPrincipal(Icon icono);

    public void setTextLblTituloPrincipal(String texto);

    public int getWidthImagen();

    public int getHeightImagen();

    public void productoClicked(int idProducto);
}
