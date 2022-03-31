package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class IncluirItemDAO {
	
	private Connection conexao;
	
	public IncluirItemDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public boolean incluiItem(String idItem, String nome, String quantidade){
		PreparedStatement ps = null;
		boolean resultado = false;
		
		try{
			
			ps = conexao.prepareStatement("insert into itens_lista(id_lista, item, quantidade) values (?, ?, ?)");
			ps.setInt(1, Integer.parseInt(idItem));
			ps.setString(2, nome);
			ps.setDouble(3, Double.parseDouble(quantidade));
			
			ps.executeUpdate();
			ps.close();
			
			resultado = true;
			
			
		}catch(Exception e){
			
		}
		
		return resultado;
		
	}

}
