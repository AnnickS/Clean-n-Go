import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class InsertMenu {
	Connection conn = null;
	
	public InsertMenu(Connection Conn) {
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
            case '1': insertEquipment();
                break;
            case '2': insertService();
                break;
            case '3': insertCustomer();
                break;
            case '4': insertEmployee();
                break;
            case '5': inMenu = false;
            	break;
            default:
                System.out.println(" Not a valid option ");
	        }}
		}
	}
	
	private void insertEquipment() throws SQLException {
		System.out.println("Service currently unavailable.");
	}
	
	private void insertService() {
		System.out.println("Service currently unavailable.");
	}
	
	private void insertCustomer() {
		System.out.println("Service currently unavailable.");
	}
	
	private void insertEmployee() {
		System.out.println("Service currently unavailable.");
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
        System.out.println("                                  Updates : Insert                                   ");
        System.out.println("*************************************************************************************");
        System.out.println("                             1. Equipment                                            ");
        System.out.println("                             2. Service                                              ");
        System.out.println("                             3. Customer                                             ");
        System.out.println("                             4. Employee                                             ");
        System.out.println("                             5. Go Back                                              ");
        System.out.println("*************************************************************************************");
    }
}
