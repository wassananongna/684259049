import java.util.Scanner;

/**
 * ระบบคำนวณค่าจัดส่งสินค้า (Shipping Cost Calculator)
 * 
 * อัตราค่าจัดส่งแบบปกติ (Standard):
 * - น้ำหนัก 0-1 กก. = 40 บาท
 * - น้ำหนัก >1-3 กก. = 60 บาท
 * - น้ำหนัก >3-5 กก. = 80 บาท
 * - น้ำหนัก >5 กก. = 100 บาท
 * 
 * อัตราค่าจัดส่งแบบด่วน (Express):
 * - น้ำหนัก 0-1 กก. = 60 บาท
 * - น้ำหนัก >1-3 กก. = 90 บาท
 * - น้ำหนัก >3-5 กก. = 120 บาท
 * - น้ำหนัก >5 กก. = 150 บาท
 * 
 * บริการเพิ่มเติม:
 * - บริการด่วน (Express) เพิ่ม 30 บาท
 * - สมาชิก VIP ลด 20%
 */
public class ShippingCalculator {
    
    // ค่าบริการด่วนเพิ่มเติม
    private static final double EXPRESS_SERVICE_FEE = 30.0;
    
    // ส่วนลดสมาชิก VIP (20%)
    private static final double VIP_DISCOUNT_RATE = 0.20;
    
    // อัตราค่าจัดส่งแบบปกติ (Standard)
    private static final double STANDARD_RATE_0_1 = 40.0;
    private static final double STANDARD_RATE_1_3 = 60.0;
    private static final double STANDARD_RATE_3_5 = 80.0;
    private static final double STANDARD_RATE_OVER_5 = 100.0;
    
    // อัตราค่าจัดส่งแบบด่วน (Express)
    private static final double EXPRESS_RATE_0_1 = 60.0;
    private static final double EXPRESS_RATE_1_3 = 90.0;
    private static final double EXPRESS_RATE_3_5 = 120.0;
    private static final double EXPRESS_RATE_OVER_5 = 150.0;
    
    /**
     * คำนวณค่าจัดส่งตามน้ำหนักสำหรับบริการปกติ
     * @param weight น้ำหนักสินค้า (กิโลกรัม)
     * @return ค่าจัดส่งพื้นฐาน (บาท)
     */
    public double calculateStandardRate(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("น้ำหนักต้องมากกว่า 0 กิโลกรัม");
        }
        
