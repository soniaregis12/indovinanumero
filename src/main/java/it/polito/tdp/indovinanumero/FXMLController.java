package it.polito.tdp.indovinanumero;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class FXMLController {

	
	private final int NMAX = 100;
	private final int TMAX = 8;
	private int segreto;
	private int tentativi;
	private boolean inGioco = false;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private Button btnNuova;

    @FXML
    private TextField txtRimasti;

    @FXML
    private HBox layoutTentativo;

    @FXML
    private TextField txtTentativi;

    @FXML
    private Button btnProva;

    @FXML
    void doNuova(ActionEvent event) {
    	// gestione inizio di una nuova partita
    	this.segreto = (int) (Math.random() * NMAX) + 1;
    	this.tentativi = 0;
    	this.inGioco = true;
    	
    	// gestione interfaccia, abilitare Hbox
    	layoutTentativo.setDisable(false);
    	txtRisultato.clear();
    	txtRimasti.setText(Integer.toString(TMAX));

    }

    @FXML
    void doTentativo(ActionEvent event) {
    	// leggi imput utente
    	String tentativo = txtTentativi.getText();
    	int tentativoInt;
    	
    	try {
    		tentativoInt = Integer.parseInt(tentativo);
    	}catch(NumberFormatException e) {
    		txtRisultato.appendText("Devi inerire un numero, coglione!");
    		return ;
    	}
    	
    	this.tentativi++;
    	
    	if(this.segreto == tentativoInt) {		// ho vinto
    		txtRisultato.appendText("Hai vinto! Hai utilizzato: " + this.tentativi + "tentativi");
    		layoutTentativo.setDisable(true);
    		this.inGioco = false;
    		return;
    	}
    	
    	if(tentativoInt == TMAX) {		// ho perso
    		txtRisultato.appendText("Hai perso! Il numero segreto era: " + this.segreto);
    		layoutTentativo.setDisable(true);
    		this.inGioco = false;
    		return;
    	}
    	
    	if(tentativoInt < this.segreto) {
    		txtRisultato.appendText("Tentativo troppo basso\n");
    	}else {
    		txtRisultato.appendText("Tentativo tropo alto\n");
    	}
    	txtRimasti.setText(Integer.toString(TMAX - tentativi));
    }

    @FXML
    void initialize() {
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnNuova != null : "fx:id=\"btnNuova\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRimasti != null : "fx:id=\"txtRimasti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert layoutTentativo != null : "fx:id=\"layoutTentativo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTentativi != null : "fx:id=\"txtTentativi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnProva != null : "fx:id=\"btnProva\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
