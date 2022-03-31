package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Pessoa;

public class LoginDAO {

	private Connection conexao;
	
	public LoginDAO (Connection conexao){
		this.conexao = conexao;
	}
	
	public Pessoa loginPessoa(String usuario, String senha){
		Pessoa p = null;
		
		PreparedStatement ps = null;
		
		try{
			
			ps = conexao.prepareStatement("select id_pessoa, nome_pessoa, endereco_pessoa, uf_pessoa from pessoa where nome_pessoa = ? and senha_pessoa = ?");
			ps.setString(1, usuario);
			ps.setString(2, senha);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()){
				p = new Pessoa(rs.getInt("id_pessoa"), rs.getString("nome_pessoa"), rs.getString("endereco_pessoa"), rs.getString("uf_pessoa"));
			}else{
				p = null;
			}
			
			ps.close();
			rs.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return p;
	}
	
}
