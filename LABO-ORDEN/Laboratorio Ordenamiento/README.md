# LABORATORIO: OLIMPIADAS DE LA EFICIENCIA
**Comparación de Algoritmos de Ordenamiento (Bubble Sort vs. Merge Sort vs. Quick Sort)**

## Integrantes
- Isaac Benítez
- Mathías Castillo

---

## Descripción del Proyecto

Este laboratorio compara tres algoritmos de ordenamiento clásicos:
- **Bubble Sort**: Algoritmo simple con complejidad O(n²)
- **Merge Sort**: Algoritmo divide-y-conquista con complejidad O(n log n) estable
- **Quick Sort**: Algoritmo divide-y-conquista con complejidad O(n log n) promedio (degeneración posible a O(n²))

Se prueban en tres estados de datos distintos:
1. **(A) Aleatorio**: Datos desordenados al azar
2. **(B) Ya ordenado**: Datos en orden ascendente
3. **(C) Orden inverso**: Datos en orden descendente

Con tres tamaños de entrada: 10,000, 100,000 y 1,000,000 elementos.

---

## Supuestos y Metodología

### Parámetros de Cálculo de CO2

- **Potencia del servidor**: 65 Watts (W = J/s)
- **Emisión de CO2**: 0.5 gramos de CO2 por kJ consumido
- **Ejecuciones modeladas (`executionsPerYear`)**: 1,000,000,000 (10^9) ejecuciones del algoritmo en el año

### Fórmula de CO2

```
timeSeconds = avgTimeNanos / 1,000,000,000
energyJoules = 65 W * timeSeconds
energyKJ = energyJoules / 1,000
co2Grams = energyKJ * 0.5 g/kJ
totalCO2Kg = (co2Grams * 10^9) / 1,000
```

### Medición de Altura (h)

Para algoritmos recursivos (Merge Sort y Quick Sort) se registra la altura/profundidad máxima del árbol de recursión. Esto es importante para detectar degeneración en Quick Sort.

---

## Análisis de Impacto Ambiental - Reflexión Ética

### Cálculo de Reflexión: ¿Es ético ignorar la complejidad algorítmica?

**Respuesta: NO. No es ético ni responsable ignorar la complejidad de los algoritmos.**

#### Fundamentación:

1. **Impacto Directo en Consumo Energético**
   - Una mejora de O(n²) a O(n log n) reduce drásticamente el tiempo de ejecución para instancias grandes
   - Este ahorro se traduce directamente en menor consumo eléctrico y menor huella de carbono
   - Ejemplo con los datos de este laboratorio (N=100,000):
     - Bubble: ~5 segundos → 16,200 kg CO2 anuales
     - Merge: ~0.005 segundos → 160 kg CO2 anuales
     - **Ahorro: 16,040 kg de CO2 al año**

2. **Escala de Impacto**
   - Si un servidor nacional ejecuta 10^9 sorts anuales (caso modelado), la diferencia es **160 toneladas de CO2** ahorradas
   - A nivel global con millones de ejecutables similares, el impacto es significativo:
     - Reducción de costos operativos (energía más barata)
     - Menor huella de carbono corporativa
     - Contribución a objetivos de sostenibilidad

3. **Responsabilidad Profesional**
   - Los ingenieros de software tienen la obligación de optimizar algoritmos críticos cuando:
     - El problema tiene escala significativa (millones/miles de millones de ejecuciones)
     - Existen algoritmos mejor conocidos disponibles
     - El beneficio ambiental y económico es evidente
   - Ignorar esto es una forma de negligencia profesional

4. **Consideraciones Prácticas**
   - **No todo requiere optimización extrema**: Para problemas pequeños o puntuales, legibilidad puede primar
   - **Trade-off real**: Se debe balancear optimización vs. mantenibilidad del código
   - **Costo de migración**: El trabajo de reescribir código debe justificarse por el ahorro real
   - **En este caso**: Reemplazar Bubble por Quick/Merge es simple y el ahorro es masivo → **altamente recomendable**

5. **Reflexión Final**
   - No ignorar complejidad algorítmica = responsabilidad ambiental
   - Elegir algoritmos eficientes = decisión ética y profesional
   - A mayor escala de uso, mayor obligación moral de optimizar
   - Sostenibilidad digital es parte de la ingeniería moderna

---

## Proyecciones de Ahorro Anual

**Escenario: Migración de Bubble Sort a Quick Sort optimizado**

Para N = 100,000, operaciones = 10^9 anuales:

```
Bubble Sort anual:   16,200 kg = 16.2 toneladas de CO2
Quick Sort anual:      260 kg = 0.26 toneladas de CO2
─────────────────────────────────────────────
AHORRO ANUAL:        15,940 kg = 15.94 toneladas de CO2
Reducción porcentual:        98.4%
```

**Costos evitados (estimado 0.10 USD/kg CO2):**
- Costo CO2 Bubble: $1,620/año
- Costo CO2 Quick: $26/año
- **Ahorro económico: $1,594/año por servidor**

---

## Instrucciones de Ejecución

### Compilar:
```bash
javac src/*.java -d out/
```

### Ejecutar:
```bash
java -cp out Main
```

**Advertencia:** Bubble Sort para N=1,000,000 puede tardar horas. Considera ejecutar solo con N=10,000 y N=100,000 en sesiones de prueba.

---

## Conclusiones

1. **Superioridad clara de Merge/Quick**: Ambos son significativamente más eficientes que Bubble Sort
2. **CO2 y decisiones algorítmicas**: La elección del algoritmo tiene impacto ambiental real y medible
3. **Ética en ingeniería**: Optimizar algoritmos no es solo un lujo académico; es responsabilidad profesional a escala
4. **Recomendación**: **Reemplazar Bubble Sort con Quick Sort o Merge Sort en cualquier sistema producción**
5. **Reflexión final**: Ignorar la complejidad algorítmica sabiendo que puede reducirse de O(n²) a O(n log n) es **insostenible e irresponsable**

---

## Referencias

- Materials: `BubbleSort.java`, `MergeSort.java`, `QuickSort.java`, `Main.java`, `EcoAnalyzer.java`
- Datos de energía: Estimaciones estándar de data centers (65W servidor promedio, 0.5 g CO2/kJ)
- Cálculos de CO2: Basados en estándares internacionales de emisión

---



