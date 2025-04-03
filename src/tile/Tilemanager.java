package tile;

import main.Gamepanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Tilemanager {
    Gamepanel gp;
    Tile[] tile;
    int maptilenum[][];

    public Tilemanager(Gamepanel gp){

        this.gp=gp;

        tile=new Tile[10];

        maptilenum =new int[gp.maxworldcol][gp.maxworldrow];
        getTileImage();
        loadmap("/maps/worldmap.txt");
    }
    public void getTileImage(){
        try{
            tile[0]=new Tile();
            tile[0].image= ImageIO.read(getClass().getResourceAsStream("/tiles/grass.jpg"));
            tile[1]=new Tile();
            tile[1].image= ImageIO.read(getClass().getResourceAsStream("/tiles/stone.png"));
            tile[2]=new Tile();
            tile[2].image= ImageIO.read(getClass().getResourceAsStream("/tiles/water.jpg"));
            tile[3]=new Tile();
            tile[3].image= ImageIO.read(getClass().getResourceAsStream("/tiles/earth.jpeg"));
            tile[4]=new Tile();
            tile[4].image= ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
            tile[5]=new Tile();
            tile[5].image= ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));





        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public void loadmap(String filepath){
        try{
            InputStream is=getClass().getResourceAsStream(filepath);
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            int col=0;
            int row=0;
            while(col<gp.maxworldcol && row<gp.maxworldrow){
                String line = br.readLine();
                while(col< gp.maxworldcol){

                    String numbers[]=line.split(" ");

                    int num=Integer.parseInt(numbers[col]);
                    maptilenum[col][row]=num;
                    col++;

                }
                if(col==gp.maxworldcol){
                    col=0;
                    row++;
                }
            }
            br.close();
        }

        catch(Exception e){

        }
    }

    public void draw(Graphics2D g2){
       int worldcol=0;
       int worldrow=0;


       while(worldcol<gp.maxworldcol && worldrow<gp.maxworldrow) {

           int tilenum=maptilenum[worldcol][worldrow];

           int worldx=worldcol*gp.tilesize;
           int worldy=worldrow*gp.tilesize;
           int screenx=worldx-gp.player.worldx+gp.player.screenx;
           int screeny=worldy-gp.player.worldy+gp.player.screeny;



           g2.drawImage(tile[tilenum].image, screenx, screeny, gp.tilesize, gp.tilesize, null);

           worldcol++;


           if (worldcol == gp.maxworldcol) {
               worldcol = 0;

               worldrow++;

           }
       }

    }
}
