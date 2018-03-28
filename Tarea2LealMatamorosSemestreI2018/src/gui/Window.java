package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Window extends JFrame implements ActionListener {

    private JIFNewVehicle jifNewVehicle;
    private JIFDeleteVehicle jifDelete;
    private JIFShowVehicles jifShowVehicles;
    private JIFUpdate jifUpdate;

    private JMenuBar jMenuBar;
    private JMenu jmInsert, jmUtilities;
    public static JMenuItem jmiNewVehicle, jmiDelete, jmiShow, jmiUpdate;

    public Window() throws IOException {
        super("Tarea 2");
        this.setLayout(null);
        init();
        this.setVisible(true);
        this.setResizable(false);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    } // constructor

    private void init() {
        this.jMenuBar = new JMenuBar();

        this.jmInsert = new JMenu("Insert");
        this.jmUtilities = new JMenu("Utilities");

        this.jmiNewVehicle = new JMenuItem("New Vehicle");
        this.jmiDelete = new JMenuItem("Delete");
        this.jmiShow = new JMenuItem("Show Vehicles");
        this.jmiUpdate = new JMenuItem("Update vehicle");

        this.jmiNewVehicle.addActionListener(this);
        this.jmiDelete.addActionListener(this);
        this.jmiShow.addActionListener(this);
        this.jmiUpdate.addActionListener(this);

        this.jmInsert.setMnemonic('I');
        this.jmUtilities.setMnemonic('U');
        this.jmiNewVehicle.setMnemonic('N');
        this.jmiDelete.setMnemonic('D');
        this.jmiShow.setMnemonic('S');
        this.jmiUpdate.setMnemonic('U');

        this.jMenuBar.add(this.jmInsert);
        this.jMenuBar.add(this.jmUtilities);
        this.jmInsert.add(this.jmiNewVehicle);
        this.jmUtilities.add(this.jmiDelete);
        this.jmUtilities.add(this.jmiShow);
        this.jmUtilities.add(this.jmiUpdate);

        this.jMenuBar.setSize(800, 30);
        this.add(this.jMenuBar);
    } // init

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jmiNewVehicle) {
            // Al abrir la ventana deshabilito el JMenuItem para evitar que se
            // abran muchas veces una ventana
            this.jmiNewVehicle.setEnabled(false);
            try {
                this.jifNewVehicle = new JIFNewVehicle();
            } catch (IOException ex) {
                Logger.getLogger(Window.class.getName()).log(Level.SEVERE, null, ex);
            }
            this.add(this.jifNewVehicle);
            this.jifNewVehicle.setVisible(true);
        } else if (e.getSource() == this.jmiDelete) {
            // Al abrir la ventana deshabilito el JMenuItem para evitar que se
            // abran muchas veces una ventana
            this.jmiDelete.setEnabled(false);
            this.jifDelete = new JIFDeleteVehicle();
            this.add(this.jifDelete);
            this.jifDelete.setVisible(true);
        } else if (e.getSource() == this.jmiShow) {
            // Al abrir la ventana deshabilito el JMenuItem para evitar que se
            // abran muchas veces una ventana
            this.jmiShow.setEnabled(false);
            this.jifShowVehicles = new JIFShowVehicles();
            this.add(this.jifShowVehicles);
            this.jifShowVehicles.setVisible(true);
        } else if(e.getSource() == this.jmiUpdate){
            // Al abrir la ventana deshabilito el JMenuItem para evitar que se
            // abran muchas veces una ventana
            this.jmiUpdate.setEnabled(false);
            this.jifUpdate = new JIFUpdate();
            this.add(this.jifUpdate);
            this.jifUpdate.setVisible(true);
        }

    } // actionPerformed

} // fin de la clase
