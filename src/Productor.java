public class Productor extends Thread {



    @Override
    public void run() {
        while(true){
            try{
                Main.cantidadIteracionesTotales.acquire();
                Main.cantidadConsumida.acquire();

                Main.mutex.acquire();
                Main.productos.add('P');
                Main.bw.write("Se produjo y hay "+Main.productos.size() + " productos \n");
                Main.mutex.release();

                Main.cantidadProducida.release();


            }catch (Exception e){}
        }
    }

    public Productor() {
        super();
        // TODO Auto-generated constructor stub
    }

}