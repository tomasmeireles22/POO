import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Estatistica {
    // Variáveis de Instancia
    private List<PlanoTreino> planosTreino;
    private List<Utilizador> utilizador;

    /**
     * Construtor vazio da Classe Estatistica
     */
    public Estatistica() {
        this.planosTreino = new ArrayList<>();
        this.utilizador = new ArrayList<>();
    }

    /**
     * Construtor parametrizado da Classe Estatistica
     * 
     * @param planosTreino lista de planos de treino
     * @param utilizador   lista de utilizadores
     */
    public Estatistica(List<PlanoTreino> planosTreino, List<Utilizador> utilizador) {
        this.planosTreino = new ArrayList<>();
        for (PlanoTreino plano : planosTreino) {
            this.planosTreino.add(plano.clone());
        }
        this.utilizador = new ArrayList<>();
        for (Utilizador utilizadores : utilizador) {
            this.utilizador.add(utilizadores.clone());
        }
    }

    /**
     * Construtor Cópia da Classe Estatistica
     * 
     * @param est
     */
    public Estatistica(Estatistica est) {
        this.planosTreino = est.getPlanosTreino();
        this.utilizador = est.getUtilizador();
    }

    /**
     * Devolve os planos de treino
     * 
     * @return
     */
    public List<PlanoTreino> getPlanosTreino() {
        // Criar um clone da lista de planos de treino para não perder o encapsulamento
        List<PlanoTreino> clonePlanosTreino = new ArrayList<>();
        for (PlanoTreino plano : this.planosTreino) {
            clonePlanosTreino.add(plano.clone());
        }
        return clonePlanosTreino;
    }

    /**
     * Devolve os Utilizadores
     * 
     * @return
     */
    public List<Utilizador> getUtilizador() {
        List<Utilizador> cUtilizador = new ArrayList<>();
        for (Utilizador uti : this.utilizador) {
            cUtilizador.add(uti.clone());
        }
        return cUtilizador;
    }

    /**
     * Atualiza a lista de planos de treino
     * 
     * @param planosTreino
     */
    public void setPlanosTreino(List<PlanoTreino> planosTreino) {
        // Criar um clone da lista de planos de treino para não perder o encapsulamento
        this.planosTreino = new ArrayList<>();
        for (PlanoTreino plano : planosTreino) {
            this.planosTreino.add(plano.clone());
        }
    }

    /**
     * Atualiza a lista de utilizadores
     * 
     * @param utilizador
     */
    public void setUtilizador(List<Utilizador> utilizador) {
        this.utilizador = new ArrayList<>();
        for (Utilizador uti : utilizador) {
            this.utilizador.add(uti.clone());
        }
    }

    /**
     * Método de igualdade entre dois objetos do tipo Estatistica
     * 
     * @param o objeto que será comparado
     * @return booleano true ou false
     */
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if ((o == null) || (this.getClass() != o.getClass()))
            return false;
        Estatistica estatistica = (Estatistica) o;
        return (this.planosTreino.equals(estatistica.getPlanosTreino())
                && this.utilizador.equals(estatistica.getUtilizador()));
    }

    /**
     * Mostra dados referentes as Estatistica
     * 
     * @return
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nLista de planos de treino:\n");
        for (PlanoTreino plano : this.planosTreino) {
            sb.append(plano.toString()).append("\n");
        }
        sb.append("Lista de atividades:\n");
        for (Utilizador uti : utilizador) {
            sb.append(uti.toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Método que clona um objeto do tipo Estatistica
     * 
     * @return
     */
    public Estatistica clone() {
        return new Estatistica(this);
    }

    /**
     * Calcula o plano que mais calorias gasta
     * 
     * @param planoTreino
     * @return
     */
    public String planoExigente(List<PlanoTreino> planoTreino) {
        double maxCalorias = 0;
        double calorias = 0;
        PlanoTreino plano = planoTreino.get(0);

        for (PlanoTreino pl : planoTreino) {
            calorias = pl.totalCalorias();

            if (calorias > maxCalorias) {
                maxCalorias = calorias;
                calorias = 0;
                plano = pl;
            }
        }
        return plano.getId();
    }
}