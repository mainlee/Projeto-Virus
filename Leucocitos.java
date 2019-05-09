/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;
import java.util.Date;
import java.util.Random;
import java.util.ArrayList;
/**
 *
 * @author unifasilva
 */
public class Leucocitos extends Celulas implements IMovable{
    
    private int velocidade = 2;
    private Date nascimento = new Date();
    
    public Leucocitos(){
        setCor(8);
    }
    
    public Leucocitos(int x, int y, int cor, Date idade){
        setNasc(idade);
        setX(x);
        setY(y);
        setCor(cor);
    }

    //Inicio de Getters e Setters
    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public Date getNasc() {
        return nascimento;
    }

    public void setNasc(Date nasc) {
        this.nascimento = nasc;
    }//Fim de Getters e Setters
    
    /**
     * Inicia Leucocitos
     */
    public void startLeuco(ArrayList<Leucocitos> leucos, int m[][] , int cor){
        Date nasc = new Date();
        Random rnd = new Random();
        for(int i =0; i<10;i++){
            int posX = rnd.nextInt(29);
            int posY = rnd.nextInt(59);
            leucos.add(new Leucocitos(posX,posY,8,nasc));
            m[posX][posY] = cor;
        }
    }
    
    /**
     * Essa função tem como objetivo criar um novo leucocito e colocar o mesmo
     * em um posição X e Y aleatória da Matriz
     */
    public void doNewLeu(ArrayList<Leucocitos> leucos, int m[][],int cor){
        Date nasc = new Date();
        Random rnd = new Random();
        int posX = rnd.nextInt(29);
        int posY = rnd.nextInt(59);
        leucos.add(new Leucocitos(posX,posY,8,nasc));
        m[posX][posY] = cor;
    }
    /**
     * Função responsável pela movimentação do Leucocito, nela é gerado um número
     * randomico de 0 a 8, o qual determina em qual direção o Leucocito vai se
     * mover
     */
    @Override
    public void move(int m[][], int x, int y) {
        Random rnd = new Random();
        switch(rnd.nextInt(8)){
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
            case 4:
                if((x-velocidade)>0 && (y-velocidade)>0){
                    setX(x-velocidade);
                    setY(y-velocidade);
                    break;
                }
                setY(59);
                setX(29);
            case 5:
                if((x+velocidade)<29 && (y+velocidade)<59){
                    setX(x+velocidade);
                    setY(y+velocidade);
                    break;
                }
                setY(0);
                setX(0);
            case 6:
                if((y-velocidade)>0 && (x+velocidade)<29){
                    setY(y-velocidade);
                    setX(x+velocidade);
                    break;
                }
                setX(0);
                setY(59);
            case 7:
                if((y+velocidade)<59 && (x-velocidade)>0){
                    setY(y+velocidade);
                    setX(x-velocidade);
                    break;
                }
                setX(29);
                setY(0);
        }
    }
}
