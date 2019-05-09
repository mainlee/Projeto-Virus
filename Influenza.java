/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author unifasilva
 */
public class Influenza extends Virus{
    
    public Influenza (){
        setCor(9);
    }
    
    public Influenza(int x, int y, int cor, Boolean celula){
        
        setX(x);
        setY(y);
        setCor(cor);
        setCelula(celula);
    }
    
    private Boolean celula = false;
    private int x;
    private int y;
    
    //Métodos Getters e Setters
    public Boolean getCelula() {
        return celula;
    }

    public void setCelula(Boolean celula) {
        this.celula = celula;
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
    //Fim de Getter e Setters
    
    /**
     * Inicia as influenzas em posições aleatórias da matriz
     */
    public void startInflu(ArrayList<Influenza> virus, int m[][] , int cor){
        Random rnd = new Random();
        for(int i =0; i<5;i++){
            int posX = rnd.nextInt(29);
            int posY = rnd.nextInt(59);
            virus.add(new Influenza(posX,posY,9,false));
            m[posX][posY] = cor;
        }
    }
    
    /**
     * Função responsável pela criação de uma nova influenza, sendo a mesma colocada
     * em uma posição X e Y aleatória da Matriz
     */
    public void doNewInflu(ArrayList<Influenza> virus, int m[][],int cor){
        Random rnd = new Random();
        int posX = rnd.nextInt(29);
        int posY = rnd.nextInt(59);
        virus.add(new Influenza(posX,posY,9,false));
        m[posX][posY] = cor;
    }
    
}
