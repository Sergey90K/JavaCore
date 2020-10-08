package brainacad.kursak;

import java.util.Collection;

/**
 * Created by Серега on 29.06.2016.
 */
public class Work extends Aditor {


    public void createCourse (){
//        System.out.println("____________________________________________________________________________________");
//        System.out.println("\t\t\t\t\t\t\t Creating new course. ");
//        System.out.println("____________________________________________________________________________________");
          printAndFormat("Creating new course.");


        int writrTrener = inputInt(" Werine trener ID -");

        if (writrTrener > trainerId ){
//            System.out.println("____________________________________________________________________________________");
//            System.out.println("\t\t\t\t\t\t\t Trener Id dont correct \n\t\t\t\t\t\t\t Cours dont created");
//            System.out.println("____________________________________________________________________________________");
            printAndFormat("Trener Id dont correct \n" + tabulator + " Cours dont created");
            return;
        }else {

            Course courseNew = new Course();
            courseNew.setId(++courseId);
            courseNew.setTrainerId(writrTrener);

            Trainer trainerChange = getTrainerById(writrTrener);
            Collection<Integer> turnCoursId = trainerChange.getCourseId();
            turnCoursId.add(courseId);
            trainerChange.setCourseId(turnCoursId);
            removeTrainerById(writrTrener);
            trainerList.add(trainerChange);
            courseNew.setStudentsCount(0);
            courseNew.setName(inputString(" Write course name "));
            courseNew.setDescription(inputString(" Write description yor course "));
            courseNew.setDataBegin(inputString(" Write data of starting course "));
            courseNew.setDataEnd(inputString(" Write data of ended course "));
            courseNew.setWorkDays(inputString(" Write dey of wec wen course exist "));

            courseList.add(courseNew);
//            System.out.println("____________________________________________________________________________________");
//            System.out.println("\t\t\t\t\t\t\tCourse created,and app to new their exist. Their ID - " + courseId);
//            System.out.println("____________________________________________________________________________________");
            printAndFormat("Course created,and app to new their exist.");
        }



    }

    public void getCourseInfo(){
//        System.out.println("____________________________________________________________________________________");
//        System.out.println( "\t\t\t\t\t\t\t Informatoins about course " );
//        System.out.println("____________________________________________________________________________________");
        printAndFormat("Informatoins about course ");
        int id = inputInt(" Write ID course ");
        if (id > courseId){
            System.out.println(tabulator + "You write dont correct ID course? they dont exist " );
            return;
        }
        Course course = getCourseById(id);
        System.out.println(tabulator +" Course ID " + id);
        System.out.println(tabulator + "Name of course " + course.getName());
        System.out.println(tabulator + "Description about course " + course.getDescription());
        System.out.println(tabulator + "When their started " + course.getDataBegin());
        System.out.println(tabulator + "When their ended " + course.getDataEnd());
        System.out.println(tabulator + "Work days " + course.getWorkDays());
        System.out.println(tabulator + "Quantity of students " + course.getStudentsCount());
        System.out.println(tabulator + "Trainer ID of course " + course.getTrainerId());
        System.out.println(tabulator + getTrainerById(course.getTrainerId()));
//        System.out.println("____________________________________________________________________________________");
//        System.out.println("\t\t\t\t\t\t\t Its oll data ");
//        System.out.println("____________________________________________________________________________________");
        printAndFormat("Its oll data ");

    }

    public void getCourseList(){
//        System.out.println("____________________________________________________________________________________");
//        System.out.println("\t\t\t\t\t\t\t GetCourseList \n\t\t\t\t\t\t\t Existing course ");
//        System.out.println("____________________________________________________________________________________");
        printAndFormat("GetCourseList \n" + tabulator + " Existing course ");
        for (int i=0; i<=courseId; i++) {
            System.out.println(tabulator + "ID course " + i + " Name " + getCourseById(i).getName());
        }
    }




