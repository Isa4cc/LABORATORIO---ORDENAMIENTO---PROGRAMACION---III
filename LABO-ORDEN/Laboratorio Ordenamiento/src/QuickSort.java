
public class QuickSort {
    public static SortResult sort(int[] arr) {
        long start = System.nanoTime();
        int height = quickSort(arr, 0, arr.length - 1, 1);
        long time = System.nanoTime() - start;
        return new SortResult(time, height);
    }

    private static int quickSort(int[] arr, int low, int high, int depth) {
        if (low < high) {
            // Pivote: primer elemento para forzar degeneración en arreglos ordenados
            int pi = partition(arr, low, high);
            int leftHeight = quickSort(arr, low, pi - 1, depth + 1);
            int rightHeight = quickSort(arr, pi + 1, high, depth + 1);
            return Math.max(leftHeight, rightHeight);
        }
        return depth;
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low]; // Selección del primer elemento como pivote (Degeneración)
        int i = low + 1;
        int j = high;
        while (i <= j) {
            if (arr[i] <= pivot) i++;
            else if (arr[j] > pivot) j--;
            else {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[low];
        arr[low] = arr[j];
        arr[j] = temp;
        return j;
    }
}