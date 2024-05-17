/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employees;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;


/**
 *
 * @author pila4
 */
public class DB {
    public static Connection con = null;
    
    public static void loadConnection(){
    String url="jdbc:mysql://localhost:3306/myemployee";
    String root="root";
    String pass="root";
    
        try {
        con = DriverManager.getConnection(url, root, pass);
        if(con != null){
        JOptionPane.showMessageDialog(null,"database connected succesfully");
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error in database loading check again"+e);
        }

        
    }
    
    
}
