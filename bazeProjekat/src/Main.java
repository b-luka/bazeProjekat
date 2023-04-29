import processing.core.PApplet;

public class Main extends PApplet {
    private static PaintBrush brush;

    public static void main(String[] args) {
        PApplet.main("Main", args);
    }

    @Override
    public void settings() {
        size(800, 600);
    }

    @Override
    public void setup() {
        brush = new PaintBrush();
        ellipseMode(CENTER);
    }

    @Override
    public void draw() {

    }

    @Override
    public void mouseDragged() {
        fill(0);
        ellipse(mouseX, mouseY, 5, 5);
    }

    @Override
    public void mousePressed() {
        fill(0);
        ellipse(mouseX, mouseY, 5, 5);
    }
}

