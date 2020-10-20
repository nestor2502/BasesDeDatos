package src;

import src.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PruebaAsociacion {
	public static void main(String[] args) {
		boolean bandera;
		int opcion = 0;
		Scanner input = new Scanner(System.in);
		Asociacion asociacion = new Asociacion();
		do {
			bandera = true;
            System.out.println("Selecciona una categoría.\n" + "1- Dueños\n" + 
            "2- Chóferes\n" + "3- Taxis\n" + "4- Salir\n" );
			try {
				opcion = input.nextInt();
			} catch (InputMismatchException e) {
				input.next();
				System.out.println("Ingresa un número como opción");
			}
			if (opcion > 0 && opcion < 5) {
				switch (opcion) {
				case 1:
                    System.out.println("Selecciona una acción.\n" + "1- Agregar\n" + 
                    "2- Consultar\n" + "3- Modificar\n" + "4- Eliminar\n" );
                    try {
                        opcion = input.nextInt();
                    } catch (InputMismatchException e) {
                        input.next();
                        System.out.println("Ingresa un número como opción");
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
                                    System.out.println("Ingresa un número como opción");
                                    input.next();
                                    bandera = true;
                                }
                            } while (bandera);
                            bandera = true;
                            break;
                        case 4:
                            System.out.println("Elige el número del propietario que deseas borrar");
                            bandera = true;
                            do {
                                try {
                                    System.out.println(asociacion.listadoPropietarios());
                                    opcion = input.nextInt();
                                    asociacion.eliminaPropietario(opcion);
                                    bandera = false;
                                } catch (InputMismatchException i) {
                                    System.out.println("Ingresa un número como opción");
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
					System.out.println("Selecciona una acción.\n" + "1- Agregar\n" + 
                    "2- Consultar\n" + "3- Modificar\n" + "4- Eliminar\n" );
                    try {
                        opcion = input.nextInt();
                    } catch (InputMismatchException e) {
                        input.next();
                        System.out.println("Ingresa un número como opción");
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
                            System.out.println("Elige el número del chófer que deseas editar");
                            bandera = true;
                            do {
                                try {
                                    System.out.println(asociacion.listadoChoferes());
                                    opcion = input.nextInt();
                                    asociacion.getChofer(opcion).edita();
                                    bandera = false;
                                    System.out.println("Chófer editado correctamente");
                                } catch (InputMismatchException i) {
                                    System.out.println("Ingresa un número como opción");
                                    input.next();
                                    bandera = true;
                                }
                            } while (bandera);
                            bandera = true;
                            break;

                        case 4:
                            System.out.println("Elige el número del chófer que deseas borrar");
                            bandera = true;
                            do {
                                try {
                                    System.out.println(asociacion.listadoChoferes());
                                    opcion = input.nextInt();
                                    asociacion.eliminaChofer(opcion);
                                    bandera = false;
                                } catch (InputMismatchException i) {
                                    System.out.println("Ingresa un número como opción");
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
                    System.out.println("Selecciona una acción.\n" + "1- Agregar\n" + 
                    "2- Consultar\n" + "3- Modificar\n" + "4- Eliminar\n" );
                    try {
                        opcion = input.nextInt();
                    } catch (InputMismatchException e) {
                        input.next();
                        System.out.println("Ingresa un número como opción");
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
                        System.out.println("Elige el número del taxi que deseas editar");
                        bandera = true;
                        do {
                            try {
                                System.out.println(asociacion.listadoTaxis());
                                opcion = input.nextInt();
                                asociacion.getTaxi(opcion).edita();
                                bandera = false;
                                System.out.println("Propietario editado correctamente");
                            } catch (InputMismatchException i) {
                                System.out.println("Ingresa un número como opción");
                                input.next();
                                bandera = true;
                            }
                        } while (bandera);
                        bandera = true;
                        break;
                        case 4:
                            System.out.println("Elige el número del taxi que deseas borrar");
                            bandera = true;
                            do {
                                try {
                                    System.out.println(asociacion.listadoTaxis());
                                    opcion = input.nextInt();
                                    asociacion.eliminaTaxi(opcion);
                                    bandera = false;
                                } catch (InputMismatchException i) {
                                    System.out.println("Ingresa un número como opción");
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
