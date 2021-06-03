public class Moto extends Vehiculo{
    public String diferencia;
    public Moto (String placa, String marca, String color, int valor, String diferencia){
        super(placa, marca, color, valor, "Moto");
        this.diferencia = "Moto";
    }
    public Moto (String placa, String marca, String color, String diferencia){
        super(placa, marca, color, "Moto");
        this.diferencia = "Moto";
    }
    public Moto (){
        
    }
    public String getDiferencia (){
        return this.diferencia;
    }
}