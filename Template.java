import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

    public class Template {

        public static void main(String args[]) {
            Connection conn = null;
            try {

                Class.forName("com.mysql.cj.jdbc.Driver");
                String url = "jdbc:mysql://localhost:3306/CS331-18-Company?serverTimezone=UTC&useSSL=TRUE";
                String user, pass;
                user = readEntry("userid : ");
                pass = readEntry("password: ");
                conn = DriverManager.getConnection(url, user, pass);

                boolean done = false;
                do {
                    printMenu();
                    System.out.print("Type in your option: ");
                    System.out.flush();
                    String ch = readLine();
                    System.out.println();
                    switch (ch.charAt(0)) {
                        case 'a': findHighestPaid(conn);
                            break;
                        case 'b':
                            findMostWorked(conn);
                            break;
                        case 'q': done = true;
                            break;
                        default:
                            System.out.println(" Not a valid option ");
                    } //switch
                } while (!done);


            } catch (ClassNotFoundException e) {
                System.out.println("Could not load the driver");
            } catch (SQLException ex) {
                System.out.println(ex);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) { /* ignored */}
                }
            }
        }

        private static void findHighestPaid(Connection conn) throws SQLException, IOException {

            //STEP1: CREATE VARIABLE OF TYPE STATEMENT
            Statement stmt = conn.createStatement();
           // STEP 2 DEFINE A STRING THAT IS = TO YOUR query SQL Statement
           // String query = ""

            // Step 3: Declare a variable with ResultSet type
            ResultSet rset;
            //Execute your Query and store the return in the declared variable from step 3

            System.out.println("    HIGHEST PAID WORKERS");
            System.out.println("--------------------------------------------------\n");

            // Write a loop to read all the returned rows from the query execution


           //Close the statement

        }


        private static void findMostWorked(Connection conn) throws SQLException, IOException {

          // Complete this method following the same steps above to return the required information

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
            System.out.println("\n        QUERY OPTIONS ");
            System.out.println("(a) Find Highest paid workers. ");
            System.out.println("(b) Find the most worked workers. ");
            System.out.println("(q) Quit. \n");
        }

    }

