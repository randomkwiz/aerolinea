/*
 * Alumna: Angela Vazquez Dominguez
 * Nombre: 
 * Comentario: 
(Sistema de Reserva de Vuelos). Una pequeña compañía aérea acaba de comprar un ordenador para su sistema de reserva de vuelos. Escribir un programa que asigne asientos para cada vuelo del único avión de la compañía (capacidad: 20 asientos). El programa debe contemplar zona de fumadores y no fumadores. Los no fumadores ocuparan los asientos 1-15 y los fumadores el resto.
Utiliza un array de una dimensión para representar los asientos del avión. Utiliza 0 para indicar asiento vacío y 1 asiento ocupado.
El programa nunca debe hacer "overbooking", es decir, reasignar un asiento que ya está ocupado. Si la sección de fumadores se llena, el programa debe preguntar al pasajero si desea un asiento en la zona de no fumadores, y viceversa. Si acepta, entonces has de realizar la asignación de asiento correspondiente. Si no acepta, avise de la salida del próximo vuelo.
Añada cuantos requisitos considere conveniente.
 * Datos de entrada: opciones del usuario
 * Datos de salida: mensajes de ayuda al usuario
 * Restricciones: 

 * PSEUDOCODIGO GENERALIZADO
 * 	inicio
 * 		repetir
 * 			mostrarMenuLeerValidarOpcion
 * 			si (la opcion no es salir)
 * 				segun (opcion)
 * 					caso 1
 * 						Reservar asientos del vuelo
 * 					caso 2 
 * 						Cancelar asientos del vuelo
 * 					caso 3
 * 						Revisar asientos del vuelo
 * 				finSegun
 * 			finSi
 * 		mientras opcion no sea salir
 * 	fin
 */
 
 import java.util.Scanner;
 import java.lang.Character;
public class Main {
	
