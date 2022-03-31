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
import dao.PesquisarProfessoresDAO;
import model.Professor;

/**
 * Servlet implementation class ServletConsultarPorComputacao
 */
@WebServlet("/consultarApenasComputacao")
public class ServletConsultarPorComputacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConsultarPorComputacao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conexao = Conexao.getConexao();
		
		PesquisarProfessoresDAO ppd = new PesquisarProfessoresDAO(conexao);
		
		ArrayList<Professor> professores = ppd.pesquisarPorCurso("Ciência da Computação");		

		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Listar professor pelo curso de Ciência da Computação</title></head>");
		out.println("<body><h2>Professores</h2><br><table border='1'>");
		out.println("<tr><td>Nome</td></tr>");
		
		for(Professor p : professores)
			out.println("<tr><td>" + p.getNome() + "</td></tr>");
		
		out.println("</table></body></html>");
		
	}

}
