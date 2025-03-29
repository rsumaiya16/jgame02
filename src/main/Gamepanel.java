package main;

import javax.swing.*;
import java.awt.*;



public class Gamepanel extends JPanel implements Runnable {
    //screen settings
    final int originalTileSize=16;
    final int scale =3;
    final int tilesize=originalTileSize*scale;
    final int maxScreenCol=16;
    final int maxScreenRow=12;
    final int screenwidth=tilesize*maxScreenCol;
    final int screenheight=tilesize*maxScreenRow;

    Thread gameThread;

     public Gamepanel(){
         this.setPreferredSize(new Dimension(screenwidth,screenheight));
         this.setBackground(Color.black );
         this.setDoubleBuffered(true);
     }

       public void startgamethread(){
         gameThread =new Thread(this);
         gameThread.start();
       }

    @Override
    public void run() {

         while(gameThread != null){
             System.out.println("the game is running");
         }


         update();

         repaint();


    }
    public void update(){

    }
    public void paintComponent(Graphics g){
         super.paintComponent(g);

         Graphics2D g2=(Graphics2D) g;
         g2.setColor(Color.white);
         g2.fillRect(100,100,tilesize,tilesize);
         g2.dispose();



    }


}
