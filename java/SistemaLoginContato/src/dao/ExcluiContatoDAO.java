package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;


public class ExcluiContatoDAO {

	private Connection conexao;
	
	public ExcluiContatoDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public boolean excluirContato(String idContato){
		
		PreparedStatement ps = null;
		boolean excluir = false;
		
		try{
			ps = conexao.prepareStatement("delete from contato where id_contato = ?");
			ps.setInt(1, Integer.parseInt(idContato));
			
			ps.executeUpdate();
			
			ps.close();
			
			excluir = true;
			
			
		}catch(Exception e){
			
		}
		
		return excluir;
		
	}
	
}
