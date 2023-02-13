
package application;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

/**
 *
 * @author marez
 */

// klasa za izradu objekta recnika

public class Dictionary {
    private ArrayList<String> words;
    private HashMap<String, String> translations;

    public Dictionary() {
        this.words = new ArrayList<>();
        this.translations = new HashMap<>();
        
        add("Reka", "River");
    }
    
    public String get(String word){
        return this.translations.get(word);
    }
    
    public void add(String word, String translation){
        if(!(this.translations.containsKey(word))){
            this.words.add(word);
        }
        
        this.translations.put(word, translation);
    }
    
    // dohvatanje nasumicne reci iz recnika
    
    public String randomWord(){
        Random rand=new Random();
        int num=rand.nextInt(this.words.size());
        return this.words.get(num);
    }
    
}
