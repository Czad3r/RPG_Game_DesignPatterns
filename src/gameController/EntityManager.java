package gameController;

import gameModel.DynamicEntities.HeroAbstract;
import gameModel.Entity;

import java.awt.*;
import java.util.ArrayList;

public class EntityManager {
    private Handler handler;
    private HeroAbstract player;
    private ArrayList<Entity> entities;

    public EntityManager(Handler handler, HeroAbstract player) {
        this.handler = handler;
        this.player = player;
        entities=new ArrayList<Entity>();
        //addEntity(player);
    }

    public void render(Graphics g){
        for (Entity e:entities){
            e.render(g);
        }
    }

    public void tick(){
        for (int i=0;i< entities.size();i++){
            Entity e=entities.get(i);
            e.tick();
        }
    }

    public void addEntity(Entity e){
        entities.add(e);
    }

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public HeroAbstract getPlayer() {
        return player;
    }

    public void setPlayer(HeroAbstract player) {
        this.player = player;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
}
