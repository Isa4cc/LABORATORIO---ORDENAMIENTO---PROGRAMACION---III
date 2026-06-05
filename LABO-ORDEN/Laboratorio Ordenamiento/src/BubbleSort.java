
public class BubbleSort {
    // Algoritmo O(n^2): compara e intercambia pares adyacentes de forma iterativa
    public static SortResult sort(int[] arr) {
        long start = System.nanoTime();
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        long time = System.nanoTime() - start;
        return new SortResult(time, 0); // No es recursivo, altura siempre 0
    }
}