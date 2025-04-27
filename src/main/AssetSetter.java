package main;

import object.*;

public class AssetSetter {
    Gamepanel gp;
    public  AssetSetter(Gamepanel gp){
        this.gp=gp;
    }
    public void setobject(){
        gp.obj[0]=new Objkey();
        gp.obj[0].worldx=23* gp.tilesize;
        gp.obj[0].worldy=7*gp.tilesize;

        gp.obj[1]=new Objkey();
        gp.obj[1].worldx=23* gp.tilesize;
        gp.obj[1].worldy=40*gp.tilesize;

        gp.obj[2]=new Objkey();
        gp.obj[2].worldx=37* gp.tilesize;
        gp.obj[2].worldy=7*gp.tilesize;

        gp.obj[3]=new Objdoor();
        gp.obj[3].worldx=10* gp.tilesize;
        gp.obj[3].worldy=11*gp.tilesize;

        gp.obj[4]=new Objdoor();
        gp.obj[4].worldx=8* gp.tilesize;
        gp.obj[4].worldy=20*gp.tilesize;

        gp.obj[5]=new Objdoor();
        gp.obj[5].worldx=12* gp.tilesize;
        gp.obj[5].worldy=22*gp.tilesize;

        gp.obj[5]=new Objchest();
        gp.obj[5].worldx=10* gp.tilesize;
        gp.obj[5].worldy=7*gp.tilesize;

        gp.obj[6]=new Objchest();
        gp.obj[6].worldx=10* gp.tilesize;
        gp.obj[6].worldy=7*gp.tilesize;

        gp.obj[7]=new Objboost();
        gp.obj[7].worldx=37* gp.tilesize;
        gp.obj[7].worldy=42*gp.tilesize;

        gp.obj[8]=new Objdagger();
        gp.obj[8].worldx=30* gp.tilesize;
        gp.obj[8].worldy=40*gp.tilesize;






    }

}
