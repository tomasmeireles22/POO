import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class PraticanteOcasional extends Utilizador {

    // variáveis de instância
    private double gastoCalorico;

    /**
     * Construtor vazio da Classe Amador
     */
    public PraticanteOcasional() {
        super();
        this.gastoCalorico = 0.5;
    }

    /**
     * 
     * @param id
     * @param nome
     * @param email
     * @param morada
     * @param idade
     * @param peso
     * @param altura
     * @param genero
     * @param freqCardiaca
     * @param treinos
     * @param atividade
     */
    public PraticanteOcasional(int id, String nome, String email, String morada, int idade, float peso, int altura,
            String genero, int freqCardiaca, List<PlanoTreino> treinos, List<Atividade> atividade) {
        super(id, nome, email, morada, idade, peso, altura, genero, freqCardiaca, treinos, atividade);
        this.gastoCalorico = 0.5;
    }

    /**
     * Construtor Cópia da Classe PraticanteOcasional
     * 
     * @param umPraticanteOcasional
     */
    public PraticanteOcasional(PraticanteOcasional umPraticanteOcasional) {
        super(umPraticanteOcasional.getId(), umPraticanteOcasional.getNome(), umPraticanteOcasional.getEmail(),
                umPraticanteOcasional.getMorada(), umPraticanteOcasional.getIdade(), umPraticanteOcasional.getPeso(),
                umPraticanteOcasional.getAltura(), umPraticanteOcasional.getGenero(),
                umPraticanteOcasional.getFreqCardiaca(), umPraticanteOcasional.getPlanosTreino(),
                umPraticanteOcasional.getAtividades());
        this.gastoCalorico = 0.5;
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
     * Método de igualdade entre dois objetos do tipo PraticanteOcasional
     * 
     * @param o objeto que será comparado
     * @return booleano true ou false
     */
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        PraticanteOcasional pO = (PraticanteOcasional) o;
        return (super.equals(pO) && this.gastoCalorico == pO.getGastoCalorico());
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
    public PraticanteOcasional clone() {
        return new PraticanteOcasional(this);
    }
}
