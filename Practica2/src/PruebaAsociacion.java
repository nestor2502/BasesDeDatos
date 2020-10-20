package src;

import src.*;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Clase de prueba para capturar, consultar, editar y eliminar en los csv.
 * @author jose ramirez
 */
public class PruebaAsociacion {
	public static void main(String[] args) {
		boolean bandera;
		int opcion = 0;
		Scanner input = new Scanner(System.in);
		Asociacion asociacion = new Asociacion();
		do {
			bandera = true;
            System.out.println("Selecciona una categoria.\n" + "1- Propietarios\n" + 
            "2- Choferes\n" + "3- Taxis\n" + "4- Salir\n" );
			try {
				opcion = input.nextInt();
			} catch (InputMismatchException e) {
				input.next();
				System.out.println("Ingresa un numero como opcion");
			}
			if (opcion > 0 && opcion < 5) {
				switch (opcion) {
				case 1:
                    System.out.println("Selecciona una accion.\n" + "1- Agregar\n" + 
                    "2- Consultar\n" + "3- Modificar\n" + "4- Eliminar\n" );
                    try {
                        opcion = input.nextInt();
                    } catch (InputMismatchException e) {
                        input.next();
                        System.out.println("Ingresa un numero como opcion");
                    }
                    if (opcion > 0 && opcion < 5) {
                        switch (opcion) {
                        case 1:
                            Propietario propietario = new Propietario();
                            asociacion.agregaPropietario(propietario);
                            if (propietario.getEsChofer())
                                asociacion.agregaChofer(propietario.convierteAChofer());
                            break;
                        case 2:
                            System.out.println(asociacion.listadoPropietarios());
                            break;
                        case 3:
                            System.out.println("Elige el número del propietario que deseas editar");
                            bandera = true;
                            do {
                                try {
                                    System.out.println(asociacion.listadoPropietarios());
                                    opcion = input.nextInt();
                                    asociacion.getPropietario(opcion).edita();
                                    bandera = false;
                                    System.out.println("Propietario editado correctamente");
                                } catch (InputMismatchException i) {
                                    System.out.println("Ingresa un número como opcion");
                                    input.next();
                                    bandera = true;
                                }
                            } while (bandera);
                            bandera = true;
                            break;
                        case 4:
                            System.out.println("Elige el numero del propietario que deseas borrar");
                            bandera = true;
                            do {
                                try {
                                    System.out.println(asociacion.listadoPropietarios());
                                    opcion = input.nextInt();
                                    asociacion.eliminaPropietario(opcion);
                                    bandera = false;
                                } catch (InputMismatchException i) {
                                    System.out.println("Ingresa un numero como opcion");
                                    input.next();
                                    bandera = true;
                                }
                            } while (bandera);
                            bandera = true;
                            break;
                        default:
                            break;
                        }
                    break;
                    }
				case 2:
					System.out.println("Selecciona una accion.\n" + "1- Agregar\n" + 
                    "2- Consultar\n" + "3- Modificar\n" + "4- Eliminar\n" );
                    try {
                        opcion = input.nextInt();
                    } catch (InputMismatchException e) {
                        input.next();
                        System.out.println("Ingresa un numero como opcion");
                    }
                    if (opcion > 0 && opcion < 5) {
                        switch (opcion) {
                        case 1:
                            Chofer chofer = new Chofer();
                            asociacion.agregaChofer(chofer);
                            break;
                        case 2:
                            System.out.println(asociacion.listadoChoferes());
                            break;
                        case 3:
                            System.out.println("Elige el numero del chofer que deseas editar");
                            bandera = true;
                            do {
                                try {
                                    System.out.println(asociacion.listadoChoferes());
                                    opcion = input.nextInt();
                                    asociacion.getChofer(opcion).edita();
                                    bandera = false;
                                    System.out.println("Chofer editado correctamente");
                                } catch (InputMismatchException i) {
                                    System.out.println("Ingresa un numero como opcion");
                                    input.next();
                                    bandera = true;
                                }
                            } while (bandera);
                            bandera = true;
                            break;

                        case 4:
                            System.out.println("Elige el numero del chofer que deseas borrar");
                            bandera = true;
                            do {
                                try {
                                    System.out.println(asociacion.listadoChoferes());
                                    opcion = input.nextInt();
                                    asociacion.eliminaChofer(opcion);
                                    bandera = false;
                                } catch (InputMismatchException i) {
                                    System.out.println("Ingresa un numero como opcion");
                                    input.next();
                                    bandera = true;
                                }
                            } while (bandera);
                            bandera = true;
                            break;
                        default:
                            break;
                        }
                    }
                    break;
				case 3:
                    System.out.println("Selecciona una accion.\n" + "1- Agregar\n" + 
                    "2- Consultar\n" + "3- Modificar\n" + "4- Eliminar\n" );
                    try {
                        opcion = input.nextInt();
                    } catch (InputMismatchException e) {
                        input.next();
                        System.out.println("Ingresa un numero como opcion");
                    }
                    if (opcion > 0 && opcion < 5) {
                        switch (opcion) {
                        case 1:
                            Taxi taxi = new Taxi();
                            asociacion.agregaTaxi(taxi);
                            break;
                        case 2:
                            System.out.println(asociacion.listadoTaxis());
                            break;
                        case 3:
                        System.out.println("Elige el numero del taxi que deseas editar");
                        bandera = true;
                        do {
                            try {
                                System.out.println(asociacion.listadoTaxis());
                                opcion = input.nextInt();
                                asociacion.getTaxi(opcion).edita();
                                bandera = false;
                                System.out.println("Propietario editado correctamente");
                            } catch (InputMismatchException i) {
                                System.out.println("Ingresa un numero como opcion");
                                input.next();
                                bandera = true;
                            }
                        } while (bandera);
                        bandera = true;
                        break;
                        case 4:
                            System.out.println("Elige el numero del taxi que deseas borrar");
                            bandera = true;
                            do {
                                try {
                                    System.out.println(asociacion.listadoTaxis());
                                    opcion = input.nextInt();
                                    asociacion.eliminaTaxi(opcion);
                                    bandera = false;
                                } catch (InputMismatchException i) {
                                    System.out.println("Ingresa un numero como opcion");
                                    input.next();
                                    bandera = true;
                                }
                            } while (bandera);
                            bandera = true;
                            break;
                        default:
					        break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Guardando datos ...");
                    asociacion.guardaPropietarios();
                    asociacion.guardaChoferes();
                    asociacion.guardaTaxis();
                    bandera = false;
                    System.out.println("Datos guardados");
                    System.out.println("Saliendo del sistema...\n Hasta pronto.");
					break;
				default:
					break;
				    }
                
            }
        } while (bandera);
    }
}
