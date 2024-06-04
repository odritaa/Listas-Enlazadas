import java.util.Scanner;

public class Menu {
	Scanner scan = new Scanner(System.in);

    /**
     * Menu en que se manipulan las listas.
     */
    public Menu(){
    	LISTANOD listaNod= new LISTANOD();
    	LISTATOT lista = new LISTATOT();
        
        boolean est = false;
        while(!est){
            System.out.println("""
                    1. Lista Enlazada.
                    2. Lista Nodo.
                    3. Salir""");
            String ans = scan.nextLine();
            switch (ans){
                case "1" -> lista.interfaz();
                case "2" -> listaNod.interfaz();
                case "3" -> {est = true;
                    System.out.println("Hasta luego!");}
                default -> System.out.println("No reconocido");
            }
            if (!est){
                System.out.println("Presione 'ENTER' para continuar.");
                scan.nextLine();
            }
        }
    }
}
