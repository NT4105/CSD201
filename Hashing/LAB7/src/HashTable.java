public class HashTable {
    private Node[] table;
    private int size;

    public HashTable(int size) {
        this.size = size;
        table = new Node[size];
    }

    private int hash(String key) {
        // Chuyển đổi chữ cái đầu tiên thành vị trí trong bảng chữ cái (0-25)
        char firstChar = key.charAt(0);
        if (firstChar >= 'a' && firstChar <= 'z') {
            return firstChar - 'a';
        } else if (firstChar >= 'A' && firstChar <= 'Z') {
            return firstChar - 'A';
        } else {
            return 0; // Mặc định cho ký tự không phải chữ cái
        }
    }

    public void insert(Student student) {
        String key = student.getName();
        int index = hash(key);

        Node newNode = new Node(student);

        // Nếu vị trí trống
        if (table[index] == null) {
            table[index] = newNode;
        } else {
            // Thêm vào đầu chuỗi
            newNode.next = table[index];
            table[index] = newNode;
        }
    }

    public Student search(String name) {
        int index = hash(name);

        Node current = table[index];
        while (current != null) {
            if (current.data.getName().equals(name)) {
                return current.data;
            }
            current = current.next;
        }

        return null; // Không tìm thấy
    }

    public boolean delete(String name) {
        int index = hash(name);

        // Nếu danh sách trống
        if (table[index] == null) {
            return false;
        }

        // Nếu nút đầu tiên khớp
        if (table[index].data.getName().equals(name)) {
            table[index] = table[index].next;
            return true;
        }

        // Kiểm tra phần còn lại của danh sách
        Node current = table[index];
        while (current.next != null) {
            if (current.next.data.getName().equals(name)) {
                current.next = current.next.next;
                return true;
            }
            current = current.next;
        }

        return false; // Không tìm thấy
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");

            Node current = table[i];
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }

            System.out.println("null");
        }
    }
}