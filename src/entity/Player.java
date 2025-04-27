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
    public int haskey=0;

    int counter2=0;

      public Player(Gamepanel gp,Keyhandler keyH){
          this.gp=gp;
          this.keyH=keyH;

          screenx=gp.screenwidth/2-(gp.tilesize/2);
          screeny=gp.screenheight/2-(gp.tilesize/2);

          solidarea=new Rectangle();
          solidarea.x=14;
          solidarea.y=14;
          solidareadefaultx=solidarea.x;
          solidareadefaulty=solidarea.y;
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
          if(keyH.upPressed==true || keyH.downPressed==true ||
                  keyH.leftPressed==true || keyH.rightPressed==true ) {
              if (keyH.upPressed == true) {
                  direction = "up";


              } else if (keyH.downPressed == true) {

                  direction = "down";


              } else if (keyH.leftPressed == true) {

                  direction = "left";
              } else if (keyH.rightPressed == true) {

                  direction = "right";
              }

              //check tile collision
              collisonon=false;
              gp.cchecker.checktile(this);

              //check object collisopn
             int objindex= gp.cchecker.checkobject(this,true);
             pickupobj(objindex);

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
              if (spritecounter > 12) {
                  if (spritenum == 1) {
                      spritenum = 2;
                  } else if (spritenum == 2) {
                      spritenum = 1;
                  }
                  spritecounter = 0;
              }


          }

      }
      public void pickupobj(int i) {
          if (i != 999) {
              String objectName = gp.obj[i].name;

              switch (objectName) {
                  case "key":
                      haskey++;
                      gp.obj[i] = null;
                      gp.ui.showmessage("you got a key!!");
                      break;
                  case "door":
                      if (haskey > 0) {
                          gp.obj[i] = null;
                          haskey--;
                          gp.ui.showmessage("You opened the door!");
                      }
                      else{
                          gp.ui.showmessage("You need a key");
                      }
                      break;
                  case "boost":
//                       speed+=1;
                      gp.obj[i]=null;
                      gp.ui.showmessage("You have completed your daily quest!!");

                      break;
                  case "chest":
                     gp.ui.gamekhatam=true;

                      break;

                  case "dagger":
                      gp.obj[i]=null;
                      gp.ui.showmessage("You got s dagger");
                      break;





              }

          }
      }
      public void draw(Graphics2D g2){

          BufferedImage image=null;
          switch (direction){

              case "up":
                  if(spritenum==1) {
                      image = up1;
                  }
                  if(spritenum==2){
                      image=up2;
                  }
                  break;
              case "down":
                  if(spritenum==1) {
                      image = down2;
                  }
                  if(spritenum==2){
                      image=down1;
                  }
                  break;
              case "left":
                  if(spritenum==1) {
                      image = left1;
                  }
                  if(spritenum==2){
                      image=left2;
                  }
                  break;
              case "right":
                  if(spritenum==1) {
                      image = right1;
                  }
                  if(spritenum==2){
                      image=right2;
                  }
                  break;


          }
          g2.drawImage(image,screenx,screeny,gp.tilesize, gp.tilesize, null);

      }


}
