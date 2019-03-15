/*
 * . (Sistema de Reserva de Vuelos). 
 * Una pequeña compañía aérea acaba de comprar un ordenador para su sistema de reserva de vuelos. 
 * Escribir un programa que asigne asientos para cada vuelo del único avión de la compañía (capacidad: 20 asientos). 
 * El programa debe contemplar zona de fumadores y no fumadores. 
 * Los no fumadores ocuparan los asientos 1-15 y los fumadores el resto. 
 * Utiliza un array de una dimensión para representar los asientos del avión. 
 * Utiliza 0 para indicar asiento vacío y 1 asiento ocupado. 
 * El programa nunca debe hacer "overbooking", es decir, reasignar un asiento que ya está ocupado. 
 * Si la sección de fumadores se llena, el programa debe preguntar al pasajero si desea un asiento en la zona de no fumadores, 
 * y viceversa. Si acepta, entonces has de realizar la asignación de asiento correspondiente. 
 * Si no acepta, avise de la salida del próximo vuelo. 
 * Añada cuantos requisitos considere conveniente. 
 * 
 * 
 * */

/*
 * Estudio de interfaz de la clase
 * Clase: Vuelos
 * Propiedades: 
 * 	Basicas: array de 20 enteros asiento, consultable y modificable
 * 	Compartidas: 	
 * 	Derivadas:	
 * 	Restricciones de los datos: los valores del array solo pueden ser 0 o 1
 * 
 * Metodos (para interface):
 * 	public int[] getAsiento () {
		
		return this.asiento;
		}	
		
	public int getAsientoElemento (int i){
		
		return asiento[i];
		}
	public void setAsiento (int[] asiento){
		this.asiento = asiento;
		}
		
	public void setAsientoElemento (int i, int newValor){
		
		this.asiento[i] = newValor;
		}
 * 
 * 
 * Metodos añadidos:
 * 
 * public int siguienteAsientoVacio (boolean fumador)
 * 
 * public int asignarAsiento (boolean esFumador)
 * 
 * public void reservarAsientos (int cantidad, boolean fumadores)
 * 
 * public boolean quedanAsientosLibres (boolean fumador)
 * 
 * public int cantidadAsientosLibres ()
 * 
 * public int cantidadAsientosLibres (boolean fumador)
 * 
 * 
 * 
 * Metodos añadidos obligatorios:
 * 		equals
 * 		compareTo
 * 		toString
 * 		hashCode
 * 		clone
 * 
 * */

public class VuelosImpl  implements  Vuelos  {
	
	private int[] asiento = new int[20];

	public VuelosImpl () {
		for (int i=0; i < asiento.length; i++ ) {
			setAsientoElemento(i, 0);
			}
		
		}
		
	public int[] getAsiento () {
		
		return this.asiento;
		}	
		
	public int getAsientoElemento (int i){
		
		return asiento[i];
		}
	public void setAsiento (int[] asiento){
		this.asiento = asiento;
		}
		
	public void setAsientoElemento (int i, int newValor){
		
		this.asiento[i] = newValor;
		}


/*
	-Prototipo: public int siguienteAsientoVacio (boolean fumador)
	-Comentario de lo que realiza: busca cual es el siguiente asiento disponible segun si el pasajero es fumador o no
	-Precondiciones
	-Entradas: boolean que indica si el pasajero es fumador o no
	-Salidas: numero del siguiente asiento vacio
	-Entrada/Salida
	-Postcondiciones
*/
	public int siguienteAsientoVacio (boolean fumador){
		int asientoValido=-1;

		
		//System.out.println("Copia del estado actual del vuelo: \n"+this.toString());
		
		if (fumador){
			for (int i= asiento.length-1; i > 14 ; i--){		//pongo que vaya hacia atras para que empiece a dar los asientos del primero disponible al ultimo
				if (getAsientoElemento(i) == 0){
					asientoValido = i;
				}
					
				
				}
			} else {
			for (int i=14; (i >= 0); i--){
				if (getAsientoElemento(i) == 0){
					asientoValido = i;
				}
				
				}	
				
			}
		
		return asientoValido;
		}
	
/*
	-Prototipo: public int asignarAsiento (boolean esFumador)
	-Comentario de lo que realiza: asigna un asiento a un pasajero segun si es fumador o no
	-Precondiciones
	-Entradas: boolean que indica si el pasajero es fumador o no
	-Salidas: numero del asiento asignado
	-Entrada/Salida
	-Postcondiciones
*/

	public int asignarAsiento (boolean esFumador){
		int butaca = -1;
		
		butaca = siguienteAsientoVacio(esFumador);
		setAsientoElemento(butaca, 1);
		//System.out.println("asiento resultado de asignarAsiento "+butaca );
		
		return butaca;
		}
		
	/*
	-Prototipo: public void reservarAsientos (int cantidad, boolean fumadores)
	-Comentario de lo que realiza: reserva varios asientos
	-Precondiciones
	-Entradas: boolean que indica si el pasajero es fumador o no
	-Salidas: numero del asiento asignado
	-Entrada/Salida
	-Postcondiciones
*/
	
	public void reservarAsientos (int cantidad, boolean fumadores){
		
		for(int i = 0 ; i<cantidad; i++){
			asignarAsiento(fumadores);
			}
		
		}


		
	/*
	-Prototipo: public boolean quedanAsientosLibres (boolean fumador)
	-Comentario de lo que realiza: revisa si quedan asientos libres en el vuelo para un pasajero fumador o no fumador
	-Precondiciones
	-Entradas: boolean que indica si el pasajero es fumador o no
	-Salidas: boolean que indica si quedan asientos o no
	-Entrada/Salida
	-Postcondiciones
*/
	
	public boolean quedanAsientosLibres (boolean fumador){
		boolean res = true;
		if (siguienteAsientoVacio(fumador) == -1) {
			res = false;
			}
		return res;
		}
	
		
	/*
	-Prototipo:public int cantidadAsientosLibres ()
	-Comentario de lo que realiza: devuelve cuantos asientos libres quedan, independientemente de si son para fumadores o no
	-Precondiciones
	-Entradas:
	-Salidas: entero que indica cuantos asientos libres quedan
	-Entrada/Salida
	-Postcondiciones
*/
	
	public int cantidadAsientosLibres (){
		int libres = 0;
		
		for(int i = 0; i < asiento.length; i++){
			if (getAsientoElemento(i) == 0) {
				libres++;
				}
			
			}
		
		return libres;
		}
	
	/*Metodo sobrecargado, este si diferencia entre asientos para fumadores y para no fumadores*/
		public int cantidadAsientosLibres (boolean fumador){
		int libres = 0;
		
				if (fumador){
			for (int i= asiento.length-1; i > 14 ; i--){		
				if (getAsientoElemento(i) == 0){
					libres++;
				}
					
				
				}
			} else {
			for (int i=14; (i >= 0); i--){
				if (getAsientoElemento(i) == 0){
					libres++;
				}
				
				}	
				
			}
		
		
		
		return libres;
		}

	//Metodos Object
	

	
	
	
	@Override
	public String toString (){
		String cadena="ASIENTOS PARA NO FUMADORES\n";
		for (int i = 0; i < asiento.length; i++){
			cadena += "Asiento "+(i+1)+" Estado: "+asiento[i] + "\n";
			
			if (i == 14) {
				cadena += "\nASIENTOS PARA FUMADORES \n";
				
				}
			
			}
		return cadena;
		}
		
	
}

