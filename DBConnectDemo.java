import java.io.ObjectInputFilter.Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DBConnectDemo {
 Connection con = null;
	public static void main(String[] args) throws Exception {
		DBConnectDemo demo=new DBConnectDemo();
		demo.getConnection();
		demo.selectEmployeesByID(1006);
		System.out.println("......");
		demo.selectAllEmployees();
		//selectEmployeeByID(1001);

}
public   void getConnection() throws Exception{
	Class.forName("oracle.jdbc.driver.OracleDriver");
	String url="jdbc:oracle:thin:@localhost:1520:xe";
	String userName ="scott";
	String password ="tiger";
	Connection con=DriverManager.getConnection(url,userName,password);
	System.out.println("Connectin success");
}

public void selectAllEmployees() throws Exception{
	
	
}
public  void selectEmployeeByID() throws Exception {
	String query ="select * from employee order by name";
	System.out.println("Query:" + query);
	Statement stmt=con.createStatement();
	ResultSet rs =stmt.executeQuery(query);
	while(rs.next()) {
		System.out.println(rs.getInt(1)+" ");
		System.out.println(rs.getString(2)+" ");
		System.out.println(rs.getFloat(3)+" ");
		System.out.println(rs.getInt(4)+" ");
		System.out.println();
		
	}
}
public Employee  selectEmployeesByID(int empID) throws Exception {
	String query = "select * from employee where empid =" + empID;
	System.out.println("Query: "+query);
	Statement stmt = con.createStatement();
	ResultSet rs=stmt.executeQuery(query);
	int id=0;
	String name="";
	String gender="";
	float sal=0f;
	employee emp=new Employee();
	if(rs.next()) {
		//System.out.println(rs.getInt(1)+" ");
		//System.out.println(rs.getString(2)+" ");
		//System.out.println(rs.getFloat(3)+" ");
		//System.out.println(rs.getInt(4)+" ");
		id=rs.getInt(1);
		name=rs.getString(2);
		sal=rs.getFloat(3);
		gender = rs.getString(4);
		emp.setEmpId(id);
		emp.setGender(gender);
		emp.setSal(sal);
		emp.setName(name);
		
	}
	return emp ;
}
}