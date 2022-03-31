package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.GetAllPessoaDAO;
import model.Pessoa;

/**
 * Servlet implementation class ServletTodosUsuarios
 */
@WebServlet("/todosUsuarios")
public class ServletTodosUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletTodosUsuarios() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conexao = Conexao.getConexao();
		
		GetAllPessoaDAO galp = new GetAllPessoaDAO(conexao);
		
		ArrayList<Pessoa> allPessoas = galp.getAllPessoas();
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Todas as pessoas</title></head>");
		out.println("<body><h1>Todas as pessoas cadastradas</h1>");
		out.println("<br>");
		out.println("<table border='1'><tr><td>Nome</td><td>UF</td></tr>");
		
		for(Pessoa pessoa : allPessoas){
			out.println("<tr><td>" + pessoa.getNome() + "</td>>");
			out.println("<td>" + pessoa.getUf_pessoa() + "</td></tr>");
		}
		
		out.println("</body></html>");
		
		
	}

}
