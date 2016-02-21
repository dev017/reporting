package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import Bo.Utilisateur;
import Service.Manager;

public class DaoUtilisateur {

	 static DaoUtilisateur myDaoUtilisateur;
	 public static DaoUtilisateur getDaoUtilisateur(){
	        if(myDaoUtilisateur==null)
	        	myDaoUtilisateur=new DaoUtilisateur();
	        return myDaoUtilisateur;
	    }

	 
	 public void addClient(Utilisateur u){
			PreparedStatement ps=null;
			Connection cn=Manager.getconnexion();
			 String sql = "insert into utilisateur(logi,pass,nom,pren) values(?,?,?,?)";
		     try {
		         ps = cn.prepareStatement(sql);
		         ps.setString(1, u.getLogin());
		         ps.setString(2,u.getPassword());
		         ps.setString(3, u.getNom());
		         ps.setString(4, u.getPrenom());
		         ps.executeUpdate();
		         ps.close();
		         cn.close();
		     } catch (SQLException e) {
		         System.out.println(e.toString());
		     }
			
		}
	 
	 
	 
	 
	 
	 public void updateUtilisateur(Utilisateur u,String id){
			PreparedStatement ps=null;
			Connection cn=Manager.getconnexion();
			 String sql = "update utilisateur set logi=?,pass=?,nom=?,pren=? where id=?";
		     try {
		         ps = cn.prepareStatement(sql);
		         ps.setString(1,u.getLogin());
		         ps.setString(2, u.getPassword());
		         ps.setString(3, u.getNom());
		         ps.setString(4, u.getPrenom());
		         ps.setInt(5, Integer.parseInt(id));
		         
		         ps.executeUpdate();
		         ps.close();
		         cn.close();
		         System.out.println("Modification Ok");
		     } catch (SQLException e) {
		         System.out.println(e.toString());
		     }
			
		}
	 
	 
	 
	 public void supprimerUtilisateur(Utilisateur u) {
			Connection cn=Manager.getconnexion();
		    try {
		        PreparedStatement ps = cn.prepareStatement("delete from utilisateur where id=?");
		        ps.setInt(1,u.getId());
		     ps.executeUpdate();
		     System.out.println("Utilisateur Supprimer avec succés");
		    } catch (SQLException e) {
		        System.out.println(e.toString());
		    }
		}
	 
	 
	 
	 
	 public static Vector<Utilisateur>  getAllUtilisateur(String login,String password) {
		 Connection con=Manager.getconnexion();
	    Vector<Utilisateur> vGroupe = new Vector<Utilisateur>();
		
	            try {
		        	Statement req = con.createStatement();
		            ResultSet rs = req.executeQuery("select * from utilisateur where logi="+login+" and pass="+password);
		            while (rs.next()) {
		            	Utilisateur u = new Utilisateur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
		            	vGroupe.addElement(u);
		            	
		            }
		        } catch (SQLException e) {
		        System.out.println(e.toString());
		        System.out.println("Imposible de charger les catégories");
		        }
	       return vGroupe;
		    }
	 
	 
	 
	 
	 public static Vector<Utilisateur>  getUtilisateurByID(String id) {
		 Connection con=Manager.getconnexion();
	    Vector<Utilisateur> vGroupe = new Vector<Utilisateur>();
		
	            try {
		        	Statement req = con.createStatement();
		            ResultSet rs = req.executeQuery("select * from utilisateur where id="+Integer.parseInt(id));
		            while (rs.next()) {
		            	Utilisateur u = new Utilisateur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
		            	vGroupe.addElement(u);
		            	
		            }
		        } catch (SQLException e) {
		        System.out.println(e.toString());
		        System.out.println("Imposible de charger les catégories");
		        }
	       return vGroupe;
		    }
	 
	 
	 
	 
	 public  boolean verifUtilisateur(String login,String password) {
		Connection con=Manager.getconnexion();
		boolean trouve=false;
	            try {
		        	Statement req = con.createStatement();
		            ResultSet rs = req.executeQuery("select logi,pass from utilisateur where logi='"+login+"' and pass='"+password+"'");
		            while (rs.next()) {
		            	System.out.println("WHILE ");
		            	if((rs.getString(1).equals(login)) && (rs.getString(1).equals(login))){
		            		trouve=true;
		            		System.out.println("OUIIIIIIIII");
		            	}else{
		            		trouve=false;
		            		System.out.println("NONnnnnnnnnnnn");
		            	}
		            	
		            }
		        } catch (SQLException e) {
		        System.out.println(e.toString());
		        System.out.println("Imposible de charger les catégories");
		        }
	       return trouve;
		    }
	 
	 
	 
	 
	 
	 public  String getUtilisateur(String login,String password) {
			Connection con=Manager.getconnexion();
			boolean trouve=false;
			String nomcomplet=null;
		            try {
			        	Statement req = con.createStatement();
			            ResultSet rs = req.executeQuery("select logi,pass,nom,pren,id from utilisateur where logi='"+login+"' and pass='"+password+"'");
			            while (rs.next()) {
			            	System.out.println("WHILE ");
			            	if((rs.getString(1).equals(login)) && (rs.getString(1).equals(login))){
			            		trouve=true;
			            		System.out.println("OUIIIIIIIII");
			            		nomcomplet=String.valueOf(rs.getInt(5));
			            	}else{
			            		trouve=false;
			            		System.out.println("NONnnnnnnnnnnn");
			            	}
			            	
			            }
			        } catch (SQLException e) {
			        System.out.println(e.toString());
			        System.out.println("Imposible de charger les catégories");
			        }
		       return nomcomplet;
			    }
		 
	 
	 
	 public static List<Utilisateur>  getAllUsers() {
		 Connection con=Manager.getconnexion();
	    ArrayList<Utilisateur> lUsers = new ArrayList<Utilisateur>();
		
	            try {
		        	Statement req = con.createStatement();
		            ResultSet rs = req.executeQuery("select * from utilisateur");
		            while (rs.next()) {
		            	Utilisateur u = new Utilisateur(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
		            	lUsers.add(u);
		            	
		            }
		        } catch (SQLException e) {
		        System.out.println(e.toString());
		        System.out.println("Imposible de charger les utilisateurs");
		        }
	       return lUsers;
		    }
	 
	 
	 

}
