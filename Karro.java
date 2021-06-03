public class Karro extends Vehiculo{
    public String diferencia;
    public Karro (String placa, String marca, String color, int valor, String diferencia){
        super(placa, marca, color, valor, "Carro");
        this.diferencia = "Carro";
    }
    public Karro (String placa, String marca, String color, String diferencia){
        super(placa, marca, color, "Carro");
        this.diferencia = "Carro";
    }
    public Karro (){
        
    }
    public String getDiferencia (){
        return this.diferencia;
    }
}