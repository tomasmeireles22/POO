import java.lang.StringBuilder;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;

public class Menu {
    // Menu inicial onde vai ser o que aparece no inicio do programa
    // para se fazer as varias opcoes
    public int mInicial() {
        StringBuilder sb = new StringBuilder("######### MENU INICIAL #########\n\n");
        sb.append("1) Registar utilizador.\n");
        sb.append("2) Iniciar sessão.\n");
        sb.append("3) Registar plano de treino.\n");
        sb.append("4) Salvar ficheiro\n");
        sb.append("5) Carregar ficheiro\n");
        sb.append("0) Sair.\n\n");
        sb.append("Selecione a opcao pretendida: ");
        System.out.println(sb.toString());
        Scanner scanner = new Scanner(System.in);
        {
            return scanner.nextInt();
        }
    }

    /**
     * Menu para registar um utilizador novo
     * 
     * @return Array de strings com os dados do utilizador
     */
    public String[] mRegistarUsuario() {
        Scanner scanner = new Scanner(System.in);
        String[] input = new String[9];

        System.out.println("Registar Utilizador");
        System.out.print("Nome: ");
        input[0] = scanner.nextLine();

        System.out.print("Email: ");
        input[1] = scanner.nextLine();

        System.out.print("Morada: ");
        input[2] = scanner.nextLine();

        System.out.print("Idade: ");
        input[3] = scanner.nextLine();

        System.out.print("Peso: ");
        input[4] = scanner.nextLine();

        System.out.print("Altura: ");
        input[5] = scanner.nextLine();

        System.out.print("Genero: ");
        input[6] = scanner.nextLine();

        System.out.print("Frequencia Cardiaca: ");
        input[7] = scanner.nextLine();

        System.out.print("Tipo de Utilizador (1-Amador, 2-Ocasional, 3-Profissional):");
        input[8] = scanner.nextLine();

        scanner.close();
        return input;
    }

    /**
     * Escolhe um utilizador
     * 
     * @return
     */

    /**
     * Permite registar Atividades
     * 
     * @return
     */
    

    /**
     * Permite registar os Planos de Treino
     * 
     * @return
     */

    public ArrayList<String[]> mRegistarPlanoDeTreino() {
        ArrayList<String[]> input = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Boolean ciclo = true;

        System.out.println("Registar Plano de treino");
        while (ciclo) {
            String[] infoAtividade = new String[5];
            System.out.println(
                    "Se a atividade envolver distancia clicar 1, se envolver repetições clicar 2 caso queria terminar o plano de treino pressionar 0:");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 0:
                    ciclo = false;
                    break;
                case 1:
                    infoAtividade[0] = "Distancia";
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    infoAtividade[1] = scanner.nextLine();

                    System.out.print("Duração do exercicio (minutos): ");
                    infoAtividade[2] = scanner.nextLine();

                    System.out.print("Distância: ");
                    infoAtividade[3] = scanner.nextLine();

                    System.out.print("Altimetria: ");
                    infoAtividade[4] = scanner.nextLine();
                    input.add(infoAtividade);
                    break;

                case 2:
                    infoAtividade[0] = "Repeticoes";
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    infoAtividade[1] = scanner.nextLine();

                    System.out.print("Duração do exercicio (minutos): ");
                    infoAtividade[2] = scanner.nextLine();

                    System.out.print("Quantidade de Peso: ");
                    infoAtividade[3] = scanner.nextLine();

                    System.out.print("Numero de Repetições: ");
                    infoAtividade[4] = scanner.nextLine();
                    input.add(infoAtividade);
                    break;
                default:
                    System.out.print("Opcao invalida");
                    break;

            }

        }

        scanner.close();
        return input;
    }
    public int mDoUtilizador (){
        StringBuilder sb = new StringBuilder("######### MENU LOGIN #########\n\n");
        sb.append("1) Informação sobre o utilizador.\n");
        sb.append("2) Criar plano de treino.\n");
        sb.append("3) Utilizar plano de treino.\n");
        sb.append("4) Criar atividade\n");
        sb.append("7) CaloriasATividade\n");
        sb.append("6) Estatísticas.\n");
        sb.append("8) Salvar ficheiro\n");
        sb.append("9) Carregar ficheiro\n");
        sb.append("0) Sair.\n\n");
        sb.append("Selecione a opcao pretendida: ");
        System.out.println(sb.toString());
        Scanner scanner = new Scanner(System.in);
        {
            return scanner.nextInt();
        }
    }

    public int mIdPlanoTreino(){
        System.out.println("Indique o Id do plano de Treino:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    
    public int mLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indique o Id do Utilizador");
        System.out.print("Numero de Id: ");
        return scanner.nextInt();
    }

    public int mLoginError(){
        System.out.println("O Id Oferecido é invalido, indique um valido:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
    
    public void mToStringUtilizador (String info){
        System.out.println(info);
    }
    
    public ArrayList<String[]> mRegistarAtividade() {
        ArrayList<String[]> input = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Boolean ciclo = true;
        
        System.out.println("Registar Atividade");
        while (ciclo) {
            String[] infoAtividade = new String[5];
            System.out.println(
                    "Se a atividade envolver distancia clicar 1, se envolver repetições clicar 2 caso queria terminar o plano de treino pressionar 0:");
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 0:
                    ciclo = false;
                    break;
                case 1:
                    infoAtividade[0] = "Distancia";
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    infoAtividade[1] = scanner.nextLine();

                    System.out.print("Duração do exercicio (minutos): ");
                    infoAtividade[2] = scanner.nextLine();

                    System.out.print("Distância: ");
                    infoAtividade[3] = scanner.nextLine();

                    System.out.print("Altimetria: ");
                    infoAtividade[4] = scanner.nextLine();
                    input.add(infoAtividade);
                    break;
                case 2:
                    infoAtividade[0] = "Repeticoes";
                    scanner.nextLine();
                    System.out.print("Nome: ");
                    infoAtividade[1] = scanner.nextLine();

                    System.out.print("Duração do exercicio (minutos): ");
                    infoAtividade[2] = scanner.nextLine();

                    System.out.print("Quantidade de Peso: ");
                    infoAtividade[3] = scanner.nextLine();

                    System.out.print("Numero de Repetições: ");
                    infoAtividade[4] = scanner.nextLine();
                    input.add(infoAtividade);
                    break;
                default:
                    System.out.print("Opcao invalida");
                    break;
                
            }

        }
        scanner.close();
        return input;
    }
    
    public void mCalculoAtiv(Map<Atividade, Double> calorias) {
        for (Map.Entry<Atividade, Double> entry : calorias.entrySet()) {
            System.out.println("Atividade: " + entry.getKey() + ", Calorias gastas: " + entry.getValue());
        }
    }
    
    public void mCalculoPlano(String s) {
        System.out.println(s);
    }
}
    