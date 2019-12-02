import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteMenu {
	Connection conn = null;
	
	public DeleteMenu(Connection Conn) {
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
            case '1': deleteEquipment();
                break;
            case '2': deleteService();
                break;
            case '3': deleteCustomer();
                break;
            case '4': deleteEmployee();
                break;
            case '5': inMenu = false;
            	break;
            default:
                System.out.println(" Not a valid option ");
	        }}
		}
	}
	
	private void deleteEquipment() throws SQLException {
		CallableStatement delItem = conn.prepareCall("{call deleteEquip(?, ?)}");
        System.out.println();
        System.out.println("Insert Column Name: ");
		System.out.flush();
		String ch = readLine();
		delItem.setString(1, ch);
		System.out.println();
		System.out.println("Insert Condition: ");
		System.out.flush();
		ch = readLine();
		delItem.setString(2, ch);
		System.out.println();
		
		delItem.executeQuery();
        
        CallableStatement showEq = conn.prepareCall("{call showEq()}");
        ResultSet result = showEq.executeQuery();
        while(result.next()) {
        	System.out.println(result.getString("eID"));
        }
	}
	
	private void deleteService() throws SQLException {
		CallableStatement delItem = conn.prepareCall("{call deleteServ(?, ?)}");
        System.out.println();
        System.out.println("Insert Column Name: ");
		System.out.flush();
		String ch = readLine();
		delItem.setString(1, ch);
		System.out.println();
		System.out.println("Insert Condition: ");
		System.out.flush();
		ch = readLine();
		delItem.setString(2, ch);
		System.out.println();
		
		delItem.executeQuery();
        
        CallableStatement showSer = conn.prepareCall("{call showSer()}");
        ResultSet result = showSer.executeQuery();
        while(result.next()) {
        	System.out.println(result.getString("sName"));
        }
	}
	
	private void deleteCustomer() throws SQLException {
		CallableStatement delItem = conn.prepareCall("{call deleteCust(?, ?)}");
        System.out.println();
        System.out.println("Insert Column Name: ");
		System.out.flush();
		String ch = readLine();
		delItem.setString(1, ch);
		System.out.println();
		System.out.println("Insert Condition: ");
		System.out.flush();
		ch = readLine();
		delItem.setString(2, ch);
		System.out.println();
		
		delItem.executeQuery();
        
        CallableStatement showCus = conn.prepareCall("{call showCus()}");
        ResultSet result = showCus.executeQuery();
        while(result.next()) {
        	System.out.println(result.getString("fName"));
        }
	}
	
	private void deleteEmployee() throws SQLException {
		CallableStatement delItem = conn.prepareCall("{call deleteEmpl(?, ?)}");
        System.out.println();
        System.out.println("Insert Column Name: ");
		System.out.flush();
		String ch = readLine();
		delItem.setString(1, ch);
		System.out.println();
		System.out.println("Insert Condition: ");
		System.out.flush();
		ch = readLine();
		delItem.setString(2, ch);
		System.out.println();
		
		delItem.executeQuery();
        
        CallableStatement showEm = conn.prepareCall("{call showEmp()}");
        ResultSet result = showEm.executeQuery();
        while(result.next()) {
        	System.out.println(result.getString("fName"));
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
        System.out.println("                                   Updates : Delete                                  ");
        System.out.println("*************************************************************************************");
        System.out.println("                             1. Equipment                                            ");
        System.out.println("                             2. Service                                              ");
        System.out.println("                             3. Customer                                             ");
        System.out.println("                             4. Employee                                             ");
        System.out.println("                             5. Go Back                                              ");
        System.out.println("*************************************************************************************");
    }
}
