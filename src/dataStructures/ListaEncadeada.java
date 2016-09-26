package datastructures;

public class ListaEncadeada<T> implements Iterable<T> {
	class ListaIterator implements Iterator<T> {
		private No<T> atual;
		private ListaEncadeada<T> container;

		public ListaIterator(ListaEncadeada<T> lista) {
			atual = null;
			container = lista;
		}

		public boolean hasNext() {
			return atual == null || atual.getProximo() != null;
		}

		public T next() {
			if (atual == null)
				atual = head;
			else
				atual = atual.getProximo();
			if (atual == null) {
				String msg = "List is empty.";
				throw new IllegalStateException(msg);
			}
			return atual.getValor();
		}

		public void append(T valor) {
			if (atual == null) {
				String msg = "Use next() before using an iterator.";
				throw new IllegalStateException(msg);
			}
			No<T> no = new No<>(valor);
			No<T> anterior = atual;
			No<T> proximo = atual.getProximo();
			no.setProximo(proximo);
			no.setAnterior(anterior);
			anterior.setProximo(no);
			if (proximo == null) {
				container.tail = no;
			} else {
				proximo.setAnterior(no);
			}

		}

		@Override
		public void insert(T valor) {
			if (atual == null) {
				String msg = "Use next() before using an iterator.";
				throw new IllegalStateException(msg);
			}
			No<T> no = new No<>(valor);
			No<T> anterior = atual.getAnterior();
			
			no.setProximo(atual);
			no.setAnterior(anterior);
			atual.setAnterior(no);
			if (anterior == null){
				head = no;	
			} else{
				anterior.setProximo(no);
			}
		}

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

	}

	private No<T> head;
	private No<T> tail;

	public void append(T valor) {
		No<T> no = new No<>(valor);

		if (head == null) {
			this.head = no;
		} else {
			no.setAnterior(tail);
			tail.setProximo(no);
		}
		tail = no;
	}

	public java.util.Iterator<T> iterator() {
		return new ListaIterator(this);
	}

	public void addFirst(T valor) {
		No<T> no = new No<>(valor);
		No<T> proximo = head;
		if (proximo == null) {
			tail = no;
		} else {
			no.setProximo(proximo);
		}
		head = no;
	}
	public boolean isEmpty(){
		if (head==null){
			return true;
		}else{
			return false;
		}
	}

	
	public T getLast(){
		return tail.getValor();
	}
	/**
	 * Main, que um dia morrera...
	 *//*
	public static void main(String[] args) {
		ListaEncadeada<Integer> lista = new ListaEncadeada<>();
		lista.append(1);
		lista.append(2);
		lista.append(3);
		ListaEncadeada<Integer>.ListaIterator i;
		i = (ListaEncadeada<Integer>.ListaIterator) lista.iterator();
		while (i.hasNext())
			System.out.println(i.next());
		for (Integer o : lista)
			System.out.println(o);
		i = (ListaEncadeada<Integer>.ListaIterator) lista.iterator();
		i.next();
		i.append(50);
		i = (ListaEncadeada<Integer>.ListaIterator) lista.iterator();
		while (i.hasNext())
			System.out.println(i.next());
	}
*/
	public void removeLast() {
		if(tail == null){
			return;
		}
		if(head == tail){
			tail = head = null;
		}else{
			No <T> anterior = tail.getAnterior();
			tail = anterior;
			tail.setProximo(null);
		}
		
	}
}
