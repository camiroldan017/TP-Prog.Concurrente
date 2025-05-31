package test;

import datos.arrayAleatorio;

//Solo lo utilizo para ver el funcionamiento del array 
public class testArrayAleatorio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Cargo el array de 10 elementos, con numeros aleatorios del 1 al 10000
		int[] array = arrayAleatorio.cargarArrayAleatorio(10, 1, 10000);
		
		//Se muestra el array
		arrayAleatorio.mostrarArrayAleat(array);
	}

}