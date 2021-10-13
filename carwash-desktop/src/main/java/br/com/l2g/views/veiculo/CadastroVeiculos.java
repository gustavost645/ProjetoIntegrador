/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.views.veiculo;

import br.com.l2g.model.Veiculo;
import br.com.l2g.util.Environment;
import br.com.l2g.util.Util;
import br.com.l2g.views.cliente.CadastroCliente;
import java.awt.Frame;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.swing.JOptionPane;
import org.apache.http.HttpException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;

/**
 *
 * @author lucas
 */
public class CadastroVeiculos extends javax.swing.JFrame {

    private static final String URL_BASE = Environment.DEV.url();
    private static final String URL_VEICULO = URL_BASE + "veiculo";
    private static final String URL_CIDADE = URL_BASE + "cidade";

    /**
     * Creates new form CadastroVeiculos
     */
    public CadastroVeiculos(Frame parent, boolean modal, String operacao) {

        initComponents();
        String viewTitulo = operacao.equals("incluir") ? "Cadastro de Veiculo" : "Alterar Veiculo";
        String botaoTitulo = operacao.equals("incluir") ? "Salvar" : "Alterar";
        this.setTitle(viewTitulo);
        buttonSalvar.setText(botaoTitulo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        codigoveiculoText1 = new javax.swing.JFormattedTextField();
        buttonSalvar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        veiculoText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        PlacaVeiculoText = new javax.swing.JTextField();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        complementoText = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        bairroText = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        placaText = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro De Veiculos");

        jLabel11.setText("*Codigo:");

        codigoveiculoText1.setEditable(false);
        codigoveiculoText1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("######"))));
        codigoveiculoText1.setEnabled(false);
        codigoveiculoText1.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        codigoveiculoText1.setFocusable(false);

        buttonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1480357534_free-05.png"))); // NOI18N
        buttonSalvar.setText("Salvar");
        buttonSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonSalvar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        buttonSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });

        buttonCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1479862814_Cancel.png"))); // NOI18N
        buttonCancelar.setText("Cancelar");
        buttonCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonCancelar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        buttonCancelar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        jLabel3.setText("*Modelo Veiculo:");

        veiculoText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                veiculoTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                veiculoTextFocusLost(evt);
            }
        });

        jLabel4.setText("*Placa Veiculo : ");

        PlacaVeiculoText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                PlacaVeiculoTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                PlacaVeiculoTextFocusLost(evt);
            }
        });

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Veiculo"));

        jLabel8.setText("Marca :");

        jLabel9.setText("*Modelo :");

        jLabel12.setText("Placa Veiculo");

        placaText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                placaTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                placaTextFocusLost(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/2943_16x16.png"))); // NOI18N
        jButton1.setToolTipText("Pesquisar Cep");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(complementoText, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(placaText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(bairroText, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 75, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(complementoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bairroText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(placaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.getAccessibleContext().setAccessibleName("");
        jPanel2.getAccessibleContext().setAccessibleDescription("");

        jTabbedPane1.addTab("Informações Gerais", jPanel1);
        jPanel1.getAccessibleContext().setAccessibleName("Veiculos");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(codigoveiculoText1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(veiculoText, javax.swing.GroupLayout.PREFERRED_SIZE, 491, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(PlacaVeiculoText, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 657, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(buttonCancelar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(codigoveiculoText1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(veiculoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PlacaVeiculoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonCancelar)
                    .addComponent(buttonSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        salvarVeiculo();
        limpaCamposveiculos();
    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void veiculoTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_veiculoTextFocusGained
        veiculoText.selectAll();
    }//GEN-LAST:event_veiculoTextFocusGained

    private void veiculoTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_veiculoTextFocusLost
        if (veiculoText.getText().trim().length() > 60) {
            JOptionPane.showMessageDialog(null, "Nome da empresa exedeu o limite de 60 caracteres\nFavor abreviar o nome!", "ERRO", JOptionPane.ERROR_MESSAGE);
            veiculoText.requestFocusInWindow();
        }
    }//GEN-LAST:event_veiculoTextFocusLost

    private void PlacaVeiculoTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PlacaVeiculoTextFocusGained
        PlacaVeiculoText.selectAll();
    }//GEN-LAST:event_PlacaVeiculoTextFocusGained

    private void PlacaVeiculoTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_PlacaVeiculoTextFocusLost
        if (PlacaVeiculoText.getText().trim().length() > 60) {
            JOptionPane.showMessageDialog(null, "Nome da empresa exedeu o limite de 60 caracteres\nFavor abreviar o nome!", "ERRO", JOptionPane.ERROR_MESSAGE);
            PlacaVeiculoText.requestFocusInWindow();
        }
    }//GEN-LAST:event_PlacaVeiculoTextFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        listarVeiculos();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void placaTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_placaTextFocusLost

    }//GEN-LAST:event_placaTextFocusLost

    private void placaTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_placaTextFocusGained
        placaText.selectAll();
    }//GEN-LAST:event_placaTextFocusGained

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
            java.util.logging.Logger.getLogger(CadastroVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroVeiculos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                System.exit(0);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField PlacaVeiculoText;
    private javax.swing.JTextField bairroText;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JFormattedTextField codigoveiculoText1;
    private javax.swing.JTextField complementoText;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField placaText;
    private javax.swing.JTextField veiculoText;
    // End of variables declaration//GEN-END:variables

    private void limpaCamposveiculos() {
        codigoveiculoText1.setText("");
        veiculoText.setText("");
        placaText.setText("");
    }

    private void salvarVeiculo() {
        try {
            HttpPost post = new HttpPost(URL_VEICULO);
            Veiculo empresa = criarVeiculo();
            String jsonEnvio = Util.objectToJson(empresa);
            post.setEntity(new StringEntity(jsonEnvio));
            String jsonResposta = Util.enviaRequest(post);
            Optional retorno = Optional.ofNullable(Util.jsonToObject(jsonResposta, Veiculo.class));
            if (!retorno.isPresent()) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar registro!", "ERRO", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }

        } catch (IOException | HttpException | NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | BadPaddingException | InvalidKeyException ex) {
            Logger.getLogger(CadastroVeiculos.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Veiculo criarVeiculo() {
        Veiculo veiculo = new Veiculo();
        veiculo.setIdVeiculos(Integer.parseInt(codigoveiculoText1.getText().trim()));
        veiculo.setMerca(veiculoText.getText().trim());
        veiculo.setPlaca(placaText.getText().trim());

        Veiculo cliente = new Veiculo();

        if (!codigoveiculoText1.getText().trim().isEmpty()) {
            cliente.setIdVeiculos(Integer.parseInt(codigoveiculoText1.getText().trim()));
        }

        veiculo.setMerca(veiculoText.getText().trim().toUpperCase());
        veiculo.setPlaca(placaText.getText().trim().toUpperCase());

        veiculo.setIdVeiculos(MOVE_CURSOR);

        return veiculo;
    }

    private void listarVeiculos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void enviarCodigoSelecionado(String id) throws IOException, HttpException, NoSuchPaddingException {
        try {
            String URL_PESQ = URL_VEICULO + "/" + id;
            HttpGet get = new HttpGet(URL_PESQ);
            String resposta = Util.enviaRequest(get);
            Optional retorno = Optional.ofNullable(Util.jsonToObject(resposta, Veiculo.class));
            if (retorno.isPresent()) {
                Veiculo veiculo = (Veiculo) retorno.get();

                codigoveiculoText1.setText(String.valueOf(veiculo.getIdVeiculos()));
                veiculoText.setText(veiculo.getMerca());
                placaText.setText(veiculo.getPlaca());

            }
        } catch (IOException | HttpException | NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | BadPaddingException | InvalidKeyException ex) {
            Logger.getLogger(CadastroCliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);

        }

    }
}
