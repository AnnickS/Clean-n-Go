import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

public class AnalyzeBusinessMenu {
	Connection conn = null;
   
   public AnalyzeBusinessMenu(Connection Conn) {
		conn = Conn;
	}
   
	public void menu() {
		Boolean inMenu = true;
		while(inMenu) {
			printMenu();
			System.out.print("Type in your option: ");
            System.out.flush();
			String ch = readLine();
	        System.out.println();
	        
	        if(ch.length() > 0) {
	        switch (ch.charAt(0)) {
            case '1': total_New_Customers(conn);
               break;
            case '2': total_Service_Transactions(conn);
               break;
            case '3': inMenu = false;
               break;
            default:
                System.out.println(" Not a valid option ");
	        }}
		}
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
    
    private static void total_New_Customers(Connection conn) throws SQLException, IOException {
    
        System.out.print("Enter year: ");
        System.out.flush();
		  String input = readLine();
	     System.out.println();

        Statement stmt = conn.createStatement();
        String query = "SELECT count(custID) " +  
                       "FROM customer " + 
                       "WHERE YEAR(signDate) = " + input;
        ResultSet rset = stmt.executeQuery(query);

        System.out.println("New customers in " + input ":");
        System.out.println("------------------- ---\n");

        while(rset.next()) {
        	String output = rset.getString(1);
        	System.out.println(output);  	
        }
        stmt.close();
    }
    
    private static void total_Service_Transactions(Connection conn) throws SQLException, IOException {

        Statement stmt = conn.createStatement();
        String query = "SELECT count(*) " + 
                       "FROM uses " + 
                       "WHERE YEAR(useDate) = 2019 " + 
                       "AND MONTH(useDate) = 11";
        ResultSet rset = stmt.executeQuery(query);

        System.out.println("Services last Month:");
        System.out.println("---------------- --\n");

        while(rset.next()) {
        	String output = rset.getString(1);
        	System.out.println(output);  	
        }
        stmt.close();
    }
    
    
    private void printMenu() {
        System.out.println("*************************************************************************************");
        System.out.println("                                *******************                                  ");
        System.out.println("                             Welcome to Clean-and-Go Shop                            ");
        System.out.println("                       1. Analyze the progress of the business                       ");
        System.out.println("*************************************************************************************");
        System.out.println("                           1. Total number of new customers                          ");
        System.out.println("                        2. Total number of serice transactions                       ");
        System.out.println("                                       3. Quit                                       ");        
        System.out.println("*************************************************************************************");
    }
}
