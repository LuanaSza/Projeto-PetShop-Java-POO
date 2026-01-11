package View;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        setTitle("Sistema PetShop - Luana Souza");
        setSize(400, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //botões
        setLayout(new GridLayout(4, 1, 15, 15));

        JButton btnCliente = new JButton("Cadastrar Novo Cliente");
        JButton btnPet = new JButton("Cadastrar Pet para Cliente");
        JButton btnListaCliente = new JButton("Lista de Clientes (Gerenciar)");
        JButton btnListaPet = new JButton("Lista de Pets (Ver Animais)");

        // ações dos botões
        btnCliente.addActionListener(e -> new TelaCadastro().setVisible(true));
        btnPet.addActionListener(e -> new TelaPet().setVisible(true));
        btnListaCliente.addActionListener(e -> new TelaListaCliente().setVisible(true));

        // visualizar pets
        btnListaPet.addActionListener(e -> new TelaListaPet().setVisible(true));

        add(btnCliente);
        add(btnPet);
        add(btnListaCliente);
        add(btnListaPet);

        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MenuPrincipal().setVisible(true);
        });
    }
}