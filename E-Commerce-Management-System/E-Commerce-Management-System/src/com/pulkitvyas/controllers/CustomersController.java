package com.pulkitvyascoder.controllers;

import animatefx.animation.Shake;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXTextField;
import com.pulkitvyascoder.database.DatabaseConnection;
import com.pulkitvyascoder.database.DatabaseHelper;
import com.pulkitvyascoder.models.Customers;
import com.pulkitvyascoder.resources.Resources;
import static com.pulkitvyascoder.resources.Resources.jfxDialog;
import java.net.URL;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.ESCAPE;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class CustomersController implements Initializable {

    private ObservableList<Customers> listCustomers;

    private ObservableList<Customers> filterCustomers;

    @FXML
    private StackPane stckCustomers;

    @FXML
    private AnchorPane rootCustomers;

    @FXML
    private AnchorPane rootDeleteCustomer;

    @FXML
    private AnchorPane rootAddCustomer;

    @FXML
    private JFXButton btnUpdateCustomer;

    @FXML
    private JFXButton btnSaveCustomer;

    @FXML
    private TableView<Customers> tblCustomers;

    @FXML
    private TableColumn<Customers, Integer> colCodigoCliente;

    @FXML
    private TableColumn<Customers, String> colLastName;

    @FXML
    private TableColumn<Customers, String> colAddress;

    @FXML
    private TableColumn<Customers, String> colState;

    @FXML
    private TableColumn<Customers, String> colCity;

    @FXML
    private TableColumn<Customers, String> colPincode;

    @FXML
    private TableColumn<Customers, String> colCountry;

    @FXML
    private TableColumn<Customers, String> colGender;

    @FXML
    private TableColumn<Customers, String> colNombreCliente;

    @FXML
    private TableColumn<Customers, String> colTelefonoCliente;

    @FXML
    private TableColumn<Customers, String> colCorreoCliente;

    @FXML
    private TableColumn<Customers, String> colNitCliente;

    @FXML
    private JFXButton btnAddCustomer;

    @FXML
    private JFXButton btnCancel;
    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnCancelDelete;

    @FXML
    private HBox rootSearchCustomers;

    @FXML
    private TextField txtSearchNumber;

    @FXML
    private TextField txtSearchCustomer;

    @FXML
    private JFXTextField txtFName;

    @FXML
    private JFXTextField txtLName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtCity;

    @FXML
    private JFXTextField txtState;

    @FXML
    private JFXTextField txtPincode;

    @FXML
    private JFXTextField txtCountry;

    @FXML
    private JFXTextField txtPassword;

    @FXML
    private JFXTextField txtGender;

    @FXML
    private JFXTextField txtCustomerNumber;

    @FXML
    private JFXTextField txtEmail;

    @FXML
    private JFXTextField txtIt;

    @FXML
    private Text titleWindowAddCustomer;

    @FXML
    private Text textConfirmation;

    @FXML
    private Text description;

    private JFXDialog dialogAddCustomer;

    private JFXDialog dialogDeleteCustomer;

    private final BoxBlur blur = new BoxBlur(3, 3, 3);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        filterCustomers = FXCollections.observableArrayList();
        escapeWindowWithTextFields();
        keyDeleteCustomer();
        keyEscapeWindows();
        characterLimiter();
        animateNodes();
        validation();
        selectText();
        loadData();
        setFonts();
    }

    private void setFonts() {
        Resources.setFontToJFXButton(btnUpdateCustomer, 15);
        Resources.setFontToJFXButton(btnSaveCustomer, 15);
        Resources.setFontToJFXButton(btnCancelDelete, 15);
        Resources.setFontToJFXButton(btnAddCustomer, 12);
        Resources.setFontToJFXButton(btnCancel, 15);
        Resources.setFontToJFXButton(btnDelete, 15);

        Resources.setFontToText(titleWindowAddCustomer, 20);
        Resources.setFontToText(textConfirmation, 15);
        Resources.setFontToText(description, 12);
    }

    private void animateNodes() {
        Resources.fadeInUpAnimation(rootSearchCustomers);
        Resources.fadeInUpAnimation(btnAddCustomer);
        Resources.fadeInUpAnimation(tblCustomers);
    }

    private void selectText() {
        Resources.selectTextToJFXTextField(txtCustomerNumber);
        Resources.selectTextToJFXTextField(txtFName);
        Resources.selectTextToJFXTextField(txtLName);
        Resources.selectTextToJFXTextField(txtAddress);
        Resources.selectTextToJFXTextField(txtPincode);
        Resources.selectTextToJFXTextField(txtCity);
        Resources.selectTextToJFXTextField(txtState);
        Resources.selectTextToJFXTextField(txtCountry);
        Resources.selectTextToJFXTextField(txtPassword);
        Resources.selectTextToJFXTextField(txtGender);
        Resources.selectTextToJFXTextField(txtEmail);
        Resources.selectTextToJFXTextField(txtIt);

        Resources.selectTextToTextField(txtSearchCustomer);
        Resources.selectTextToTextField(txtSearchNumber);
    }

    private void validation() {
        Resources.validationOfJFXTextField(txtCustomerNumber);
        Resources.validationOfJFXTextField(txtFName);
    }
    
    private void characterLimiter() {
        Resources.limitTextField(txtFName, 150);
        Resources.limitTextField(txtCustomerNumber, 15);
        Resources.limitTextField(txtEmail, 150);
        Resources.limitTextField(txtIt, 50);
    }

    @FXML
    private void onlyTextFieldNumber() {
        Resources.validationOnlyNumbers(txtSearchNumber);
    }

    @FXML
    private void onlyTextFieldAddNumber() {
        Resources.validationOnlyNumbers(txtCustomerNumber);
    }

    @FXML
    private void showWindowAddCustomer() {
        rootCustomers.setEffect(blur);
        enableControlsEdit();
        resetValidation(); 
        disableTable();

        titleWindowAddCustomer.setText("Add customer");
        btnUpdateCustomer.setVisible(true);
        btnSaveCustomer.setDisable(false);
        rootAddCustomer.setVisible(true);
        btnSaveCustomer.toFront();

        dialogAddCustomer = new JFXDialog();
        dialogAddCustomer.setTransitionType(JFXDialog.DialogTransition.valueOf(DatabaseHelper.getDialogTransition()));
        dialogAddCustomer.setDialogContainer(stckCustomers);
        dialogAddCustomer.setBackground(Background.EMPTY);
        dialogAddCustomer.setContent(rootAddCustomer);
        Resources.styleAlert(dialogAddCustomer);
        dialogAddCustomer.show();

        dialogAddCustomer.setOnDialogOpened(ev -> {
            txtFName.requestFocus();
            txtLName.requestFocus();
        });

        dialogAddCustomer.setOnDialogClosed(ev -> {
            rootAddCustomer.setVisible(false);
            tblCustomers.setDisable(false);
            rootCustomers.setEffect(null);
            cleanControls();
        });
    }

    @FXML
    private void hideWindowAddCustomer() {
        dialogAddCustomer.close();
    }

    @FXML
    private void showWindowDeleteCustomer() {
        if (tblCustomers.getSelectionModel().getSelectedItems().isEmpty()) {
            Resources.showErrorAlert(stckCustomers, rootCustomers, tblCustomers, "Select an item from the table");
        } else {
            rootCustomers.setEffect(blur);
            disableTable();

            dialogDeleteCustomer = new JFXDialog();
            dialogDeleteCustomer.setTransitionType(JFXDialog.DialogTransition.valueOf(DatabaseHelper.getDialogTransition()));
            dialogDeleteCustomer.setDialogContainer(stckCustomers);
            dialogDeleteCustomer.setBackground(Background.EMPTY);
            dialogDeleteCustomer.setContent(rootDeleteCustomer);
            Resources.styleAlert(dialogDeleteCustomer);
            rootDeleteCustomer.setVisible(true);
            dialogDeleteCustomer.show();

            dialogDeleteCustomer.setOnDialogClosed(ev -> {
                rootDeleteCustomer.setVisible(false);
                tblCustomers.setDisable(false);
                rootCustomers.setEffect(null);
                cleanControls();
            });
        }
    }

    @FXML
    private void hideWindowDeleteCustomer() {
        try {
            dialogDeleteCustomer.close();
        } catch (NullPointerException ex) {}
    }

    @FXML
    private void showWindowUptadeCustomer() {
        if (tblCustomers.getSelectionModel().getSelectedItems().isEmpty()) {
            Resources.showErrorAlert(stckCustomers, rootCustomers, tblCustomers, "Select an item from the table");
        } else {
            showWindowAddCustomer();
            titleWindowAddCustomer.setText("Update customer");
            btnUpdateCustomer.toFront();
            selectedRecord();
        }
    }

    @FXML
    private void showWindowDetailsCustomer() {
        if (tblCustomers.getSelectionModel().getSelectedItems().isEmpty()) {
            Resources.showErrorAlert(stckCustomers, rootCustomers, tblCustomers, "Select an item from the table");
        } else {
            showWindowAddCustomer();
            titleWindowAddCustomer.setText("Customer details");
            btnUpdateCustomer.setVisible(false);
            btnSaveCustomer.setDisable(true);
            btnSaveCustomer.toFront();
            disableControlsEdit();
            selectedRecord();
        }
    }

    private void selectedRecord() {
        Customers customers = tblCustomers.getSelectionModel().getSelectedItem();
        txtFName.setText(customers.getFName());
        txtCustomerNumber.setText(customers.getCustomerNumber());
        txtEmail.setText(customers.getCustomerEmail());
    }

    @FXML
    private void loadData() {
        loadTable();
        colCodigoCliente.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNombreCliente.setCellValueFactory(new PropertyValueFactory<>("FName"));
        colTelefonoCliente.setCellValueFactory(new PropertyValueFactory<>("Phone"));
        colCorreoCliente.setCellValueFactory(new PropertyValueFactory<>("Email"));
        colNitCliente.setCellValueFactory(new PropertyValueFactory<>("Locality"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("LName"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("Address"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("City"));
        colPincode.setCellValueFactory(new PropertyValueFactory<>("Pincode"));
        colState.setCellValueFactory(new PropertyValueFactory<>("State"));
        colCountry.setCellValueFactory(new PropertyValueFactory<>("Country"));
        colGender.setCellValueFactory(new PropertyValueFactory<>("Gender"));
    }

    private void loadTable() {
        ArrayList<Customers> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Customers";
            PreparedStatement preparedStatement = DatabaseConnection.getInstance().getConnection().prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("Customer_ID");
                String FName = resultSet.getString("Fname");
                String LName = resultSet.getString("Lname");
                String Locality = resultSet.getString("Locality");
                String Address = resultSet.getString("CustomerAddress");
                String City = resultSet.getString("City");
                String State = resultSet.getString("CState");
                String Country = resultSet.getString("CState");
                int Pincode = resultSet.getInt("Pincode");
                String Phone = resultSet.getString("Phone_no");
                String Email = resultSet.getString("Email");
                String Password = resultSet.getString("CPassword");
                String Gender = resultSet.getString("Gender");
                list.add(new Customers(id, FName, LName, Phone, Email, Locality, Address, City, State, Pincode, Country, Password, Gender));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseHelper.class.getName()).log(Level.SEVERE, null, ex);
            Resources.showErrorAlert(stckCustomers, rootCustomers, tblCustomers, "An error occurred when connecting to MySQL.\n"
                    + "Check your connection to MySQL");
        }
        listCustomers = FXCollections.observableArrayList(list);
        tblCustomers.setItems(listCustomers);
    }

    @FXML
    private void newCustomer() {
        if (txtFName.getText().isEmpty()) {
            new Shake(txtFName).play();
        } else if (txtCustomerNumber.getText().isEmpty()) {
            new Shake(txtCustomerNumber).play();
        } else if (!validateEmailAddress(txtEmail.getText()) && !txtEmail.getText().isEmpty()) {
            new Shake(txtEmail).play();
            Resources.notification("Error", "Invalid email", "error.png");
        } else {
            Customers customers = new Customers();
            customers.setCustomerNumber(txtCustomerNumber.getText());

            if (txtEmail.getText().isEmpty()) {
                customers.setCustomerEmail("N/A");
            } else {
                customers.setCustomerEmail(txtEmail.getText());
            }

            boolean result = DatabaseHelper.insertNewCustomer(customers, listCustomers);
            if (result) {
                loadData();
                cleanControls();
                hideWindowAddCustomer();
                Resources.showSuccessAlert(stckCustomers, rootCustomers, tblCustomers, "Registry added successfully");
            } else {
                Resources.notification("FATAL ERROR", "An error occurred when connecting to MySQL.", "error.png");
            }
        }
    }

    @FXML
    private void deleteCustomer() {
        boolean result = DatabaseHelper.deleteCustomer(tblCustomers, listCustomers);
        if (result) {
            loadData();  
            cleanControls();
            hideWindowDeleteCustomer();
            Resources.showSuccessAlert(stckCustomers, rootCustomers, tblCustomers, "Registry deleted successfully");
        } else {
            Resources.notification("FATAL ERROR", "An error occurred when connecting to MySQL.", "error.png");
        }
    }

    @FXML
    private void updateCustomer() {
        if (txtFName.getText().isEmpty()) {
            new Shake(txtFName).play();
        } else if (txtCustomerNumber.getText().isEmpty()) {
            new Shake(txtCustomerNumber).play();
        } else if (!validateEmailAddress(txtEmail.getText()) && !txtEmail.getText().isEmpty() && !txtEmail.getText().equals("N/A")) {
            new Shake(txtEmail).play();
            Resources.notification("Error", "Invalid email", "error.png");
        } else {
            Customers customers = tblCustomers.getSelectionModel().getSelectedItem();
            customers.setId(customers.getId());
            customers.setCustomerNumber(txtCustomerNumber.getText());

            if (txtEmail.getText().isEmpty()) {
                customers.setCustomerEmail("N/A");
            } else {
                customers.setCustomerEmail(txtEmail.getText());
            }

            boolean result = DatabaseHelper.updateCustomer(customers);
            if (result) {
                loadData();  
                cleanControls();
                hideWindowAddCustomer();
                Resources.showSuccessAlert(stckCustomers, rootCustomers, tblCustomers, "Registry updated successfully");
            } else {
                Resources.notification("FATAL ERROR", "An error occurred when connecting to MySQL.", "error.png");
            }

        }
    }

    private void cleanControls() {
        txtCustomerNumber.clear();
        txtFName.clear();
        txtEmail.clear();
        txtIt.clear();
    }

    private void disableControlsEdit() {
        txtCustomerNumber.setEditable(false);
        txtFName.setEditable(false);
        txtEmail.setEditable(false);
        txtIt.setEditable(false);
    }

    private void enableControlsEdit() {
        txtCustomerNumber.setEditable(true);
        txtFName.setEditable(true);
        txtEmail.setEditable(true);
        txtIt.setEditable(true);
    }
    
    private void resetValidation() {
        txtCustomerNumber.resetValidation();
        txtFName.resetValidation();
        txtEmail.resetValidation();
        txtIt.resetValidation();
    }
    
    private void disableTable() {
        tblCustomers.setDisable(true);
    }
    
    private boolean validateEmailAddress(String email) {
        String regex = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(email).matches();
    } 

    private void keyEscapeWindows() {
        rootCustomers.setOnKeyReleased((KeyEvent keyEvent) -> {
            if (keyEvent.getCode() == ESCAPE && rootDeleteCustomer.isVisible()) {
                hideWindowDeleteCustomer();
            }
            if (keyEvent.getCode() == ESCAPE && rootAddCustomer.isVisible()) {
                hideWindowAddCustomer();
            }
            try {
                if (keyEvent.getCode() == ESCAPE && jfxDialog.isVisible()) {
                    tblCustomers.setDisable(false);
                    rootCustomers.setEffect(null);
                    jfxDialog.close();
                }
            } catch (NullPointerException ex) {}
        });
    }

    private void escapeWindowWithTextFields() {
        txtFName.setOnKeyReleased(ev -> {
            if (ev.getCode() == ESCAPE) {
                hideWindowAddCustomer();
            }
        });

        txtCustomerNumber.setOnKeyReleased(ev -> {
            if (ev.getCode() == ESCAPE) {
                hideWindowAddCustomer();
            }
        });

        txtEmail.setOnKeyReleased(ev -> {
            if (ev.getCode() == ESCAPE) {
                hideWindowAddCustomer();
            }
        });

        txtIt.setOnKeyReleased(ev -> {
            if (ev.getCode() == ESCAPE) {
                hideWindowAddCustomer();
            }
        });
    }

    private void keyDeleteCustomer() {
        rootCustomers.setOnKeyPressed((KeyEvent keyEvent) -> {
            if (keyEvent.getCode().equals(KeyCode.DELETE)) {
                if (tblCustomers.isDisable()) {
                    System.out.println("To delete, finish saving the record or cancel the operation");
                } else if (tblCustomers.getSelectionModel().getSelectedItems().isEmpty()) {
                    Resources.showErrorAlert(stckCustomers, rootCustomers, tblCustomers, "Select an item from the table");
                } else {
                    deleteCustomer();
                }
            }
        });
    }

    @FXML
    private void filterNameCustomer() {
        String filterName = txtSearchCustomer.getText();
        if (filterName.isEmpty()) {
            tblCustomers.setItems(listCustomers);
        } else {
            filterCustomers.clear();
            for (Customers c : listCustomers) {
                if (c.getFName().toLowerCase().contains(filterName.toLowerCase())) {
                    filterCustomers.add(c);
                }
            }
            tblCustomers.setItems(filterCustomers);
        }
    }

    @FXML
    private void filterNumberCustomer() {
        String filterNumber = txtSearchNumber.getText();
        if (filterNumber.isEmpty()) {
            tblCustomers.setItems(listCustomers);
        } else {
            filterCustomers.clear();
            for (Customers c : listCustomers) {
                if (c.getCustomerNumber().toLowerCase().contains(filterNumber.toLowerCase())) {
                    filterCustomers.add(c);
                }
            }
            tblCustomers.setItems(filterCustomers);
        }
    }
}
