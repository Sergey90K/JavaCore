package brainacad.kursak;

import java.io.Serializable;

/**
 * Created by Серега on 13.06.2016.
 */
public class Student implements Serializable {
   private int id,
                coursId;
    private String name,
                    lastName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCoursId() {
        return coursId;
    }

    public void setCoursId(int coursId) {
        this.coursId = coursId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        System.out.println("____________________________________________________________________________________");
        System.out.println("\t\t\t\t\t\t\t Student id: " + id);
        System.out.println("\t\t\t\t\t\t\t Name: " + name);
        System.out.println("\t\t\t\t\t\t\t Last name: " + lastName);
        System.out.println("\t\t\t\t\t\t\t Course id: " + coursId);
        System.out.println("____________________________________________________________________________________");

        return " ";
    }
}
