package gameView;

import gameController.States.State;

import java.awt.*;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class Draw {
    JFrame frame;
    Canvas canvas;

    BufferStrategy bufferStrategy;
    Graphics2D g;

    private int WIDTH;
    private int HEIGHT;
    private String title= "RPG_GAME_DesignPatterns";





    public Draw(int width,int height){
        this.WIDTH=width;
        this.HEIGHT=height;
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

    public JFrame getFrame() {
        return frame;
    }



}


