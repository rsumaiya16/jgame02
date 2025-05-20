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
    public int checkobject(Entity entity, boolean player) {
        int index = 999;
        for (int i = 0; i < gp.obj.length; i++) {
            if (gp.obj[i] != null) {
                // update entity's solid area position
                entity.solidarea.x = entity.worldx + entity.solidarea.x;
                entity.solidarea.y = entity.worldy + entity.solidarea.y;

                // update object solid area position
                gp.obj[i].solidarea.x = gp.obj[i].worldx + gp.obj[i].solidarea.x;
                gp.obj[i].solidarea.y = gp.obj[i].worldy + gp.obj[i].solidarea.y;

                switch (entity.direction) {
                    case "up":
                        entity.solidarea.y -= entity.speed;
                        if (entity.solidarea.intersects(gp.obj[i].solidarea)) {
                            if (gp.obj[i].collision) {
                                entity.collisonon = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;

                    case "down":
                        entity.solidarea.y += entity.speed;
                        if (entity.solidarea.intersects(gp.obj[i].solidarea)) {
                            if (gp.obj[i].collision) {
                                entity.collisonon = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;

                    case "left":
                        entity.solidarea.x -= entity.speed;
                        if (entity.solidarea.intersects(gp.obj[i].solidarea)) {
                            if (gp.obj[i].collision) {
                                entity.collisonon = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;

                    case "right":
                        entity.solidarea.x += entity.speed;
                        if (entity.solidarea.intersects(gp.obj[i].solidarea)) {
                            if (gp.obj[i].collision) {
                                entity.collisonon = true;
                            }
                            if (player) {
                                index = i;
                            }
                        }
                        break;
                }

                // reset to default solid area values
                entity.solidarea.x = entity.solidareadefaultx;
                entity.solidarea.y = entity.solidareadefaulty;
                gp.obj[i].solidarea.x = gp.obj[i].solidareadefaultx;
                gp.obj[i].solidarea.y = gp.obj[i].solidareadefaulty;
            }
        }

        return index;
    }
}