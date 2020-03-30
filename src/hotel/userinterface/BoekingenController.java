package hotel.userinterface;

import hotel.model.Boeking;
import hotel.model.Hotel;
import hotel.model.Kamer;
import hotel.model.KamerType;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.List;

public class BoekingenController {


    @FXML public TextField adres;
    @FXML public TextField naam;
    @FXML public DatePicker aankomst;
    @FXML public DatePicker vertrek;
    @FXML public ComboBox<KamerType> kamer;
    @FXML public Button reset;
    @FXML public Button boek;
    @FXML public Label message;


    public void initialize() {
        kamer.setItems(FXCollections.observableList(Hotel.getHotel().getKamerTypen()));
    }

    public void reset(ActionEvent actionEvent) {
        naam.clear();
        adres.clear();
        aankomst.setValue(null);
        vertrek.setValue(null);
        kamer.setValue(null);
        message.setText("Voer uw gegevens in");

    }

    public void boek(ActionEvent actionEvent) throws Exception {
        try{
            if ( (!aankomst.getValue().isBefore(vertrek.getValue())) ||
                    !(aankomst.getValue().isAfter(LocalDate.now())) ||
                    !(vertrek.getValue().isAfter(LocalDate.now()))){
                message.setText("de datum klopt niet, vul een geldige datum in");
            }
            else {

                if (naam.getText() != null &&
                        adres.getText() != null &&
                        aankomst.getValue() != null &&
                        vertrek.getValue() != null &&
                        kamer.getValue() != null) {
                    Hotel.getHotel().voegBoekingToe(aankomst.getValue(), vertrek.getValue(), naam.getText(), adres.getText(), kamer.getValue());
                    message.setText("boekig is gelukt!");
                }
            }

        }catch (Exception e){
            message.setText("vul alle velden in");
        }




    }


}
