package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Window extends JFrame implements ActionListener {

    //private JIFNewVehicle jifNewVehicle;

    private JMenuBar jMenuBar;
    private JMenu jmInsert;
    private JMenuItem jmiNewVehicle;

    public Window() {
        super("Tarea 2");
        this.setLayout(null);
        init();
        this.setVisible(true);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    } // constructor

    private void init() {
//        this.jifNewVehicle = new JIFNewVehicle();
//        this.add(this.jifNewVehicle);

        this.jMenuBar = new JMenuBar();

        this.jmInsert = new JMenu("Insert");

        this.jmiNewVehicle = new JMenuItem("New Vehicle");

        this.jmiNewVehicle.addActionListener(this);

        this.jMenuBar.add(this.jmInsert);
        this.jmInsert.add(this.jmiNewVehicle);

        this.jMenuBar.setSize(800, 30);
        this.add(this.jMenuBar);
    } // init

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jmiNewVehicle) {
//            if (!this.jifNewVehicle.isShowing()) {
//                this.jifNewVehicle = new JIFNewVehicle();
//                this.add(this.jifNewVehicle);
//                this.jifNewVehicle.setVisible(true);
//                this.add(this.jifNewVehicle);
//            }
        }
    } // actionPerformed

} // fin de la clase
