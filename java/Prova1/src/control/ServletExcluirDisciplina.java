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
import dao.ExcluirDisciplinaDAO;

/**
 * Servlet implementation class ServletExcluirDisciplina
 */
@WebServlet("/excluirDisciplina")
public class ServletExcluirDisciplina extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirDisciplina() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idDisciplina = request.getParameter("iddisciplina");
		
		Connection conexao = Conexao.getConexao();
		
		ExcluirDisciplinaDAO edd = new ExcluirDisciplinaDAO(conexao);
		
		boolean resultado = edd.excluirDisciplina(idDisciplina);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Exclusão de disciplina</title></head>");
		out.println("<body>");
		
		if(resultado)
			out.println("<h1>DISCIPLINA EXCLUÍDA COM SUCESSO</h1>");
		else
			out.println("<h1>ERRO AO EXCLUIR DISCIPLINA</h1>");
		
		out.println("</body></html>");
		
	}

}
