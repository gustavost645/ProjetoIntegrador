/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.views.MeiosDePagamento;

import br.com.l2g.model.FluxoDeCaixa;
import br.com.l2g.util.Environment;
import br.com.l2g.util.Util;
import br.com.l2g.views.fluxodecaixa.CadastroCaixa;
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
public class CadastroMeioDePAfamento extends javax.swing.JFrame {

    /**
     * Creates new form CadastroMeioDePAfamento
     */
      private static final String URL_BASE = Environment.DEV.url();
     private static final String URL_PAGAMENTO = URL_BASE + "pagamento";
    public CadastroMeioDePAfamento(Frame parent, boolean modal, String operacao) {
        initComponents();
        String viewTitulo = operacao.equals("incluir") ? "Cadastro de Cidades" : "Alterar Cidades";
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

        codigoCaixaText = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();
        buttonSalvar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboxMeioDePagamento = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        codigoCaixaText.setEditable(false);
        codigoCaixaText.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("######"))));
        codigoCaixaText.setEnabled(false);
        codigoCaixaText.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        codigoCaixaText.setFocusable(false);

        jLabel10.setText("*Codigo:");

        buttonSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/1480357534_free-05.png"))); // NOI18N
        buttonSalvar.setText("Salvar");
        buttonSalvar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonSalvar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        buttonSalvar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        buttonSalvar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                buttonSalvarFocusGained(evt);
            }
        });
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
        buttonCancelar.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                buttonCancelarFocusGained(evt);
            }
        });
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        jLabel1.setText("*Toipo de Pagamento :");

        jComboxMeioDePagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Dinheiro", "Cartão Debito", "Cartão Credito", "Pix ", "Trasferencia Bancaria ", " " }));
        jComboxMeioDePagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboxMeioDePagamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(buttonCancelar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(18, 18, 18)
                            .addComponent(codigoCaixaText, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(18, 18, 18)
                            .addComponent(jComboxMeioDePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoCaixaText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboxMeioDePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonSalvar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSalvarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buttonSalvarFocusGained
        //
    }//GEN-LAST:event_buttonSalvarFocusGained

    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
        salvarFluxo();
    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void buttonCancelarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buttonCancelarFocusGained
        //
    }//GEN-LAST:event_buttonCancelarFocusGained

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void jComboxMeioDePagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboxMeioDePagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboxMeioDePagamentoActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroMeioDePAfamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroMeioDePAfamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroMeioDePAfamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroMeioDePAfamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JFormattedTextField codigoCaixaText;
    private javax.swing.JComboBox<String> jComboxMeioDePagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    // End of variables declaration//GEN-END:variables

  private void salvarFluxo() {
        try {
            HttpPost post = new HttpPost(URL_PAGAMENTO);
            FluxoDeCaixa fluxo = criaFluxo();
            String jsonEnvio = Util.objectToJson(fluxo);
            post.setEntity(new StringEntity(jsonEnvio));
            String jsonResposta = Util.enviaRequest(post);
            Optional retorno = Optional.ofNullable(Util.jsonToObject(jsonResposta, FluxoDeCaixa.class));
            if (!retorno.isPresent()) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar registro!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
            
        } catch (IOException | HttpException | NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | BadPaddingException | InvalidKeyException ex) {
            Logger.getLogger(CadastroCaixa.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private FluxoDeCaixa criaFluxo() {
        FluxoDeCaixa fluxo = new FluxoDeCaixa();
        
        if(!codigoCaixaText.getText().trim().isEmpty()){
            fluxo.setIdPagamento(Integer.parseInt(codigoCaixaText.getText().trim()));
        }
        
        
        fluxo.setValor(URL_BASE);
        //terminar 
        return fluxo; 
    }

    public void enviarCodigoSelecionado(String id) {
        try {
            String URL_PESQ = URL_PAGAMENTO + "/" + id;
            HttpGet get = new HttpGet(URL_PESQ);
            String resposta = Util.enviaRequest(get);
            Optional retorno = Optional.ofNullable(Util.jsonToObject(resposta, FluxoDeCaixa.class));
            if (retorno.isPresent()) {
                FluxoDeCaixa fluxo = (FluxoDeCaixa) retorno.get();
                
                codigoCaixaText.setText(String.valueOf(fluxo.getIdPagamento()));
               
              
            } 

        } catch (IOException | HttpException | NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | BadPaddingException | InvalidKeyException ex) {
            Logger.getLogger(CadastroCaixa.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

}


