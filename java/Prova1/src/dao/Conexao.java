package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	private static Connection conexao = null;
	
	public static Connection getConexao(){
		
		if(conexao == null){
			
			try{
				
				Class.forName("com.mysql.jdbc.Driver");
				
				//Criar as strings de conexao
				String url = "jdbc:mysql://localhost/faculdade";
				String username = "root"; //nome do usuario no BD
				String password = ""; //senha do usuario no BD
				
				//Realizar a conexao ao BD
				conexao = DriverManager.getConnection(url, username, password);
				
			
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
		//retortando o atributo estatico conexao
		return conexao;
	}

}
