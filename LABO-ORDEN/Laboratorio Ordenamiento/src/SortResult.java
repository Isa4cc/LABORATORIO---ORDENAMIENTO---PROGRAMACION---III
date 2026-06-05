
// Almacena el resultado de una ejecución de ordenamiento: tiempo en nanosegundos y altura recursiva
public class SortResult {
    public long timeNanos;
    public int height;

    public SortResult(long timeNanos, int height) {
        this.timeNanos = timeNanos;
        this.height = height;
    }
}