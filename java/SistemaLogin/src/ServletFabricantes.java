

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
 * Servlet implementation class ServletFabricantes
 */
@WebServlet("/fabricantes")
public class ServletFabricantes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFabricantes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tabela = "<table border='1'><tr><td>Fabricante</td></tr>";
		
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost/sistemalogin?verifyServerCertificate=false&useSSL=true";
			String username = "root"; //nome do usuario no BD
			String password = ""; //senha do usuario no BD
			
			Connection conexao = DriverManager.getConnection(url, username, password);
			
			PreparedStatement ps = conexao.prepareStatement("SELECT DISTINCT fabricante From produto");
			
			ResultSet rs = ps.executeQuery();

			
			while(rs.next()){
				
					
					tabela = tabela + "<tr>";

					tabela = tabela + "<td>" + rs.getString("fabricante") + "</td>";
		
					tabela = tabela + "</tr>";
					
			}
			
			tabela = tabela + "</table>";
			
			ps.close();
			rs.close();
			conexao.close();
		}catch(Exception e){
			
		}
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Fabricantes</title></head>");
		out.println("<body><h2>Fabricantes</h2>");
		out.println(tabela + "</body></html>");
	}

}
