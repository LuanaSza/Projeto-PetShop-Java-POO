package DAO;

import Model.Pet;
import Model.Cliente;
import Util.BancoDados;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetDAO {

    public PetDAO() {
        // cria a tabela de pets ligada ao cliente (id_cliente)
        String sql = "CREATE TABLE IF NOT EXISTS pet (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nome TEXT NOT NULL, " +
                "especie TEXT NOT NULL, " +
                "id_cliente INTEGER, " +
                "FOREIGN KEY(id_cliente) REFERENCES cliente(id))";
        try (Connection conn = BancoDados.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.execute();
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela pet: " + e.getMessage());
        }
    }

    public void salvar(Pet pet) throws SQLException {
        String sql = "INSERT INTO pet (nome, especie, id_cliente) VALUES (?, ?, ?)";

        try (Connection conn = BancoDados.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pet.getNome());
            stmt.setString(2, pet.getEspecie());
            // pega o id do dono para o relacionento 1:N
            stmt.setInt(3, pet.getDono().getId());

            stmt.executeUpdate();
            System.out.println("Pet " + pet.getNome() + " cadastrado com sucesso!");
        }
    }

    // MÉTODO NOVO: Necessário para a TelaListaPet funcionar e sair o erro vermelho
    public List<Pet> listarTodos() throws SQLException {
        List<Pet> pets = new ArrayList<>();
        String sql = "SELECT * FROM pet";

        try (Connection conn = BancoDados.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Pet p = new Pet();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setEspecie(rs.getString("especie"));

                // criando um cliente 'fake' só com o ID pra amarrar o pet ao dono sem erro.
                Cliente dono = new Cliente();
                dono.setId(rs.getInt("id_cliente"));
                p.setDono(dono);

                pets.add(p);
            }
        }
        return pets;
    }
}