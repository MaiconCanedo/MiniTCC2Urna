package br.gov.tse.urna.gui;

import br.gov.tse.urna.bo.LoginBO;
import br.gov.tse.urna.util.Mensagem;

/**
 *
 * @author Maicon C. R. Paradela
 */
public class Login extends javax.swing.JFrame {

    public Login() {
        initComponents();
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        ctSenha = new javax.swing.JPasswordField();
        ctLogin = new javax.swing.JTextField();
        lbBrasao = new javax.swing.JLabel();
        lbJusticaEleitoral = new javax.swing.JLabel();
        lbSiteTse = new javax.swing.JLabel();
        lbLogin = new javax.swing.JLabel();
        lbSenha = new javax.swing.JLabel();
        btLogin = new javax.swing.JButton();
        btSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela deLogin");
        setMinimumSize(new java.awt.Dimension(780, 580));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel1.setText("Login:");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(310, 130, 49, 22);

        jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel2.setText("Senha:");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(310, 210, 57, 22);

        ctSenha.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ctSenha.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(ctSenha);
        ctSenha.setBounds(310, 250, 245, 24);

        ctLogin.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ctLogin.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.add(ctLogin);
        ctLogin.setBounds(310, 160, 245, 24);

        lbBrasao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/gov/tse/urna/img/BrasaoDoBrasil.png"))); // NOI18N
        jPanel1.add(lbBrasao);
        lbBrasao.setBounds(83, 102, 200, 232);

        lbJusticaEleitoral.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        lbJusticaEleitoral.setText("JUSTIÇA ELEITORAL");
        jPanel1.add(lbJusticaEleitoral);
        lbJusticaEleitoral.setBounds(210, 440, 366, 43);

        lbSiteTse.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        lbSiteTse.setText("www.tse.jus.br");
        jPanel1.add(lbSiteTse);
        lbSiteTse.setBounds(320, 490, 158, 29);

        lbLogin.setForeground(new java.awt.Color(255, 0, 0));
        lbLogin.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbLogin.setText("                           ");
        jPanel1.add(lbLogin);
        lbLogin.setBounds(440, 190, 120, 14);

        lbSenha.setForeground(new java.awt.Color(255, 0, 0));
        lbSenha.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbSenha.setText("                             ");
        jPanel1.add(lbSenha);
        lbSenha.setBounds(310, 280, 130, 14);

        btLogin.setBackground(new java.awt.Color(255, 255, 255));
        btLogin.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btLogin.setText("Login");
        btLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btLogin);
        btLogin.setBounds(310, 300, 110, 31);

        btSair.setBackground(new java.awt.Color(255, 255, 255));
        btSair.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });
        jPanel1.add(btSair);
        btSair.setBounds(450, 300, 110, 31);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLoginActionPerformed
        try {
            new LoginBO().logar(ctLogin.getText(), ctSenha.getText());
            Mensagem.addMsgInf(this, "Logado!");
        } catch (Exception ex) {
            Mensagem.addMsgErr(this, ex.getMessage());
        } 
    }//GEN-LAST:event_btLoginActionPerformed

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btSairActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btLogin;
    private javax.swing.JButton btSair;
    private javax.swing.JTextField ctLogin;
    private javax.swing.JPasswordField ctSenha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbBrasao;
    private javax.swing.JLabel lbJusticaEleitoral;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JLabel lbSiteTse;
    // End of variables declaration//GEN-END:variables
}