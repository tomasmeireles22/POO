import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.Map;

public class Controlador {
    // variáveis de instância
    private Modelo modelo;
    private Menu view;

    /**
     * Construtor parametrizado
     * 
     * @param modelo Modelo que será usado pelo controlador
     */
    public Controlador(Modelo modelo, Menu view) {
        this.modelo = modelo;
        this.view = view;
    }

    public void login() throws ClassNotFoundException, IOException {
        int inputId = this.view.mLogin();
        this.modelo.login(inputId);

        while (this.modelo.login(inputId) == null) {
            inputId = this.view.mLogin();
        }
        opcoesUtilizador(inputId);
    }

    /**
     * Método para adicionar um utilizador
     */
    public void addUtilizador() {
        String[] inputUtilizador = this.view.mRegistarUsuario();
        this.modelo.addUtilizador(inputUtilizador[0], inputUtilizador[1], inputUtilizador[2],
                Integer.parseInt(inputUtilizador[3]), Float.parseFloat(inputUtilizador[4]),
                Integer.parseInt(inputUtilizador[5]),
                inputUtilizador[6], Integer.parseInt(inputUtilizador[7]), Integer.parseInt(inputUtilizador[8]));
    }

    /**
     * Método para adicionar PlanosTreino
     */
    public void addPlanoTreino() {
        ArrayList<String[]> planoTreino = this.view.mRegistarPlanoDeTreino();
        this.modelo.addPlanoTreino(planoTreino);
    }

    /**
     * 
     * @throws IOException
     */
    public void run() throws ClassNotFoundException, IOException {
        while (true) {
            int opcao = this.view.mInicial();
            switch (opcao) {
                case 0:
                    return;
                case 1:
                    this.addUtilizador();
                    break;
                case 2:
                    this.login();
                    break;
                case 3:
                    this.addPlanoTreino();
                    break;
                case 4:
                    this.salvar();
                    break;
                case 5:
                    this.carregar();
                    break;
                default:
                    break;
            }
        }
    }

    /**
     * dá save da informação do programa
     * 
     * @throws IOException
     */

    public void opcoesUtilizador(int idUtilizador) throws ClassNotFoundException, IOException {
        while (true) {
            int opcao = this.view.mDoUtilizador();
            switch (opcao) {
                case 0:
                    return;
                case 1:
                    infoUtilizador(idUtilizador);
                    break;
                case 2:
                    addPlanoTreino();
                    break;
                case 3:
                    addPlanoTreinoUtilizador(idUtilizador);
                    break;
                case 4:
                    addAtividade(idUtilizador);
                    break;
                case 6:
                    infoPlano(idUtilizador);
                    break;
                case 7:
                    infoAtividade(idUtilizador);
                    break;
                case 8:
                    this.salvar();
                    break;
                case 9:
                    this.carregar();
                    break;
                default:
                    break; 
            }
        }
    }

    public void addPlanoTreinoUtilizador(int idUtilizador) throws ClassNotFoundException, IOException {
        int inputId = this.view.mIdPlanoTreino();

        while (this.modelo.addPlanoTreinoUtilizador(idUtilizador, inputId) == null) {
            inputId = this.view.mIdPlanoTreino();
        }
        opcoesUtilizador(inputId);
    }

    public void infoUtilizador(int infoUtilizador) throws ClassNotFoundException, IOException {
        String info = this.modelo.infoUtilizador(infoUtilizador);
        this.view.mToStringUtilizador(info);
        opcoesUtilizador(infoUtilizador);
    }
    
    public void addAtividade(int idUtilizador) {
        ArrayList<String[]> atividade = this.view.mRegistarAtividade();
        this.modelo.addAtividade(idUtilizador, atividade);
    }

    public void carregar() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("Info.obj");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Modelo modelo = (Modelo) ois.readObject();
        ois.close();
        this.modelo = modelo;
    }

    // E no save mudam para guardar o modelo apenas
    public void salvar() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("Info.obj"));
        oos.writeObject(this.modelo);
        oos.flush();
        oos.close();
    }
    /*
    public void infoAtiv(int idUtilizador){
        this.view.mCalculoPlano(this.modelo.caloriasAtiv(idUtilizador));
    }*/
    
    public void infoPlano(int idUtilizador){
        StringBuilder sb = new StringBuilder();
           for (Map.Entry<PlanoTreino, Double> entry : this.modelo.infoPlano(idUtilizador).entrySet()) {
            sb.append("Plano de Treino: " + entry.getKey() + ", Calorias gastas: " + entry.getValue());
        }
           this.view.mCalculoPlano(sb.toString());
    }
    
    public void infoAtividade(int idUtilizador){
        StringBuilder sb = new StringBuilder();
           for (Map.Entry<Atividade, Double> entry : this.modelo.infoAtividade(idUtilizador).entrySet()) {
            sb.append("Atividade: " + entry.getKey() + ", Calorias gastas: " + entry.getValue());
        }
           this.view.mCalculoPlano(sb.toString());
    }
}
