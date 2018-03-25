package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Window extends JFrame implements ActionListener {

    JIFNewVehicle jifNewVehicle;

    private JMenuBar jMenuBar;
    private JMenu jmInsert;
    private JMenuItem jmiNewVehicle;

    public Window() throws IOException {
        super("Tarea 2");
        this.setLayout(null);
        init();
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    } // constructor

    private void init() throws IOException {
        this.jifNewVehicle = new JIFNewVehicle();
        this.add(this.jifNewVehicle);

        this.jMenuBar = new JMenuBar();

        this.jmInsert = new JMenu("Insert");

        this.jmiNewVehicle = new JMenuItem("New Vehicle");

        this.jmiNewVehicle.addActionListener(this);

        this.jmInsert.setMnemonic('I');
        this.jmiNewVehicle.setMnemonic('N');

        this.jMenuBar.add(this.jmInsert);
        this.jmInsert.add(this.jmiNewVehicle);

        this.jMenuBar.setSize(800, 30);
        this.add(this.jMenuBar);
    } // init

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jmiNewVehicle) {
            this.jifNewVehicle.setVisible(true);
        }
    } // actionPerformed

} // fin de la clase
