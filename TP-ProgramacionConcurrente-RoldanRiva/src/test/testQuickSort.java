package test;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import datos.Concurrencia;
import datos.QuickSort;
import datos.arrayAleatorio;

public class testQuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Se necesita crear variables de inicio y fin para el calcular el tiempo 
		long inicio;
		long fin;
				
		//Creamos y cargamos el arreglo 'array' con numeros aleatorios
		int[] array = arrayAleatorio.cargarArrayAleatorio(100, 1, 1000);
		// Copiamos el arreglo 'array' en 'array2', manteniendo la misma longitud
		int[] array1 = Arrays.copyOf(array, array.length);
				
		System.out.println(" -- QUICKSORT SECUENCIA -- ");
		//Tiempo donde comienza
		inicio = System.nanoTime();	
				
		//Ordena el array
		QuickSort.quickSort(array, 0, array.length -1);
				
		//Tiempo donde termina
		fin = System.nanoTime() - inicio;	
				
		// Mostramos cuanto tiempo tardó el algoritmo secuencial
		System.out.println("El tiempo del algoritmo de secuencia es de: " + fin/1000+ " microSegundos.\n");
				
		
		System.out.println(" -- QUICKSORT CONCURRENTE --");
		//Tiempo donde comienza
		inicio = System.nanoTime();	
		 
		//Se implementa para ejecutar de manera optimizada las tareas que se realizan de forma paralela
		ForkJoinPool pool = ForkJoinPool.commonPool();
		
		//Invoke: no continua hasta que el orden del array se termine
		//lo divide en hilos (se realiza la concurrencia) y lo optimiza 
		pool.invoke(new Concurrencia(0, array1.length - 1, array1));
		
		//Tiempo donde termina
		fin = System.nanoTime() - inicio;	
		
		// Mostramos cuanto tiempo tardó el algoritmo secuencial
		System.out.println("El tiempo del algoritmo de concurrencia es de: " + fin/1000+ " microSegundos.\n");

	}
}
