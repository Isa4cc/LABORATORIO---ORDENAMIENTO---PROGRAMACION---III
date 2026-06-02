
public class MergeSort {
    public static SortResult sort(int[] arr) {
        long start = System.nanoTime();
        int[] temp = new int[arr.length];
        int height = mergeSort(arr, temp, 0, arr.length - 1, 1);
        long time = System.nanoTime() - start;
        return new SortResult(time, height);
    }

    private static int mergeSort(int[] arr, int[] temp, int left, int right, int depth) {
        if (left >= right) return depth;
        int mid = (left + right) / 2;
        int depthLeft = mergeSort(arr, temp, left, mid, depth + 1);
        int depthRight = mergeSort(arr, temp, mid + 1, right, depth + 1);
        merge(arr, temp, left, mid, right);
        return Math.max(depthLeft, depthRight);
    }

    private static void merge(int[] arr, int[] temp, int left, int mid, int right) {
        for (int i = left; i <= right; i++) temp[i] = arr[i];
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (temp[i] <= temp[j]) arr[k++] = temp[i++];
            else arr[k++] = temp[j++];
        }
        while (i <= mid) arr[k++] = temp[i++];
    }
}