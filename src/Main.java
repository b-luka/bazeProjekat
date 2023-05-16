import processing.core.PApplet;

import java.util.ArrayList;
import java.util.HashSet;

public class Main extends PApplet {
    private static PaintBrushNov brush;
    private static FormaNova forma;

    private static int lineXB, lineYB, lineXE, lineYE;

    public static void main(String[] args) {
        brush = new PaintBrushNov();
        forma = new FormaNova("gui", brush);
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
        forma.setApplet(this);
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
                noStroke();
                fill(color(brush.getColor()[0], brush.getColor()[1], brush.getColor()[2], brush.getColor()[3] == 100 ? 255 : brush.getColor()[3]));
                ellipse(mouseX, mouseY, forma.Slider(), forma.Slider());
                strokeWeight(1);
                break;
            case 2:
                rectMode(CENTER);
                noStroke();
                fill(color(brush.getColor()[0], brush.getColor()[1], brush.getColor()[2], brush.getColor()[3] == 100 ? 255 : brush.getColor()[3]));
                rect(mouseX, mouseY, forma.Slider(), forma.Slider());
                strokeWeight(1);
                break;
            case 3:
                lineXB = mouseX;
                lineYB = mouseY;
                break;
            case 4:
                int fillColor = color(brush.getColor()[0], brush.getColor()[1], brush.getColor()[2], brush.getColor()[3] == 100 ? 255 : brush.getColor()[3]);
                if (fillColor != get(mouseX, mouseY)) {
                    bucketFill(get(mouseX, mouseY), fillColor, mouseX, mouseY);
                }
                break;
            case 5:
                rectMode(CENTER);
                noStroke();
                fill(color(255, 255, 255));
                rect(mouseX, mouseY, forma.Slider(), forma.Slider());
                strokeWeight(1);
                break;
        }
    }

    @Override
    public void mouseDragged() {
        switch (brush.getMod()) {
            case 1:
                ellipseMode(CENTER);
                noStroke();
                fill(color(brush.getColor()[0], brush.getColor()[1], brush.getColor()[2], brush.getColor()[3] == 100 ? 255 : brush.getColor()[3]));
                ellipse(mouseX, mouseY, forma.Slider(), forma.Slider());
                strokeWeight(1);
                break;
            case 2:
                rectMode(CENTER);
                noStroke();
                fill(color(brush.getColor()[0], brush.getColor()[1], brush.getColor()[2], brush.getColor()[3] == 100 ? 255 : brush.getColor()[3]));
                rect(mouseX, mouseY, forma.Slider(), forma.Slider());
                strokeWeight(1);
                break;
            case 3:
                lineXE = mouseX;
                lineYE = mouseY;
                break;
            case 5:
                rectMode(CENTER);
                noStroke();
                fill(color(255, 255, 255));
                rect(mouseX, mouseY, forma.Slider(), forma.Slider());
                strokeWeight(1);
                break;
        }
    }

    @Override
    public void mouseReleased() {
        switch (brush.getMod()) {
            case 3:
                stroke(color(brush.getColor()[0], brush.getColor()[1], brush.getColor()[2], brush.getColor()[3] == 100 ? 255 : brush.getColor()[3]));
                strokeWeight(forma.Slider());
                line(lineXB, lineYB, lineXE, lineYE);
                strokeWeight(1);
                break;
        }
    }
}
