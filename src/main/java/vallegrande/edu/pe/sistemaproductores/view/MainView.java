package vallegrande.edu.pe.misistema.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import vallegrande.edu.pe.misistema.model.Productor;

public class MainView extends BorderPane {

    private TextField txtId;
    private TextField txtNombre;
    private TextField txtDni;
    private TextField txtTelefono;
    private TextField txtComunidad;

    private Button btnRegistrar;
    private Button btnActualizar;
    private Button btnEliminar;

    private TableView<Productor> tabla;
    private TableColumn<Productor, Integer> colId;
    private TableColumn<Productor, String> colNombre;
    private TableColumn<Productor, String> colDni;
    private TableColumn<Productor, String> colTelefono;
    private TableColumn<Productor, String> colComunidad;

    public MainView() {
        initComponents();
    }

    private void initComponents() {
        this.setPadding(new Insets(20));
        this.setStyle("-fx-background-color: #f7fafc;");

        // Header
        Label lblTitulo = new Label("GESTIÓN DE PRODUCTORES AGRÍCOLAS");
        lblTitulo.setStyle("-fx-font-size: 20px; -fx-font-weight: bold; -fx-text-fill: #1a365d;");
        HBox headerBox = new HBox(lblTitulo);
        headerBox.setAlignment(Pos.CENTER);
        headerBox.setPadding(new Insets(0, 0, 20, 0));
        this.setTop(headerBox);

        // Formulario (Izquierda)
        VBox formBox = new VBox(12);
        formBox.setPadding(new Insets(15));
        formBox.setStyle("-fx-background-color: #ffffff; -fx-border-color: #e2e8f0; -fx-border-radius: 8; -fx-background-radius: 8;");
        formBox.setPrefWidth(300);

        Label lblFormTitle = new Label("Datos del Productor");
        lblFormTitle.setStyle("-fx-font-size: 14px; -fx-font-weight: bold; -fx-text-fill: #2b6cb0;");

        txtId = new TextField();
        txtId.setPromptText("ID (Auto)");
        txtId.setEditable(false);
        txtId.setStyle("-fx-background-color: #edf2f7;");

        txtNombre = new TextField();
        txtNombre.setPromptText("Nombre completo");

        txtDni = new TextField();
        txtDni.setPromptText("DNI");

        txtTelefono = new TextField();
        txtTelefono.setPromptText("Teléfono");

        txtComunidad = new TextField();
        txtComunidad.setPromptText("Comunidad");

        btnRegistrar = new Button("Registrar");
        btnRegistrar.setStyle("-fx-background-color: #3182ce; -fx-text-fill: white; -fx-font-weight: bold;");
        btnRegistrar.setMaxWidth(Double.MAX_VALUE);

        btnActualizar = new Button("Actualizar");
        btnActualizar.setStyle("-fx-background-color: #319795; -fx-text-fill: white; -fx-font-weight: bold;");
        btnActualizar.setMaxWidth(Double.MAX_VALUE);

        btnEliminar = new Button("Eliminar");
        btnEliminar.setStyle("-fx-background-color: #e53e3e; -fx-text-fill: white; -fx-font-weight: bold;");
        btnEliminar.setMaxWidth(Double.MAX_VALUE);

        VBox buttonBox = new VBox(8, btnRegistrar, btnActualizar, btnEliminar);

        formBox.getChildren().addAll(
                lblFormTitle,
                new Label("ID:"), txtId,
                new Label("Nombre:"), txtNombre,
                new Label("DNI:"), txtDni,
                new Label("Teléfono:"), txtTelefono,
                new Label("Comunidad:"), txtComunidad,
                new Separator(),
                buttonBox
        );

        this.setLeft(formBox);

        // Tabla (Centro)
        tabla = new TableView<>();
        tabla.setStyle("-fx-background-radius: 8; -fx-border-radius: 8;");

        colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colId.setPrefWidth(50);

        colNombre = new TableColumn<>("Nombre");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colNombre.setPrefWidth(160);

        colDni = new TableColumn<>("DNI");
        colDni.setCellValueFactory(new PropertyValueFactory<>("dni"));
        colDni.setPrefWidth(100);

        colTelefono = new TableColumn<>("Teléfono");
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colTelefono.setPrefWidth(110);

        colComunidad = new TableColumn<>("Comunidad");
        colComunidad.setCellValueFactory(new PropertyValueFactory<>("comunidad"));
        colComunidad.setPrefWidth(140);

        tabla.getColumns().addAll(colId, colNombre, colDni, colTelefono, colComunidad);

        VBox centerBox = new VBox(tabla);
        centerBox.setPadding(new Insets(0, 0, 0, 20));
        HBox.setHgrow(tabla, Priority.ALWAYS);
        VBox.setVgrow(tabla, Priority.ALWAYS);

        this.setCenter(centerBox);
    }

    public void limpiarFormulario() {
        txtId.clear();
        txtNombre.clear();
        txtDni.clear();
        txtTelefono.clear();
        txtComunidad.clear();
        tabla.getSelectionModel().clearSelection();
    }

    public void cargarProductorEnFormulario(Productor p) {
        if (p != null) {
            txtId.setText(String.valueOf(p.getId()));
            txtNombre.setText(p.getNombre());
            txtDni.setText(p.getDni());
            txtTelefono.setText(p.getTelefono() != null ? p.getTelefono() : "");
            txtComunidad.setText(p.getComunidad() != null ? p.getComunidad() : "");
        }
    }

    public TextField getTxtId() { return txtId; }
    public TextField getTxtNombre() { return txtNombre; }
    public TextField getTxtDni() { return txtDni; }
    public TextField getTxtTelefono() { return txtTelefono; }
    public TextField getTxtComunidad() { return txtComunidad; }
    public Button getBtnRegistrar() { return btnRegistrar; }
    public Button getBtnActualizar() { return btnActualizar; }
    public Button getBtnEliminar() { return btnEliminar; }
    public TableView<Productor> getTabla() { return tabla; }
}