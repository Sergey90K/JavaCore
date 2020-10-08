package brainacad.kursak;

import static java.lang.System.out;

/**
 * Created by Серега on 29.06.2016.
 */
public class Menu extends Work {

     private void runMenuAdmin(){
         int menu=0;
        while (menu !=11){
            System.out.println("____________________________________________________________________________________");
            out.println("\t\t\t\t\t\t\t Menu Admin");
            System.out.println("____________________________________________________________________________________");

            out.println(tabulator + "1. Creating new Course.");
            out.println(tabulator + "2. Info about one Course.");
            out.println(tabulator + "3. Cours List.");
            out.println(tabulator + "4. Creating new Student.");
            out.println(tabulator + "5. Transfer Student to another Course.");
            out.println(tabulator + "6. Info about one Student.");
            out.println(tabulator + "7. Creating new Trainer.");
            out.println(tabulator + "8. Info about one Trainer.");
            out.println(tabulator + "9. List of all Students by Course id.");
            out.println(tabulator + "10. Get task list with mark. ");
            out.println(tabulator + "11. Exit. ");

            System.out.println("____________________________________________________________________________________");
            menu = inputInt(" Input your wey ");
            System.out.println("____________________________________________________________________________________");

            switch (menu){

                case 1 : createCourse();
                    break;
                case 2 : getCourseInfo();
                    break;
                case 3 : getCourseList();
                    break;
                case 4: createStudent();
                    break;
                case 5: transferStudent();
                    break;
                case 6: getStudentInfo();
                    break;
                case 7: createTrainer();
                    break;
                case 8: getTrainerInfo();
                    break;
                case 9: getStudentByCourseId();
                    break;
                case 10: getTaskListByCourseId();
                    break;
                case 11: return;
                default:
                    System.out.println("____________________________________________________________________________________");
                    out.println("\t\t\t\t\t\t\t Write dont correct data");
                    System.out.println("____________________________________________________________________________________");
                    break;

            }
        }
    }
     private void runMenuTrainer(){
        int menu=0;
        while (menu !=8) {
            System.out.println("____________________________________________________________________________________");
            out.println("\t\t\t\t\t\t\t Menu Trainer");
            System.out.println("____________________________________________________________________________________");

            out.println(tabulator + "1. Info about one Course.");
            out.println(tabulator + "2. Cours List.");
            out.println(tabulator + "3. Info about one Student.");
            out.println(tabulator + "4. Info about one Trainer.");
            out.println(tabulator + "5. Create new task.");
            out.println(tabulator + "6. List of all Students by Course id.");
            out.println(tabulator + "7. Get task list with mark. ");
            out.println(tabulator + "8. Exit. ");

            System.out.println("____________________________________________________________________________________");
            menu = inputInt(" Input your wey ");
            System.out.println("____________________________________________________________________________________");

            switch (menu){
                case 1:getCourseInfo();
                    break;
                case 2:getCourseList();
                    break;
                case 3:getStudentInfo();
                    break;
                case 4:getTrainerInfo();
                    break;
                case 5:createNewTask();
                    break;
                case 6:getStudentByCourseId();
                    break;
                case 7:getTaskListByCourseId();
                    break;
                case 8: return;

                default:
                    System.out.println("____________________________________________________________________________________");
                    out.println("\t\t\t\t\t\t\t Write dont correct data");
                    System.out.println("____________________________________________________________________________________");
                    break;
            }
        }
    }
     private void runMenuStudent(){
        int menu=0;
        while (menu !=6) {
            System.out.println("____________________________________________________________________________________");
            out.println("\t\t\t\t\t\t\t Menu Student");
            System.out.println("____________________________________________________________________________________");

            out.println(tabulator + "1. Info about one Course.");
            out.println(tabulator + "2. Cours List.");
            out.println(tabulator + "3. Info about one Student.");
            out.println(tabulator + "4. List of all Students by Course id.");
            out.println(tabulator + "5. Get task list with mark. ");
            out.println(tabulator + "6. Exit. ");

            System.out.println("____________________________________________________________________________________");
            menu = inputInt("Input your wey ");
            System.out.println("____________________________________________________________________________________");

            switch (menu){
                case 1:getCourseInfo();
                    break;
                case 2:getCourseList();
                    break;
                case 3:getStudentInfo();
                    break;
                case 4:getStudentByCourseId();
                    break;
                case 5:getTaskListByCourseId();
                    break;
                case 6:return;

                default:
                    System.out.println("____________________________________________________________________________________");
                    out.println("\t\t\t\t\t\t\t Write dont correct data");
                    System.out.println("____________________________________________________________________________________");
                    break;

            }
        }
        }

     private boolean passwordMenu(String value){
      switch (value){
        case "admin": if(inputString("Write your password ").equals("root")){
                return true;
            } else return false;

        case "trainer": if(inputString("Write your password ").equals("toor")){
            return true;
        } else return false;

        case "student": if(inputString("Write your password ").equals("brain")){
            return true;
        } else return false;
      }
        return false;
    }

    public void startMenu(){
        readDataFromFile();
        int i=0;
        while (i<6) {
            System.out.println("************************************************************************************");
            System.out.print("*");
            System.out.print(" \t\t\t\t\t\t\t Start program ");
            System.out.println("\t\t\t\t\t\t\t\t\t\t   *");
            System.out.println("************************************************************************************");
            String menu = null;

//            System.out.println("\t\t\t\t\t\t\t admin");
            printAndFormat("admin");
//            System.out.println("____________________________________________________________________________________");
//            System.out.println("\t\t\t\t\t\t\t trainer");
            printAndFormat("trainer");
//            System.out.println("____________________________________________________________________________________");
//            System.out.println("\t\t\t\t\t\t\t student");
            printAndFormat("student");
//            System.out.println("____________________________________________________________________________________");
//            System.out.println("\t\t\t\t\t\t\t exit");
//            System.out.println("____________________________________________________________________________________");
            printAndFormat("exit");

            menu = inputString(" write who you are,or what you wont ");
            System.out.println("____________________________________________________________________________________");

            switch (menu) {

                case "admin":
                    if (passwordMenu(menu)) {
                        runMenuAdmin();
                    }else incorrectPassword();
                    break;
                case "trainer":
                    if (passwordMenu(menu)) {
                        runMenuTrainer();
                    }else incorrectPassword();
                    break;
                case "student":
                    if (passwordMenu(menu)) {
                        runMenuStudent();
                    }else incorrectPassword();
                    break;
                case "exit":saveDataToFile();
                    return;
                default:
                    System.out.println(tabulator + " Your choice is invalid, try again");
                    break;
            }
            i++;
        }


        }
    private void incorrectPassword(){
        System.out.println(tabulator + " Incorrect password ");
    }

}
