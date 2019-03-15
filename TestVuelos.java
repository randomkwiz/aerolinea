
public class TestVuelos {
	
	public static void main (String[] args) {
		Vuelos myVuelo = new Vuelos();
		System.out.println("RECIEN CREADO EL VUELO");
		System.out.println(myVuelo.toString());
		
		System.out.println(myVuelo.asignarAsiento(false));
		System.out.println(myVuelo.asignarAsiento(true));
		System.out.println(myVuelo.asignarAsiento(false));
		System.out.println("VUELO CON ASIENTOS ASIGNADOS");
		System.out.println(myVuelo.toString());
		
		
		System.out.println(myVuelo.asignarAsiento(true));
		System.out.println(myVuelo.asignarAsiento(false));
		System.out.println(myVuelo.asignarAsiento(true));
		System.out.println(myVuelo.asignarAsiento(false));
		System.out.println(myVuelo.asignarAsiento(false));
		
		System.out.println("VUELO CON ASIENTOS ASIGNADOS");
		System.out.println(myVuelo.toString());
		
		
		System.out.println(myVuelo.asignarAsiento(false));
		System.out.println(myVuelo.asignarAsiento(false));
		System.out.println(myVuelo.asignarAsiento(false));
		System.out.println(myVuelo.asignarAsiento(false));
		System.out.println(myVuelo.asignarAsiento(false));
		System.out.println(myVuelo.asignarAsiento(false));
		System.out.println(myVuelo.asignarAsiento(false));
		System.out.println(myVuelo.asignarAsiento(false));

		System.out.println(myVuelo.asignarAsiento(false));
//		System.out.println(myVuelo.asignarAsiento(false));
		System.out.println("VUELO CON ASIENTOS ASIGNADOS");
		System.out.println(myVuelo.toString());
		
		
		System.out.println("Asientos libres en total: "+myVuelo.cantidadAsientosLibres());
		System.out.println("Asientos libres para fumadores: "+myVuelo.cantidadAsientosLibres(true));
		System.out.println("Asientos libres para no fumadores: "+myVuelo.cantidadAsientosLibres(false));
		
		
	}
}

