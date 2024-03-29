/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.views.servicos;

import br.com.l2g.model.Funcionario;
import br.com.l2g.model.Servicos;
import br.com.l2g.model.Usuario;
import br.com.l2g.util.Environment;
import br.com.l2g.util.Util;
import br.com.l2g.views.agendamento.CadastroAgendamento;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.PatternSyntaxException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JDialog;
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
public class ListServico extends javax.swing.JDialog {

    /**
     * Creates new form ListagemServico
     */
    private static final String URL_BASE = Environment.DEV.url();
    private static final String URL_servico = URL_BASE + "servico";
    private final JDialog frame;

    public ListServico(java.awt.Frame parent, boolean modal, javax.swing.JDialog aThis) {
        super(parent, modal);
        initComponents();
        frame = aThis;
        CarregaTabela();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        comboColunasBox = new javax.swing.JComboBox<>();
        localizarText = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listagem de Serviços");
        setPreferredSize(new java.awt.Dimension(712, 488));

        comboColunasBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Código", "Serviço" }));

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

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Serviço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMaxWidth(200);
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 353, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(comboColunasBox, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(localizarText, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboColunasBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(localizarText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void localizarTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_localizarTextFocusGained
        localizarText.setText("");
        localizarText.selectAll();
    }//GEN-LAST:event_localizarTextFocusGained

    private void localizarTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_localizarTextKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            pesquisaPorColuna(localizarText.getText().trim(), comboColunasBox.getSelectedIndex());
        }
    }//GEN-LAST:event_localizarTextKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
       try {
            if (evt.getClickCount() == 2) {
                DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
                if (frame instanceof CadastroAgendamento) {
                    CadastroAgendamento lv = (CadastroAgendamento) frame;
                    String codigo = model.getValueAt(jTable1.getSelectedRow(), 0).toString();
                    lv.setServico(buscarFuncPorId(codigo));
                    dispose();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ListServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboColunasBox;
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
            HttpGet get = new HttpGet(URL_servico);
            String resposta = Util.enviaRequest(get);
            List<Servicos> servicolista = Arrays.asList(Util.jsonToObject(resposta, Servicos[].class));
            for (Servicos f : servicolista) {
                objects[0] = f.getIdServico();
                objects[1] = f.getNomeServico();

                Tmodel.addRow(objects);
                jTable1.setModel(Tmodel);

            }
        } catch (IOException | HttpException | NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | BadPaddingException | InvalidKeyException ex) {
            Logger.getLogger(ListServico.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void IncluirServico() {
        CadastroServico view = new CadastroServico(null, true, "incluir");
        view.setVisible(true);
        CarregaTabela();
    }

    private void AlterarServico() {
        CadastroServico view = new CadastroServico(null, true, "editar");
        view.enviarCodigoSelecionado(jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0).toString());
        view.setVisible(true);
        CarregaTabela();
    }

    private void DeletarServico() {
        try {
            Object[] options = {"Sim", "Não"};
            int opcao = JOptionPane.showOptionDialog(null, "Deseja excluir este registro?", "Excluir", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
            if (opcao == 0 || opcao == -1) {
                String url_id = URL_servico + "/" + jTable1.getModel().getValueAt(jTable1.getSelectedRow(), 0).toString();
                HttpDelete delete = new HttpDelete(url_id);
                String resposta = Util.enviaRequest(delete);
                JOptionPane.showMessageDialog(null, "Registro deleteado com sucesso!\n" + resposta, "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                CarregaTabela();
            }
        } catch (IOException | HttpException | NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | BadPaddingException | InvalidKeyException ex) {
            Logger.getLogger(ListServico.class.getName()).log(Level.SEVERE, null, ex);
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
    
    private Servicos buscarFuncPorId(String codigo) throws Exception {
        String URL_PESQ = URL_servico + "/" + codigo;
        HttpGet get = new HttpGet(URL_PESQ);
        String resposta = Util.enviaRequest(get);
        Optional<Servicos> retorno = Optional.ofNullable(Util.jsonToObject(resposta, Servicos.class));
        return retorno.get();
    }

}
