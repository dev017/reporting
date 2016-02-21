import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
//public class Main {
//	public static void main(String[] args) {
//		try {
//			String file = "C:\\Users\\Ihab\\report2.jrxml";

public class Mainn {
	public static void main(String[] args) {
		try {
		//	InputStream file = Main.class.getClassLoader().getResourceAsStream("D://hicham//a.jrxml");
		//	JasperDesign jasperDesign = JRXmlLoader.load(file);
			//JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			
			
//			JasperDesign jasperDesign = JRXmlLoader.load("C://Users//Ihab//report3.jrxml");
//	        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
//	            
	        
			
			String jrxmlFile = "C://Users//Ihab//report3.jrxml";

			JasperDesign jasperDesign = JRXmlLoader.load(jrxmlFile);

			JasperReport jasperReport2 = JasperCompileManager
					.compileReport(jasperDesign);

			
			
			Map<String, Object> parameters = new HashMap<String, Object>();			
			
			List<Employee> employees = createEmployees();			
			JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(employees);
			
			System.out.println("Coll => "+employees);
			
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport2, parameters, dataSource);
			JasperExportManager.exportReportToPdfFile(jasperPrint, "D://List_table_report.pdf");
		} catch (Exception e) {
			System.out.println("Impossible de créer le rapport: " + e.getMessage());
		}
	}
	
	public static List<Employee> createEmployees() {
		List<Employee> employees = new ArrayList<Employee>();
		
		employees.add(new Employee("Doe", "John"));
		employees.add(new Employee("Smith", "Jane"));
		employees.add(new Employee("Gates", "Bill"));
		
		return employees;
	}
}