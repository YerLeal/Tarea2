/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import business.VehicleBusiness;
import domain.Vehicle;
import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maikel
 */
public class JIFShowVehicles extends JInternalFrame implements InternalFrameListener{
    //Atributos
    private VehicleBusiness vehiBusiness;
    private JTable jtbTable1;
    private DefaultTableModel dtmModelTable;
    private JScrollPane scrollPane;
    private ArrayList<Vehicle> list;

    //Constructor
    public JIFShowVehicles() {
        super("Show Vehicles", false, true, false, false);
        this.setLayout(null);
        this.refresh();
        this.setLocation(20, 40);
        this.setSize(400, 350);
        this.addInternalFrameListener(this);
    }
    //inicializa la tabla
    public void initTable(ArrayList<Vehicle> list) {

        Object[][] employeeDates = new Object[0][0];
        String[] columNames1 = {"Name", "Year", "Mileage", "American", "Serie"};
        this.dtmModelTable = new DefaultTableModel(employeeDates, columNames1);
        for (int i = 0; i < list.size(); i++) {

            this.dtmModelTable.addRow(new Object[]{list.get(i).getName(), list.get(i).getYear(), list.get(i).getMileage(),
                list.get(i).getAmerican(), list.get(i).getSerie()});

        }
        this.jtbTable1 = new JTable(this.dtmModelTable);
        this.scrollPane = new JScrollPane(this.jtbTable1);
        scrollPane.setBounds(50, 5, 300, 300);
        this.setForeground(Color.red);
        this.jtbTable1.setSelectionBackground(Color.GREEN);
        this.getContentPane().add(scrollPane);
        this.jtbTable1.setEnabled(false);

    } // initTabla
    
    //refresca los valores de la tabla
    public void refresh() {
        try {
            this.vehiBusiness = new VehicleBusiness();
            this.list = this.vehiBusiness.getAllVehicles();

        } catch (IOException ex) {
            Logger.getLogger(JIFDeleteVehicle.class.getName()).log(Level.SEVERE, null, ex);
        }
        initTable(this.list);

    }
    //Evento internalFrame para que cuando se cierre habilite el JMitem con el que se abre la ventana
    @Override
    public void internalFrameOpened(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
        Window.jmiShow.setEnabled(true);

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

}
