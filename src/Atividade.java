import java.io.Serializable;
import java.time.format.DateTimeFormatter;

public class Atividade implements Serializable {

    // Variáveis de instância
    private String nome;
    public Float duracao;

    /**
     * Construtor vazio da Classe Atividade
     */
    public Atividade() {
        this.nome = "";
        this.duracao = 0.0f;
        // this. = ;
    }

    /**
     * Construtor parametrizado da Classe Atividade
     * 
     * @param nome    nome da atividade
     * @param duracao duração da atividade
     */
    public Atividade(String nome, Float duracao) {
        this.nome = nome;
        this.duracao = duracao;

    }

    /**
     * Construtor Cópia da Classe Atividade
     * 
     * @param umaAtividade
     */
    public Atividade(Atividade umaAtividade) {
        this.nome = umaAtividade.getNome();
        this.duracao = umaAtividade.getDuracao();
    }

    /**
     * Devolve o nome
     * 
     * @return
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Devolve a duração
     * 
     * @return
     */
    public Float getDuracao() {
        return this.duracao;
    }

    /**
     * Atualiza o nome
     * 
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Atualiza a duração
     * 
     * @param duracao
     */
    public void setduracao(Float duracao) {
        this.duracao = duracao;
    }

    /**
     * Método de igualdade entre dois objetos do tipo Atividade
     * 
     * @param o objeto que será comparado
     * @return booleano true ou false
     */
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Atividade atividade = (Atividade) o;
        return (this.nome.equals(atividade.getNome())
                && this.duracao.equals(atividade.getDuracao()));
    }

    /**
     * Mostra dados referentes ao tipo Atividade
     * 
     * @return
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.nome);
        sb.append("\nDuracao: ").append(this.duracao);
        return sb.toString();
    }

    /**
     * Método que clona um objeto do tipo Atividade
     * 
     * @return
     */
    public Atividade clone() {
        return new Atividade(this);
    }
    
    public Object toStringLog() {
        StringBuilder sb = new StringBuilder();
        sb.append("Utilizador:").append(this);
        return sb.toString();
    } 
}