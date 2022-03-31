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
import dao.ExcluirItemDAO;

/**
 * Servlet implementation class ServletExcluirItem
 */
@WebServlet("/excluirItem")
public class ServletExcluirItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletExcluirItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idItem = request.getParameter("idItem");
		
		Connection conexao = Conexao.getConexao();
		
		ExcluirItemDAO eid = new ExcluirItemDAO(conexao);
		
		boolean resultado = eid.excluirItem(idItem);
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Exclusão de item</title></head>");
		out.println("<body>");
		
		if(resultado)
			out.println("<h1>Item excluído com sucesso!");
		else
			out.println("<h1>Erro ao excluir o item");
			
		out.println("</body></html>");
	}

}
