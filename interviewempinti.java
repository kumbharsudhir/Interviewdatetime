package interview;
import java.sql.*;
import java.util.*;

public class interviewempinti{

	public static void main(String[] args)  throws Exception {
		// TODO Auto-generated method stub
		interviewempinti inter=new interviewempinti();
		Scanner select=new Scanner(System.in);
		while(true)
		{
		System.out.println("\n");
		System.out.println("Welcome To Interview Invite Session.");
		System.out.println(" 1.Create Interview Session.\n 2.Check Interview.\n 3.Update Interview Date.\n 4.Delete interview. \n 5.Exit.");
		int ch=select.nextInt();
		switch(ch)
		{
		case 1: inter.Insert();
		break;
		case 2: inter.Read();
		break;
		case 3: inter.Update();
		break;
		case 4: inter.Delete();
		break;
		case 5: System.out.print("Thank You For Using Software System.");
		System.exit(0);
		default: System.out.println("Invalid number enter between 1 to 4");
		}
	}
	}
	
	public void Insert() throws Exception {
		
		System.out.println("Connecting to database...");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","SUDHIRk$@79179189");
		System.out.println("Connected Successfully");
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter Empolyee name");
		String pname =sc.nextLine();
		System.out.println("Enter HR name");
		String dname =sc.nextLine();
		System.out.println("Enter interview contact number");
		Long contact =sc.nextLong();
		Scanner input = new Scanner(System.in);
		System.out.println("Enter interview Session date in (yyyy-mm-dd)");
		String strdate =input.nextLine();
		
		String query = "INSERT INTO interview(pname,dname,phone,apdate) VALUES (?, ?, ?, ?)";
	    PreparedStatement pstmt = con.prepareStatement(query);
	    
	    pstmt.setString(1, pname);
	    pstmt.setString(2, dname);
	    pstmt.setLong(3, contact);
	    pstmt.setString(4, strdate);
	    
	    int i= pstmt.executeUpdate();
	    
		if(i==1)
		{
			System.out.println("interview Session created Successfully");
		}
		else 
		{
			System.out.println("interview Session created Unsuccessfully");
		}
		con.close();  
	}
	
	public void Read() throws Exception
	{
		System.out.println("Connecting to database...");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","SUDHIRk$@79179189");	
		System.out.println("Connected Successfully");
		
		Scanner sc1= new Scanner(System.in);
		System.out.println("Enter mobile number to check Session interview Datails");
		Long contact =sc1.nextLong();
		
		Statement pstmt=con.createStatement();
		String query = "Select pname,dname,phone,apdate from interview where phone ="+contact;
		ResultSet rs=pstmt.executeQuery(query);
		if(rs.next()==false)
		{
			System.out.println("No  Available Interview Session");
		}
		else 
		{
			do
			{	
				System.out.println("Empolyee name = " +rs.getString(1));
				System.out.println("HR name = " +rs.getString(2));
				System.out.println("interview contact number = " +rs.getString(3));
				System.out.println("interview Session Date = " +rs.getString(4));
					
			}while(rs.next());
		}
		System.out.println();
		con.close();  
	}
	
	public void Update() throws Exception
	{
		System.out.println("Connecting to database...");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","SUDHIRk$@79179189");
		System.out.println("Connected Successfully");
		
		Scanner sc1= new Scanner(System.in);
		System.out.println("Enter you mobile number to update interview Session Date");
		Long contact =sc1.nextLong();
		Scanner input = new Scanner(System.in);
		System.out.println("Change interview date in (yyyy-mm-dd)");
		String strdate =input.nextLine();
			
		String query = "Update interview set apdate='"+strdate+"'where phone="+contact;
		PreparedStatement pstmt = con.prepareStatement(query);
		    
		int u= pstmt.executeUpdate();
		if(u==1)
		{
			System.out.println("interview Session Date updated Successfully");
		}
		else 
		{
			System.out.println("Can't Interview Session Update Date. ");
		}
		
		Statement st=con.createStatement();
		String query1 = "Select pname,dname,phone,apdate from interview where phone ="+contact;
		ResultSet rs=st.executeQuery(query1);
		while(rs.next())
		{
			System.out.println("Empoyee name = " +rs.getString(1));
			System.out.println("HR name = " +rs.getString(2));
			System.out.println("interview contact number  = " +rs.getString(3));
			System.out.println("Interview  Session Date = " +rs.getString(4));
		}
		con.close();  
	}
	
	public void Delete() throws Exception
	{
		System.out.println("Connecting to database...");
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql","root","SUDHIRk$@79179189");
		System.out.println("Connected Successfully");
		
		Scanner sc1= new Scanner(System.in);
		System.out.println("Enter you mobile number to delete interview Session");
		Long contact =sc1.nextLong();
		
		String query = "Delete from interview where phone="+contact;
		PreparedStatement pstmt = con.prepareStatement(query);
		int d =pstmt.executeUpdate();
		if(d==1)
		{
			System.out.println("Interview Session  Deleted Successfully");
		}
		else 
		{
			System.out.println("Interview Session Deletion Unsuccessfully");
		}
		con.close(); 
	}
	


}




