import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;

public class Modelo implements Serializable {

    // variáveis de instância
    private Map<Integer, Utilizador> utilizadores = new HashMap<Integer, Utilizador>();
    private int nrUtilizadores;
    private Map<Integer, PlanoTreino> planosTreino = new HashMap<Integer, PlanoTreino>();
    private int nrPlanosTreino;
    /**
     * Construtor para objetos da classe Modelo
     */

      public Modelo() {
        this.utilizadores = new HashMap<Integer, Utilizador>();
        this.nrUtilizadores = 0;
        this.planosTreino = new HashMap<Integer, PlanoTreino>();
        this.nrPlanosTreino = 0;
    }

    /**
     * Método para adicionar um Utilizador
     * 
     * @param nome
     * @param email
     * @param morada
     * @param idade
     * @param peso
     * @param altura
     * @param genero
     * @param freqCardiaca
     * @param planosTreino
     * @param atividades
     */
    public void addUtilizador(String nome, String email, String morada, int idade, float peso, int altura,
            String genero, int freqCardiaca, int tipo) {
        List<PlanoTreino> planosTreinos = new ArrayList<>();
        List<Atividade> atividades = new ArrayList<>();
        switch (tipo) {
            case 1:
                utilizadores.put(nrUtilizadores, new Amador(nrUtilizadores, nome, email, morada, idade, peso, altura,
                        genero, freqCardiaca, planosTreinos, atividades));
                break;
            case 2:
                utilizadores.put(nrUtilizadores, new PraticanteOcasional(nrUtilizadores, nome, email, morada, idade,
                        peso, altura, genero, freqCardiaca, planosTreinos, atividades));
                break;
            case 3:
                utilizadores.put(nrUtilizadores, new Profissional(nrUtilizadores, nome, email, morada, idade, peso,
                        altura, genero, freqCardiaca, planosTreinos, atividades));
            default:
                return;

        }
        utilizadores.put(nrUtilizadores, new Utilizador(nrUtilizadores, nome, email, morada, idade, peso, altura,
                genero, freqCardiaca, planosTreinos, atividades));
        nrUtilizadores++;

        // Debug - Remover Futuramente
        System.out.println(utilizadores.get(nrUtilizadores - 1).toString());
    }

    public void addPlanoTreino(ArrayList<String[]> planoTreino) {
        PlanoTreino novo = new PlanoTreino();
        novo.setId(String.valueOf(nrPlanosTreino));
        for (String[] atividade : planoTreino) {
            if (atividade[0] == "Repeticoes") {
                novo.adicionarAtividade(new Repeticoes(atividade[1], Float.parseFloat(atividade[2]),
                        Integer.parseInt(atividade[3]), Integer.parseInt(atividade[4])));
            }
            if (atividade[0] == "Distancia") {
                novo.adicionarAtividade(new Distancia(atividade[1], Float.parseFloat(atividade[2]),
                        Double.parseDouble(atividade[3]), Integer.parseInt(atividade[4])));
            }
        }

        planosTreino.put(nrPlanosTreino, novo);
        nrPlanosTreino++;
        // Debug - Remove Later
        System.out.println(novo.toString());
    }
    
    public PlanoTreino addPlanoTreinoUtilizador (int idUtilizador,int idPlanoTreino){
        if (planosTreino.containsKey(idPlanoTreino)){
            Utilizador utilizador = utilizadores.get(idUtilizador);
            utilizador.adicionarPlanoTreino(planosTreino.get(idPlanoTreino));
            return planosTreino.get(idPlanoTreino);
        }
        else {
            return null;
        }
    }    
    
    public Map<Integer, Utilizador> getUtilizadores() {
        return this.utilizadores;
    }
    
    public Utilizador login (int id){
        if (utilizadores.containsKey(id)){
            return utilizadores.get(id);
        }
        else {
            return null;
        }
    }
    
    public String infoUtilizador(int idUtilizador){
        Utilizador utilizador = utilizadores.get(idUtilizador);
        return utilizador.toString();
    }
    
    
    public Map<Integer, PlanoTreino> getPlanosTreino() {
        return this.planosTreino;
    }
    
    public void addAtividade(int idUtilizador, ArrayList<String[]> ati){
        Utilizador utilizador = utilizadores.get(idUtilizador);
        if(utilizador == null){
            return;
        }
        for (String[] atividade : ati) {
            if (atividade[0] == "Repeticoes") {
            utilizador.adicionarAtividade(new Repeticoes(atividade[1], Float.parseFloat(atividade[2]),
                    Integer.parseInt(atividade[3]), Integer.parseInt(atividade[4])));
            }
            if (atividade[0] == "Distancia") {
            utilizador.adicionarAtividade(new Distancia(atividade[1], Float.parseFloat(atividade[2]),
                    Double.parseDouble(atividade[3]), Integer.parseInt(atividade[4])));
            }
        }
    }
    
    public Map<Atividade,Double> caloriasAtiv(int idUtilizador,int idAtividade){
        Map<Atividade,Double> res =  new HashMap<Atividade, Double>();
        Utilizador u=utilizadores.get(idUtilizador);
        return u.calculacaloriasAtividade();
    }
    
    public String planoTreinolog() {
        StringBuilder sb = new StringBuilder();
        for (HashMap.Entry<Integer, PlanoTreino> entry : this.planosTreino.entrySet()) {
            sb.append(entry.getValue().toString());
            sb.append("\n");
        }
        return sb.toString();
    }
    
     public String utilizadoresLog() {
        StringBuilder sb = new StringBuilder();
        for (HashMap.Entry<Integer, Utilizador> entry : this.utilizadores.entrySet()) {
            sb.append(entry.getValue().toStringLog());
            sb.append("\n");
        }
        return sb.toString();
    }
    
    public Map<PlanoTreino,Double> infoPlano(int idUtilizador){
        Utilizador utilizador = utilizadores.get(idUtilizador);
        double gastoCalorico = 0.0;
        return utilizador.calculaCaloriasPlanoTreino(utilizador.getGastoCalorico(), utilizador.getPlanosTreino());
    }
    
    public Map<Atividade,Double> infoAtividade(int idUtilizador){
        Utilizador utilizador = utilizadores.get(idUtilizador);
        System.out.println(utilizador.getGastoCalorico());
        return utilizador.calculacaloriasAtividade();
    }
}

