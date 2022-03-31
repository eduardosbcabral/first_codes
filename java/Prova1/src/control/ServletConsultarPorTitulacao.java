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
 * Servlet implementation class ServletConsularPorTitulacao
 */
@WebServlet(name = "ServletConsultarPorTitulacao", urlPatterns = { "/consultarPorTitulacao" })
public class ServletConsultarPorTitulacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConsultarPorTitulacao() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String titulacao = request.getParameter("titulacao");
		
		Connection conexao = Conexao.getConexao();
		
		PesquisarProfessoresDAO ppd = new PesquisarProfessoresDAO(conexao);
		
		ArrayList<Professor> porTitulacao = ppd.pesquisarPorTitulacao(titulacao);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Listar professor por titulação</title></head>");
		

		
		if(titulacao.equals("Especializacao") || titulacao.equals("especializacao")){

			out.println("<body><h1>Lista de professores que tem especialização</h1><table border='1'>");
			out.println("<tr><td>Nome</td><td>Titulação><tr>");
			
			for(Professor p : porTitulacao)
				out.println("<tr><td><a href='exibirProfessor?idprofessor=" + p.getId_professor() + "'>" + p.getNome() + "</a></td><td>Especialização</td></tr>");
			
		}
		else if(titulacao.equals("Mestrado") || titulacao.equals("mestrado")){
			out.println("<body><h1>Lista de professores que tem mestrado</h1><table border='1'>");
			out.println("<tr><td>Nome</td><td>Titulação><tr>");
			
			for(Professor p : porTitulacao)
				out.println("<tr><td><a href='exibirProfessor?idprofessor=" + p.getId_professor() + "'>" + p.getNome() + "</a></td><td>Mestrado</td></tr>");
			
		}else if(titulacao.equals("Doutorado") || titulacao.equals("doutorado")){
			out.println("<body><h1>Lista de professores que tem doutorado</h1><table border='1'>");
			out.println("<tr><td>Nome</td><td>Titulação><tr>");
			
			for(Professor p : porTitulacao)
				out.println("<tr><td><a href='exibirProfessor?idprofessor=" + p.getId_professor() + "'>" + p.getNome() + "</a></td><td>Doutorado</td></tr>");
		}else
			out.println("<body><h1>Erro ao pesquisar</h1>");
		
		out.println("</table></body></html>");
	}

}
