# Laboratorio de Ordenamiento y Eficiencia

Este proyecto es una aplicación en Java diseñada para implementar, medir y comparar la eficiencia de tres algoritmos de ordenamiento fundamentales: Bubble Sort, Merge Sort y Quick Sort.

El objetivo es analizar su rendimiento computacional (tiempo de ejecución) y su impacto ambiental (huella de carbono) bajo diferentes condiciones de datos.

## Estructura del Proyecto

- `LABO-ORDEN/Laboratorio Ordenamiento/`: Directorio raíz de la lógica de la aplicación.
- `LABO-ORDEN/Laboratorio Ordenamiento/src/`: Contiene todos los archivos fuente `.java`.
- `LABO-ORDEN/Laboratorio Ordenamiento/src/Main.java`: Punto de entrada de la aplicación que orquesta los experimentos.
- `LABO-ORDEN/Laboratorio Ordenamiento/out/`: Directorio donde se almacenan los archivos `.class` compilados.

## Flujo de Trabajo

### 1. Compilar

Para compilar los archivos fuente, ejecute el siguiente comando desde el directorio `LABO-ORDEN/Laboratorio Ordenamiento/`:

```bash
javac -d out/ src/*.java
```

### 2. Ejecutar

Para correr la aplicación compilada, ejecute el siguiente comando desde el mismo directorio:

```bash
java -cp out Main
```
