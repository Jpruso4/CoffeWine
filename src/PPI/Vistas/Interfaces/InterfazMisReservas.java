package PPI.Vistas.Interfaces;

import javax.swing.Icon;

/**
 *
 * @author Personal
 */
public interface InterfazMisReservas {

    public void setTextLblImagenPublicar(String texto);

    public void setIconLblImagenPublicar(Icon icono);

    public void setTextLblNombreProducto(String texto);

    public void setTextLblCantidadDeReserva(String texto);

    public void setTextLblPrecio(String texto);

    public int getWidthImagen();

    public int getHeightImagen();

    public void reservaClickedModificar(int idReserva);

    public void reservaClickedEliminar(int idReserva);
}
