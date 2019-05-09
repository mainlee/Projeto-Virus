/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author unifasilva
 */

public class Cabeca{
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String BLACK_BACKGROUND = "\u001B[40m"; 
    public static final String WHITE_BACKGROUND = "\u001B[47m"; // Borda
    public static final String BLUE_BACKGROUND = "\u001B[44m"; // Olho
    public static final String GREEN_BACKGROUND = "\u001B[42m"; // Nariz
    public static final String RED_BACKGROUND = "\u001B[41m"; //Boca
    public static final String YELLOW_BACKGROUND = "\033[43m"; //Leucocitos
    public static final String PURPLE_BACKGROUND = "\033[45m"; //Influenza
    
    public int mapa[][] = new int [30][60];
    
    public static ArrayList<Leucocitos> ArrayLeuco = new ArrayList<>();
    public static ArrayList<Influenza> ArrayInflu = new ArrayList<>();
    public static ArrayList<CelulasOculares> olhos = new ArrayList<>();
    public static ArrayList<CelulasNasais> nariz = new ArrayList<>();
    public static ArrayList<CelulasBoca> boca = new ArrayList<>();
    
    Date iniTime = new Date();
            
    CelulasOculares o = new CelulasOculares();
    CelulasNasais n = new CelulasNasais();
    CelulasBoca b = new CelulasBoca();
    Leucocitos leuco = new Leucocitos();
    Influenza influ = new Influenza();
    
    public Cabeca(){
        /**
         * Este laço tem como função preencher todos os espaços de 0 menos as
         * bordas, que serão colocados o valor 1
         */
        for(int i=0;i<30; i++){
            for(int j=0;j<60;j++){
                if(i==0 || j==0 || i==29 || j==59){
                    mapa[i][j] = 1;
                }
                else{
                    mapa[i][j] = 0;
                }
            }
        }
        
        /**
         * Este laço tem como função preencher as posições das celulas com suas
         * respectivas cores
         */
        for(int i=1;i<29;i++){
            for(int j=1;j<59;j++){
                if(i<12 && i>3){
                    if(j<20 && j>5){   
                        mapa[i][j] = o.getCor();
                        olhos.add(new CelulasOculares(i,j));
                    }
                   else if(j<54 && j>39){
                        mapa[i][j] = o.getCor();
                        olhos.add(new CelulasOculares(i,j));
                   }
                }

                if(i<18 && i>13){
                    if(j<34 && j>24){
                        mapa[i][j] = n.getCor();
                        nariz.add(new CelulasNasais(i,j));
                    }
                }
                if(i == 20){
                    if(j == 10 || j==11 || j==49 || j == 50){
                        mapa[i][j] = b.getCor();
                        boca.add(new CelulasBoca(i,j));
                    }
                }
                if(i == 21){
                    if(j == 11 || j==12 || j==48 || j == 49){
                        mapa[i][j] = b.getCor();
                        boca.add(new CelulasBoca(i,j));
                    }
                }
                if(i == 22){
                    if(j == 12 || j==13 || j==47 || j == 48){
                        mapa[i][j] = b.getCor();
                        boca.add(new CelulasBoca(i,j));
                    }
                }
                if(i == 23){
                    if(j>11 && j<49){
                        mapa[i][j] = b.getCor();
                        boca.add(new CelulasBoca(i,j));
                    }
                }
                if(i == 24){
                    if(j>12 && j<48){
                        mapa[i][j] = b.getCor();
                        boca.add(new CelulasBoca(i,j));
                    }
                }
                if(i == 25){
                    if(j>14 && j<46){
                        mapa[i][j] = b.getCor();
                        boca.add(new CelulasBoca(i,j));
                    }
                }
            }
        }
        /**
         * Essas funções iniciam o Leucocitos e Influenzas
         */
        influ.startInflu(ArrayInflu,mapa, influ.getCor());
        leuco.startLeuco(ArrayLeuco,mapa,leuco.getCor());
    }
    
