/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPI.Vista;

import PPI.Controladores.ControladorReservasAdmin;
import PPI.Modelos.ModeloReserva;
import PPI.Vistas.Interfaces.InterfazReservasAdmin;
import java.awt.Image;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Personal
 */
public class VistaReservasAdmin extends javax.swing.JFrame implements InterfazReservasAdmin{

    ControladorReservasAdmin controlador;
    boolean respuestaReserva;
    ModeloReserva reservaModificado = new ModeloReserva();

    /**
     * Creates new form VistaReservasAdmin
     */
    public VistaReservasAdmin() {
        initComponents();
        
        controlador = new ControladorReservasAdmin(this);
         
        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/grano-de-cafe.png")).getImage());
        
        List<ModeloReserva> reserva = controlador.VerificarReservas();
        if (reserva != null) {
            VistaGenericaReservasAdmin controlGenerico = new VistaGenericaReservasAdmin(reserva, this);
            controlGenerico.crearReservas(this);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        lblLogo1 = new javax.swing.JLabel();
        lblVolver1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelPedidos = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pedidos de Usuarios - CoffeWine");

        jPanel5.setBackground(new java.awt.Color(93, 64, 55));

        lblLogo1.setBackground(new java.awt.Color(255, 255, 255));
        lblLogo1.setFont(new java.awt.Font("Dialog", 3, 18)); // NOI18N
        lblLogo1.setForeground(new java.awt.Color(255, 255, 255));
        lblLogo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/grano-de-cafe.png"))); // NOI18N
        lblLogo1.setText("CoffeWine");

        lblVolver1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/atras.png"))); // NOI18N
        lblVolver1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lblVolver1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblVolver1MouseClicked(evt);
            }
        });

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pedidos de usuarios");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblVolver1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 181, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(130, 130, 130)
                .addComponent(lblLogo1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogo1)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(lblVolver1)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelPedidos.setBackground(new java.awt.Color(215, 204, 200));
        jPanelPedidos.setForeground(new java.awt.Color(215, 204, 200));
        jPanelPedidos.setLayout(new java.awt.GridLayout(0, 1));
        jScrollPane1.setViewportView(jPanelPedidos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 408, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblVolver1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblVolver1MouseClicked
        VistaPrincipal principal = new VistaPrincipal();
        principal.setVisible(true);
        dispose();
    }//GEN-LAST:event_lblVolver1MouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaReservasAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaReservasAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaReservasAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaReservasAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaReservasAdmin().setVisible(true);
            }
        });
    }
    
    public javax.swing.JPanel getJPanelScroll(){
        return jPanelPedidos;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanelPedidos;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblLogo1;
    private javax.swing.JLabel lblVolver1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setTextLblImagenPublicar(String texto) {
    }

    @Override
    public void setIconLblImagenPublicar(Icon icono) {
    }

    @Override
    public void setTextLblNombreProducto(String texto) {
    }

    @Override
    public void setTextLblCantidadDeReserva(String texto) {
    }

    @Override
    public void setTextLblCorreo(String texto) {
    }

    @Override
    public void setTextLblPrecio(String texto) {
    }

    @Override
    public int getWidthImagen() {
        return 0;
    }

    @Override
    public int getHeightImagen() {
        return 0;
    }

    @Override
    public void reservaClickedModificar(int idReserva) {
        reservaModificado = controlador.ObtenerReservaModificar(idReserva);
        VistaProductosCatalogo ProductosCatalogo = new VistaProductosCatalogo(reservaModificado);
        ProductosCatalogo.setVisible(true);
        this.dispose();
    }

    @Override
    public void reservaClickedEliminar(int idReserva) {
         int resp = JOptionPane.showConfirmDialog(null, "Esta seguro que quiere eliminar el producto?", "ELIMINAR PRODUCTO", JOptionPane.OK_CANCEL_OPTION);
        if (JOptionPane.OK_OPTION == resp) {
            ModeloReserva reservaEliminado = new ModeloReserva();
            reservaEliminado.setIdReserva(idReserva);
            boolean eliminado = controlador.EliminarReserva(reservaEliminado.getIdReserva());
            if (eliminado) {
                JOptionPane.showMessageDialog(null, "El producto ha sido eliminado con éxito", "ELIMINAR PRODUCTO", JOptionPane.INFORMATION_MESSAGE);
                VistaReservasAdmin vistaReservasAdmin = new VistaReservasAdmin();
                vistaReservasAdmin.setVisible(true);
                this.dispose();
            }
        }
    }
}
