/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import business.vehicleBusiness;
import domain.Vehicle;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.InternalFrameEvent;
import javax.swing.event.InternalFrameListener;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author maikel
 */
public class JIFDeleteVehicle extends JInternalFrame implements ActionListener, MouseListener, InternalFrameListener {

    private vehicleBusiness vehiBusiness;
    private JTable jtbTable1;
    private DefaultTableModel dtmModelTable;
    private JScrollPane scrollPane;
    private ArrayList<Vehicle> list;
    private JButton jbtnDelete;
    private int position1;
    public static JIFDeleteVehicle ventana;

    public JIFDeleteVehicle() {
        super("Delete By Serie", false, true, false, false);
        this.setLayout(null);
        this.refresh();
        this.init();
        this.setVisible(false);
        this.setLocation(20, 40);
        this.setSize(500, 325);
        this.addInternalFrameListener(this);
    }

    public void init() {
        this.jbtnDelete = new JButton("Delete");
        this.jbtnDelete.setBounds(400, 150, 90, 90);
        this.jbtnDelete.addActionListener(this);
        this.add(this.jbtnDelete);

    }

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
        scrollPane.setBounds(0, 2, 300, 300);
        this.setForeground(Color.red);
        this.jtbTable1.setSelectionBackground(Color.GREEN);
        this.getContentPane().add(scrollPane);

        this.jtbTable1.addMouseListener(this);

    } // init
    //mouseListener para agarrar los valores de la tabla para hacer el pedido

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.jbtnDelete) {
            try {
                if (!(this.list.isEmpty()) && this.vehiBusiness.deleteStudent(this.list.get(this.position1).getSerie())) {
                    JOptionPane.showMessageDialog(rootPane, "Success");

                    this.getContentPane().remove(this.scrollPane);
                    refresh();

                } else {
                    
                    JOptionPane.showMessageDialog(rootPane, "The Serie not in the file");
                }
            } catch (IOException ex) {
                Logger.getLogger(JIFDeleteVehicle.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //this.dtmModelTable.fireTableDataChanged();
        this.position1 = this.jtbTable1.getSelectedRow();
        //JOptionPane.showMessageDialog(rootPane, this.jtbTable1.getRowCount());
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void refresh() {
        try {
            this.vehiBusiness = new vehicleBusiness();
            this.list = this.vehiBusiness.getAllVehicles();
            
        } catch (IOException ex) {
            Logger.getLogger(JIFDeleteVehicle.class.getName()).log(Level.SEVERE, null, ex);
        }
        initTable(this.list);

    }

    @Override
    public void internalFrameOpened(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameClosing(InternalFrameEvent e) {

    }

    @Override
    public void internalFrameClosed(InternalFrameEvent e) {
        Window.jmiDelete.setEnabled(true);

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
