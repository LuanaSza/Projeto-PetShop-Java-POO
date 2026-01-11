package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import Model.Cliente;
import DAO.ClienteDAO;

public class TelaCadastro extends JFrame {
    private JTextField txtNome = new JTextField(20);
    private JTextField txtCpf = new JTextField(15);
    private JTextField txtTelefone = new JTextField(15);
    private JButton btnSalvar = new JButton("Salvar Cliente");

    public TelaCadastro() {
        setTitle("PetShop - Cadastro de Cliente");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2));

        //bloquear letras no CPF
        txtCpf.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) e.consume();
            }
        });

        add(new JLabel(" Nome:")); add(txtNome);
        add(new JLabel(" CPF [Apenas números]:")); add(txtCpf);
        add(new JLabel(" Telefone:")); add(txtTelefone);
        add(new JLabel("")); add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            try {
                // campos obrigatórios
                if (txtNome.getText().trim().isEmpty() || txtCpf.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Preencha Nome e CPF!");
                    return;
                }

                Cliente c = new Cliente();
                c.setNome(txtNome.getText());
                c.setCpf(txtCpf.getText());
                c.setTelefone(txtTelefone.getText());

                new ClienteDAO().salvar(c);
                JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
                dispose(); //fecha tela dps que salva
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro: " + ex.getMessage());
            }
        });
        setLocationRelativeTo(null);
    }
}