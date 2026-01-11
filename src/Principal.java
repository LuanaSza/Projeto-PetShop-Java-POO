import DAO.ClienteDAO;
import Model.Cliente;
import java.sql.SQLException;

// classe simples só para testar se o banco de dados está gravando certo
public class Principal {
    public static void main(String[] args) {
        try {
            // criando um cliente de teste para ve se vai pro banco
            Cliente c = new Cliente();
            c.setNome("Luana Teste");
            c.setCpf("01909815390");
            c.setTelefone("86 995381394");

            // chamando o DAO para salvar no SQLite
            ClienteDAO dao = new ClienteDAO();
            dao.salvar(c);

            System.out.println("Deu certo! O cliente foi salvo. Olhe o arquivo petshop.db");

        } catch (SQLException e) {
            System.err.println("Ih, deu erro no teste do banco: " + e.getMessage());
        }
    }
}