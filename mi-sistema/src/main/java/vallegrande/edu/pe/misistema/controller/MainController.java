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

        view.getTablaUsuarios().getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                view.cargarUsuarioEnFormulario(newVal);
            }
        });

        view.getBtnActualizar().setOnAction(e -> actualizarUsuario());
        view.getBtnEliminar().setOnAction(e -> eliminarUsuario());
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
        cargarUsuarios();
    }

    private void actualizarUsuario() {
        int id = view.getIdSeleccionado();
        if (id == 0) return;

        Usuario u = new Usuario();
        u.setId(id);
        u.setNombre(view.getNombre().trim());
        u.setApellido(view.getApellido().trim());
        u.setCorreo(view.getCorreo().trim());
        u.setEstado(view.getEstado());

        usuarioDAO.actualizar(u);
        cargarUsuarios();
        view.limpiarFormulario();
    }

    private void eliminarUsuario() {
        int id = view.getIdSeleccionado();
        if (id == 0) return;

        usuarioDAO.eliminar(id);
        cargarUsuarios();
        view.limpiarFormulario();
    }
}