package vallegrande.edu.pe.misistema.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import java.util.List;
import vallegrande.edu.pe.misistema.model.Usuario;

public class MainView extends BorderPane {

    // Botones del Menú Lateral
    private Button btnInicio;
    private Button btnUsuarios;
    private Button btnProductos;
    private Button btnInventario;
    private Button btnVentas;
    private Button btnDashboard;

    // Componentes del Formulario
    private TextField txtNombre;
    private TextField txtApellido;
    private TextField txtCorreo;
    private ComboBox<String> cbEstado;
    private Button btnRegistrar;
    private Label lblMensaje;
    private TableView<Usuario> tablaUsuarios;

    public MainView() {
        inicializarComponentesUsuarios();
        crearMenu();
        mostrarInicio();
    }

    private void inicializarComponentesUsuarios() {
        txtNombre = crearTextField("Ej: Carlos");
        txtApellido = crearTextField("Ej: Pérez");
        txtCorreo = crearTextField("Ej: carlos@gmail.com");

        cbEstado = new ComboBox<>();
        cbEstado.getItems().addAll("ACTIVO", "INACTIVO");
        cbEstado.setValue("ACTIVO");
        cbEstado.setPrefHeight(40);
        cbEstado.setMaxWidth(Double.MAX_VALUE);
        cbEstado.setStyle(
                "-fx-background-color: #F1F5F9;" +
                        "-fx-border-color: #CBD5E1;" +
                        "-fx-border-radius: 8;" +
                        "-fx-background-radius: 8;" +
                        "-fx-font-size: 13px;"
        );

        btnRegistrar = new Button("➕ Registrar Usuario");
        btnRegistrar.setPrefHeight(40);
        btnRegistrar.setStyle(
                "-fx-background-color: #10B981;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-weight: bold;" +
                        "-fx-font-size: 13px;" +
                        "-fx-background-radius: 8;" +
                        "-fx-cursor: hand;"
        );
        btnRegistrar.setOnMouseEntered(e -> btnRegistrar.setStyle(
                "-fx-background-color: #059669; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 13px; -fx-background-radius: 8; -fx-cursor: hand;"
        ));
        btnRegistrar.setOnMouseExited(e -> btnRegistrar.setStyle(
                "-fx-background-color: #10B981; -fx-text-fill: white; -fx-font-weight: bold; -fx-font-size: 13px; -fx-background-radius: 8; -fx-cursor: hand;"
        ));

        lblMensaje = new Label();
        lblMensaje.setStyle("-fx-text-fill: #10B981; -fx-font-weight: bold; -fx-font-size: 13px;");

        tablaUsuarios = new TableView<>();
        tablaUsuarios.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tablaUsuarios.setPrefHeight(260);
        tablaUsuarios.setStyle(
                "-fx-background-color: white;" +
                        "-fx-border-color: #E2E8F0;" +
                        "-fx-border-radius: 8;" +
                        "-fx-padding: 0;"
        );

        TableColumn<Usuario, Integer> colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colId.setPrefWidth(60);

        TableColumn<Usuario, String> colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<Usuario, String> colApellido = new TableColumn<>("Apellido");
        colApellido.setCellValueFactory(new PropertyValueFactory<>("apellido"));

        TableColumn<Usuario, String> colCorreo = new TableColumn<>("Correo Electrónico");
        colCorreo.setCellValueFactory(new PropertyValueFactory<>("correo"));

        TableColumn<Usuario, String> colEstado = new TableColumn<>("Estado");
        colEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));

        tablaUsuarios.getColumns().addAll(colId, colNombre, colApellido, colCorreo, colEstado);
    }

    private TextField crearTextField(String placeholder) {
        TextField tf = new TextField();
        tf.setPromptText(placeholder);
        tf.setPrefHeight(40);
        tf.setStyle(
                "-fx-background-color: #F1F5F9;" +
                        "-fx-border-color: #CBD5E1;" +
                        "-fx-border-radius: 8;" +
                        "-fx-background-radius: 8;" +
                        "-fx-padding: 8 12;" +
                        "-fx-font-size: 13px;"
        );
        return tf;
    }

    private void crearMenu() {
        VBox menu = new VBox(12);
        menu.setPadding(new Insets(28, 16, 28, 16));
        menu.setPrefWidth(230);

        Label badge = new Label("SISTEMA POO");
        badge.setStyle(
                "-fx-background-color: #3B82F6;" +
                        "-fx-text-fill: white;" +
                        "-fx-font-size: 10px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-padding: 3 8 3 8;" +
                        "-fx-background-radius: 12;"
        );

        Label titulo = new Label("⚡ MI SISTEMA");
        titulo.setStyle("-fx-font-size: 19px; -fx-font-weight: bold; -fx-text-fill: #FFFFFF;");

        VBox headerBox = new VBox(5, badge, titulo);
        headerBox.setPadding(new Insets(0, 0, 10, 0));

        Separator separador = new Separator();
        separador.setStyle("-fx-opacity: 0.2;");

        btnInicio = crearBotonMenu("🏠   Inicio");
        btnUsuarios = crearBotonMenu("👥   Usuarios");
        btnProductos = crearBotonMenu("📦   Productos");
        btnInventario = crearBotonMenu("📊   Inventario");
        btnVentas = crearBotonMenu("💰   Ventas");
        btnDashboard = crearBotonMenu("📈   Dashboard");

        menu.getChildren().addAll(
                headerBox,
                separador,
                btnInicio,
                btnUsuarios,
                btnProductos,
                btnInventario,
                btnVentas,
                btnDashboard
        );

        // Fondo azul noche ultra moderno
        menu.setStyle("-fx-background-color: #0F172A;");
        setLeft(menu);
    }

    private Button crearBotonMenu(String texto) {
        Button boton = new Button(texto);
        boton.setMaxWidth(Double.MAX_VALUE);
        boton.setPrefHeight(42);
        boton.setAlignment(Pos.CENTER_LEFT);

        boton.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-text-fill: #94A3B8;" +
                        "-fx-font-size: 13px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 8;" +
                        "-fx-padding: 0 0 0 12;" +
                        "-fx-cursor: hand;"
        );

        boton.setOnMouseEntered(e -> boton.setStyle(
                "-fx-background-color: #1E293B;" +
                        "-fx-text-fill: #38BDF8;" +
                        "-fx-font-size: 13px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 8;" +
                        "-fx-padding: 0 0 0 12;" +
                        "-fx-cursor: hand;"
        ));

        boton.setOnMouseExited(e -> boton.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-text-fill: #94A3B8;" +
                        "-fx-font-size: 13px;" +
                        "-fx-font-weight: bold;" +
                        "-fx-background-radius: 8;" +
                        "-fx-padding: 0 0 0 12;" +
                        "-fx-cursor: hand;"
        ));

        return boton;
    }

    public void mostrarInicio() {
        VBox contenido = crearContenedor();

        Label titulo = crearTitulo("Recepción del Sistema");
        Label texto = crearDescripcion("Bienvenido al panel central de administración");

        VBox tarjeta1 = crearTarjetaPro("Gestión de Usuarios", "Accede al registro, edición y visualización del personal.", "Módulo activo");
        VBox tarjeta2 = crearTarjetaPro("Control de Almacén", "Revisa el stock disponible y estado de inventarios.", "En monitoreo");

        HBox cajaTarjetas = new HBox(16, tarjeta1, tarjeta2);

        contenido.getChildren().addAll(titulo, texto, cajaTarjetas);
        setCenter(contenido);
    }

    public void mostrarUsuarios() {
        VBox contenido = crearContenedor();

        Label titulo = crearTitulo("Gestión de Usuarios");
        Label subtitulo = crearDescripcion("Registro de nuevos accesos y consulta de base de datos");

        // --- TARJETA 1: FORMULARIO ---
        VBox tarjetaForm = new VBox(16);
        tarjetaForm.setPadding(new Insets(20));
        tarjetaForm.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 12;" +
                        "-fx-border-color: #E2E8F0;" +
                        "-fx-border-radius: 12;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(148, 163, 184, 0.12), 10, 0, 0, 4);"
        );

        Label lblSeccion = new Label("Datos del Usuario:");
        lblSeccion.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-text-fill: #1E293B;");

        GridPane grid = new GridPane();
        grid.setHgap(14);
        grid.setVgap(10);

        // Columnas alineadas correctamente
        grid.add(crearEtiquetaCampo("Nombre:"), 0, 0);
        grid.add(txtNombre, 0, 1);

        grid.add(crearEtiquetaCampo("Apellido:"), 1, 0);
        grid.add(txtApellido, 1, 1);

        grid.add(crearEtiquetaCampo("Correo Electrónico:"), 2, 0);
        grid.add(txtCorreo, 2, 1);

        grid.add(crearEtiquetaCampo("Estado:"), 3, 0);
        grid.add(cbEstado, 3, 1);

        grid.add(btnRegistrar, 4, 1);

        tarjetaForm.getChildren().addAll(lblSeccion, grid, lblMensaje);

        // --- TARJETA 2: TABLA ---
        VBox tarjetaTabla = new VBox(14);
        tarjetaTabla.setPadding(new Insets(20));
        tarjetaTabla.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 12;" +
                        "-fx-border-color: #E2E8F0;" +
                        "-fx-border-radius: 12;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(148, 163, 184, 0.12), 10, 0, 0, 4);"
        );

        Label lblTablaTitulo = new Label("Lista de Usuarios Registrados");
        lblTablaTitulo.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-text-fill: #1E293B;");

        tarjetaTabla.getChildren().addAll(lblTablaTitulo, tablaUsuarios);

        contenido.getChildren().addAll(titulo, subtitulo, tarjetaForm, tarjetaTabla);
        setCenter(contenido);
    }

    public void mostrarProductos() {
        VBox contenido = crearContenedor();
        Label titulo = crearTitulo("Catálogo de Productos");
        Label descripcion = crearDescripcion("Inventario disponible para comercialización");

        HBox tarjetas = new HBox(16);
        tarjetas.getChildren().addAll(
                crearTarjetaPro("Laptop Lenovo i7", "Precio: S/ 2,800.00", "Categoría: Cómputo"),
                crearTarjetaPro("Mouse Gamer RGB", "Precio: S/ 95.00", "Categoría: Periféricos"),
                crearTarjetaPro("Teclado Mecánico", "Precio: S/ 210.00", "Categoría: Periféricos")
        );

        contenido.getChildren().addAll(titulo, descripcion, tarjetas);
        setCenter(contenido);
    }

    public void mostrarInventario() {
        VBox contenido = crearContenedor();
        Label titulo = crearTitulo("Control de Inventario");
        Label descripcion = crearDescripcion("Estado de existencias en tiempo real");

        HBox tarjetas = new HBox(16);
        tarjetas.getChildren().addAll(
                crearTarjetaPro("Laptop Lenovo i7", "Stock: 12 Unidades", "Estado: Normal"),
                crearTarjetaPro("Mouse Gamer RGB", "Stock: 45 Unidades", "Estado: Normal"),
                crearTarjetaPro("Teclado Mecánico", "Stock: 2 Unidades", "Estado: ¡Bajo Stock!")
        );

        contenido.getChildren().addAll(titulo, descripcion, tarjetas);
        setCenter(contenido);
    }

    public void mostrarVentas() {
        VBox contenido = crearContenedor();
        Label titulo = crearTitulo("Registro de Ventas");
        Label descripcion = crearDescripcion("Histórico de transacciones realizadas");

        HBox tarjetas = new HBox(16);
        tarjetas.getChildren().addAll(
                crearTarjetaPro("Venta #001", "Monto: S/ 2,800.00", "Cliente: Juan Pérez"),
                crearTarjetaPro("Venta #002", "Monto: S/ 95.00", "Cliente: María López")
        );

        contenido.getChildren().addAll(titulo, descripcion, tarjetas);
        setCenter(contenido);
    }

    public void mostrarDashboard() {
        VBox contenido = crearContenedor();
        Label titulo = crearTitulo("Dashboard Resumen");
        Label descripcion = crearDescripcion("Indicadores clave del negocio");

        HBox tarjetas = new HBox(16);
        tarjetas.getChildren().addAll(
                crearTarjetaPro("Total Usuarios", "4 Registrados", "Base de datos activa"),
                crearTarjetaPro("Total Productos", "3 En catálogo", "Disponibles"),
                crearTarjetaPro("Ingresos Hoy", "S/ 2,895.00", "2 ventas realizadas")
        );

        contenido.getChildren().addAll(titulo, descripcion, tarjetas);
        setCenter(contenido);
    }

    private Label crearEtiquetaCampo(String texto) {
        Label lbl = new Label(texto);
        lbl.setStyle("-fx-font-weight: bold; -fx-text-fill: #475569; -fx-font-size: 12px;");
        return lbl;
    }

    private VBox crearContenedor() {
        VBox contenido = new VBox(20);
        contenido.setPadding(new Insets(30));
        contenido.setStyle("-fx-background-color: #F8FAFC;");
        return contenido;
    }

    private Label crearTitulo(String texto) {
        Label titulo = new Label(texto);
        titulo.setStyle("-fx-font-size: 24px; -fx-font-weight: bold; -fx-text-fill: #0F172A;");
        return titulo;
    }

    private Label crearDescripcion(String texto) {
        Label descripcion = new Label(texto);
        descripcion.setStyle("-fx-font-size: 13px; -fx-text-fill: #64748B;");
        return descripcion;
    }

    // --- TARJETA CON BORDE VERDE LATERAL (INSPIRADA EN LA IMAGEN 3) ---
    private VBox crearTarjetaPro(String titulo, String linea1, String linea2) {
        VBox tarjeta = new VBox(8);
        tarjeta.setPadding(new Insets(16, 20, 16, 20));
        tarjeta.setPrefWidth(240);

        tarjeta.setStyle(
                "-fx-background-color: white;" +
                        "-fx-background-radius: 10;" +
                        "-fx-border-color: transparent transparent transparent #10B981;" +
                        "-fx-border-width: 0 0 0 5;" +
                        "-fx-effect: dropshadow(three-pass-box, rgba(148, 163, 184, 0.15), 10, 0, 0, 3);"
        );

        Label lblTit = new Label(titulo);
        lblTit.setStyle("-fx-font-size: 15px; -fx-font-weight: bold; -fx-text-fill: #0F172A;");

        Label lbl1 = new Label(linea1);
        lbl1.setStyle("-fx-font-size: 13px; -fx-text-fill: #334155;");

        Label lbl2 = new Label(linea2);
        lbl2.setStyle("-fx-font-size: 12px; -fx-text-fill: #94A3B8;");

        tarjeta.getChildren().addAll(lblTit, lbl1, lbl2);
        return tarjeta;
    }

    // Getters para el controlador
    public Button getBtnInicio() { return btnInicio; }
    public Button getBtnUsuarios() { return btnUsuarios; }
    public Button getBtnProductos() { return btnProductos; }
    public Button getBtnInventario() { return btnInventario; }
    public Button getBtnVentas() { return btnVentas; }
    public Button getBtnDashboard() { return btnDashboard; }
    public Button getBtnRegistrar() { return btnRegistrar; }

    public String getNombre() { return txtNombre.getText(); }
    public String getApellido() { return txtApellido.getText(); }
    public String getCorreo() { return txtCorreo.getText(); }
    public String getEstado() {
        return cbEstado.getValue() != null ? cbEstado.getValue() : "ACTIVO";
    }

    public void mostrarDatosUsuarios(List<Usuario> usuarios) {
        if (tablaUsuarios != null) {
            tablaUsuarios.getItems().clear();
            tablaUsuarios.getItems().addAll(usuarios);
        }
    }
}