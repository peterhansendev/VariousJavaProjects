public class If {
    public static void main(String[] args) {
        int myInt = 0;

        if(myInt == 4) {
            System.out.println("yes");

        }
        else if(myInt > 40) {
            System.out.println("no");
        } else {
            System.out.println("ok");
        }

        while(myInt < 5) {
            System.out.println("loop" + myInt);
            if(myInt == 5) {
                break;
            }
            myInt++;
            System.out.println("running");
        } 
    }
}
