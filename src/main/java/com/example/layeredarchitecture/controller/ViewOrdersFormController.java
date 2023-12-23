package com.example.layeredarchitecture.controller;

import com.example.layeredarchitecture.bo.BOFactory;
import com.example.layeredarchitecture.bo.custom.QueryBO;
import com.example.layeredarchitecture.bo.custom.impl.QueryBOImpl;
import com.example.layeredarchitecture.model.CustomDTO;
import com.example.layeredarchitecture.view.tdm.CustomTM;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class ViewOrdersFormController {
    @FXML
    private AnchorPane root;

    @FXML
    private TableColumn<?, ?> colCusId;

    @FXML
    private TableColumn<?, ?> colCusName;

    @FXML
    private TableColumn<?, ?> colItemDescription;

    @FXML
    private TableColumn<?, ?> colOId;

    @FXML
    private TableColumn<?, ?> colQty;

    @FXML
    private TableColumn<?, ?> colUnitPrice;

    @FXML
    private TableColumn<?, ?> colDate;

    @FXML
    private TableView<CustomTM> tableView;

    @FXML
    private TextField txtSearch;
    QueryBO queryBO = (QueryBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.QUERY);

    public void initialize(){
        setCellValueFactory();
        txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            searchOrders(newValue);
        });
    }

    private void setCellValueFactory() {
        colOId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        colCusId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colCusName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colItemDescription.setCellValueFactory(new PropertyValueFactory<>("itemDescription"));
        colQty.setCellValueFactory(new PropertyValueFactory<>("qty"));
        colUnitPrice.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("orderDate"));
    }

    private void searchOrders(String name) {
        tableView.getItems().clear();
        try {
            ArrayList<CustomDTO> customDTOS = queryBO.customerOrderDetails(name);
            System.out.println(customDTOS);

            for (CustomDTO dto : customDTOS){
                tableView.getItems().add(
                        new CustomTM(
                                dto.getOrderId(),
                                dto.getId(),
                                dto.getName(),
                                dto.getItemDescription(),
                                dto.getQty(),
                                dto.getUnitPrice(),
                                dto.getOrderDate()
                        )
                );
            }
        }catch (Exception e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void navigateToHome(MouseEvent event) throws IOException {
        URL resource = this.getClass().getResource("/com/example/layeredarchitecture/main-form.fxml");
        Parent root = FXMLLoader.load(resource);
        Scene scene = new Scene(root);
        Stage primaryStage = (Stage) (this.root.getScene().getWindow());
        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        Platform.runLater(() -> primaryStage.sizeToScene());
    }

}
