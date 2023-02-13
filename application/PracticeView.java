
package application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author marez
 */

//izgradnja pogleda za vezbanje

public class PracticeView {
    private Dictionary dict;
    private String word;

    public PracticeView(Dictionary dict) {
        this.dict = dict;
        this.word = this.dict.randomWord();
    }
    
    // metoda za vracanje pogleda 
    
    public Parent getView(){
        GridPane gp=new GridPane();
        
        Label l1=new Label("Translate the word: " + this.word);
        TextField tx=new TextField();
        
        gp.setAlignment(Pos.CENTER);
        gp.setVgap(10);
        gp.setHgap(10);
        gp.setPadding(new Insets(10,10,10,10));
        
        Button btnCheck=new Button("Check");
        Label feedback=new Label("");
        
        gp.add(l1, 0, 0);
        gp.add(tx, 0, 1);
        gp.add(btnCheck, 0, 2);
        gp.add(feedback, 0, 3);
        
        /* dodavanje setOn akcije na button, nakon unosenja odgovora, proverava se odgovor, 
            ukoliko je odgovor tacan, rec se uklanja iz recnika i generise se sledeca random
            rec, ukoliko je odgovor netacan, ispisuje se isparavan odgovor i prelazi na narednu rec
        */
        
        btnCheck.setOnAction((event)->{
            String translation=tx.getText();
            if(this.dict.get(word).equals(translation)){
                feedback.setText("Correct!");
            } else {
                feedback.setText("Fail! Translaton of the word: " + this.word + " is " + this.dict.get(word));
            }
            
            
            this.word=this.dict.randomWord();
            
            l1.setText("Translate the word: " + this.word);
            tx.clear();
            
        });
        
        return gp;
    }
    
    
}
