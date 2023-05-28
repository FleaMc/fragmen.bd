/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gym;

import static Gym.GimnasioLosMejores.combo;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mich
 */
public class RegistroEntrenamiento extends javax.swing.JFrame {

    public RegistroEntrenamiento() throws SQLException {
        initComponents();
        Connect();
        Entrenamiento();
        limites();
    }

    Connection con;
    PreparedStatement pst;

    int c = 0;

    public void Connect() {
        String connection = "jdbc:sqlserver://localhost:1433;databaseName=Gym;integratedSecurity=true";

        try {
            con = DriverManager.getConnection(connection);
        } catch (SQLException ex) {
            Logger.getLogger(RegistroEntrenamiento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void limites() throws SQLException {
        tab tabla = new tab();
        String id = "";
        String nombreT = "Entrenamientos1";
        String nT = "";
        int acum = 1;
        int i = 0;
        int j = 0;
        boolean val = true;
        Object[] datos = new Object[3];
        while (val != false) {
            DatabaseMetaData dbm = con.getMetaData();
            ResultSet tables = dbm.getTables(null, null, nombreT, null);
            j = 0;
            if (tables.next()) {
                pst = con.prepareStatement("select * from " + nombreT + "");
                ResultSet rs = pst.executeQuery();

                datos[0] = nombreT;
                while (rs.next()) {

                    id = rs.getString(1);
                    if (id.equals("1")) {
                        j = j + 1;

                        datos[1] = "1";
                    }

                }
                j = j + 1;
                datos[2] = id;
                i = i + 1;
                acum = acum + 1;
                nT = Integer.toString(acum);
                nombreT = "Entrenamientos" + nT + "";
                tabla.tabla.addRow(datos);
            } else {
                val = false;
            }

        }

    }

    public void Entrenamiento() {
        try {
            pst = con.prepareStatement("select * from Entrenamientos1");
            ResultSet rs = pst.executeQuery();
            ResultSetMetaData RSM = rs.getMetaData();
            int c;
            c = RSM.getColumnCount();
            DefaultTableModel DF = (DefaultTableModel) jTable1.getModel();
            DF.setRowCount(0);
            String id = "";
            String tabla = "Entrenamientos1";
            int j = 1;
            int z = 1;
            int id2 = 5;
            boolean com = false;
            while (rs.next()) {
                Vector v2 = new Vector();
                for (int i = 1; i <= c; i++) {
                    id = rs.getString("Id");
                    if (tabla.equals("Entrenamientos1")) {
                        v2.add(rs.getString("Id"));

                    }

                    if (tabla.equals("Entrenamientos2")) {

                        if (id.equals("1")) {
                            v2.add(6);
                        }
                        if (id.equals("2")) {
                            v2.add(7);
                        }
                        if (id.equals("3")) {
                            v2.add(8);
                        }
                        if (id.equals("4")) {
                            v2.add(9);
                        }
                        if (id.equals("5")) {
                            v2.add(10);
                        }
                    }
                    if (tabla.equals("Entrenamientos3")) {
                        if (id.equals("1")) {
                            v2.add(11);
                        }
                        if (id.equals("2")) {
                            v2.add(12);
                        }
                        if (id.equals("3")) {
                            v2.add(13);
                        }
                        if (id.equals("4")) {
                            v2.add(14);
                        }
                        if (id.equals("5")) {
                            v2.add(15);
                        }
                    }
                    v2.add(rs.getString("Entrenamiento"));
                    v2.add(rs.getString("Horario"));
                    v2.add(rs.getString("Equipamiento"));

                }
                if (id.equals("5")) {
                    j = j + 1;
                    String t = Integer.toString(j);
                    tabla = "Entrenamientos" + t;
                    DatabaseMetaData dbm = con.getMetaData();
                    ResultSet tables = dbm.getTables(null, null, tabla, null);
                    if (tables.next()) {
                        z = z + 1;
                        pst = con.prepareStatement("select * from " + tabla + "");
                        rs = pst.executeQuery();
                        RSM = rs.getMetaData();
                    } else {
                    }
                }

                DF.addRow(v2);
                com = false;

            }
        } catch (SQLException ex) {
            Logger.getLogger(GimnasioLosMejores.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtEnt = new javax.swing.JTextField();
        txtHor = new javax.swing.JTextField();
        txtEqp = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bttnGuardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        bttnModificar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        bttnEnt = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        txtClean = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTip = new javax.swing.JLabel();
        txtFec = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Registro de entrenamiento");

        jLabel2.setFont(new java.awt.Font("Microsoft Sans Serif", 0, 11)); // NOI18N
        jLabel2.setText("Gimnasio LOS MEJORES");

        jLabel3.setText("Entrenamiento");

        jLabel4.setText("Horario");

        jLabel5.setText("Equipamiento especial");

        bttnGuardar.setBackground(new java.awt.Color(204, 255, 255));
        bttnGuardar.setText("Registrar nuevo");
        bttnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnGuardarActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 102, 102));
        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        bttnModificar.setBackground(new java.awt.Color(255, 255, 153));
        bttnModificar.setText("Modificar");
        bttnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnModificarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Entrenamiento", "Horario", "Equipamento"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        bttnEnt.setText("Backup");
        bttnEnt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttnEntActionPerformed(evt);
            }
        });

        jButton1.setText("Consulta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtClean.setText("Limpiar");
        txtClean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCleanActionPerformed(evt);
            }
        });

        jLabel6.setText("Nombre");

        jLabel7.setText("Fecha");

        txtTip.setText("jLabel8");

        txtFec.setText("jLabel9");

        jButton3.setText("metodo");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtEnt, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                .addComponent(txtHor)
                                .addComponent(txtEqp))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(72, 72, 72)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtTip, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bttnEnt)
                                    .addComponent(txtClean))
                                .addGap(120, 120, 120)
                                .addComponent(jLabel8)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtFec)
                        .addGap(26, 26, 26))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bttnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bttnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(96, 96, 96))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 947, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(148, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(txtTip)
                            .addComponent(txtFec))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(bttnGuardar)
                            .addComponent(txtClean))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtHor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jButton2)
                                    .addComponent(bttnEnt))
                                .addGap(34, 34, 34))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3)
                                .addGap(42, 42, 42)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtEqp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(bttnModificar)))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked

        DefaultTableModel d1 = (DefaultTableModel) jTable1.getModel();
        int SelectIndex = jTable1.getSelectedRow();
        txtEnt.setText(d1.getValueAt(SelectIndex, 1).toString());
        txtHor.setText(d1.getValueAt(SelectIndex, 2).toString());
        txtEqp.setText(d1.getValueAt(SelectIndex, 3).toString());


    }//GEN-LAST:event_jTable1MouseClicked


    private void bttnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnGuardarActionPerformed
        String Entrenamiento = txtEnt.getText();
        String Horario = txtHor.getText();
        String Equipamiento = txtEqp.getText();
        tab tabla = new tab();
        String id = "";
        String nombreT = "Entrenamientos1";
        int i = 0;
        int j = 1;
        int id2 = 0;
        boolean val = true;
        Object[] datos = new Object[3];
        try {
            datos[0] = nombreT;
            pst = con.prepareStatement("select * from " + nombreT + "");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                i = i + 1;
                id = rs.getString(1);
                id2 = Integer.parseInt(id);
                if (id.equals("1")) {
                    datos[1] = "1";
                }
                if (id2 == 5) {
                    datos[2] = "5";
                    id2 = 6;
                }
            }
            if (id2 <= 5) {
                pst = con.prepareStatement("insert into " + nombreT + "(Entrenamiento,Horario,Equipamiento)values(?,?,?)");
                pst.setString(1, Entrenamiento);
                pst.setString(2, Horario);
                pst.setString(3, Equipamiento);
                datos[2] = id2 + 1;
//                tabla.tabla.addRow(datos);
            } else {
                int jT = 0;
                j = j + 1;
                String j2 = Integer.toString(j);
                nombreT = "Entrenamientos" + j2;
                limites();
                String pasa = "no";
                while (val != false) {
                    if (tabla.tablaj.getRowCount() == 1 || pasa.equals("si")) {

//                    datos[0] = nombreT;
                        pst = con.prepareStatement("Create table  " + nombreT + "(Id int identity(1,1) not null primary key, Entrenamiento varchar (30),Horario varchar (20),Equipamiento varchar(35))");
                        pst.execute();
                        pst = con.prepareStatement("insert into " + nombreT + "(Entrenamiento,Horario,Equipamiento)values(?,?,?)");
                        pst.setString(1, Entrenamiento);
                        pst.setString(2, Horario);
                        pst.setString(3, Equipamiento);
                        val = false;

                    } else {
                        int limite2 = 0;
                        int tabAc = tabla.tablaj.getRowCount();

//                      
                        if (tabla.tablaj.getValueAt(tabAc - 1, 0).equals("Entrenamientos" + tabAc)) {
                            String limite = (String) tabla.tablaj.getValueAt(tabAc - 1, 2);

                            limite2 = Integer.parseInt(limite);
                            if (limite2 == 5) {
                                jT = 1 + tabAc;
                                j2 = Integer.toString(jT);

                                nombreT = "Entrenamientos" + j2;

                                pasa = "si";
                            }
                            if (limite2 < 5) {

                                nombreT = "Entrenamientos" + tabAc;
                                pst = con.prepareStatement("insert into " + nombreT + "(Entrenamiento,Horario,Equipamiento)values(?,?,?)");
                                pst.setString(1, Entrenamiento);
                                pst.setString(2, Horario);
                                pst.setString(3, Equipamiento);
                                val = false;
                            }
                        }
                    }
                }
            }
            int k = pst.executeUpdate();

            if (k == 1) {
                JOptionPane.showMessageDialog(this, "Registro añadido");
//                    combo.addItem(Entrenamiento);
                txtEnt.setText("");
                txtHor.setText("");
                txtEqp.setText("");
                txtEnt.requestFocus();
                Entrenamiento();
                limites();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error");
        }
    }//GEN-LAST:event_bttnGuardarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        DefaultTableModel d1 = (DefaultTableModel) jTable1.getModel();
        int SelectIndex = jTable1.getSelectedRow();
        String id = d1.getValueAt(SelectIndex, 0).toString();
        String ent = d1.getValueAt(SelectIndex, 1).toString();
        int id2 = Integer.parseInt(id);

        try {
            if (id2 > 0 && id2 < 6) {

                pst = con.prepareStatement("delete from Entrenamientos1 where Entrenamiento = ?");
                pst.setString(1, ent);
            }
            if (id2 > 5 && id2 < 11) {
                pst = con.prepareStatement("delete from Entrenamientos2 where Entrenamiento = ?");
                pst.setString(1, ent);
            }

            if (id2 > 10 && id2 < 15) {
                System.out.println(id2);
                pst = con.prepareStatement("delete from Entrenamientos3 where Entrenamiento = ?");
                pst.setString(1, ent);
            }

            int k = pst.executeUpdate();

            if (k == 1) {
                combo.removeItem(id);
                JOptionPane.showMessageDialog(this, "Entrenamiento eliminado");
                txtEnt.setText("");
                txtHor.setText("");
                txtEqp.setText("");
                txtEnt.requestFocus();
                Entrenamiento();
                bttnGuardar.setEnabled(true);

            } else {
                JOptionPane.showMessageDialog(this, "Fallo");
            }

        } catch (SQLException ex) {
            Logger.getLogger(RegistroEntrenamiento.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void bttnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnModificarActionPerformed
        {
            DefaultTableModel d1 = (DefaultTableModel) jTable1.getModel();
            int SelectIndex = jTable1.getSelectedRow();

            String idd = d1.getValueAt(SelectIndex, 0).toString();
            String id = d1.getValueAt(SelectIndex, 1).toString();
            int id2 = Integer.parseInt(idd);
            String Horario = txtHor.getText();
            String Equipamiento = txtEqp.getText();
            String Entrenamiento = txtEnt.getText();
            try {
                if (id2 > 0 && id2 < 6) {

                    pst = con.prepareStatement("update Entrenamientos1 set Entrenamiento =?,Equipamiento =? , Horario = ? where Entrenamiento = ?");
                    pst.setString(1, Entrenamiento);
                    pst.setString(2, Equipamiento);
                    pst.setString(3, Horario);
                    pst.setString(4, id);
                }
                if (id2 > 5 && id2 < 11) {
                    pst = con.prepareStatement("update Entrenamientos2 set Entrenamiento =?,Equipamiento =? , Horario = ? where Entrenamiento = ?");
                    pst.setString(1, Entrenamiento);
                    pst.setString(2, Equipamiento);
                    pst.setString(3, Horario);
                    pst.setString(4, id);
                }

                if (id2 > 10 && id2 < 15) {

                    pst = con.prepareStatement("update Entrenamientos3 set Entrenamiento =?,Equipamiento =? , Horario = ? where Entrenamiento = ?");
                    pst.setString(1, id);
                    pst.setString(2, Equipamiento);
                    pst.setString(3, Horario);
                    pst.setString(4, id);
                }
                int k = pst.executeUpdate();

                if (k == 1) {
                    JOptionPane.showMessageDialog(this, "Registro actualizado");
                    txtEnt.setText("");
                    txtHor.setText("");
                    txtEqp.setText("");

                    Entrenamiento();
                    bttnGuardar.setEnabled(true);

                } else {
                    JOptionPane.showMessageDialog(this, "Error al guardar");
                }

            } catch (SQLException ex) {
                Logger.getLogger(RegistroEntrenamiento.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_bttnModificarActionPerformed

    private void bttnEntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttnEntActionPerformed
        Backup ventana = new Backup();

        ventana.setVisible(true);

    }//GEN-LAST:event_bttnEntActionPerformed

    public int getC() {
        return c;
    }


    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Entrenamiento();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtCleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCleanActionPerformed
        bttnGuardar.setEnabled(true);
        Entrenamiento();
        txtEnt.setText("");
        txtEqp.setText("");
        txtHor.setText("");

    }//GEN-LAST:event_txtCleanActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
//        try {
//            limites();
//        } catch (SQLException ex) {
//            Logger.getLogger(RegistroEntrenamiento.class.getName()).log(Level.SEVERE, null, ex);
//        }

    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(RegistroEntrenamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistroEntrenamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistroEntrenamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistroEntrenamiento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new RegistroEntrenamiento().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(RegistroEntrenamiento.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton bttnEnt;
    private javax.swing.JButton bttnGuardar;
    public static javax.swing.JButton bttnModificar;
    private javax.swing.JButton jButton1;
    public static javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JButton txtClean;
    private javax.swing.JTextField txtEnt;
    private javax.swing.JTextField txtEqp;
    public static javax.swing.JLabel txtFec;
    private javax.swing.JTextField txtHor;
    public static javax.swing.JLabel txtTip;
    // End of variables declaration//GEN-END:variables
}
