public class Employee implements Comparable<Employee> { // Implement Comparable interface
    private String id;
    private String name;
    private int level;

    public Employee(String id, String name, int level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return String.format("%-5s %-15s %d", id, name, level);
    }

    @Override
    public int compareTo(Employee other) {
        return this.id.compareTo(other.id);
    }
}