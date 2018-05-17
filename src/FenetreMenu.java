//package src;
import javax.swing.*;
import java.awt.*;

public class FenetreMenu extends JFrame {
    JTextField tfNomdujeu;
    JButton jbJouer;
    JButton jbParametre;
    JButton jbQuitter;

    public FenetreMenu(){
        initAttribut();
        ajouterWidget();
        pack();
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initAttribut() {
        jbJouer = new JButton("JOUER");
        jbParametre = new JButton("PARAMETRE");
        jbQuitter = new JButton("QUITTER");
    }

    public void ajouterWidget(){
        JPanel nomdujeu = new JPanel();
        nomdujeu.add(new JLabel("ECHEC ET MAT"));

        JPanel jouer = new JPanel();
        jouer.add(jbJouer);

        JPanel parametre = new JPanel();
        parametre.add(jbParametre);

        JPanel quitter = new JPanel();
        quitter.add(jbQuitter);

        JPanel global = new JPanel();
        global.setLayout(new BoxLayout(global, BoxLayout.Y_AXIS));
        global.add(nomdujeu);
        global.add(jouer);
        global.add(parametre);
        global.add(quitter);

        JPanel total = new JPanel();
        total.add(global);

        setContentPane(total);
    }
}
