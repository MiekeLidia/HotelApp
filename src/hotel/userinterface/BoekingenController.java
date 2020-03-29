package hotel.userinterface;

import hotel.model.Boeking;
import hotel.model.Hotel;
import hotel.model.KamerType;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.time.LocalDate;
import java.util.List;

public class BoekingenController {


    public Label adres;
    public TextField naam;
    public DatePicker aankomst;
    public DatePicker vertrek;
    @FXML
    private ComboBox comboBoxKamer;
    public Button reset;
    public Button boek;
    private Hotel hotel = Hotel.getHotel();


//    private Hotel typen = Hotel.getKamerTypen();
//
//    public void initialize() {
//
//        comboBoxKamer.setItems(FXCollections.observableList(Hotel.getKamerTypen));
//        public void aankomst(ActionEvent actionEvent) {
//    }

    public void vertrek(ActionEvent actionEvent) {
    }

    public void kamer(ActionEvent actionEvent) {
    }

    public void reset(ActionEvent actionEvent) {
    }

    public void boek(ActionEvent actionEvent) {
        if (naam != null && adres != null && aankomst != null && vertrek != null && comboBoxKamer != null){
            LocalDate aankomstLD = aankomst.getValue();
            String adresString = String.valueOf(adres);
            //KamerType kamerType = KamerType.comboBoxKamer;

            //Hotel.voegBoekingToe(aankomstLD,vertrek,naam,adresString,);

        }
        else {System.out.println("vull alle velden in");}

    }
}
