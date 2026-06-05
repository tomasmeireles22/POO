import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.List;

public class Profissional extends Utilizador {

    // variáveis de instância
    private double gastoCalorico;

    /**
     * Construtor vazio da Classe Amador
     */
    public Profissional() {
        super();
        this.gastoCalorico = 1.7;
    }

    /**
     * Construtor parametrizado da Classe Profissional
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
    public Profissional(int id, String nome, String email, String morada, int idade, float peso, int altura,
            String genero, int freqCardiaca, List<PlanoTreino> treinos, List<Atividade> atividade) {
        super(id, nome, email, morada, idade, peso, altura, genero, freqCardiaca, treinos, atividade);
        this.gastoCalorico = 1.7;
    }

    /**
     * Construtor Cópia da Classe Profissional
     * 
     * @param umProfissional
     */
    public Profissional(Profissional umProfissional) {
        super(umProfissional.getId(), umProfissional.getNome(), umProfissional.getEmail(), umProfissional.getMorada(),
                umProfissional.getIdade(), umProfissional.getPeso(), umProfissional.getAltura(),
                umProfissional.getGenero(), umProfissional.getFreqCardiaca(), umProfissional.getPlanosTreino(),
                umProfissional.getAtividades());
        this.gastoCalorico = 1.7;
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
     * Método de igualdade entre dois objetos do tipo Profissional
     * 
     * @param o objeto que será comparado
     * @return booleano true ou false
     */
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Profissional p = (Profissional) o;
        return (super.equals(p) && this.gastoCalorico == p.getGastoCalorico());
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
     * Método que clona um objeto do tipo Profissional
     * 
     * @return
     */
    public Profissional clone() {
        return new Profissional(this);
    }
}
