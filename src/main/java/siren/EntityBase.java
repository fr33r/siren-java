package siren;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jonfreer
 * @since 8/13/17
 */
public abstract class EntityBase {

    private List<String> classes;
    private String title;

    public EntityBase(){
        this.classes = new ArrayList<String>();
    }

    public EntityBase(List<String> classes, String title){
        this.classes = classes;
        this.title = title;
    }

    public List<String> getClasses(){
        List<String> classesCopy = new ArrayList<String>();
        classesCopy.addAll(this.classes);
        return classesCopy;
    }

    public String getTitle(){
        return this.title;
    }

    public boolean equals(Object obj){
        if(obj == null || this.getClass() != obj.getClass()) return false;

        EntityBase entity = (EntityBase)obj;

        boolean sameClasses = this.classes.equals(entity.classes);

        return sameClasses;
    }

    public int hashCode(){

        final int prime = 31;
        int hashCode = 1;

        if(this.classes != null){
            hashCode *= prime + this.classes.hashCode();
        }

        return hashCode;
    }
}
