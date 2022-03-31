package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	
	public static Connection conexao = null;
	
	public static Connection getConexao(){
		
		if(conexao == null){
			
			try{
				
				Class.forName("com.mysql.jdbc.Driver");
				
				String url = "jdbc:mysql://localhost/pessoas";
				String usuario = "root";
				String senha = "root";
				
				conexao = DriverManager.getConnection(url, usuario, senha);
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		
		return conexao;
	}

}
