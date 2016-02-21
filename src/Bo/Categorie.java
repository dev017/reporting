package Bo;
import java.util.*;
public class Categorie {
	private int id_categorie;
	private String nom_categorie;
    private Vector<Client>cl;
   public  Categorie(){}
   public  Categorie(int id_categorie,String nom_categorie,Vector<Client>cl){
    	this.id_categorie=id_categorie;
    	this.nom_categorie=nom_categorie;
    	this.cl=cl;
    }
   
   public  Categorie(int id_categorie,String nom_categorie){
   	this.id_categorie=id_categorie;
   	this.nom_categorie=nom_categorie;
   }
public Vector<Client> getCl() {
	return cl;
}
public void setCl(Vector<Client> cl) {
	this.cl = cl;
}
public int getId_categorie() {
	return id_categorie;
}
public void setId_categorie(int id_categorie) {
	this.id_categorie = id_categorie;
}
public String getNom_categorie() {
	return nom_categorie;
}
public void setNom_categorie(String nom_categorie) {
	this.nom_categorie = nom_categorie;
}
   
   
   
}
