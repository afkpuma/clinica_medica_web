package br.edu.imepac.clinica.services;

import br.edu.imepac.clinica.daos.EspecialidadeDAO;
import br.edu.imepac.clinica.entidades.Especialidade;
import java.sql.SQLException;
import java.util.List;

public class EspecialidadeService {
    
    private EspecialidadeDAO dao = new EspecialidadeDAO();

    public void cadastrarEspecialidade(Especialidade especialidade) {
        // Regra de Negócio: Validação
        if (especialidade.getNome() == null || especialidade.getNome().trim().isEmpty()) {
            throw new IllegalArgumentException("O nome da especialidade é obrigatório!");
        }

        try {
            dao.salvar(especialidade);
        } catch (SQLException e) {
            // Em sistema real, logaríamos o erro e lançaríamos uma exceção amigável
            throw new RuntimeException("Erro ao salvar especialidade no banco", e);
        }
    }

    public List<Especialidade> buscarTodas() {
        try {
            return dao.listarTodos();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar especialidades", e);
        }
    }
}