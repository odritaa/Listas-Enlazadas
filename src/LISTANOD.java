import java.util.Scanner;


public class LISTANOD {
	/*
		Atributos
	 */
	Scanner scanner= new Scanner(System.in);
	protected Nodo inicio,fin; //punteros para saber donde este el inicio y el fin
	int cont = 0; // Contador que indica el numero de elementos.

	/*
		Metodos
	 */
	public LISTANOD() {
		inicio= null;
		fin= null;
	}

	/**
	 * Metodo para insertar un elemento al inicio.
	 * @param elemento Dato almacenado en el nodo.
	 */
	public void insertarElemInicio(int elemento) {
		if(noRepeat(elemento)) {
		    inicio = new Nodo(elemento, inicio); // Se crea el nodo en el comienzo
		    if (fin==null) {  // si el fin es null significa que inicio y fin es lo mismo
		    	fin= inicio;
		    }
		    cont++; // Se incrementa el contador.
		}else {
			System.out.println("EL ELEMENTO QUE DESEA INGRESAR YA ESTA EN LA LISTA. ");
		}
	}

	/**
	 * Metodo para insertar al final de la lista
	 * @param elemento Dato almacenado en el nodo.
	 */
	public void insertarElemfinal(int elemento) {
		if (noRepeat(elemento)) {
			
			if (!estaVacia()) { // Si la lista no esta vacia continua.
				fin.nodoSig= new Nodo(elemento);  // El fin previo ahora apunta a nuestro nuevo nodo.
				fin= fin.nodoSig; // Nuestro nodo es el nodo final.
			}
			else {
				inicio = fin = new Nodo(elemento); // Si la lista esta vacia inicio = fin.
			}
			cont++; // Se incrementa el contador.
	
		   }
		else {System.out.println("EL ELEMENTO QUE DESEA INGRESAR YA ESTA EN LA LISTA.");}
		}
	/**
	 * METODO PARA INGRESAR EN LA POSICION QUE SE DESEE
	 */
	public void insertarElem() {
		System.out.println("INGRESE EL DATO QUE DESEA INGRESAR: ");
		int datoIng= scanner.nextInt();
		scanner.nextLine();
		Nodo y= new Nodo(datoIng);
		if (noRepeat(datoIng)) { // si el dato no esta repetido
			System.out.println("INGRESE EL DATO A SEGUIR:");
			int pos= scanner.nextInt(); 
			scanner.nextLine();
			if(!noRepeat(pos)) { // si el dato esta en la lista
				Nodo x = inicio;
				while(x != null) { // se recorre la lista
					if(x.nodoSig != null) {
						if(x == inicio && x.dato == pos) {
							insertarElemInicio(datoIng);
						} else if(x.nodoSig.dato== pos){ // si el dato del nodo siguiente es igual al pedido para posicionar
							y.nodoSig= x.nodoSig; // y seguira al nodo siguiente x
							x.nodoSig= y; // x seguira a y
							break;
						}
					}
					x = x.nodoSig;
				}
			} else {
				System.out.println("EL DATO INGRESADO PARA POSICIONAR NO ESTABA EN LA LISTA. SE INGRESARA AL COMIENZO.");
				insertarElemInicio(datoIng);
			}
		} else {
			System.out.println("EL DATO YA SE ENCUENTRA EN LA LISTA");
		}
		mostrarListaNod(this);
	}

	/**
	 * METODO PARA VER SI UN ELEMENTO YA ESTA EN LA LISTA
	 * @param x
	 * @return False = Elemento ya esta en la lista. True = Elemento no esta en la lista.
	 */
	public boolean noRepeat(int x) {
		
		Nodo recorrer= inicio;   // El recorrer empieza en el inicio de la lista.
		while(recorrer != null) {  // mientras recorrer no este vacio
			if(x== recorrer.dato) {
			   return false;
			}	
			recorrer= recorrer.nodoSig; // recorrer pasa a nodo siguiente y repite hasta que este vacio
		}
		return true;
	}
	
	/**
	 * Muestra la lista.
	 * @param nod Sirve para multiples listanod.
	 */
	public void mostrarListaNod(LISTANOD nod) {
		Nodo recorrer= nod.inicio;   // El recorrer empieza en el inicio de la lista.
		while(recorrer != null) {  // mientras recorrer no este vacio
			if (recorrer.nodoSig == null){ // Si el nodo siguiente de recorrer es null. Este es el final.
				System.out.println(recorrer.dato);
			} else{ // En caso contrario sigue a otro nodo.
				System.out.print(recorrer.dato + " ---> ");
			}
			recorrer= recorrer.nodoSig; // recorrer pasa a nodo siguiente y repite hasta que este vacio
		}
	}

	/**
	 * metodo para saber si la lista esta  vacia
	 * @return Vacia = True. noVacia = False.
	 */
	 public boolean estaVacia(){
		 return inicio == null;
	}

