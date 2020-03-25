/**
 * Sample Skeleton for 'Scene.fxml' Controller Class
 */
package it.polito.tdp.spellchecker;
import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdt.spellchecker.model.Dictionary;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Labeled;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import java.math.*;
public class FXMLController {
    private Dictionary dizionario;
	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ChoiceBox<String> sceltaLingua;

    @FXML
    private TextArea areaParole;

    @FXML
    private Button btnSpell;

    @FXML
    private TextArea areaErrori;

    @FXML
    private TextArea contaErrori;

    @FXML
    private Button btnClear;

    @FXML
    private TextField txtTime;

    @FXML
    void doClearText(ActionEvent event) {
    	areaParole.clear();
    	areaErrori.clear();
    	contaErrori.clear();
    	txtTime.clear();
    	this.dizionario.reset();
    }
    
    @FXML
    void doSpellCheck(ActionEvent event) {
    	long time1=System.nanoTime();
    	String contenuto=areaParole.getText();
    	String lingua=sceltaLingua.getValue();
    	dizionario.loadDictionary(lingua);
    	String risultato=dizionario.spellCheckText(contenuto);
    	areaErrori.setText(risultato);
    	contaErrori.setText("Ci sono "+dizionario.conta()+" errori");
    	long time2=System.nanoTime();
    	double timeSec=((time2-time1)/Math.pow(10, 9));
    	txtTime.setText("Processo durato "+timeSec+" secondi");
    }

    @FXML
    void initialize() {
        assert sceltaLingua != null : "fx:id=\"sceltaLingua\" was not injected: check your FXML file 'Scene.fxml'.";
        assert areaParole != null : "fx:id=\"areaParole\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnSpell != null : "fx:id=\"btnSpell\" was not injected: check your FXML file 'Scene.fxml'.";
        assert areaErrori != null : "fx:id=\"areaErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert contaErrori != null : "fx:id=\"contaErrori\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";
        sceltaLingua.getItems().addAll("English","Italian");
        sceltaLingua.setValue("Italian");
        dizionario=new Dictionary();    
       }
	
}
