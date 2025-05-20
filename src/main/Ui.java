package main;

import object.Objdagger;
import object.Objkey;

import java.awt.*;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.text.DecimalFormat;

public class Ui {
    static Gamepanel gp;
    static Font arial_40,arial_80B;
    static BufferedImage Keyimage;
    static BufferedImage daggerimage;
    public static boolean messageon=false;
    public static String message=" ";
    private static int msgcounter=0;
    public static boolean gamekhatam=false;
    static double playtime;
    static DecimalFormat dformat=new DecimalFormat("0.00");

    public void setMsgcounter(int msgcounter) {
        this.msgcounter = msgcounter;
    }

    public  static int getMsgcounter() {
        return msgcounter;
    }

    public Ui(Gamepanel gp){
        this.gp=gp;
        arial_40=new Font("Arial",Font.PLAIN,50);
        arial_80B=new Font("Arial",Font.BOLD,80);
            Objkey key=new Objkey();
            Keyimage=key.image;
        Objdagger dagger=new Objdagger();
        daggerimage=dagger.image;

    }
    public void showmessage(String text ){
        message=text;
        messageon=true;
    }
    public static void draw(Graphics2D g2){



        if(gamekhatam==true){
            String text;
            int textlen;
            int x;
            int y;
            int daggerX;

            g2.setFont(arial_40);
            g2.setColor(Color.yellow);

            text="You found the treasure";
            textlen=(int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x=gp.screenwidth/2-textlen/2;
            daggerX = gp.screenwidth / 2 - textlen / 2 + 20;

            y=gp.screenheight/2-(gp.tilesize*3);
            g2.drawString(text,x,y);

            text="Your time is"+dformat.format(playtime)+"!";
            textlen=(int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x=gp.screenwidth/2-textlen/2;
            y=gp.screenheight/2+(gp.tilesize*5);
            g2.drawString(text,x,y);

            g2.setFont(arial_80B);
            g2.setColor(Color.YELLOW);

            text="Congo!";
            textlen=(int)g2.getFontMetrics().getStringBounds(text,g2).getWidth();
            x=gp.screenwidth/2-textlen/2;
            y=gp.screenheight/2+(gp.tilesize*3);
            g2.drawString(text,x,y);

            gp.gameThread=null;

        }
        else {
            g2.setFont(arial_40);
            g2.setColor(Color.white);
            g2.drawImage(Keyimage,gp.tilesize/2,gp.tilesize/2,gp.tilesize,gp.tilesize,null);
            g2.drawString("x "+gp.player.haskey,74,65);

            g2.setFont(arial_40);
            g2.setColor(Color.white);
            g2.drawImage(daggerimage,gp.tilesize/2,gp.tilesize/2+40,gp.tilesize,gp.tilesize,null);
            g2.drawString("x "+gp.player.hasdagger,74,100);

            //time
            playtime+=(double)1/60;
            g2.drawString("Time : " + dformat.format(playtime),gp.tilesize*11,65);


            if(messageon==true){
                g2.setFont(g2.getFont().deriveFont(30F));
                g2.drawString(message,gp.tilesize/2,gp.tilesize*5);
                int msgcounter=getMsgcounter();
                if(msgcounter>500){
                    msgcounter=0;
                    messageon=false;
                }


            }

        }




    }
}
