import java.io.Serializable;

public class Message implements Serializable {
    // gives an ID to this version of the object
    private static final long serialVersionUID = 1234L;

    private int type;
    private String text;

    public Message(String text, int type){
        this.text = text;
        this.type = type;
    }

    public Message(String text){
        this.text = text;
        this.type = 0;
    }

    public String getText(){
        return text;
    }

    public int getType(){
        return type;
    }

}
