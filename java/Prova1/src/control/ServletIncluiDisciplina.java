package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.IncluirDisciplinaDAO;

/**
 * Servlet implementation class ServletIncluiDisciplina
 */
@WebServlet(name = "ServletIncluirDisciplina", urlPatterns = { "/incluirDisciplina" })
public class ServletIncluiDisciplina extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletIncluiDisciplina() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idProfessor = request.getParameter("idprofessor");
		String nomeDisciplina = request.getParameter("nomedisciplina");
		String nomeCurso = request.getParameter("nomecurso");
		String cargahoraria = request.getParameter("cargahoraria");
		
		Connection conexao = Conexao.getConexao();
		
		IncluirDisciplinaDAO idd = new IncluirDisciplinaDAO(conexao);
		
		boolean resultado = idd.incluirDisciplina(idProfessor, nomeDisciplina, nomeCurso, cargahoraria);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Inclusão de disciplina</title></head>");
		out.println("<body>");
		
		if(resultado)
			out.println("<h1>DISCIPLINA INCLÚIDA COM SUCESSO</h1>");
		else
			out.println("<h1>ERRO AO INCLUIR DISCIPLINA</h1>");
		
		out.println("</body></html>");
		
	}

}
