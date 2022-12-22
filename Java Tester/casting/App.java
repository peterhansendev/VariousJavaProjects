package casting;

public class App {
    public static void main(String[] args) {
        short shortValue = 55;
        byte byteValue = 20;
        int intValue = 888;
        long longValue = 23355;
        float floatValue = 8834.4f;
        double doubleValue = 32.4;

        intValue = (int)longValue;
        System.out.println(intValue);
    }
}
