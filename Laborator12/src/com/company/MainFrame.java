package com.company;
/*Programul creeaza o fereastra ce curprinde in partea de sus o zona de text in care se va scrie componenta swing
 * (JButton,JLabel,JTextField) pe care dorim sa o adaugam, butonul "Add" ce adauga componenta aleasa si o eticheta
 * ce va preciza daca ceea ce am scris poate fi aplicat sau nu. Restul reprezinta panoul in care se adauga componentele.*/
import javax.swing.*;

public class MainFrame {
    public static void main(String[] args) {
        JFrame mainframe = new JFrame();
        ControlPanel controlPanel = new ControlPanel(mainframe);
    }
}
