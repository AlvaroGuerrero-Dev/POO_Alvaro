package vallegrande.edu.pe.misistema.controller;

import java.util.List;
import vallegrande.edu.pe.misistema.model.Usuario;
import vallegrande.edu.pe.misistema.model.UsuarioDAO;
import vallegrande.edu.pe.misistema.view.MainView;

public class MainController {

    private MainView view;
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public MainController(MainView view) {
        this.view = view;
        configurarEventos();
    }

    private void configurarEventos() {

        view.getBtnInicio().setOnAction(e -> {
            view.mostrarInicio();
        });

        view.getBtnUsuarios().setOnAction(e -> {
            view.mostrarUsuarios();
            cargarUsuarios();
        });

        view.getBtnRegistrar().setOnAction(e -> {
            registrarUsuario();
        });

        view.getBtnProductos().setOnAction(e -> {
            view.mostrarProductos();
        });

        view.getBtnInventario().setOnAction(e -> {
            view.mostrarInventario();
        });

        view.getBtnVentas().setOnAction(e -> {
            view.mostrarVentas();
        });

        view.getBtnDashboard().setOnAction(e -> {
            view.mostrarDashboard();
        });

    }

    private void cargarUsuarios() {
        List<Usuario> usuarios = usuarioDAO.listar();
        view.mostrarDatosUsuarios(usuarios);
    }

    private void registrarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setNombre(view.getNombre());
        usuario.setApellido(view.getApellido());
        usuario.setCorreo(view.getCorreo());
        usuario.setEstado(view.getEstado());

        usuarioDAO.insertar(usuario);
        cargarUsuarios(); // Vuelve a cargar la tabla para ver el usuario recien agregado
    }
}