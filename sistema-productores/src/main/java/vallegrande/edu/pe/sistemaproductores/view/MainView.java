package vallegrande.edu.pe.misistema.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
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
    private Button btnLimpiar;

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
        // Fondo general de la ventana
        this.setStyle("-fx-background-color: #F1F5F9;");
        this.setPadding(new Insets(20));

        // Sombra suave para las tarjetas (Cards)
        DropShadow cardShadow = new DropShadow();
        cardShadow.setColor(Color.rgb(0, 0, 0, 0.08));
        cardShadow.setRadius(12);
        cardShadow.setOffsetY(4);

        // ==========================================
        // 1. ENCABEZADO (HEADER BANNER)
        // ==========================================
        VBox headerBox = new VBox(5);
        headerBox.setAlignment(Pos.CENTER_LEFT);
        headerBox.setPadding(new Insets(18, 25, 18, 25));
        headerBox.setStyle(
                "-fx-background-color: linear-gradient(to right, #0F172A, #1E293B, #059669);" +
                        "-fx-background-radius: 12px;"
        );
        headerBox.setEffect(cardShadow);

        Label lblTitulo = new Label("🌱 SISTEMA DE GESTIÓN DE PRODUCTORES");
        lblTitulo.setFont(Font.font("System", FontWeight.BOLD, 20));
        lblTitulo.setTextFill(Color.WHITE);

        Label lblSubtitulo = new Label("Panel de Administración Agrícola — Arquitectura MVC & Docker MySQL");
        lblSubtitulo.setFont(Font.font("System", FontWeight.NORMAL, 12));
        lblSubtitulo.setTextFill(Color.web("#94A3B8"));

        headerBox.getChildren().addAll(lblTitulo, lblSubtitulo);
        BorderPane.setMargin(headerBox, new Insets(0, 0, 20, 0));
        this.setTop(headerBox);

        // ==========================================
        // 2. FORMULARIO LATERAL (IZQUIERDA)
        // ==========================================
        VBox formBox = new VBox(10);
        formBox.setPadding(new Insets(20));
        formBox.setStyle(
                "-fx-background-color: #FFFFFF;" +
                        "-fx-background-radius: 12px;" +
                        "-fx-border-color: #E2E8F0;" +
                        "-fx-border-radius: 12px;"
        );
        formBox.setPrefWidth(320);
        formBox.setEffect(cardShadow);

        Label lblFormTitle = new Label("📋 Datos del Productor");
        lblFormTitle.setFont(Font.font("System", FontWeight.BOLD, 15));
        lblFormTitle.setStyle("-fx-text-fill: #0F172A;");

        // Campos de Texto con Estilo Moderno
        txtId = createStyledTextField("ID (Automático)", true);
        txtNombre = createStyledTextField("Nombre Completo", false);
        txtDni = createStyledTextField("Número de DNI", false);
        txtTelefono = createStyledTextField("Teléfono / Celular", false);
        txtComunidad = createStyledTextField("Comunidad / Sector", false);

        // Estilos para los Labels
        String labelStyle = "-fx-font-weight: bold; -fx-text-fill: #475569; -fx-font-size: 11px;";

        Label l1 = new Label("ID:"); l1.setStyle(labelStyle);
        Label l2 = new Label("👤 NOMBRE:"); l2.setStyle(labelStyle);
        Label l3 = new Label("🪪 DNI:"); l3.setStyle(labelStyle);
        Label l4 = new Label("📞 TELÉFONO:"); l4.setStyle(labelStyle);
        Label l5 = new Label("🏡 COMUNIDAD:"); l5.setStyle(labelStyle);

        // Botones con Hover y Paleta Dinámica
        btnRegistrar = createStyledButton("➕ Registrar", "#059669", "#047857");
        btnActualizar = createStyledButton("✏️ Actualizar", "#2563EB", "#1D4ED8");
        btnEliminar = createStyledButton("🗑️ Eliminar", "#DC2626", "#B91C1C");
        btnLimpiar = createStyledButton("🧹 Limpiar Campos", "#64748B", "#475569");

        btnLimpiar.setOnAction(e -> limpiarFormulario());

        HBox topButtons = new HBox(8, btnRegistrar, btnActualizar);
        topButtons.setAlignment(Pos.CENTER);
        HBox.setHgrow(btnRegistrar, Priority.ALWAYS);
        HBox.setHgrow(btnActualizar, Priority.ALWAYS);

        VBox buttonContainer = new VBox(8, topButtons, btnEliminar, btnLimpiar);

        formBox.getChildren().addAll(
                lblFormTitle,
                new Separator(),
                l1, txtId,
                l2, txtNombre,
                l3, txtDni,
                l4, txtTelefono,
                l5, txtComunidad,
                new Separator(),
                buttonContainer
        );

        this.setLeft(formBox);

        // ==========================================
        // 3. TABLA DE DATOS (CENTRO)
        // ==========================================
        VBox tableContainer = new VBox(10);
        tableContainer.setPadding(new Insets(15));
        tableContainer.setStyle(
                "-fx-background-color: #FFFFFF;" +
                        "-fx-background-radius: 12px;" +
                        "-fx-border-color: #E2E8F0;" +
                        "-fx-border-radius: 12px;"
        );
        tableContainer.setEffect(cardShadow);

        Label lblTableTitle = new Label("📊 Lista de Productores Registrados");
        lblTableTitle.setFont(Font.font("System", FontWeight.BOLD, 15));
        lblTableTitle.setStyle("-fx-text-fill: #0F172A;");

        tabla = new TableView<>();
        tabla.setStyle(
                "-fx-background-color: transparent;" +
                        "-fx-font-size: 12px;" +
                        "-fx-selection-bar: #E0E7FF;" +
                        "-fx-selection-bar-non-focused: #F1F5F9;"
        );
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        colId = new TableColumn<>("ID");
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colId.setMaxWidth(60);

        colNombre = new TableColumn<>("Nombre Completo");
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        colDni = new TableColumn<>("DNI");
        colDni.setCellValueFactory(new PropertyValueFactory<>("dni"));

        colTelefono = new TableColumn<>("Teléfono");
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));

        colComunidad = new TableColumn<>("Comunidad");
        colComunidad.setCellValueFactory(new PropertyValueFactory<>("comunidad"));

        tabla.getColumns().addAll(colId, colNombre, colDni, colTelefono, colComunidad);

        VBox.setVgrow(tabla, Priority.ALWAYS);
        tableContainer.getChildren().addAll(lblTableTitle, new Separator(), tabla);

        BorderPane.setMargin(tableContainer, new Insets(0, 0, 0, 20));
        this.setCenter(tableContainer);
    }

    private TextField createStyledTextField(String prompt, boolean disabled) {
        TextField tf = new TextField();
        tf.setPromptText(prompt);
        if (disabled) {
            tf.setEditable(false);
            tf.setStyle(
                    "-fx-background-color: #F8FAFC;" +
                            "-fx-border-color: #CBD5E1;" +
                            "-fx-border-radius: 6px;" +
                            "-fx-background-radius: 6px;" +
                            "-fx-padding: 7px 10px;" +
                            "-fx-text-fill: #94A3B8;"
            );
        } else {
            tf.setStyle(
                    "-fx-background-color: #FFFFFF;" +
                            "-fx-border-color: #CBD5E1;" +
                            "-fx-border-radius: 6px;" +
                            "-fx-background-radius: 6px;" +
                            "-fx-padding: 7px 10px;"
            );
            tf.focusedProperty().addListener((obs, oldVal, newVal) -> {
                if (newVal) {
                    tf.setStyle(
                            "-fx-background-color: #FFFFFF;" +
                                    "-fx-border-color: #059669;" +
                                    "-fx-border-width: 2px;" +
                                    "-fx-border-radius: 6px;" +
                                    "-fx-background-radius: 6px;" +
                                    "-fx-padding: 6px 9px;"
                    );
                } else {
                    tf.setStyle(
                            "-fx-background-color: #FFFFFF;" +
                                    "-fx-border-color: #CBD5E1;" +
                                    "-fx-border-radius: 6px;" +
                                    "-fx-background-radius: 6px;" +
                                    "-fx-padding: 7px 10px;"
                    );
                }
            });
        }
        return tf;
    }

    private Button createStyledButton(String text, String colorNormal, String colorHover) {
        Button btn = new Button(text);
        btn.setMaxWidth(Double.MAX_VALUE);
        btn.setFont(Font.font("System", FontWeight.BOLD, 12));
        btn.setTextFill(Color.WHITE);

        String styleBase =
                "-fx-background-color: " + colorNormal + ";" +
                        "-fx-background-radius: 8px;" +
                        "-fx-padding: 9px 12px;" +
                        "-fx-cursor: hand;";

        String styleHover =
                "-fx-background-color: " + colorHover + ";" +
                        "-fx-background-radius: 8px;" +
                        "-fx-padding: 9px 12px;" +
                        "-fx-cursor: hand;";

        btn.setStyle(styleBase);

        btn.setOnMouseEntered(e -> btn.setStyle(styleHover));
        btn.setOnMouseExited(e -> btn.setStyle(styleBase));

        return btn;
    }

    // ==========================================
    // MÉTODOS DE COMPATIBILIDAD CON EL CONTROLADOR
    // ==========================================
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