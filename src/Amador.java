import java.util.List;

public class Amador extends Utilizador {

    // Variáveis de Instancia
    private double gastoCalorico;

    /**
     * Construtor vazio da Classe Amador
     */
    public Amador() {
        super();
        this.gastoCalorico = 1.2;
    }

    /**
     * Construtor parametrizado da Classe Amador
     * 
     * @param id           id do Utilizador
     * @param nome         nome do Utilizador
     * @param email        email do Utilizador
     * @param morada       morada do utilizador
     * @param idade        idade do utilizador
     * @param peso         peso do utilizador
     * @param altura       altura do utilizador
     * @param genero       genero do utilizador
     * @param freqCardiaca frequencia Cardiaca do utilizador
     * @param planosTreino planos de treino associados ao Utilizador
     * @param atividade    atividades de treino associados ao Utilizador
     */

    public Amador(int id, String nome, String email, String morada, int idade, float peso, int altura, String genero,
            int freqCardiaca, List<PlanoTreino> planosTreino, List<Atividade> atividade) {
        super(id, nome, email, morada, idade, peso, altura, genero, freqCardiaca, planosTreino, atividade);
        this.gastoCalorico = 1.2;
    }

    /**
     * Construtor Cópia da Classe Amador
     * 
     * @param umAmador objeto do tipo Amador
     */
    public Amador(Amador umAmador) {
        super(umAmador.getId(), umAmador.getNome(), umAmador.getEmail(), umAmador.getMorada(), umAmador.getIdade(),
                umAmador.getPeso(), umAmador.getAltura(), umAmador.getGenero(), umAmador.getFreqCardiaca(),
                umAmador.getPlanosTreino(), umAmador.getAtividades());
        this.gastoCalorico = 1.2;
    }

    /**
     * Devolve o valor de gasto calórico
     * 
     * @return
     */
    public double getGastoCalorico() {
        return this.gastoCalorico;
    }

    /**
     * Atualiza o valor de gasto calórico
     * 
     * @param gastoCalorico
     */
    public void setGastoCalorico(double gastoCalorico) {
        this.gastoCalorico = gastoCalorico;
    }

    /**
     * Método de igualdade entre dois objetos do tipo Amador
     * 
     * @param o objeto que será comparado
     * @return booleano true ou false
     */
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Amador a = (Amador) o;
        return (super.equals(a) && this.gastoCalorico == a.getGastoCalorico());
    }

    /**
     * Mostra dados referentes ao tipo Amador
     * 
     * @return
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("\nGasto Calórico: ").append(this.gastoCalorico);
        return sb.toString();
    }

    /**
     * Método que clona um objeto do tipo Amador
     * 
     * @return
     */
    public Amador clone() {
        return new Amador(this);
    }
}
