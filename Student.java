package bgu.spl.mics.application.objects;

import java.util.List;

/**
 * Passive object representing single student.
 * Add fields and methods to this class as you see fit (including public methods and constructors).
 */
public class Student {
    /**
     * Enum representing the Degree the student is studying for.
     */
    enum Degree {
        MSc, PhD
    }

    private int name;
    private String department;
    private Degree status;
    private int publications;
    private int papersRead;
    private List<Model> models;
    private int currentModel;

    public Student(int name_, String department_, Degree status_, List<Model> models_){
        name = name_;
        department = department_;
        status = status_;
        publications = 0;
        papersRead = 0;
        models = models_;
        currentModel=0;
    }
    private void nextModel(){
        currentModel++;
    }
    public Model getModel(){
        nextModel();
        return (models.get(currentModel-1));
    }
}
