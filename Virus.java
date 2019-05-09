/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;

import java.util.Random;

/**
 *
 * @author unifasilva
 */
public abstract class Virus implements IMovable{
    private int velocidade = 1;
    private int cor = 9;
    private int x;
    private int y;

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
    /**
     * Método responsável pela movimentação do vírus Influenza, é gerado um número
     * aleatório de 0 a 3, o qual define a direção que ela vai se mover
     */
    @Override
    public void move(int m[][], int x, int y) {
        Random rnd = new Random();
        switch(rnd.nextInt(4)){
            case 0:
                if((x-velocidade)>0){
                    setX(x-velocidade);
                    break;
                }
                setX(29);
            case 1:
                if((x+velocidade)<29){
                    setX(x+velocidade);
                    break;
                }
                setX(0);
            case 2:
                if((y-velocidade)>0){
                    setY(y-velocidade);
                    break;
                }
                setY(59);
            case 3:
                if((y+velocidade)<59){
                    setY(y+velocidade);
                    break;
                }
                 setY(0);
        }
    }
    
    
}
