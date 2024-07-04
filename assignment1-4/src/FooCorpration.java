public class FooCorpration {

    public static void main(String[] args) {
        double basePay = 10.20;
        int hoursWorked = 73;
        Caculate(basePay, hoursWorked);
    }

    public static void Caculate(double basePay, int hoursWorked) {
        double wage;
        if (basePay < 8.0){
            System.err.println("Error: The base pay must not be less than the minimum wage.");
            return;

        }
        if (hoursWorked > 60){
            System.err.println("Error: The most working hours must not be more than the maximum hours.");
            return;
        }
        if (hoursWorked<=40){
            wage = hoursWorked * basePay;
        }
        else{
            wage = 40 * basePay  + (hoursWorked-40) * 1.5 * 40;
        }
        System.err.println("Wage: " + wage);
    }
}
