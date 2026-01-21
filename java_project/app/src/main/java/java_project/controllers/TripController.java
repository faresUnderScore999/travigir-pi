package java_project.controllers;

import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java_project.models.Trip;
import java_project.services.TripService;

public class TripController {
    
    @FXML
    private ListView<Trip> tripsListView;
    
    @FXML
    private TextField titleField;
    
    @FXML
    private TextArea descriptionArea;
    
    @FXML
    private TextField destinationField;
    
    @FXML
    private DatePicker startDatePicker;
    
    @FXML
    private DatePicker endDatePicker;
    
    @FXML
    private TextField priceField;
    
    @FXML
    private TextField imageUrlField;
    
    @FXML
    private Button addButton;
    
    @FXML
    private Button deleteButton;

    private ObservableList<Trip> trips;
    private TripService tripService;

    @FXML
    public void initialize() {
        tripService = new TripService();
        trips = FXCollections.observableArrayList();
        tripsListView.setItems(trips);
        loadTrips();
        setupListViewCellFactory();
    }

    private void setupListViewCellFactory() {
        tripsListView.setCellFactory(param -> new ListCell<Trip>() {
            @Override
            protected void updateItem(Trip trip, boolean empty) {
                super.updateItem(trip, empty);
                if (empty || trip == null) {
                    setText(null);
                } else {
                    setText(trip.getTitle() + " - " + trip.getDestination() + " ($" + trip.getPrice() + ")");
                }
            }
        });
    }

    private void loadTrips() {
        try {
            trips.clear();
            trips.addAll(tripService.getAllTrips());
        } catch (Exception e) {
            showAlert("Error", "Failed to load trips: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    public void handleAddTrip() {
        try {
            if (titleField.getText().isEmpty() || destinationField.getText().isEmpty() || 
                priceField.getText().isEmpty() || startDatePicker.getValue() == null || 
                endDatePicker.getValue() == null) {
                showAlert("Validation Error", "Please ca u fill in all required fields");
                return;
            }

            Trip newTrip = new Trip(
                titleField.getText(),
                descriptionArea.getText(),
                destinationField.getText(),
                startDatePicker.getValue(),
                endDatePicker.getValue(),
                Double.parseDouble(priceField.getText()),
                imageUrlField.getText()
            );

            tripService.addTrip(newTrip);
            clearFields();
            loadTrips();
            showAlert("Success", "Trip added successfully!");
        } catch (NumberFormatException e) {
            showAlert("Error", "Price must be a valid number");
        } catch (Exception e) {
            showAlert("Error", "Failed to add trip: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    public void handleDeleteTrip() {
        Trip selectedTrip = tripsListView.getSelectionModel().getSelectedItem();
        if (selectedTrip == null) {
            showAlert("Error", "Please select a trip to delete");
            return;
        }

        try {
            tripService.deleteTrip(selectedTrip.getId());
            loadTrips();
            showAlert("Success", "Trip deleted successfully!");
        } catch (Exception e) {
            showAlert("Error", "Failed to delete trip: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private void clearFields() {
        titleField.clear();
        descriptionArea.clear();
        destinationField.clear();
        priceField.clear();
        imageUrlField.clear();
        startDatePicker.setValue(null);
        endDatePicker.setValue(null);
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
