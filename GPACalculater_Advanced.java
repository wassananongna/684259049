public class GPACalculater_Advanced {
    public static void main(String[] args) {
       
        // 1. กำหนดข้อมูลรายวิชา (Input)
        // ทดสอบใส่เกรดหลายๆ แบบ รวมถึงเกรด E
        String[] grades = {"A", "B+", "C+", "D", "E"};
        int creditPerSubject = 3;

        double totalPoints = 0.0;
        int totalCredits = 0;    

        System.out.println("--- เริ่มการคำนวณเกรด (รองรับ + และ E) ---");

        // 2. วนลูปคำนวณ
        for (int i = 0; i < grades.length; i++) {
            String grade = grades[i].toUpperCase(); // แปลงเป็นตัวพิมพ์ใหญ่กันพลาด
            double gradeValue = 0.0;
            boolean isCalculated = true; // ตัวแปรเช็คว่าวิชานี้ต้องคิดเกรดไหม

            switch (grade) {
                case "A":  gradeValue = 4.0; break;
                case "B+": gradeValue = 3.5; break;
                case "B":  gradeValue = 3.0; break;
                case "C+": gradeValue = 2.5; break;
                case "C":  gradeValue = 2.0; break;
                case "D+": gradeValue = 1.5; break;
                case "D":  gradeValue = 1.0; break;
               
                case "E":
                    // โจทย์กำหนด: E มีค่า 0 และ *ไม่นำมาคิดเกรดเฉลี่ย*
                    // ดังนั้นเราจะตั้ง flag ให้ข้ามการบวกหน่วยกิต
                    System.out.println("วิชาที่ " + (i + 1) + " (เกรด E): ไม่นำมาคำนวณ");
                    isCalculated = false;
                    break;
                   
                default:
                    System.out.println("ไม่พบข้อมูลเกรด: " + grade);
                    isCalculated = false;
            }

            // เฉพาะวิชาที่นับเกรด (ไม่ใช่ E หรือเกรดผิด) ให้ทำการคำนวณ
            if (isCalculated) {
                double currentPoints = gradeValue * creditPerSubject;
                totalPoints += currentPoints;
                totalCredits += creditPerSubject;
               
                System.out.println("วิชาที่ " + (i + 1) + " (เกรด " + grade + "): ได้แต้ม " + currentPoints);
            }
        }

        // 3. แสดงผลลัพธ์
        System.out.println("-------------------------");
        if (totalCredits > 0) {
            double gpa = totalPoints / totalCredits;
            System.out.println("คะแนนรวมทั้งหมด: " + totalPoints);
            System.out.println("หน่วยกิตรวมที่นำมาคิด: " + totalCredits); // สังเกตว่าหน่วยกิตจะลดลงถ้ามี E
            System.out.printf("เกรดเฉลี่ย (GPA) ของคุณคือ: %.2f%n", gpa);
        } else {
            System.out.println("ไม่มีหน่วยกิตที่นำมาคำนวณได้");
        }
    }
}