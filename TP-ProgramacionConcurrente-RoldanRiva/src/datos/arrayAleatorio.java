package datos;

import java.util.Random;

public class arrayAleatorio {

	public static int[] cargarArrayAleatorio (int n, int minimo, int maximo) { 
		
		//Declaro el array 
		int[] arrayAleat = new int [n];	
		
		//Genero los numeros aleatorios
		Random random = new Random();
		
		for (int i = 0; i < n; i++) {
			//Se obtiene el numero aleatorio (en el rango de minimo y maximo) y se lo inserta en el array
			arrayAleat[i] = random.nextInt(maximo - minimo + 1)+ minimo;
		} 
		//Retorna el array con numeros aleatorios
		return arrayAleat;
	}
	
	//Metodo para mostrar el array (solo usado para realizar los casos de prueba)
	public static void mostrarArrayAleat(int[] arrayAleat) {
		System.out.println("\n -- Array Aleatorio --\n");
		
		//Se recorre el array y se muestran los numeros 
		for (int numero : arrayAleat) {	
			//Donde se imprimen
			System.out.print(numero + " - "); 
		}
	}
}
