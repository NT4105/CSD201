public class SortingAlgorithms {
    // Basic Sorting Algorithms

    // Insertion Sort
    public static void insertionSort(Employee[] arr, boolean ascending) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            Employee key = arr[i];
            int j = i - 1;

            while (j >= 0 && (ascending ? arr[j].compareTo(key) > 0 : arr[j].compareTo(key) < 0)) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    // Selection Sort
    public static void selectionSort(Employee[] arr, boolean ascending) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minMax = i;
            for (int j = i + 1; j < n; j++) {
                if (ascending ? arr[j].compareTo(arr[minMax]) < 0 : arr[j].compareTo(arr[minMax]) > 0) {
                    minMax = j;
                }
            }
            Employee temp = arr[minMax];
            arr[minMax] = arr[i];
            arr[i] = temp;
        }
    }

    // Bubble Sort
    public static void bubbleSort(Employee[] arr, boolean ascending) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (ascending ? arr[j].compareTo(arr[j + 1]) > 0 : arr[j].compareTo(arr[j + 1]) < 0) {
                    Employee temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Advanced Sorting Algorithms

    // Quick Sort
    public static void quickSort(Employee[] arr, int low, int high, boolean ascending) {
        if (low < high) {
            int pi = partition(arr, low, high, ascending);
            quickSort(arr, low, pi - 1, ascending);
            quickSort(arr, pi + 1, high, ascending);
        }
    }

    private static int partition(Employee[] arr, int low, int high, boolean ascending) {
        Employee pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (ascending ? arr[j].compareTo(pivot) < 0 : arr[j].compareTo(pivot) > 0) {
                i++;
                Employee temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        Employee temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    // Merge Sort
    public static void mergeSort(Employee[] arr, int left, int right, boolean ascending) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid, ascending);
            mergeSort(arr, mid + 1, right, ascending);
            merge(arr, left, mid, right, ascending);
        }
    }

    private static void merge(Employee[] arr, int left, int mid, int right, boolean ascending) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Employee[] L = new Employee[n1];
        Employee[] R = new Employee[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (ascending ? L[i].compareTo(R[j]) <= 0 : L[i].compareTo(R[j]) >= 0) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Heap Sort
    public static void heapSort(Employee[] arr, boolean ascending) {
        int n = arr.length;

        // Build heap
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i, ascending);

        // Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Move current root to end
            Employee temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call heapify on reduced heap
            heapify(arr, i, 0, ascending);
        }
    }

    private static void heapify(Employee[] arr, int n, int i, boolean ascending) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Compare with left child
        if (left < n && (ascending ? arr[left].compareTo(arr[largest]) > 0 : arr[left].compareTo(arr[largest]) < 0))
            largest = left;

        // Compare with right child
        if (right < n && (ascending ? arr[right].compareTo(arr[largest]) > 0 : arr[right].compareTo(arr[largest]) < 0))
            largest = right;

        // If largest is not root
        if (largest != i) {
            Employee swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, n, largest, ascending);
        }
    }
}