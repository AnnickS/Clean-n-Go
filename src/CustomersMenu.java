import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

public class CustomersMenu {
	Connection conn = null;
   
   public CustomersMenu(Connection Conn) {
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
        System.out.println("-----------------\n");
        Statement stmt = conn.createStatement();
        String query = "SELECT sName FROM service";
        ResultSet rset = stmt.executeQuery(query);
        while(rset.next()){
         String servName = rset.getString(1);
         System.out.prinln(ServName);
         }
        System.out.println("-----------------\n");
        System.out.print("Type in your option: ");
        System.out.flush();
		  String input = readLine();
	     System.out.println();
         
        Statement stmt = conn.createStatement();
        String query = "SELECT fName, lName " + 
                       "FROM customer AS C, uses AS U, service AS S " + 
                       "WHERE C.custID = U.cID " + 
                       "AND U.servID = S.servID " + 
                       "AND sName like \"%" + input + "%\"";
        ResultSet rset = stmt.executeQuery(query);

        System.out.println("Customers:");
        System.out.println("----------\n");

        while(rset.next()) {
        	String custFName = rset.getString(1);
        	String custLName = rset.getString(2);
        	System.out.println(custFName + " " + custLName);  	
        }
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
                       "YEAR(useDate) = " + input + 
                       " GROUP BY MONTH(useDate)";
        ResultSet rset = stmt.executeQuery(query);

        System.out.println("Customers per month in" + input + ":");
        System.out.println("-------------------\n");

        while(rset.next()) {
        	String month = rset.getString(1);
         String monthName = monthCalc(month);
        	String CN = rset.getString(2);
        	System.out.println(monthName + " " + CN);  	
        }
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

    private static string monthCalc(string monthNumber){
      if(monthNumber == "1"){
         return "Jan";
      }else if(monthNumber == "2"){
         return "Feb";
      }else if(monthNumber == "3"){
         return "Mar";
      }else if(monthNumber == "4"){
         return "Apr";               
      }else if(monthNumber == "5"){
         return "May";
      }else if(monthNumber == "6"){
         return "Jun";
      }else if(monthNumber == "7"){
         return "Jul";
      }else if(monthNumber == "8"){
         return "Aug";}
      }else if(monthNumber == "9"){
         return "Sep";
      }else if(monthNumber == "10"){
         return "Oct";
      }else if(monthNumber == "11"){
         return "Nov;
      }else if(monthNumber == "12"){
         return "Dec";
      }else{
         return"";
      }
   }
}
