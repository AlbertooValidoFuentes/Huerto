import com.simuladorhuerto.huerto.Huerto;
import com.simuladorhuerto.clases.Consumidor;
import com.simuladorhuerto.clases.Granjero;

public class Main {
    public static void main(String[] args) {

        Huerto huerto = new Huerto(5);

        Granjero granjero = new Granjero("Alberto", 5, 5,huerto);
        Consumidor consumidor = new Consumidor("Joel", 5, 5, huerto);
        
        granjero.setPriority(10);

        granjero.start();
        consumidor.start();

    }
}