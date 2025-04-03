package main;

import entity.Entity;

public class Collisioncheck {
    Gamepanel gp;

    public Collisioncheck(Gamepanel gp){
        this.gp=gp;
    }

public void checktile(Entity entity){

        int entityleftworldx=entity.worldx+entity.solidarea.x;
        int entityrightworldx=entity.worldx+entity.solidarea.x+entity.solidarea.width;
        int entitytopworldy=entity.worldy+entity.solidarea.y;
        int entitybottomworldy=entity.worldy+entity.solidarea.y+entity.solidarea.height;

        int entityleftcol=entityleftworldx/gp.tilesize;
        int entityrightcol=entityrightworldx/gp.tilesize;
        int entitytoprow=entitytopworldy/gp.tilesize;
        int entitybottomrow=entitybottomworldy/gp.tilesize;

        int tilenum1,tilenum2;

        switch(entity.direction){
            case "up":
                entitytoprow=(entitytopworldy-entity.speed)/gp.tilesize;
                tilenum1=gp.tilem.maptilenum[entityleftcol][entitytoprow];
                tilenum2=gp.tilem.maptilenum[entityrightcol][entitytoprow];

                if(gp.tilem.tile[tilenum1].collison==true || gp.tilem.tile[tilenum2].collison==true){
                    entity.collisonon=true;
                }

                break;
            case "down":
                entitybottomrow=(entitybottomworldy+entity.speed)/gp.tilesize;
                tilenum1=gp.tilem.maptilenum[entityleftcol][entitybottomrow];
                tilenum2=gp.tilem.maptilenum[entityrightcol][entitybottomrow];

                if(gp.tilem.tile[tilenum1].collison==true || gp.tilem.tile[tilenum2].collison==true){
                    entity.collisonon=true;
                }
                break;
            case "left":
                entityleftcol=(entityleftworldx-entity.speed)/gp.tilesize;
                tilenum1=gp.tilem.maptilenum[entityleftcol][entitytoprow];
                tilenum2=gp.tilem.maptilenum[entityleftcol][entitybottomrow];

                if(gp.tilem.tile[tilenum1].collison==true || gp.tilem.tile[tilenum2].collison==true){
                    entity.collisonon=true;
                }
                break;
            case "right":
                entityrightcol=(entityrightworldx-entity.speed)/gp.tilesize;
                tilenum1=gp.tilem.maptilenum[entityrightcol][entitytoprow];
                tilenum2=gp.tilem.maptilenum[entityrightcol][entitybottomrow];

                if(gp.tilem.tile[tilenum1].collison==true || gp.tilem.tile[tilenum2].collison==true){
                    entity.collisonon=true;
                }
            break;


        }



}

}
