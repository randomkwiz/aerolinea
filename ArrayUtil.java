/*
 * Implementa una clase de utilidad donde se contemplen funcionalidades como: 
 * a. Dado un array cargado aleatoriamente, generar a partir de él otro array que contenga los elementos pares que se encuentran en el primero. 
 * b. Crear un array de 20 elementos, con números aleatorios comprendidos entre 100 y 300, de forma que no se repita ningún elemento.  
 * c. Dado un array de números enteros, generar a partir de él un nuevo array donde se almacenen los elementos del primero que sean primos.   
 * d. A partir de un array generar otro con los elementos al revés.  
 * e. Funcionalidad que reciba un array de enteros y un número y devuelva la posición en la que lo encuentre y 0 si el número no está en el array. 
 * 	  En el array no puede haber números repetidos. 
 * */


public class ArrayUtil {
		
	/*	Interfaz
	 * Comentario: carga un array dado con numeros aleatorios entre dos numeros dados
	 * Cabecera: public static int[] cargarAleatoriamente (double[] myArray, double min, double max)
	 * Precondiciones: el array debe ser de doubles
	 * Datos de entrada: array de doubles
	 * Datos de salida: otro array de doubles con la longitud del array introducido por parametros
	 * Postcondiciones: se devuelve un array asociado al nombre
	 * 
	 * */
	
	public static double[] cargarAleatoriamente (double[] myArray, double min, double max){
		double[] myArray2 = new double [myArray.length];
		for (int i =0; i < myArray2.length; i ++) {
			
			myArray2[i] = (Math.random() * (max - min) + min);
			
			//System.out.println( "myArray["+i+"] = "+myArray[i]);
			}
		return myArray2;
	}
	
	/*Igual que el anterior pero con tipos int*/
		public static int[] cargarAleatoriamente (int[] myArray, int min, int max){
		int[] myArray2 = new int [myArray.length];
		for (int i =0; i < myArray2.length; i ++) {
			
			myArray2[i] = (int) (Math.random() * (max - min) + min);
			
			//System.out.println( "myArray["+i+"] = "+myArray[i]);
			}
		return myArray2;
	}
	

	/*	Interfaz
	 * Comentario: carga un array dado con numeros aleatorios entre 1 y 10 
	 * Cabecera: public static int[] cargarAleatoriamente (double[] myArray)
	 * Precondiciones: el array debe ser de doubles
	 * Datos de entrada: array de doubles
	 * Datos de salida: otro array de doubles con la longitud del array introducido por parametros
	 * Postcondiciones: se devuelve un array asociado al nombre
	 * 
	 * */

	public static double[] cargarAleatoriamente (double[] myArray){
		double[] myArray2 = new double [myArray.length];
		for (int i =0; i < myArray2.length; i ++) {
			
			myArray2[i] = (int) (Math.random() * ( (100 - 10) + 1) +10);	
			myArray2[i] /= 10; 
			//ASI FUNCIONA, NO TOCAR. TE DEVUELVE NUMEROS ENTRE 1 Y 10 PERO SIN PASARSE DE 10.0
			
			
			//System.out.println( "myArray["+i+"] = "+myArray[i]);
			}
		return myArray2;
	}





	/*	Interfaz
	 * Comentario: carga un array dado con numeros aleatorios entre 100 y 300
	 * Cabecera: public static int[] cargarAleatoriamente (int[] myArray)
	 * Precondiciones: el array debe ser de enteros
	 * Datos de entrada: array de enteros
	 * Datos de salida: otro array de enteros con la longitud del array introducido por parametros
	 * Postcondiciones: se devuelve un array asociado al nombre
	 * 
	 * */
	
	public static int[] cargarAleatoriamente (int[] myArray){
		int[] myArray2 = new int [myArray.length];
		for (int i =0; i < myArray2.length; i ++) {
			
			myArray2[i] = (int) (Math.random() * 300 +100);
			
			//System.out.println( "myArray["+i+"] = "+myArray[i]);
			}
		return myArray2;
	}
	
	/*	Interfaz 
	 * Comentario: genera un array a partir de otro solo con los elementos pares del segundo array
	 * Cabecera: public static int[] generarArrayElementosPares (int[] myArray)
	 * Precondiciones: 
	 * Datos entrada: un array
	 * Datos salida: otro array
	 * Postcondiciones: devuelve otro array asociado al nombre
	 * */
	
	public static int[] generarArrayElementosPares (int[] myArray) {
		int i = contarElementosPares(myArray);
		int[] myArray2 = new int [i];
		
		for (int j = 0, k =0 ; j < myArray.length; j++ ){
			
			if (myArray[j] % 2 == 0 ) {
				myArray2[k] = myArray[j];
				k++;
				}
			
			}
		return myArray2;
		}
		
	/*	Interfaz
	 * Comentario: cuenta los elementos pares que hay en un array dado
	 * Cabecera: public static int contarElementosPares (int[] myArray)
	 * Precondiciones: 
	 * Datos de entrada: un array de enteros
	 * Datos de salida: un entero que sera la cantidad de elementos pares que hay en el array dado
	 * Postcondiciones: un entero sera devuelto asociado al nombre
	 * 
	 * */
		
	public static int contarElementosPares (int[] myArray){
		int contador = 0;
		for (int i = 0; i < myArray.length; i++ ){
			
			if (myArray[i] % 2 == 0 ) {
				contador++;
				}
			
			}		
		return contador;
		
		}
	
