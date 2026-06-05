
import java.util.Random;

public class DataGenerator {
    // Arreglo con valores aleatorios entre 0 y size-1
    public static int[] generateRandom(int size) {
        int[] arr = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) arr[i] = rand.nextInt(size);
        return arr;
    }

    // Arreglo ordenado ascendentemente (mejor caso para algunos algoritmos)
    public static int[] generateSorted(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = i;
        return arr;
    }

    // Arreglo ordenado descendentemente (peor caso para Quick Sort con pivote fijo)
    public static int[] generateReverse(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = size - i;
        return arr;
    }
}