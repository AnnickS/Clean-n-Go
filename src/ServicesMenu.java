import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServicesMenu {
	Connection conn = null;
   
   public ServicesMenu(Connection Conn) {
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
            case '1': requested_Services(conn);
               break;
            case '2': service_Transactions(conn);
               break;
            case '3': annual_Revenues(conn);
               break;
            case '4': inMenu = false;
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
    
    private static void requested_Services(Connection conn) throws SQLException, IOException {

        Statement stmt = conn.createStatement();
        String query = "SELECT S.sName, U.servId, count(*) " + 
                       "FROM service AS S, uses as U " + 
                       "WHERE U.servID = S.servID " + 
                       "GROUP BY servID " + 
                       "ORDER BY count(*) DESC";
        ResultSet rset = stmt.executeQuery(query);

        System.out.println("Requested Service in Descending Order:");

        while(rset.next()) {
        	String serviceName = rset.getString(1);
        	String serviceCount = rset.getString(3);
        	System.out.println(serviceName + ": " + serviceCount + " occurences");  	
        }
        System.out.println("\nPress enter to continue...");
        readLine();
        stmt.close();
    }
    
    private static void service_Transactions(Connection conn) throws SQLException, IOException {

        System.out.print("Enter year: ");
        System.out.flush();
		  String inputYear = readLine();
	     System.out.println();
        System.out.print("First month: ");
        System.out.flush();
		  String inputSMonth = readLine();
	     System.out.println();
        System.out.print("Second month: ");
        System.out.flush();
		  String inputFMonth = readLine();
	     System.out.println();
        String firstMonth = monthCalc(inputSMonth);
        String lastMonth = monthCalc(inputFMonth);

        Statement stmt = conn.createStatement();
        String query = "SELECT MONTH(useDate), count(*) " + 
                       "FROM uses " + 
                       "WHERE YEAR(useDate) = " + inputYear + 
                       " AND MONTH(useDate) >= " + inputSMonth + 
                       " AND MONTH(useDate) <= " + inputFMonth +
                       " GROUP BY MONTH(useDate)";
        ResultSet rset = stmt.executeQuery(query);

        System.out.println("Services transactions from " + firstMonth + " to " + lastMonth + " in " + inputYear);

        while(rset.next()) {
        	String month = rset.getString(1);
        	String count = rset.getString(2);
        	String monthName = monthCalc(month);
        	System.out.println(monthName + " " + count);  	
        }
        System.out.println("\nPress enter to continue...");
        readLine();
        stmt.close();
    }

    private static void annual_Revenues(Connection conn) throws SQLException, IOException {
    
        System.out.print("Enter year: ");
        System.out.flush();
		  String input = readLine();
	     System.out.println();

        Statement stmt = conn.createStatement();
        String query = "SELECT sName, SUM(S.rate * S.servTime) " + 
                       "FROM service AS S, uses AS U " + 
                       "WHERE S.servID = U.servID " + 
                       "AND YEAR(useDate) = " + input + 
                       " GROUP BY sName";
        ResultSet rset = stmt.executeQuery(query);

        System.out.println("Annual revenues from services:");

        while(rset.next()) {
        	String service = rset.getString(1);
        	String amount = rset.getString(2);
        	System.out.println(service + " generated " + amount + " in " + input);  	
        }
        System.out.println("\nPress enter to continue...");
        readLine();
        stmt.close();
    }
    
    private void printMenu() {
        System.out.println("*************************************************************************************");
        System.out.println("                                *******************                                  ");
        System.out.println("                             Welcome to Clean-and-Go Shop                            ");
        System.out.println("                                    2. Services                                      ");
        System.out.println("*************************************************************************************");
        System.out.println("                               1. Requested services                                 ");
        System.out.println("                              2. Service transactions                                ");
        System.out.println("                           3. Annual revenues from services                          ");
        System.out.println("                                      4. Quit                                        ");
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