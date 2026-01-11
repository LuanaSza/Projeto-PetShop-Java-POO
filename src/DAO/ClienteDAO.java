package DAO;

import Model.Cliente;
import Util.BancoDados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClienteDAO {
    // construtor
    public ClienteDAO() {
        String sql = "CREATE TABLE IF NOT EXISTS cliente (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT NOT NULL, " +
                "cpf TEXT NOT NULL, " +
                "telefone TEXT)";
        try (Connection conn = BancoDados.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela cliente: " + e.getMessage());
        }
    }

    //salvar o cliente no banco de dados
    public void salvar(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO cliente (nome, cpf, telefone) VALUES (?, ?, ?)";

        //aqui eu usei PreparedStatement para tratar os dados corretamente antes de salvar no banco
        try (Connection conn = BancoDados.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());

            stmt.executeUpdate();
            System.out.println("Cliente " + cliente.getNome() + " salvo com sucesso!");
        }
    }
    //criando a lista de clientes para mostrar na tela de gerenciamento
    public java.util.List<Model.Cliente> listarTodos() throws java.sql.SQLException {
        String sql = "SELECT * FROM cliente";
        java.util.List<Model.Cliente> lista = new java.util.ArrayList<>();
        try (java.sql.Connection conn = BancoDados.getConnection();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql);
             java.sql.ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Model.Cliente c = new Model.Cliente();
                c.setId(rs.getInt("id"));
                c.setNome(rs.getString("nome"));
                c.setCpf(rs.getString("cpf"));
                c.setTelefone(rs.getString("telefone"));
                lista.add(c);
            }
        }
        return lista;
    }

    // metodo para apagar o cadastro do cliente quando o usuário clicar em excluir na tela
    public void excluir(int id) throws java.sql.SQLException {
        String sql = "DELETE FROM cliente WHERE id = ?";
        try (java.sql.Connection conn = BancoDados.getConnection();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    // atualiza os dados do cliente no banco de dados após a edição na tela
    public void atualizar(Model.Cliente cliente) throws java.sql.SQLException {
        String sql = "UPDATE cliente SET nome = ?, cpf = ?, telefone = ? WHERE id = ?";
        try (java.sql.Connection conn = BancoDados.getConnection();
             java.sql.PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setInt(4, cliente.getId());
            stmt.executeUpdate();
        }
    }
}
