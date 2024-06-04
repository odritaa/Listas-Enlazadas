public class Nodo {
	int dato; // Dato a guardar.
	Nodo nodoSig; // Nodo siguiente.

	/**
	 * Instanciar un nodo sin valores.
	 */
	public Nodo(){}

	/**
	 * Instanciar un nodo solo con su dato.
	 * @param d Dato a guardar.
	 */
	public Nodo(int d) {
		this.dato= d;
		this.nodoSig= null;
	}

	/**
	 * Instanciar un nodo sabiendo el nodo siguiente
	 * @param d Dato a guardar
	 * @param n Nodo siguiente
	 */
	public Nodo(int d, Nodo n) {
		dato=d;
		nodoSig = n;
	}

	@Override
	public String toString() {
		return "Nodo{" +
				"dato=" + dato +
				", nodoSig=" + nodoSig +
				'}';
	}
}
