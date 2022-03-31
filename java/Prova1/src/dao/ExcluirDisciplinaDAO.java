package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ExcluirDisciplinaDAO {
	
	private Connection conexao;
	
	public ExcluirDisciplinaDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public boolean excluirDisciplina(String idDisciplina){
		
		PreparedStatement ps = null;
		boolean resultado = false;
		
		try{
			
			ps = conexao.prepareStatement("delete from disciplina where id_disciplina = ?");
			ps.setInt(1, Integer.parseInt(idDisciplina));
			
			ps.executeUpdate();
			ps.close();
			resultado = true;
			
			
		}catch (Exception e){
			e.printStackTrace();
		}
		
		return resultado;
		
	}

}
