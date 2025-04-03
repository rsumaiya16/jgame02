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

    public final int screenx;
    public final int screeny;

    int counter2=0;

      public Player(Gamepanel gp,Keyhandler keyH){
          this.gp=gp;
          this.keyH=keyH;

          screenx=gp.screenwidth/2-(gp.tilesize/2);
          screeny=gp.screenheight/2-(gp.tilesize/2);

          solidarea=new Rectangle();
          solidarea.x=8;
          solidarea.y=8;
          solidarea.width=32;
          solidarea.height=32;


          setDefaultValues();
          getPlayerImage();

      }
      public void setDefaultValues(){
          worldx= gp.tilesize*23;
          worldy= gp.tilesize*21;
          speed=1;
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
          if(keyH.upPressed==true || keyH.downPressed==true || keyH.leftPressed==true || keyH.rightPressed==true ) {
              if (keyH.upPressed == true) {
                  direction = "up";


              } else if (keyH.downPressed == true) {

                  direction = "down";


              } else if (keyH.leftPressed == true) {

                  direction = "left";
              } else if (keyH.rightPressed == true) {

                  direction = "right";
              }

              //check collision
              collisonon=false;
              gp.cchecker.checktile(this);

              if(collisonon==false){
                  switch (direction){
                      case "up":  worldy -= speed;
                          break;
                      case "down": worldy += speed;
                          break;
                      case "left":   worldx -= speed;
                          break;
                      case "right": worldx += speed;
                          break;


                  }
              }
              spritecounter++;
              if(spritecounter>12){
                  if(spritecounter==1){
                      spritenum=2;
                  }
                  else if(spritecounter==2){
                      spritenum=1;
                  }
                  spritecounter=0;
              }
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
          g2.drawImage(image,screenx,screeny,gp.tilesize, gp.tilesize, null);

      }


}
