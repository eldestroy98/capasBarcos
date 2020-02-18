/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbccapas_165561;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Srneno
 */
public class FrameSocio extends javax.swing.JFrame {
    ConnectionFactory connectionFactory= new MySQLConnection("localhost","club nautico",3306,"root","1234");
       SocioDAO socioDao= new SocioDAOImp1(connectionFactory);
    
  DefaultTableModel tablaSocio;
    /**
     * Creates new form FrameSocio
     */
    public FrameSocio() {
        initComponents();
        this.TextoDni.setText("");
      this.TextoNombre.setText("");
      this.TextoId.setText("");
      this.TextoBuscar.setText("");
      
      
         tablaSocio =new DefaultTableModel();
        tablaSocio.addColumn("ID");
        tablaSocio.addColumn("DNI");
        tablaSocio.addColumn("Nombre");
        this.jTable1.setModel(tablaSocio);
        
        
        DefaultTableModel acumular= new DefaultTableModel();
         
         String user="root";
        
         String password="operation7";
        
        Connection con= null;
        
        Statement statement=null;
        
        ResultSet resultSet=null;
        
        try{
            //direccion de la base de datos de servidor
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/socios?serverTimezone=UTC",user,password);
            //estado de la base de datos
            statement = con.createStatement();
            resultSet=statement.executeQuery("SELECT * FROM socios");
            
            
            while(resultSet.next()){
                
                 String id=resultSet.getString("id");
                String dni = resultSet.getString("dni");
                String nombre = resultSet.getString("nombre");

                acumular = (DefaultTableModel) jTable1.getModel();
                Object[] obj = {id,dni,nombre};
                acumular.addRow(obj);
            }
            
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally{
           
            
           //finalmente cuando uses cualquier de estos se tiene que cerrar las conecciones
            if(resultSet!=null){
                try{
                    resultSet.close();
                }catch(SQLException ex){
                     System.out.println(ex.getMessage());
                }
            }
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                     System.out.println(ex.getMessage());
                }
            }
            if(con!=null){
                try{
                    con.close();
                }catch(SQLException ex){
                     System.out.println(ex.getMessage());
                }
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

        TextoBuscar = new javax.swing.JTextField();
        TextoId = new javax.swing.JTextField();
        TextoDni = new javax.swing.JTextField();
        TextoNombre = new javax.swing.JTextField();
        BotonGuardar = new javax.swing.JButton();
        BotonBorrar = new javax.swing.JButton();
        BotonSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        TextoBuscar.setBackground(new java.awt.Color(153, 153, 255));
        TextoBuscar.setForeground(new java.awt.Color(0, 0, 0));
        TextoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextoBuscarActionPerformed(evt);
            }
        });

        TextoId.setBackground(new java.awt.Color(153, 153, 255));
        TextoId.setForeground(new java.awt.Color(0, 0, 0));
        TextoId.setEnabled(false);

        TextoDni.setBackground(new java.awt.Color(153, 153, 255));
        TextoDni.setForeground(new java.awt.Color(0, 0, 0));

        TextoNombre.setBackground(new java.awt.Color(153, 153, 255));
        TextoNombre.setForeground(new java.awt.Color(0, 0, 0));
        TextoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextoNombreActionPerformed(evt);
            }
        });

        BotonGuardar.setText("GUARDAR");
        BotonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarActionPerformed(evt);
            }
        });

        BotonBorrar.setText("BORRAR");
        BotonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBorrarActionPerformed(evt);
            }
        });

        BotonSalir.setText("SALIR");
        BotonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonSalirActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 255));
        jLabel1.setText("ID:");
        jLabel1.setEnabled(false);

        jLabel2.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 255));
        jLabel2.setText("DNI:");

        jLabel3.setFont(new java.awt.Font("Berlin Sans FB Demi", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 255));
        jLabel3.setText("Nombre:");

        jButton4.setText("Buscar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(BotonGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(BotonBorrar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3))
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextoId)
                            .addComponent(TextoDni)
                            .addComponent(TextoNombre))
                        .addGap(10, 10, 10)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(BotonSalir)
                        .addGap(16, 16, 16))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(TextoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton4)
                .addGap(43, 43, 43))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextoBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextoDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TextoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotonGuardar)
                    .addComponent(BotonBorrar)
                    .addComponent(BotonSalir))
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TextoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoBuscarActionPerformed

    private void BotonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarActionPerformed
        if(this.TextoNombre.getText()!="" && this.TextoDni.getText()!=""){
           this.jTable1.removeAll();
        DefaultTableModel acumular= new DefaultTableModel();
         
         String user="root";
        
         String password="1234";
        
        Connection con= null;
        
        Statement statement=null;
        
        ResultSet resultSet=null;
        
        try{
            //direccion de la base de datos de servidor
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/socios?serverTimezone=UTC",user,password);
            //estado de la base de datos
            statement = con.createStatement();
            resultSet=statement.executeQuery("SELECT * FROM socios");
            
            
            while(resultSet.next()){
                
                 String id=resultSet.getString("id");
                String dni = resultSet.getString("dni");
                String nombre = resultSet.getString("nombre");

                acumular = (DefaultTableModel) jTable1.getModel();
                Object[] obj = {id,dni,nombre};
                acumular.addRow(obj);
            }
            //al final se agrega el nuevo objeto 
            Object[] ObjGuardar = {this.TextoId.getText(),this.TextoDni.getText(),this.TextoNombre.getText()};
            acumular.addRow(ObjGuardar);
            
            
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally{
           
            
           //finalmente cuando uses cualquier de estos se tiene que cerrar las conecciones
            if(resultSet!=null){
                try{
                    resultSet.close();
                }catch(SQLException ex){
                     System.out.println(ex.getMessage());
                }
            }
            if(statement!=null){
                try{
                    statement.close();
                }catch(SQLException ex){
                     System.out.println(ex.getMessage());
                }
            }
            if(con!=null){
                try{
                    con.close();
                }catch(SQLException ex){
                     System.out.println(ex.getMessage());
                }
            }
        } 
        }
    }//GEN-LAST:event_BotonGuardarActionPerformed

    private void BotonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonSalirActionPerformed
       dispose();
    }//GEN-LAST:event_BotonSalirActionPerformed

    private void TextoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoNombreActionPerformed

    private void BotonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBorrarActionPerformed
      this.TextoDni.setText("");
      this.TextoNombre.setText("");
      this.TextoId.setText("");
      this.TextoBuscar.setText("");
    }//GEN-LAST:event_BotonBorrarActionPerformed

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
            java.util.logging.Logger.getLogger(FrameSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameSocio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameSocio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonBorrar;
    private javax.swing.JButton BotonGuardar;
    private javax.swing.JButton BotonSalir;
    private javax.swing.JTextField TextoBuscar;
    private javax.swing.JTextField TextoDni;
    private javax.swing.JTextField TextoId;
    private javax.swing.JTextField TextoNombre;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}