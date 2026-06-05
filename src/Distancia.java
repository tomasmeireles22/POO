
public class Distancia extends Atividade {

    // Variáveis de instância
    private double dist;
    private int altimetria;

    /**
     * Construtor vazio da Classe Distancia
     */
    public Distancia() {
        super();
        this.dist = 0.0;
        this.altimetria = 0;
    }

    /**
     * Construtor parametrizado da Classe Distancia
     * 
     * @param nome       nome do exercicio do tipo Distancia
     * @param duracao    duração da exercicio do tipo Distancia
     * @param dist       disntancia
     * @param altimetria altimetria
     */
    public Distancia(String nome, Float duracao, double dist, int altimetria) {
        super(nome, duracao);
        this.dist = dist;
        this.altimetria = altimetria;
    }

    /**
     * Construtor Cópia da Classe Distancia
     * 
     * @param umaDistancia
     */
    public Distancia(Distancia umaDistancia) {
        super(umaDistancia.getNome(), umaDistancia.getDuracao());
        this.dist = umaDistancia.getDist();
        this.altimetria = umaDistancia.getAltimetria();
    }

    /**
     * Devolve a distancia
     * 
     * @return
     */
    public double getDist() {
        return this.dist;
    }

    /**
     * Devolve a altimetria
     * 
     * @return
     */
    public int getAltimetria() {
        return this.altimetria;
    }

    /**
     * Atualiza a distancia
     * 
     * @param dist
     */
    public void setDist(double dist) {
        this.dist = dist;
    }

    /**
     * Atualiza a altimetria
     * 
     * @param altimetria
     */
    public void setAltimetria(int altimetria) {
        this.altimetria = altimetria;
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
        Distancia d = (Distancia) o;
        return (super.equals(d)
                && this.duracao == d.getDuracao()
                && this.dist == d.getDist()
                && this.altimetria == d.getAltimetria());
    }

    /**
     * Mostra dados referentes ao tipo Atividade
     * 
     * @return
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\nDistancia: ").append(this.dist);
        sb.append("\nAltimetria: ").append(this.altimetria);
        return sb.toString();
    }

    /**
     * Método que clona um objeto do tipo Distancia
     * 
     * @return
     */
    public Distancia clone() {
        return new Distancia(this);
    }

    /**
     * Calcula as calorias gastas neste exercicio
     * 
     * @return
     */
    public double calculaCalorias() {
        if (this.getAltimetria() == 0) {
            return 11 * this.getDuracao() + 4 * (this.getDist());
        } else {
            return 11 * this.getDuracao() + 4 * (this.getDist()) + this.getAltimetria();
        }
    }
}
