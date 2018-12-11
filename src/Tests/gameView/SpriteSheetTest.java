package Tests.gameView;

import gameView.ImageLoader;
import gameView.SpriteSheet;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;

class SpriteSheetTest {
    BufferedImage img1= ImageLoader.loadImage("/textures/map.png");
    BufferedImage img2=ImageLoader.loadImage("/textures/hero1.png");
    BufferedImage img3=ImageLoader.loadImage("/menu/Start.png");
    BufferedImage img4=ImageLoader.loadImage("/menu/Create.png");
    @Test
    void crop() {
        SpriteSheet s1=new SpriteSheet(img1);

        boolean isImgNull=s1.crop(5,5,5,5)==null ? true:false;
        assertEquals(false,isImgNull);

        s1=new SpriteSheet(img2);

        isImgNull=s1.crop(20,20,12,12)==null ? true:false;
        assertEquals(false,isImgNull);

        s1=new SpriteSheet(img3);

        isImgNull=s1.crop(20,20,12,12)==null ? true:false;
        assertEquals(false,isImgNull);

        s1=new SpriteSheet(img4);

        isImgNull=s1.crop(20,20,12,12)==null ? true:false;
        assertEquals(false,isImgNull);

    }

}