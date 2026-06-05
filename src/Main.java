

public class Main {

    public static void main(String[] args) throws java.io.IOException {
        Modelo modelo = new Modelo();
        Menu menu = new Menu();
        Controlador controlador = new Controlador(modelo, menu);
        try
        {
            controlador.run();
        }
        catch (ClassNotFoundException cnfe)
        {
            cnfe.printStackTrace();
        }

    }
}
