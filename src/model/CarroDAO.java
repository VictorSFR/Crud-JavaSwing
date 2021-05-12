package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


public class CarroDAO extends DataBaseDAO{
    
    public void inserir(Carro c) throws Exception{
        String sqlQuery = "INSERT INTO carro (placa,marca,modelo,potenciaEmCavalos) VALUES(?,?,?,?)";
        this.connectar();
        
        PreparedStatement pstm = conn.prepareStatement(sqlQuery);
        pstm.setString(1, c.getPlaca());
        pstm.setString(2, c.getMarca());
        pstm.setString(3, c.getModelo());
        pstm.setInt(4, c.getPotenciaEmCavalos());
        
        pstm.execute();
        this.desconnectar();
    }
    
    public ArrayList<Carro> listarCarro() throws Exception{
        ArrayList<Carro> listaCarro = new ArrayList<Carro>();
        String sqlQuery = "SELECT * FROM carro";
        this.connectar();
        PreparedStatement pstm = conn.prepareStatement(sqlQuery);
        ResultSet rs = pstm.executeQuery();
        
        while (rs.next()) {
            
            Carro carro = new Carro();
            carro.setId(rs.getInt("id"));
            carro.setPlaca(rs.getString("placa"));
            carro.setMarca(rs.getString("marca"));
            carro.setModelo(rs.getString("modelo"));
            carro.setPotenciaEmCavalos(rs.getInt("potenciaEmCavalos"));
            
            listaCarro.add(carro);
            
        }
        this.desconnectar();
        return listaCarro;
    }
    
    
    
    
    
    public void alterarCarro(Carro carro) throws Exception{
        String sqlQuery = "UPDATE carro SET placa=?,marca=?,modelo=?,potenciaEmCavalos=? WHERE id=?";
        this.connectar();
        
        PreparedStatement pstm = conn.prepareStatement(sqlQuery);
        pstm.setString(1, carro.getPlaca());
        pstm.setString(2, carro.getMarca());
        pstm.setString(3, carro.getModelo());
        pstm.setInt(4, carro.getPotenciaEmCavalos());
        pstm.setInt(5, carro.getId());
        
        pstm.execute();
        this.desconnectar();
    }
    
    public void excluirCarro(String placa) throws Exception{
        
        String sqlQuery = "DELETE FROM carro WHERE placa=?";
        this.connectar();
        
        PreparedStatement pstm = conn.prepareStatement(sqlQuery);
        pstm.setString(1, placa);
        pstm.execute();
        this.desconnectar();
    }
    
    
    
}
