package brainacad.kursak;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Серега on 13.06.2016.
 */
public class Trainer implements Serializable {
    private int id;
    private String name,
                    lastName;
    private Collection<Integer> courseId = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Collection<Integer> getCourseId() {
        return courseId;
    }

    public void setCourseId(Collection<Integer> courseId) {
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        System.out.println("____________________________________________________________________________________");
        System.out.println("\t\t\t\t\t\t\t Trainer id: " + id);
        System.out.println("\t\t\t\t\t\t\t Trainer name: " + name);
        System.out.println("\t\t\t\t\t\t\t Trainer last name: " + lastName);
        System.out.print("\t\t\t\t\t\t\t Trainer`s course id`s: ");
        Iterator<Integer> itr = courseId.iterator();
        int course_id;
        while(itr.hasNext()){
            course_id = itr.next();
            System.out.print(course_id + " ");
        }
        System.out.println("  ");

        return " ";
    }
}
