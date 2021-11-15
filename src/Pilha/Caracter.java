package Pilha;

public class Caracter {
    private char valor;

    public Caracter(char valor) {
        this.valor = valor;
    }

    public char getValor() {
        return this.valor;
    }

    public boolean ehOperando() {
        return Character.isDigit(this.valor);
    }

    public boolean ehOperador() {
        return !this.ehOperando();
    }

    public boolean possuiPrioridadeMaiorQue(Caracter c) {
        return this.getPrioridade() > c.getPrioridade();
    }

    public boolean possuiPrioridadeMaiorOuIgualQue(Caracter c) {
        return this.getPrioridade() >= c.getPrioridade();
    }

    public boolean possuiPrioridadeMenorQue(Caracter c) {
        return this.getPrioridade() > c.getPrioridade();
    }

    public String toString() {
        return String.valueOf(this.valor);
    }

    public Double toDouble() {
        if (this.ehOperador()) {
            return 0.0;
        }
        return Double.parseDouble(Character.toString(this.valor));
    }

    public int getPrioridade() {
        if (!this.ehOperador()) {
            return -1;
        }

        switch (this.valor) {
            case '(':
                return 0;
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            default:
                return -1;
        }
    }
}
