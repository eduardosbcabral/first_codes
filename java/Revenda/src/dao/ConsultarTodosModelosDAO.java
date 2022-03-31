package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Carro;

public class ConsultarTodosModelosDAO {
	
	private Connection conexao;
	
	public ConsultarTodosModelosDAO(Connection conexao){
		this.conexao = conexao;
	}

	public ArrayList<Carro> getCarros (){
		ArrayList<Carro> carros = new ArrayList<Carro>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			
			ps = conexao.prepareStatement("select idcarros, modelo, anofab, marca from revenda.carros");
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				carros.add(new Carro(rs.getInt("idcarros"), rs.getString("modelo"), rs.getString("anofab"), rs.getString("marca")));
			}
			
			ps.close();
			rs.close();
			
		}catch(Exception e){
			
		}
		
		return carros;
	}
}
