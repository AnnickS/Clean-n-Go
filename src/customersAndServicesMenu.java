import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;

public class customersAndServicesMenu {
	Connection conn = null;
	
	public customersAndServicesMenu(Connection Conn) {
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
            case '1': inMenu = false;
                break;
            default:
                System.out.println(" Not a valid option ");
	        }} //switch
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
    
    private void printMenu() {
        System.out.println("*************************************************************************************");
        System.out.println("                                *******************                                  ");
        System.out.println("                             Welcome to Clean-and-Go Shop                            ");
        System.out.println("                                 Customers & Services                                ");
        System.out.println("*************************************************************************************");
        System.out.println("                             There is nothing to see here                            ");
        System.out.println("                                  Press 1 to go back                                 ");
        System.out.println("*************************************************************************************");
    }
}
