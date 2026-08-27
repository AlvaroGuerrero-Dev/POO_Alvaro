package vallegrande.edu.pe.app;

import vallegrande.edu.pe.model.Producto;
import vallegrande.edu.pe.view.AgendaView;

public class Main {
    public static void main(String[] args) {
        // Demostración Punto 2: Objeto Producto
        Producto prod = new Producto("Papa Canchán", "P-001", 2.50, 500, "Tubérculos");
        prod.mostrarDatos();

        // Demostración Punto 3: Consola Interactiva
        AgendaView agenda = new AgendaView();
        agenda.iniciar();
    }
}