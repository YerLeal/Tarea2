package gui;

import business.VehicleBusiness;
import domain.Vehicle;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

public class JIFUpdate extends javax.swing.JInternalFrame implements InternalFrameListener {

    private VehicleBusiness vehicleBusiness;
    private ArrayList<Vehicle> vehicles;
    private Vehicle vehicle;

    public JIFUpdate() {
        initComponents();
        this.setLocation(20, 40);
        init();
        this.addInternalFrameListener(this);
    } // constructor

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jtfName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfYear = new javax.swing.JTextField();
        jbSearch = new javax.swing.JButton();
        jrbYes = new javax.swing.JRadioButton();
        jrbNo = new javax.swing.JRadioButton();
        jbOk = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jtfMileage = new javax.swing.JTextField();

        setClosable(true);
        setTitle("Update Vehicle");

        jLabel1.setText("Serie");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel2.setText("Name");

        jLabel3.setText("Year");

        jLabel4.setText("American");

        jbSearch.setText("Search");
        jbSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSearchActionPerformed(evt);
            }
        });

        jrbYes.setText("Yes");

        jrbNo.setText("No");

        jbOk.setText("Ok");
        jbOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbOkActionPerformed(evt);
            }
        });

        jLabel5.setText("Mileage");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jtfMileage, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                .addComponent(jtfYear, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jbOk, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jbSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbNo)
                            .addComponent(jrbYes))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSearch))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jtfName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jtfMileage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jrbYes))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbNo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbOk)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSearchActionPerformed
        try {
            this.vehicle = vehicleBusiness.getVehicle(
                    vehicleBusiness.getPosition(
                            Integer.parseInt("" + jComboBox1.getSelectedItem())));
        } catch (IOException ex) {
            Logger.getLogger(JIFUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        refreshValues();
        activateComponents(true);
    }//GEN-LAST:event_jbSearchActionPerformed

    private void jbOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbOkActionPerformed
        boolean success = true;
        if (this.jtfName.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "All spaces are required", "Error", 0);
            success = false;
        } else {
            try {
                int year = Integer.parseInt(this.jtfYear.getText());
                if (year < 1885) {
                    JOptionPane.showMessageDialog(this,
                            "Invalid data, the first automobiles were created in the 18th century.", "Error", 2);
                    success = false;
                } else {
                    Vehicle tempVehicle = this.vehicle;
                    tempVehicle.setName(this.jtfName.getText());
                    tempVehicle.setYear(year);
                    if (this.jrbYes.isSelected()) {
                        tempVehicle.setAmerican(true);
                    } else if (this.jrbNo.isSelected()) {
                        tempVehicle.setAmerican(false);
                    } else {
                        JOptionPane.showMessageDialog(this, "You must select if the car is American.", "Error", 0);
                        success = false;
                    }
                    if (success) {
                        this.vehicle = tempVehicle;
                        vehicleBusiness.updateRecord(this.vehicle);
                        refreshValues();
                        activateComponents(false);
                    }
                } // else
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(this, "The year must be a number.", "Error", 0);
            } catch (IOException ex) {
                Logger.getLogger(JIFUpdate.class.getName()).log(Level.SEVERE, null, ex);
            } // try/catch
        } // if (this.jtfName.equals(""))
    }//GEN-LAST:event_jbOkActionPerformed

    private void refreshValues() {
        this.jtfName.setText(this.vehicle.getName());
        this.jtfYear.setText("" + this.vehicle.getYear());
        this.jtfMileage.setText("" + this.vehicle.getMileage());
        if (this.vehicle.isAmerican()) {
            this.jrbYes.setSelected(true);
        } else {
            this.jrbNo.setSelected(true);
        }
    } // refreshValues: carga valores en textFields

    private void initButtonGroup() {
        this.buttonGroup1 = new ButtonGroup();
        this.buttonGroup1.add(this.jrbYes);
        this.buttonGroup1.add(this.jrbNo);

    } // init

    private ArrayList<Vehicle> orderList(ArrayList<Vehicle> list) {
        Vehicle temp;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i; j < list.size(); j++) {
                if (list.get(i).getSerie() > list.get(j).getSerie()) {
                    temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
        return list;
    } // orderList: retorna lista ordenada por serie

    private void initComboBox(ArrayList<Vehicle> list) throws IOException {
        String series[] = new String[list.size()];
        for (int i = 0; i < series.length; i++) {
            series[i] = "" + list.get(i).getSerie();
        }
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(series));
    } // initComboBox: carga lista de series en ComboBox

    private void init() {
        try {
            this.vehicleBusiness = new VehicleBusiness();
            this.vehicles = this.vehicleBusiness.getAllVehicles();
            initButtonGroup();
            initComboBox(orderList(this.vehicles));
        } catch (IOException ex) {
            Logger.getLogger(JIFUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.jtfMileage.setEditable(false);
        activateComponents(false);
    } // refresh

    private void activateComponents(boolean b) {
        this.jtfName.setEditable(b);
        this.jtfYear.setEditable(b);
        this.jrbYes.setEnabled(b);
        this.jrbNo.setEnabled(b);
        this.jbOk.setEnabled(b);
    } // habilita y deshabilita componentes

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JButton jbOk;
    private javax.swing.JButton jbSearch;
    private javax.swing.JRadioButton jrbNo;
    private javax.swing.JRadioButton jrbYes;
    private javax.swing.JTextField jtfMileage;
    private javax.swing.JTextField jtfName;
    private javax.swing.JTextField jtfYear;
    // End of variables declaration//GEN-END:variables

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {
        Window.jmiUpdate.setEnabled(true);
    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameIconified(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameDeiconified(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameActivated(InternalFrameEvent e) {
    }

    @Override
    public void internalFrameDeactivated(InternalFrameEvent e) {
    }
} // fin de la clase
