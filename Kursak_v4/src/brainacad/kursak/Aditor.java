package brainacad.kursak;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * Created by Серега on 14.06.2016.
 */
public  class Aditor {
      Collection<Course> courseList = new ArrayList<>();
      Collection<Student> studentList = new ArrayList<>();
      Collection<Trainer> trainerList = new ArrayList<>();
      Collection<Task> taskList = new ArrayList<>();


    int courseId = -1;
    int studentId = -1;
    int trainerId = -1;
    int taskID = -1;

//    int counterTrainer =1;

      String tabulator = "\t\t\t\t\t\t\t ";



    public  int inputInt(String st){
        int i = -1;
        while(i<0) {
            Scanner scanner = new Scanner(in);
            try {
                System.out.println(st);
                i = scanner.nextInt();
            } catch (Exception e) {
                System.out.println( "You write dont integer data ");
            }
        }
        return i;
    }

    public String inputString (String st){
        Scanner scanner = new Scanner(in);
        out.println(st);
        return scanner.nextLine();
    }

    public void removeTrainerById(int id){
        Trainer trainer;
        Iterator<Trainer> itr = trainerList.iterator();
        while (itr.hasNext()){
            trainer = itr.next();
            if (id == trainer.getId())
                itr.remove();
        }
    }

    public Trainer getTrainerById (int id){
        Trainer trainer;
        Iterator <Trainer> itr = trainerList.iterator();
        while (itr.hasNext()){
            trainer = itr.next();
            if (id == trainer.getId())
            return trainer;
        }
        return null;
    }

    public Course getCourseById(int id){
        Course course;
        Iterator <Course> itr = courseList.iterator();
        while (itr.hasNext()){
            course = itr.next();
            if (id == course.getId())
                return course;
        }
        return null;
    }

    public void removeCourseById (int id){
        Course course;
        Iterator <Course> itr = courseList.iterator();
        while (itr.hasNext()){
            course = itr.next();
            if (id == course.getId())
                itr.remove();
        }
    }

    public Student getStudentsById (int id){
        Student student;
        Iterator <Student> itr = studentList.iterator();
        while (itr.hasNext()){
            student = itr.next();
            if (id == student.getId())
                return student;
        }
        return null;
    }

    public void  removeStudentsById (int id) {
        Student student;
        Iterator <Student> itr = studentList.iterator();
        while (itr.hasNext()){
            student = itr.next();
            if(id == student.getId())
                itr.remove();
        }
    }

    public Task getTaskById(int id){
        Task task;
        Iterator<Task> itr = taskList.iterator();
        while (itr.hasNext()){
            task = itr.next();
            if(id == task.getId())
                return task;
        }
        out.println("\t\t\t\t\t\t\t get task by id - return NULL ");
        return null;
    }


    public void printAndFormat(String str){
        System.out.println("____________________________________________________________________________________");
        System.out.println(tabulator + str);
        System.out.println("____________________________________________________________________________________");}


    public void saveDataToFile(){
        try (ObjectOutputStream outObj = new ObjectOutputStream(new FileOutputStream("safeData.txt"))){
            outObj.writeObject(trainerId);
            outObj.writeObject(studentId);
            outObj.writeObject(courseId);
            outObj.writeObject(taskID);
            if(trainerId>=0){
                for (int i = 0 ; i<= trainerId; i++){
                    outObj.writeObject(getTrainerById(i));
                }
            }
            if (studentId>=0){
                for(int i = 0; i<=studentId; i++){
                    outObj.writeObject(getStudentsById(i));
                }
            }
            if (courseId>=0){
                for(int i=0; i<=courseId; i++){
                    outObj.writeObject(getCourseById(i));
                }
            }
            if(taskID>=0){
                for(int i= 0; i<=taskID; i++){
                    outObj.writeObject(getTaskById(i));
                }
            }
        }catch (IOException exp){
            exp.printStackTrace();
        }
    }

    public void readDataFromFile(){
        try (ObjectInputStream inputObj = new ObjectInputStream(new FileInputStream("safeData.txt"))){
            trainerId = (Integer) inputObj.readObject();
            studentId = (Integer) inputObj.readObject();
            courseId = (Integer) inputObj.readObject();
            taskID = (Integer) inputObj.readObject();
            if (trainerId >= 0){
                for(int i =0; i<=trainerId; i++){
                    trainerList.add((Trainer) inputObj.readObject());
                }
            }
            if (studentId>=0){
                for (int i =0; i<=studentId; i++){
                    studentList.add((Student) inputObj.readObject());
                }
            }
            if(courseId >=0){
                for (int i = 0; i<=courseId; i++){
                    courseList.add((Course) inputObj.readObject());
                }
            }
            if (taskID >=0){
                for (int i = 0; i<=taskID; i++){
                    taskList.add((Task) inputObj.readObject());
                }
            }
        }catch (IOException exp){
            exp.printStackTrace();
        }catch (ClassNotFoundException ex){
            ex.printStackTrace();
        }
    }

}
