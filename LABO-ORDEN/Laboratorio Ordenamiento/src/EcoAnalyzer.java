
public class EcoAnalyzer {
    // 65W = 65 Joules/segundo. 1 kJ = 1000 Joules. 0.5g CO2 por kJ.
    public static double calculateCO2Kg(long timeNanos, long totalOperations) {
        double timeSeconds = timeNanos / 1_000_000_000.0;
        double energyJoules = 65.0 * timeSeconds;
        double energyKiloJoules = energyJoules / 1000.0;
        double co2Grams = energyKiloJoules * 0.5;
        double totalCO2Grams = co2Grams * totalOperations;
        return totalCO2Grams / 1000.0; // Convertir a Kilogramos
    }
}