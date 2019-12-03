import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class employeesMenu {
	Connection conn = null;
	
	public employeesMenu(Connection Conn) {
		conn = Conn;
	}
	
	public void menu() throws SQLException {
		Boolean inMenu = true;
		while(inMenu) {
			printMenu();
			System.out.print("Type in your option: ");
            System.out.flush();
			String ch = readLine();
	        System.out.println();
	        
	        if(ch.length() > 0) {
	        switch (ch.charAt(0)) {
            case '1': employeeSchedule();
                break;
            case '2': inMenu = false;
            	break;
            default:
                System.out.println(" Not a valid option ");
	        }}
		}
	}
	
	private void employeeSchedule() throws SQLException {
		System.out.print("Enter Employee ID: ");
        System.out.flush();
		String input = readLine();
	    System.out.println();
	     
		Statement stmt  = conn.createStatement();
        String query = "SELECT eID,MHours,THours,WHours,"
        		+ "TRHours,FHours,SAHours,SUHours "
        		+ "FROM employee_schedule "
        		+ "WHERE eID = " + input;
        ResultSet rset = stmt.executeQuery(query);
        
        System.out.println("                                EMPLOYEE WORK SCHEDULE");
        System.out.println();
        System.out.println("employee ID     Monday     Tuesday    Wednesday  Thursday   Friday     Saturday   Sunday");
        System.out.println("----------------------------------------------------------------------------------------");
       
        while(rset.next()) {
            int eId = rset.getInt("eId");
            float m = rset.getFloat("MHours");
            float t = rset.getFloat("THours");
            float w = rset.getFloat("WHours");
            float th = rset.getFloat("TRHours");
            float f = rset.getFloat("FHours");
            float sa = rset.getFloat("SAHours");
            float su = rset.getFloat("SUHours");
            
            System.out.println(eId+"                "+m+"       "+t+"       "+w+"       "+th+"       "
                       +f+"       "+sa+"       "+sa+"\n\n");
        }
        
        System.out.print("Press enter to continue...");
        readLine();
	}
	
    private static String readLine() {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr, 1);
        String line = "";

        try {
            line = br.readLine();
        } catch (IOException e) {
            System.out.println("Error in SimpleIO.readLine: " +
                    "IOException was thrown");
            System.exit(1);
        }
        
        return line;
    }
    
    private void printMenu() {
        System.out.println("*************************************************************************************");
        System.out.println("                                *******************                                  ");
        System.out.println("                             Welcome to Clean-and-Go Shop                            ");
        System.out.println("                                       Employees                                     ");
        System.out.println("*************************************************************************************");
        System.out.println("                             1. Employee Schedule                                    ");
        System.out.println("                             2. Go Back                                              ");
        System.out.println("*************************************************************************************");
    }
}
