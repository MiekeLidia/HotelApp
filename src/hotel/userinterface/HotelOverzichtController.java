package hotel.userinterface;

import hotel.model.Boeking;
import hotel.model.Hotel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HotelOverzichtController {
    @FXML private Label hotelnaamLabel;
    @FXML private ListView boekingenListView;
    @FXML private DatePicker overzichtDatePicker;

    private Hotel hotel = Hotel.getHotel();

    public void initialize() {
        hotelnaamLabel.setText("Boekingen hotel " + hotel.getNaam());
        overzichtDatePicker.setValue(LocalDate.now());
        toonBoekingen();
    }

    public void toonVorigeDag(ActionEvent actionEvent) {
        LocalDate dagEerder = overzichtDatePicker.getValue().minusDays(1);
        overzichtDatePicker.setValue(dagEerder);
    }

    public void toonVolgendeDag(ActionEvent actionEvent) {
        LocalDate dagLater = overzichtDatePicker.getValue().plusDays(1);
        overzichtDatePicker.setValue(dagLater);
    }

    public void nieuweBoeking(ActionEvent actionEvent) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("Boekingen.fxml"));   Parent root = loader.load();
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.initModality(Modality.APPLICATION_MODAL);
        newStage.showAndWait();
        initialize();

        // Maak in je project een nieuwe FXML-pagina om boekingen te kunnen invoeren
        // Open de nieuwe pagina in deze methode
        // Zorg dat de gebruiker ondertussen geen gebruik kan maken van de HotelOverzicht-pagina
        // Update na sluiten van de nieuwe pagina het boekingen-overzicht
    }

    public void toonBoekingen() {
        ObservableList<String> boekingen = FXCollections.observableArrayList();

        //boekingen.add(Boeking.getAankomstDatum);
        for (Boeking boeking : hotel.getBoekingen()){
            if (overzichtDatePicker.getValue().isEqual(boeking.getAankomstDatum())){
//                DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
//                String strDate = dateFormat.format(boeking.getAankomstDatum());
//                boekingen.add(strDate);
                String aankomstString  = String.valueOf((boeking.getAankomstDatum()));
                String vertrekString  = String.valueOf((boeking.getVertrekDatum()));

                boekingen.add(aankomstString + vertrekString + boeking.getKamer() + boeking.getBoeker());


            }


        }


                // Vraag de boekingen op bij het Hotel-object.
        // Voeg voor elke boeking in nette tekst (string) toe aan de boekingen-lijst.

        boekingenListView.setItems(boekingen);
    }
}