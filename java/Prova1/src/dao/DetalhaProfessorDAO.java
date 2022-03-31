package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Disciplina;
import model.Professor;

public class DetalhaProfessorDAO {
	
	private Connection conexao;
	
	public DetalhaProfessorDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public Professor getProfessor(String idProfessor){
		Professor p = null;
		
		PreparedStatement ps = null;
		
		try{
			
			ps = conexao.prepareStatement("select id_professor, nome, datanasc, nomemae, titulacao from professor where id_professor = ?");
			ps.setInt(1, Integer.parseInt(idProfessor));
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				p = new Professor(rs.getInt("id_professor"), rs.getString("nome"), rs.getString("datanasc"), rs.getString("nomemae"), rs.getInt("titulacao"));
			}
			
			ps.close();
			rs.close();
			
		}catch(Exception e){
			
		}
		
		return p;
	}
	
	public ArrayList<Disciplina> getDisciplina(String idProfessor){
		ArrayList<Disciplina> allDisciplinas = new ArrayList<Disciplina>();
				
		PreparedStatement ps = null;
		
		try{
			
			ps = conexao.prepareStatement("select id_disciplina, nome, curso, cargahoraria from disciplina where id_professor = ?");
			ps.setInt(1, Integer.parseInt(idProfessor));
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				allDisciplinas.add(new Disciplina(rs.getInt("id_disciplina"), rs.getString("nome"),rs.getString("curso"), rs.getString("cargahoraria")));
			}
			
			ps.close();
			rs.close();
			
		}catch(Exception e){
			
		}
		
		return allDisciplinas;
	}

}
