package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Item;

public class DetalhaListaDAO {
	
	private Connection conexao;
	
	public DetalhaListaDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Item> detalhaLista(String idLista){
		ArrayList<Item> getItens = new ArrayList<Item>();
		PreparedStatement ps = null;
		
		try{
			
			ps = conexao.prepareStatement("select id_item, item, quantidade from itens_lista where id_lista = ?");
			ps.setString(1, idLista);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				getItens.add(new Item(rs.getInt("id_item"), rs.getString("item"), rs.getDouble("quantidade")));
			}
			
			ps.close();
			rs.close();
			
		}catch(Exception e){
			
		}
		
		return getItens;
		
		
	}

}
