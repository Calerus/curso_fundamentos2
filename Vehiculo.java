import java.util.Date;
import java.util.*;
public class Vehiculo{
    static Vehiculo [][] arreglo_vehiculos;
    static int tamano;
    static int cantidad = 0;
    private String placa;
    private String marca;
    private String color;
    private int valorComercial;
    private String diferencia;
    Date fechaActual = new Date ();     
    public Vehiculo (){   
    } 
    
    public void dimension (int tam, int cantid){
        this.tamano = tam*cantid;
        this.arreglo_vehiculos = new Vehiculo [tam][cantid];
    }

    public Vehiculo (String placa, String marca, String color, int valor, String diferencia){
        this.placa = placa;
        this.marca = marca;
        this.color = color;
        this.valorComercial = valor;
        this.cantidad ++; 
        this.diferencia = diferencia;
    }
    
        public  Vehiculo (String placa, String marca, String color, String diferencia){
        this(placa, marca, color, 30000000, diferencia);
    }

    public String toString (){
     return 
            "Placa: "+ this.placa + "\n" + 
            "Marca: " + this.marca + "\n" +
            "Color: " + this.color + "\n" +
            "Valor Comercial: " + this.valorComercial + "\n" +
            "Fecha: " + fechaActual + "\n" +
            "Tipo de vehiculo: " + this.diferencia;
    }

    public static String toStringVehiculos (){
        String info = "\n";
        for(int i = 0; i<arreglo_vehiculos.length; i++){
          for (int j = 0; j<arreglo_vehiculos[0].length; j++){
            if (arreglo_vehiculos[i][j] != null){
             info = info + "\n" + arreglo_vehiculos[i][j].toString();
            }                             
          }
        }    
        return info;
    }
    
    public static String busquedaColor (String color){
        String cars = "\n";
        for(int i = 0; i<arreglo_vehiculos.length; i++){
          for (int j = 0; j<arreglo_vehiculos[0].length; j++){
            if (arreglo_vehiculos[i][j] != null){
                if (arreglo_vehiculos[i][j].getColor().equalsIgnoreCase(color)){
                cars = cars + "\n" + arreglo_vehiculos[i][j].toString();
              }
            }                             
          }
        }    
        if (cars == "\n"){
         cars = cars + "No existen carros de este color";  
        }
        return cars;
    }  
    
        
    public static String ordenVehiculo (){
     String info = "";
     int aux = 0;
     Vehiculo veh2[] = new Vehiculo [cantidad];
     for(int i = 0; i<arreglo_vehiculos.length; i++){
          for (int j = 0; j<arreglo_vehiculos[0].length; j++){
            if (arreglo_vehiculos[i][j] != null){
              veh2 [aux] = arreglo_vehiculos [i][j];
              aux++;
            }                             
          }
        } 
        vehiculoOrdenado(veh2);
        for(int i = 0; i<cantidad; i++){
           info = info + veh2[i].toString() + "\n";
        } 
        return info;
    }
    
    public static void vehiculoOrdenado (Vehiculo[]veh2){
     Vehiculo arreglo_aux[] = new Vehiculo[cantidad];
     for(int i = 0; i<cantidad; i++){
          for (int j = 0; j<cantidad -1; j++){
            if (veh2[j].getValorComercial() > veh2[j+1].getValorComercial()){
              arreglo_aux[j] = veh2 [j];
              veh2 [j] = veh2 [j+1];
              veh2 [j+1] = arreglo_aux[j];
            }                             
          }
        } 
    }
    
    public static int cantidadVehiculos (){
       return cantidad;
    }
    
    public int getTamano(){
        return this.tamano;
    }
    public int getCantidad(){
        return this.cantidad;
    }
    public String getPlaca(){
        return this.placa;
    }
    public String getDiferencia(){
        return this.diferencia;
    }
    public String getMarca(){
        return this.placa;
    }
    public String getColor(){
        return this.color;
    }
    public int getValorComercial(){
        return this.valorComercial;
    }
    public void setTamano(int tam){
        this.tamano = tam;
    }
    public void setDiferencia(String dife){
        this.diferencia = dife;
    }
    public void setCantidad (int cant){
        this.cantidad = cant;
    }
    public void setPlaca(String plac){
        this.placa = plac;
    }
    public void setMarca (String marc){
        this.marca = marc;
    }
    public void setColor (String col){
        this.color = col;
    }
    public void setValorComercial (int vacom){
        this.valorComercial = vacom; 
    }
}

