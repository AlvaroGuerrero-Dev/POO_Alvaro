package vallegrande.edu.pe.view;

import vallegrande.edu.pe.controller.AgendaController;
import vallegrande.edu.pe.model.Contacto;
import java.util.List;
import java.util.Scanner;

public class AgendaView {
    private AgendaController controller;
    private Scanner scanner;

    public AgendaView() {
        this.controller = new AgendaController();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion = 0;
        do {
            System.out.println("--- AGENDA DE CONTACTOS ---");
            System.out.println("1. Registrar contacto");
            System.out.println("2. Mostrar contactos");
            System.out.println("3. Buscar contacto");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> registrar();
                case 2 -> mostrar();
                case 3 -> buscar();
                case 4 -> System.out.println("Saliendo de la agenda...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    private void registrar() {
        System.out.print("Ingrese nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese teléfono: ");
        String telefono = scanner.nextLine();
        controller.registrarContacto(nombre, telefono);
        System.out.println("Contacto registrado con éxito.\n");
    }

    private void mostrar() {
        List<Contacto> lista = controller.obtenerContactos();
        if (lista.isEmpty()) {
            System.out.println("La agenda está vacía.\n");
        } else {
            System.out.println("\n--- LISTA DE CONTACTOS ---");
            for (Contacto c : lista) {
                System.out.println("Nombre: " + c.getNombre() + " | Teléfono: " + c.getTelefono());
            }
            System.out.println();
        }
    }

    private void buscar() {
        System.out.print("Ingrese el nombre a buscar: ");
        String nombre = scanner.nextLine();
        Contacto c = controller.buscarContacto(nombre);
        if (c != null) {
            System.out.println("Contacto encontrado -> Nombre: " + c.getNombre() + " | Teléfono: " + c.getTelefono() + "\n");
        } else {
            System.out.println("No se encontró ningún contacto con ese nombre.\n");
        }
    }
}