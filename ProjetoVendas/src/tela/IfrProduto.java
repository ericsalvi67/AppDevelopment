/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import dao.FornecedorDAO;
import dao.ProdutoDAO;
import entidade.Fornecedor;
import entidade.Produto;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class IfrProduto extends javax.swing.JInternalFrame {

    int ID = 0;

    public IfrProduto() {
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
        tblProduto = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfdDescricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfdValor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfdQuantidade = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jComboFornecedor = new javax.swing.JComboBox<>();
        tfdBusca = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setTitle("Cadastro: Produto");

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

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Descrição", "Valor unitario", "Quantidade Estoque"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Float.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblProduto);

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

        jLabel1.setText("Descricao");

        tfdDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdDescricaoActionPerformed(evt);
            }
        });

        jLabel2.setText("Valor unitário");

        tfdValor.setToolTipText("");
        tfdValor.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        tfdValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfdValorActionPerformed(evt);
            }
        });

        jLabel4.setText("Quantidade");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(tfdQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfdValor, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tfdDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(254, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tfdDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfdValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(tfdQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(224, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inserção", jPanel2);

        jLabel3.setText("Buscar");

        jComboFornecedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Descricao" }));
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
                        .addGap(500, 500, 500)
                        .addComponent(btnDeletar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonClose))
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 818, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnEditar)
                        .addComponent(btnDeletar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonClose)
                        .addComponent(btnSalvar)))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonCloseActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
    }
    
    private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {
        ArrayList<Produto> p = new ArrayList();
        String criterio = jComboFornecedor.getSelectedItem().toString();
        String valor = tfdBusca.getText();

        if (valor.isEmpty())
            GetAllData();
        else{
            p = new ProdutoDAO().consultar(criterio, valor);
            ExibitData(p);
        }    
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        if (tfdDescricao.getText().isEmpty()
                || tfdValor.getText().isEmpty()
                || tfdQuantidade.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não foi possível salvar os dados.");
            tfdDescricao.requestFocus();
            return;
        }

        Produto p = new Produto(
                ID,
                tfdDescricao.getText(),
                Float.parseFloat(tfdValor.getText().replace(",", ".")),
                Integer.parseInt(tfdQuantidade.getText()));

        ProdutoDAO produtoDAO = new ProdutoDAO();
        int idGerado = -1;
        String logRegistro = null;

        if (ID == 0) {
            idGerado = Integer.parseInt(produtoDAO.salvar(p));
            logRegistro = "Registro salvo com sucesso! ID: " + idGerado;
        } else {
            idGerado = Integer.parseInt(produtoDAO.atualizar(p));
            logRegistro = "Registro atualizado com sucesso!";
        }

        if (idGerado >= 0) {
            ClearAllData();
            GetAllData();
            JOptionPane.showMessageDialog(this, logRegistro);

            jTabbedPane1.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(this, "Problemas ao salvar registro! " + idGerado);
        }
    }
    
    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {
        String idTabela = String.valueOf(tblProduto.getValueAt(tblProduto.getSelectedRow(), 0));

        Produto p = new ProdutoDAO().consultarId(Integer.parseInt(idTabela));

        ID = p.id;

        if (p != null) {
            jTabbedPane1.setSelectedIndex(1);

            tfdDescricao.setText(p.descricao);
            tfdValor.setText(String.valueOf(p.valor_unitario));
            tfdQuantidade.setText(String.valueOf(p.qtde_estoque));

            tfdDescricao.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Id da cidade não encontrado!");
        }
    }
    
    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {
        ArrayList<Produto> p = new ArrayList();
        String idTabela = String.valueOf(tblProduto.getValueAt(tblProduto.getSelectedRow(), 0));

        ID = Integer.parseInt(idTabela);

        int resposta = JOptionPane.showConfirmDialog(
                this,
                "Deseja realmente excluir este registro?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {

            try {
                new ProdutoDAO().excluir(ID);
                JOptionPane.showMessageDialog(this, "Registro excluído com sucesso!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Problemas ao excluir registro!");
            }

            jTabbedPane1.setSelectedIndex(0);
            ClearAllData();
            GetAllData();
        } else {
            JOptionPane.showMessageDialog(this, "Problemas ao excluir registro!");
        }
        ID = 0;
    }

    private void tfdDescricaoActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfdDescricaoActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_tfdDescricaoActionPerformed

    private void jComboFornecedorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboFornecedorActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jComboFornecedorActionPerformed

    private void tfdBuscaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfdBuscaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_tfdBuscaActionPerformed

    private void tfdValorActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfdValorActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_tfdValorActionPerformed
    
    private void GetAllData(){
        ArrayList<Produto> p = new ArrayList();

        p = new ProdutoDAO().consultarTodos();

        ExibitData(p);
    }
    
    private void ClearAllData(){
        tfdDescricao.setText("");
        tfdValor.setText("");
        tfdQuantidade.setText("");
    }
    
    private void ExibitData(ArrayList<Produto> p){
        for (Produto x : p) {
            System.out.println("Id: " + x.id);
            System.out.println("Descrição: " + x.descricao);
            System.out.println("Valor Unitário: " + x.valor_unitario);
            System.out.println("Qtde Estoque: " + x.qtde_estoque);
            System.out.println("");
        }
        
        DefaultTableModel modelo = (DefaultTableModel) tblProduto.getModel();
        modelo.setRowCount(0);

        for (Produto x : p) {
            modelo.addRow(new Object[] {
                    x.id,
                    x.descricao,
                    x.valor_unitario,
                    x.qtde_estoque
            });
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JComboBox<String> jComboFornecedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblProduto;
    private javax.swing.JTextField tfdBusca;
    private javax.swing.JTextField tfdDescricao;
    private javax.swing.JTextField tfdQuantidade;
    private javax.swing.JTextField tfdValor;
    // End of variables declaration//GEN-END:variables
}
