package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author marez
 */


public class PracticeApplication extends Application{
    
    private Dictionary dict;
    
    public static void main(String[] args){
        launch(PracticeApplication.class);
    }
    
    @Override
    public void init() throws Exception{
        this.dict=new Dictionary(); 
    }

    /* postavka pocetnog prozora aplikacije - generisanje dva pogleda koja ce biti zaduzena za prikazivanje prozora za dodavanje novih reci i za pogadjanje reci 
       i definisanje odgovarajucih buttona za promenu istih
    */
    
    @Override
    public void start(Stage arg0) throws Exception {
        PracticeView pv=new PracticeView(dict);
        InputView iv=new InputView(dict); 
        
        
        BorderPane bp=new BorderPane();
        
        HBox menu=new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);
        
        Button btn1=new Button("Enter new word");
        Button btn2=new Button("Practice");
        
        menu.getChildren().addAll(btn1,btn2);
        bp.setTop(menu);
        
        btn1.setOnAction((event)->bp.setCenter(iv.getView()));
        btn2.setOnAction((event)->bp.setCenter(pv.getView()));
        
        bp.setCenter(iv.getView());
        Scene scene1=new Scene(bp, 500, 500);
        
        arg0.setScene(scene1);
        arg0.show();
    }
    
    
}
