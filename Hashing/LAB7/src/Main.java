/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ACER
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(26);

        // Thêm một số sinh viên
        hashTable.insert(new Student("Alice", 20, 85.5));
        hashTable.insert(new Student("Bob", 21, 90.0));
        hashTable.insert(new Student("Charlie", 19, 78.5));
        hashTable.insert(new Student("David", 22, 92.0));
        hashTable.insert(new Student("Amy", 20, 88.0));
        hashTable.insert(new Student("Andrew", 21, 76.5));

        // Hiển thị bảng băm
        System.out.println("Bảng băm sau khi thêm:");
        hashTable.display();

        // Tìm kiếm một sinh viên
        Student found = hashTable.search("Bob");
        if (found != null) {
            System.out.println("\nĐã tìm thấy: " + found);
        } else {
            System.out.println("\nKhông tìm thấy sinh viên 'Bob'");
        }

        // Xóa một sinh viên
        boolean deleted = hashTable.delete("Amy");
        System.out.println("\nXóa 'Amy': " + (deleted ? "Thành công" : "Thất bại"));

        // Hiển thị bảng băm sau khi xóa
        System.out.println("\nBảng băm sau khi xóa:");
        hashTable.display();
    }
}
