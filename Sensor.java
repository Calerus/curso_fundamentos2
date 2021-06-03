
import java.util.*;

public class Sensor{
   static Sensor [][] arreglo_sensor;
   private int estado;
   
   public Sensor (){
   }
   
   public void dimension (int tamano, int cantidad){
       this.arreglo_sensor = new Sensor [tamano][cantidad];
   }
   
   public Sensor (int e){
       this.estado = e;
   }
   
   public String toString (){
      String flag = "" ;
       if (this.estado == 1){
       flag = "ocupado";
      }
      else if (this.estado == 0){
       flag = "libre";
      }
      return flag;
   }
   
   public ArrayList<String> sensorLibres (){
        ArrayList<String> disponibles = new ArrayList(); 
       for(int i = 0; i<arreglo_sensor.length; i++){
          for (int j = 0; j<arreglo_sensor[0].length; j++){
            if (arreglo_sensor[i][j] == null){
                disponibles.add("("+i+","+j+")");
            }
          }
        }  
       return disponibles; 
   }
   public boolean validarDisponibilidad (int piso, int espacio){
     boolean disponible = true; 
     if (arreglo_sensor[piso][espacio] != null)
        disponible = false;
     return disponible; 
    }
      
   public ArrayList<String> sensoresEstado (){
      ArrayList<String> infoSensores = new ArrayList(); 
      for(int i = 0; i<arreglo_sensor.length; i++){
        for (int j = 0; j<arreglo_sensor[0].length; j++){
            if (arreglo_sensor[i][j]!=null){
            infoSensores.add("Piso: "+i+"\n"+"Fila: "+j+"\n"+"Estado: "+ String.valueOf(arreglo_sensor[i][j].estado));
          }
        }
      }  
      return infoSensores;  
   }
   
   public String validacion (int piso, int espacio){
      String validacion = ""; 
       if(piso>=arreglo_sensor.length||piso<0){
           validacion = "El piso no existe, por favor ingrese un piso valido.";
           if(espacio>=arreglo_sensor[0].length||espacio<0){
             validacion = validacion + "\n" + "El espacio no existe, por favor ingrese un espacio valido.";
            }
       }
      return validacion;
   }
   public int getEstado(){
        return this.estado;
    }
   public void setEstado (int estate){
        this.estado = estate;
   }
}   
