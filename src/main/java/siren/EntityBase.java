package siren;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jonfreer
 * @since 8/13/17
 */
public abstract class EntityBase {

    private List<String> klass;
    private String title;

    public EntityBase(){
        this.klass = new ArrayList<String>();
    }

    public EntityBase(List<String> klass, String title){
        this.klass = klass;
        this.title = title;
    }

    public List<String> getKlass(){
        if(this.klass == null) return this.klass;
        List<String> classesCopy = new ArrayList<String>();
        classesCopy.addAll(this.klass);
        return classesCopy;
    }

    public String getTitle(){
        return this.title;
    }

    public boolean equals(Object obj){
        if(obj == null || this.getClass() != obj.getClass()) return false;

        EntityBase entity = (EntityBase)obj;

        boolean sameClasses = this.klass.equals(entity.klass);

        return sameClasses;
    }

    public int hashCode(){

        final int prime = 31;
        int hashCode = 1;

        if(this.klass != null){
            hashCode *= prime + this.klass.hashCode();
        }

        return hashCode;
    }
}
