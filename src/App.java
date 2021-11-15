import PosFixa.Resolvedor;

public class App {
    public static void main(String[] args) throws Exception {
        String expressao = "3+2/5+3";
        System.out.println(expressao + " = " + Resolvedor.resolver(expressao));
        // int resultado = Resolvedor.resolver(expressao);
        // System.out.println("Resultado: " + resultado);
    }
}
