/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import dao.EnderecoDAO;
import entidade.Endereco;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class IfrEndereco extends javax.swing.JInternalFrame {

    int ID = 0;

    public IfrEndereco() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonClose = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEndereco = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfdDescricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfdCep = new javax.swing.JTextField();
        jButtonGet = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboEndereco = new javax.swing.JComboBox();
        tfdBusca = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setTitle("Cadastro: Endereco");

        jButtonClose.setText("Fechar");
        jButtonClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCloseActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        tblEndereco.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {

                },
                new String[] {
                        "ID", "Descricao", "CEP"
                }) {
            Class[] types = new Class[] {
                    java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean[] {
                    false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblEndereco);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 811,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        jTabbedPane1.addTab("Listagem", jPanel1);

        jLabel1.setText("Descricao");

        tfdDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdDescricaoActionPerformed(evt);
            }
        });

        jLabel2.setText("CEP");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel2Layout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(tfdCep, javax.swing.GroupLayout.PREFERRED_SIZE, 466,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel2Layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(tfdDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 466,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(280, Short.MAX_VALUE)));
        jPanel2Layout.setVerticalGroup(
                jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(tfdDescricao, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(tfdCep, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(258, Short.MAX_VALUE)));

        jTabbedPane1.addTab("Inserção", jPanel2);

        jButtonGet.setText("Consultar");
        jButtonGet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGetActionPerformed(evt);
            }
        });

        jLabel3.setText("Buscar");

        jComboEndereco.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Descricao", "CEP" }));

        tfdBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdBuscaActionPerformed(evt);
            }
        });

        jButtonSearch.setText("Pesquisar");
        jButtonSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchActionPerformed(evt);
            }
        });

        btnDeletar.setBackground(new java.awt.Color(200, 0, 0));
        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButtonGet)
                                                .addGap(419, 419, 419)
                                                .addComponent(btnDeletar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnEditar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSalvar)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButtonClose))
                                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 818,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(19, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jComboEndereco, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfdBusca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonSearch)
                                .addGap(31, 31, 31)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jComboEndereco, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(tfdBusca, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonSearch))
                                .addGap(18, 18, 18)
                                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(btnEditar)
                                                .addComponent(btnDeletar))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jButtonClose)
                                                .addComponent(btnSalvar)
                                                .addComponent(jButtonGet)))
                                .addGap(19, 19, 19)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnDeletarActionPerformed
        ArrayList<Endereco> e = new ArrayList();
        String idTabela = String.valueOf(tblEndereco.getValueAt(tblEndereco.getSelectedRow(), 0));

        ID = Integer.parseInt(idTabela);

        int resposta = JOptionPane.showConfirmDialog(
                this,
                "Deseja realmente excluir este registro?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {

            try {
                new EnderecoDAO().excluir(ID);
                JOptionPane.showMessageDialog(this, "Registro excluído com sucesso!");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Problemas ao excluir registro!");
            }

            e = new EnderecoDAO().consultarTodos();

            DefaultTableModel modelo = (DefaultTableModel) tblEndereco.getModel();
            modelo.setRowCount(0);

            for (Endereco x : e) {
                modelo.addRow(new Object[] {
                        x.id,
                        x.descricao,
                        x.cep
                });
            }
        } else {
            JOptionPane.showMessageDialog(this, "Problemas ao excluir registro!");
        }

        ID = 0;
    }// GEN-LAST:event_btnDeletarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnEditarActionPerformed
        String idTabela = String.valueOf(tblEndereco.getValueAt(tblEndereco.getSelectedRow(), 0));

        Endereco e = new EnderecoDAO().consultarId(Integer.parseInt(idTabela));

        ID = e.id;

        if (e != null) {
            jTabbedPane1.setSelectedIndex(1);

            tfdDescricao.setText(e.descricao);
            tfdCep.setText(e.cep);

            tfdDescricao.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Id da cidade não encontrado!");
        }
    }// GEN-LAST:event_btnEditarActionPerformed

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonCloseActionPerformed
        this.dispose();
    }// GEN-LAST:event_jButtonCloseActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalvarActionPerformed

        if (tfdDescricao.getText().isEmpty()
                || tfdCep.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não foi possível inserir os dados.");
            tfdDescricao.requestFocus();
            return;
        }

        Endereco e = new Endereco(
                ID,
                tfdDescricao.getText(),
                tfdCep.getText());

        EnderecoDAO enderecoDAO = new EnderecoDAO();

        int idGerado = -1;
        String id = null;

        if (ID == 0) {
            enderecoDAO.salvar(e);
        } else {
            enderecoDAO.atualizar(e);
        }

        try {
            idGerado = Integer.parseInt(id);
        } catch (Exception ex) {
            idGerado = -1;
        }

        if (idGerado > 0) {
            tfdDescricao.setText("");
            tfdCep.setText("");

            JOptionPane.showMessageDialog(this, "Registro salvo com sucesso! ID: " + idGerado);
            tfdDescricao.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Problemas ao salvar registro!");
        }
    }// GEN-LAST:event_btnSalvarActionPerformed

    private void jButtonGetActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonGetActionPerformed
        ArrayList<Endereco> e = new ArrayList<>();

        e = new EnderecoDAO().consultarTodos();

        DefaultTableModel modelo = (DefaultTableModel) tblEndereco.getModel();
        modelo.setRowCount(0);

        for (Endereco x : e) {
            modelo.addRow(new Object[] {
                    x.id,
                    x.descricao,
                    x.cep
            });
        }
    }// GEN-LAST:event_jButtonGetActionPerformed

    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonSearchActionPerformed
        ArrayList<Endereco> e = new ArrayList<>();
        String criterio = jComboEndereco.getSelectedItem().toString();
        String valor = tfdBusca.getText();

        if (valor.isEmpty()) {
            return;
        }

        e = new EnderecoDAO().consultar(criterio, valor);

        DefaultTableModel modelo = (DefaultTableModel) tblEndereco.getModel();
        modelo.setRowCount(0);

        for (Endereco x : e) {
            modelo.addRow(new Object[] {
                    x.id,
                    x.descricao,
                    x.cep
            });
        }
    }// GEN-LAST:event_jButtonSearchActionPerformed

    private void tfdDescricaoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfdDescricaoActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_tfdDescricaoActionPerformed

    private void tfdBuscaActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonGet;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JComboBox jComboEndereco;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblEndereco;
    private javax.swing.JTextField tfdBusca;
    private javax.swing.JTextField tfdCep;
    private javax.swing.JTextField tfdDescricao;
    // End of variables declaration//GEN-END:variables
}
