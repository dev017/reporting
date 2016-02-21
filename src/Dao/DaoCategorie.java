package Dao;
import Bo.*;
import Service.*;
import java.sql.*;
import javax.swing.*;
import java.util.*;
public class DaoCategorie {
	
	 static DaoCategorie myDaoCategorie;
	 public static DaoCategorie getDaoCategorie(){
	        if(myDaoCategorie==null)
	        	myDaoCategorie=new DaoCategorie();
	        return myDaoCategorie;
	    }
	 
public void addCategorie(Categorie c){
	PreparedStatement ps=null;
	Connection cn=Manager.getconnexion();
	 String sql = "insert into categorie values(?,?)";
     try {
         ps = cn.prepareStatement(sql);
         ps.setInt(1, c.getId_categorie());
         ps.setString(2,c.getNom_categorie());
         ps.executeUpdate();
         ps.close();
         cn.close();
     } catch (SQLException e) {
         System.out.println("erreur de l'insertion");
     }
	
}



public void updateCategorie(Categorie c) {
	Connection cn=Manager.getconnexion();
    try {
        PreparedStatement ps = cn.prepareStatement("update categorie set nom_cat=? where id_cat=?");
        ps.setInt(2,c.getId_categorie());
        ps.setString(1, c.getNom_categorie());

        ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Categorie modifié avec succés");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.toString(), "Message", JOptionPane.INFORMATION_MESSAGE);
    }
}



public void supprimerCategorie(Categorie c) {
	Connection cn=Manager.getconnexion();
    try {
        PreparedStatement ps = cn.prepareStatement("delete from categorie where id_cat=?");
        ps.setInt(1,c.getId_categorie());
     ps.executeUpdate();
        JOptionPane.showMessageDialog(null, "Auteur Supprimer avec succés");
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, e.toString(), "Message", JOptionPane.INFORMATION_MESSAGE);
    }
}


public static Vector<Categorie>  getAllCategorie() {
	 Connection con=Manager.getconnexion();
    Vector<Categorie> vGroupe = new Vector<Categorie>();
	
            try {
	        	Statement req = con.createStatement();
	            ResultSet rs = req.executeQuery("select * from categorie");
	            while (rs.next()) {
	            	Categorie g = new Categorie(rs.getInt(1), rs.getString(2));
	            	vGroupe.addElement(g);
	            	
	            }
	        } catch (SQLException e) {
	        	JOptionPane.showMessageDialog(null,e.toString() );
	            JOptionPane.showMessageDialog(null, "Imposible de charger les catégories", "Message", JOptionPane.INFORMATION_MESSAGE);
	        }
       return vGroupe;
	    }



}