	//Crear un array de 20 elementos, con números aleatorios comprendidos entre 100 y 300, de forma que no se repita ningún elemento.  
	/*	Interfaz
	 * Comentario: Crea un array de 20 elementos, con números aleatorios comprendidos entre 100 y 300, de forma que no se repita ningún elemento. 
	 * Cabecera: public static int[] generarArrayVeinteElementos ()
	 * Precondiciones: el array sera de enteros
	 * Datos entrada: 
	 * Datos salida: un array de enteros de 20 elementos
	 * E/S: 
	 * Postcondiciones: devuelve un array de enteros asociado al nombre
	 * */
	
	
	public static int[] generarArrayVeinteElementos () {
		int[] myArray = new int[20];
		
		for(int i = 0; i< myArray.length; i++){
			myArray[i] = (int) (Math.random() * 300 + 100 );
			
				if (i>0 && esRepetido(myArray, myArray[i], i )) {
					do{
						
					myArray[i] = (int) (Math.random() * 300 + 100 );
					System.out.println(myArray[i]);
					
					}while ( esRepetido(myArray, myArray[i], i ));
					}
			}

		return myArray;
		}
		
		/* Interfaz
		 * Comentario: comprueba si un numero esta en un array, evaluando el array hasta una posicion dada
		 * Signatura: public static boolean esRepetido (int[] myArray, int num, int posicion)
		 * Precondiciones: el array es un array de enteros
		 * Datos de entrada: un array y dos enteros que seran el numero a evaluar si esta en el array y la posicion hasta la que se comprobara
		 * Datos de salida: un boolean que devolvera true si ese numero esta en ese array comprobando desde la posicion 0 hasta la indicada
		 * E/S:
		 * Postcondiciones:
		 * */
		
	public static boolean esRepetido (int[] myArray, int num, int posicion) {
			boolean repe = false;
			
			
				for (int i = 0; i < posicion; i++) {
				
					if (myArray[i] == num ){
						repe = true;
						}
					
					}
			
		return repe;
		}
		/*Metodo sobrecargado por si no introduces en los parametros la posicion, para que recorra el array entero*/
			
	public static boolean esRepetido (int[] myArray, int num) {
			boolean repe = false;
			
			
				for (int i = 0; i < myArray.length; i++) {
				
					if (myArray[i] == num ){
						repe = true;
						}
					
					}
			
		return repe;
		}
		
	
	/*  Dado un array de números enteros, generar a partir de él un nuevo array 
	 * donde se almacenen los elementos del primero que sean primos.   
	 * */
	 public static int[] elementosPrimos(int[] myArray){
			int n = contarPrimos(myArray);
			int myArray2[] = new int[n];
			
			for (int i =0, j = 0 ; i < myArray.length; i++){
				if (Calculo.isPrimo(myArray[i])) {
					myArray2[j] = myArray[i];
					j++;
					}
				
				}
		 
		 return myArray2;
		 }
	/* Interfaz
	 * 	-Prototipo: public static int contarPrimos(int[] myArray)
		-Comentario de lo que realiza: dado un array de enteros, devuelve el numero de numeros primos que contiene
		-Precondiciones: el array debe ser de enteros
		-Entradas: un array de enteros pasado por --
		-Salidas: devuelve la cantidad de numeros primos asociado al nombre
		-Entrada/Salida
		-Postcondiciones
	 * 
	 * */
	
	public static int contarPrimos(int[] myArray){
		int n=0;
		for(int i=0; i<myArray.length; i++){
			 if ( Calculo.isPrimo(myArray[i]) ) {
				 n++;
				 }
		
			 }	
		return n; 
		}


 //d. A partir de un array generar otro con los elementos al revés.
 
	/* Interfaz
	 * Comentario: A partir de un array genera otro con los elementos al revés.
	 * Cabecera: public static int[] invertirElementos (int[] myArray)
	 * Precondiciones:
	 * Datos entrada: un array
	 * Datos salida: otro array
	 * Postcondiciones:
	 * 
	 * */
	 public static int[] invertirElementos (int[] myArray) {
		 int[] myArrayInvertido = new int[myArray.length];
		// System.out.println("Largo: "+myArray.length);
		 for( int i = 0; i< myArray.length; i++  ){
			// System.out.println("myArray original posicion "+i+": "+myArray[i]);
			 myArrayInvertido[myArray.length - 1 -i ] = myArray[i]; 
			// System.out.println("myArray invertido posicion "+(myArray.length - 1 -i)+": "+myArrayInvertido[myArray.length - 1 -i ]);
			 }
		 return myArrayInvertido;
		 }
	 

/*e. Funcionalidad que reciba un array de enteros y un número y devuelva la posición en la que lo encuentre y -1 si el número no está en el array. 
 * 	  En el array no puede haber números repetidos. 
*/

/*	Interfaz
 * Comentario: Funcionalidad que reciba un array de enteros y un número y 
 * 			   devuelva la posición en la que lo encuentre y 0 si el número no está en el array. 
 * 			   En el array no puede haber números repetidos. 
 * Cabecera: public static int buscarPosicion (int[] myArray, int numero)
 * Precondiciones: En el array no puede haber números repetidos. 
 * Datos de entrada: un array y un entero
 * Datos de salida: un numero 
 * Postcondiciones: se devolvera un numero asociado al nombre que sera la posicion del array en la que ha encontrado 
 * 					el numero que se ha introducido como parametro de entrada. Se devolvera -1 si el numero no se ha encontrado en el array.
 * */

	public static int buscarPosicion (int[] myArray, int numero) {
		int pos=-1;
		for(int i = 0; i < myArray.length; i++) {
			
			if (myArray[i] == numero ) {
				pos = i;
				}
			}
		return pos;
		}





	//Metodos Object
	
	public static String toString (int[] myArray){
		String array = "\n";
		for (int i =0; i < myArray.length; i ++) {
			 array += "myArray["+i+"] = "+myArray[i]+"\n"; 
			}
		return array;
		}
	
}

