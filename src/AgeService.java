
import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.*;
import org.jfree.data.category.DefaultCategoryDataset;

import Service.Manager;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
public class AgeService {
	 static boolean ok=false;
	public static void ageParService() {
   
		
		 // - Paramètres de connexion à la base de données
//        String url = "jdbc:mysql://localhost/reporting";
//        String login = "root";
//        String password = "";

        try {
            // - Connexion à la base
//            Driver monDriver = new com.mysql.jdbc.Driver();
//            DriverManager.registerDriver(monDriver);
         // connection = DriverManager.getConnection(url, login, password);
           
            Connection connection = Manager.getconnexion();
            		
            Manager.getconnexion();
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            
            
            java.sql.Statement st = connection.createStatement(); 

    		ResultSet rs = st.executeQuery(
    				       "SELECT COUNT(*)AS NOMBRE,IF(("+
                           " AGE >15"+
                           " AND AGE <25"+
                           " ), '20-25', IF(("+
                           " AGE >25"+
                           " AND AGE <30"+
                           " ), '25-30', IF(("+
                           " AGE >30"+
                           " AND AGE <35"+
                           "), '30-35',IF(("+
                           " AGE >35"+
                           " AND AGE <40"+
                           "), '35-40', IF(("+
                           " AGE >40"+
                           " AND AGE <45"+
                           " ), '40-45',  IF(("+
                           " AGE >45"+
                           " AND AGE <50"+
                           " ), '45-50', IF(("+
                           " AGE >50 "+
                           " AND AGE <55"+
                           " ), '50-55', IF(("+
                           " AGE >55"+
                           " AND AGE <60"+
                           " ), '55-60', IF(("+
                           " AGE >60"+
                           " AND AGE <65"+
                           " ), '60-65',  IF(("+
                           " AGE >65"+
                           " AND AGE <70"+
                           " ), '65-70',  IF(("+
                           " AGE >70"+
                           " AND AGE <100"+
                           " ), '70-100', 0 ))))) )))))) AS AGEE,SERV "+
                           " FROM PERSONNEL"+
                           " GROUP BY AGEE,SERV"); 

    	int i=0;
    		while (rs.next()){ 
    			i+=1;
            System.out.println(" Dans while ");
    			dataset.addValue(Double.parseDouble(rs.getString(1)), rs.getString(2), rs.getString(3));    	
    		System.out.println(rs.getString(2));
    		}
    		System.err.println(i);
    		JFreeChart barChart = ChartFactory.createBarChart("Personnel par service", "","Nombre ", dataset, PlotOrientation.VERTICAL, true, true, false);
    		   ChartUtilities.saveChartAsJPEG(new File("E:\\chart.jpg"), barChart, 500, 300);
        }catch(Exception ex){
        	
        	System.out.println(ex.toString());
        		
	}       
}
}