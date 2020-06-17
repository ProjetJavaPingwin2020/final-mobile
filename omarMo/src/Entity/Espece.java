/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.io.InputStream;

/**
 *
 * @author TH3OMAR
 */
public class Espece {
    private int id;
    private String nom;
    private String type;
    private String description;
    private int categorie;
    private String NomCategorie;
    private String NomImage;

    public Espece(int id, String nom, String type, String description, int categorie, String NomCategorie, String NomImage) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.description = description;
        this.categorie = categorie;
        this.NomCategorie = NomCategorie;
        this.NomImage = NomImage;
    }

    public String getNomImage() {
        return NomImage;
    }

    public void setNomImage(String NomImage) {
        this.NomImage = NomImage;
    }
    

    @Override
    public String toString() {
        return "Espece{" + "id=" + id + ", nom=" + nom + ", type=" + type + ", description=" + description + ", categorie=" + categorie + ", NomCategorie=" + NomCategorie + ", NomImage=" + NomImage + '}';
    }

    public Espece(String nom, String type, String description, int categorie, String NomCategorie, String NomImage) {
        this.nom = nom;
        this.type = type;
        this.description = description;
        this.categorie = categorie;
        this.NomCategorie = NomCategorie;
        this.NomImage = NomImage;
    }


    public String getNomCategorie() {
        return NomCategorie;
    }

    public void setNomCategorie(String NomCategorie) {
        this.NomCategorie = NomCategorie;
    }

    public Espece(int id, String nom, String type, String description, int categorie) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.description = description;
        this.categorie = categorie;
    }

    public Espece(String nom, String type, String description, int categorie) {
        this.nom = nom;
        this.type = type;
        this.description = description;
        this.categorie = categorie;
    }
     public Espece(String nom, String type, String description, int categorie,String NomCategorie) {
        this.nom = nom;
        this.type = type;
        this.description = description;
        this.categorie = categorie;
        this.NomCategorie=NomCategorie;
    }

    public Espece() {
        
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public int getCategorie() {
        return categorie;
    }
   
    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }

    

    
    
    
}
