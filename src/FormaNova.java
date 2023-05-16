import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FormaNova extends JFrame {
    private JPanel Panel;
    private JButton krugBtn;
    private JButton kvadratBtn;
    private JButton linijaBtn;
    private JButton fillBtn;
    private JTextField imeTxt;
    private JButton loadBtn;
    private JButton saveBtn;
    private JSlider debljinaSld;
    private JTextField Boja;
    private JButton Gumica;
    private JButton PromeniBoju;

    public FormaNova(String title, PaintBrushNov p) {
        super(title);
        this.setContentPane(Panel);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
        p.setDebljina(this.Slider());

        krugBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                p.setMod(1);
            }
        });

        kvadratBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                p.setMod(2);
            }
        });

        linijaBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                p.setMod(3);
            }
        });

        fillBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                p.setMod(4);
            }
        });

        loadBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println(imeTxt.getText());
            }
        });

        saveBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println(imeTxt.getText());
            }
        });
        Gumica.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                p.setMod(0);
            }
        });
        PromeniBoju.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                System.out.println(Boja.getText());
            }
        });
    }

    public int Slider(){
        return debljinaSld.getValue();
    }
}
