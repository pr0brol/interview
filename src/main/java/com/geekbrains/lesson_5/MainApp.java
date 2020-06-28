package com.geekbrains.lesson_5;



public class MainApp {
    public static void main(String[] args) {

        StudentDaoImpl studentDao = new StudentDaoImpl();

        for (int i=0;i<100;i++){
            studentDao.save(new Student("student-" + i, (int) (Math.random()*5)));
        }

        studentDao.findAll().stream().forEach(s -> System.out.println(s.toString()));

        System.out.println();

        Student student = studentDao.findById(45L);
        System.out.println(student.toString());
        student.setName("super_student");
        studentDao.update(student);
        System.out.println(student.toString());
        System.out.println();

        studentDao.findAll().stream().forEach(s -> System.out.println(s.toString()));
        System.out.println();

        studentDao.delete(student);
        studentDao.findAll().stream().forEach(s -> System.out.println(s.toString()));

    }

}
