package projeto;

import java.util.Date;

/**
 *
 * @author Anderson Simao
 * @version 1.0
 */
public class Projeto {

    /**
     * Principal função do programa
     */
    public static void main(String[] args) throws InterruptedException {
        Cabeca c = new Cabeca();
        c.desenhaCabeca();
        /**
         * Este loop faz com que a tenha sensação de movimento no terminal
         */
            while(true){
                //Timer
                Date realTime = new Date();
               
                System.out.printf("Tempo de simualacao(em ms): \t %d", (realTime.getTime()-c.getDate().getTime())/1000);
                System.out.println("\nInfluenzas: "+c.getInflusize()+"\t Leucocitos: "+ c.getLeucosize()+"\n");
                System.out.println("");

                //Cabeca
                c.updatePos();
                c.desenhaCabeca();
                Thread.sleep(100);
            }
           
        
    }
    
}
