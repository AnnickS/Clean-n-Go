import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class DeleteMenu {
	Connection conn = null;
	Set<String> equipmentFields = new HashSet<String>();
	Set<String> serviceFields = new HashSet<String>();
	Set<String> customerFields = new HashSet<String>();
	Set<String> employeeFields = new HashSet<String>();
	//{"eID", "gender", "jobTitle", "dateHired", "fName", "minit", "lName", "street", "city", "stateInits", "zip" };
	
	public DeleteMenu(Connection Conn) {
		conn = Conn;
		
		equipmentFields.add("eID");
		equipmentFields.add("iID");
		equipmentFields.add("eType");
		equipmentFields.add("brand");
		equipmentFields.add("installationDate");
		equipmentFields.add("removeDate");
		
		serviceFields.add("servID");
		serviceFields.add("sName");
		serviceFields.add("description");
		serviceFields.add("rate");
		serviceFields.add("satRating");
		serviceFields.add("servTime");

		customerFields.add("custID");
		customerFields.add("fName");
		customerFields.add("lName");
		customerFields.add("street");
		customerFields.add("city");
		customerFields.add("stateInits");
		customerFields.add("zip");
		customerFields.add("email");
		customerFields.add("phoneNum");
		customerFields.add("currBalance");
		customerFields.add("creditCard");
		customerFields.add("signDate");

		employeeFields.add("eID");
		employeeFields.add("gender");
		employeeFields.add("jobTitle");
		employeeFields.add("dateHired");
		employeeFields.add("fName");
		employeeFields.add("minit");
		employeeFields.add("lName");
		employeeFields.add("street");
		employeeFields.add("city");
		employeeFields.add("stateInits");
		employeeFields.add("zip");
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
		Boolean wrongInput = true;
		CallableStatement delItem = conn.prepareCall("{call deleteServ(?, ?)}");
		String ch;
		System.out.print("Fields: ");
		for(String i : equipmentFields) {
			System.out.print(i + " ");
		}
		
		while(wrongInput) {
			System.out.println();
	        System.out.println("Insert Column Name: ");
			System.out.flush();
			ch = readLine();
			
			if(equipmentFields.contains(ch)) {
				wrongInput = false;
				delItem.setString(1, ch);
			} else {
				System.out.println("Incorrect field type.");
			}
		}
		
		System.out.println();
		System.out.println("Insert Condition: ");
		System.out.flush();
		ch = readLine();
		delItem.setString(2, ch);
		System.out.println();
		
		delItem.executeQuery();
        
		System.out.println("Updated Equipment List:\n");
        CallableStatement showEq = conn.prepareCall("{call showEq()}");
        ResultSet result = showEq.executeQuery();
        while(result.next()) {
        	System.out.println(result.getString("eID"));
        }
        
        System.out.print("Press enter to continue...");
        readLine();
	}
	
	private void deleteService() throws SQLException {
		Boolean wrongInput = true;
		CallableStatement delItem = conn.prepareCall("{call deleteServ(?, ?)}");
		String ch;
		System.out.print("Fields: ");
		for(String i : serviceFields) {
			System.out.print(i + " ");
		}
		
		while(wrongInput) {
			System.out.println();
	        System.out.println("Insert Column Name: ");
			System.out.flush();
			ch = readLine();
			
			if(serviceFields.contains(ch)) {
				wrongInput = false;
				delItem.setString(1, ch);
			} else {
				System.out.println("Incorrect field type.");
			}
		}
		
		System.out.println();
		System.out.println("Insert Condition: ");
		System.out.flush();
		ch = readLine();
		delItem.setString(2, ch);
		System.out.println();
		
		delItem.executeQuery();
        
		System.out.println("Updated Service List:\n");
        CallableStatement showSer = conn.prepareCall("{call showSer()}");
        ResultSet result = showSer.executeQuery();
        while(result.next()) {
        	System.out.println(result.getString("sName"));
        }
        
        System.out.print("Press enter to continue...");
        readLine();
	}
	
	private void deleteCustomer() throws SQLException {
		Boolean wrongInput = true;
		CallableStatement delItem = conn.prepareCall("{call deleteServ(?, ?)}");
		String ch;
		System.out.print("Fields: ");
		for(String i : customerFields) {
			System.out.print(i + " ");
		}
		
		while(wrongInput) {
			System.out.println();
	        System.out.println("Insert Column Name: ");
			System.out.flush();
			ch = readLine();
			
			if(customerFields.contains(ch)) {
				wrongInput = false;
				delItem.setString(1, ch);
			} else {
				System.out.println("Incorrect field type.");
			}
		}
		System.out.println();
		System.out.println("Insert Condition: ");
		System.out.flush();
		ch = readLine();
		delItem.setString(2, ch);
		System.out.println();
		
		delItem.executeQuery();
        
		System.out.println("Updated Customer List:\n");
        CallableStatement showCus = conn.prepareCall("{call showCus()}");
        ResultSet result = showCus.executeQuery();
        while(result.next()) {
        	System.out.println(result.getString("fName"));
        }
        
        System.out.print("Press enter to continue...");
        readLine();
	}
	
	private void deleteEmployee() throws SQLException {
		Boolean wrongInput = true;
		CallableStatement delItem = conn.prepareCall("{call deleteServ(?, ?)}");
		String ch;
		System.out.print("Fields: ");
		for(String i : employeeFields) {
			System.out.print(i + " ");
		}
		
		while(wrongInput) {
			System.out.println();
	        System.out.println("Insert Column Name: ");
			System.out.flush();
			ch = readLine();
			
			if(employeeFields.contains(ch)) {
				wrongInput = false;
				delItem.setString(1, ch);
			} else {
				System.out.println("Incorrect field type.");
			}
		}
		System.out.println();
		System.out.println("Insert Condition: ");
		System.out.flush();
		ch = readLine();
		delItem.setString(2, ch);
		System.out.println();
		
		delItem.executeQuery();
        
		System.out.println("Updated Employee List:\n");
        CallableStatement showEm = conn.prepareCall("{call showEmp()}");
        ResultSet result = showEm.executeQuery();
        while(result.next()) {
        	System.out.println(result.getString("fName"));
        }
        
        System.out.print("Press enter to continue...");
        readLine();
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
