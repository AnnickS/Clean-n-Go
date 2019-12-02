import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;

public class customersAndServicesMenu {
	
	public customersAndServicesMenu(Connection Conn) {
		conn = Conn;
	}
   
    private ServicesMenu service;
    private AnalyzeBusinessMenu AB;
    private CustomersMenu customers;
	
	public updatesMenu(Connection Conn) {
   
        service = new ServicesMenu(Conn);
        AB = new AnalyzeBusinessMenu(Conn);
        customers = new CustomersMenu(Conn);
	
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
            case '1': AB.menu();
                break;
            case '2': service.menu();
                break;
            case '3': customers.menu();
                break;   
            case '4': inMenu = false;
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
        System.out.println("                               2. Customers & Services                               ");
        System.out.println("*************************************************************************************");
        System.out.println("                         1. Analyze the progress of the business                     ");
        System.out.println("                                    2. Services                                      ");
        System.out.println("                                    3. Customers                                     ");
        System.out.println("                                      4. Quit                                        ");
        System.out.println("*************************************************************************************");
    }
}
