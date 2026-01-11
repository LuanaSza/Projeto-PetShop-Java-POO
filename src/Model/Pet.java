package Model;

public class Pet {
    private int id;
    private String nome;
    private String especie;
    private Cliente dono; // Relacionamento 1:N

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public Cliente getDono() { return dono; }
    public void setDono(Cliente dono) { this.dono = dono; }
}