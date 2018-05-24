import java.awt.*;
import javax.swing.*;
class Bouton extends JButton{

  private int x;
  private int y;
  private String nom;

    public Bouton( String nom, int x, int y) {
        super(nom);
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setNom(String nom) {
        super.setName(nom);
    }

    public int getX() {

        return x;
    }

    public int getY() {
        return y;
    }

    public String getNom() {
        return (super.getText());
    }
}
