import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- LABORATORIO: OLIMPIADAS DE LA EFICIENCIA ---");
        System.out.println("---- INTEGRANTES ----");
        System.out.println("Isaac Benítez");
        System.out.println("Mathías Castillo");
        // Precaución: N = 100_000 en Bubble Sort tomará bastante tiempo.
        int[] sizes = {10_000, 100_000, 1_000_000};
        long operacionesServidor = 1_000_000_000L; // 10^9 operaciones para cálculo de CO2


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
            long timeQuickAleatorio  = 0;

            // 1. BUBBLE SORT (Omitido solo para 1,000,000 por tiempo extremo)
            System.out.println("\n[ 1. Evaluando Bubble Sort ]");
            if (n >= 1_000_000) {
                System.out.println("Estado (A) Aleatorio: Omitido por N >= 1,000,000. Tiempo de ejecución demasiado largo.");
                System.out.println("Estado (B) Ya ordenado: Omitido por N >= 1,000,000.");
                System.out.println("Estado (C) Orden inverso: Omitido por N >= 1,000,000.");
            } else {
                for (int i = 0; i < estadosDeDatos.length; i++) {
                    System.out.print("Estado " + nombresEstados[i] + ": ");
                    long time = executeAverage("Bubble", estadosDeDatos[i], 10).timeNanos;
                    if (i == 0) timeBubbleAleatorio = time; // Guardamos para cálculo de CO2
                }
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
                    long time = executeAverage("Quick", estadosDeDatos[i], 10).timeNanos;
                    if (i == 0) timeQuickAleatorio = time; // Guardamos para cálculo de CO2
                } catch (StackOverflowError e) {
                    System.out.println("ERROR: StackOverflow. Altura (h) excedió límite JVM por degeneración estructural.");
                }
            }

            // 4. ANÁLISIS AMBIENTAL (Comparar Bubble vs Quick usando tiempos del estado Aleatorio)
            System.out.println("\n--- ANÁLISIS DE IMPACTO AMBIENTAL (CO2) ---");
            System.out.println("Comparando: Bubble Sort vs Quick Sort");
            double bubbleCO2 = EcoAnalyzer.calculateCO2Kg(timeBubbleAleatorio, operacionesServidor);
            double quickCO2  = EcoAnalyzer.calculateCO2Kg(timeQuickAleatorio, operacionesServidor);

            System.out.printf("CO2 emitido por Bubble Sort (%,d ejecuciones): %.4f Kg%n", operacionesServidor, bubbleCO2);
            System.out.printf("CO2 emitido por Quick Sort (%,d ejecuciones): %.4f Kg%n", operacionesServidor, quickCO2);
            
            double ahorroKg = bubbleCO2 - quickCO2;
            double ahorroPct = (bubbleCO2 > 0) ? (ahorroKg / bubbleCO2 * 100.0) : 0.0;
            double ahorroToneladas = ahorroKg / 1000.0;
            
            System.out.printf("AHORRO ABSOLUTO al migrar a Quick Sort: %.4f Kg (%.2f%%)%n", ahorroKg, ahorroPct);
            System.out.printf("AHORRO PROYECTADO (anual): %.6f toneladas de CO2%n", ahorroToneladas);
        }
    }

    private static SortResult executeAverage(String algorithm, int[] originalArr, int iterations) {
        long totalTime = 0;
        int lastHeight = 0;

        for (int i = 0; i < iterations; i++) {
            // Se crea una copia para no alterar el arreglo original en cada iteración
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

        // Calcula el promedio para obtener una métrica estable
        long avgTime = totalTime / iterations;
        // Convierte a milisegundos para una mejor legibilidad
        double avgTimeMs = avgTime / 1_000_000.0;
        System.out.printf("Tiempo Promedio: %.2f ms | Altura final (h): %d%n", avgTimeMs, lastHeight);
        return new SortResult(avgTime, lastHeight);
    }
}