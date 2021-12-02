import javax.swing.*;
import java.io.*;
import java.util.LinkedList;
import java.util.concurrent.Semaphore;

public class Main {
    public static Semaphore cantidadProducida = new Semaphore(0);
    public static Semaphore cantidadConsumida = new Semaphore(10);
    public static Semaphore mutex = new Semaphore(1);
    public static Semaphore cantidadIteracionesTotales = new Semaphore(12);
    static public LinkedList<Character> productos = new LinkedList<>();
    static public BufferedWriter bw;
    static public BufferedReader br;

    public static void main(String[] args) throws IOException, InterruptedException {
        bw = new BufferedWriter(new FileWriter("C:\\test\\output.txt"));
        br = new BufferedReader(new FileReader("C:\\test\\output.txt"));

        Productor productor = new Productor();
        Thread consumidor = new Thread(new Consumidor());
        consumidor.start();
        productor.start();
        System.out.println("Hola");
        Thread.sleep(5000);
        System.out.println("Hola");
        consumidor.stop();
        productor.stop();
        bw.close();
        System.out.println(br.ready()); //Imprime si el archivo esta listo para ser leido

        Integer i = 0;
        String currentLine;
        while ((currentLine = br.readLine()) != null){
            System.out.println(currentLine);
        }

    }
}