	/**
	 * Metodo para vaciar la lista.
	 */
	public void vaciar(){
		inicio = null; // Para vaciarla ni inicio ni fin son nodos.
		fin = null;
		cont = 0; // Y como no hay elementos el cont es 0.
	}

	/**
	 * Metodo para eliminar un nodo al inicio
	 */
	public void eliminarElemAlinicio() {
		System.out.println("Este es el elemento que estaba al inicio: " + inicio.dato); // El elemento es el dato que tiene el nodo inicio
		if(inicio==fin) { // Si el nodo inicio y nodo son lo mismo significa los vaciamos
			inicio=null;
			fin=null;
			cont = 0;
		}
		else {
			inicio= inicio.nodoSig;  //si el nodo inicio no es igual al nodo fin es porque hay mas nodos.
			cont--; // Se disminuye el contador.
		}

	}

	/**
	 * Metodo para eliminar un nodo al final
	 */
	public void eliminarElemAlFin() {
		System.out.println("El elemento al final era: " + fin.dato); //el elemento es el dato que tiene el nodo inicio.
		if(inicio==fin) { // si el nodo inicio y nodo son lo mismo significa los vaciamos.
			inicio=null;
			fin= null;
			cont = 0;
		}
		else {
			Nodo temporal= inicio; //creamo un nodo temporal para el inicio para que recorra la lista.
			while(temporal.nodoSig != fin) { // mientras el nodo temporal de siguiente no sea el nodo final.
				temporal = temporal.nodoSig; // temporal va a ser el temporal de siguiente.
			}
			fin = temporal; // ya aca el temporal es el nodo fin.
			fin.nodoSig = null; // por lo tanto el nodo fin de nodo siguiente es null porque lo estamos eliminando.
			cont--; // El contador se disminuye.
		}
	}
	/**
	 * Metodo para eliminar un elemento especifico.
	 * @param elemento Dato que se busca.
	 */
	public void eliminarElemEspecifico(int elemento) {
		if (!estaVacia()) { // si la lista no esta vacia
			if (inicio== fin && elemento == inicio.dato) { // si nodo inicio es igual a nodo fin y el elemento es igual al dato de nodo incio ya lo encontre y se borra
				inicio= null;
				fin= null;
				cont = 0;
			}
			else if (elemento == inicio.dato) {  // si el elemento esta en el dato del primer nodo ya lo encontramos
				inicio= inicio.nodoSig; // inicio toda el valor del nodo siguiente
				cont--;
			}
			else {
				Nodo anterior,temporal;
				anterior= inicio; // el anterior apunta al inicio
				temporal= inicio.nodoSig; // el temporal apunta al nodo siguiente

				while(temporal!= null && temporal.dato != elemento) { // mientras el temporal no sea nulo y temporal de dato no sea el elemento que buscamos
					anterior = anterior.nodoSig; // anterior va a ser el nodo siguiente
					temporal= temporal.nodoSig; // y temporal tambien va a ser el nodo siguiente
     			}
				if (temporal != null) {  //si el temporal no es nulo es porque se encontro el elemento
					anterior.nodoSig= temporal.nodoSig;  // el anterior de siguiente es igual al temporal de siguiente
					if(temporal== fin) {  // si el temporal es igual al nodo fin
						fin= anterior; // el anterior es el elemento a eliminar
					}
					cont--; // Disminuye el contador.
				} else{
					System.out.println("No se encontro el elemento.");
				}
			}
		} else {
			System.out.println("La lista estaba vacia mae.");
		}
	}

	/**
	 * Metodo para buscar un elemento especifico.
	 * @param elemento2 Elemento que se busca
	 * @return Devuelve el nodo.
	 */
	public Nodo localizarElem(int elemento2) {
		Nodo temporal= inicio; // el nodo temporal es el inicio de la lista para recorrer la lista
		while(temporal!= null && temporal.dato != elemento2) { // si el temporal es diferente de null y el dato del nodo temporal es diferente del elemeento que se busca
			temporal= temporal.nodoSig;// entonces temporal pasa a ser el siguiente nodo
		}
		return temporal; // retorna temporal.
	}

	/**
	 * Ordena toda la lista NODO.
	 */
	public void ordenarElem() {
		Nodo x = new Nodo();
		Nodo search = inicio;
		LISTANOD n1 = new LISTANOD();
		int cont = this.cont;
		// Mientras que el contador de la lista temporal no iguale al de la real no se detiene.
		while(n1.cont < cont){
			x.dato = 0;
			// Mientras search no sea un nulo continua.
			while(search != null){
				// Si el valor de x es menor al de busqueda.
				if(x.dato <= search.dato){
					x = search; // Se sustituye su valor.
				}
				search = search.nodoSig;
			}
			eliminarElemEspecifico(x.dato);
			n1.insertarElemInicio(x.dato); // Se inserta x en la lista temporal.
			search = inicio; // Y search vuelve a recorrer la original desde el inicio.
		}
		inicio = n1.inicio;
		fin = n1.fin;
		fin.nodoSig = null;
		this.cont = cont;
	}

