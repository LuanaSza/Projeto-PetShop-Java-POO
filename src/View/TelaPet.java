package View;

import javax.swing.*;
import java.awt.*;
import Model.Pet;
import Model.Cliente;
import DAO.PetDAO;

public class TelaPet extends JFrame {
    private JTextField txtNomePet = new JTextField(20);
    private JTextField txtEspecie = new JTextField(20);
    private JTextField txtIdDono = new JTextField(5);
    private JButton btnSalvar = new JButton("Cadastrar Pet");

    public TelaPet() {
        setTitle("PetShop - Cadastro de Pet");
        setSize(400, 300);
        setLayout(new GridLayout(5, 2));

        // apenas números no id do dono
        txtIdDono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent e) {
                if (!Character.isDigit(e.getKeyChar())) e.consume();
            }
        });

        add(new JLabel(" Nome do Pet:")); add(txtNomePet);
        add(new JLabel(" Espécie:")); add(txtEspecie);
        add(new JLabel(" ID do Dono:")); add(txtIdDono);
        add(new JLabel("")); add(btnSalvar);

        btnSalvar.addActionListener(e -> {
            try {
                if(txtIdDono.getText().isEmpty()) return;

                Pet p = new Pet();
                p.setNome(txtNomePet.getText());
                p.setEspecie(txtEspecie.getText());

                Cliente dono = new Cliente();
                dono.setId(Integer.parseInt(txtIdDono.getText()));
                p.setDono(dono);

                new PetDAO().salvar(p);
                JOptionPane.showMessageDialog(null, "Pet cadastrado com sucesso!");
                dispose();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao vincular pet ao dono.");
            }
        });
        setLocationRelativeTo(null);
    }
}