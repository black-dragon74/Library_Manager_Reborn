/*
 * Created for fun by Nick aka black-dragon74
 * Feel free to have fun with the code :)
 * You have all rights to do whatever you want, Just Don't Forget To Credit
 */
package master;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.DriverManager;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author nick
 */
public class MainClass {
    // Init Db Connection
    public String cl = "java.sql.DriverManager";
    public String user = "root";
    public String pwd = "ExDb20Tra"; //Change MySQL/MariaDb Password Here
    public String url = "jdbc:mysql://localhost:3306/lib_reborn";
    public static int unstat = 0;
    // End Db Connection
    
    /*
     * Begin inProgram Methods
     * Please Don't Edit the lines below
     * Do so only if you have optimum programming knowledge
     * Thanks for understanding :)
    */
    // Begin Encryption Method
    public String hashot;
    public void toHash(String in){
        try{
                 MessageDigest md = MessageDigest.getInstance("MD5");
                 String passwordToHash = in;
                 md.update(passwordToHash.getBytes());
                 byte[] bytes = md.digest();
                 StringBuilder sb = new StringBuilder();
                 for (int i = 0; i<bytes.length;i++){
                 sb.append(Integer.toString((bytes [i] & 0xff) + 0x100,16).substring(1));
                 }
                 hashot = sb.toString();
             }
             catch (NoSuchAlgorithmException e){
                String ee = e.getMessage();
                System.out.println(ee);
             }
    }
    
    // Let's try and code Java Connect
    
    // Method When There is only one output through rs.getString()
    public String dbConnectExecute1Out,dbConnectExecute1Err=null;
    public void dbConnectExecute1(String sql,String wget1){
        try{
            Class.forName(cl);
            Connection con = DriverManager.getConnection(url,user,pwd);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()== true){
                dbConnectExecute1Out = rs.getString(wget1);
            }
   }
        catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
            dbConnectExecute1Err = e.getMessage();
        }
    }
    // dbConnect Method When You Just Have to exceute a sql command
    public String dbConnectUpdateErr=null;
    @SuppressWarnings("ConvertToTryWithResources")
    public void dbConnectUpdate(String sql){
        try{
            Class.forName(cl);
            Connection con = DriverManager.getConnection(url,user,pwd);
            Statement stmt = con.createStatement();
            stmt.executeUpdate(sql);
        }
        catch (ClassNotFoundException | SQLException e){
            dbConnectUpdateErr = e.getMessage();
        }
    }
    // Method When You Have 2 outputs
    public String dbConnectExecute2Out1,dbConnectExecute2Out2,dbConnectExecute2RsError=null,dbConnectExecute2Err=null;
    public void dbConnectExecute2(String sql,String wget1,String wget2){
        try{
            Class.forName(cl);
            Connection con = DriverManager.getConnection(url,user,pwd);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()== true){
                dbConnectExecute2Out1 = rs.getString(wget1);
                dbConnectExecute2Out2 = rs.getString(wget2);
                dbConnectExecute2RsError = "placeholder";
            }
            else{
                dbConnectExecute2RsError = "dummy";
            }
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
            dbConnectExecute2Err = e.getMessage();
        }
    }
    public void showMessage(String msg){
        JOptionPane.showMessageDialog(null,msg);
    }
    public String confirmOut;
   public void confirm(String ques,String title){
       int ans = JOptionPane.showConfirmDialog(null, ques,title, JOptionPane.YES_NO_OPTION);
      
       if (ans == JOptionPane.YES_OPTION){
           confirmOut = "yes";
       }
       else {
           confirmOut = "no";
       }
   }
   public String getInputOut;
   public void getInput(String quest){
       getInputOut = JOptionPane.showInputDialog(null,quest);
   }
   public void resetProgramData(){
        dbConnectUpdate("truncate book_catalogue");
        dbConnectUpdate("truncate book_transaction_log");
        dbConnectUpdate("truncate book_transactions");
        dbConnectUpdate("truncate library_users");
   }
   String emptyCheckResult;
   public void checkIfEmpty(String a,String b,String c,String d){
       if (a.isEmpty()){
           emptyCheckResult = "empty";
       }
       else if (b.isEmpty()){
           emptyCheckResult = "empty";
       }
       else if (c.isEmpty()){
           emptyCheckResult = "empty";
       }
       else if (d.isEmpty()){
           emptyCheckResult = "empty";
       }
       else {
           emptyCheckResult = "not_empty";
       }
   }
       // Method When You Have 3 outputs
    public String dbConnectExecute3Out1,dbConnectExecute3Out2,dbConnectExecute3Out3,dbConnectExecute3RsError = null,dbConnectExecute3Err=null;
    public void dbConnectExecute3(String sql,String wget1,String wget2,String wget3){
        try{
            Class.forName(cl);
            Connection con = DriverManager.getConnection(url,user,pwd);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()== true){
                dbConnectExecute3Out1 = rs.getString(wget1);
                dbConnectExecute3Out2 = rs.getString(wget2);
                dbConnectExecute3Out3 = rs.getString(wget3);
            }
            else {
                dbConnectExecute3RsError = "not_found";
            }
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
            dbConnectExecute3Err = e.getMessage();
        }
    }
    
    // Method When You Have 5 outputs
    public String dbConnectExecute5Out1,dbConnectExecute5Out2,dbConnectExecute5Out3,dbConnectExecute5Out4,dbConnectExecute5Out5,dbConnectExecute5RsError = null,dbConnectExecute5Err=null;
    public void connectEx5(String sql,String wget1,String wget2,String wget3,String wget4,String wget5){
        try{
            Class.forName(cl);
            Connection con = DriverManager.getConnection(url,user,pwd);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()== true){
                dbConnectExecute5Out1 = rs.getString(wget1);
                dbConnectExecute5Out2 = rs.getString(wget2);
                dbConnectExecute5Out3 = rs.getString(wget3);
                dbConnectExecute5Out4 = rs.getString(wget4);
                dbConnectExecute5Out5 = rs.getString(wget5);
                dbConnectExecute5RsError = "something";
            }
            else {
                dbConnectExecute5RsError = "not_found";
            }
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
            dbConnectExecute5Err = e.getMessage();
        }
    }
    
    public String dbConnectExecute6Out1,dbConnectExecute6Out2,dbConnectExecute6Out3,dbConnectExecute6Out4,dbConnectExecute6Out5,dbConnectExecute6Out6,dbConnectExecute6RsError = null,dbConnectExecute6Err=null;
    public void connectEx6(String sql,String wget1,String wget2,String wget3,String wget4,String wget5,String wget6){
        try{
            Class.forName(cl);
            Connection con = DriverManager.getConnection(url,user,pwd);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()== true){
                dbConnectExecute6Out1 = rs.getString(wget1);
                dbConnectExecute6Out2 = rs.getString(wget2);
                dbConnectExecute6Out3 = rs.getString(wget3);
                dbConnectExecute6Out4 = rs.getString(wget4);
                dbConnectExecute6Out5 = rs.getString(wget5);
                dbConnectExecute6Out6 = rs.getString(wget6);
                dbConnectExecute6RsError = "something";
            }
            else {
                dbConnectExecute6RsError = "not_found";
            }
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
            dbConnectExecute6Err = e.getMessage();
        }
    }
    
  }
