package br.edu.imepac.clinica.utils;

import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) {
        Connection conexao = null;
        try {
            // 1. Tenta obter a conexão usando sua Factory
            conexao = ConexaoFactory.getConexao();
            
            // 2. Se não deu erro, imprime sucesso
            System.out.println("✅ Conexão com o PostgreSQL realizada com SUCESSO!");

        } catch (SQLException e) {
            // 3. Se deu erro, imprime a falha
            System.err.println("❌ ERRO ao conectar com o banco de dados!");
            System.err.println("Detalhes do erro: " + e.getMessage());
            e.printStackTrace();
            
        } finally {
            // 4. Sempre fecha a conexão no final
            if (conexao != null) {
                try {
                    conexao.close();
                    System.out.println("Desconectado do Banco.");
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar a conexão.");
                }
            }
        }
    }
}