    public int getInflusize(){
        return ArrayInflu.size();
    }
    
    public int getLeucosize(){
        return ArrayLeuco.size();
    }
    
    public Date getDate(){
        return iniTime;
    }
    /**
     * Função para atualizar a posição dos Leucocitos e Influenza, também foi
     * utilizada para ajustar o tamanho do arrayList e atualizar a idade dos
     * Leucocitos
     */
    public void updatePos(){
        ArrayInflu.trimToSize();
        ArrayLeuco.trimToSize();
        updatePosInflu();
        updatePosLeu();
        updateAgeLeu();
    }
    
    /**
     * Função responsavel pela remoção dos Leucocitos dado o número de vivos
     * e seu tempo de vida
     */
    public void updateAgeLeu(){
        Date realTimeLeu = new Date();
        for(int k = 0;k<ArrayLeuco.size();k++){
            if(ArrayLeuco.size()>10 && realTimeLeu.getTime()- ArrayLeuco.get(k).getNasc().getTime()> 7000){
                ArrayLeuco.remove(k);
            }
        }
    }
    /**
    * Atualiza posição das Influenza na cabeça
    */
    public void updatePosInflu(){
        for(int k=0;k<ArrayInflu.size();k++){
            int posX_ant = ArrayInflu.get(k).getX();
            int posY_ant = ArrayInflu.get(k).getY();

            ArrayInflu.get(k).move(mapa,ArrayInflu.get(k).getX(),ArrayInflu.get(k).getY());
            
            for(int i=0;i<29;i++){
                for(int j=0;j<59;j++){
                    if(i == ArrayInflu.get(k).getX() && j == ArrayInflu.get(k).getY()){
                        mapa[i][j] = influ.getCor();
                    }
                    else if(i == 0 || i == 29 || j == 0 || j==59){
                        mapa[i][j] = 1;
                    }
                    else{
                        for(int l=0;l<olhos.size();l++){
                            if(posX_ant == olhos.get(l).getX() && posY_ant == olhos.get(l).getY()){
                                mapa[posX_ant][posY_ant] = o.getCor();
                            }
                            if(ArrayInflu.get(k).getX() == olhos.get(l).getX() && ArrayInflu.get(k).getY() == olhos.get(l).getY()){
                                if(ArrayInflu.get(k).getCelula() == false){
                                    influ.doNewInflu(ArrayInflu, mapa, influ.getCor());
                                }
                                ArrayInflu.get(k).setCelula(true);
                            }
                        }
                        for(int l=0;l<boca.size();l++){
                            if(posX_ant == boca.get(l).getX() && posY_ant == boca.get(l).getY()){
                                mapa[posX_ant][posY_ant] = b.getCor();
                            }
                            if(ArrayInflu.get(k).getX() == boca.get(l).getX() && ArrayInflu.get(k).getY() == boca.get(l).getY()){
                                if(ArrayInflu.get(k).getCelula() == false){
                                    influ.doNewInflu(ArrayInflu, mapa, influ.getCor());
                                }
                                ArrayInflu.get(k).setCelula(true);
                            }
                        }
                        for(int l=0;l<nariz.size();l++){
                            if(posX_ant == nariz.get(l).getX() && posY_ant == nariz.get(l).getY()){
                                mapa[posX_ant][posY_ant] = n.getCor();
                            }
                            if(ArrayInflu.get(k).getX() == nariz.get(l).getX() && ArrayInflu.get(k).getY() == nariz.get(l).getY()){
                                if(ArrayInflu.get(k).getCelula() == false){
                                    influ.doNewInflu(ArrayInflu, mapa, influ.getCor());
                                }
                                ArrayInflu.get(k).setCelula(true);
                            }
                        }
                    }
                    if(mapa[ArrayInflu.get(k).getX()][ArrayInflu.get(k).getY()] == 0){
                        ArrayInflu.get(k).setCelula(false);
                        
                    }
                    /**
                     * Verifica onde estava pintado e caso não seja celula ou borda
                     * ele pinta de branco
                     */
                    if(mapa[posX_ant][posY_ant]!=2 && mapa[posX_ant][posY_ant]!=3 && mapa[posX_ant][posY_ant]!=4){
                        mapa[posX_ant][posY_ant] = 0;
                    }
                }
            }
        }
    }
    
