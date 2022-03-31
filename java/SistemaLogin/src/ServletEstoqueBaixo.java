

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEstoqueBaixo
 */
@WebServlet("/estoqueBaixo")
public class ServletEstoqueBaixo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEstoqueBaixo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String tabela = "<table border='1'><tr><td>Nome</td><td>Valor</td><td>Fabricante</td><td>Corredor</td><td>Quantidade</td><td>Promoção</td></tr>";
		
			try{
				Class.forName("com.mysql.jdbc.Driver");
				
				String url = "jdbc:mysql://localhost/sistemalogin?verifyServerCertificate=false&useSSL=true";
				String username = "root"; //nome do usuario no BD
				String password = ""; //senha do usuario no BD
				
				Connection conexao = DriverManager.getConnection(url, username, password);
				
				PreparedStatement ps = conexao.prepareStatement("SELECT id_produto, nome, valor, fabricante, corredor, quantidade, promocao From produto WHERE quantidade <= 10");
				
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()){
					tabela = tabela + "<tr>";
					tabela = tabela + "<td>" + rs.getString("nome") + "</td>";
					tabela = tabela + "<td>" + rs.getString("valor") + "</td>";
					tabela = tabela + "<td>" + rs.getString("fabricante") + "</td>";
					tabela = tabela + "<td>" + rs.getString("corredor") + "</td>";
					tabela = tabela + "<td>" + rs.getString("quantidade") + "</td>";
					
					if(rs.getBoolean(7))
						tabela = tabela + "<td>Sim</td>";
					else if(rs.getBoolean(7)==false)
						tabela = tabela + "<td>Não</td>";
					
					tabela = tabela + "</tr>";
				}
				
				tabela = tabela + "</table>";
				
				ps.close();
				rs.close();
				conexao.close();
			}catch(Exception e){
				
			}
			
			PrintWriter out = response.getWriter();
			out.println("<html><head><title>Estoque baixo</title></head>");
			out.println("<body><h2>Estoque baixo de produtos</h2>");
			out.println(tabela + "</body></html>");
		
	}

}
