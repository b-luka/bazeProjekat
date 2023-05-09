public class PaintBrush {
    private int debljina,mod;

    public PaintBrush(Forma f) {
        mod=1;
        debljina= f.Slider();
    }

    public void setMod(int mod) {
        this.mod = mod;
    }
}