    public void createStudent(){
//        System.out.println("____________________________________________________________________________________");
//        System.out.println("\t\t\t\t\t\t\t Start creating student ");
//        System.out.println("____________________________________________________________________________________");
        printAndFormat("Start creating student ");
        int id = inputInt(" Write ID course, where you wont create student ");
        if (id > courseId || id < -1){
            System.out.println(tabulator + "You write dont correct ID course ");
            System.out.println("____________________________________________________________________________________");
            return;
        }

        Course course = getCourseById(id);
        int studCount = course.getStudentsCount();
        if(studCount >= 15){
            System.out.println(tabulator + "On this course 15 student. We can not add new student ");
            System.out.println("____________________________________________________________________________________");
        }
        course.setStudentsCount(++studCount);
        removeCourseById(id);
        courseList.add(course);
        Student studentNew = new Student();
        studentNew.setId(++studentId);
        studentNew.setName(inputString(" Write name of student "));
        studentNew.setLastName(inputString(" Write surname of student "));
        studentNew.setCoursId(id);
        studentList.add(studentNew);
//        System.out.println("____________________________________________________________________________________");
//        System.out.println("\t\t\t\t\t\t\t Student has been created, its ID - " + studentId);
//        System.out.println("____________________________________________________________________________________");
        printAndFormat("Student has been created");
    }

    public void transferStudent () {
//        System.out.println("____________________________________________________________________________________");
//        System.out.println("\t\t\t\t\t\t\t Transfer a student ");
//        System.out.println("____________________________________________________________________________________");
        printAndFormat("Transfer a student ");
        int id = inputInt(" Write students ID ");
        if (id < 0 || id > studentId) {
//            System.out.println("____________________________________________________________________________________");
//            System.out.println("\t\t\t\t\t\t\t This student not exist ");
//            System.out.println("____________________________________________________________________________________");
            printAndFormat("This student not exist ");
            return;
        }
        Student student = getStudentsById(id);
//        System.out.println("____________________________________________________________________________________");
//        System.out.println("\t\t\t\t\t\t\t Student course ID " + student.getCoursId());
//        System.out.println("____________________________________________________________________________________");
        printAndFormat("Student course ID " + student.getCoursId());
        int newId = inputInt(" Write new course ID ");
        if (newId <0 || newId > courseId ){
//            System.out.println("____________________________________________________________________________________");
//            System.out.println("\t\t\t\t\t\t\t This course dont exist ");
//            System.out.println("____________________________________________________________________________________");
            printAndFormat("This course dont exist ");
            return;
        }
        student.setCoursId(newId);
        removeStudentsById(id);
        studentList.add(student);
//        System.out.println("____________________________________________________________________________________");
//        System.out.println("\t\t\t\t\t\t\t Transfer was successful ");
//        System.out.println("____________________________________________________________________________________");
        printAndFormat("Transfer was successful ");
    }

    public void getStudentInfo(){
//        System.out.println("____________________________________________________________________________________");
//        System.out.println("\t\t\t\t\t\t\t getStudentInfo");
//        System.out.println("____________________________________________________________________________________");
        printAndFormat("getStudentInfo");
        int id = inputInt(" Write student ID ");
        if (id < 0 || id > studentId ){
//            System.out.println("____________________________________________________________________________________");
//            System.out.println("\t\t\t\t\t\t\t This student not exist ");
//            System.out.println("____________________________________________________________________________________");
            printAndFormat("This student not exist ");
            return;
        }
        Student student = getStudentsById(id);
        System.out.println("____________________________________________________________________________________");
        System.out.println(student);
//        System.out.println("____________________________________________________________________________________");
//        System.out.println("\t\t\t\t\t\t\t This oll data");
//        System.out.println("____________________________________________________________________________________");
        printAndFormat("This oll data");
    }



    public void createNewTask () {
//        System.out.println("____________________________________________________________________________________");
//        System.out.println("\t\t\t\t\t\t\t  Creating new Task ");
//        System.out.println("____________________________________________________________________________________");
        printAndFormat("Creating new Task ");
        Student student;
        int curId = inputInt(" Write course ID ");
        if (curId < 0 || curId > courseId ) {
//            System.out.println("____________________________________________________________________________________");
//            System.out.println("\t\t\t\t\t\t\t This course not exist ");
//            System.out.println("____________________________________________________________________________________");
            printAndFormat("This course not exist ");
            return;
        }
        String descr = inputString(" Write description of task ");
        for (int stdId = 0; stdId <=studentId; stdId++){
            student = getStudentsById(stdId);
            if (student.getCoursId() == curId){
                Task taskMew = new Task();
                taskMew.setId(++taskID);
                taskMew.setCourseId(curId);
                taskMew.setStudentId(stdId);
                taskMew.setMark(0);
                taskMew.setDescr(descr);
                taskList.add(taskMew);
            }
        }
//        System.out.println("____________________________________________________________________________________");
//        System.out.println("\t\t\t\t\t\t\tTask be creating . Total task " + taskList.size() + " task ID " + taskID);
//        System.out.println("____________________________________________________________________________________");
        printAndFormat("Task be creating . Total task " + taskList.size());
    }

