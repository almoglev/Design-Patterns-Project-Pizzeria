package OutputHandler;

public class ConsoleApplication implements IOutputHandler{
    public void printMessage(String content){
        System.out.println(content);
    }
}
