

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import Bo.Utilisateur;
import Dao.DaoUtilisateur;

/**
 * Servlet implementation class S7
 */
public class S7 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S7() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		System.out.println("  Modification utilisateur ");
		DaoUtilisateur daou=new DaoUtilisateur();
		String login=request.getParameter("txt_login");
		String password=request.getParameter("txt_password");
		String nom=request.getParameter("txt_nom");
		String prenom=request.getParameter("txt_prenom");

		Utilisateur u=new Utilisateur(login,password,nom,prenom);
		
		daou.updateUtilisateur(u,String.valueOf(session.getAttribute("nom_prenom")));
		response.sendRedirect("pyramide_age.jsp");
		
		
	}

}
