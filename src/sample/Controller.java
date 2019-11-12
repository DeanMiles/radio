package sample;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    private static MediaPlayer player, player2, player3, player4, player5, player6;


    //-------------------------------------------------paski od częstotliwości
    @FXML
    private Rectangle pasek1;
    @FXML
    private Rectangle pasek2;
    @FXML
    private Rectangle pasek3;
    @FXML
    private Rectangle pasek4;

    //-------------------------------------------------slider głośności
    @FXML
    private Slider volume;
    @FXML
    private Slider balance;


    //-------------------------------------------------wskazówki na paskach głośności wzkazujące częstotliwość
    @FXML
    private Rectangle uPasek;
    @FXML
    private Rectangle dPasek;
    @FXML
    private Rectangle sPasek;
    @FXML
    private Rectangle kPasek;

    //-------------------------------------------------Przyciski radio zmieniające pasek częstotliwości
    @FXML
    private RadioButton uButton;
    @FXML
    private RadioButton dButton;
    @FXML
    private RadioButton sButton;
    @FXML
    private RadioButton kButton;
    @FXML


    private ImageView HZ;    //-----------------------gałka od zmiany Hz
    private static boolean ifOn; //--------------------flaga sprawdzająca czy raddio jest włączone
    private int deg; //--------------------------------stopnie o ile ma się przekształcić gałka

    //--------------------------------------------guzik On/Off
    @FXML
    private void OnOff() {

        if (!ifOn) {
            pasek1.setFill(Color.rgb(255, 204, 179));
            pasek2.setFill(Color.rgb(255, 204, 179));
            pasek3.setFill(Color.rgb(255, 204, 179));
            pasek4.setFill(Color.rgb(255, 204, 179));
            ifOn = true;



        } else {
            pasek1.setFill(Color.WHITE);
            pasek2.setFill(Color.WHITE);
            pasek3.setFill(Color.WHITE);
            pasek4.setFill(Color.WHITE);
            ifOn = false;
            player.stop();
            player2.stop();
            player3.stop();
            player4.stop();
            player5.stop();
            player6.stop();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            //----------------------------------------------------------fokus na przyciks U

            uButton.setSelected(true);
            uButton.requestFocus();

            //--------------------------------------------------------ładowanie piosenek i ustawianie paska głośności

            Media media = new Media(getClass().getResource("/sample/resources/queen.mp3").toURI().toString());
            player = new MediaPlayer(media);
            volume.setValue(player.getVolume() * 100);
            balance.setMin(-1);
            balance.setMax(1);
            balance.setValue(player.getBalance());

            Media media2 = new Media(getClass().getResource("/sample/resources/zombie.mp3").toURI().toString());
            player2 = new MediaPlayer(media2);
            volume.setValue(player2.getVolume() * 100);
            balance.setMin(-1);
            balance.setMax(1);
            balance.setValue(player2.getBalance());

            Media media3 = new Media(getClass().getResource("/sample/resources/hotel.mp3").toURI().toString());
            player3 = new MediaPlayer(media3);
            volume.setValue(player3.getVolume() * 100);
            balance.setMin(-1);
            balance.setMax(1);
            balance.setValue(player3.getBalance());

            Media media4 = new Media(getClass().getResource("/sample/resources/eminem.mp3").toURI().toString());
            player4 = new MediaPlayer(media4);
            volume.setValue(player4.getVolume() * 100);
            balance.setMin(-1);
            balance.setMax(1);
            balance.setValue(player4.getBalance());

            Media media5 = new Media(getClass().getResource("/sample/resources/sweet.mp3").toURI().toString());
            player5 = new MediaPlayer(media5);
            volume.setValue(player5.getVolume() * 100);
            balance.setMin(-1);
            balance.setMax(1);
            balance.setValue(player5.getBalance());

            Media media6 = new Media(getClass().getResource("/sample/resources/allstar.mp3").toURI().toString());
            player6 = new MediaPlayer(media6);
            volume.setValue(player6.getVolume() * 100);
            balance.setMin(-1);
            balance.setMax(1);
            balance.setValue(player6.getBalance());


            volume.valueProperty().addListener(new InvalidationListener() {
                @Override
                public void invalidated(Observable observable) {
                    player.setVolume(volume.getValue() / 200);
                    player2.setVolume(volume.getValue() / 200);
                    player3.setVolume(volume.getValue() / 200);
                    player4.setVolume(volume.getValue() / 200);
                    player5.setVolume(volume.getValue() / 200);
                    player6.setVolume(volume.getValue() / 200);
                }
            });

            balance.valueProperty().addListener(new InvalidationListener() {
                @Override
                public void invalidated(Observable observable) {
                    player.setBalance(balance.getValue());
                    player2.setBalance(balance.getValue());
                    player3.setBalance(balance.getValue());
                    player4.setBalance(balance.getValue());
                    player5.setBalance(balance.getValue());
                    player6.setBalance(balance.getValue());
                }
            });

        } catch (Exception e) {

        }

    }


    @FXML
    private void handleMouse(MouseEvent event) {
        if (event.isPrimaryButtonDown()) {
            deg = ((int) event.getSceneX() -600);
            HZ.setStyle("-fx-rotate:" + deg);

            if (ifOn) {
                //-----------------------------------------------jeżeli uButton jest aktywny uPasek jest przesuwany i dana piosenka odtwarzana
                if (deg>-600 && deg<600) {
                    if (uButton.isSelected()) {
                        uPasek.setTranslateX(deg / 2);
                        if (deg > -600 && deg < -400) {
                            player.play();
                        } else player.stop();

                        if (deg > 400 && deg < 600) {
                            player2.play();
                        } else player2.stop();
                    } else {
                        player.stop();
                        player2.stop();
                    }
 //----------------------------------------------kolejny
                    if (dButton.isSelected()) {
                        dPasek.setTranslateX(deg / 2);
                        if (deg > -300 && deg < -200) {
                            player3.play();
                        } else player3.stop();

                        if (deg > 250 && deg < 390) {
                            player4.play();
                        } else player4.stop();
                    } else {
                        player3.stop();
                        player4.stop();
                    }
                    //----------------------------------------kolejny
                   if (sButton.isSelected()) {
                        sPasek.setTranslateX(deg / 2);
                        if (deg > 0 && deg < 200) {
                            player5.play();
                        } else player5.stop();
                    } else {
                        player5.stop();
                    }
                    //------- kolejny
                    if (kButton.isSelected()) {
                        kPasek.setTranslateX(deg / 2);
                        if (deg > -200 && deg < -50) {
                            player6.play();
                        } else player6.stop();
                    } else {
                        player6.stop();
                    }
                }
            }
        }


    }



}