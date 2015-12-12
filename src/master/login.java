/*
 * Created for fun by Nick aka black-dragon74
 * Feel free to have fun with the code :)
 * You have all rights to do whatever you want, Just Don't Forget To Credit ;)
 */

package master;
import java.sql.*;
import javax.swing.*;
/**
 *
 * @author nick
 */
public class login extends javax.swing.JFrame {
static int count_err = 0;
    /**
     * Creates new form login
     */
    public login() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfuser = new javax.swing.JTextField();
        tfpwd = new javax.swing.JPasswordField();
        logonbtn = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login | Library Manager Reborn");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jLabel1.setText("Enter Your Name");

        jLabel2.setText("Enter Your Security Key");

        logonbtn.setText("LOGON");
        logonbtn.setEnabled(false);
        logonbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logonbtnActionPerformed(evt);
            }
        });

        jButton2.setText("CLEAR");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 211, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(logonbtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfuser)
                    .addComponent(tfpwd)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 46, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfpwd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(logonbtn)
                    .addComponent(jButton2))
                .addGap(28, 28, 28))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tfuser.setText(null);
        tfpwd.setText(null);
        tfuser.requestFocus();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // Init Integrity Check
        MainClass mc = new MainClass();
        try {
            Class.forName(mc.cl);
            Connection con = DriverManager.getConnection(mc.url,mc.user,mc.pwd);
            Statement stmt = con.createStatement();
            String q = "select * from pro_stat;";
            ResultSet rs = stmt.executeQuery(q);
            while (rs.next()==true){
                String val2check; int a = 0,an;
                val2check = rs.getString("CStat");
                if (val2check.equals("401")){
                    JOptionPane.showMessageDialog(this,"Sorry You Haven't Activated Product Yet"); a = 1;
                    logonbtn.setEnabled(false);
                }
                else if (val2check.equals("402")){
                    JOptionPane.showMessageDialog(this,"Program Has Been Blocked"); a = 2;
                    logonbtn.setEnabled(false);
                }
                else {
                    logonbtn.setEnabled(true);
                }
                
                switch (a){
                    case 1 :
                       an = JOptionPane.showConfirmDialog(this,"Product Not Activated! Activate Now?"); 
                        if (an == JOptionPane.YES_OPTION){dispose();new Integrity_Manager().setVisible(true);}
                        break;
                    case 2 :
                        an = JOptionPane.showConfirmDialog(this,"Product Blocked! Unlock?");
                        if (an == JOptionPane.YES_OPTION){dispose();new Integrity_Manager().setVisible(true);}break;
                    default :
                        
                }
            }
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_formWindowOpened

    private void logonbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logonbtnActionPerformed
       MainClass mc = new MainClass();
       String u,p,fp;
       u = tfuser.getText();
       p = new String (tfpwd.getPassword());
       // Start Decrypting
       mc.toHash(p);
       String dec_pass = mc.hashot;
       mc.dbConnectExecute2("select * from logon;","alpha","bravo");
       if (u.equals(mc.dbConnectExecute2Out1) && dec_pass.equals(mc.dbConnectExecute2Out2)){
          JOptionPane.showMessageDialog(this,"Welcome, "+u.toUpperCase());
          dispose();
          new activity_chooser().setVisible(true);
       }
       else{
          
           JOptionPane.showMessageDialog(this,"Sorry, "+u.toUpperCase()+"\n"+"Try Again !","Login Failed",JOptionPane.ERROR_MESSAGE);
           count_err = count_err +1;
       }
       // Incase there was some error spill it out
       if (mc.dbConnectExecute2Err != null){
       JOptionPane.showMessageDialog(this,mc.dbConnectExecute2Err);
    }
    }//GEN-LAST:event_logonbtnActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
      if (count_err == 3){
          MainClass mc = new MainClass();
          mc.showMessage("Maximum attempts made! Product Locked");
          mc.dbConnectUpdate("insert into pro_stat values ('402');");
          String err = mc.dbConnectUpdateErr;
          if (err!=null){
              mc.showMessage(err);
          }
          System.exit(0);
      }
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JButton logonbtn;
    private javax.swing.JPasswordField tfpwd;
    private javax.swing.JTextField tfuser;
    // End of variables declaration//GEN-END:variables
}
