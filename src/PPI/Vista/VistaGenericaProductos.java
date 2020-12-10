/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPI.Vista;

import PPI.Modelos.ModeloProducto;
import PPI.Vistas.Interfaces.InterfazProductos;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Personal
 */
public class VistaGenericaProductos extends javax.swing.JPanel {

    List<ModeloProducto> listaModeloProducto;
    VistaProductos vista;
    InterfazProductos listenerControlador;

    private int IdProductoPublicado;

    public VistaGenericaProductos(List<ModeloProducto> listaModeloProductos, VistaProductos context) {
        this.listaModeloProducto = listaModeloProductos;
        vista = context;
    }

    public VistaGenericaProductos(String texto, String imagen, String cantidad, String referencia, String precio, int idProducto, InterfazProductos listener) {
        initComponents();
        listenerControlador = listener;
        setNombrePoducto(texto);
        setImagenProducto(imagen);
        setCantidad(cantidad);
        setReferencia(referencia);
        setPrecio(precio);
        IdProductoPublicado = idProducto;
    }

    public void crearProductos(InterfazProductos listener) {
        for (int i = 0; i < listaModeloProducto.size(); i++) {
            VistaGenericaProductos productos = new VistaGenericaProductos(listaModeloProducto.get(i).getNombreProducto(), listaModeloProducto.get(i).getImagen(), listaModeloProducto.get(i).getCantidad(), listaModeloProducto.get(i).getReferencia(), listaModeloProducto.get(i).getPrecio(), listaModeloProducto.get(i).getIdProducto(), listener);
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.anchor = GridBagConstraints.NORTH;
            gbc.weighty = 1;
            vista.getJPanelScroll().add(productos, gbc);
        }

        vista.getJPanelScroll().updateUI();
    }

    private void setNombrePoducto(String texto) {
        lblNombreProducto.setText(texto);
    }

    private void setImagenProducto(String imagen) {
        ImageIcon icon = new ImageIcon(System.getProperty("user.dir") + imagen);
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        lblImagenProductos.setIcon(icono);
    }

    private void setCantidad(String cantidad) {
        lblCantidad.setText(cantidad);
    }

    private void setReferencia(String referencia) {
        lblRefencia.setText(referencia);
    }

    private void setPrecio(String precio) {
        lblPrecio.setText(precio);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblModificarProductos = new javax.swing.JLabel();
        btnEliminar = new javax.swing.JLabel();
        lblImagenProductos = new javax.swing.JLabel();
        lblNombreProducto = new javax.swing.JLabel();
        lblRefencia = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(215, 204, 200));
        setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED));
        setForeground(new java.awt.Color(215, 204, 200));

        lblModificarProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/edit24.png"))); // NOI18N
        lblModificarProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblModificarProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblModificarProductosMouseClicked(evt);
            }
        });

        btnEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/delete24.png"))); // NOI18N
        btnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnEliminarMouseClicked(evt);
            }
        });

        lblImagenProductos.setText("Imagen");

        lblNombreProducto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNombreProducto.setForeground(new java.awt.Color(0, 0, 0));
        lblNombreProducto.setText("Nombre del Producto");

        lblRefencia.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblRefencia.setText("Referecia");

        lblCantidad.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblCantidad.setText("Cantidad");

        lblPrecio.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblPrecio.setText("Precio");

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel1.setText("Referencia:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel2.setText("Cantidad:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 18)); // NOI18N
        jLabel3.setText("Precio:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(lblImagenProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblPrecio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblModificarProductos))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNombreProducto)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCantidad))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblRefencia)))
                        .addGap(0, 103, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addGap(12, 12, 12))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblNombreProducto)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblRefencia)
                                .addComponent(jLabel1))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblCantidad)
                                .addComponent(jLabel2))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblPrecio)
                                .addComponent(jLabel3)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminar)
                            .addComponent(lblModificarProductos)))
                    .addComponent(lblImagenProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lblModificarProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblModificarProductosMouseClicked
        listenerControlador.productoClickedModificar(IdProductoPublicado);
    }//GEN-LAST:event_lblModificarProductosMouseClicked

    private void btnEliminarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEliminarMouseClicked
        listenerControlador.productoClickedEliminar(IdProductoPublicado);
    }//GEN-LAST:event_btnEliminarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnEliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblImagenProductos;
    private javax.swing.JLabel lblModificarProductos;
    private javax.swing.JLabel lblNombreProducto;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JLabel lblRefencia;
    // End of variables declaration//GEN-END:variables
}
