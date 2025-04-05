package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {
    //here the worldx and world y are the player position on the world map
    public int worldx,worldy;
    public int speed;

    public BufferedImage up1,up2,down1,down2,left1,left2,right1,right2;
    public String direction;

    public int spritecounter=0;
    public int spritenum=1;

    public Rectangle solidarea;
    public int solidareadefaultx,solidareadefaulty;
    public boolean collisonon=false;

}
