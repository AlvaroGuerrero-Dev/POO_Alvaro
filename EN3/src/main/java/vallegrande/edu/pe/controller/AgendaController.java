package vallegrande.edu.pe.controller;

import vallegrande.edu.pe.model.Contacto;
import java.util.ArrayList;
import java.util.List;

public class AgendaController {
    private List<Contacto> contactos;

    public AgendaController() {
        this.contactos = new ArrayList<>();
    }

    public void registrarContacto(String nombre, String telefono) {
        contactos.add(new Contacto(nombre, telefono));
    }

    public List<Contacto> obtenerContactos() {
        return contactos;
    }

    public Contacto buscarContacto(String nombre) {
        for (Contacto c : contactos) {
            if (c.getNombre().equalsIgnoreCase(nombre)) {
                return c;
            }
        }
        return null;
    }
}