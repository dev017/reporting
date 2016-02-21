package Service;
import java.sql.*;
import Bo.*;
import Dao.*;
import Presentation.*;
import java.util.*;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Service {
	
	 
	 //----------------------------------------------------------------
	 //-----------------------------Catégorie--------------------------
	 //-----------------------------------------------------------------
	 
	
   //	Création de l'objet catégorie
	static Service myDaoCategorie;
	 public static Service getDaoCategorie(){
	        if(myDaoCategorie==null)
	        	myDaoCategorie=new Service();
	        return myDaoCategorie;
	    }
	 //-------------------------------------------------------------------------
	 public void ajouterCategorie(IHM ihm, int id_cat, String nom_cat) {
         Categorie a = new Categorie(id_cat,nom_cat);
         DaoCategorie.getDaoCategorie().addCategorie(a);  
       }
	 //--------------------------------------------------------------------------
    public void modifierCategorie(IHM ihm,int id_cat,String nom_cat){
	Categorie a=new Categorie(id_cat,nom_cat);
	DaoCategorie.getDaoCategorie().updateCategorie(a);
     }
    //----------------------------------------------------------------------------
    public void supprimerCategorie(IHM ihm,int id_cat){
	Categorie a=new Categorie(id_cat,null);
	DaoCategorie.getDaoCategorie().supprimerCategorie(a);
    }
    //--------------------------------------------------------------------------
       public  void afficherNumCategorie() {
		Categorie pl=new Categorie();
	    Vector<Categorie> v= new Vector<Categorie>();
	    Vector vNumEtudiant= new Vector();
	    v.addAll(DaoCategorie.getDaoCategorie().getAllCategorie());
	    for (Categorie cat : v) {
	        vNumEtudiant.add(cat.getId_categorie()+" - "+cat.getNom_categorie());
	       // IHM.combo.addItem(""+cat.getId_categorie());
	        IHM.combo.addItem(cat.getNom_categorie());
	        
	    }  
	}
       
       public void afficherGrid2(DefaultTableModel dtm){
    	   
    	   Vector<Categorie> v=DaoCategorie.getDaoCategorie().getAllCategorie();
    	   
    	   for (Categorie cat : v) {
    		   String ite[]={""+cat.getId_categorie(),cat.getNom_categorie()};
   	        dtm.addRow(ite);
   	    }  
    	   
    	   
       }
  
  
  //--------------------------------------------------------------------------------------
  //------------------------------------------Client-------------------------------------
  //-------------------------------------------------------------------------------------

       //Création de l'objet Client
  	 static Service myDaoClient;
  	 public static Service getDaoClient(){
  	        if(myDaoClient==null)
  	        	myDaoClient=new Service();
  	        return myDaoClient;
  	    }
  	 //------------------------------------------------------------------
  public void ajouterClient(IHM ihm, int id_client, String nom_client,String prenom_client,int id_cat) {
	Categorie a=new Categorie(id_cat,null);
    Client cl = new Client(id_client,nom_client,prenom_client,a);
    //DaoClient.getDaoCategorie().addCategorie(cl);  
    DaoClient.getDaoClient().addClient(cl);
    }
  //-------------------------------------------------------------------
   public void modifierClient(IHM ihm,int id_client,String nom_client,String prenom_client,int id_cat){
	Categorie a=new Categorie(id_cat,null);
	Client cl=new Client(id_client,nom_client,prenom_client,a);
	DaoClient.getDaoClient().updateClient(cl);
    }
  //------------------------------------------------------------
    public void supprimerClient(IHM ihm,int id_client){
	Client cl=new Client(id_client,null,null,null);
	DaoClient.getDaoClient().supprimerClient(cl);
     }
   //--------------------------------------------------------------------------------------------------

  public  void afficherGrid() {
	Categorie pl=new Categorie();
    Vector<Categorie> v= new Vector<Categorie>();
    v.addAll(DaoCategorie.getDaoCategorie().getAllCategorie());
    for (Categorie cat : v) {
      String ite[]={""+cat.getId_categorie(),cat.getNom_categorie()};
    }  
    }
   }



