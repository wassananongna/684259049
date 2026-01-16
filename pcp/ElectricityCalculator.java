import java.util.Scanner;

public class ElectricityCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter electricity consumption (kWh): ");
        double units = scanner.nextDouble();
        
        double bill = 0;
        final double SERVICE_CHARGE = 50.0;
        
        if (units <= 150) {
            bill = units * 3.50;
        } else if (units <= 400) {
            bill = (150 * 3.50) + ((units - 150) * 4.20);
        } else {
            bill = (150 * 3.50) + (250 * 4.20) + ((units - 400) * 5.00);
        }
        
        double total = bill + SERVICE_CHARGE;
        
        System.out.println("------------------------------");
        System.out.println("Consumption: " + units + " kWh");
        System.out.println("Energy Cost: " + String.format("%.2f", bill) + " Baht");
        System.out.println("Service Charge: " + String.format("%.2f", SERVICE_CHARGE) + " Baht");
        System.out.println("Total Bill: " + String.format("%.2f", total) + " Baht");
        System.out.println("------------------------------");
        
        scanner.close();
    }
}
