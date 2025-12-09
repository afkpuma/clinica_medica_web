package br.edu.imepac.clinica.controllers;

import br.edu.imepac.clinica.entidades.Especialidade;
import br.edu.imepac.clinica.services.EspecialidadeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

// Define a URL que acessa este código
@WebServlet("/especialidades")
public class EspecialidadeController extends HttpServlet {

    private EspecialidadeService service = new EspecialidadeService();

    // GET: Usado para carregar a página e listar dados
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Busca dados do banco via Service
        var lista = service.buscarTodas();
        
        // Coloca a lista num "envelope" para o JSP abrir
        req.setAttribute("listaEspecialidades", lista);
        
        // Encaminha para a tela (View)
        req.getRequestDispatcher("especialidades.jsp").forward(req, resp);
    }

    // POST: Usado para enviar dados de formulário
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String nome = req.getParameter("nome");
        String descricao = req.getParameter("descricao");

        Especialidade nova = new Especialidade(nome, descricao);
        
        try {
            service.cadastrarEspecialidade(nova);
            // Se der certo, volta para a lista
            resp.sendRedirect("especialidades"); 
        } catch (Exception e) {
            // Se der erro, manda mensagem para a tela
            req.setAttribute("erro", e.getMessage());
            doGet(req, resp);
        }
    }
}