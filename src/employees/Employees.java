/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package employees;


/**
 *
 * @author pila4
 */
public class Employees {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DB.loadConnection();
        LoginPage loginPage = new LoginPage();
        loginPage.show();
        
      
        }
    
}
