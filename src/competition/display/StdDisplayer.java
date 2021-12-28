package competition.display;

/**
 * This class serves to display message on the standart output
 */
public class StdDisplayer implements Displayer {
    /**
     * Display the message msg on the standart output
     * @param msg {String} the message to display
     */
    public void displayMsg(String msg){
        System.out.println(msg);
    }

}
