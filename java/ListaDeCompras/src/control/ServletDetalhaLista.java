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
import dao.DetalhaListaDAO;
import model.Item;

/**
 * Servlet implementation class ServletDetalhaLista
 */
@WebServlet("/detalhaLista")
public class ServletDetalhaLista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDetalhaLista() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idLista = request.getParameter("idLista");
		
		Connection conexao = Conexao.getConexao();
		
		DetalhaListaDAO dld = new DetalhaListaDAO(conexao);
		
		ArrayList<Item> i = dld.detalhaLista(idLista);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Detalha Lista</title></head>");
		out.println("<body><h1>Itens da lista</h1>");
		out.println("<table border='1'><tr><td>Nome</td><td>Quantidade</td><td>Exclusão</td></tr>");
		
		for(Item item : i){
			out.println("<tr><td>" + item.getItem() + "</td><td>" + item.getQuantidade() + "</td>");
			out.println("<td><form action='excluirItem'><input type='hidden' name='idItem' value=" + item.getId_item() + ">");
			out.println("<input type='submit' value='Excluir'></form></td></tr>");
		}
		
		out.println("</table><br>");
		out.println("<h2>Inclusão de itens</h2>");
		out.println("<form action='incluiItem'>");
		out.println("<input type='hidden' name='idItem' value=" + idLista + ">");
		out.println("Nome do item: <input type='text' name='nomeItem'><br>");
		out.println("Quantidade: <input type='text' name='quantidadeItem'><br>");
		out.println("<input type='submit' value='Incluir'></form>");
		
		out.println("</body></html>");
		
	}

}
