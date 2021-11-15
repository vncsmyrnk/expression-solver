package Pilha;

public class Pilha<T> {
        public ElementoPilha<T> topo;

        public Pilha() {
            topo = new ElementoPilha<T>(null);
        }

        public void push(T novoItem) {
            ElementoPilha<T> elemento = new ElementoPilha<T>(novoItem); 
            elemento.proximo = topo.proximo;
            topo.proximo = elemento;
        }

        public T pop() {
            if(pilhaVazia())
                return null;
            else{
                ElementoPilha<T> aux = topo.proximo;
                topo.proximo = aux.proximo;
                aux.proximo = null;
                return aux.elemento;
            }
        }

        public T peek() {
            if (pilhaVazia()) 
                return null;
            else 
                return topo.proximo.elemento;
        }

        public boolean pilhaVazia(){
            return (topo.proximo == null);
        }

        public void print() {
            ElementoPilha<T> aux = this.topo.proximo;
            while (aux != null) {
                System.out.print(aux.elemento.toString() + " | ");
                aux = aux.proximo;
            }
            System.out.println();
        }
    }