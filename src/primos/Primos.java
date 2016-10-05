/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ivan
 */
public class Primos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //buscaprimos();
        int cuan = 10;
        //long[] lis = listaPrimos(934614543253279817L, cuan );
        long[] lis = listaPrimos(900000000000000000L, cuan );
        for( int i = 0; i < cuan; i++ ){
            System.out.println(i + ": " + lis[i] );
        }
        System.out.println("Acabó");
        
    
    }
    
    static void buscaprimos(){
        Esprimo ep = new Esprimo( 934614543253279817L );
        ep.start();
        try {
            ep.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(Primos.class.getName()).log(Level.SEVERE, null, ex);
        }
        if( ep.esprimo )System.out.println("Es primo");
        else System.out.println("no es primo");
    }

    static long[] listaPrimos(long inicio, int cuantos){
        int np = 150;
        long[] n = new long[cuantos];
        Esprimo[] ep = new Esprimo[np];
        long ini = inicio;
        int cont = 0;
        while( cont < cuantos ){
            for( int j = 0; j < np; j++ ){ //arranca los procesos comprobadores
                ep[j] = new Esprimo( ini+j );
                ep[j].start();
            }
            for( int j = 0; j < np; j++ ){
                try {
                    ep[j].join();
                } catch (InterruptedException ex) {}

                if( ep[j].esprimo ){
                    n[cont] = ep[j].num;
                    cont++;
                    System.out.println( ep[j].num + " es primo (" +  cont + ")" );
                }else{
                    System.out.println( ep[j].num + " no es primo");
                }
                if( cont >= cuantos ) break; //pues ya hemos llegado al num de primos
            }
            ini = ini + np;
            System.out.println("----------------");
        }
        return n;
    }
    
    
    
    
}
