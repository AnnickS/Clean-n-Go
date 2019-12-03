import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CustomersMenu {
	Connection conn = null;
   
   public CustomersMenu(Connection Conn) {
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
            case '1': customer_List(conn);
               break;
            case '2': customer_Number(conn);
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
    
    private static void customer_List(Connection conn) throws SQLException, IOException {
    
        System.out.println("Our services are:");
        Statement stmt = conn.createStatement();
        String query = "SELECT sName FROM service";
        ResultSet rset = stmt.executeQuery(query);
        while(rset.next()){
         String servName = rset.getString(1);
         System.out.println(servName);
         }
        
        System.out.print("\nType in your option: ");
        System.out.flush();
		  String input = readLine();
	     System.out.println();
         
        stmt = conn.createStatement();
        query = "SELECT fName, lName " + 
                       "FROM customer AS C, uses AS U, service AS S " + 
                       "WHERE C.custID = U.cID " + 
                       "AND U.servID = S.servID " + 
                       "AND sName like \"%" + input + "%\"";
        rset = stmt.executeQuery(query);

        System.out.println("Customers:");

        while(rset.next()) {
        	String custFName = rset.getString(1);
        	String custLName = rset.getString(2);
        	System.out.println(custFName + " " + custLName);  	
        }
        System.out.println("\nPress enter to continue...");
        readLine();
        stmt.close();
    }
    
    private static void customer_Number(Connection conn) throws SQLException, IOException {
    
        System.out.print("Enter year: ");
        System.out.flush();
		  String input = readLine();
	     System.out.println();

        Statement stmt = conn.createStatement();
        String query = "SELECT MONTH(useDate), count(*) " + 
                       "FROM customer AS C, uses AS U " +
                       "WHERE C.custID = U.cID " +
                       "AND YEAR(useDate) = " + input + 
                       " GROUP BY MONTH(useDate)";
        ResultSet rset = stmt.executeQuery(query);

        System.out.println("Customers per month in " + input + ":");
        
        while(rset.next()) {
        	String month = rset.getString(1);
         String monthName = monthCalc(month);
        	String CN = rset.getString(2);
        	System.out.println(monthName + " " + CN);  	
        }
        System.out.println("\nPress enter to continue...");
        readLine();
        stmt.close();
    }
    
    private void printMenu() {
        System.out.println("*************************************************************************************");
        System.out.println("                                *******************                                  ");
        System.out.println("                             Welcome to Clean-and-Go Shop                            ");
        System.out.println("                                    3. Customers                                     ");
        System.out.println("*************************************************************************************");
        System.out.println("                            1. Customer list for a service                           ");
        System.out.println("                                  2. Customer number                                 ");
        System.out.println("                                      3. Quit                                        ");
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
