package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import DAO.PetDAO;
import Model.Pet;
import java.util.List;

// Tela para listar os pets e mostrar o relacionamento com o dono
public class TelaListaPet extends JFrame {
    private JTable tabela;
    private DefaultTableModel modelo;

    public TelaListaPet() {
        setTitle("Lista de Pets Cadastrados");
        setSize(600, 400);
        setLayout(new BorderLayout());

        // o id do Dono prova o relacionamento 1:N exigido
        modelo = new DefaultTableModel(new Object[]{"ID Pet", "Nome do Pet", "Espécie", "ID do Dono"}, 0);

        tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);
        add(scroll, BorderLayout.CENTER);

        // painel inferior para botões
        JPanel painelBotoes = new JPanel();
        JButton btnAtualizar = new JButton("Recarregar Lista");
        btnAtualizar.addActionListener(e -> carregarDados());

        painelBotoes.add(btnAtualizar);
        add(painelBotoes, BorderLayout.SOUTH);

        // carrega os dados automaticamente ao abrir a tela
        carregarDados();

        setLocationRelativeTo(null);
    }

    private void carregarDados() {
        modelo.setRowCount(0); // limpa a tabela antes de carregar novos dados

        try {
            PetDAO dao = new PetDAO();
            // busca a lista de pets através do DAO
            List<Pet> lista = dao.listarTodos();

            for (Pet p : lista) {
                // navegando no objeto: entra no Pet, pega o Dono e puxa o ID dele pra foreign key
                modelo.addRow(new Object[]{
                        p.getId(),
                        p.getNome(),
                        p.getEspecie(),
                        (p.getDono() != null) ? p.getDono().getId() : "Sem Dono"
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar lista de pets: " + e.getMessage());
        }
    }
}