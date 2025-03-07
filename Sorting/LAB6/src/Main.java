public class Main {
    public static void main(String[] args) {
        // Create employee list
        Employee[] employees = {
                new Employee("A05", "Tran Quang", 7),
                new Employee("A03", "Nguyen An", 7),
                new Employee("A01", "Truong Phung", 5),
                new Employee("A04", "Pham Thi Lam", 2),
                new Employee("A02", "Do Trung Ton", 5)
        };

        System.out.println("Original List:");
        printArray(employees);

        // Test basic sorting algorithms
        testBasicSorts(employees);

        // Test advanced sorting algorithms
        testAdvancedSorts(employees);
    }

    private static void testBasicSorts(Employee[] original) {
        // Test Insertion Sort
        Employee[] arr = original.clone();
        System.out.println("\nInsertion Sort (Ascending):");
        SortingAlgorithms.insertionSort(arr, true);
        printArray(arr);

        arr = original.clone();
        System.out.println("\nInsertion Sort (Descending):");
        SortingAlgorithms.insertionSort(arr, false);
        printArray(arr);

        // Test Selection Sort
        arr = original.clone();
        System.out.println("\nSelection Sort (Ascending):");
        SortingAlgorithms.selectionSort(arr, true);
        printArray(arr);

        arr = original.clone();
        System.out.println("\nSelection Sort (Descending):");
        SortingAlgorithms.selectionSort(arr, false);
        printArray(arr);

        // Test Bubble Sort
        arr = original.clone();
        System.out.println("\nBubble Sort (Ascending):");
        SortingAlgorithms.bubbleSort(arr, true);
        printArray(arr);

        arr = original.clone();
        System.out.println("\nBubble Sort (Descending):");
        SortingAlgorithms.bubbleSort(arr, false);
        printArray(arr);
    }

    private static void testAdvancedSorts(Employee[] original) {
        // Test Quick Sort
        Employee[] arr = original.clone();
        System.out.println("\nQuick Sort (Ascending):");
        SortingAlgorithms.quickSort(arr, 0, arr.length - 1, true);
        printArray(arr);

        arr = original.clone();
        System.out.println("\nQuick Sort (Descending):");
        SortingAlgorithms.quickSort(arr, 0, arr.length - 1, false);
        printArray(arr);

        // Test Merge Sort
        arr = original.clone();
        System.out.println("\nMerge Sort (Ascending):");
        SortingAlgorithms.mergeSort(arr, 0, arr.length - 1, true);
        printArray(arr);

        arr = original.clone();
        System.out.println("\nMerge Sort (Descending):");
        SortingAlgorithms.mergeSort(arr, 0, arr.length - 1, false);
        printArray(arr);

        // Test Heap Sort
        arr = original.clone();
        System.out.println("\nHeap Sort (Ascending):");
        SortingAlgorithms.heapSort(arr, true);
        printArray(arr);

        arr = original.clone();
        System.out.println("\nHeap Sort (Descending):");
        SortingAlgorithms.heapSort(arr, false);
        printArray(arr);
    }

    private static void printArray(Employee[] arr) {
        for (Employee e : arr) {
            System.out.println(e);
        }
    }
}