package gui;

import domain.Vehicle;
import file.VehicleFile;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class JIFNewVehicle extends JInternalFrame implements ActionListener {

    private VehicleFile vehicleFile;
    private File file;

    private JLabel jlName, jlYear, jlMileage, jlAmerican, jlSerie;
    private JTextField jtfName, jtfYear, jtfMileage, jtfSerie;
    private JRadioButton jrbYes, jrbNo;
    private ButtonGroup buttonGroup;
    private JButton jbOk;

    public JIFNewVehicle() throws IOException {
        super("New Vehicle", false, true, false, false);
        this.setLayout(null);

        this.init();
        this.setVisible(false);
        this.setLocation(20, 40);
        this.setSize(300, 325);
    } // constructor

    private void init() throws IOException {
        this.file = new File("vehicle.dat");
        this.vehicleFile = new VehicleFile(file);

        this.jlName = new JLabel("Name");
        this.jlYear = new JLabel("Year");
        this.jlMileage = new JLabel("Mileage");
        this.jlAmerican = new JLabel("American");
        this.jlSerie = new JLabel("Serie");

        this.jtfName = new JTextField();
        this.jtfYear = new JTextField();
        this.jtfMileage = new JTextField();
        this.jtfSerie = new JTextField();

        this.jrbYes = new JRadioButton("Yes");
        this.jrbNo = new JRadioButton("No");
        this.buttonGroup = new ButtonGroup();
        this.buttonGroup.add(this.jrbYes);
        this.buttonGroup.add(this.jrbNo);

        this.jbOk = new JButton("OK");
        this.jbOk.addActionListener(this);
        this.jbOk.setFocusable(false);

        this.jlName.setBounds(30, 40, 40, 15);
        this.jlYear.setBounds(30, 80, 40, 15);
        this.jlMileage.setBounds(30, 120, 70, 15);
        this.jlAmerican.setBounds(30, 160, 70, 15);
        this.jlSerie.setBounds(30, 200, 70, 15);

        this.jtfName.setBounds(112, 40, 135, 22);
        this.jtfYear.setBounds(112, 80, 135, 22);
        this.jtfMileage.setBounds(112, 120, 135, 22);
        this.jtfSerie.setBounds(112, 200, 135, 22);

        this.jrbYes.setBounds(115, 160, 50, 15);
        this.jrbNo.setBounds(180, 160, 50, 15);

        this.jbOk.setBounds(190, 240, 55, 30);

        this.add(this.jlName);
        this.add(this.jlYear);
        this.add(this.jlMileage);
        this.add(this.jlAmerican);
        this.add(this.jlSerie);
        this.add(this.jtfName);
        this.add(this.jtfYear);
        this.add(this.jtfMileage);
        this.add(this.jtfSerie);
        this.add(this.jrbYes);
        this.add(this.jrbNo);
        this.add(this.jbOk);
    } // init

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jbOk) {
            try {
                if (newData()) {
                    this.jtfName.setText("");
                    this.jtfYear.setText("");
                    this.jtfMileage.setText("");
                    this.jtfSerie.setText("");
                    this.dispose();
                }
            } catch (IOException ex) {
                Logger.getLogger(JIFNewVehicle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } // actionPerformed

    private boolean newData() throws IOException {
        String name;
        int year, serie;
        float mileage;
        name = this.jtfName.getText();
        if (name.equals("")) {
            JOptionPane.showMessageDialog(this, "All spaces are required", "Error", 0);
            return false;
        } else {
            try {
                year = Integer.parseInt(this.jtfYear.getText());
                mileage = Float.parseFloat(this.jtfMileage.getText());
                serie = Integer.parseInt(this.jtfSerie.getText());
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "The year, mileage and serie must be a number.", "Error", 0);
                return false;
            }
        }
        if (this.jrbYes.isSelected() == false && this.jrbNo.isSelected() == false) {
            JOptionPane.showMessageDialog(this, "You must select if the car is American.", "Error", 0);
            return false;
        }
        Vehicle newVehicle = new Vehicle(name, year, mileage, false, serie);
        if (this.jrbYes.isSelected()) {
            newVehicle.setAmerican(true);
        }

        this.vehicleFile.addEndRecord(newVehicle);
        return true;
    } // newData

} // fin de la clase
