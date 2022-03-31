package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Professor;

public class PesquisarProfessoresDAO {
	
	private Connection conexao;
	
	public PesquisarProfessoresDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Professor> pesquisarPorTitulacao(String titulacao){
		PreparedStatement ps = null;
		ArrayList<Professor> porTitulacao = new ArrayList<Professor>();
		
		int idTitulacao = 0;
		
		if(titulacao.equals("Especializacao") || titulacao.equals("especializacao"))
			idTitulacao = 1;
		else if(titulacao.equals("Mestrado") || titulacao.equals("mestrado"))
			idTitulacao = 2;
		else if(titulacao.equals("Doutorado") || titulacao.equals("doutorado"))
			idTitulacao = 3;
		try{
			
			ps = conexao.prepareStatement("select id_professor, nome, datanasc, nomemae, titulacao from professor where titulacao = ?");
			ps.setInt(1, idTitulacao);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				porTitulacao.add(new Professor(rs.getInt("id_professor"), rs.getString("nome"), rs.getString("datanasc"), rs.getString("nomemae"), rs.getInt("titulacao")));
			}
			
			ps.close();
			rs.close();
		}catch(Exception e){
			
		}
		
		return porTitulacao;
		
	}
	
	public ArrayList<Professor> pesquisarPorCurso(String curso){
		PreparedStatement ps = null;
		

		ArrayList<Professor> porCurso = new ArrayList<Professor>();
		
		try{
			
			ps = conexao.prepareStatement("select professor.id_professor, professor.nome, professor.datanasc, professor.nomemae, professor.titulacao from disciplina inner join professor on (disciplina.id_professor = professor.id_professor) where disciplina.curso = ?");
			ps.setString(1, curso);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				porCurso.add(new Professor(rs.getInt("id_professor"), rs.getString("nome"), rs.getString("datanasc"), rs.getString("nomemae"), rs.getInt("titulacao")));
			}
			
			ps.close();
			rs.close();
			
		}catch(Exception e){
			
		}
		
		return porCurso;
	}
	

}
