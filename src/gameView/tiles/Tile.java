package gameView.tiles;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tile {
    //Static section
    public static Tile[] tiles=new Tile[50];
    public static Tile grassTile=new GrassTile(0);
    public static Tile pathTile=new PathTile(1);
    public static Tile doorTile=new DoorTile(2);
    public static Tile arenaDoorTile=new ArenaDoorTile(3);
    public static Tile shopSignTile=new ShopSignTile(4);
    public static Tile bedSignTile=new BedSignTile(5);
    public static Tile treeTile=new TreeTile(6);
    public static Tile brickWallTile=new WoodWallWindowTile(7);
    public static Tile arenaWallTile=new ArenaWallTile(8);
    public static Tile monumentTile=new MonumentTile(9);



    public static final int TILEWIDTH=32, TILEHEIGHT=32;

    protected BufferedImage texture;
    protected final int id;

    public Tile(BufferedImage texture, int id) {
        this.texture = texture;
        this.id = id;

        tiles[id]=this;
    }

    public int getId() {
        return id;
    }

    public void tick(){

    }

    public void render(Graphics g,int x,int y){
        g.drawImage(texture,x,y,TILEWIDTH,TILEHEIGHT,null);
    }
    public boolean isSolid(){
        return false;
    }
}
