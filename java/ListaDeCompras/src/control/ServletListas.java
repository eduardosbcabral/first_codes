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
import dao.MostrarListaDAO;
import model.Lista;

/**
 * Servlet implementation class ServletListas
 */
@WebServlet("/listas")
public class ServletListas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletListas() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conexao = Conexao.getConexao();
		
		MostrarListaDAO mld = new MostrarListaDAO(conexao);
		
		ArrayList<Lista> lista = mld.getListas();
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Todas as listas</title></head><body>");
		out.println("<h1>Listas</h1><br>");
		out.println("<table border='1'><tr><td>Descrição</td></tr>");
		
		for(Lista listas : lista)
			out.println("<tr><td><a href='detalhaLista?idLista=" + listas.getId_lista() + "'>" + listas.getDescricao() + "</a></td></tr>");
		
		out.println("</table></body></html>");
		
	}

}
