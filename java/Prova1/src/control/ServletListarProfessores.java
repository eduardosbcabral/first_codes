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
import javax.swing.JOptionPane;

import dao.Conexao;
import dao.ListarProfessoresDAO;
import model.Professor;

/**
 * Servlet implementation class ServletListarProfessores
 */
@WebServlet("/listarProfessores")
public class ServletListarProfessores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListarProfessores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conexao = Conexao.getConexao();
		
		ListarProfessoresDAO lpd = new ListarProfessoresDAO(conexao);
		
		ArrayList<Professor> getAllProfessores = lpd.getAllProfessores();
		
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Listar todos professores</title></head>");
		out.println("<body><h1>Lista de professores</h1><table border='1'>");
		out.println("<tr><td>Nome</td></tr>");
		
		for(Professor p : getAllProfessores)
			out.println("<tr><td><a href='exibirProfessor?idprofessor=" + p.getId_professor() + "'>" + p.getNome() + "</a></td></tr>");
		
		out.println("</table><br><br>");
		out.println("<h3>Pesquisar professor por titulação (Não colocar acento)</h3><br>");
		out.println("<form action='consultarPorTitulacao'>");
		out.println("Titulação: <input type='text' name='titulacao'><br>");
		out.println("<input type='submit' value='Pesquisar'>");
		out.println("</form>");
		
		out.println("<br><br>");
		out.println("<h3>Pesquisar professores que ministrem disciplinas para o Curso de Ciência da Computação</h3><br>");
		out.println("<form action='consultarApenasComputacao'>");
		out.println("<input type='submit' value='Pesquisar'>");
		out.println("</form>");
		
		out.println("</body></html>");
	}

}
