import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

public class UpdateMenu {
	Connection conn = null;
	
	public UpdateMenu(Connection Conn) {
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
            case '1': updateEquipment();
                break;
            case '2': updateService();
                break;
            case '3': updateCustomer();
                break;
            case '4': updateEmployee();
                break;
            case '5': inMenu = false;
            	break;
            default:
                System.out.println(" Not a valid option ");
	        }}
		}
	}
	
	private void updateEquipment() {
		System.out.println("Service currently unavailable.");
	}
	
	private void updateService() {
		System.out.println("Service currently unavailable.");
	}
	
	private void updateCustomer() {
		System.out.println("Service currently unavailable.");
	}
	
	private void updateEmployee() {
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
        System.out.println("                                   Updates : Update                                  ");
        System.out.println("*************************************************************************************");
        System.out.println("                             1. Equipment                                            ");
        System.out.println("                             2. Service                                              ");
        System.out.println("                             3. Customer                                             ");
        System.out.println("                             4. Employee                                             ");
        System.out.println("                             5. Go Back                                              ");
        System.out.println("*************************************************************************************");
    }
}
