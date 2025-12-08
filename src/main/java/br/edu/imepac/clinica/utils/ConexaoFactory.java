package br.edu.imepac.clinica.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

    private static final String URL = "jdbc:postgresql://localhost:5432/clinica_db";
    private static final String USER = "postgres";
    private static final String PASS = "45812340";

    // Bloco estático para carregar o driver assim que a classe for lida
    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Erro ao carregar Driver do Banco", e);
        }
    }

    public static Connection getConexao() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASS);
    }
}