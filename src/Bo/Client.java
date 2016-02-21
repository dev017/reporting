package Bo;

public class Client {
private int id_client;
private String nom_client;
private String prenom_client;
private Categorie cat;
public Client(){}
public Client(int id_client,String nom_client,String prenom_client,Categorie cat){
	this.id_client=id_client;
	this.nom_client=nom_client;
	this.prenom_client=prenom_client;
	this.cat=cat;
}
public Categorie getCat() {
	return cat;
}
public void setCat(Categorie cat) {
	this.cat = cat;
}
public int getId_client() {
	return id_client;
}
public void setId_client(int id_client) {
	this.id_client = id_client;
}
public String getNom_client() {
	return nom_client;
}
public void setNom_client(String nom_client) {
	this.nom_client = nom_client;
}
public String getPrenom_client() {
	return prenom_client;
}
public void setPrenom_client(String prenom_client) {
	this.prenom_client = prenom_client;
}


}
