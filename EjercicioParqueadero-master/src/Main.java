import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Parqueadero parqueadero = new Parqueadero();

        String inPlaca;
        int opcion, puestoAsignado, valorCancelar, puestosLibres, nuevaTarifa;

        do{
            System.out.println("**** SISTEMA DE COBRO PARQUEADERO ****\n");
            System.out.println("1. Ingresar un carro");
            System.out.println("2. Dar salida a un carro");
            System.out.println("3. Informar los ingresos del parqueadero");
            System.out.println("4. Consultar la cantidad de puestos disponibles");
            System.out.println("5. Avanzar el reloj del parqueadero");
            System.out.println("6. Cambiar la tarifa del parqueadero");
            System.out.println("7. Vaciar parqueadero");
            System.out.println("8. SALIR");
            System.out.print("\nIngrese una opcion: ");
            opcion = Integer.parseInt(sc.next());
            switch (opcion) {
                case 1: {
                    System.out.println("Ingrese el numero de placa: ");
                    inPlaca = sc.next();
                    puestoAsignado = parqueadero.entrarCarro(inPlaca);
                    if(puestoAsignado == Parqueadero.NO_HAY_PUESTO){
                        System.out.println("El parqueadro esta lleno");
                    } else if (puestoAsignado == Parqueadero.PARQUEADERO_CERRADO) {
                        System.out.println("El parqueadero se encentra cerrado");
                    } else if (puestoAsignado == Parqueadero.CARRO_YA_EXISTE) {
                        System.out.println("Ya existe un vehiculo con la placa: " + inPlaca);
                    }else{
                        System.out.println("El carro con placa "+ inPlaca + " ingreso al puesto: # " +puestoAsignado);
                    }
                }
                break;

                case 2: {
                    System.out.println("Ingrese el numero de placa para sacar el vehiculo: ");
                    inPlaca = sc.next();
                    valorCancelar =  parqueadero.sacarCarro(inPlaca);

                    if(valorCancelar == Parqueadero.CARRO_NO_EXISTE){
                        System.out.println("El vehiculo con placas: "+inPlaca + " no existe");
                    }else{
                        System.out.println("Valor a cancelar: "+valorCancelar);
                    }
                }
                break;
                case 3: {
                    System.out.println("* Promedio de horas de carros estacionados: " + parqueadero.darTiempoPromedio() + " horas");
                    parqueadero.hayCarroMasDeOchoHoras();
                    System.out.println("* Carros con la misma placa: " + parqueadero.hayCarrosPlacaIgual());
                    System.out.println(parqueadero.metodo1());
                }
                break;
                case 4: {
                    puestosLibres = parqueadero.calcularPuestosLibres();
                    System.out.println("Existen " + puestosLibres + " lugares disponibles");
                }
                break;
                case 5:{
                    System.out.println("La hora actual es: "+ parqueadero.darHoraActual());
                    parqueadero.avanzarHora();
                    System.out.println("Se ha avanzado una hora, la hora es: "+ parqueadero.darHoraActual());
                }
                break;
                case 6: {
                    System.out.println("Tarifa actual: " + parqueadero.darTarifa());
                    System.out.println("Ingrese la nueva tarifa: ");
                    parqueadero.cambiarTarifa(nuevaTarifa = sc.nextInt());
                }
                break;
                case 7:{
                    System.out.println(parqueadero.metodo2());
                }
                default:
                    break;
            }

        }while (opcion!= 8);


    }
}