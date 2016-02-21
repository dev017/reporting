package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Service.Manager;
import Bo.Categorie;
import Bo.Client;

public class DaoClient {

	 static DaoClient myDaoClient;
	 public static DaoClient getDaoClient(){
	        if(myDaoClient==null)
	        	myDaoClient=new DaoClient();
	        return myDaoClient;
	    }

	 
	 public void addClient(Client cl){
			PreparedStatement ps=null;
			Connection cn=Manager.getconnexion();
			 String sql = "insert into client values(?,?,?,?)";
		     try {
		         ps = cn.prepareStatement(sql);
		         ps.setInt(1, cl.getId_client());
		         ps.setString(2,cl.getNom_client());
		         ps.setString(3, cl.getPrenom_client());
		         ps.setInt(4, cl.getCat().getId_categorie());
		         ps.executeUpdate();
		         ps.close();
		         cn.close();
		     } catch (SQLException e) {
		         System.out.println(e.toString());
		     }
			
		}
	 
	 
	 
	 
	 
	 public void updateClient(Client cl){
			PreparedStatement ps=null;
			Connection cn=Manager.getconnexion();
			 String sql = "update client set nom_client=?,prenom_client=?,id_cat=? where id_client=?";
		     try {
		         ps = cn.prepareStatement(sql);
		         ps.setString(1,cl.getNom_client());
		         ps.setString(2, cl.getPrenom_client());
		         ps.setInt(3, cl.getCat().getId_categorie());
		         ps.setInt(4, cl.getId_client());
		         ps.executeUpdate();
		         ps.close();
		         cn.close();
		     } catch (SQLException e) {
		         System.out.println(e.toString());
		     }
			
		}
	 
	 
	 
	 public void supprimerClient(Client cl) {
			Connection cn=Manager.getconnexion();
		    try {
		        PreparedStatement ps = cn.prepareStatement("delete from client where id_client=?");
		        ps.setInt(1,cl.getId_client());
		     ps.executeUpdate();
		        JOptionPane.showMessageDialog(null, "Client Supprimer avec succés");
		    } catch (SQLException e) {
		        JOptionPane.showMessageDialog(null, e.toString(), "Message", JOptionPane.INFORMATION_MESSAGE);
		    }
		}
	 
	 

}
