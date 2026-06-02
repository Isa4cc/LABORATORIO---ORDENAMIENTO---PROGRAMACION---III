import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- LABORATORIO: OLIMPIADAS DE LA EFICIENCIA ---");
        System.out.println("---- INTEGRANTES ----");
        System.out.println("Isaac Benítez");
        System.out.println("Mathías Castillo");
        // Precaución: N = 100_000 en Bubble Sort tomará bastante tiempo.
        int[] sizes = {10_000, 100_000};
        long operacionesServidor = 1_000_000_000L; // 10^9 operaciones

        for (int n : sizes) {
            System.out.println("\n==============================================");
            System.out.println("Ejecutando pruebas para N = " + n);
            System.out.println("==============================================");

            // Generación de los 3 estados de datos requeridos
            int[][] estadosDeDatos = {
                    DataGenerator.generateRandom(n),  // (A) Aleatorio
                    DataGenerator.generateSorted(n),  // (B) Ya ordenado
                    DataGenerator.generateReverse(n)  // (C) Orden inverso
            };
            String[] nombresEstados = {"(A) Aleatorio", "(B) Ya ordenado", "(C) Orden inverso"};

            long timeBubbleAleatorio = 0;
            long timeMergeAleatorio = 0;

            // 1. BUBBLE SORT
            System.out.println("\n[ 1. Evaluando Bubble Sort ]");
            for (int i = 0; i < estadosDeDatos.length; i++) {
                System.out.print("Estado " + nombresEstados[i] + ": ");
                long time = executeAverage("Bubble", estadosDeDatos[i], 10).timeNanos;
                if (i == 0) timeBubbleAleatorio = time; // Guardamos para cálculo de CO2
            }

            // 2. MERGE SORT
            System.out.println("\n[ 2. Evaluando Merge Sort ]");
            for (int i = 0; i < estadosDeDatos.length; i++) {
                System.out.print("Estado " + nombresEstados[i] + ": ");
                long time = executeAverage("Merge", estadosDeDatos[i], 10).timeNanos;
                if (i == 0) timeMergeAleatorio = time; // Guardamos para cálculo de CO2
            }

            // 3. QUICK SORT
            System.out.println("\n[ 3. Evaluando Quick Sort ]");
            for (int i = 0; i < estadosDeDatos.length; i++) {
                System.out.print("Estado " + nombresEstados[i] + ": ");
                try {
                    executeAverage("Quick", estadosDeDatos[i], 10);
                } catch (StackOverflowError e) {
                    System.out.println("ERROR: StackOverflow. Altura (h) excedió límite JVM por degeneración estructural.");
                }
            }

            // 4. ANÁLISIS AMBIENTAL (Usando tiempos del estado Aleatorio)
            System.out.println("\n--- ANÁLISIS DE IMPACTO AMBIENTAL (CO2) ---");
            double bubbleCO2 = EcoAnalyzer.calculateCO2Kg(timeBubbleAleatorio, operacionesServidor);
            double mergeCO2 = EcoAnalyzer.calculateCO2Kg(timeMergeAleatorio, operacionesServidor);

            System.out.printf("CO2 emitido por Bubble Sort en 10^9 ops: %.4f Kg%n", bubbleCO2);
            System.out.printf("CO2 emitido por Merge Sort en 10^9 ops: %.4f Kg%n", mergeCO2);
            System.out.printf("AHORRO DE CO2 al migrar a Merge Sort: %.4f Kg%n", (bubbleCO2 - mergeCO2));
        }
    }

    private static SortResult executeAverage(String algorithm, int[] originalArr, int iterations) {
        long totalTime = 0;
        int lastHeight = 0;

        for (int i = 0; i < iterations; i++) {
            int[] arrCopy = Arrays.copyOf(originalArr, originalArr.length);
            SortResult result;

            switch (algorithm) {
                case "Bubble": result = BubbleSort.sort(arrCopy); break;
                case "Merge": result = MergeSort.sort(arrCopy); break;
                case "Quick": result = QuickSort.sort(arrCopy); break;
                default: return new SortResult(0, 0);
            }

            totalTime += result.timeNanos;
            lastHeight = result.height;
        }

        long avgTime = totalTime / iterations;
        System.out.printf("Tiempo Promedio: %,d ns | Altura final (h): %d%n", avgTime, lastHeight);
        return new SortResult(avgTime, lastHeight);
    }
}