package gameView;

import gameController.ButtonHandler;
import gameController.Instances;
import gameController.State;

import java.awt.*;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

import static gameView.ImageLoader.loadImage;

public class Draw {
    JFrame frame;
    Canvas canvas;

    BufferStrategy bufferStrategy;
    Graphics2D g;

    private int WIDTH = 640;
    private int HEIGHT = 480;
    private String title= "RPG_GAME_DesignPatterns";

    private int CHARACTER_WIDTH=Instances.player.getWidth();
    private int CHARACTER_HEIGHT=Instances.player.getHeight();

    public JFrame getFrame() {
        return frame;
    }

    public int getCHARACTER_WIDTH() {
        return CHARACTER_WIDTH;
    }

    public int getCHARACTER_HEIGHT() {
        return CHARACTER_HEIGHT;
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public Draw(){
        createDisplay();
    }

    public Canvas getCanvas() {
        return canvas;
    }

    private void createDisplay(){
        frame = new JFrame(title);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH,HEIGHT);
        frame.setLocationRelativeTo(null);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMaximumSize(new Dimension(WIDTH, HEIGHT));
        canvas.setMinimumSize(new Dimension(WIDTH, HEIGHT));

        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);
        //canvas.requestFocus();
        canvas.setBackground(Color.black);

        frame.add(canvas);

        canvas.createBufferStrategy(3);

        frame.pack();
        bufferStrategy = canvas.getBufferStrategy();
        //This will make sure the canvas has focus, so that it can take input from mouse/keyboard

    }
    public void render() {
        g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);//Clearing screen

        if (State.getCurrentState() != null) State.getCurrentState().render(g);

        g.dispose();
        bufferStrategy.show();
    }


}


