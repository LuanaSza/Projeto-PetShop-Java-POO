package View;

import DAO.ClienteDAO;
import Model.Cliente;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class TelaListaCliente extends JFrame {
    private JTable tabela;
    private DefaultTableModel modelo;
    private JButton btnAtualizar, btnExcluir;

    public TelaListaCliente() {
        setTitle("Lista de Clientes Cadastrados");
        setSize(600, 400);
        setLayout(new BorderLayout());

        // criando a tabela
        modelo = new DefaultTableModel(new Object[]{"ID", "Nome", "CPF", "Telefone"}, 0);
        tabela = new JTable(modelo);
        add(new JScrollPane(tabela), BorderLayout.CENTER);

        //botões
        JPanel painelBotoes = new JPanel();
        btnAtualizar = new JButton("Recarregar Lista");
        btnExcluir = new JButton("Excluir Selecionado");
        painelBotoes.add(btnAtualizar);
        painelBotoes.add(btnExcluir);
        add(painelBotoes, BorderLayout.SOUTH);

        // ação para carregar os dados
        btnAtualizar.addActionListener(e -> carregarDados());

        // Ação para excluir
        btnExcluir.addActionListener(e -> {
            int linha = tabela.getSelectedRow();
            if (linha != -1) {
                int id = (int) modelo.getValueAt(linha, 0);
                try {
                    new ClienteDAO().excluir(id);
                    JOptionPane.showMessageDialog(this, "Cliente excluído!");
                    carregarDados(); // Atualiza a lista após excluir
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Erro ao excluir: " + ex.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selecione um cliente na tabela.");
            }
        });

        carregarDados(); // carrega assim que abre a tela
        setLocationRelativeTo(null);
    }

    private void carregarDados() {
        try {
            modelo.setRowCount(0); // limpa  tabela
            List<Cliente> clientes = new ClienteDAO().listarTodos();
            for (Cliente c : clientes) {
                modelo.addRow(new Object[]{c.getId(), c.getNome(), c.getCpf(), c.getTelefone()});
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        new TelaListaCliente().setVisible(true);
    }
}