import processing.core.PApplet;

import java.util.ArrayList;
import java.util.HashSet;

public class Main extends PApplet {
    private static PaintBrush brush;
    private static Forma forma;

    public static void main(String[] args) {
        brush = new PaintBrush();
        forma = new Forma("title");
        brush = new PaintBrush(forma);
        forma.setP(brush);
        forma.setVisible(true);
        PApplet.main("Main", args);

    }


    public void bucketFill(int oldColor, int newColor, int xpos, int ypos) {
        if (xpos > width || xpos < 0 || ypos > height || ypos < 0) {
            return;
        }

        set(xpos, ypos, newColor);

        if (get(xpos - 1, ypos) != oldColor) {
            //return;
        } else {
            bucketFill(oldColor, newColor, xpos - 1, ypos);
        }

        if (get(xpos + 1, ypos) != oldColor) {
            return;
        } else {
            bucketFill(oldColor, newColor, xpos + 1, ypos);
        }

        if (get(xpos, ypos + 1) != oldColor) {
            return;
        } else {
            bucketFill(oldColor, newColor, xpos, ypos + 1);
        }

        if (get(xpos, ypos - 1) != oldColor) {
            return;
        } else {
            bucketFill(oldColor, newColor, xpos, ypos - 1);
        }

    }


    @Override
    public void settings() {
        size(800, 600);
    }

    public void setup() {
        background(255);
        frameRate(120);

        //test
        fill(255);
        rect(width/3, height/3, width/3, height/3);
    }

    @Override
    public void draw() {

    }

    @Override
    public void mousePressed() {
        switch (brush.getMod()) {
            case 1:
                ellipseMode(CENTER);
                fill(0);
                ellipse(mouseX, mouseY, forma.Slider(), forma.Slider());
                break;
            case 2:
                rectMode(CENTER);
                fill(0);
                rect(mouseX, mouseY, forma.Slider(), forma.Slider());

                break;
            case 3:
                
                break;
            case 4:
                bucketFill(get(mouseX, mouseY), color(128), mouseX, mouseY);
                break;
        }
    }

    @Override
    public void mouseDragged() {
        switch (brush.getMod()) {
            case 1:
                ellipseMode(CENTER);
                fill(0);
                ellipse(mouseX, mouseY, forma.Slider(), forma.Slider());
                break;
            case 2:
                rectMode(CENTER);
                fill(0);
                rect(mouseX, mouseY, forma.Slider(), forma.Slider());

                break;
        }
    }
}
