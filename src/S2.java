

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.compiler.ServletWriter;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import Service.Manager;

/**
 * Servlet implementation class S2
 */
public class S2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public S2() {
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
		// TODO Auto-generated method stub
		
		super.init();
		   String date_debut=request.getParameter("date1");
		   String date_fin=request.getParameter("date2");
		   
		   System.out.println(date_debut+"  "+date_fin);
		   
		   AgeService agSer=new AgeService();
		   agSer.ageParService();
		   System.out.println("Après");
		   
		   
		   
		   
			 try {
         // - Connexion à la base
//         Driver monDriver = new com.mysql.jdbc.Driver();
//         DriverManager.registerDriver(monDriver);
//         Connection connection = DriverManager.getConnection(url, login, password);
           Manager.getconnexion();
         // - Chargement et compilation du rapport
      // ok   
           JasperDesign jasperDesign = JRXmlLoader.load("D:\\services.bak");
         	
        //   String jasperDesign ="D:\\iReport-2.0.3\\services.jasper";
           
           //"//Documents and Settings\\Admin\\report16.jrxml");
         JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

         // - Paramètres à envoyer au rapport
         Map parameters = new HashMap();
         parameters.put("Titre", "Titre");

         // - Execution du rapport
         JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, Manager.getconnexion());

         ByteArrayOutputStream pdfStream = new ByteArrayOutputStream();
         JasperExportManager.exportReportToPdfStream(jasperPrint, pdfStream);

         String filename = "C:\\Age_Service";
         response.addHeader("Content-disposition", "attachment; filename=\"" + filename + ".pdf\"");
         response.setContentLength(pdfStream.toByteArray().length);
         response.getOutputStream().write(pdfStream.toByteArray());
         response.setContentType("application/pdf");


         response.getOutputStream().flush();
         response.getOutputStream().close();
         // - Création du rapport au format PDF
         JasperExportManager.exportReportToPdfFile(jasperPrint, "E:\\Journal6.pdf");
     } catch (Exception ex1) {

         ex1.printStackTrace();
     } 
	}

}
