import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class Utilizador implements Serializable {
    // Variáveis de Instancia
    private int id;
    private String nome;
    private String email;
    private String morada;
    private int idade;
    private float peso;
    private int altura;
    private String genero;
    private int freqCardiaca;
    private List<PlanoTreino> planosTreino;
    private List<Atividade> atividades;

    /**
     * Construtor para objetos da classe Utilizador
     */
    public Utilizador() {
        this.id = 0;
        this.nome = "";
        this.email = "";
        this.morada = "";
        this.idade = 0;
        this.peso = 0;
        this.altura = 0;
        this.genero = "";
        this.freqCardiaca = 0;
        this.planosTreino = new ArrayList<>();
        this.atividades = new ArrayList<>();
    }

    /**
     * Construtor parametrizado da Classe Utilizador
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
    public Utilizador(int id, String nome, String email, String morada, int idade, float peso, int altura,
            String genero, int freqCardiaca,
            List<PlanoTreino> planosTreino, List<Atividade> atividades) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.morada = morada;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        this.genero = genero;
        this.freqCardiaca = freqCardiaca;
        this.planosTreino = new ArrayList<>();
        for (PlanoTreino p : planosTreino) {
            this.planosTreino.add(p.clone());
        }
        this.atividades = new ArrayList<>();
        for (Atividade a : atividades) {
            this.atividades.add(a.clone());
        }
    }

    /**
     * Construtor Cópia de Utilizador
     * 
     * @param umUtilizador
     */
    public Utilizador(Utilizador umUtilizador) {
        this.id = umUtilizador.getId();
        this.nome = umUtilizador.getNome();
        this.email = umUtilizador.getEmail();
        this.morada = umUtilizador.getMorada();
        this.idade = umUtilizador.getIdade();
        this.peso = umUtilizador.getPeso();
        this.altura = umUtilizador.getAltura();
        this.genero = umUtilizador.getGenero();
        this.freqCardiaca = umUtilizador.getFreqCardiaca();
        this.planosTreino = umUtilizador.getPlanosTreino();
        this.atividades = umUtilizador.getAtividades();
    }

    /*
     * Devolve o Id
     */
    public int getId() {
        return this.id;
    }

    /*
     * Devolve o Nome
     */
    public String getNome() {
        return this.nome;
    }

    /*
     * Devolve email
     */
    public String getEmail() {
        return this.email;
    }

    /*
     * Devolve morada
     */
    public String getMorada() {
        return this.morada;
    }

    /*
     * Devolve idade
     */
    public int getIdade() {
        return this.idade;
    }

    /**
     * Devolve peso
     * 
     * @return
     */
    public float getPeso() {
        return this.peso;
    }

    /*
     * Devolve altura
     */
    public int getAltura() {
        return this.altura;
    }

    /**
     * Devolve genero
     * 
     * @return
     */
    public String getGenero() {
        return this.genero;
    }

    /**
     * Devolve a frequnecia Cardiaca
     * 
     * @return
     */
    public int getFreqCardiaca() {
        return this.freqCardiaca;
    }

    /**
     * Devolve os planos de Treino do utilizador
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
     * Devolvev as Atividades do utilizador
     * 
     * @return
     */
    public List<Atividade> getAtividades() {
        List<Atividade> cloneAtividades = new ArrayList<>();
        for (Atividade atividade : this.atividades) {
            cloneAtividades.add(atividade.clone());
        }
        return cloneAtividades;
    }

    /**
     * Atualiza o id
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
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
     * Atualiza o email
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Atualiza a morada
     * 
     * @param morada
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * Atualiza a idade
     * 
     * @param idade
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     * Atualiza o peso
     * 
     * @param peso
     */
    public void setPeso(float peso) {
        this.peso = peso;
    }

    /**
     * Atualiza a altura
     * 
     * @param altura
     */
    public void setAltura(int altura) {
        this.altura = altura;
    }

    /**
     * Atualiza o genero
     * 
     * @param genero
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Atualiza a frequencia Cardiaca
     * 
     * @param freqCardiaca
     */
    public void setFreqCardiaca(int freqCardiaca) {
        this.freqCardiaca = freqCardiaca;
    }

    /**
     * Atualiza os planos de treinos associados a este Utilizador
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
     * Atualiza as atividades associados a este Utilizador
     * 
     * @param atividades
     */
    public void setAtividades(List<Atividade> atividades) {
        this.atividades = new ArrayList<>();
        for (Atividade a : atividades) {
            this.atividades.add(a.clone());
        }
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
        Utilizador utilizador = (Utilizador) o;
        return (this.id == utilizador.getId()
                && this.nome.equals(utilizador.getNome())
                && this.email.equals(utilizador.getEmail())
                && this.morada.equals(utilizador.getMorada())
                && this.idade == utilizador.getIdade()
                && this.peso == utilizador.getPeso()
                && this.altura == utilizador.getAltura()
                && this.genero.equals(utilizador.getGenero())
                && this.freqCardiaca == utilizador.getFreqCardiaca()
                && this.planosTreino.equals(utilizador.getPlanosTreino())
                && this.atividades.equals(utilizador.getAtividades()));
    }

    /**
     * Mostra dados referentes ao tipo Utilizador
     * 
     * @return
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(this.id);
        sb.append("\nNome: ").append(this.nome);
        sb.append("\nEmail: ").append(this.email);
        sb.append("\nMorada: ").append(this.morada);
        sb.append("\nIdade: ").append(this.idade);
        sb.append("\nPeso: ").append(this.peso);
        sb.append("\nAltura: ").append(this.altura);
        sb.append("\nGenero: ").append(this.genero);
        sb.append("\nFrequencia Cardiaca: ").append(this.freqCardiaca);
        sb.append("\nLista de planos de treino:\n");
        for (PlanoTreino plano : this.planosTreino) {
            sb.append(plano.toString()).append("\n");
        }
        sb.append("Lista de atividades:\n");
        for (Atividade atividade : atividades) {
            sb.append(atividade.toString()).append("\n");
        }
        return sb.toString();
    }

    /**
     * Método que clona um objeto do tipo Amador
     * 
     * @return
     */
    public Utilizador clone() {
        return new Utilizador(this);
    }

    /**
     * Adiciona um plano de Treino na lista de planos de Treino
     * 
     * @param p
     */
    public void adicionarPlanoTreino(PlanoTreino p) {
        this.planosTreino.add(p.clone());
    }

    /**
     * Adiciona um atividade na lista de atividades
     * 
     * @param atividade
     */
    public void adicionarAtividade(Atividade atividade) {
        this.atividades.add(atividade.clone());
    }

    /**
     * Associa as atividades ao valor do seu gasto calórico
     * 
     * @return
     */
    public Map<Atividade, Double> calculacaloriasAtividade() {
        Map<Atividade, Double> resultado = new HashMap<>();
        double gastoCalorico = 0.0;
        double caloriasAtividade = 0.0;
        if (this instanceof Profissional) {
            gastoCalorico = ((Profissional) this).getGastoCalorico();
        } else if (this instanceof Amador) {
            gastoCalorico = ((Amador) this).getGastoCalorico();
        } else if (this instanceof PraticanteOcasional) {
            gastoCalorico = ((PraticanteOcasional) this).getGastoCalorico();
        }

        for (Atividade atividade : atividades) {

            if (atividade instanceof Distancia) {
                Distancia distancia = (Distancia) atividade;
                caloriasAtividade = distancia.calculaCalorias() * gastoCalorico;
            } else if (atividade instanceof Repeticoes) {
                Repeticoes repeticoes = (Repeticoes) atividade;
                caloriasAtividade = repeticoes.calculaCalorias() * gastoCalorico;
            }

            resultado.put(atividade, caloriasAtividade);
        }
        return resultado;
    }

    /**
     * Associa os planos de treino ao valor do seu gasto calórico
     * 
     * @param planosTreino
     * @return
     */
    public Map<PlanoTreino, Double> calculaCaloriasPlanoTreino(double gastoCalorico, List<PlanoTreino> planosTreino) {
        Map<PlanoTreino, Double> resultados = new HashMap<>();

        for (PlanoTreino plano : planosTreino) {
            double totalCalorias = plano.totalCalorias() * this.getGastoCalorico();
            resultados.put(plano, totalCalorias);
        }

        return resultados;
    }
    
    public Object toStringLog() {
        StringBuilder sb = new StringBuilder();
        sb.append("Utilizador:").append(this);
        return sb.toString();
    } 
    public double getGastoCalorico() {
        return 1;
    }
}
