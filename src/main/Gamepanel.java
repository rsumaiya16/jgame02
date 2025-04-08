package main;

import entity.Player;
import object.Superobject;
import tile.Tilemanager;

import javax.swing.*;
import java.awt.*;



public class Gamepanel extends JPanel implements Runnable {
    //screen settings
    final int originalTileSize=16;
    final int scale =3;
    public final int tilesize=originalTileSize*scale;
    public final int maxScreenCol=16;
    public final int maxScreenRow=12;
    public final int screenwidth=tilesize*maxScreenCol;
    public final int screenheight=tilesize*maxScreenRow;

    //world map paarameter.
    public final int maxworldcol=50;
    public final int maxworldrow=50;
    public final int worldwidth=tilesize*maxworldcol;
    public final int worldheight=tilesize*maxworldrow;


    int fps=60;

    Tilemanager tilem= new Tilemanager(this);
    Keyhandler keyH=new Keyhandler();
    Thread gameThread;
    public Collisioncheck cchecker= new Collisioncheck(this);
    public AssetSetter asetter= new AssetSetter(this);
    public Ui ui=new Ui(this);
    public Player player=new Player(this,keyH);
    public Superobject obj[]=new Superobject[10];


     public Gamepanel(){
         this.setPreferredSize(new Dimension(screenwidth,screenheight));
         this.setBackground(Color.black );
         this.setDoubleBuffered(true);
         this.addKeyListener(keyH);
         this.setFocusable(true);
     }
     public void setupGame(){
         asetter.setobject();
     }

       public void startgamethread(){
         gameThread =new Thread(this);
         gameThread.start();
       }

    @Override
//    public void run() {
//
//         double drawinterval=100000000/fps; //0.01666 sec
//        double nextdrawtime=System.nanoTime()+drawinterval;
//
//
//
//         while(gameThread != null){
//
//
//             update();
//
//             repaint();
//
//
//
//             try {
//                 double remainingtime=nextdrawtime-System.nanoTime();
//                 remainingtime=remainingtime/100000;
//
//                 if(remainingtime<0){
//                     remainingtime=0;
//                 }
//                 Thread.sleep((long)remainingtime);
//
//                 nextdrawtime+=drawinterval;
//             } catch (InterruptedException e) {
//              e.printStackTrace();
//             }
//
//
//         }
//
//
//
//
//
//    }
    public void run(){
        double drawinterval=100000000/fps;
        double delta=0;
        long lasttime=System.nanoTime();
       long currenttime;
       long timer=0;
       long drawcount=0;

        while(gameThread!=null){
            currenttime=System.nanoTime();

            delta+=(currenttime-lasttime)/drawinterval;
            timer+=(currenttime-lasttime);
            lasttime=currenttime;

            if(delta>1){
            update();
            repaint();
            delta--;
            drawcount++;

            }
            if(timer>100000000){
                System.out.println("fps"+drawcount);
                drawcount=0;
                timer=0;
            }

         }
    }
    public void update(){
         player.update();

    }
    public void paintComponent(Graphics g){
         super.paintComponent(g);


         Graphics2D g2=(Graphics2D) g;

         //tile
         tilem.draw(g2);

         //object
        for(int i=0;i<obj.length;i++){
             if(obj[i]!=null){
                 obj[i].draw(g2,this);
             }
        }

        player.draw(g2);

        Ui.draw(g2);
         g2.dispose();



    }


}
