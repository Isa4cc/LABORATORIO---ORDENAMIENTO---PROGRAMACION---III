
public class EcoAnalyzer {
    // Constantes físicas del escenario: CPU 65W, factor de emisión 0.5g CO2/kJ
    private static final double CPU_WATTS = 65.0;
    private static final double CO2_PER_KJ = 0.5; // gramos de CO2 por kilojulio

    // Calcula los kilogramos de CO2 emitidos para N operaciones dado el tiempo por operación
    public static double calculateCO2Kg(long timeNanos, long totalOperations) {
        double timeSeconds = timeNanos / 1_000_000_000.0;
        double energyKiloJoules = (CPU_WATTS * timeSeconds) / 1000.0;
        double totalCO2Grams = (energyKiloJoules * CO2_PER_KJ) * totalOperations;
        return totalCO2Grams / 1000.0; // Convierte gramos a kilogramos
    }
}