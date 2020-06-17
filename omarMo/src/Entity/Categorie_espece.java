/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;


/**
 *
 * @author TH3OMAR
 */

public class Categorie_espece {
     int id;
     String nom;
     private String image;

    public Categorie_espece(int id, String nom, String image) {
        this.id = id;
        this.nom = nom;
        this.image = image;
    }

    public Categorie_espece(String nom, String image) {
        this.nom = nom;
        this.image = image;
    }

    public Categorie_espece() {
 
    }

    public Categorie_espece(String nom) {
        this.nom = nom;
    }

    public Categorie_espece(int id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Categorie_espece{" + "id=" + id + ", nom=" + nom + ", image=" + image + '}';
    }


     
    
    
}
