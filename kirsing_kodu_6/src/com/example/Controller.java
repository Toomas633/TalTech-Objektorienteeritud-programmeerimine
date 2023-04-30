package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class Controller {

    private boolean kasutajaKord = true;
    private boolean Läbi = false;

    @FXML
    private BorderPane borderPane;
    
    @FXML
    private Button Button1;

    @FXML
    private Button Button10;

    @FXML
    private Button Button11;

    @FXML
    private Button Button12;

    @FXML
    private Button Button13;

    @FXML
    private Button Button14;

    @FXML
    private Button Button15;

    @FXML
    private Button Button16;

    @FXML
    private Button Button2;

    @FXML
    private Button Button3;

    @FXML
    private Button Button4;

    @FXML
    private Button Button5;

    @FXML
    private Button Button6;

    @FXML
    private Button Button7;

    @FXML
    private Button Button8;

    @FXML
    private Button Button9;

    @FXML
    private Text Result;

    @FXML
    private Button StartBTN;

    @FXML
    private void Start(ActionEvent event) {
        if (StartBTN.getText().equals("Restart")) {
            disableButtons(true); //Lukusta nupud kui mäng ei käi
            StartBTN.setText("Start");
            Result.setText(""); //Tühjenda võitja
            restart(); //Pane mäng algfaasi tagasi
        } else {
            disableButtons(false); //Ava nupud kasutajale mängu alustamiseks
            StartBTN.setText("Restart");
        }
    }

    @FXML
    private void handleButtonAction(ActionEvent event) {
        if (!Läbi) {
            Button button = (Button) (event.getSource());
            if (button.getText().isEmpty() && !Läbi) {
                if (kasutajaKord) {
                    button.setText("X"); //Kui on mängija kord näita nupul X
                    disableButtons(true); //Lukusta nupud et kasutaja ei saaks rohkem käike teha
                }
                kasutajaKord = !kasutajaKord; //Peale käiku vaheta kelle kord on
                KontrolliLõppu(); //Peale igat käiku kontrolli kas mäng on läbi!
            }
            if (!Läbi) {
                arvutiKäik(); //Kutsu arvuti käik
                kasutajaKord = !kasutajaKord;
                disableButtons(false); //Ava nupud kasutajale peale arvuti käiku
                KontrolliLõppu();
            }
        }
    }

    private void disableButtons(Boolean status) {
        Button1.setDisable(status);
        Button2.setDisable(status);
        Button3.setDisable(status);
        Button4.setDisable(status);
        Button5.setDisable(status);
        Button6.setDisable(status);
        Button7.setDisable(status);
        Button8.setDisable(status);
        Button9.setDisable(status);
        Button10.setDisable(status);
        Button11.setDisable(status);
        Button12.setDisable(status);
        Button13.setDisable(status);
        Button14.setDisable(status);
        Button15.setDisable(status);
        Button16.setDisable(status);
    }

    private void KontrolliLõppu() { //Kontrolli kas on saavutatud võit (4-i järjestikust ühesugust välja)
        String võitja = "";
        if (Kontroll(Button1, Button2, Button3, Button4)) { //Rida 1 "Kontroll" funktsiooni
            võitja = Button1.getText();
        } else if (Kontroll(Button5, Button6, Button7, Button8)) { //Rida 2 "Kontroll" funktsiooni
            võitja = Button5.getText();
        } else if (Kontroll(Button9, Button10, Button11, Button12)) { //Rida 3 "Kontroll" funktsiooni
            võitja = Button9.getText();
        } else if (Kontroll(Button13, Button14, Button15, Button16)) { //Rida 4 "Kontroll" funktsiooni
            võitja = Button13.getText();
        } else if (Kontroll(Button1, Button5, Button9, Button13)) { // Veerg 1 "Kontroll" funktsiooni
            võitja = Button1.getText();
        } else if (Kontroll(Button2, Button6, Button10, Button14)) { // Veerg 2 "Kontroll" funktsiooni
            võitja = Button2.getText();
        } else if (Kontroll(Button3, Button7, Button11, Button15)) { // Veerg 3 "Kontroll" funktsiooni
            võitja = Button3.getText();
        } else if (Kontroll(Button4, Button8, Button12, Button16)) { // Veerg 4 "Kontroll" funktsiooni
            võitja = Button4.getText();
        } else if (Kontroll(Button1, Button6, Button11, Button16)) { //Diagonaal vasak üleval -> parem all (või vastupidi) "Kontroll" funktsiooni
            võitja = Button1.getText();
        } else if (Kontroll(Button4, Button7, Button10, Button13)) { //Diagonaal parem üleval -> vasak all (või vastupidi) "Kontroll" funktsiooni
            võitja = Button4.getText();
        } else if (!Button1.getText().isEmpty() && !Button2.getText().isEmpty() && !Button3.getText().isEmpty() //Kui kõik nupud on täidetud kuid ühesugust 4jast rida/diagonaali pole
                && !Button4.getText().isEmpty() && !Button5.getText().isEmpty() && !Button6.getText().isEmpty() //tagastatakse viik
                && !Button7.getText().isEmpty() && !Button8.getText().isEmpty() && !Button9.getText().isEmpty()
                && !Button10.getText().isEmpty() && !Button11.getText().isEmpty() && !Button12.getText().isEmpty()
                && !Button13.getText().isEmpty() && !Button14.getText().isEmpty() && !Button15.getText().isEmpty()
                && !Button16.getText().isEmpty()) { 
            võitja = "Viik";
        }
        if (!võitja.isEmpty()) { //Kui võitja on leitud
            Läbi = true; //Märgi mäng lõppenuks
            if (võitja.equals("Viik")) { //Kui võitja on viik tagasta "Viik!"
                Result.setText("Viik!");
            } else if (võitja.equals("X")) { //Kui võitja on märk X tagasta "Mängija võitis!"
                Result.setText("Mängija võitis!");
            } else {
                Result.setText("Arvuti võitis!"); //Kui võitja on märk O tagasta "Arvuti võitis!"
            }
        }
    }

    private boolean Kontroll(Button button1, Button button2, Button button3, Button button4) {
        String sisend1 = button1.getText(); //Kontrolli et nupp 1 ei ole tühi ja kõik 4-i nuppu on samad
        String sisend2 = button2.getText();
        String sisend3 = button3.getText();
        String sisend4 = button4.getText();
        return !sisend1.isEmpty() && sisend1.equals(sisend2) && sisend2.equals(sisend3) && sisend3.equals(sisend4);
    }

    private void restart() { //Tühjenda mänguväljaku käigud kui vajutatakse "Restart"
        Button1.setText("");
        Button2.setText("");
        Button3.setText("");
        Button4.setText("");
        Button5.setText("");
        Button6.setText("");
        Button7.setText("");
        Button8.setText("");
        Button9.setText("");
        Button10.setText("");
        Button11.setText("");
        Button12.setText("");
        Button13.setText("");
        Button14.setText("");
        Button15.setText("");
        Button16.setText("");
        kasutajaKord = true;
        Läbi = false;
    }

    private void arvutiKäik() {
        if (blockWinningMove("X")) { //Otsi mängija võidu käiku ja blokeeri see
            return;
        }
        if (blockWinningMove("O")) { //Otsi võidu käiku arvuti jaoks ja tee see kui leidub
            return;
        }
        if (Button1.getText().equals("X") && Button16.getText().isEmpty()) { //Kontrolli vastastikuseid mängija nurki
            Button16.setText("O");
            return;
        }
        if (Button4.getText().equals("X") && Button13.getText().isEmpty()) {
            Button13.setText("O");
            return;
        }
        if (Button13.getText().equals("X") && Button4.getText().isEmpty()) {
            Button4.setText("O");
            return;
        }
        if (Button16.getText().equals("X") && Button1.getText().isEmpty()) {
            Button1.setText("O");
            return;
        }
        if (Button6.getText().isEmpty()) { //Kui keskmine ruut on vaba täida see
            Button6.setText("O");
            return;
        }
        if (Button7.getText().isEmpty()) {
            Button7.setText("O");
            return;
        }
        if (Button10.getText().isEmpty()) {
            Button10.setText("O");
            return;
        }
        if (Button11.getText().isEmpty()) {
            Button11.setText("O");
            return;
        }
        List<Button> emptyCorners = new ArrayList<>(); //Otsi tühje nurki
        if (Button1.getText().isEmpty()) emptyCorners.add(Button1);
        if (Button4.getText().isEmpty()) emptyCorners.add(Button4);
        if (Button13.getText().isEmpty()) emptyCorners.add(Button13);
        if (Button16.getText().isEmpty()) emptyCorners.add(Button16);
        if (!emptyCorners.isEmpty()) {
            int index = (int) (Math.random() * emptyCorners.size()); //Täida tühi nurk suvaliselt
            emptyCorners.get(index).setText("O");
            return;
        }
        List<Button> emptyButtons = new ArrayList<>(); //Kui kõik eelnevad ei tööta tee suvaline käik
        if (Button1.getText().isEmpty()) emptyButtons.add(Button1); 
        if (Button2.getText().isEmpty()) emptyButtons.add(Button2); 
        if (Button3.getText().isEmpty()) emptyButtons.add(Button3); 
        if (Button4.getText().isEmpty()) emptyButtons.add(Button4); 
        if (Button5.getText().isEmpty()) emptyButtons.add(Button5); 
        if (Button6.getText().isEmpty()) emptyButtons.add(Button6); 
        if (Button7.getText().isEmpty()) emptyButtons.add(Button7); 
        if (Button8.getText().isEmpty()) emptyButtons.add(Button8); 
        if (Button9.getText().isEmpty()) emptyButtons.add(Button9); 
        if (Button10.getText().isEmpty()) emptyButtons.add(Button10); 
        if (Button11.getText().isEmpty()) emptyButtons.add(Button11); 
        if (Button12.getText().isEmpty()) emptyButtons.add(Button12); 
        if (Button13.getText().isEmpty()) emptyButtons.add(Button13); 
        if (Button14.getText().isEmpty()) emptyButtons.add(Button14); 
        if (Button15.getText().isEmpty()) emptyButtons.add(Button15); 
        if (Button16.getText().isEmpty()) emptyButtons.add(Button16);
        Random random = new Random(System.currentTimeMillis()); //Vali suvaline ruut tühjadest
        Button selectedButton = emptyButtons.get(random.nextInt(emptyButtons.size()));
        selectedButton.setText("O");
    }

    private boolean blockWinningMove(String märk) {
        //Kontrolli 1st rida
        if (Button1.getText().equals(märk) && Button2.getText().equals(märk) && Button3.getText().equals(märk) && Button4.getText().equals("")) {
            Button4.setText("O");
            return true;
        }
        if (Button1.getText().equals(märk) && Button2.getText().equals(märk) && Button3.getText().equals("") && Button4.getText().equals(märk)) {
            Button3.setText("O");
            return true;
        }
        if (Button1.getText().equals(märk) && Button2.getText().equals("") && Button3.getText().equals(märk) && Button4.getText().equals(märk)) {
            Button2.setText("O");
            return true;
        }
        if (Button1.getText().equals("") && Button2.getText().equals(märk) && Button3.getText().equals(märk) && Button4.getText().equals(märk)) {
            Button1.setText("O");
            return true;
        }
        //Kontrolli 2st rida
        if (Button5.getText().equals(märk) && Button6.getText().equals(märk) && Button7.getText().equals(märk) && Button8.getText().equals("")) {
            Button8.setText("O");
            return true;
        }
        if (Button5.getText().equals(märk) && Button6.getText().equals(märk) && Button7.getText().equals("") && Button8.getText().equals(märk)) {
            Button7.setText("O");
            return true;
        }
        if (Button5.getText().equals(märk) && Button6.getText().equals("") && Button7.getText().equals(märk) && Button8.getText().equals(märk)) {
            Button6.setText("O");
            return true;
        }
        if (Button5.getText().equals("") && Button6.getText().equals(märk) && Button7.getText().equals(märk) && Button8.getText().equals(märk)) {
            Button5.setText("O");
            return true;
        }
        //Kontrolli 3ndat rida
        if (Button9.getText().equals(märk) && Button10.getText().equals(märk) && Button11.getText().equals(märk) && Button12.getText().equals("")) {
            Button12.setText("O");
            return true;
        }
        if (Button9.getText().equals(märk) && Button10.getText().equals(märk) && Button11.getText().equals("") && Button12.getText().equals(märk)) {
            Button11.setText("O");
            return true;
        }
        if (Button9.getText().equals(märk) && Button10.getText().equals("") && Button11.getText().equals(märk) && Button12.getText().equals(märk)) {
            Button10.setText("O");
            return true;
        }
        if (Button9.getText().equals("") && Button10.getText().equals(märk) && Button11.getText().equals(märk) && Button12.getText().equals(märk)) {
            Button9.setText("O");
            return true;
        }
        //Kontrolli 4ndat rida
        if (Button13.getText().equals(märk) && Button14.getText().equals(märk) && Button15.getText().equals(märk) && Button16.getText().equals("")) {
            Button16.setText("O");
            return true;
        }
        if (Button13.getText().equals(märk) && Button14.getText().equals(märk) && Button15.getText().equals("") && Button16.getText().equals(märk)) {
            Button15.setText("O");
            return true;
        }
        if (Button13.getText().equals(märk) && Button14.getText().equals("") && Button15.getText().equals(märk) && Button16.getText().equals(märk)) {
            Button14.setText("O");
            return true;
        }
        if (Button13.getText().equals("") && Button14.getText().equals(märk) && Button15.getText().equals(märk) && Button16.getText().equals(märk)) {
            Button13.setText("O");
            return true;
        }
        //Kontrolli 1st veergu
        if (Button1.getText().equals(märk) && Button5.getText().equals(märk) && Button9.getText().equals(märk) && Button13.getText().equals("")) {
            Button13.setText("O");
            return true;
        }
        if (Button1.getText().equals(märk) && Button5.getText().equals(märk) && Button9.getText().equals("") && Button13.getText().equals(märk)) {
            Button9.setText("O");
            return true;
        }
        if (Button1.getText().equals(märk) && Button5.getText().equals("") && Button9.getText().equals(märk) && Button13.getText().equals(märk)) {
            Button5.setText("O");
            return true;
        }
        if (Button1.getText().equals("") && Button5.getText().equals(märk) && Button9.getText().equals(märk) && Button13.getText().equals(märk)) {
            Button1.setText("O");
            return true;
        }
        //Kontrolli 2st veergu
        if (Button2.getText().equals(märk) && Button6.getText().equals(märk) && Button10.getText().equals(märk) && Button14.getText().equals("")) {
            Button14.setText("O");
            return true;
        }
        if (Button2.getText().equals(märk) && Button6.getText().equals(märk) && Button10.getText().equals("") && Button14.getText().equals(märk)) {
            Button10.setText("O");
            return true;
        }
        if (Button2.getText().equals(märk) && Button6.getText().equals("") && Button10.getText().equals(märk) && Button14.getText().equals(märk)) {
            Button6.setText("O");
            return true;
        }
        if (Button2.getText().equals("") && Button6.getText().equals(märk) && Button10.getText().equals(märk) && Button14.getText().equals(märk)) {
            Button2.setText("O");
            return true;
        }
        //Kontrolli 3ndat veergu
        if (Button3.getText().equals(märk) && Button7.getText().equals(märk) && Button11.getText().equals(märk) && Button15.getText().equals("")) {
            Button15.setText("O");
            return true;
        }
        if (Button3.getText().equals(märk) && Button7.getText().equals(märk) && Button11.getText().equals("") && Button15.getText().equals(märk)) {
            Button11.setText("O");
            return true;
        }
        if (Button3.getText().equals(märk) && Button7.getText().equals("") && Button11.getText().equals(märk) && Button15.getText().equals(märk)) {
            Button7.setText("O");
            return true;
        }
        if (Button3.getText().equals("") && Button7.getText().equals(märk) && Button11.getText().equals(märk) && Button15.getText().equals(märk)) {
            Button3.setText("O");
            return true;
        }
        //Kontrolli 4ndat veergu
        if (Button4.getText().equals(märk) && Button8.getText().equals(märk) && Button12.getText().equals(märk) && Button16.getText().equals("")) {
            Button16.setText("O");
            return true;
        }
        if (Button4.getText().equals(märk) && Button8.getText().equals(märk) && Button12.getText().equals("") && Button16.getText().equals(märk)) {
            Button12.setText("O");
            return true;
        }
        if (Button4.getText().equals(märk) && Button8.getText().equals("") && Button12.getText().equals(märk) && Button16.getText().equals(märk)) {
            Button8.setText("O");
            return true;
        }
        if (Button4.getText().equals("") && Button8.getText().equals(märk) && Button12.getText().equals(märk) && Button16.getText().equals(märk)) {
            Button4.setText("O");
            return true;
        }
        //Kontrolli vasak-parem diagonaali
        if (Button1.getText().equals(märk) && Button6.getText().equals(märk) && Button11.getText().equals(märk) && Button16.getText().equals("")) {
            Button16.setText("O");
            return true;
        }
        if (Button1.getText().equals(märk) && Button6.getText().equals(märk) && Button11.getText().equals("") && Button16.getText().equals(märk)) {
            Button11.setText("O");
            return true;
        }
        if (Button1.getText().equals(märk) && Button6.getText().equals("") && Button11.getText().equals(märk) && Button16.getText().equals(märk)) {
            Button6.setText("O");
            return true;
        }
        if (Button1.getText().equals("") && Button6.getText().equals(märk) && Button11.getText().equals(märk) && Button16.getText().equals(märk)) {
            Button1.setText("O");
            return true;
        }
        //Kontrolli parem-vasak diagonaali
        if (Button13.getText().equals(märk) && Button10.getText().equals(märk) && Button7.getText().equals(märk) && Button4.getText().equals("")) {
            Button4.setText("O");
            return true;
        }
        if (Button13.getText().equals(märk) && Button10.getText().equals(märk) && Button7.getText().equals("") && Button4.getText().equals(märk)) {
            Button7.setText("O");
            return true;
        }
        if (Button13.getText().equals(märk) && Button10.getText().equals("") && Button7.getText().equals(märk) && Button4.getText().equals(märk)) {
            Button10.setText("O");
            return true;
        }
        if (Button13.getText().equals("") && Button10.getText().equals(märk) && Button7.getText().equals(märk) && Button4.getText().equals(märk)) {
            Button13.setText("O");
            return true;
        }
        return false;
    }
}
