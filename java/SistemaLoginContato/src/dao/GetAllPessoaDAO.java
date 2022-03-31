package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.Pessoa;

public class GetAllPessoaDAO {
	
	private Connection conexao;
	
	public GetAllPessoaDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Pessoa> getAllPessoas(){
		ArrayList<Pessoa> getAll = new ArrayList<Pessoa>();
		
		PreparedStatement ps = null;
		
		try{
			
			ps = conexao.prepareStatement("select id_pessoa, nome_pessoa, endereco_pessoa, uf_pessoa from pessoa");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				getAll.add(new Pessoa(rs.getInt("id_pessoa"),rs.getString("nome_pessoa"),rs.getString("endereco_pessoa"),rs.getString("uf_pessoa")));
			}
			
			ps.close();
			rs.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return getAll;
	}

}
