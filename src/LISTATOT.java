import java.util.LinkedList;
import java.util.Scanner;
public class LISTATOT {
	String nombreLista;

	LinkedList<Integer> lista;

	Scanner scanner= new Scanner(System.in);


	public LISTATOT() {

		this.nombreLista= scanner.nextLine();

		this.lista = new LinkedList<>();


	}

	/**
	 * METODO PARA AGREGAR ELEMENTOS
	 */
	public void agregar() {
		System.out.print("DEFINA CUANTOS ELEMENTOS DESEA INGRESAR: ");
		int tam1= scanner.nextInt();
		scanner.nextLine();
		int elem;
		for (int i = 0; i < tam1; i++) { // hasta que termine la cantidad que indico el usuario se va a repetir la pregunta
			System.out.print("INGRESE ELEMENTO A LA LISTA: " + "\n");
			elem= scanner.nextInt();
			scanner.nextLine();
			if (lista.contains(elem)){
				System.out.println("EL ELEMENTO YA SE ENCUENTRA EN LA LISTA. INGRESE OTRO POR FAVOR.");
				i--;
			} else {
				lista.add(elem); // se agrega el elemento
			}
		}
	}
	
	/**
	 * METODO PARA ELIMINAR ELEMENTO
	 * @param elemBorrar
	 */
	public void eliminarElem(int elemBorrar) {
		for (int i = 0; i < lista.size(); i++) { //hasta que se encuentre el elemento que se desea borrar recorre elemento a elemento.  
			if (elemBorrar== lista.get(i)) { // condicion para que coincida el elemnto que se desea borrar con el elemento de la lista
				lista.remove(i); // se borra
				System.out.println("ELEMENTO BORRADO EXITOSAMENTE--- " + elemBorrar + "\n");
			}
		}
	}
	
	/**
	 * METODO PARA LOCALIZAR ELEMENTO
	 * @param elementoBuscado
	 */
	public void localizarElem(int elementoBuscado) {  
		for (int i = 0; i < lista.size(); i++) { // Recorre la lista hasta que se encuentre el elemento buscado
			if (lista.get(i)== elementoBuscado) {
			System.out.print("ELEMENTO ENCONTRADO EN POSICION: "+ (i+1) + "\n");
			}
		}
	}
	/**
	 * METODO PARA MOSTRAR LA LISTA
	 * @param lista
	 */
	
	public void mostrar(LinkedList<Integer> lista) {
		String n = "";
		for (int i = 0; i < lista.size(); i++) { // recorre la lista completa
			if (i != lista.size()-1){  
				n += lista.get(i) + " --> ";
			} else {
				n += lista.get(i) + " ";
			}
		}
		System.out.println(n);
	}
	/**
	 * METODO PARA ORDENAR ELEMENTOS
	 */
	public void ordenarElemMen() {  
		int elementoActual;
		int j;
		for (int i = 0; i < lista.size(); i++) {// recorre la lista
			elementoActual = lista.get(i); 
			j = i - 1;
			// Desplaza los elementos mayores hacia la derecha
			while (j >= 0 && lista.get(j) > elementoActual) {
				lista.set(i, lista.get(j));
				j--;
			}
			// Inserta el elemento en su posición adecuada
			lista.set(j + 1, elementoActual);
		}
	}
	/**
	 * METODO COPIAR LISTA
	 * @return
	 */
	public LinkedList<Integer> copiarLista() {
		return lista;
	}
	
	/**
	 * METODO PARA UNIR LISTA
	 * @param lista2
	 * @return
	 */
	public LinkedList<Integer> unirLista(LinkedList<Integer> lista2) {
		LinkedList<Integer> listasunidas= new LinkedList<>();
		for (Integer elemento : lista) { //Recorre todos los elementos de la lista principal
			listasunidas.add(elemento);// los agrega a la nueva lista creada listaunidas
		}
		for (Integer elemento: lista2) { //recorre todos los elementos de la lista secundaria
			listasunidas.add(elemento); // agrega los elementos a la lista unida
		}
		return listasunidas;
	}
	/** 
	 * METODO PARA DIVIDIR LISTA
	 */
	