    /**
     * Semelhante a função updatePosInflu(), porém agora essa função é responsável
     * pela posição dos Leucocitos
     */
    public void updatePosLeu(){
        for(int k=0;k<ArrayLeuco.size();k++){
            int posX_ant = ArrayLeuco.get(k).getX();
            int posY_ant = ArrayLeuco.get(k).getY();
            
            ArrayLeuco.get(k).move(mapa,ArrayLeuco.get(k).getX(),ArrayLeuco.get(k).getY());
            
            for(int i=0;i<29;i++){
                for(int j=0;j<59;j++){
                    if(i == ArrayLeuco.get(k).getX() && j == ArrayLeuco.get(k).getY()){
                        mapa[i][j] = leuco.getCor();
                    }
                    else if(i == 0 || i == 29 || j == 0 || j==59){
                        mapa[i][j] = 1;
                    }
                    else{
                        for(int l=0;l<ArrayInflu.size();l++){
                            if(ArrayLeuco.get(k).getX() == ArrayInflu.get(l).getX() && ArrayLeuco.get(k).getY() == ArrayInflu.get(l).getY()){
                                leuco.doNewLeu(ArrayLeuco,mapa,leuco.getCor());
                                ArrayInflu.remove(l);
                            }
                        }
                        for(int l=0;l<nariz.size();l++){
                            if(posX_ant == nariz.get(l).getX() && posY_ant == nariz.get(l).getY()){
                                mapa[posX_ant][posY_ant] = n.getCor();
                            }
                        }
                        for(int l=0;l<boca.size();l++){
                            if(posX_ant == boca.get(l).getX() && posY_ant == boca.get(l).getY()){
                                mapa[posX_ant][posY_ant] = b.getCor();
                            }
                        }
                        for(int l=0;l<olhos.size();l++){
                            if(posX_ant == olhos.get(l).getX() && posY_ant == olhos.get(l).getY()){
                                mapa[posX_ant][posY_ant] = o.getCor();
                            }
                        }
                    }
                    if(mapa[posX_ant][posY_ant]!=2 && mapa[posX_ant][posY_ant]!=3 && mapa[posX_ant][posY_ant]!=4){
                        mapa[posX_ant][posY_ant] = 0;
                    }
                }
            }
        }

    }
    
    /**
     * Função responsavel pela coloração da cabeça
    */
    public void desenhaCabeca(){
        for(int i=0;i<30;i++){
            for(int j=0; j<60;j++){
                if(mapa[i][j] == 1){
                    System.out.print(WHITE_BACKGROUND +" "+ANSI_RESET);
                }
                if(mapa[i][j] == 0){
                    System.out.print(BLACK_BACKGROUND+" "+ANSI_RESET);
                }
                if(mapa[i][j] == 2){
                    System.out.print(BLUE_BACKGROUND+" "+ANSI_RESET);
                }
                if(mapa[i][j] == 3){
                    System.out.print(GREEN_BACKGROUND+" "+ANSI_RESET);
                }
                if(mapa[i][j] == 4){
                    System.out.print(RED_BACKGROUND+" "+ANSI_RESET);
                }
                if(mapa[i][j] == 8){
                    System.out.print(PURPLE_BACKGROUND+" "+ANSI_RESET);
                }
                if(mapa[i][j] == 9){
                    System.out.print(YELLOW_BACKGROUND+" "+ANSI_RESET);
                }
            }
            System.out.println("");
        }
    }
}
