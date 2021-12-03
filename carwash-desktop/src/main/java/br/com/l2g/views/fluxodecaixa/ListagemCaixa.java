/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.views.fluxodecaixa;

import br.com.l2g.model.FluxoDeCaixa;
import br.com.l2g.util.Environment;
import br.com.l2g.util.Util;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.URI;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import org.apache.http.HttpException;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;

/**
 *
 * @author lucas
 */
public class ListagemCaixa extends javax.swing.JInternalFrame {

    /**
     * Creates new form ListagemCaixa
     */
    
      private static final String URL_BASE = Environment.DEV.url();
      private static final String URL_PAGAMENTO = URL_BASE + "pagamento";
    
    public ListagemCaixa() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        comboColunasBox = new javax.swing.JComboBox<>();
        localizarText = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Tipo Pagamento", "Data", "Valor", "Nome"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(2).setPreferredWidth(20);
            jTable1.getColumnModel().getColumn(3).setPreferredWidth(20);
        }

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1479862814_Cancel.png"))); // NOI18N
        jButton4.setText("Cancelar");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/remover_free-27.png"))); // NOI18N
        jButton3.setText("Excluir");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/editar_free-07.png"))); // NOI18N
        jButton2.setText("Alterar");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton2.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/incluir_free-10.png"))); // NOI18N
        jButton1.setText("Incluir");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        comboColunasBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "TIpo De Pagamento", "Data ", "VAlor", "Nome " }));
        comboColunasBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboColunasBoxActionPerformed(evt);
            }
        });

        localizarText.setText("Pesquisar");
        localizarText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                localizarTextFocusGained(evt);
            }
        });
        localizarText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                localizarTextKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(362, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(comboColunasBox, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(localizarText, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 694, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboColunasBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(localizarText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 363, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton4)
                    .addComponent(jButton3)
                    .addComponent(jButton2)))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(38, 38, 38)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(65, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        DeletarValor();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        AlterarPagamento();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        IncluirFLuxoDeCAixa();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void localizarTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_localizarTextFocusGained
        localizarText.setText("");
        localizarText.selectAll();
    }//GEN-LAST:event_localizarTextFocusGained

    private void localizarTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_localizarTextKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            pesquisaPorColuna(localizarText.getText().trim(), comboColunasBox.getSelectedIndex());
        }
    }//GEN-LAST:event_localizarTextKeyPressed

    private void comboColunasBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboColunasBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboColunasBoxActionPerformed

    
     public void setPosicao() {
        Dimension d = this.getDesktopPane().getSize();
        this.setLocation((d.width - this.getSize().width) / 2, (d.height - this.getSize().height) / 2);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboColunasBox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField localizarText;
    // End of variables declaration//GEN-END:variables

    private void CarregaTabela() {
        try {
            limpaTabela();
            DefaultTableModel m = (DefaultTableModel) jTable1.getModel();
            DefaultTableModel Tmodel = m;
            int col = m.getColumnCount();
            Object[] objects = new Object[col];
            HttpGet get = new HttpGet(URL_PAGAMENTO);
            String resposta = Util.enviaRequest(get);
            List<FluxoDeCaixa> fluxodecaixa = Arrays.asList(Util.jsonToObject(resposta, FluxoDeCaixa[].class));
            for (FluxoDeCaixa f : fluxodecaixa) {
                objects[0] = f.getIdPagamento();
                objects[1] = f.getTipo();
                objects[2] = f.getData();
                objects[3] = f.getValor(); 
                objects[4] = f.getNome(); 
              

                Tmodel.addRow(objects);
                jTable1.setModel(Tmodel);

            }
        } catch (IOException | HttpException | NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | BadPaddingException | InvalidKeyException ex) {
            Logger.getLogger(FluxoDeCaixa.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void IncluirFLuxoDeCAixa() {
        CadastroCaixa view = new CadastroCaixa(null, true, "incluir");
        view.setVisible(true);
        CarregaTabela();
    }

    private void AlterarPagamento() {
        CadastroCaixa view = new CadastroCaixa(null, true, "editar");
        view.enviarCodigoSelecionado(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0).toString());
        view.setVisible(true);
        CarregaTabela();
    }

    private void DeletarValor() {
        try {
            Object[] options = {"Sim", "Não"};
            int opcao = JOptionPane.showOptionDialog(null, "Deseja excluir este registro?", "Excluir", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if (opcao == 0 || opcao == -1) {
                String url_id = URL_PAGAMENTO + "/" + jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0).toString();
                HttpDelete delete = new HttpDelete(url_id);
                String resposta = null;
                try {
                    resposta = Util.enviaRequest(delete);
                } catch (IOException ex) {
                    Logger.getLogger(ListagemCaixa.class.getName()).log(Level.SEVERE, null, ex);
                } catch (HttpException ex) {
                    Logger.getLogger(ListagemCaixa.class.getName()).log(Level.SEVERE, null, ex);
                } catch (NoSuchPaddingException ex) {
                    Logger.getLogger(ListagemCaixa.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalBlockSizeException ex) {
                    Logger.getLogger(ListagemCaixa.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(null, "Registro deleteado com sucesso!\n" + resposta, "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                CarregaTabela();
            }
        } catch (NoSuchAlgorithmException | BadPaddingException | InvalidKeyException ex) {
            Logger.getLogger(FluxoDeCaixa.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpaTabela() {
        DefaultTableModel m = (DefaultTableModel) jTable1.getModel();
        for (int a1 = m.getRowCount(); a1 > 0; --a1) {
            m.removeRow(a1 - 1);
        }
    }

    private void pesquisaPorColuna(String text, int pesq) {
        DefaultTableModel tabela = (DefaultTableModel) jTable1.getModel();
        final TableRowSorter<TableModel> sorter = new TableRowSorter<>(tabela);
        jTable1.setRowSorter(sorter);

        if (text.length() == 0) {
            sorter.setRowFilter(null);
        } else {
            try {
                sorter.setRowFilter(RowFilter.regexFilter("(?i)" + text, pesq));
            } catch (PatternSyntaxException pse) {
                System.out.print("Erro: " + pse);
            }
        }
    }


}
