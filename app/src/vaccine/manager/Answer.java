package vaccine.manager;

import java.util.Iterator;
import java.util.LinkedList;

public class Answer implements java.io.Serializable{

    private int reply = 0;
    private LinkedList <String> string_data = new LinkedList<>();
    private LinkedList <Integer> int_data = new LinkedList<>();

    public int getReply() {
        return reply;
    }

    public void setReply(int reply) {
        this.reply = reply;
    }

    public LinkedList<String> getString_data() {
        return string_data;
    }
    
    public void setString_data(LinkedList<String> string_data) {
        this.string_data = string_data;
    }

    public void setInt_data(LinkedList<Integer> int_data) {
        this.int_data = int_data;
    }
    
    public LinkedList<Integer> getInt_data() {
        return int_data;
    }

    public String toString() {
        
        String result = "";

        result = result + reply + " ";
        
        Iterator<String> iterator_string = string_data.iterator();
        while (iterator_string.hasNext()) {
            result = result + iterator_string.next() + " ";
        }

        Iterator<Integer> iterator_int = int_data.iterator();
        while (iterator_int.hasNext()) {
            result = result + iterator_int.next() + " ";
        }

        return "Answear: " + result;
    }
}