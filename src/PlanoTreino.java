import java.util.Map;
import java.io.Serializable;
import java.util.HashMap;
import java.util.stream.Collectors;

public class PlanoTreino implements Serializable {
    // Variáveis de instância
    private String id;
    private Map<String, Atividade> atividades = new HashMap<String, Atividade>();

    /**
     * Construtor vazio da Classe Plano Treino
     */
    public PlanoTreino() {
        this.id = "";
        this.atividades = new HashMap<String, Atividade>();
    }

    /**
     * Construtor parametrizado da Classe PlanoTreino
     * 
     * @param id        id do plano treino
     * @param atividade atividades que pertencem ao plano Treino
     */
    public PlanoTreino(String id, Map<String, Atividade> atividade) {
        this.id = id;
        this.atividades = atividades.values().stream().collect(Collectors.toMap(Atividade::getNome, Atividade::clone));
    }

    /**
     * Construtor Cópia da Classe PlanoTreino
     * 
     * @param p
     */
    public PlanoTreino(PlanoTreino p) {
        this.id = p.getId();
        this.atividades = p.getAtividades();
    }

    /**
     * Construtor PlanoTreino que recebe um id
     * 
     * @param id
     */
    public PlanoTreino(String id) {
        this.id = id;
        this.atividades = new HashMap<>();
    }

    /**
     * Método de igualdade entre dois objetos do tipo PlanoTreino
     * 
     * @param o objeto que será comparado
     * @return booleano true ou false
     */
    public boolean equals(Object o) {
        if (this == o)
            return true;

        if (o == null || this.getClass() != o.getClass())
            return false;

        PlanoTreino p = (PlanoTreino) o;
        return this.id.equals(p.id) &&
                this.atividades.equals(p.atividades);
    }

    /**
     * Mostra dados referentes ao tipo Atividade
     * 
     * @return
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Id: ");
        sb.append(this.id);
        if (this.atividades.isEmpty())
            sb.append("");
        else {
            sb.append("\nAtividades: \n");
            this.atividades.values().forEach(l -> {
                sb.append(l.toString());
                sb.append("\n");
            });
        }
        return sb.toString();
    }

    /**
     * Devolve o id
     * 
     * @return
     */
    public String getId() {
        return this.id;
    }

    /**
     * Atualiza o id
     * 
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Devolve as ativiades que pertencem ao plano de treino
     * 
     * @return
     */
    public Map<String, Atividade> getAtividades() {
        return this.atividades.values().stream().collect(Collectors.toMap(Atividade::getNome, Atividade::clone));
    }

    /**
     * Atualiza as atividades que pertencem ao plano de treino
     * 
     * @param atv
     */
    public void setAtividades(Map<String, Atividade> atv) {
        this.atividades = atv.values().stream().collect(Collectors.toMap(Atividade::getNome, Atividade::clone));
    }

    /**
     * Adiciona atividades
     * 
     * @param a
     */
    public void adicionarAtividade(Atividade a) {
        atividades.put(a.getNome(), a.clone());
    }

    /**
     * Calcula o total de calorias do plano de treino
     * 
     * @return
     */
    public double totalCalorias() {
        double total = 0.0;
        for (Atividade atividade : atividades.values()) {
            if (atividade instanceof Distancia) {
                total += ((Distancia) atividade).calculaCalorias();
            } else if (atividade instanceof Repeticoes) {
                total += ((Repeticoes) atividade).calculaCalorias();
            }
        }
        return total;
    }

    /**
     * Método que clona um objeto do tipo PlanoTreino
     * 
     * @return
     */
    public PlanoTreino clone() {
        return new PlanoTreino(this);
    }
    
    public Object toStringLog() {
        StringBuilder sb = new StringBuilder();
        sb.append("PlanoTreino:").append(this.id);
        return sb.toString();
    } 
}
