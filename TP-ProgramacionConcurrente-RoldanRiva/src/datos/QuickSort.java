package datos;

//SECUENCIAL
public class QuickSort {
	
	//Implementacion del ordenamiento rapido (QUICK SORT)
	public static void quickSort(int[] arr, int low, int high) {
		
		//Se asegura que exista al menos dos numeros para ordenar, ademas de que el array no se este vacio 
		if (low < high) {
			
            //piv es el indice de retorno de la particion del pivote 
			int piv = partition(arr, low, high);
			
			//Se llama a la recursion del quickSort para ordenarlos
			//los ordena antes del pivote
			quickSort(arr, low, piv - 1);
			//los ordena despues del pivote
			quickSort(arr, piv + 1, high);
		}	
	}
	
	private static int partition(int[] arr, int low, int high) {
		// Seleccionamos el pivote
		int pivot = arr[high];
		
		//El numero mas pequeño o bajo se inicializa en i (indice o posicion)
		int i = low - 1;
		
		//Se recorre el array del i mas pequeño al mas grande
		for (int j = low; j < high -1; j++) {
			//Si el numero que tenemos es mas chico que el pivote, lo cambiamos con el numero que esta en la posicion mas chica
			if (arr[j] < pivot) {
				i++;
                swap(arr, i, j); //el swap hace el intercambio de posiciones
			}
		}
		swap(arr, i + 1, high); 
	       return i + 1;
	}
	 // Realiza la funcion del intercambio de posiciones para luego directamente llamarlo
    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
