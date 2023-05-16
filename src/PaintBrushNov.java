import processing.core.*;
public class PaintBrushNov {
    private int debljina,mod;
    private int color[];

    public PaintBrushNov() {
        mod=1;
        color= new int[]{0, 0, 0, 100};
    }

    public int[] getColor() {
        return color;
    }

    public void setColor(int[] color) {
        this.color = color;
    }

    public void setMod(int mod) {
        this.mod = mod;
    }

    public int getDebljina() {
        return debljina;
    }

    public void setDebljina(int debljina) {
        this.debljina = debljina;
    }

    public int getMod() {
        return mod;
    }
}
