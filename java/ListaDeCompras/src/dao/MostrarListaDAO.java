package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Lista;

public class MostrarListaDAO {
	
	private Connection conexao;
	
	public MostrarListaDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Lista> getListas(){
		
		ArrayList<Lista> lista = new ArrayList<Lista>();
		
		PreparedStatement ps = null;
		
		try{
			
			ps = conexao.prepareStatement("select id_lista, descricao from lista");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				lista.add(new Lista(rs.getInt("id_lista"),rs.getString("descricao")));
			}
			
			ps.close();
			rs.close();
			
		}catch(Exception e){
			
		}
		
		return lista;
	}

}
