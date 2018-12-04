package gameController.States.Menu;

import gameController.Handler;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MenuManager {

    private Handler handler;
    private ArrayList<MenuObject> objects;

    public MenuManager(Handler handler) {
        this.handler = handler;
        objects=new ArrayList<>();
    }

    public void tick(){
        for (MenuObject o:objects) {
            o.tick();
        }
    }

    public void render(Graphics g){
        for (MenuObject o:objects) {
            o.render(g);
        }
    }

    public void onMouseMove(MouseEvent e){
        for (MenuObject o:objects) {
            o.onMouseMove(e);
        }
    }

    public void onMouseRelease(MouseEvent e){
        for (MenuObject o:objects) {
            o.onMouseRelease(e);
        }
    }

    public void addObject(MenuObject o){
        objects.add(o);
    }

    public void removeObject(MenuObject o){
        objects.remove(o);
    }

    //Getters and setters
    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public ArrayList<MenuObject> getObjects() {
        return objects;
    }

    public void setObjects(ArrayList<MenuObject> objects) {
        this.objects = objects;
    }
}
