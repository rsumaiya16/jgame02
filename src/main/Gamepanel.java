package main;

import entity.Player;

import javax.swing.*;
import java.awt.*;



public class Gamepanel extends JPanel implements Runnable {
    //screen settings
    final int originalTileSize=16;
    final int scale =3;
    public final int tilesize=originalTileSize*scale;
    final int maxScreenCol=16;
    final int maxScreenRow=12;
    final int screenwidth=tilesize*maxScreenCol;
    final int screenheight=tilesize*maxScreenRow;

    int fps=60;

    Keyhandler keyH=new Keyhandler();
    Thread gameThread;
    Player player=new Player(this,keyH);

    //player's initial position
    int playerX=100;
    int playerY=100;
    int playerspeed=1;

     public Gamepanel(){
         this.setPreferredSize(new Dimension(screenwidth,screenheight));
         this.setBackground(Color.black );
         this.setDoubleBuffered(true);
         this.addKeyListener(keyH);
         this.setFocusable(true);
     }

       public void startgamethread(){
         gameThread =new Thread(this);
         gameThread.start();
       }

    @Override
    public void run() {

         double drawinterval=100000000/fps; //0.01666 sec
        double nextdrawtime=System.nanoTime()+drawinterval;



         while(gameThread != null){


             update();

             repaint();



             try {
                 double remainingtime=nextdrawtime-System.nanoTime();
                 remainingtime=remainingtime/100000;

                 if(remainingtime<0){
                     remainingtime=0;
                 }
                 Thread.sleep((long)remainingtime);

                 nextdrawtime+=drawinterval;
             } catch (InterruptedException e) {
              e.printStackTrace();
             }


         }





    }
    public void update(){
         player.update();

    }
    public void paintComponent(Graphics g){
         super.paintComponent(g);

         Graphics2D g2=(Graphics2D) g;
        player.draw(g2);
         g2.dispose();



    }


}
