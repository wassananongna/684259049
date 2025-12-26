public class GPACalculator {
    public class GPACalculator {
    public static void main(String[] args) {
       
        // 1. กำหนดข้อมูลรายวิชา (Input Data)
        // เกรด A 2 ตัว, B 3 ตัว
        char[] grades = {'A', 'A', 'B', 'B', 'B'};
        int creditPerSubject = 3; // กำหนดให้ทุกวิชา 3 หน่วยกิตเท่ากัน
       
        // ตัวแปรสำหรับเก็บผลรวม
        double totalPoints = 0.0; // คะแนนรวม (เกรด x หน่วยกิต)
        int totalCredits = 0;     // หน่วยกิตรวม

        System.out.println("--- เริ่มการคำนวณเกรด ---");

        // 2. วนลูปคำนวณทีละวิชา (Process)
        for (int i = 0; i < grades.length; i++) {
            char grade = grades[i];
            double gradeValue = 0.0;

            // แปลงเกรดตัวอักษรเป็นตัวเลข
            switch (grade) {
                case 'A':
                    gradeValue = 4.0;
                    break;
                case 'B':
                    gradeValue = 3.0;
                    break;
                case 'C':
                    gradeValue = 2.0;
                    break;
                case 'D':
                    gradeValue = 1.0;
                    break;
                case 'F':
                    gradeValue = 0.0;
                    break;
                default:
                    System.out.println("ไม่พบข้อมูลเกรด: " + grade);
                    continue; // ข้ามรอบนี้ไป
            }

            // คำนวณคะแนนวิชานั้น (เกรด x หน่วยกิต)
            double currentPoints = gradeValue * creditPerSubject;
           
            // สะสมลงในยอดรวม
            totalPoints += currentPoints;
            totalCredits += creditPerSubject;

            // แสดงผลการคำนวณย่อย (Optional: เพื่อให้เห็นการทำงาน)
            System.out.println("วิชาที่ " + (i + 1) + " (เกรด " + grade + "): ได้แต้ม " + currentPoints);
        }

        // 3. คำนวณหาเกรดเฉลี่ยและแสดงผล (Output)
        if (totalCredits > 0) {
            double gpa = totalPoints / totalCredits;
           
            System.out.println("-------------------------");
            System.out.println("คะแนนรวมทั้งหมด: " + totalPoints);
            System.out.println("หน่วยกิตรวม: " + totalCredits);
            // แสดงผลทศนิยม 2 ตำแหน่ง
            System.out.printf("เกรดเฉลี่ย (GPA) ของคุณคือ: %.2f%n", gpa);
        } else {
            System.out.println("ไม่มีหน่วยกิตที่นำมาคำนวณได้");
        }
    }
} 
}
