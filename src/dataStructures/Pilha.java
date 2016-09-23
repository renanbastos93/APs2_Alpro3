package datastructures;

public class Pilha <T>{

	//static ListaEncadeada pilha;
	private ListaEncadeada<T> pilha = new ListaEncadeada<>();
	 
	public void push (T valor){
		//ListaEncadeada pilha = new ListaEncadeada();		
		pilha.append(valor);
				
	}
	public boolean isEmpty(){
		if (pilha.isEmpty()){
			return true;
		}else{
			return false;
		}
	}
	
	public T peek(){
		return pilha.getLast();	
	}
	
	public T pop(){
		T topo = peek();
		pilha.removeLast();
		return topo;
	}
}



