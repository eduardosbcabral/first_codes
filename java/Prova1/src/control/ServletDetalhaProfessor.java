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
import dao.DetalhaProfessorDAO;
import model.Disciplina;
import model.Professor;

/**
 * Servlet implementation class ServletDetalhaProfessor
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/exibirProfessor" })
public class ServletDetalhaProfessor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetalhaProfessor() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idProfessor = request.getParameter("idprofessor");
		
		Connection conexao = Conexao.getConexao();
		
		DetalhaProfessorDAO dpd = new DetalhaProfessorDAO(conexao);
		
		Professor p = dpd.getProfessor(idProfessor);
		
		ArrayList<Disciplina> allDisciplinas = dpd.getDisciplina(idProfessor);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>" + p.getNome() + "</title></head>");
		out.println("<body><h1>" + p.getNome() + "</h1><table border='1'>");
		out.println("<tr><td>Data de nascimento</td><td>Nome da mãe</td><td>Titulação</td>></tr>");
		out.println("<tr><td>" + p.getData_nasc() + "</td><td>" + p.getNome_mae() + "</td>");
		
		if(p.getIntitulacao()==1)
			out.println("<td>Especialização</td></tr>");
		else if(p.getIntitulacao()==2)
			out.println("<td>Mestrado</td></tr>");
		else if(p.getIntitulacao()==3)
			out.println("<td>Doutorado</td></tr>");

		out.println("</table>");
		out.println("<br>");
		out.println("<h2>Disciplinas</h2>");
		out.println("<br>");
		out.println("<table border='1'>");
		out.println("<tr><td>Nome</td><td>Curso</td><td>Carga Horária</td><td>Exclusão</td></tr>");
		
		for(Disciplina d : allDisciplinas){
			out.println("<tr><td>" + d.getNome() + "</td><td>" + d.getCurso() + "</td><td>" + d.getCarga_horaria() + "</td>");
			out.println("<td><form action='excluirDisciplina'><input type='hidden' name='iddisciplina' value=" + d.getId_disciplina() + ">");
			out.println("<input type='submit' value='Excluir'></form></td></tr>");
		}
			
		out.println("</table>");
		
		out.println("<br>");
		out.println("<h3>Adicionar nova disciplina</h3>");
		out.println("<form action='incluirDisciplina'>");
		out.println("<input type='hidden' name='idprofessor' value='" + idProfessor + "'>");
		out.println("Nome da disciplina: <input type='text' name='nomedisciplina'><br>");
		out.println("Nome do curso: <input type='text' name='nomecurso'><br>");
		out.println("Carga horária: <input type='text' name='cargahoraria'><br>");
		out.println("<input type='submit' value='Incluir'>");
		out.println("</form>");
		
		out.println("</body></html>");
	}

}
