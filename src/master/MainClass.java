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

/**
 *
 * @author nick
 */
public class MainClass {
    // Init Db Connection
    public String cl = "java.sql.DriverManager";
    public String user = "root";
    public String pwd = "ExDb20Tra"; //Change MySQL/MariaDb Password Here
    public String url = "jdbc:mysql://localhost:3306/libnk";
    // End Db Connection
    
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
                con.close();
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
            con.close();
        }
        catch (ClassNotFoundException | SQLException e){
            dbConnectUpdateErr = e.getMessage();
        }
    }
    // Method When You Have 2 outputs
    public String dbConnectExecute2Out1,dbConnectExecute2Out2,dbConnectExecute2Err=null;
    public void dbConnectExecute2(String sql,String wget1,String wget2){
        try{
            Class.forName(cl);
            Connection con = DriverManager.getConnection(url,user,pwd);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()== true){
                dbConnectExecute2Out1 = rs.getString(wget1);
                dbConnectExecute2Out2 = rs.getString(wget2);
                con.close();
            }
        }
        catch (ClassNotFoundException | SQLException e){
            System.out.println(e.getMessage());
            dbConnectExecute2Err = e.getMessage();
        }
    }
  }
