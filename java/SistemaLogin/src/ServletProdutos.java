

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
 * Servlet implementation class ServletProdutos
 */
@WebServlet("/produtos")
public class ServletProdutos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProdutos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tabela = null;
		
		
		//Iniciando a tabela
		tabela = "<table border='1'>" +
				"<tr><td>Nome</td></tr>";
		
		try {
			//Referenciar o driver JDBC
			Class.forName("com.mysql.jdbc.Driver");
			
			//Criar as strings de conexao
			String url = "jdbc:mysql://localhost/sistemalogin";
			String username = "root"; //nome do usuario no BD
			String password = ""; //senha do usuario no BD
			
			//Realizar a conexao ao BD
			Connection conexao = DriverManager.getConnection(url, username, password);

			//Preparar a consulta SQL
			PreparedStatement ps = conexao.prepareStatement("select nome, valor, fabricante from produto");

			//Executando a query e recebendo o ResultSet
			ResultSet rs = ps.executeQuery();
			
			//Percorrer o ResultSet
			while (rs.next()) {
				
				//Iniciando a linha
				tabela = tabela + "<tr>";
				//Pegando o nome
				tabela = tabela + "<td><a href='/SistemaLogin/produtoDetalhado?" + rs.getString("nome") + "'>" + rs.getString("nome") + "</a></td>";
				//Fechando a linha
				tabela = tabela + "</tr>";
			}
			
			//Finalizar a tabela html
			tabela = tabela + "</table>";

			//Fechar o ResultSet
			rs.close();
			//Fechar o PreparedStatement
			ps.close();
			//Fechar o Connnection
			conexao.close();
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//Retornar HTML para o cliente
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Lista de Produtos</title></head>");
		out.println("<body><h1>Lista de Produtos</h1>");
		out.println(tabela);
		out.println("</body></html>");
	}

}