    public void getStudentByCourseId (){
//        System.out.println("____________________________________________________________________________________");
//        System.out.println("\t\t\t\t\t\t\t Informations about Students by course ID ");
//        System.out.println("____________________________________________________________________________________");
        printAndFormat("Informations about Students by course ID ");
        int courId = inputInt(" Write course ID ");
        if ( courId < 0 || courId > courseId){
//            System.out.println("____________________________________________________________________________________");
//            System.out.println("\t\t\t\t\t\t\t This course dont exist ");
//            System.out.println("____________________________________________________________________________________");
            printAndFormat("This course dont exist ");
            return;
        }
//        if (studentId == 1){
//            System.out.println("____________________________________________________________________________________");
//            System.out.println("\t\t\t\t\t\t\t Student dont creating ");
//            System.out.println("____________________________________________________________________________________");
//            return;
//        }
        Student student;
        for (int studId = 0; studId <= studentId;studId++){
            student = getStudentsById(studId);
            if (student.getCoursId() == courId){
                System.out.println(student);
            }
        }
//        System.out.println("____________________________________________________________________________________");
//        System.out.println("\t\t\t\t\t\t\t  This oll data");
//        System.out.println("____________________________________________________________________________________");
        printAndFormat("This oll data");
    }

    public void getTaskListByCourseId(){
//        System.out.println("____________________________________________________________________________________");
//        System.out.println("\t\t\t\t\t\t\t Show task list of oll student by course ID  ");
//        System.out.println("____________________________________________________________________________________");
        printAndFormat("Show task list of oll student by course ID  ");
        int courID = inputInt("Write course ID ");
        if (courID <0 || courID > courseId){
//            System.out.println("____________________________________________________________________________________");
//            System.out.println("\t\t\t\t\t\t\t This course dont create app to new ");
//            System.out.println("____________________________________________________________________________________");
            printAndFormat("This course dont create app to new ");
            return;
        }
        Task task;
        Student student;
        System.out.println("tasks ID " + taskID);
        for (int i = 0; i <= taskID; i++){
            task = getTaskById(i);
            if(task.getCourseId() == courID){
                System.out.println(tabulator + "Task ID " + task.getId());
                System.out.println(tabulator + "Description " + task.getDescr());
                student = getStudentsById(task.getStudentId());
                System.out.println(tabulator + "Student " + student.getName()+" " + student.getLastName());
                System.out.println(tabulator + "Course ID " + task.getCourseId());
                System.out.println(tabulator + "Marc " + task.getMark());
            }
        }
//        System.out.println("____________________________________________________________________________________");
//        System.out.println("\t\t\t\t\t\t\t  This oll data");
//        System.out.println("____________________________________________________________________________________");
        printAndFormat("This oll data");
    }



    public void createTrainer(){
//        System.out.println("____________________________________________________________________________________");
//        System.out.println(" \t\t\t\t\t\t\t  Creating new trainer ");
//        System.out.println("____________________________________________________________________________________");
        printAndFormat("Creating new trainer ");
        Trainer trainerNew = new Trainer();
        trainerNew.setId(++trainerId);
        trainerNew.setName(inputString(" Write name of trainer "));
        trainerNew.setLastName(inputString(" Write surname of trainer "));
        trainerList.add(trainerNew);
//        System.out.println("____________________________________________________________________________________");
//        System.out.println(" \t\t\t\t\t\t\t New trainer creating, with ID -  " + trainerId);
//        System.out.println("____________________________________________________________________________________");
        printAndFormat("New trainer creating");


    }

    public void getTrainerInfo (){
//        System.out.println("____________________________________________________________________________________");
//        System.out.println(" \t\t\t\t\t\t\t Informations about one Trainer ");
//        System.out.println("____________________________________________________________________________________");
        printAndFormat("Informations about one Trainer ");
        int id = inputInt(" Write trainer ID ");
        if (id < 0 || id > trainerId) {
//            System.out.println("____________________________________________________________________________________");
//            System.out.println(" \t\t\t\t\t\t\t This trainer not exist ");
//            System.out.println("____________________________________________________________________________________");
            printAndFormat("This trainer not exist ");
            return;
        }
        Trainer trainer = getTrainerById(id);
        System.out.println(trainer);
//        System.out.println("____________________________________________________________________________________");
//        System.out.println("\t\t\t\t\t\t\t  This oll data");
//        System.out.println("____________________________________________________________________________________");
        printAndFormat("This oll data");
    }



}