	public void dividirLista() {
		LinkedList<Integer> listaA = new LinkedList<>(); 
		LinkedList<Integer> listaB = new LinkedList<>();
		for (int i = 0; i < lista.size(); i++) { //Recorremos la lista 
		   if(i < lista.size()/2){ // cuando el iterador es menor a la mitad del tamaño de la lista 
			   listaA.add(lista.get(i)); // agrega los elementos a la lista A
		   } else {
			   listaB.add(lista.get(i)); //agrega los elementos a la lista B.
		   }
		}
		System.out.print("LISTA A "+ listaA + "\n");
		System.out.print("LISTA B " + listaB + "\n");
		System.out.println("Cual de las dos desea conservar?");
		String ans = scanner.nextLine();
		if(ans.equalsIgnoreCase("A")){
			lista = listaA;
		} else if (ans.equalsIgnoreCase("B")) {
			lista = listaB;
		} else {
			System.out.println("No identificado. Se conservara la lista A por defecto.");
			lista = listaA;
		}
	}
	
	public void interfaz() {
		boolean est = false;
		while(!est) {

		System.out.println("""

		Bienvenido. Ingrese una opcion para continuar.
		1. Ingresar valores a la lista.
		2. Borrar elementos de la lista.
		3. Buscar la posicion de un elemento.
		4. Ordenar la lista.
		5. Copiar la lista.
		6. Dividir la lista.
		7. Unir dos listas.
		8. Mostrar lista.
		9. Salir.""");
		String opcion= scanner.nextLine();
		switch (opcion) {

			case "1":
				agregar();
				System.out.println("LISTA  CREADA EXITOSAMENTE!" + "\n");
				break;
			case "2":
				System.out.print("INGRESE ELEMENTO A ELIMINAR: " + "\n");
				int elemBorrar= scanner.nextInt();
				scanner.nextLine();
				eliminarElem(elemBorrar);
				break;
			case "3":
				System.out.print("INGRESE EL ELEMENTO QUE DESEA CONOCER SU POSICION: " + "\n");
				int elementoBuscado= scanner.nextInt();
				scanner.nextLine();
				localizarElem(elementoBuscado);
				break;
			case "4":
				System.out.print("LISTA ORDENADA DE MENOR A MAYOR ---\n");
				ordenarElemMen();
				break;
			case "5":
				LinkedList<Integer> copia = copiarLista();
				System.out.print("LISTA COPIADA");
				mostrar(copia);
				break;
			case "6":
				System.out.print("LISTA DIVIDIDA: " + "\n");
				dividirLista();
				break;
			case "7":
				System.out.println("VAMOS A CREAR LA LISTA 2."+ "\n");
				LISTATOT lista2 = new LISTATOT();
				lista2.agregar();
				System.out.print("DESEA AGREGAR LA LISTA 2: \n1. AL COMIENZO. \n2. AL FINAL.\n");
				int orden= scanner.nextInt();
				scanner.nextLine();
				System.out.print("LISTA UNIDA: "+ "\n");
				if (orden == 1) {
					lista = lista2.unirLista(lista);
					mostrar(lista);
				} else if(orden ==2) {
					lista = unirLista(lista2.lista);
					mostrar(lista);
				} else{
					System.out.println("No se identifico. Se agregara la lista 2 al comienzo por defecto.");
					lista = lista2.unirLista(lista);
					mostrar(lista);
				}
				break;
			case "8":
				mostrar(lista);
				break;
			case "9":
				System.out.println("SALIENDO..." + "\n");
				est = true;
				break;

			default:
				System.out.println("VALOR INGRESADO NO VALIDO"+ "\n");

		}
		if(!est){
			System.out.println("Presione 'ENTER' para continuar.");
			scanner.nextLine();
		}

		}
	}
}