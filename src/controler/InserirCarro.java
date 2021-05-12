
package controler;

import model.Carro;


public class InserirCarro {
    public InserirCarro(String placa, String marca, String modelo, int potenciaEmCavalos) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.potenciaEmCavalos = potenciaEmCavalos;
        this.InserirCarro();
    }

    private String placa;
    private String marca;
    private String modelo;
    private int potenciaEmCavalos;

    
    
    protected void InserirCarro(){
    
    Carro carro = new Carro();
    carro.setPlaca(this.placa);
    carro.setMarca(this.marca);
    carro.setModelo(this.modelo);
    carro.setPotenciaEmCavalos(this.potenciaEmCavalos);
    
    try {
                carro.inserirCarro();
                
            } catch (Exception e) {
                System.err.print("Erro: "+e);
            }
    }

    

}
