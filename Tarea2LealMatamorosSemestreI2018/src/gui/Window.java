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
    JIFDeleteVehicle jifDelete;
    JIFShowVehicles jifShowVehicles;

    private JMenuBar jMenuBar;
    private JMenu jmInsert, jmUtilities;
    public static JMenuItem jmiNewVehicle, jmiDelete, jmiShow;

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
        this.jmUtilities = new JMenu("Utilities");

        this.jmiNewVehicle = new JMenuItem("New Vehicle");
        this.jmiDelete = new JMenuItem("Delete");
        this.jmiShow = new JMenuItem("Show Vehicles");

        this.jmiNewVehicle.addActionListener(this);
        this.jmiDelete.addActionListener(this);
        this.jmiShow.addActionListener(this);

        this.jmInsert.setMnemonic('I');
        this.jmUtilities.setMnemonic('U');
        this.jmiNewVehicle.setMnemonic('N');
        this.jmiDelete.setMnemonic('D');
        this.jmiShow.setMnemonic('S');

        this.jMenuBar.add(this.jmInsert);
        this.jMenuBar.add(this.jmUtilities);
        this.jmInsert.add(this.jmiNewVehicle);
        this.jmUtilities.add(this.jmiDelete);
        this.jmUtilities.add(this.jmiShow);

        this.jMenuBar.setSize(800, 30);
        this.add(this.jMenuBar);
    } // init

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jmiNewVehicle) {
            this.jifNewVehicle.setVisible(true);
        } else if (e.getSource() == this.jmiDelete) {
            //al abrir la ventana deshabilito el JMenuItem para evitar que se
            //abran muchas veces una ventana
            this.jmiDelete.setEnabled(false);
            this.jifDelete = new JIFDeleteVehicle();
            this.add(this.jifDelete);
            this.jifDelete.setVisible(true);
        } else if(e.getSource() == this.jmiShow){
            //al abrir la ventana deshabilito el JMenuItem para evitar que se
            //abran muchas veces una ventana
            this.jmiShow.setEnabled(false);
            this.jifShowVehicles=new JIFShowVehicles();
            this.add(this.jifShowVehicles);
            this.jifShowVehicles.setVisible(true);
        }
    } // actionPerformed

} // fin de la clase