        if (weight <= 1) {
            return STANDARD_RATE_0_1;
        } else if (weight <= 3) {
            return STANDARD_RATE_1_3;
        } else if (weight <= 5) {
            return STANDARD_RATE_3_5;
        } else {
            return STANDARD_RATE_OVER_5;
        }
    }
    
    /**
     * คำนวณค่าจัดส่งตามน้ำหนักสำหรับบริการด่วน
     * @param weight น้ำหนักสินค้า (กิโลกรัม)
     * @return ค่าจัดส่งพื้นฐาน (บาท)
     */
    public double calculateExpressRate(double weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("น้ำหนักต้องมากกว่า 0 กิโลกรัม");
        }
        
        if (weight <= 1) {
            return EXPRESS_RATE_0_1;
        } else if (weight <= 3) {
            return EXPRESS_RATE_1_3;
        } else if (weight <= 5) {
            return EXPRESS_RATE_3_5;
        } else {
            return EXPRESS_RATE_OVER_5;
        }
    }
    
    /**
     * คำนวณค่าจัดส่งทั้งหมด
     * @param weight น้ำหนักสินค้า (กิโลกรัม)
     * @param isExpress เลือกบริการด่วนหรือไม่
     * @param isVIP เป็นสมาชิก VIP หรือไม่
     * @return ค่าจัดส่งรวม (บาท)
     */
    public double calculateTotalShippingCost(double weight, boolean isExpress, boolean isVIP) {
        double baseCost;
        
        // คำนวณค่าจัดส่งพื้นฐานตามประเภทบริการ
        if (isExpress) {
            baseCost = calculateExpressRate(weight);
        } else {
            baseCost = calculateStandardRate(weight);
        }
        
        // เพิ่มค่าบริการด่วน 30 บาท ถ้าเลือกบริการด่วน
        if (isExpress) {
            baseCost += EXPRESS_SERVICE_FEE;
        }
        
        // ลด 20% สำหรับสมาชิก VIP
        if (isVIP) {
            baseCost = baseCost * (1 - VIP_DISCOUNT_RATE);
        }
        
        return baseCost;
    }
    
    /**
     * แสดงรายละเอียดการคำนวณ
     * @param weight น้ำหนักสินค้า (กิโลกรัม)
     * @param isExpress เลือกบริการด่วนหรือไม่
     * @param isVIP เป็นสมาชิก VIP หรือไม่
     */
    public void printShippingDetails(double weight, boolean isExpress, boolean isVIP) {
        System.out.println("\n========================================");
        System.out.println("       รายละเอียดค่าจัดส่งสินค้า");
        System.out.println("========================================");
        System.out.printf("น้ำหนักสินค้า: %.2f กิโลกรัม%n", weight);
        System.out.printf("ประเภทบริการ: %s%n", isExpress ? "ด่วน (Express)" : "ปกติ (Standard)");
        System.out.printf("สถานะสมาชิก: %s%n", isVIP ? "VIP" : "ทั่วไป");
        System.out.println("----------------------------------------");
        
        double baseCost;
        if (isExpress) {
            baseCost = calculateExpressRate(weight);
            System.out.printf("ค่าจัดส่งพื้นฐาน (Express): %.2f บาท%n", baseCost);
            System.out.printf("ค่าบริการด่วนเพิ่มเติม: +%.2f บาท%n", EXPRESS_SERVICE_FEE);
            baseCost += EXPRESS_SERVICE_FEE;
        } else {
            baseCost = calculateStandardRate(weight);
            System.out.printf("ค่าจัดส่งพื้นฐาน (Standard): %.2f บาท%n", baseCost);
        }
        
        if (isVIP) {
            double discount = baseCost * VIP_DISCOUNT_RATE;
            System.out.printf("ส่วนลด VIP (20%%): -%.2f บาท%n", discount);
            baseCost = baseCost * (1 - VIP_DISCOUNT_RATE);
        }
        
        System.out.println("----------------------------------------");
        System.out.printf("ค่าจัดส่งรวมทั้งสิ้น: %.2f บาท%n", baseCost);
        System.out.println("========================================\n");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShippingCalculator calculator = new ShippingCalculator();
        
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   ระบบคำนวณค่าจัดส่งสินค้า             ║");
        System.out.println("║   Shipping Cost Calculator             ║");
        System.out.println("╚════════════════════════════════════════╝");
        
        boolean continueProgram = true;
        
        while (continueProgram) {
            try {
                // รับน้ำหนักสินค้า
                System.out.print("\nกรุณาระบุน้ำหนักสินค้า (กิโลกรัม): ");
                double weight = scanner.nextDouble();
                
                if (weight <= 0) {
                    System.out.println("ข้อผิดพลาด: น้ำหนักต้องมากกว่า 0 กิโลกรัม");
                    continue;
                }
                
                // เลือกประเภทบริการ
                System.out.println("\nเลือกประเภทบริการ:");
                System.out.println("1. บริการปกติ (Standard)");
                System.out.println("2. บริการด่วน (Express) - เพิ่ม 30 บาท");
                System.out.print("กรุณาเลือก (1 หรือ 2): ");
                int serviceChoice = scanner.nextInt();
                
                boolean isExpress = (serviceChoice == 2);
                
                // ตรวจสอบสถานะสมาชิก
                System.out.println("\nคุณเป็นสมาชิก VIP หรือไม่?");
                System.out.println("1. ใช่ (ลด 20%)");
                System.out.println("2. ไม่ใช่");
                System.out.print("กรุณาเลือก (1 หรือ 2): ");
                int vipChoice = scanner.nextInt();
                
                boolean isVIP = (vipChoice == 1);
                
                // แสดงผลการคำนวณ
                calculator.printShippingDetails(weight, isExpress, isVIP);
                
                // ถามว่าต้องการคำนวณต่อหรือไม่
                System.out.print("ต้องการคำนวณค่าจัดส่งอีกครั้งหรือไม่? (1=ใช่, 2=ไม่): ");
                int continueChoice = scanner.nextInt();
                continueProgram = (continueChoice == 1);
                
            } catch (Exception e) {
                System.out.println("ข้อผิดพลาด: กรุณาใส่ข้อมูลที่ถูกต้อง");
                scanner.nextLine(); // Clear buffer
            }
        }
        
        System.out.println("\nขอบคุณที่ใช้บริการ!");
        scanner.close();
    }
}