package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Professor;

public class ListarProfessoresDAO {
	
	private Connection conexao;
	
	public ListarProfessoresDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Professor> getAllProfessores(){
		ArrayList<Professor> allProfessores = new ArrayList<Professor>();
		
		PreparedStatement ps = null;
		
		try{
			
			ps = conexao.prepareStatement("select id_professor, nome, datanasc, nomemae, titulacao from professor");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				allProfessores.add(new Professor(rs.getInt("id_professor"), rs.getString("nome"), rs.getString("datanasc"), rs.getString("nomemae"), rs.getInt("titulacao")));
			}
			
			ps.close();
			rs.close();
			
		}catch(Exception e){
			
		}
		
		return allProfessores;
	}

}
