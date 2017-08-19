package siren;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents the common lineage of all entities.
 * @author jonfreer
 * @since 8/13/17
 */
public abstract class EntityBase {

    /**
     * Describes the nature of an entity's content based on the current representation.
     * Possible values are implementation-dependent and should be documented.
     */
    private List<String> klass;

    /**
     * Descriptive text about the entity.
     */
    private String title;

    /**
     * Constructs an instance of {@link EntityBase}.
     */
    public EntityBase(){}

    /**
     * Constructs an instance of {@link EntityBase}.
     * @param klass Describes the nature of an entity's content based on the current representation.
     *              Possible values are implementation-dependent and should be documented.
     * @param title Descriptive text about the entity.
     */
    public EntityBase(List<String> klass, String title){
        this.klass = klass;
        this.title = title;
    }

    /**
     * Retrieves the class of the entity.
     * @return The class of the entity.
     */
    public List<String> getKlass(){
        if(this.klass == null) return this.klass;
        List<String> classesCopy = new ArrayList<String>();
        classesCopy.addAll(this.klass);
        return classesCopy;
    }

    /**
     * Retrieves the title of the entity.
     * @return The title of the entity.
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * Determines if the instance of {@link Object} provided is
     * equal to the calling {@link EntityBase} instance.
     * @param obj The instance of {@link Object} being examined.
     * @return {@code true} if the instances are equal; {@code false} otherwise.
     */
    public boolean equals(Object obj){
        if(obj == null || this.getClass() != obj.getClass()) return false;

        EntityBase entity = (EntityBase)obj;

        boolean sameClass =
                this.klass == null && entity.klass == null ||
                this.klass != null && entity.klass != null &&
                this.klass.equals(entity.klass);

        boolean sameTitle =
                this.title == null && entity.title == null ||
                this.title != null && entity.title != null &&
                this.title.equals(entity.title);

        return sameClass && sameTitle;
    }

    /**
     * Generates hashcode represented as an integer for the calling {@link EntityBase} sub-class instance.
     * @return The hashcode for the calling {@link EntityBase} sub-class instance.
     */
    public int hashCode(){

        final int prime = 31;
        int hashCode = 1;

        if(this.klass != null){
            hashCode *= prime + this.klass.hashCode();
        }

        if(this.title != null){
            hashCode *= prime + this.title.hashCode();
        }

        return hashCode;
    }
}
