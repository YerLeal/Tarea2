package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Window extends JFrame implements ActionListener, ContainerListener {

    public static boolean b1 = true;
    private ArrayList<JInternalFrame> list = new ArrayList<>();
    JIFNewVehicle jifNewVehicle;
    JIFDeleteVehicle jifDelete;

    private JMenuBar jMenuBar;
    private JMenu jmInsert;
    public static JMenuItem jmiNewVehicle, jmiDelete;

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
        this.jifDelete = null;
        this.add(this.jifNewVehicle);

        this.jMenuBar = new JMenuBar();

        this.jmInsert = new JMenu("Insert");

        this.jmiNewVehicle = new JMenuItem("New Vehicle");
        this.jmiDelete = new JMenuItem("Delete");
        this.jmiNewVehicle.addActionListener(this);
        this.jmiDelete.addActionListener(this);

        this.jmInsert.setMnemonic('I');
        this.jmiNewVehicle.setMnemonic('N');
        this.jmiDelete.setMnemonic('D');

        this.jMenuBar.add(this.jmInsert);
        this.jmInsert.add(this.jmiNewVehicle);
        this.jmInsert.add(this.jmiDelete);

        this.jMenuBar.setSize(800, 30);
        this.add(this.jMenuBar);
    } // init

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jmiNewVehicle) {
            this.jifNewVehicle.setVisible(true);
        } else if (e.getSource() == this.jmiDelete) {

                this.jmiDelete.setEnabled(false);
                this.jifDelete = new JIFDeleteVehicle();
                this.add(this.jifDelete);
                this.jifDelete.setVisible(true);
                
            
            
        }
    } // actionPerformed

    @Override
    public void componentAdded(ContainerEvent e) {

    }

    @Override
    public void componentRemoved(ContainerEvent e) {
        if (e.getSource() == this.jifDelete) {
            System.out.println("SSS");
            b1 = true;
        }
    }

} // fin de la clase
