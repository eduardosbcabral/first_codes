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
import model.Contato;
import model.Pessoa;

@WebServlet("/contatos")
public class ServletDetalhaPessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletDetalhaPessoa() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Obter parâmetro
		String idPessoa = request.getParameter("idpessoa");
		//Obter uma conexão com o BD
		Connection conexao = Conexao.getConexao();
		//Instanciando DetalhaPessoaDAO
		DetalhaPessoaDAO dpd = new DetalhaPessoaDAO(conexao);
		//Obter detalhes da pessoa
		Pessoa p = dpd.getPessoa(idPessoa);
		//Obter contatos da pessoa
		ArrayList<Contato> contatosPessoa = dpd.getContatosPessoa(idPessoa);
		
		//Escrevendo a resposta ao cliente
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Detalha Pessoa</title></head>");
		out.println("<body><h1>" + p.getNome() + "</h1>");
		out.println("<h2>" + p.getEndereco() + "/" + p.getUf() + "</h2>");
		out.println("<p><br>");
		out.println("<table border='1'><tr><td>Tipo Contatos</td><td>Contato</td>");
		
		for(Contato contato : contatosPessoa){
			out.println("<tr><td>" + contato.getTipo_contato() + "</td><td>" + contato.getContato() + "</td></tr>");
		}
		
		out.println("</table></body></html>");
		
	}

}
