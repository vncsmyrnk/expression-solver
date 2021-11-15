import PosFixa.Resolvedor;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite uma expressão (Formato exemplo: \"3+2/5+3\").");
        String expressao = sc.nextLine();
        Double resultado = Resolvedor.resolver(expressao);
        System.out.println(resultado);
        sc.close();
    }
}
