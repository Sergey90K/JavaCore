package brainacad.kursak;

import java.io.Serializable;

/**
 * Created by Серега on 13.06.2016.
 */
public class Course implements Serializable{
    private int id,
                trainerId;
    private String dataBegin,
                    dataEnd,
                    name,
                    description,
                    workDays;
    private int studentsCount = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public String getDataBegin() {
        return dataBegin;
    }

    public void setDataBegin(String dataBegin) {
        this.dataBegin = dataBegin;
    }

    public String getDataEnd() {
        return dataEnd;
    }

    public void setDataEnd(String dataEnd) {
        this.dataEnd = dataEnd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWorkDays() {
        return workDays;
    }

    public void setWorkDays(String workDays) {
        this.workDays = workDays;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public void setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
    }
}
