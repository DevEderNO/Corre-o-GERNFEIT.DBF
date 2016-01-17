/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controle.GernfeitCO;
import Dao.gernfeitDao;
import Modelo.gernfeitTO;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Masterkaos
 */
public class Tela_ConsultaGernfeit extends javax.swing.JFrame {

    private Tela_EditarGernfeit tEditar = new Tela_EditarGernfeit();

    public Tela_ConsultaGernfeit() throws SQLException, ClassNotFoundException {
        initComponents();
        listarAluno();
        setLocationRelativeTo(null);
    }

    private void corrigirErros() throws ClassNotFoundException, SQLException {
        int tLinha = tabela.getRowCount();
        int cont = 0;
        GernfeitCO ctrl = new GernfeitCO();
        for (int i = 0; i < tLinha; i++) {
            boolean s = (boolean) tabela.getValueAt(i, 9);
            if (s) {
                if (cont < 400) {
                    String num_nfe = tabela.getValueAt(i, 0).toString();
                    String mod_nfece = tabela.getValueAt(i, 1).toString();
                    String num_seq = tabela.getValueAt(i, 2).toString();
                    String des_prod = tabela.getValueAt(i, 3).toString();
                    int qtde_prod = Integer.parseInt(tabela.getValueAt(i, 4).toString());
                    double val_unit = Double.parseDouble(tabela.getValueAt(i, 5).toString());
                    double val_desc = Double.parseDouble(tabela.getValueAt(i, 6).toString());
                    double val_total = Double.parseDouble(tabela.getValueAt(i, 8).toString());
                    ctrl.dadosTabela(num_nfe, mod_nfece, num_seq, des_prod, qtde_prod, val_unit, val_desc, val_total);
                    cont++;
                } else if (cont > 399) {
                    JOptionPane.showMessageDialog(null, "O sistema só permite correção de 400 notas por vez \n"
                            + "feche e abra o sistema para continuar...");
                    i = tLinha;
                }
            }
            if(i==tLinha-1 && cont<400){
                JOptionPane.showMessageDialog(null, "Todas as notas foram corrigidas !!!");
            }

        }
        this.dispose();
    }

    private void listarAluno() throws SQLException, ClassNotFoundException {
        DefaultTableModel modelo = (DefaultTableModel) tabela.getModel();
        gernfeitDao dao = new gernfeitDao();
        BigDecimal bd;
        boolean s = true;
        tabela.getColumnModel().getColumn(0).setPreferredWidth(150);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(400);
        ArrayList<gernfeitTO> listaAluno = dao.listarAluno();
        for (gernfeitTO ger : listaAluno) {
            double d = ger.getQtde_prod() * ger.getVal_unit() - ger.getVal_desc();
            bd = new BigDecimal(d).setScale(2, RoundingMode.HALF_EVEN);
            if (ger.getVal_total() == bd.doubleValue()) {
                s = false;
            }
            Object[] lista = {ger.getNum_nfe(),
                ger.getMod_nfece(),
                ger.getNum_seq(),
                ger.getDes_prod(),
                ger.getQtde_prod(),
                ger.getVal_unit(),
                ger.getVal_desc(),
                ger.getVal_total(),
                (ger.getQtde_prod() * ger.getVal_unit()) - ger.getVal_desc(), s};
            modelo.addRow(lista);
            s = true;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        bt_corrigir = new javax.swing.JButton();
        bt_cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tabela.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NUMR_NFE", "MODL_NFECE", "NUMR_SEQIT ", "DESC_PRODU ", "QTDE_PRODT ", "VALR_UNITT ", "VALR_DESCN ", "VALR_TOTAL ", "VALR_TOTAL CORRETO", "S"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Double.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabela.getTableHeader().setReorderingAllowed(false);
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabela);

        bt_corrigir.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_corrigir.setText("Corrigir");
        bt_corrigir.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                bt_corrigirMouseDragged(evt);
            }
        });
        bt_corrigir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_corrigirMouseClicked(evt);
            }
        });

        bt_cancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bt_cancelar.setText("Cancelar");
        bt_cancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bt_cancelarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 850, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(bt_cancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_corrigir)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 449, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_corrigir)
                    .addComponent(bt_cancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_cancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_cancelarMouseClicked
        this.dispose();
    }//GEN-LAST:event_bt_cancelarMouseClicked

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked

    }//GEN-LAST:event_jScrollPane1MouseClicked

    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        if (evt.getClickCount() > 1) {
            int linhaSelecionada = tabela.getSelectedRow();
            System.out.println(linhaSelecionada);
            String num_nfe = tabela.getValueAt(linhaSelecionada, 0).toString();
            String mod_nfece = tabela.getValueAt(linhaSelecionada, 1).toString();
            String num_seq = tabela.getValueAt(linhaSelecionada, 2).toString();
            String des_prod = tabela.getValueAt(linhaSelecionada, 3).toString();
            String qtde_prod = tabela.getValueAt(linhaSelecionada, 4).toString();
            String val_unit = tabela.getValueAt(linhaSelecionada, 5).toString();
            String val_desc = tabela.getValueAt(linhaSelecionada, 6).toString();
            String val_total = tabela.getValueAt(linhaSelecionada, 8).toString();
            tEditar.setVisible(true);
            tEditar.editarGernfeit(num_nfe, mod_nfece, num_seq, des_prod, qtde_prod, val_unit, val_desc, val_total);
            this.dispose();
        }
    }//GEN-LAST:event_tabelaMouseClicked

    private void bt_corrigirMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_corrigirMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_bt_corrigirMouseDragged

    private void bt_corrigirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bt_corrigirMouseClicked

        try {
            corrigirErros();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Tela_ConsultaGernfeit.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_bt_corrigirMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_cancelar;
    private javax.swing.JButton bt_corrigir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabela;
    // End of variables declaration//GEN-END:variables
}
