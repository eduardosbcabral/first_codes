package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Carro;

public class ConsultarModeloDAO {
	//Atributos
	private Connection conexao;
	
	//Metodo construtor
	public ConsultarModeloDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	//Metodo que retorna um modelo de acordo com a marca
	public Carro consultarModelo(String marca){
		//Criar objeto de retorno
		Carro c = null;
		//Criar objetos de acesso a BD
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conexao.prepareStatement("SELECT idcarros, modelo, anofab, marca FROM carros where marca =?");
			ps.setString(1, marca);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getInt("idcarros"));
				c =  new Carro(rs.getInt("idcarros"), rs.getString("modelo"),rs.getString("anofab"), rs.getString("marca"));
			}
			
			rs.close();
			ps.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return c;
	}

	
	
	
	
	
	
	
	
	
}
