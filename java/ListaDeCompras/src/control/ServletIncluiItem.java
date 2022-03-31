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
import dao.IncluirItemDAO;

/**
 * Servlet implementation class ServletIncluiItem
 */
@WebServlet("/incluiItem")
public class ServletIncluiItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletIncluiItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String idItem = request.getParameter("idItem");
		String nome_item = request.getParameter("nomeItem");
		String quantidade_item = request.getParameter("quantidadeItem");
		
		Connection conexao = Conexao.getConexao();
		
		IncluirItemDAO itd = new IncluirItemDAO(conexao);
		
		boolean resultado = itd.incluiItem(idItem, nome_item, quantidade_item);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Inclusão de item</title></head>");
		out.println("<body>");
		
		if(resultado)
			out.println("<h1>Item incluído com sucesso!");
		else
			out.println("<h1>Erro ao incluir o item");
			
		out.println("</body></html>");
		
		
	}

}
