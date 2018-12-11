package Tests.gameView;

import gameView.Draw;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrawTest {

    Draw draw;
    @Test
    void getCanvas() {
        draw=new Draw(200,200);
        boolean isCanvasNull=draw.getCanvas()==null ? true:false;
        assertEquals(false,isCanvasNull);
        draw.render();

        isCanvasNull=draw.getCanvas()==null ? true:false;
        assertEquals(false,isCanvasNull);

    }

    @Test
    void getFrame() {
        draw=new Draw(200,200);

        boolean isFrameNull=draw.getFrame()==null ? true:false;
        assertEquals(false,isFrameNull);
        draw.render();

        isFrameNull=draw.getFrame()==null ? true:false;
        assertEquals(false,isFrameNull);
    }
}