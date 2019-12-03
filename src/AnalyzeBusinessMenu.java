import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AnalyzeBusinessMenu {
	Connection conn = null;
   
   public AnalyzeBusinessMenu(Connection Conn) {
		conn = Conn;
	}
   
	public void menu() throws SQLException, IOException {
		Boolean inMenu = true;
		
		while(inMenu) {
			
			printMenu();
			System.out.print("Type in your option: ");
            System.out.flush();
			String ch = readLine();
	        System.out.println();
	        
	        if(ch.length() > 0) {
	        switch (ch.charAt(0)) {
            case '1': total_New_Customers();
               break;
            case '2': total_Service_Transactions();
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
    
    private void total_New_Customers() throws SQLException, IOException {
    
        System.out.print("Enter year: ");
        System.out.flush();
		  String input = readLine();
	     System.out.println();

        Statement stmt = conn.createStatement();
        String query = "SELECT count(custID) " +  
                       "FROM customer " + 
                       "WHERE YEAR(signDate) = " + input;
        ResultSet rset = stmt.executeQuery(query);

        if(rset.next()) {
        	System.out.println("New customers in " + input + ": " + rset.getString(1));
        }
        System.out.println("\nPress enter to continue...");
        readLine();
        stmt.close();
    }
    
    private void total_Service_Transactions() throws SQLException, IOException {

    	System.out.print("Enter year: ");
        System.out.flush();
        String input1 = readLine();
        System.out.println();
        
        System.out.print("Enter month: ");
        System.out.flush();
        String input2 = readLine();
        System.out.println();
        
        Statement stmt = conn.createStatement();
        String query = "SELECT count(*) " + 
                       "FROM uses " + 
                       "WHERE YEAR(useDate) = " + input1 + 
                       " AND MONTH(useDate) = " + input2 + "";
        ResultSet rset = stmt.executeQuery(query);

        if(rset.next()) {
        	System.out.println("Services in " + monthCalc(input2) + " " + input1 + ": " + rset.getString(1));
        }
        System.out.println("\nPress enter to continue...");
        readLine();
        stmt.close();
    }
    
    
    private void printMenu() {
        System.out.println("*************************************************************************************");
        System.out.println("                                *******************                                  ");
        System.out.println("                             Welcome to Clean-and-Go Shop                            ");
        System.out.println("                       1. Analyze the progress of the business                       ");
        System.out.println("*************************************************************************************");
        System.out.println("                           1. Total number of new customers                          ");
        System.out.println("                        2. Total number of service transactions                      ");
        System.out.println("                                       3. Quit                                       ");        
        System.out.println("*************************************************************************************");
    }
    
    private static String monthCalc(String monthNumber){
        if(monthNumber.equals("1")){
           return "Jan";
        }else if(monthNumber.equals("2")){
           return "Feb";
        }else if(monthNumber.equals("3")){
           return "Mar";
        }else if(monthNumber.equals("4")){
           return "Apr";               
        }else if(monthNumber.equals("5")){
           return "May";
        }else if(monthNumber.equals("6")){
           return "Jun";
        }else if(monthNumber.equals("7")){
           return "Jul";
        }else if(monthNumber.equals("8")){
           return "Aug";
        }else if(monthNumber.equals("9")){
           return "Sep";
        }else if(monthNumber.equals("10")){
           return "Oct";
        }else if(monthNumber.equals("11")){
           return "Nov";
        }else if(monthNumber.equals("12")){
           return "Dec";
        }else{
           return"";
        }
     }
}