	public static void main (String[] args) {
		int opcion, cantidadPasajeros;
		int noFumadores, fumadores;
		char respuesta= ' ';
		Scanner entrada = new Scanner(System.in);
		VuelosImpl myVuelo = new VuelosImpl();
		
		do {
			//mostrarMenuLeerValidarOpcion
			do{
				System.out.println("-------MENU--------");
				System.out.println("0. Salir");
				System.out.println("1. Reservar asientos del vuelo");
				System.out.println("2. Cancelar asientos del vuelo");
				System.out.println("3. Revisar asientos del vuelo");
				opcion = entrada.nextInt();	
				}while(opcion < 0 || opcion > 3);
			
			if (opcion != 0 ){
				switch (opcion) {
					
					case 1:
						//Reservar asientos del vuelo
				
						do{
						
						System.out.println("Actualmente quedan "+myVuelo.cantidadAsientosLibres(true)+ " asientos libres para personas fumadoras.");
						System.out.println("Actualmente quedan "+myVuelo.cantidadAsientosLibres(false)+ " asientos libres para personas no fumadoras.");
						System.out.println("Presione 0 para cancelar");
						System.out.print("Cuantos billetes desea reservar? : ");
						
						cantidadPasajeros = entrada.nextInt();
						}while (cantidadPasajeros < 0 || cantidadPasajeros > myVuelo.cantidadAsientosLibres()  );
						
						if (cantidadPasajeros != 0 ){
							
							do{
								do{
								System.out.println("De esos "+ cantidadPasajeros+" billetes, cuantos son para personas no fumadoras?");
								noFumadores = entrada.nextInt();
								}while (noFumadores < 0 || noFumadores > cantidadPasajeros );
								
								fumadores = cantidadPasajeros - noFumadores;
								
								
								if (fumadores > myVuelo.cantidadAsientosLibres(true) || noFumadores > myVuelo.cantidadAsientosLibres(false)) {
									
									System.out.println("Disculpe, no queda espacio en su vagon para uno o mas de los billetes que intenta comprar. Desea comprar los billetes del vagon contrario?");
									
									//System.out.println("En este punto:\n fumadores vale: "+fumadores+"\nnoFumadores vale: "+noFumadores);
									
									
									if (fumadores > myVuelo.cantidadAsientosLibres(true)  ) {
										System.out.println( (fumadores-  myVuelo.cantidadAsientosLibres(true) )   +" billete(s) para fumadores se comprarian en el vagon de no fumadores. ");
									}
									if (noFumadores >  myVuelo.cantidadAsientosLibres(false)  ) {
										System.out.println( (noFumadores-  myVuelo.cantidadAsientosLibres(false)   )+" billete(s) para no fumadores se comprarian en el vagon de fumadores. ");
										}
								
									}

									System.out.println("Esta de acuerdo? S/N");
									
									respuesta = Character.toUpperCase(entrada.next().charAt(0));
								
								}while (respuesta != 'S' && respuesta != 'N');
								
								if (respuesta == 'S') {
									
									if (fumadores > myVuelo.cantidadAsientosLibres(true)   ) {
										/*
										noFumadores += fumadores-5;
										fumadores -= (fumadores-5); 
										*/
										
										noFumadores = noFumadores + (fumadores- myVuelo.cantidadAsientosLibres(true) );
										fumadores = fumadores - (fumadores -  myVuelo.cantidadAsientosLibres(true) );
										
									}
									if (noFumadores > myVuelo.cantidadAsientosLibres(false)  ) {
										/*
										fumadores += noFumadores-15;
										noFumadores -=(noFumadores-15);
										*/
										fumadores = fumadores + (noFumadores- myVuelo.cantidadAsientosLibres(false) );
										noFumadores = noFumadores - (noFumadores - myVuelo.cantidadAsientosLibres(false));
										}
									
									System.out.println("Has reservando "+fumadores+" asientos para fumadores.");
									System.out.println("Has reservando "+noFumadores+" asientos para no fumadores.");
									System.out.println((fumadores+noFumadores)+" asientos en total.");
									myVuelo.reservarAsientos(fumadores, true);
									myVuelo.reservarAsientos(noFumadores, false);
									
									} else {
										System.out.println("Lamentamos su decision. El siguiente vuelo sale en hh:mm hora(s).");
										
										
										}
							
							}
						
					break;
					
					case 2:
						int cancelar;
						char op;
						//Cancelar asientos del vuelo
						
						do{
							do{
							System.out.println("Indique el numero del asiento que desea cancelar. Recuerde que no puede cancelar un asiento que ya este disponible ");
							System.out.println("Presione 0 para salir");
							cancelar = entrada.nextInt();
							}while( cancelar < 0 || cancelar > 20 );
							
							
							if (cancelar != 0 && myVuelo.getAsientoElemento(cancelar-1) == 1) {
							myVuelo.setAsientoElemento(cancelar-1,0);
							System.out.println("El asiento "+cancelar+" ahora vuelve a estar disponible.");
							do{
							System.out.println("Desea cancelar otro asiento? S/N");
							op = Character.toUpperCase(entrada.next().charAt(0));
							}while (op != 'S' && op != 'N');
							
							if (op == 'N'){ cancelar = 0; }
						} else {System.out.println("Ese asiento ya esta libre, no puede cancelarlo.");}
						
						} while (cancelar != 0);
						
					break;
					
					
					case 3:
					
						//Revisar asientos del vuelo
						System.out.println(myVuelo.toString());
						System.out.println("Quedan "+myVuelo.cantidadAsientosLibres(true)+" asientos libres en el vagon de FUMADORES." );
						System.out.println("Quedan "+myVuelo.cantidadAsientosLibres(false)+" asientos libres en el vagon de NO FUMADORES." );
						
						
					break;
					
					
					} //switch
				
				
				}//cierra el if
			
			
			
			
			} while (opcion != 0);
	}
}
