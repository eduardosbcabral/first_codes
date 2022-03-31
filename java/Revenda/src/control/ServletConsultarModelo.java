package control;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Conexao;
import dao.ConsultarModeloDAO;
import model.Carro;

/**
 * Servlet implementation class ServletConsultarModelo
 */
@WebServlet("/consultarModelo")
public class ServletConsultarModelo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletConsultarModelo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Obter os parametros da requisicao
		String marca = request.getParameter("marca");
		//Criar conexao com BD
		Connection conexao = Conexao.getConexao();
		//Criar um objeto DAO
		ConsultarModeloDAO cmd = new ConsultarModeloDAO(conexao);
		//Recuperar um carro de acordo com a marca
		Carro c = cmd.consultarModelo(marca);
		
		//Inserir parametros no request
		request.setAttribute("carro", c);
		
		//Criar um Request Dispatcher
		RequestDispatcher rd = request.getRequestDispatcher("/respostaConsultarModelo.jsp");
		rd.forward(request, response);
	}

	
	
	
	
	
	
	
	
	
	
}
