package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Contato;
import model.Pessoa;

public class DetalhaPessoaDAO {
	
	private Connection conexao;
	
	public DetalhaPessoaDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public Pessoa getPessoa(String idPessoa){
		Pessoa p = null;
		
		PreparedStatement ps = null;
		
		try{
			
			ps = conexao.prepareStatement("select id_pessoa, nome_pessoa, endereco_pessoa, uf_pessoa from pessoa where id_pessoa = ?");
			ps.setString(1, idPessoa);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				p = new Pessoa(rs.getInt("id_pessoa"), rs.getString("nome_pessoa"), rs.getString("endereco_pessoa"), rs.getString("uf_pessoa"));
			}
			
			ps.close();
			rs.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return p;
	}
	
	
	
	public ArrayList<Contato> getContatosPessoa(int idPessoa){
		ArrayList<Contato> contatosPessoa = new ArrayList<Contato>();
		
		PreparedStatement ps = null;
		
		try{
			
			ps = conexao.prepareStatement("select id_contato, id_pessoa, tipo_contato, contato from contato where id_pessoa = ?");
			ps.setInt(1, idPessoa);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				contatosPessoa.add(new Contato(rs.getInt("id_contato"), rs.getInt("id_pessoa"), rs.getString("tipo_contato"), rs.getString("contato")));
			}
			
			rs.close();
			ps.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return contatosPessoa;
	}
	
	

}
