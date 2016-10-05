/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primos;

/**
 *
 * @author ivan
 */
public class Esprimo extends Thread {
    
    long num;
    boolean esprimo;
    
    Esprimo( long num ){
        super();
        this.num = num;
    }
    
    @Override
    public void run(){
            esprimo = primo(num);
    }
    
    public static boolean primo(long n) {
        if (n % 2 == 0) {
            return false;
        }
        long fin = (long) Math.sqrt(n);
        for( long i = 3; i < fin; i+=2 ){
            if( n % i == 0) return false;
        }
        return true;
    }
}
