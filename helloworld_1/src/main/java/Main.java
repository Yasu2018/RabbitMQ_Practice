public class Main {
    public static void main(String[] args)throws Exception{

        //Sender.send(args);
        Receiver.receive(args);

        /*
        while(true) {
            Sender.send(args);
            Thread.sleep(1000);
        }
        */
    }
}
