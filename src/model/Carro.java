package model;

import java.util.ArrayList;

public class Carro implements Comparable<Carro> {
	
	private Integer id;
	private String placa;
	private String marca;
	private String modelo;
	private Integer potenciaEmCavalos;
	
	public Carro(String modelo, int potencia) {
		this.setModelo(modelo);
		this.setPotenciaEmCavalos(potencia);
	}
	public Carro() {
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public Integer getPotenciaEmCavalos() {
		return potenciaEmCavalos;
	}
	public void setPotenciaEmCavalos(Integer potenciaEmCavalos) {
		this.potenciaEmCavalos = potenciaEmCavalos;
	}
        
        public void inserirCarro() throws Exception{
        CarroDAO carroDAO = new CarroDAO();
        carroDAO.inserir(this);
        }
        
        public void alterarCarro() throws Exception{
        CarroDAO carroDAO = new CarroDAO();
        carroDAO.alterarCarro(this);
        
        }
        
        public void excluirCarro() throws Exception{
        CarroDAO carroDAO = new CarroDAO();
        carroDAO.excluirCarro(this.placa);
        
        }
        
        public ArrayList<Carro> listarCarro() throws Exception{
        CarroDAO carroDAO = new CarroDAO();
        return carroDAO.listarCarro();
    }
        
        
	@Override
	public int compareTo(Carro outroCarro) {
		if (outroCarro == null || outroCarro.getPotenciaEmCavalos() == null) {
			return 1;
		} else if (this.getPotenciaEmCavalos() == null) {
			return -1;
		} else {
			return this.getPotenciaEmCavalos().compareTo(outroCarro.getPotenciaEmCavalos());
		}
	}
	@Override
	public String toString() {
		return "Carro [modelo=" + modelo + ", potenciaEmCavalos=" + potenciaEmCavalos + "]";
	}
        
        

}
