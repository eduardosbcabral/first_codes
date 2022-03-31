package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ExcluirItemDAO {

	private Connection conexao;
	
	public ExcluirItemDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public boolean excluirItem(String idItem){
		PreparedStatement ps = null;
		boolean resultado = false;
		
		try{
			
			ps = conexao.prepareStatement("delete from itens_lista where id_item = ?");
			ps.setInt(1, Integer.parseInt(idItem));
			
			ps.executeUpdate();
			ps.close();
			resultado = true;
			
		}catch(Exception e){
			
		}
		
		return resultado;
		
	}
	
}
