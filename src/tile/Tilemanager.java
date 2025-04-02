package tile;

import main.Gamepanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class Tilemanager {
    Gamepanel gp;
    Tile[] tile;
    public Tilemanager(Gamepanel gp){
        this.gp=gp;
        tile=new Tile[10];
        getTileImage();
    }
    public void getTileImage(){
        try{
            tile[0]=new Tile();
            tile[0].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass.jpg"));
            tile[1]=new Tile();
            tile[1].image= ImageIO.read(getClass().getResourceAsStream("/tiles/water.jpg"));
            tile[2]=new Tile();
            tile[2].image= ImageIO.read(getClass().getResourceAsStream("/tiles/stone.png"));




        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void draw(Graphics2D g2){
       int col=0;
       int row=0;
       int x=0;
       int y=0;

       while(col<gp.maxScreenCol && row<gp.maxScreenRow) {
           g2.drawImage(tile[0].image, x, y, gp.tilesize, gp.tilesize, null);
           col++;
           x += gp.tilesize;


           if (col == gp.maxScreenCol) {
               col = 0;
               x = 0;
               row++;
               y += gp.tilesize;
           }
       }

    }
}
