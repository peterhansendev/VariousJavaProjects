import java.util.Scanner;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String email;
    private String department;
    private int mailboxCapacity;
    private int defaultPasswordLength = 10;
    private String alernateEmail;
    private String companySuffix = "company.com";

    public Email(String firstname, String lastName) {
        this.firstName = firstname;
        this.lastName = lastName;
        System.out.println("Email created: " + this.firstName + " " + this.lastName);

        this.department = setDepartment();
       // System.out.println("Department: " + department);

        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Your password is: " + this.password);

        email = firstname.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
        System.out.println("Your email is: " + email);
    }

    private String setDepartment() {
        System.out.print(
                "DEPARTMENT CODES\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {
            return "sales";
        } else if (depChoice == 2) {
            return "dev";
        } else if (depChoice == 3) {
            return "acct";
        } else {
            return "";
        }
    }

    private String randomPassword(int length) {
        String passwordSet = "QWERTYUIOPÅØÆLKJHGFDSAZXCVBNM1234567890!#¤%&/()=";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }

    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    public void setAlernateEmail(String altEmail) {
        this.alernateEmail = altEmail;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlernateEmail() {
        return alernateEmail;
    }

    public void changePassWord(String password) {
        this.password = password;
    }

    public String getPassword() {return password;}

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
        "\nCOMPANY EMAIL: " + email + 
        "\nMAILBOX CAPACITY: " + mailboxCapacity + "mb";
    }
}
