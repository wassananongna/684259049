void main() {
    // กำหนดค่าตัวแปร
    int a = 10;
    int b = 555;
    int c = 25;

    // เช็คว่า a เป็นค่ามากที่สุด
    if ((a > b) && (a > c)) {
        System.out.println("A");
    } else {
        // ถ้า a ไม่มากที่สุด เช็คว่า b เป็นค่ามากที่สุด
        if ((b > a) && (b > c)) {
            System.out.println("B");
        } else {
            // ถ้า b ก็ไม่มากที่สุด พิมพ์ C
            System.out.println("C");
        }
    }
}
