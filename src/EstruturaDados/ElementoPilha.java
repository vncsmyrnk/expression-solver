package EstruturaDados;

public class ElementoPilha<T> {

        public T elemento;
        public ElementoPilha<T> proximo;

        public ElementoPilha(T elemento){
            this.elemento = elemento;
            this.proximo = null;
        }
}



