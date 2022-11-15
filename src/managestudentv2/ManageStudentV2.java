/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package managestudentv2;

import data.Cabinet;

/**
 *
 * @author MR-LUONG
 */
public class ManageStudentV2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Cabinet se = new Cabinet();
        se.addAStudent();
        se.addAStudent();
        
        se.printStudentList();
        
        
        //se.searchAStudent("SE123456");
        se.searchAStudent();
        
        se.updateAStudent();
        se.printStudentList();
    }
}
