
package application;



import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 *
 * @author marez
 */

// pogled za dodavanje novih reci

public class InputView {
    private Dictionary dict;

    public InputView(Dictionary d) {
        this.dict = d;
    }
    
    // metoda za izgradnju i vracanje pogleda
    
    public Parent getView(){
        GridPane gp=new GridPane();
        
        Label l1=new Label("Word");
        TextField tx1=new TextField();
        Label l2=new Label("Translation");
        TextField tx2=new TextField();
        
        gp.setAlignment(Pos.CENTER);
        gp.setVgap(10);
        gp.setHgap(10);
        gp.setPadding(new Insets(10,10,10,10));
        
        Button btn=new Button("Add the word pair");
        gp.add(l1, 0, 0);
        gp.add(tx1, 0, 1);
        gp.add(l2, 0, 2);
        gp.add(tx2, 0, 3);
        gp.add(btn, 0, 4);
        
        // dodavanje akcije na btn, nakon akcije, rec ce biti dodata u this.dict
        
        btn.setOnAction((event)->{
            String wrd=tx1.getText();
            String trans=tx2.getText();
            
            this.dict.add(wrd, trans);
            tx1.clear();
            tx2.clear();
            
        });
        return gp;
    }
}
