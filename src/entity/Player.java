package entity;

import main.Gamepanel;
import main.Keyhandler;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Player extends Entity {
    Gamepanel gp;
    Keyhandler keyH;

      public Player(Gamepanel gp,Keyhandler keyH){
          this.gp=gp;
          this.keyH=keyH;

          setDefaultValues();
          getPlayerImage();

      }
      public void setDefaultValues(){
          x=100;
          y=100;
          speed=2;
          direction="down";
      }
      public void getPlayerImage(){
          try{
              up1= ImageIO.read(getClass().getResourceAsStream("/player/boyup1.png"));
              up2= ImageIO.read(getClass().getResourceAsStream("/player/boyup2.png"));
              down1= ImageIO.read(getClass().getResourceAsStream("/player/boydown1.png"));
              down2= ImageIO.read(getClass().getResourceAsStream("/player/boydown2.png"));
              right1= ImageIO.read(getClass().getResourceAsStream("/player/boyright1.png"));
              right2= ImageIO.read(getClass().getResourceAsStream("/player/boyright2.png"));
              left1= ImageIO.read(getClass().getResourceAsStream("/player/boyleft1.png"));
              left2= ImageIO.read(getClass().getResourceAsStream("/player/boyleft2.png"));



          }
          catch(IOException e){
              e.printStackTrace();

          }
      }
      public void update(){
          if(keyH.upPressed==true){
              direction="up";
              y-=speed;


          }
          else if(keyH.downPressed==true){
              y+=speed;
              direction="down";


          }
          else if(keyH.leftPressed==true){
              x-=speed;
              direction="left";
          }
          else if(keyH.rightPressed==true){
              x+=speed;
              direction="right";
          }
      }
      public void draw(Graphics2D g2){

          BufferedImage image=null;
          switch (direction){
              case "up":
                  image=up1;
                  break;
              case "down":
                  image=down1;
                  break;
              case "left":
                  image=left1;
                  break;
              case "right":
                  image=right1;
                  break;


          }
          g2.drawImage(image,x,y,gp.tilesize, gp.tilesize, null);

      }


}
