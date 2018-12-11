package Tests.gameView;

import gameView.ImageLoader;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;

class ImageLoaderTest {
    BufferedImage img1=ImageLoader.loadImage("/textures/map.png");
    BufferedImage img2=ImageLoader.loadImage("/textures/hero1.png");
    BufferedImage img3=ImageLoader.loadImage("/menu/Start.png");
    BufferedImage img4=ImageLoader.loadImage("/menu/Create.png");
    @Test
    void loadImage() {
        boolean isImgNull=img1==null ? true:false;
        assertEquals(false,isImgNull);

        isImgNull=img2==null ? true:false;
        assertEquals(false,isImgNull);

        isImgNull=img3==null ? true:false;
        assertEquals(false,isImgNull);

        isImgNull=img4==null ? true:false;
        assertEquals(false,isImgNull);

    }
}