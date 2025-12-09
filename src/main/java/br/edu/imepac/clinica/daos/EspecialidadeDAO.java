package br.edu.imepac.clinica.daos;

import br.edu.imepac.clinica.entidades.Especialidade;
import br.edu.imepac.clinica.utils.ConexaoFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EspecialidadeDAO {

    // Método para SALVAR
    public void salvar(Especialidade especialidade) throws SQLException {
        String sql = "INSERT INTO especialidade (nome, descricao) VALUES (?, ?)";

        // Try-with-resources: Fecha a conexão automaticamente (Java 7+)
        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            // Setar os valores substitui os '?' (Evita SQL Injection)
            stmt.setString(1, especialidade.getNome());
            stmt.setString(2, especialidade.getDescricao());
            
            stmt.execute();
        }
    }

    // Método para LISTAR
    public List<Especialidade> listarTodos() throws SQLException {
        List<Especialidade> lista = new ArrayList<>();
        String sql = "SELECT id, nome, descricao FROM especialidade";

        try (Connection conn = ConexaoFactory.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Especialidade e = new Especialidade();
                e.setId(rs.getLong("id"));
                e.setNome(rs.getString("nome"));
                e.setDescricao(rs.getString("descricao"));
                lista.add(e);
            }
        }
        return lista;
    }
}