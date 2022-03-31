package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class IncluirDisciplinaDAO {
	
	private Connection conexao;
	
	public IncluirDisciplinaDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public boolean incluirDisciplina(String idProfessor, String nomeDisciplina, String nomeCurso, String cargaHoraria){
		PreparedStatement ps = null;
	
		boolean resultado = false;
		
		try{
			
			ps = conexao.prepareStatement("insert into disciplina (id_professor, nome, curso, cargahoraria) values (?,?,?,?)");
			ps.setInt(1, Integer.parseInt(idProfessor));
			ps.setString(2, nomeDisciplina);
			ps.setString(3, nomeCurso);
			ps.setInt(4, Integer.parseInt(cargaHoraria));
			
			ps.executeUpdate();
			ps.close();
			resultado = true;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return resultado;
		
	}

}
