package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.Pessoa;

public class ListaPessoasDAO {
	
	private Connection conexao;
	
	public ListaPessoasDAO(Connection conexao){
		this.conexao = conexao;
	}
	
	public ArrayList<Pessoa> getListaPessoas(){
		ArrayList<Pessoa> listaPessoas = new ArrayList<Pessoa>();
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try{
			
			ps = conexao.prepareStatement("select id_pessoa, nome, endereco, uf from pessoa order by nome");
			
			rs = ps.executeQuery();
			
			while(rs.next()){
				listaPessoas.add(new Pessoa(rs.getInt("id_pessoa"), rs.getString("nome"), rs.getString("endereco"), rs.getString("uf")));
			}
			
			rs.close();
			ps.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return listaPessoas;
	}

}
