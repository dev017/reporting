
import java.io.*;
import java.sql.*;

import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.jfree.data.*;
import org.jfree.data.category.DefaultCategoryDataset;

import Service.Manager;

import com.mysql.jdbc.Driver;
import com.mysql.jdbc.Statement;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;
public class TypeContratService {
	
	public  void typeContratService() throws IOException {
   
		
		
        try {
        	
        	 Connection connection=Manager.getconnexion();
     		
            
            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
            
            
            java.sql.Statement st = connection.createStatement(); 

    		ResultSet rs = st.executeQuery(
    				       "SELECT count(TYPE_CONT) , SERV"+
                           " FROM PERSONNEL P "+
                           " GROUP BY SERV"); 

    		while (rs.next()){ 
            System.out.println(" Dans while ");
    			dataset.addValue(Double.parseDouble(rs.getString(1)), rs.getString(2), rs.getString(2));    	
    		}
    		JFreeChart barChart = ChartFactory.createBarChart(" ", "","  ", dataset, PlotOrientation.VERTICAL, true, true, false);
    		   ChartUtilities.saveChartAsJPEG(new File("E:\\chart.jpg"), barChart, 500, 300);
        }catch(Exception ex){
        	
        	System.out.println(ex.toString());
        }			
	}
}
