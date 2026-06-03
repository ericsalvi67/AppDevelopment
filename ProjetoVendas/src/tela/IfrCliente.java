/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tela;

import apoio.ConexaoBD;
import apoio.Formatacao;
import apoio.Validacao;
import dao.ClienteDAO;
import entidade.Cliente;
import java.awt.Color;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class IfrCliente extends javax.swing.JInternalFrame {

    int ID = 0;

    public IfrCliente() {
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
        tblCliente = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfdNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfdEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tfdTelefone = new javax.swing.JFormattedTextField();
        tfdCpf = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        cmbEndereco = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jComboCliente = new javax.swing.JComboBox<>();
        tfdBusca = new javax.swing.JTextField();
        jButtonSearch = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();

        setResizable(true);
        setTitle("Cadastro: Cliente");

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

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nome", "Email", "Telefone", "CPF", "Endereco"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblCliente);

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

        jLabel5.setText("CPF");

        tfdCpf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfdCpfFocusLost(evt);
            }
        });

        jLabel6.setText("Endereco");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbEndereco, 0, 461, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(tfdNome, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tfdTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, 458, Short.MAX_VALUE)
                            .addComponent(tfdEmail)
                            .addComponent(tfdCpf)))
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)))
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
                    .addComponent(tfdCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(cmbEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(156, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Inserção", jPanel2);

        jLabel3.setText("Buscar");

        jComboCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ID", "Nome", "Email", "Telefone", "CPF" }));
        jComboCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboClienteActionPerformed(evt);
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
                .addComponent(jComboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(jComboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
    
        private void jButtonSearchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButtonSearchActionPerformed
        ArrayList<Cliente> c = new ArrayList();
        String criterio = jComboCliente.getSelectedItem().toString();
        String valor = tfdBusca.getText();
        
        if (valor.isEmpty())
            GetAllData();
        else {
            c = new ClienteDAO().consultar(criterio, valor);

            ExibitData(c);
        }        
    }

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSalvarActionPerformed

        if (tfdNome.getText().isEmpty()
                || tfdEmail.getText().isEmpty()
                || tfdTelefone.getText().isEmpty()
                || tfdCpf.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Não foi possível inserir os dados.");
            tfdNome.requestFocus();
            return;
        }

        Cliente c = new Cliente(
                ID,
                tfdNome.getText(),
                tfdEmail.getText(),
                tfdTelefone.getText(),
                tfdCpf.getText());

        ClienteDAO clienteDAO = new ClienteDAO();

        int idGerado = -1;
        String logRegistro = null;
        
        if (ID == 0) {
            idGerado = Integer.parseInt(clienteDAO.salvar(c));
            logRegistro = "Registro salvo com sucesso! ID: " + idGerado;
        } else {
            idGerado = Integer.parseInt(clienteDAO.atualizar(c));
            logRegistro = "Registro salvo com sucesso!";
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
        String idTabela = String.valueOf(tblCliente.getValueAt(tblCliente.getSelectedRow(), 0));

        Cliente c = new ClienteDAO().consultarId(Integer.parseInt(idTabela));

        ID = c.id;

        if (c != null) {
            jTabbedPane1.setSelectedIndex(1);

            tfdNome.setText(c.nome);
            tfdEmail.setText(c.email);
            tfdTelefone.setText(c.telefone);
            tfdCpf.setText(c.cpf);

            tfdNome.requestFocus();
        } else {
            JOptionPane.showMessageDialog(this, "Id da cidade não encontrado!");
        }
    }
    
    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {
        ArrayList<Cliente> c = new ArrayList();
        String idTabela = String.valueOf(tblCliente.getValueAt(tblCliente.getSelectedRow(), 0));

        ID = Integer.parseInt(idTabela);

        int resposta = JOptionPane.showConfirmDialog(
                this,
                "Deseja realmente excluir este registro?",
                "Confirmação",
                JOptionPane.YES_NO_OPTION);

        if (resposta == JOptionPane.YES_OPTION) {

            try {
                new ClienteDAO().excluir(ID);
                JOptionPane.showMessageDialog(this, "Registro excluído com sucesso!");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, "Problemas ao excluir registro!");
            }
           
            ClearAllData();
            GetAllData();
            jTabbedPane1.setSelectedIndex(0);
        } else {
            JOptionPane.showMessageDialog(this, "Problemas ao excluir registro!");
        }
        ID = 0;
    }

    private void tfdNomeActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfdNomeActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_tfdNomeActionPerformed

    private void jComboClienteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jComboClienteActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jComboClienteActionPerformed

    private void tfdBuscaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_tfdBuscaActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_tfdBuscaActionPerformed
    
    private void tfdCpfFocusLost(java.awt.event.FocusEvent evt) {// GEN-FIRST:event_tfdCnpjFocusLost
        if (!Validacao.validarCNPJ(Formatacao.removerFormatacao(tfdCpf.getText()))) {
            tfdCpf.setBackground(Color.ORANGE);
        } else {
            tfdCpf.setBackground(Color.WHITE);
        }
    }
    
    private void tfdTelefoneFocusLost(java.awt.event.FocusEvent evt) {
        if (!Validacao.validarTelefone(tfdTelefone)) {
            tfdTelefone.setBackground(Color.ORANGE);
        } else {
            tfdTelefone.setBackground(Color.WHITE);
        }
    }
    
    private void GetAllData(){
        ArrayList<Cliente> p = new ArrayList();

        p = new ClienteDAO().consultarTodos();

        ExibitData(p);
    }
    
    private void ClearAllData(){
        tfdNome.setText("");
        tfdTelefone.setText("");
        tfdCpf.setText("");
    }
    
    private void ExibitData(ArrayList<Cliente> c){
        for (Cliente x : c) {
            System.out.println("Id: " + x.id);
            System.out.println("Nome: " + x.nome);
            System.out.println("Telefone: " + x.telefone);
            System.out.println("CPF: " + x.cpf);
            System.out.println("");
        }
        
        DefaultTableModel modelo = (DefaultTableModel) tblCliente.getModel();
        modelo.setRowCount(0);

        for (Cliente x : c) {
            modelo.addRow(new Object[] {
                    x.id,
                    x.nome,
                    x.email,
                    x.telefone,
                    x.cpf
            });
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cmbEndereco;
    private javax.swing.JButton jButtonClose;
    private javax.swing.JButton jButtonSearch;
    private javax.swing.JComboBox<String> jComboCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblCliente;
    private javax.swing.JTextField tfdBusca;
    private javax.swing.JFormattedTextField tfdCpf;
    private javax.swing.JTextField tfdEmail;
    private javax.swing.JTextField tfdNome;
    private javax.swing.JFormattedTextField tfdTelefone;
    // End of variables declaration//GEN-END:variables
}
