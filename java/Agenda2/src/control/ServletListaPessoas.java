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
import javax.swing.JOptionPane;

import dao.Conexao;
import dao.ListaPessoasDAO;
import model.Pessoa;

@WebServlet("/agenda")
public class ServletListaPessoas extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public ServletListaPessoas() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Obter uma conexão com o banco de dados
		Connection conexao = Conexao.getConexao();
		//Criar um objeto DAO
		ListaPessoasDAO lpd = new ListaPessoasDAO(conexao);
		//Obter lista de pessoas
		ArrayList<Pessoa> listaPessoas = lpd.getListaPessoas();
		
		//Escrevendo a resposta ao cliente
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>A G E N D A</title></head>");
		out.println("<body><table border='1'>");
		out.println("<tr><td>Lista de nomes</td></tr>");
		
		for(Pessoa pessoa : listaPessoas){
			out.println("<tr><td>" + "<a href='contatos?idpessoa=" + pessoa.getId_pessoa() + "'>" + pessoa.getNome() + "</a></td></tr>");
			
		}
		
		out.println("</table></body></html>");
		
	}

}
