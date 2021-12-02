public class Consumidor implements Runnable {
    @Override
    public void run() {
        while(true){
            try{
                Main.cantidadIteracionesTotales.acquire();
                Main.cantidadProducida.acquire();

                Main.mutex.acquire();
                Main.productos.pop();
                Main.bw.write("Se consumio y hay "+Main.productos.size() + " productos\n");
                Main.mutex.release();

                Main.cantidadConsumida.release();

            }catch (Exception e){}
        }
    }
}
