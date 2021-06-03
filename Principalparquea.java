import java.io.File;
import java.text.BreakIterator;
import java.io.FileWriter;
import java.io.Writer;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.*;
public class Principalparquea{
   public static void main (String[]args){
       Scanner scannpe = new Scanner (System.in);
       
       System.out.println ("Ingrese la cantidad de pisos:");
       int pisos = scannpe.nextInt();
       System.out.println ("Ingrese la cantidad de espacios");
       int espacios = scannpe.nextInt();
       Vehiculo parqueadero = new Vehiculo ();
       parqueadero.dimension (pisos, espacios);
       Sensor sensores = new Sensor ();
       sensores.dimension (pisos, espacios);
       boolean preguntar = true;
               
        do{
            System.out.println ("\nQue opcion desea ingresar:" + "\n" +
           "0. Salir." + "\n" + 
           "1. Consultar sensores desocupados." + "\n" + 
           "2. Asignar el parqueadero a un vehiculo sin valor." + "\n" + 
           "3. Asignar el parqueadero a un vehiculo con valor." + "\n" + 
           "4. Consultar la informacion de todos los vehiculos." + "\n" + 
           "5. Consultar la cantidad de vehiculos." + "\n" + 
           "6. Consultar el estado de un parqueadero." + "\n" + 
           "7. Consultar el estado de todos los parqueaderos." + "\n" +
           "8. Consultar vehiculo por color." + "\n" + 
           "9. Ordenar vehiculos por valor comercial." + "\n" +
           "10. Retirar vehiculo." + "\n" +
           "11. Modificar txt.");
            int opcion = scannpe.nextInt();
            
            switch (String.valueOf(opcion)){
                case "0": 
                    System.out.println ("Saliendo...") ;
                    preguntar = false;
                    break;
                    
                case "1": 
                    System.out.println(sensores.sensorLibres());
                    break;
                    
                case "2": 
                    boolean validacion = false;
                    int piso = 0;
                    int espacio = 0;
                    String placa, marca, color;
                       
                    
                                          
                    do{
                        
                        System.out.println("En que piso desea parquear: ");
                        piso = scannpe.nextInt();
                        System.out.println("En que espacio del piso desea parquear: ");
                        espacio = scannpe.nextInt();
                        System.out.println(sensores.validacion (piso, espacio));
                        
                        if (sensores.validacion (piso, espacio) == ""){
                            if(sensores.validarDisponibilidad(piso, espacio)){
                                validacion = true;
                            }else{
                                System.out.println("Parqueadero ocupado");
                            }   
                        }
                    }while (!validacion);
                
                System.out.println ("Que tipo de vehiculo desea parquear");
                scannpe.nextLine();
                String diferencia = scannpe.next();
                
                if(diferencia.equalsIgnoreCase("Carro")){
                    if (sensores.validarDisponibilidad(piso, espacio)){
                            System.out.println("Ingrese la placa");
                            scannpe.nextLine();
                            placa = scannpe.nextLine();
                            System.out.println("Ingrese la marca");
                            marca = scannpe.nextLine ();
                            System.out.println("Ingrese el color");
                            color = scannpe.nextLine ();
                            
                            
                            
                            Karro carro = new Karro (diferencia, placa, marca, color);
                            Sensor sensor = new Sensor(1);
                            
                            parqueadero.arreglo_vehiculos[piso][espacio] = carro;                       
                            sensores.arreglo_sensor[piso][espacio] = sensor;
                            
                            System.out.println(carro.toString());
                            System.out.println(sensor.getEstado());
                            
                 }
                } else if(diferencia.equalsIgnoreCase("Moto")){
                    if (sensores.validarDisponibilidad(piso, espacio)){
                            System.out.println("Ingrese la placa");
                            scannpe.nextLine();
                            placa = scannpe.nextLine();
                            System.out.println("Ingrese la marca");
                            marca = scannpe.nextLine ();
                            System.out.println("Ingrese el color");
                            color = scannpe.nextLine ();
                            
                            
                            
                            Moto motos = new Moto (diferencia, placa, marca, color);
                            Sensor sensor = new Sensor(1);
                            
                            parqueadero.arreglo_vehiculos[piso][espacio] = motos;                       
                            sensores.arreglo_sensor[piso][espacio] = sensor;
                            
                            System.out.println(motos.toString());
                            System.out.println(sensor.getEstado());
                            
                 }
                }       
                    
                    break;
                    
                case "3": 
                 boolean validacion1 = false;
                    int piso1 = 0;
                    int espacio1 = 0;
                    int valor;
                    String placas, marcas, colors;
                    
                    do{
                        System.out.println("En que piso desea parquear: ");
                        piso1 = scannpe.nextInt();
                        System.out.println("En que espacio del piso desea parquear: ");
                        espacio1 = scannpe.nextInt();
                        System.out.println(sensores.validacion (piso1, espacio1));
                        
                        if (sensores.validacion (piso1, espacio1) == ""){
                            if(sensores.validarDisponibilidad(piso1, espacio1)){
                                validacion1 = true;
                            }else{
                                System.out.println("Parqueadero ocupado");
                            }   
                        }
                    }while (!validacion1);
                    
                System.out.println ("Que tipo de vehiculo desea parquear");
                String diferencias = scannpe.next();
                
                if(diferencias.equalsIgnoreCase("Carro")){
                    if (sensores.validarDisponibilidad(pisos, espacios)){
                            System.out.println("Ingrese la placa");
                            scannpe.nextLine();
                            placas = scannpe.nextLine();
                            System.out.println("Ingrese la marca");
                            marcas = scannpe.nextLine ();
                            System.out.println("Ingrese el color");
                            colors = scannpe.nextLine ();
                            System.out.println ("Ingrese el valor");
                            valor = scannpe.nextInt();
                            
                            Karro carros = new Karro (placas, marcas, colors, valor, diferencias);
                            Sensor sensor = new Sensor(1);
                            
                            parqueadero.arreglo_vehiculos[pisos][espacios] = carros;                       
                            sensores.arreglo_sensor[pisos][espacios] = sensor;
                            
                            System.out.println(carros.toString());
                            System.out.println(sensor.getEstado());
                            
                 }
                } else if(diferencias.equalsIgnoreCase("Moto")){
                    if (sensores.validarDisponibilidad(pisos, espacios)){
                            System.out.println("Ingrese la placa");
                            scannpe.nextLine();
                            placas = scannpe.nextLine();
                            System.out.println("Ingrese la marca");
                            marcas = scannpe.nextLine ();
                            System.out.println("Ingrese el color");
                            colors = scannpe.nextLine ();
                            System.out.println ("Ingrese el valor");
                            valor = scannpe.nextInt(); 
                            
                            
                            Moto motosd = new Moto (placas, marcas, colors, valor, diferencias);
                            Sensor sensor = new Sensor(1);
                            
                            parqueadero.arreglo_vehiculos[pisos][espacios] = motosd;                       
                            sensores.arreglo_sensor[pisos][espacios] = sensor;
                            
                            System.out.println(motosd.toString());
                            System.out.println(sensor.getEstado());
                            
                 }
                }       

                    break;
                    
                    
                case "4": 
                    
                    System.out.println (parqueadero.toStringVehiculos());
                    
                    break;
                    
                case "5": 
                    
                    System.out.println ("La cantidad de vehiculos es:" + parqueadero.cantidadVehiculos());
                
                    break;
                    
                case "6": 
                    boolean validacion2 = false;
                    do{
                        System.out.println("En que piso desea mostrar el estado: ");
                        piso = scannpe.nextInt();
                        System.out.println("En que espacio del piso desea mostrar el estado: ");
                        espacio = scannpe.nextInt();
                        System.out.println(sensores.validacion (piso, espacio));
                        
                        if (sensores.validacion (piso, espacio) == ""){
                            validacion2 = true;
                        }
                    }while (!validacion2);
                        if (sensores.arreglo_sensor[piso][espacio]!=null){
                      System.out.println ("El estado del sensor es: " + sensores.arreglo_sensor[piso][espacio].toString());
                    }else{
                        System.out.println ("El estado del sensor es disponible");
                    if (sensores.validacion (piso, espacio) == ""){
                            if(sensores.validarDisponibilidad(piso, espacio)){
                                validacion = true;
                            }else{
                                System.out.println("Parqueadero ocupado");
                            }   
                        }}
                    break;
                    
                case "7": 
                    
                    System.out.println (sensores.sensoresEstado());
                
                    break;
                case "8":
                    String color2;
                    System.out.println ("Ingrese el color del Carro");
                    scannpe.nextLine ();
                    color2 = scannpe.nextLine ();
                    System.out.println (parqueadero.busquedaColor(color2));
                
                break;
                    
                case "9":
                    System.out.println (parqueadero.ordenVehiculo());
                    
                    break;
                    
                case "10":
                    System.out.println("Donde esta el vehiculo a retirar? ingrese piso");
                    piso = scannpe.nextInt();
                    System.out.println("Ingrese espacio");
                    espacio = scannpe.nextInt();
                    if(parqueadero.arreglo_vehiculos[piso][espacio] != null){
                        parqueadero.arreglo_vehiculos[piso][espacio] = null;
                        sensores.arreglo_sensor[piso][espacio].setEstado(0);
                        System.out.println("Su vehiculo ha sido retirado con exito");
                    }else{
                        System.out.println("No hay vehiculo a retirar");
                    }
                    break;
                   
                
                    
                default: System.out.println ("Comando incorrecto"); 
                    break;
         }
        }while(preguntar);             

      }
}