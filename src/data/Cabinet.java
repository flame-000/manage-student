/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package data;

import java.util.*;

/**
 *
 * @author MR-LUONG
 */
public class Cabinet {

    private List<Student> arr = new ArrayList();
    private Scanner sc = new Scanner(System.in);

    public void addAStudent() {
        String id, name;
        int yob;
        double gpa;

        System.out.println("Input student profile #" + (arr.size() + 1) + ": ");

        //CÒN TRÙNG ID TRONG GIỎ, THÌ KHÔNG CHO THOÁT - LOOP BẤT TẬN
        while (true) {
            System.out.println("Input id:");
            id = sc.nextLine().trim().toUpperCase(); //cắt trắng dư, đổi HOA

            Student xx = searchAStudent(id);
            if (xx == null) {
                break;
            } else {
                System.out.println("ID duplication!!! Try with another one");
            }
        }

        System.out.println("Input name: ");
        name = sc.nextLine().trim().toUpperCase();

        System.out.println("Input yob: ");
        yob = Integer.parseInt(sc.nextLine());
        //MyToys

        System.out.println("Input gpa: ");
        gpa = Double.parseDouble(sc.nextLine());

        arr.add(new Student(id, name, yob, gpa));
        System.out.println("The new student has been added successfully");
    }

    public void printStudentList() {
        if (arr.isEmpty()) {
            System.out.println("The student list is empty. Nothing to print");
            return;
        }

        System.out.println("There is/are " + arr.size() + "student");
        for (Student x : arr) {
            x.showProfile();
        }
    }

    //ta sẽ làm hàm search sv. Hàm này dùng cho nhiều mục đích
    //1. Search 1 sv đưa id vào
    //2. dùng lại ở các chỗ/nơi có nhu cầu tìm sv theo id
    // - kiểm tra xem id có tồn tại chưa ở hàm add//
    // - cập nhập 1 hồ sơ sv, hồ sơ nào, thì phải search
    // - xóa 1 sv, coi sv có tồn tại ko đã
    public Student searchAStudent(String id) {
        if (arr.isEmpty()) {
            return null; //ko có hồ sơ mà tìm, trả về null
        }
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getId().equalsIgnoreCase(id)) {
                return arr.get(i);
            }
        }   //tìm thấy trả về thẻ/card 
        return null;
    }

    public void searchAStudent() {
        String id;
        System.out.println("Input student id to seach a profile");
        id = sc.nextLine();
        Student xxx = searchAStudent(id);
        if (xxx == null) {
            System.out.println("NOT FOUND");
        } else {
            System.out.println("STUDENT FOUND");
        }
        System.out.println("Here he/she is");
        xxx.showProfile();
    }

    public void updateStudent(Student x, double newGPA) {
        if (x != null) {
            x.setGpa(newGPA);
        }

    }

    public void updateAStudent() {
        String id;
        double newGPA;

        System.out.println("Input student id to update a profile:");
        id = sc.nextLine();

        Student xx = searchAStudent(id);
        if (xx == null) {
            System.out.println("NOT FOUND! No student tobe update");
        } else {
            System.out.println("STUDENT FOUND!!");
            System.out.println("Here he/she is before updating gpa");
            xx.showProfile();

            //mời nhập điểm mới
            System.out.println("Input new gpa:");
            newGPA = Double.parseDouble(sc.nextLine());
            xx.setGpa(newGPA);
            System.out.println("Here he/she is before updating gpa");
            xx.showProfile();

        }
    }
}
