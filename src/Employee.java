public class Employee {
	private String name;
	private String firstName;
//	private Department department;
	public Employee(String name, String firstName) {
		this.name = name;
		this.firstName = firstName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
//	public Department getDepartment() {
//		return department;
//	}
//	public void setDepartment(Department department) {
//		this.department = department;
//	}
}