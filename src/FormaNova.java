import com.mysql.cj.util.Base64Decoder;
import processing.core.PApplet;
import processing.core.PImage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

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
    private JSlider alphaSld;
    private JLabel bojaPrikaz;
    private PApplet applet;

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
                try {
                    PreparedStatement pstm = Database.getConnection().prepareStatement("select image from images where image_name like ?");
                    pstm.setString(1, imeTxt.getText());
                    ResultSet rs = pstm.executeQuery();
                    rs.next();
                    FileOutputStream fos = new FileOutputStream("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\tempPaintProcessing.png");
                    fos.write(rs.getBytes(1));
                    fos.close();
                    File image = new File("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\tempPaintProcessing.png");
                    PImage loadedImage = applet.loadImage("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\tempPaintProcessing.png");
                    applet.background(loadedImage);
                    //image.delete();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });

        saveBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                applet.save("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\tempPaintProcessing.png");
                File image = new File("C:\\ProgramData\\MySQL\\MySQL Server 8.0\\Uploads\\tempPaintProcessing.png");

                try {
                    PreparedStatement pstm = Database.getConnection().prepareStatement("insert into images(image_name, image) values (?, ?)");
                    InputStream in = new FileInputStream(image);
                    pstm.setString(1, imeTxt.getText());
                    pstm.setBlob(2, in);
                    pstm.execute();

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }


                image.delete();
            }
        });
        Gumica.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                p.setMod(5);
            }
        });
        PromeniBoju.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                String hexString = Boja.getText();
                int r = hexToInt(hexString.substring(0, 2));
                int g = hexToInt(hexString.substring(2, 4));
                int b = hexToInt(hexString.substring(4, 6));

                bojaPrikaz.setForeground(new Color(r, g, b));
                changeBrushColor(p, Boja.getText());
            }
        });
    }

    public void changeBrushColor(PaintBrushNov brush, String hexString) {
        int r = hexToInt(hexString.substring(0, 2));
        int g = hexToInt(hexString.substring(2, 4));
        int b = hexToInt(hexString.substring(4, 6));
        int[] color = brush.getColor();
        color[0] = r;
        color[1] = g;
        color[2] = b;
        color[3] = alphaSld.getValue();
        brush.setColor(color);
    }

    private static int hexDigitToInt(char hexDigit) {
        if (hexDigit >= '0' && hexDigit <= '9') {
            return hexDigit - '0';
        }
        else if (hexDigit == 'A' || hexDigit == 'a') {
            return 10;
        }
        else if (hexDigit == 'B' || hexDigit == 'b') {
            return 11;
        }
        else if (hexDigit == 'C' || hexDigit == 'c') {
            return 12;
        }
        else if (hexDigit == 'D' || hexDigit == 'd') {
            return 13;
        }
        else if (hexDigit == 'E' || hexDigit == 'e') {
            return 14;
        }
        else if (hexDigit == 'F' || hexDigit == 'f') {
            return 15;
        }
        else {
            return 0;
        }
    }

    private static int hexToInt(String hex) {
        int parsedInt = 0;
        int hexLength = hex.length();

        for (int i = hexLength - 1; i >= 0; i--) {
            parsedInt += Math.pow(16, i) * hexDigitToInt(hex.charAt(i));
        }
        return parsedInt;
    }

    public int Slider(){
        return debljinaSld.getValue();
    }

    public PApplet getApplet() {
        return applet;
    }

    public void setApplet(PApplet applet) {
        this.applet = applet;
    }
}
