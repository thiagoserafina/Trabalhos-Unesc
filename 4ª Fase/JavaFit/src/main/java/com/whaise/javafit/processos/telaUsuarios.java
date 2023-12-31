/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.whaise.javafit.processos;

import com.whaise.javafit.Banco;
import com.whaise.javafit.Get.GetUsuario;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author henry
 */
public class telaUsuarios extends javax.swing.JFrame {
    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public telaUsuarios() {
        initComponents();
        con = Banco.ConectarDB();
        mostra_lista();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        edtNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        edtLogin = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        edtSenha = new javax.swing.JPasswordField();
        btnAdd = new javax.swing.JButton();
        btnExc = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();

        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "LOGIN"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabela.setFocusable(false);
        jScrollPane2.setViewportView(Tabela);

        jLabel1.setFont(new java.awt.Font("Comfortaa", 1, 24)); // NOI18N
        jLabel1.setText("USUÁRIOS");

        jLabel2.setFont(new java.awt.Font("Comfortaa", 1, 24)); // NOI18N
        jLabel2.setText("CADASTRO");

        edtNome.setFont(new java.awt.Font("Hack", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Hack", 0, 16)); // NOI18N
        jLabel3.setText("Nome:");

        jLabel4.setFont(new java.awt.Font("Hack", 0, 16)); // NOI18N
        jLabel4.setText("Login:");

        edtLogin.setFont(new java.awt.Font("Hack", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Hack", 0, 16)); // NOI18N
        jLabel5.setText("Senha:");

        edtSenha.setFont(new java.awt.Font("Hack", 0, 18)); // NOI18N

        btnAdd.setBackground(new java.awt.Color(51, 204, 0));
        btnAdd.setFont(new java.awt.Font("Hack", 0, 18)); // NOI18N
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/whaise/javafit/img/check.png"))); // NOI18N
        btnAdd.setText("Adicionar");
        btnAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAddMouseClicked(evt);
            }
        });

        btnExc.setBackground(new java.awt.Color(204, 0, 0));
        btnExc.setFont(new java.awt.Font("Hack", 0, 18)); // NOI18N
        btnExc.setForeground(new java.awt.Color(255, 255, 255));
        btnExc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/whaise/javafit/img/cross.png"))); // NOI18N
        btnExc.setText("Excluir");
        btnExc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnExcMouseClicked(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 52, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(73, 73, 73)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(4, 4, 4)
                                                .addComponent(jLabel1))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel3)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(edtLogin)
                                    .addComponent(edtSenha, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(edtNome)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel4))
                                        .addGap(0, 0, Short.MAX_VALUE)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnExc)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 444, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(edtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExc, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAddMouseClicked
        String sql_gerador = "select * from USUARIO order by ID_USUARIO DESC";
        String sql_inserir = "insert into USUARIO values(?,?,?,?)";
        String gen;
        if (edtNome.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nome Vazio");
        }
        else if (edtLogin.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Login Vazio");
        }
        else if (edtSenha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Senha Vazia");
        }
        else {
            try{
                pst = con.prepareStatement(sql_gerador);
                rs = pst.executeQuery();
                if(rs.next()){
                    gen = Integer.toString(rs.getInt("id_usuario")+1);
                }
                else {
                    gen = "1";
                }
                pst = con.prepareStatement(sql_inserir);
                pst.setString(1, gen);
                pst.setString(2, edtNome.getText());
                pst.setString(3, edtLogin.getText());
                pst.setString(4, edtSenha.getText());
                pst.executeUpdate();
                mostra_lista();
                edtLogin.setText("");
                edtNome.setText("");
                edtSenha.setText("");
            }
            catch(Exception e){
              System.out.println("Erro: " + e.getMessage());
            }
        }
        
    }//GEN-LAST:event_btnAddMouseClicked

    private void btnExcMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnExcMouseClicked
        String id = Tabela.getModel().getValueAt(Tabela.getSelectedRow(), 0).toString();
        String sql_delete = "delete from USUARIO where ID_USUARIO = ?";
        try{
            pst = con.prepareStatement(sql_delete);
            pst.setString(1, id);
            pst.executeUpdate();
            mostra_lista();
        }
        catch(Exception e){
            
        }
    }//GEN-LAST:event_btnExcMouseClicked

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
            java.util.logging.Logger.getLogger(telaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaUsuarios().setVisible(true);
            }
        });
    }
    
    public ArrayList<GetUsuario> ListaUsuario(){
        ArrayList<GetUsuario> ListaUsuario = new ArrayList<>();
        String sql = "select * from usuario";
        try{
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            GetUsuario usuario;
            while(rs.next()){
                usuario = new GetUsuario(rs.getString("id_usuario"),rs.getString("ds_usuario"),rs.getString("ds_login"));
                ListaUsuario.add(usuario);
            }
        }
        catch(Exception e){
            
        }
        return ListaUsuario;
    }
    
    public void mostra_lista(){
        ArrayList<GetUsuario> lista = ListaUsuario();
        DefaultTableModel modelo = (DefaultTableModel)Tabela.getModel();
        Object[] campos = new Object[3];
        modelo.setRowCount(0);
        for(int i=0;i<lista.size();i++){
            campos[0] = lista.get(i).GetGen();
            campos[1] = lista.get(i).GetNome();
            campos[2] = lista.get(i).GetLogin();
            modelo.addRow(campos);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabela;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnExc;
    private javax.swing.JTextField edtLogin;
    private javax.swing.JTextField edtNome;
    private javax.swing.JPasswordField edtSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
