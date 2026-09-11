package vallegrande.edu.pe.misistema.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MainView extends BorderPane {

    private Button btnInicio;
    private Button btnUsuarios;
    private Button btnProductos;
    private Button btnInventario;
    private Button btnVentas;
    private Button btnDashboard;

    public MainView() {
        crearMenu();
        mostrarInicio();
    }

    private void crearMenu() {
        VBox menu = new VBox(14);
        menu.setPadding(new Insets(30, 20, 30, 20));
        menu.setPrefWidth(210);

        Label titulo = new Label("MI SISTEMA");
        titulo.setStyle(
                "-fx-font-size: 22px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: white;"
        );

        Label subtitulo = new Label("Panel administrativo");
        subtitulo.setStyle(
                "-fx-font-size: 12px;" +
                        "-fx-text-fill: #DBEAFE;"
        );

        btnInicio = crearBoton("Inicio");
        btnUsuarios = crearBoton("Usuarios");
        btnProductos = crearBoton("Productos");
        btnInventario = crearBoton("Inventario");
        btnVentas = crearBoton("Ventas");
        btnDashboard = crearBoton("Dashboard");

        menu.getChildren().addAll(
                titulo,
                subtitulo,
                btnInicio,
                btnUsuarios,
                btnProductos,
                btnInventario,
                btnVentas,
                btnDashboard
        );

        menu.setStyle(
                "-fx-background-color: #1D4ED8;"
        );

        setLeft(menu);
    }

    private Button crearBoton(String texto) {
        Button boton = new Button(texto);

        boton.setPrefWidth(170);
        boton.setPrefHeight(42);

        boton.setStyle(
                "-fx-background-color: white;" +
                        "-fx-text-fill: #1E3A8A;" +
                        "-fx-font-size: 14px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 8;" +
                        "-fx-border-radius: 8;"
        );

        return boton;
    }

    public void mostrarInicio() {
        VBox contenido = crearContenedor();

        Label titulo = crearTitulo("BIENVENIDO");

        Label texto = new Label(
                "Panel principal de mi sistema"
        );

        texto.setStyle(
                "-fx-font-size: 15px;" +
                        "-fx-text-fill: #64748B;"
        );

        VBox tarjeta = crearTarjetaGrande(
                "Gestión del sistema",
                "Administra usuarios, productos, inventario y ventas desde el menú lateral."
        );

        contenido.getChildren().addAll(
                titulo,
                texto,
                tarjeta
        );

        setCenter(contenido);
    }

    public void mostrarUsuarios() {
        VBox contenido = crearContenedor();

        Label titulo = crearTitulo("USUARIOS");

        Label descripcion = crearDescripcion(
                "Usuarios registrados en el sistema"
        );

        HBox tarjetas = new HBox(18);

        tarjetas.getChildren().addAll(
                crearTarjeta("Carlos Perez", "Administrador"),
                crearTarjeta("Maria Lopez", "Vendedora"),
                crearTarjeta("Piero Ramos", "Supervisor")
        );

        contenido.getChildren().addAll(
                titulo,
                descripcion,
                tarjetas
        );

        setCenter(contenido);
    }

    public void mostrarProductos() {
        VBox contenido = crearContenedor();

        Label titulo = crearTitulo("PRODUCTOS");

        Label descripcion = crearDescripcion(
                "Productos disponibles en el sistema"
        );

        HBox tarjetas = new HBox(18);

        tarjetas.getChildren().addAll(
                crearTarjeta("Laptop Lenovo", "S/ 2500"),
                crearTarjeta("Mouse Logitech", "S/ 80"),
                crearTarjeta("Teclado Mecánico", "S/ 180")
        );

        contenido.getChildren().addAll(
                titulo,
                descripcion,
                tarjetas
        );

        setCenter(contenido);
    }

    public void mostrarInventario() {
        VBox contenido = crearContenedor();

        Label titulo = crearTitulo("INVENTARIO");

        Label descripcion = crearDescripcion(
                "Control y seguimiento del stock de productos"
        );

        HBox tarjetas = new HBox(18);

        tarjetas.getChildren().addAll(
                crearTarjeta("Laptop Lenovo", "15 unidades\nStock disponible"),
                crearTarjeta("Mouse Logitech", "42 unidades\nStock disponible"),
                crearTarjeta("Teclado Mecánico", "3 unidades\nStock bajo")
        );

        contenido.getChildren().addAll(
                titulo,
                descripcion,
                tarjetas
        );

        setCenter(contenido);
    }

    public void mostrarVentas() {
        VBox contenido = crearContenedor();

        Label titulo = crearTitulo("VENTAS");

        Label resumen = new Label(
                "Ventas del día: S/ 3,450"
        );

        resumen.setStyle(
                "-fx-font-size: 20px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #1E3A8A;"
        );

        Label descripcion = crearDescripcion(
                "Resumen de las principales ventas realizadas"
        );

        HBox tarjetas = new HBox(18);

        tarjetas.getChildren().addAll(
                crearTarjeta("Laptop Lenovo", "S/ 2500"),
                crearTarjeta("Mouse Logitech", "S/ 80"),
                crearTarjeta("Teclado Mecánico", "S/ 180")
        );

        contenido.getChildren().addAll(
                titulo,
                resumen,
                descripcion,
                tarjetas
        );

        setCenter(contenido);
    }

    public void mostrarDashboard() {
        VBox contenido = crearContenedor();

        Label titulo = crearTitulo("DASHBOARD");

        Label descripcion = crearDescripcion(
                "Resumen general del sistema"
        );

        HBox tarjetas = new HBox(15);

        tarjetas.getChildren().addAll(
                crearTarjeta("Usuarios", "3 registrados"),
                crearTarjeta("Productos", "3 registrados"),
                crearTarjeta("Stock", "60 unidades"),
                crearTarjeta("Ventas", "S/ 3,450")
        );

        contenido.getChildren().addAll(
                titulo,
                descripcion,
                tarjetas
        );

        setCenter(contenido);
    }

    private VBox crearContenedor() {
        VBox contenido = new VBox(18);

        contenido.setPadding(
                new Insets(35)
        );

        contenido.setStyle(
                "-fx-background-color: #F8FAFC;"
        );

        return contenido;
    }

    private Label crearTitulo(String texto) {
        Label titulo = new Label(texto);

        titulo.setStyle(
                "-fx-font-size: 28px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #1E293B;"
        );

        return titulo;
    }

    private Label crearDescripcion(String texto) {
        Label descripcion = new Label(texto);

        descripcion.setStyle(
                "-fx-font-size: 14px;" +
                        "-fx-text-fill: #64748B;"
        );

        return descripcion;
    }

    private VBox crearTarjeta(String titulo, String detalle) {
        VBox tarjeta = new VBox(10);

        tarjeta.setPadding(
                new Insets(20)
        );

        tarjeta.setPrefWidth(175);
        tarjeta.setPrefHeight(90);

        tarjeta.setAlignment(Pos.CENTER_LEFT);

        tarjeta.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 12;" +
                        "-fx-border-color: #E2E8F0;" +
                        "-fx-border-radius: 12;" +
                        "-fx-effect: dropshadow(gaussian, rgba(15, 23, 42, 0.08), 8, 0, 0, 3);"
        );

        Label nombre = new Label(titulo);

        nombre.setStyle(
                "-fx-font-size: 16px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #1E293B;"
        );

        Label info = new Label(detalle);

        info.setStyle(
                "-fx-font-size: 13px;" +
                        "-fx-text-fill: #64748B;"
        );

        tarjeta.getChildren().addAll(
                nombre,
                info
        );

        return tarjeta;
    }

    private VBox crearTarjetaGrande(
            String titulo,
            String detalle) {

        VBox tarjeta = new VBox(10);

        tarjeta.setPadding(
                new Insets(25)
        );

        tarjeta.setPrefWidth(500);
        tarjeta.setPrefHeight(120);

        tarjeta.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 12;" +
                        "-fx-border-color: #E2E8F0;" +
                        "-fx-border-radius: 12;" +
                        "-fx-effect: dropshadow(gaussian, rgba(15, 23, 42, 0.08), 8, 0, 0, 3);"
        );

        Label nombre = new Label(titulo);

        nombre.setStyle(
                "-fx-font-size: 18px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-text-fill: #1E3A8A;"
        );

        Label info = new Label(detalle);

        info.setStyle(
                "-fx-font-size: 14px;" +
                        "-fx-text-fill: #64748B;"
        );

        tarjeta.getChildren().addAll(
                nombre,
                info
        );

        return tarjeta;
    }

    public Button getBtnInicio() {
        return btnInicio;
    }

    public Button getBtnUsuarios() {
        return btnUsuarios;
    }

    public Button getBtnProductos() {
        return btnProductos;
    }

    public Button getBtnInventario() {
        return btnInventario;
    }

    public Button getBtnVentas() {
        return btnVentas;
    }

    public Button getBtnDashboard() {
        return btnDashboard;
    }
}