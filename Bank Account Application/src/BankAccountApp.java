import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

public class BankAccountApp {
    public static void main(String[] args) throws Exception {

        try {

            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "");
            // System.out.println(myConn + " myconn");

            java.sql.Statement myStmt = myConn.createStatement();
            // System.out.println(myStmt + " stmt");

            ResultSet myRs = myStmt.executeQuery("select * from customers");
            // System.out.println(myRs + " myRs");
            while (myRs.next()) {
                System.out.println(myRs.getString("first_name") + ", " + myRs.getString("last_name"));
            }

            String sql = "insert into customers " + " (first_name, last_name, id, initial_deposit)"
                    + " values ('Pete', 'Peteson', 2, 2000)";

            myStmt.executeUpdate(sql);
            System.out.println("Insert complete");
        } catch (Exception e) {
            // TODO: handle exception
        }

        /*
         * 
         * List<Account> accounts = new LinkedList<Account>();
         * String file = "C:\\Users\\PHanse\\Downloads\\NewBankAccounts.csv";
         */

        /*
         * Checking chkacc1 = new Checking("Tom", "123456789", 1500);
         * 
         * Savings savacc1 = new Savings("bob", "987654321", 2500);
         * 
         * savacc1.showInfo();
         * System.out.println("!!!");
         * 
         * chkacc1.showInfo();
         * System.out.println("!!!");
         * 
         * savacc1.compund();
         */

        /*
         * List<String[]> newAccountHolders = utilities.CSV.read(file);
         * for (String[] accoutHolder : newAccountHolders) {
         * String name = accoutHolder[0];
         * String sSN = accoutHolder[1];
         * String accountType = accoutHolder[2];
         * double initDeposit = Double.parseDouble(accoutHolder[3]);
         * // System.out.println(name + " " + sSN + " " + accountType + " " +
         * initDeposit);
         * if (accountType.equals("Savings")) {
         * System.out.println("OPEN A SAVINGS ACCOUNT");
         * accounts.add(new Savings(name, sSN, initDeposit));
         * } else if (accountType.equals("Checking")) {
         * System.out.println("OPEN A CHECKING ACCOUNT");
         * accounts.add(new Checking(name, sSN, initDeposit));
         * } else {
         * System.out.println("ERROR READING ACCOUNT TYPE");
         * }
         * }
         * for (Account acc : accounts) {
         * System.out.println("\n**********");
         * acc.showInfo();
         * }
         */
    }

}
