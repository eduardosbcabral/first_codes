package control;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.ConsultarTodosModelosDAO;
import model.Carro;

/**
 * Servlet implementation class ServletConsultarTodosModelos
 */
@WebServlet("/consultarTodosModelos")
public class ServletConsultarTodosModelos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConsultarTodosModelos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection conexao = Conexao.getConexao();
		
		ConsultarTodosModelosDAO cmdao = new ConsultarTodosModelosDAO(conexao);
		
		ArrayList<Carro> carros = cmdao.getCarros();
		
		//Inserir parametros no request
		request.setAttribute("listaCarros", carros);
				
		//Criar um Request Dispatcher
		RequestDispatcher rd = request.getRequestDispatcher("/respostaConsultarTodosModelos.jsp");
		rd.forward(request, response);
	}

}
