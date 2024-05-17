/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employees;
import java.sql.Blob;

import java.util.List;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;

import java.sql.DriverManager;
import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 *
 * @author pila4
 */
public class sqlFunctions {
    
    
    public List<personne> getAllEmployee(){
        List<personne> list = new ArrayList<personne>();
            try {
                String query="SELECT * FROM myemployee.employee;";
                PreparedStatement ps = DB.con.prepareStatement(query);
                ResultSet rs=  ps.executeQuery();
                while (rs.next()) { 
                    int id=rs.getInt("id_employee");
                    String nom=rs.getString("nom");
                    String prenom=rs.getString("prenom");
                    String adresse=rs.getString("adresse");
                    String numero_tel=rs.getString("numero_tel");
                    String genre=rs.getString("genre");
                    Blob blob = rs.getBlob("image");
            byte[] image = null;
            if (blob != null) {
                image = blob.getBytes(1, (int) blob.length());
            }
                    personne personneObj = new personne(id, nom, prenom, adresse, numero_tel,genre,image);
                    list.add(personneObj);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"error getting data"+e);
            }
            return list;
}
    
    public void insertemployee(personne personneObj)
    {
    
        try {
            String query ="insert into employee values(null,?,?,?,?,?,?)";
            PreparedStatement ps = DB.con.prepareStatement(query);
            ps.setString(1, personneObj.getNom());
            ps.setString(2, personneObj.getPrenom());
            ps.setString(3, personneObj.getAdresse());
            ps.setString(4, personneObj.getNumero_tel());
             ps.setString(5, personneObj.getGenre());
             ps.setBytes(6, personneObj.getImage());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"employee added succefully into database");
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"error data failed to insert correctly"+e);
        }
    }
    
    public personne returnAllDataToTextField(int id){
    personne perso = null;
        try {
            String query = "select * from employee where id_employee = "+id;
            PreparedStatement ps = DB.con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {                
                    int ids=rs.getInt("id_employee");
                    String nom=rs.getString("nom");
                    String prenom=rs.getString("prenom");
                    String adresse=rs.getString("adresse");
                    String numero_tel=rs.getString("numero_tel");
                    String genre=rs.getString("genre");
                     Blob blob = rs.getBlob("image");
            byte[] image = null;
            if (blob != null) {
                image = blob.getBytes(1, (int) blob.length());
            }

                    perso = new personne(ids, nom, prenom, adresse, numero_tel,genre,image);

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,""+e);
        }
    return perso;
    }
    public void deleteEmployee(int id){
        try {
            String query="delete from employee where id_employee = ? ";
            PreparedStatement ps = DB.con.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"employee deleted succesfully");
            
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null, ""+e);
        }
    }
    public void updateEmployee(personne perso){
    
        try {
            String query="update employee set nom = ?, prenom = ?, adresse = ? , numero_tel = ? where id_employee = ? ";
            PreparedStatement ps = DB.con.prepareStatement(query);
            ps.setString(1, perso.getNom());
            ps.setString(2, perso.getPrenom());
            ps.setString(3, perso.getAdresse());
            ps.setString(4, perso.getNumero_tel());
            ps.setInt(5, perso.getId_employee());
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null,"employee updated succesfully"+perso.getId_employee());

        
        } catch (Exception e) {
        JOptionPane.showMessageDialog(null," "+e);
        }
    }
    
    public boolean checkLogin(String username,String password){
       Boolean b = false;
        try {
            String query = "select username,password from user where username = '"+username+"' and password ='"+password+"' ";
            Statement st = DB.con.createStatement();
            ResultSet rs=st.executeQuery(query);
            if(rs.next()){
            b = true;
            }else{
            JOptionPane.showMessageDialog(null,"wronf informations please check again ");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"login error"+e);
        }
        return b;
    }
 }
