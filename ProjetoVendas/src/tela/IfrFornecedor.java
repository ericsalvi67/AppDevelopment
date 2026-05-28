/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import apoio.ConexaoBD;
import dao.FornecedorDAO;
import entidade.Fornecedor;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class IfrFornecedor extends javax.swing.JInternalFrame {

    int ID = 0;

    public IfrFornecedor() {
        initComponents();
        GetAllData();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonClose = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFornecedor = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfdNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfdEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfdTelefone = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tfdCnpj = new javax.swing.JTextField();
        jButtonGet = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboFornecedor = new javax.swing.JComboBox<>();
        tfdBusca = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();

        setTitle("Cadastro: Fornecedor");

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

        tblFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Email", "Telefone", "CNPJ"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblFornecedor);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Listagem", jPanel1);

        jLabel1.setText("Nome");

        tfdNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdNomeActionPerformed(evt);
            }
        });

        jLabel2.setText("Email");

        jLabel4.setText("Telefone");

        jLabel5.setText("CNPJ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tfdTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(tfdEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(tfdNome, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tfdCnpj, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel2))
                .addContainerGap(279, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfdNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfdEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfdTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(tfdCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(190, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inserção", jPanel2);

        jButtonGet.setText("Consultar todos");
        jButtonGet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGetActionPerformed(evt);
            }
        });

        jLabel3.setText("Buscar");

        jComboFornecedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nome", "Email", "Telefone", "CNPJ" }));
        jComboFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboFornecedorActionPerformed(evt);
            }
        });

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

        btnEditar.setText("Editar");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnDeletar.setBackground(new java.awt.Color(200, 0, 0));
        btnDeletar.setText("Deletar");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
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
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfdBusca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSearch)
                .addGap(31, 31, 31))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfdBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearch))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 401, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonClose)
                    .addComponent(btnSalvar)
                    .addComponent(jButtonGet)
                    .addComponent(btnEditar)
                    .addComponent(btnDeletar))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }
    
    private void jButtonGetActionPerformed(java.awt.event.ActionEvent evt) {
        GetAllData();
    }
    
    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {
        ArrayList<Fornecedor> f = new ArrayList();
        String criterio = jComboFornecedor.getSelectedItem().toString();
        String valor = tfdBusca.getText();

        if (valor.isEmpty())
            return;

        f = new FornecedorDAO().consultar(criterio, valor);

        ExibitData(f);
    }
    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {

        if (tfdNome.getText().isEmpty()
                || tfdEmail.getText().isEmpty()
                || tfdTelefone.getText().isEmpty()
                || tfdCnpj.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não foi possível inserir os dados.");
            tfdNome.requestFocus();
            return;
        }

        Fornecedor f = new Fornecedor(
                ID,
                tfdNome.getText(),
                tfdEmail.getText(),
                tfdTelefone.getText(),
                tfdCnpj.getText());

        FornecedorDAO fornecedorDAO = new FornecedorDAO();

        int idGerado = -1;
        String logRegistro = null;

        if (ID == 0) {
            idGerado = Integer.parseInt(fornecedorDAO.salvar(f));
            logRegistro = "Registro salvo com sucesso! ID: " + idGerado;
        } else {
            idGerado = Integer.parseInt(fornecedorDAO.atualizar(f));
            logRegistro = "Registro atualizado com sucesso!";
        }

        if (idGerado >= 0) {
            ClearAllData();
            GetAllData();
            jTabbedPane1.setSelectedIndex(0);

            JOptionPane.showMessageDialog(this, logRegistro);
        } else {
            JOptionPane.showMessageDialog(this, "Problemas ao salvar registro! " + idGerado);
        }

        ID = 0;
    }
    
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
        String idTabela = String.valueOf(tblFornecedor.getValueAt(tblFornecedor.getSelectedRow(), 0));

        Fornecedor f = new FornecedorDAO().consultarId(Integer.parseInt(idTabela));

        ID = f.id;

        if (f != null) {
            jTabbedPane1.setSelectedIndex(1);

            tfdNome.setText(f.nome);
            tfdEmail.setText(f.email);
            tfdTelefone.setText(f.telefone);
            tfdCnpj.setText(f.cnpj);

            tfdNome.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Id da cidade não encontrado!");
        }
    }
    
    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {
        ArrayList<Fornecedor> f = new ArrayList();
        String idTabela = String.valueOf(tblFornecedor.getValueAt(tblFornecedor.getSelectedRow(), 0));

        ID = Integer.parseInt(idTabela);

        int resposta = JOptionPane.showConfirmDialog(
                this,
                "Deseja realmente excluir este registro?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {

            try {
                new FornecedorDAO().excluir(ID);
                JOptionPane.showMessageDialog(this, "Registro excluído com sucesso!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Problemas ao excluir registro!");
            }

            jTabbedPane1.setSelectedIndex(0);
            ClearAllData();
            GetAllData();
        }
        ID = 0;
    }

    private void tfdNomeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfdNomeActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_tfdNomeActionPerformed

    private void jComboFornecedorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboFornecedorActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jComboFornecedorActionPerformed

    private void tfdBuscaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfdBuscaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_tfdBuscaActionPerformed

    private void GetAllData(){
        ArrayList<Fornecedor> f = new ArrayList();

        f = new FornecedorDAO().consultarTodos();
        
        ExibitData(f);
    }
    
    private void ClearAllData(){
        tfdNome.setText("");
        tfdEmail.setText("");
        tfdTelefone.setText("");
        tfdCnpj.setText("");
    }
    
    private void ExibitData(ArrayList<Fornecedor> f){
        
        for (Fornecedor x : f) {
            System.out.println("Id: " + x.id);
            System.out.println("Nome: " + x.nome);
            System.out.println("Email: " + x.email);
            System.out.println("Telefone: " + x.telefone);
            System.out.println("CNPJ: " + x.cnpj);
            System.out.println("");
        }
        
        DefaultTableModel modelo = (DefaultTableModel) tblFornecedor.getModel();
        modelo.setRowCount(0);

        for (Fornecedor x : f) {
            modelo.addRow(new Object[] {
                    x.id,
                    x.nome,
                    x.email,
                    x.telefone,
                    x.cnpj
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonGet;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JComboBox<String> jComboFornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblFornecedor;
    private javax.swing.JTextField tfdBusca;
    private javax.swing.JTextField tfdCnpj;
    private javax.swing.JTextField tfdEmail;
    private javax.swing.JTextField tfdNome;
    private javax.swing.JTextField tfdTelefone;
    // End of variables declaration//GEN-END:variables
}
