/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PPI.Vista;

import PPI.Controladores.ControladorPrincipal;
import PPI.Modelos.ModeloSesion;
import PPI.Utils.Sesion;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Personal
 */
public class VistaPrincipal extends javax.swing.JFrame {

    public File inicio;
    ControladorPrincipal controlador;
    boolean respuestaSesion;
    int tipoUsuario;

    /**
     * Creates new form VistaPrincipal
     */
    public VistaPrincipal() {
        initComponents();
        
        jTextArea1.setText("El vino de café no es la bebida más popular del mundo. Es probable, incluso que muchos de vosotros estéis leyendo acerca de ella por primera vez justo en estos momentos. Se trata de una receta que se elabora con vino y café (sí, lo has adivinado), que resulta muy atractiva pero que debe equilibrarse con gran precisión. No debemos confundirla con el licor de café, que se elabora a partir de otras bebidas espirituosas y que no tiene nada que ver con el vino.");
        jTextArea1.setForeground(new java.awt.Color(93,64,55));
        jTextArea1.setLineWrap(true);
        jTextArea1.setWrapStyleWord(true);

        inicio = new File("iniciosesion.txt");

        controlador = new ControladorPrincipal(this);
        ModeloSesion sesion = new ModeloSesion();

        this.setLocationRelativeTo(null);
        this.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/grano-de-cafe.png")).getImage());
        ImageIcon icon = new ImageIcon(System.getProperty("/Imagenes/grano-de-cafe.png"));
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
        respuestaSesion = controlador.VerificarSesion(sesion);
        tipoUsuario = controlador.RetornarTipoUsuario(sesion);

        if (respuestaSesion && tipoUsuario == 1) {
            this.btnDerecha.setText("Cerrar Sesión");
            this.btnIzquierda.setText("Pedidos");
            this.btnProductos.setVisible(true);
        } else {
            if (respuestaSesion && tipoUsuario == 2) {
                this.btnDerecha.setText("Cerrar Sesión");
                this.btnIzquierda.setText("Mis Pedidos");
                this.btnProductos.setVisible(false);

            } else {
                this.btnDerecha.setText("Regístrate");
                this.btnIzquierda.setText("Iniciar Sesión");
                this.btnProductos.setVisible(false);
            }
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

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        btnProductos = new javax.swing.JButton();
        btnIzquierda = new javax.swing.JButton();
        btnDerecha = new javax.swing.JButton();
        btnCatalogo1 = new javax.swing.JButton();
        btnGuia1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Principal - CoffeWine");
        setBackground(new java.awt.Color(140, 158, 255));

        jPanel3.setBackground(new java.awt.Color(215, 204, 200));

        jPanel4.setBackground(new java.awt.Color(93, 64, 55));

        lblLogo.setBackground(new java.awt.Color(255, 255, 255));
        lblLogo.setFont(new java.awt.Font("Dialog", 3, 14)); // NOI18N
        lblLogo.setForeground(new java.awt.Color(255, 255, 255));
        lblLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/grano-de-cafe.png"))); // NOI18N
        lblLogo.setText("CoffeWine");

        btnProductos.setBackground(new java.awt.Color(188, 170, 164));
        btnProductos.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btnProductos.setForeground(new java.awt.Color(0, 0, 0));
        btnProductos.setText("Productos");
        btnProductos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProductosMouseClicked(evt);
            }
        });
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });

        btnIzquierda.setBackground(new java.awt.Color(188, 170, 164));
        btnIzquierda.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btnIzquierda.setForeground(new java.awt.Color(0, 0, 0));
        btnIzquierda.setText("Iniciar Sesión");
        btnIzquierda.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnIzquierda.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnIzquierdaMouseClicked(evt);
            }
        });

        btnDerecha.setBackground(new java.awt.Color(188, 170, 164));
        btnDerecha.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btnDerecha.setForeground(new java.awt.Color(0, 0, 0));
        btnDerecha.setText("Regístrate");
        btnDerecha.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDerecha.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDerechaMouseClicked(evt);
            }
        });

        btnCatalogo1.setBackground(new java.awt.Color(188, 170, 164));
        btnCatalogo1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btnCatalogo1.setForeground(new java.awt.Color(0, 0, 0));
        btnCatalogo1.setText("Catálogo");
        btnCatalogo1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCatalogo1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCatalogo1MouseClicked(evt);
            }
        });

        btnGuia1.setBackground(new java.awt.Color(188, 170, 164));
        btnGuia1.setFont(new java.awt.Font("Dialog", 1, 13)); // NOI18N
        btnGuia1.setForeground(new java.awt.Color(0, 0, 0));
        btnGuia1.setText("Guía");
        btnGuia1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuia1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnGuia1MouseClicked(evt);
            }
        });
        btnGuia1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuia1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblLogo)
                .addGap(54, 54, 54)
                .addComponent(btnProductos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuia1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCatalogo1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnIzquierda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnDerecha)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnProductos)
                    .addComponent(btnIzquierda)
                    .addComponent(btnDerecha)
                    .addComponent(btnCatalogo1)
                    .addComponent(btnGuia1))
                .addContainerGap())
        );

        jLabel1.setBackground(new java.awt.Color(93, 64, 55));
        jLabel1.setFont(new java.awt.Font("Microsoft JhengHei UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(93, 64, 55));
        jLabel1.setText("VINO DE CAFÉ");

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(215, 204, 200));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 18)); // NOI18N
        jTextArea1.setForeground(new java.awt.Color(0, 0, 0));
        jTextArea1.setRows(5);
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(93, 64, 55), new java.awt.Color(93, 64, 55), java.awt.Color.black, java.awt.Color.black));
        jScrollPane2.setViewportView(jTextArea1);

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(93, 64, 55));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Puedes visitar nuesra guia de fabricación casera en el apartado de arriba");

        jLabel3.setFont(new java.awt.Font("Microsoft JhengHei", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(93, 64, 55));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Si deseas reservar algun insumo, puedes pedirlo en nuestro catalogo");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(14, 14, 14))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(42, 42, 42))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProductosMouseClicked
        VistaProductos productos = new VistaProductos();
        productos.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnProductosMouseClicked

    private void btnIzquierdaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIzquierdaMouseClicked
        if (respuestaSesion && tipoUsuario == 2) {
            VistaMisReservas reservas = new VistaMisReservas();
            reservas.setVisible(true);
            this.dispose();
        } else {
            if (respuestaSesion && tipoUsuario == 1) {
                VistaReservasAdmin reservasAdmin = new VistaReservasAdmin();
                reservasAdmin.setVisible(true);
                this.dispose();
            } else {
                VistaIniciarSesion iniciarSesion = new VistaIniciarSesion();
                iniciarSesion.setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_btnIzquierdaMouseClicked

    private void btnDerechaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDerechaMouseClicked
        if (respuestaSesion) {
            ModeloSesion sesion = new ModeloSesion();
            sesion.setSesionActiva(false);
            Sesion actualizar = new Sesion();
            actualizar.ActualizarSesion(sesion);
            VistaPrincipal principal = new VistaPrincipal();
            principal.setVisible(true);
            this.dispose();
        } else {
            VistaRegistrarse registrarse = new VistaRegistrarse();
            registrarse.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_btnDerechaMouseClicked

    private void btnCatalogo1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCatalogo1MouseClicked
        VistaCatalogo catalogo = new VistaCatalogo();
        catalogo.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCatalogo1MouseClicked

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnGuia1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnGuia1MouseClicked
        VistaGuia guia = new VistaGuia();
        guia.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnGuia1MouseClicked

    private void btnGuia1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuia1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnGuia1ActionPerformed

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
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCatalogo1;
    private javax.swing.JButton btnDerecha;
    private javax.swing.JButton btnGuia1;
    private javax.swing.JButton btnIzquierda;
    private javax.swing.JButton btnProductos;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lblLogo;
    // End of variables declaration//GEN-END:variables
}
