package PosFixa;

import Pilha.*;

public class Resolvedor {
    public static double resolver(String expressao) {
        String expressaoPosFixa = transformaEmPosFixa(expressao);
        Pilha<Double> pilhaOperandos = new Pilha<Double>();
        for (int i=0; i<expressaoPosFixa.length(); i++) {
            Caracter caracter = new Caracter(expressaoPosFixa.charAt(i));
            if (caracter.ehOperando()) {
                pilhaOperandos.push(caracter.toDouble());
                continue;
            }

            Double segundoOperando = pilhaOperandos.pop();
            Double primeiroOperando = pilhaOperandos.pop();
            Double resultado = resolveOperacao(primeiroOperando, segundoOperando, caracter.getValor());
            pilhaOperandos.push(resultado);
        }

        return pilhaOperandos.peek();
    }

    public static String transformaEmPosFixa(String expressao) {
        String posFixa = "";
        Pilha<Caracter> pilhaOperadores = new Pilha<Caracter>();
        for (int i=0; i<expressao.length(); i++) {
            Caracter caracter = new Caracter(expressao.charAt(i));
            // System.out.println("'" + caracter.getValor() + "'" + "/" + caracter.ehOperador());
            
            if (caracter.ehOperando()) {
                posFixa += caracter.getValor();
                continue;
            }

            Caracter topoPilha = pilhaOperadores.peek();
            if (topoPilha == null || caracter.possuiPrioridadeMenorQue(topoPilha)) {
                pilhaOperadores.push(caracter);
                continue;
            }

            Caracter novoTopoPilha = pilhaOperadores.pop();
            while (novoTopoPilha != null && novoTopoPilha.possuiPrioridadeMaiorOuIgualQue(caracter)) {
                posFixa += novoTopoPilha.getValor();
                novoTopoPilha = pilhaOperadores.pop();
            }

            pilhaOperadores.push(caracter);
        }

        Caracter novoTopoPilha = pilhaOperadores.pop();
        while (novoTopoPilha != null) {
            posFixa += novoTopoPilha.getValor();
            novoTopoPilha = pilhaOperadores.pop();
        }
        
        return posFixa;
    }

    public static Double resolveOperacao(Double primeiroValor, Double segundoValor, char operacao) {
        switch (operacao) {
            case '+':
                return primeiroValor + segundoValor;
            case '-':
                return primeiroValor - segundoValor;
            case '*':
                return primeiroValor * segundoValor;
            case '/':
                return primeiroValor / segundoValor;
            default:
                return 0.0;
        }
    }
}
