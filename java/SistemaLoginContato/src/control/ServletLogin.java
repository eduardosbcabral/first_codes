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
import dao.DetalhaPessoaDAO;
import dao.LoginDAO;
import model.Contato;
import model.Pessoa;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		
		Connection conexao = Conexao.getConexao();

		LoginDAO ldao = new LoginDAO(conexao);
		
		Pessoa p = ldao.loginPessoa(usuario, senha);
		
		PrintWriter out = response.getWriter();
		
		
		if(p==null){
			out.println("<html><head><title>Usuário inválido</title></head>");
			out.println("<body><h1>Usuário não encontrado!</h1>");
		}else{
			out.println("<html><head><title>" + p.getNome() + "</title></head>");
			out.println("<body><h1>" + p.getNome() + "</h1>");
			out.println("<h2>" + p.getEndereco_pessoa() + "/" + p.getUf_pessoa() + "</h2>");
			out.println("<p><br>");
			out.println("<table border='1'><tr><td>Tipo Contatos</td><td>Contato</td><td>Exclusão</td></tr>");
			
			DetalhaPessoaDAO dpd = new DetalhaPessoaDAO(conexao);
			
			ArrayList<Contato> tipo_contato = dpd.getContatosPessoa(p.getId_pessoa());
			
			for(Contato contato : tipo_contato)
				out.println("<tr><td>" + contato.getTipo_contato() + "</td><td>" + contato.getContato() + "</td><td><form action='excluiContato'>"+
							"<input type='hidden' name='idcontato' value =" + contato.getId_contato() + "><input type='submit' value='Excluir'></form></td></tr>");
			
		}

		
		out.println("</table></body></html>");
	}

}
