/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.l2g.views.funcionario;

import br.com.l2g.model.Funcionario;
import br.com.l2g.util.Environment;
import br.com.l2g.util.Util;
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
public class cadastroFuncionario extends javax.swing.JFrame {

    /**
     * Creates new form listagemFuncionario
     */
        private static final String URL_BASE = Environment.DEV.url();
     private static final String URL_FUNCIONARIO = URL_BASE + "funcionario";
    
    public cadastroFuncionario(Frame parent, boolean modal, String operacao) {
        initComponents();
        String viewTitulo = operacao.equals("incluir") ? "Cadastro de Funcionario" : "Alterar Funcionario";
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

        buttonCancelar = new javax.swing.JButton();
        buttonSalvar = new javax.swing.JButton();
        nomeText = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        codigoFuncionarioText = new javax.swing.JFormattedTextField();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        nomeText.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nomeTextFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                nomeTextFocusLost(evt);
            }
        });

        jLabel3.setText("*Nome Pessoa:");

        codigoFuncionarioText.setEditable(false);
        codigoFuncionarioText.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("######"))));
        codigoFuncionarioText.setEnabled(false);
        codigoFuncionarioText.setFocusLostBehavior(javax.swing.JFormattedTextField.COMMIT);
        codigoFuncionarioText.setFocusable(false);

        jLabel10.setText("*Codigo:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancelar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addComponent(jLabel10)
                        .addComponent(codigoFuncionarioText, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nomeText, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(codigoFuncionarioText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(buttonCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonSalvar))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonCancelarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buttonCancelarFocusGained
        //
    }//GEN-LAST:event_buttonCancelarFocusGained

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void buttonSalvarFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_buttonSalvarFocusGained
        //
    }//GEN-LAST:event_buttonSalvarFocusGained

    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvarActionPerformed
      salvarFuncionario();
    }//GEN-LAST:event_buttonSalvarActionPerformed

    private void nomeTextFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomeTextFocusGained
        nomeText.selectAll();
    }//GEN-LAST:event_nomeTextFocusGained

    private void nomeTextFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nomeTextFocusLost
        if (nomeText.getText().trim().length() > 60) {
            JOptionPane.showMessageDialog(null, "Nome da funcionario exedeu o limite de 60 caracteres\nFavor abreviar o nome!", "ERRO", JOptionPane.ERROR_MESSAGE);
            nomeText.requestFocusInWindow();
        }
    }//GEN-LAST:event_nomeTextFocusLost

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
            java.util.logging.Logger.getLogger(cadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastroFuncionario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
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
    private javax.swing.JFormattedTextField codigoFuncionarioText;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField nomeText;
    // End of variables declaration//GEN-END:variables

 private void salvarFuncionario() {
        try {
            HttpPost post = new HttpPost(URL_FUNCIONARIO);
            Funcionario funcionario = criaFuncionario();
            String jsonEnvio = Util.objectToJson(funcionario);
            post.setEntity(new StringEntity(jsonEnvio));
            String jsonResposta = Util.enviaRequest(post);
            Optional retorno = Optional.ofNullable(Util.jsonToObject(jsonResposta, cadastroFuncionario.class));
            if (!retorno.isPresent()) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar registro!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }else{
                JOptionPane.showMessageDialog(null, "Registro salvo com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
            
        } catch (IOException | HttpException | NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | BadPaddingException | InvalidKeyException ex) {
            Logger.getLogger(cadastroFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
    }

    private Funcionario criaFuncionario() {
        Funcionario funcionario = new Funcionario();
        
        if(!codigoFuncionarioText.getText().trim().isEmpty()){
            funcionario.setIdFuncionario(Integer.parseInt(codigoFuncionarioText.getText().trim()));
        }
        
        funcionario.setNome(nomeText.getText().trim().toUpperCase());

        return funcionario; 
    }

 public void enviarCodigoSelecionado(String id) {
        try {
            String URL_PESQ = URL_FUNCIONARIO + "/" + id;
            HttpGet get = new HttpGet(URL_PESQ);
            String resposta = Util.enviaRequest(get);
            Optional retorno = Optional.ofNullable(Util.jsonToObject(resposta, listagemFuncionario.class));
            if (retorno.isPresent()) {
                Funcionario fluxo = (Funcionario) retorno.get();
                
                codigoFuncionarioText.setText(String.valueOf(fluxo.getIdFuncionario()));
                nomeText.setText(fluxo.getNome());
               
              
            } 

        } catch (IOException | HttpException | NoSuchPaddingException | IllegalBlockSizeException | NoSuchAlgorithmException | BadPaddingException | InvalidKeyException ex) {
            Logger.getLogger(cadastroFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
        }
}
}
