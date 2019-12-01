import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

public class updatesMenu {
    private String username;
    private String password;
    private InsertMenu insert;
    private DeleteMenu delete;
    private UpdateMenu update;
	
	public updatesMenu(Connection Conn, String Username, String Password) {
        username = Username;
        password = Password;
        insert = new InsertMenu(Conn);
        delete = new DeleteMenu(Conn);
        update = new UpdateMenu(Conn);
	}
	
	public void menu() throws SQLException {
        Boolean inMenu;

        inMenu = securityPrompt();
        
		while(inMenu) {
			printMenu();
			System.out.print("Type in your option: ");
            System.out.flush();
			String ch = readLine();
	        System.out.println();
	        
	        if(ch.length() > 0) {
	        switch (ch.charAt(0)) {
            case '1': insert.menu();
                break;
            case '2': delete.menu();
                break;
            case '3': update.menu();
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

    private Boolean securityPrompt(){
        Boolean inSecurity = true;
        Boolean correct = false;

        while(inSecurity) {
			printSecurityPrompt();
			System.out.print("Username: ");
            System.out.flush();
			String ch = readLine();
            System.out.println();

	        if(ch.length() > 0) {
	        	
                if(ch.length() == 1 && ch.charAt(0) == '1'){
                    inSecurity = false;
                    correct = false;
                }

                if(ch.equals(username)){
                    System.out.print("Password: ");
                    System.out.flush();
                    ch = readLine();
                    System.out.println();

                    if(ch.length() == 1 && ch.charAt(0) == '1'){
                        inSecurity = false;
                        correct = false;
                    } else if(ch.equals(password)){
                        System.out.println("Valid Login");
                        inSecurity = false;
                        correct = true;
                    } else System.out.println("Invalid Login");
                } else System.out.println("Invalid Username");
	        }
        }
        
        return correct;
    }

    private void printSecurityPrompt(){
        System.out.println("*************************************************************************************");
        System.out.println("                                *******************                                  ");
        System.out.println("                             Welcome to Clean-and-Go Shop                            ");
        System.out.println("                                       Updates                                       ");
        System.out.println("*************************************************************************************");
        System.out.println("                          Please enter Username and Password                         ");
        System.out.println("                                Or enter 1 to go Back                                ");
        System.out.println("*************************************************************************************");
        System.out.println();
    }
    
    private void printMenu() {
        System.out.println("*************************************************************************************");
        System.out.println("                                *******************                                  ");
        System.out.println("                             Welcome to Clean-and-Go Shop                            ");
        System.out.println("                                       Updates                                       ");
        System.out.println("*************************************************************************************");
        System.out.println("                             1. Insert New Data                                      ");
        System.out.println("                             2. Delete Data                                          ");
        System.out.println("                             3. Update Current Data                                  ");
        System.out.println("                             4. Go Back                                              ");
        System.out.println("*************************************************************************************");
    }
}
