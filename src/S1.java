

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Bo.Utilisateur;
import Dao.DaoUtilisateur;

/**
 * Servlet implementation class S1
 */
public class S1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	   System.out.println("");
	  
	 //  if(request.getParameter("Submit").equals("Entrer")) {
		   
	   String login= request.getParameter("txt_login");
	  String password= request.getParameter("txt_password");
	  System.out.println(login+"  "+password);
	  DaoUtilisateur u=new DaoUtilisateur();
	  HttpSession session = request.getSession(true);
	  if(u.verifUtilisateur(login, password)){
		  
		  String nomComplet=u.getUtilisateur(login, password);
		     System.out.println(" nom complet "+nomComplet);
			session.removeAttribute("nom_prenom");
			session.setAttribute("nom_prenom",nomComplet);
		 response.sendRedirect("index.jsp");
		 System.out.println("==> "+session.getAttribute("nom_prenom"));
	   }else{
		   session.removeAttribute("nom_prenom");
		   response.sendRedirect("non.jsp");
	   }
	}
	   
	   
	 //  if(request.getParameter("rechercher_pyradide_age").equals("Entrer")) {
		//   String date_debut=request.getParameter("date1");
		 //  String date_fin=request.getParameter("date2");
		   
		  // System.out.println(date_debut+"  "+date_fin);
	  // }
	//}
}
