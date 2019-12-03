import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class mainMenu {
	
	public static void main(String args[]) throws IOException {
		
        Connection conn = null;
        
        equipmentAndSuppliesMenu esMenu;
    	customersAndServicesMenu csMenu;
    	employeesMenu eMenu;
    	updatesMenu uMenu;
        
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/PROJECT2?serverTimezone=UTC&useSSL=TRUE";
            String user, pass;
            user = "student"; //readEntry("userid : ");
            pass = "password"; //readEntry("password: ");
            conn = DriverManager.getConnection(url, user, pass);
            
            esMenu = new equipmentAndSuppliesMenu(conn);
            csMenu = new customersAndServicesMenu(conn);
            eMenu = new employeesMenu(conn);
            uMenu = new updatesMenu(conn, user, pass);
            

            boolean done = false;
            do {
                printMenu();
                System.out.print("Type in your option: ");
                System.out.flush();
                String ch = readLine();
                System.out.println();
                
                if(ch.length() > 0) {
                switch (ch.charAt(0)) {
                    case '1': 
                    	esMenu.menu();
                        break;
                    case '2':
                    	csMenu.menu();
                        break;
                    case '3':
                    	eMenu.menu();
                        break;                  
                    case '4':
                    	uMenu.menu();
                        break;
                    case '5': done = true;
                        break;
                    default:
                        System.out.println(" Not a valid option ");
                }} //switch
            } while (!done);


        } catch (ClassNotFoundException e) {
            System.out.println("Could not load the driver");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) { /* ignored */}
            }
        }
    }

    private static void Equipment_Supplies(Connection conn) throws SQLException, IOException {

        Statement stmt = conn.createStatement();
        String query = "SELECT custID, fname, lname FROM customer";
        ResultSet rset = stmt.executeQuery(query);

        System.out.println("    EQUIPMENT & SUPPLIES");
        System.out.println("--------------------------------------------------\n");

        while(rset.next()) {
        	String ssn = rset.getString(1);
        	String fname = rset.getString(2);
        	String lname = rset.getString(3);
        	System.out.println(ssn + " " + fname + " " + lname);  	
        }
        stmt.close();
    }


    private static void Customer_Services(Connection conn) throws SQLException, IOException {

        Statement stmt = conn.createStatement();
        String query = "";
        ResultSet rset = stmt.executeQuery(query);
        
        System.out.println("    CUSTOMER & SERVICES");
        System.out.println("--------------------------------------------------\n");

        while(rset.next()) {
        	String hours = rset.getString(1);
        	String ssn = rset.getString(2);
        	String fname = rset.getString(3);
        	String lname = rset.getString(4);
        	System.out.println(ssn + " " + fname + " " + lname + " " + hours);
        	
        }
        stmt.close();
    }
    
    private static void Employees(Connection conn) throws SQLException, IOException {

        Statement stmt = conn.createStatement();
        String query = "SELECT SUM(hours) as totalHours, ssn, fname, lname FROM employee, works_on WHERE ssn = essn GROUP BY ssn ORDER BY totalHours DESC";
        ResultSet rset = stmt.executeQuery(query);

        System.out.println("    EMPLOYEES");
        System.out.println("--------------------------------------------------\n");

        while(rset.next()) {
        	String hours = rset.getString(1);
        	String ssn = rset.getString(2);
        	String fname = rset.getString(3);
        	String lname = rset.getString(4);
        	System.out.println(ssn + " " + fname + " " + lname + " " + hours);
        }
        stmt.close();
    }
    
    private static void Updates(Connection conn) throws SQLException, IOException {

        Statement stmt = conn.createStatement();
        String query = "SELECT SUM(hours) as totalHours, ssn, fname, lname FROM employee, works_on WHERE ssn = essn GROUP BY ssn ORDER BY totalHours DESC";
        ResultSet rset = stmt.executeQuery(query);

        System.out.println("    UPDATES");
        System.out.println("--------------------------------------------------\n");

        while(rset.next()) {
        	String hours = rset.getString(1);
        	String ssn = rset.getString(2);
        	String fname = rset.getString(3);
        	String lname = rset.getString(4);
        	System.out.println(ssn + " " + fname + " " + lname + " " + hours);
        }
        stmt.close();
    }

    static String readEntry(String prompt) {
        try {
            StringBuffer buffer = new StringBuffer();
            System.out.print(prompt);
            System.out.flush();
            int c = System.in.read();
            while(c != '\n' && c != -1) {
                buffer.append((char)c);
                c = System.in.read();
            }
            return buffer.toString().trim();
        } catch (IOException e) {
            return "";
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

    private static void printMenu() {
        System.out.println("*************************************************************************************");
        System.out.println("                                *******************                                  ");
        System.out.println("                             Welcome to Clean-and-Go Shop                            ");
        System.out.println("                                *******************                                  ");
        System.out.println("*************************************************************************************");
        System.out.println("                              1. Equipment & Supplies                                ");
        System.out.println("                              2. Customers & Services                                ");
        System.out.println("                                    3. Employees                                     ");
        System.out.println("                                     4. Updates                                      ");
        System.out.println("                                      5. Quit                                        ");
        System.out.println("*************************************************************************************");
        System.out.println();
    }
}


