import java.time.LocalDateTime;

public class Repeticoes extends Atividade {
    // Variáveis de Instancia
    private int reps;
    private double peso;

    /**
     * Construtor vazio da Classe Repeticoes
     */
    public Repeticoes() {
        super();
        this.reps = 0;
        this.peso = 0.0;
    }

    /**
     * Construtor parametrizado da Classe Repeticoes
     * 
     * @param nome    nome do exercicio do tipo Repetições
     * @param duracao duração da exercicio do tipo Repetições
     * @param reps    numero de repetições
     * @param peso    peso usado
     */
    public Repeticoes(String nome, Float duracao, int reps, double peso) {
        super(nome, duracao);
        this.reps = reps;
        this.peso = peso;
    }

    /**
     * Construtor Cópia da Classe Repeticoes
     * 
     * @param repeticoes
     */
    public Repeticoes(Repeticoes repeticoes) {
        super(repeticoes.getNome(), repeticoes.getDuracao());
        this.reps = repeticoes.getReps();
        this.peso = repeticoes.getPeso();
    }

    /**
     * Devolve o numero de repetições
     * 
     * @return
     */
    public int getReps() {
        return this.reps;
    }

    /**
     * Devolve o peso
     * 
     * @return
     */
    public double getPeso() {
        return this.peso;
    }

    /**
     * Atualiza o numero de repetições
     * 
     * @param reps
     */
    public void setReps(int reps) {
        this.reps = reps;
    }

    /**
     * Atualiza o peso
     * 
     * @param peso
     */
    public void setPeso(double peso) {
        this.peso = peso;
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
        Repeticoes p = (Repeticoes) o;
        return (super.equals(p)
                && this.reps == p.getReps()
                && this.peso == p.getPeso());
    }

    /**
     * Mostra dados referentes ao tipo Repeticoes
     * 
     * @return
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\nRepetições: ").append(this.reps);
        sb.append("\nPeso: ").append(this.peso);
        return sb.toString();
    }

    /**
     * Método que clona um objeto do tipo Repeticoes
     * 
     * @return
     */
    public Repeticoes clone() {
        return new Repeticoes(this);
    }

    /**
     * Calcula as calorias gastas neste exercício
     * 
     * @return
     */
    public double calculaCalorias() {
        if (this.getPeso() == 0) {
            return 5 * this.getReps();
        } else {
            return 11 * this.getReps() + 4 * (this.getPeso());
        }
    }
}
