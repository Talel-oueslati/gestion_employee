/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package employees;

/**
 *
 * @author pila4
 */
public class personne {
    private int id_employee;
    private String nom;
    private String prenom;
    private String adresse;
    private String numero_tel;
    private String genre;
     private byte[] image;

    public personne(int id,String nom, String prenom, String adresse, String numero_tel,String genre,byte[] image) {
        this.id_employee=id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.numero_tel = numero_tel;
        this.genre = genre;
        this.image = image;
        
    }
        public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

 
    public int getId_employee() {
        return id_employee;
    }

    public void setId_employee(int id_employee) {
        this.id_employee = id_employee;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumero_tel() {
        return numero_tel;
    }

    public void setNumero_tel(String numero_tel) {
        this.numero_tel = numero_tel;
    }

    
        
    
}
