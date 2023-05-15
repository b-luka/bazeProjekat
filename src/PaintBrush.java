public class PaintBrush {
    private int debljina,mod;
    public PaintBrush() {
        mod = 1;
    }

    public PaintBrush(Forma f) {
        mod=1;
        debljina= f.Slider();
    }

    public int getMod() {
        return mod;
    }

    public int getDebljina() {
        return debljina;
    }

    public void setMod(int mod) {
        this.mod = mod;
    }
}
