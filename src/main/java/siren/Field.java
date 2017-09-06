package siren;

import java.util.List;

/**
 * Represents a control inside of an action.
 * @author jonfreer
 * @since 8/13/17
 */
public class Field<T> {

    /**
     * Constructs an instance of {@link Field.Builder}.
     */
    public static class Builder<T> implements siren.Builder<Field<T>>{

        private String name;
        private FieldType type;
        private String title;
        private T value;

        /**
         * Adds the name provided to the current state of the builder.
         * @param name A name describing the control. Field names MUST be unique
         *             within the set of fields for an action. The behaviour of
         *             clients when parsing a Siren document that violates this
         *             constraint is undefined.
         * @return The builder this method is called on.
         */
        public Builder<T> name(String name){
            this.name = name;
            return this;
        }

        /**
         * Adds the title provided to the current state of the builder.
         * @param title Textual annotation of a field. Clients may use this as a label.
         * @return The builder this method is called on.
         */
        public Builder<T> title(String title){
            this.title = title;
            return this;
        }

        /**
         * Adds the type provided to the current state of the builder.
         * @param type The input type of the field. This is a subset of
         *             the input types specified by HTML5.
         * @return The builder this method is called on.
         */
        public Builder<T> type(FieldType type){
            this.type = type;
            return this;
        }

        /**
         * Adds the value provided to the current state of the builder.
         * @param value The value assigned to the field.
         * @return The builder this method is called on.
         */
        public Builder<T> value(T value){
            this.value = value;
            return this;
        }

        /**
         * Clears the state of the builder.
         */
        @Override
        public void clear() {
            this.name = null;
            this.title = null;
            this.value = null;
            this.type = null;
        }

        /**
         * Constructs an instance of {@link T} with the
         * current state of the builder.
         *
         * @return Instance of {@link T} with the current state of the builder.
         */
        @Override
        public Field<T> build() {
            return new Field<T>(this.name, this.type, this.title, this.value);
        }
    }

    /**
     * A name describing the control. Field names MUST be unique within the set of fields for an action.
     */
    private String name;

    /**
     * The input type of the field. This is a subset of the input types specified by HTML5.
     */
    private FieldType type;

    /**
     * Textual annotation of a field. Clients may use this as a label.
     */
    private String title;

    /**
     * The value assigned to the field.
     */
    private T value;

    /**
     * Constructs an instance of {@link Field}.
     * @param name The name describing the control. Field names MUST be unique
     *             within the set of fields for an action.
     */
    private Field(String name){
        if(name == null){
            throw new IllegalArgumentException("'name' cannot be null as it is required.");
        }
        this.name = name;
    }

    /**
     * Constructs an instance of {@link Field}.
     * @param name The name describing the control. Field names MUST be unique
     *             within the set of fields for an action.
     * @param type The input type of the field. This is a subset of the input
     *             types specified by HTML5.
     * @param title Textual annotation of a field. Clients may use this as a label.
     * @param value The value assigned to the field.
     */
    private Field(String name, FieldType type, String title, T value){
        this(name);

        //perform type checking on T to ensure it's either a number, a string, or a list (of FieldValue).
        boolean isShort, isInteger, isLong, isDouble,
                isFloat, isNumber, isString, isList;

        isFloat = value instanceof Float;
        isDouble = value instanceof Double;
        isInteger = value instanceof Integer;
        isLong = value instanceof Long;
        isShort = value instanceof Short;
        isNumber = isFloat || isDouble || isInteger || isLong || isShort;
        isString = value instanceof String;
        isList = value instanceof List;

        if(value != null && !isNumber && !isString && !isList){
            throw new IllegalArgumentException("'value' must be either a number, a string, or a list.");
        }

        this.title = title;
        this.value = value;
        this.type = type;
    }

    /**
     * Determines if the instance of {@link Object} provided is
     * equal to the calling {@link Field} instance.
     * @param obj The instance of {@link Field} being examined.
     * @return {@code true} if the instances are equal; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj){

        if(obj == null || obj.getClass() != this.getClass()) return false;

        Field<T> field = (Field<T>)obj;

        boolean sameName = this.name.equals(field.name);

        boolean sameTitle =
            this.title == null && field.title == null ||
            this.title != null && field.title != null &&
            this.title.equals(field.title);

        boolean sameValue =
            this.value == null && field.value == null ||
            this.value != null && field.value != null &&
            this.value.equals(field.value);

        boolean sameType =
            this.type == null && field.type == null ||
            this.type != null && field.type != null &&
            this.type.equals(field.type);

        return sameName && sameTitle && sameValue && sameType;
    }

    /**
     * Generates hashcode represented as an integer for the calling {@link Field} instance.
     * @return The hashcode for the calling {@link Field} instance.
     */
    @Override
    public int hashCode(){

        final int PRIME = 31;
        int hashCode = 1;

        hashCode *= PRIME + this.name.hashCode();

        if(this.title != null){
            hashCode *= PRIME + this.title.hashCode();
        }

        if(this.value != null){
            hashCode *= PRIME + this.value.hashCode();
        }

        if(this.type != null){
            hashCode *= PRIME + this.type.hashCode();
        }

        return hashCode;
    }

    /**
     * Retrieves the name describing the control. Field names MUST be unique
     * within the set of fields for an action.
     * @return The name describing the control. Field names MUST be unique
     * within the set of fields for an action.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Retrieves the input type of the field.
     * @return The input type of the field. This is a subset of
     * the input types specified by HTML5.
     */
    public FieldType getType(){
        return this.type;
    }

    /**
     * Retrieves the value assigned to the field.
     * @return The value assigned to the field.
     */
    public T getValue(){
        return this.value;
    }

    /**
     * Retrieves the textual annotation of a field. Clients may use this as a label.
     * @return Textual annotation of a field. Clients may use this as a label.
     */
    public String getTitle(){
        return this.title;
    }
}
