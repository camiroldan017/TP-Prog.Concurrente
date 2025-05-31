package datos;
import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.*;

//CONCURRENTE
@SuppressWarnings("serial")
public class Concurrencia extends RecursiveTask<Integer> {
	
	//Umbral: para dividir las tareas en hilos
	 private static final int THRESHOLD = 1000;
	
	 int start, end;
	 int[] arr;
	 
	 //Se realiza la particion 
	 private int partition(int start, int end, int[] arr){

	     int i = start, j = end;

	     //De manera aleatoria elige al pivote
	     int pivoted = new Random().nextInt(j - i)+ i;

	     //Realiza el intercambio con el ultimo numero del array
	     int t = arr[j];
	     arr[j] = arr[pivoted];
	     arr[pivoted] = t;
	     j--;

	     //Comienza la particion 
	     while (i <= j) {
	         if (arr[i] <= arr[end]) {
	             i++;
	             continue;
	         }
	         if (arr[j] >= arr[end]) {
	             j--;
	             continue;
	         }

	         //Intercambio de posiciones
	         t = arr[j];
	         arr[j] = arr[i];
	         arr[i] = t;
	         j--;
	         i++;
	     }

	     //Coloca al pivote en su posicion o indice correcto
	     t = arr[j + 1];
	     arr[j + 1] = arr[end];
	     arr[end] = t;
	     return j + 1;
	 }
	 
	 //Se definen los limites o "bordes" del array
	 public Concurrencia(int start, int end, int[] arr){
	     this.arr = arr;
	     this.start = start;
	     this.end = end;
	 }

	 @Override
	 protected Integer compute(){
	     //Validaciones:
		 //Si son invalidos o nulos/vacios se termina la ejecucion
		 if (start >= end || arr == null || arr.length == 0) return null;
		 if (start < 0 || end >= arr.length) return null;
		 
		 //Si el tamaño del array es mas chico que el umbral, se realiaza el ordenamiento directamente antes de dividir en hilos
		 if (end - start < THRESHOLD) {
				Arrays.sort(arr, start, end + 1);
				return null;
		 }
	       
	     //Encuentra en que posicion quedo el pivote una vez terminada la particion
	     int p = partition(start, end, arr);

	     //Se crean "minis" arrays
	     //El array que queda en la izquierda
	     Concurrencia left = new Concurrencia(start, p - 1, arr);
	     //El array que queda en la derecha
	     Concurrencia right= new Concurrencia(p + 1, end, arr);

	     //Ejecuta el izquierdo
	     left.fork();
	     //Ejecuta el derecho
	     right.compute();

	     //Espera a que termine el "mini array" de la izquierda
	     left.join();
	     
	     return null;
	 }
}

//Utilizamos la API Fork/Join, divide el problema en partes aun mas pequeñas para luego dividirlas
//en subproblemas y mejora la eficiencia del algoritmo. 