	/**
	 * Se copia la lista original.
	 * @return Retorna la misma lista.
	 */
	public LISTANOD copiarLista() {
		    return this;
	}

	/**
	 * Este metodo unira dos listas.
	 */
	public void unirLista() {
		LISTANOD l1 = new LISTANOD();
		System.out.println("Cuantos elementos desea ingresar en la lista que se va a unir? \n");
		int c = scanner.nextInt();
		scanner.nextLine();
		// Se estan agregando elementos a la lista nodo que se va a unir con la actual.
		for (int i = 0;c > i; i++){
			System.out.println("Ingrese el numero del elemento: " + "\n");
			l1.insertarElemInicio(scanner.nextInt());
			scanner.nextLine();
		}
		// La lista continua con la recien creada.
		fin.nodoSig = l1.inicio;
		// Su final es el de la recien creada.
		fin = l1.fin;
		cont += l1.cont;
	}

	/**
	 * Este metodo dividira la lista en dos segun su longitud.
	 */
	public void dividirLista() {
		if(!estaVacia()) {
			LISTANOD n1 = new LISTANOD();
			LISTANOD n2 = new LISTANOD();
			Nodo x = inicio;
			// Se hace un for en el q x recorre cada nodo.
			for (int i = 0; i < cont; i++) {
				// Hasta llegar al que se ubica en la mitad de la lista.
				if (i < cont / 2) {
					// Ahi se separa en dos listas. N1 y N2.
					n1.insertarElemfinal(x.dato);
				} else {
					n2.insertarElemfinal(x.dato);
				}
				x = x.nodoSig;
			}
			System.out.println("Aqui estan las dos partes de la lista: ");
			System.out.println("1." + "\n");
			mostrarListaNod(n1);
			System.out.println("2." + "\n");
			mostrarListaNod(n2);
			System.out.println("Que parte desea conservar?");
			String ans = scanner.nextLine();
			if (ans.equals("1")){
				inicio = n1.inicio;
				fin = n1.fin;
				cont = n1.cont;
			} else if (ans.equals("2")){
				inicio = n2.inicio;
				fin = n2.fin;
				cont = n2.cont;
			} else {
				System.out.println("No reconocido. Se guardara la 1 por defecto.");
			}
		}
	}

	/**
	 * Menu usado para manejar la lista.
	 */
	public void interfaz() {
		boolean menuNod = false;
		while(!menuNod) {
			System.out.println("""
			1. Ingresar valores a la lista al inicio.
			2. Ingresar valores a la lista al final.
			3. Borrar elemento al inicio de la lista. 
			4. Borrar elemento al final de la lista.
			5. Borrar elemento especifico.
			6. Ordenar la lista.	
			7. Buscar la posicion de un elemento.
			8. Copiar la lista.
			9. Dividir la lista.
			10. Unir dos listas.
			11. Mostrar la lista.
			12. Insertar donde desea.
			13. Salir.""");


			String opcion1= scanner.nextLine();

			switch (opcion1) {

				case "1":
					System.out.print("INGRESE EL ELEMENTO: ");
					int elemInicio= scanner.nextInt();
					scanner.nextLine();
					insertarElemInicio(elemInicio);
					break;

				case "2":
					System.out.print("INGRESE EL ELEMENTO: ");
					int elemFin= scanner.nextInt();
					scanner.nextLine();
					insertarElemfinal(elemFin);
					break;
					
				case "12":
					insertarElem();
					break;
						
				case "3":
					eliminarElemAlinicio();
					break;
				case "4":
					eliminarElemAlFin();
					break;
				case "5":
					System.out.println("INGRESE ELEMENTO A ELIMINAR: ");
					int elemento= scanner.nextInt();
					scanner.nextLine();
					eliminarElemEspecifico(elemento);
					break;

				case "6":
					System.out.println("ORDENANDO ELEMENTOS...");
					ordenarElem();
					System.out.println("Ordenado");
					break;
				case "7":
					System.out.println("INGRESE EL ELEMENTO A BUSCAR: ");
					int elemento2= scanner.nextInt();
					scanner.nextLine();
					System.out.println("Elemento encontrado: " + localizarElem(elemento2));
					break;
				case "8":
					System.out.println("LISTA COPIADA");
					System.out.println(copiarLista());
					break;
				case "9":
					dividirLista();
					break;
				case "10":
					unirLista();
					mostrarListaNod(this);
					break;
				case "11":
					mostrarListaNod(this);
					break;
				case "13":
					menuNod = true;
					break;
				default:
					System.out.println("VALOR INGRESADO NO VALIDO");
				}

			if(!menuNod){
				System.out.println("Presione 'ENTER' para continuar.");
				scanner.nextLine();
			}

		}
	}
}
	



