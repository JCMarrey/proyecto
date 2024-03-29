
package VIEW;

import CONTROLLER.OAutentificacion;
/**
 *
 * @author juanm
 */
public class GUI_Autentificacion extends javax.swing.JFrame {

    /**
     * Creates new form GUI_Autentificacion
     */
    
    OAutentificacion oyenteAutentificacion;
    
    public GUI_Autentificacion() {
        
        initComponents();
        oyenteAutentificacion = new OAutentificacion(this,BTCambioC,BTSesion, BTregistrar,BTregresar);
        BTCambioC.addActionListener(oyenteAutentificacion);
        BTSesion.addActionListener(oyenteAutentificacion);
        BTregistrar.addActionListener(oyenteAutentificacion);
        BTregresar.addActionListener(oyenteAutentificacion);
        setLocationRelativeTo(null); //centrar el frame
           
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        contraseña = new javax.swing.JPasswordField();
        jLabel8 = new javax.swing.JLabel();
        BTSesion = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        usuario = new javax.swing.JFormattedTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        BTregistrar = new javax.swing.JButton();
        BTCambioC = new javax.swing.JButton();
        BTregresar = new javax.swing.JButton();

        jButton3.setBackground(new java.awt.Color(240, 240, 240));
        jButton3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Iniciar sesión");
        jButton3.setBorder(null);
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("BLACK PANTHERS");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SING UP");
        setResizable(false);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pantera-fuerte-1_1975-361.jpg"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 0, 312, 281);

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("GYM");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 330, 266, 27);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("BLACK PANTHERS");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(12, 293, 266, 27);

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, 0));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 153, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Iniciar Sesión");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 60, 220, 60));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(51, 51, 51));
        jLabel5.setText("Selecione el tipo de usuario, por favor.");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 220, 20));

        contraseña.setBackground(new java.awt.Color(255, 255, 255));
        contraseña.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        contraseña.setForeground(new java.awt.Color(51, 51, 51));
        contraseña.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        contraseña.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        jPanel3.add(contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 270, 220, 30));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Contraseña");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 250, 70, 20));

        BTSesion.setBackground(new java.awt.Color(240, 240, 240));
        BTSesion.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        BTSesion.setForeground(new java.awt.Color(51, 51, 255));
        BTSesion.setText("Iniciar sesión");
        BTSesion.setBorder(null);
        BTSesion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTSesionActionPerformed(evt);
            }
        });
        jPanel3.add(BTSesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 340, 100, 40));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setForeground(new java.awt.Color(51, 51, 51));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pantera-fuerte-1_1975-361.jpg"))); // NOI18N
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 12, 276, 278));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("BLACK PANTHERS");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 293, -1, 27));

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Copperplate Gothic Bold", 1, 24)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("GYM");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, 266, 27));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, -1));

        usuario.setBackground(new java.awt.Color(255, 255, 255));
        usuario.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(51, 51, 51)));
        usuario.setForeground(new java.awt.Color(51, 51, 51));
        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });
        jPanel3.add(usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 210, 220, 30));

        jComboBox1.setBackground(new java.awt.Color(204, 255, 255));
        jComboBox1.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jComboBox1.setForeground(new java.awt.Color(51, 51, 51));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Socio", "Entrenador" }));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        jPanel3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 150, 140, 30));

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("Usuario");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 190, 50, 20));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BTregistrar.setBackground(new java.awt.Color(240, 240, 240));
        BTregistrar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        BTregistrar.setForeground(new java.awt.Color(51, 51, 255));
        BTregistrar.setText("RegistrarUsuario");
        BTregistrar.setBorder(null);
        BTregistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTregistrarActionPerformed(evt);
            }
        });
        jPanel5.add(BTregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 40));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 130, 40));

        BTCambioC.setBackground(new java.awt.Color(255, 255, 255));
        BTCambioC.setForeground(new java.awt.Color(0, 0, 0));
        BTCambioC.setText("¿Olvidaste tu contraseña?");
        BTCambioC.setBorder(null);
        BTCambioC.setBorderPainted(false);
        BTCambioC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(BTCambioC, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, 170, 20));

        BTregresar.setBackground(new java.awt.Color(255, 255, 255));
        BTregresar.setForeground(new java.awt.Color(0, 0, 0));
        BTregresar.setText("Regresar");
        BTregresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));
        BTregresar.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        BTregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTregresarActionPerformed(evt);
            }
        });
        jPanel3.add(BTregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        BTregistrar.setBackground(new java.awt.Color(240, 240, 240));
        BTregistrar.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        BTregistrar.setForeground(new java.awt.Color(51, 51, 255));
        BTregistrar.setText("RegistrarUsuario");
        BTregistrar.setBorder(null);
        BTregistrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BTregistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTregistrarActionPerformed(evt);
            }
        });
        jPanel5.add(BTregistrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 40));

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 340, 130, 40));

        BTCambioC.setBackground(new java.awt.Color(255, 255, 255));
        BTCambioC.setForeground(new java.awt.Color(0, 0, 0));
        BTCambioC.setText("¿Olvidaste tu contraseña?");
        BTCambioC.setBorder(null);
        BTCambioC.setBorderPainted(false);
        BTCambioC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(BTCambioC, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 310, 170, 20));

        BTregresar.setBackground(new java.awt.Color(255, 255, 255));
        BTregresar.setForeground(new java.awt.Color(0, 0, 0));
        BTregresar.setText("Regresar");
        BTregresar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 51)));
        BTregresar.setCursor(new java.awt.Cursor(java.awt.Cursor.WAIT_CURSOR));
        BTregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BTregresarActionPerformed(evt);
            }
        });
        jPanel3.add(BTregresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(697, 487));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioActionPerformed

    private void BTSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTSesionActionPerformed

    }//GEN-LAST:event_BTSesionActionPerformed

    private void BTregistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTregistrarActionPerformed
        
    }//GEN-LAST:event_BTregistrarActionPerformed

    private void BTregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BTregresarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BTregresarActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_AgregarProducto_G.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_AgregarProducto_G.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_AgregarProducto_G.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_AgregarProducto_G.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new GUI_Autentificacion().setVisible(true);
        });
    
     }  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BTCambioC;
    private javax.swing.JButton BTSesion;
    private javax.swing.JButton BTregistrar;
    private javax.swing.JButton BTregresar;
    private javax.swing.JPasswordField contraseña;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JFormattedTextField usuario;
    // End of variables declaration//GEN-END:variables
}
