package siren;

/**
 * Value objects represent multiple selectable field values.
 * Use in conjunction with field `"type" = "radio"` and `"type" = "checkbox"`
 * to express that zero, one or many out of several possible values may
 * be sent back to the server.
 * @author jonfreer
 * @since 8/13/17
 */
public class FieldValue<T> {

    /**
     * Constructs an instance of {@link FieldValue.Builder}.
     */
    public static class Builder<T> implements siren.Builder<FieldValue<T>>{

        private String title;
        private T value;
        private Boolean selected;

        /**
         * Adds the value provided to the current state of the builder.
         * @param value Possible value for the field.
         * @return The builder this method is called on.
         */
        public Builder<T> value(T value){
            if(value == null){
                throw new IllegalArgumentException("'value' cannot be null.");
            }
            this.value = value;
            return this;
        }

        /**
         * Adds the title provided to the current state of the builder.
         * @param title Textual description of a field value.
         * @return The builder this method is called on.
         */
        public Builder<T> title(String title){
            this.title = title;
            return this;
        }

        /**
         * Adds the provided flag indicating whether to be selected to the current state of the builder.
         * @param selected Indicates whether this field value should be considered preselected by the client.
         * @return The builder this method is called on.
         */
        public Builder<T> selected(Boolean selected){
            this.selected = selected;
            return this;
        }

        /**
         * Clears the state of the builder.
         */
        @Override
        public void clear() {
            this.title = null;
            this.value = null;
            this.selected = null;
        }

        /**
         * Constructs an instance of {@link T} with the
         * current state of the builder.
         *
         * @return Instance of {@link T} with the current state of the builder.
         */
        @Override
        public FieldValue<T> build() {
            return new FieldValue<>(this.title, this.value, this.selected);
        }
    }

    /**
     * The textual description of a field value.
     */
    private String title;

    /**
     * The value for the field.
     */
    private T value;

    /**
     * Indicates whether this value should be considered preselected.
     */
    private Boolean selected;

    /**
     * Constructs an instance of {@link FieldValue}.
     * @param value The value for the field.
     */
    private FieldValue(T value){
        if(value == null){
            throw new IllegalArgumentException("'value' cannot be null as it is required.");
        }

        //perform type checking on T to ensure it's either a number or a string.
        boolean isShort;
        boolean isInteger;
        boolean isLong;
        boolean isDouble;
        boolean isFloat;
        boolean isNumber;
        boolean isString;

        isFloat = value instanceof Float;
        isDouble = value instanceof Double;
        isInteger = value instanceof Integer;
        isLong = value instanceof Long;
        isShort = value instanceof Short;
        isNumber = isFloat || isDouble || isInteger || isLong || isShort;
        isString = value instanceof String;

        if(!isNumber && !isString){
            throw new IllegalArgumentException("'value' must be either a number or a string.");
        }

        this.value = value;
    }

    /**
     * Constructs an instance of {@link FieldValue}.
     * @param title The textual description of a field value.
     * @param value The value for the field.
     * @param selected Indicates whether this value should be considered preselected.
     */
    private FieldValue(String title, T value, Boolean selected){
        this(value);

        this.title = title;
        this.selected = selected;
    }

    /**
     * Determines if the instance of {@link Object} provided is
     * equal to the calling {@link FieldValue} instance.
     * @param obj The instance of {@link FieldValue} being examined.
     * @return {@code true} if the instances are equal; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj){

        if(obj == null || obj.getClass() != this.getClass()) return false;

        FieldValue<T> fieldValue = (FieldValue<T>)obj;

        boolean sameValue = this.value.equals(fieldValue.value);

        boolean sameTitle =
            this.title == null && fieldValue.title == null ||
            this.title != null && fieldValue.title != null &&
            this.title.equals(fieldValue.title);

        boolean sameSelected =
            this.selected == null && fieldValue.selected == null ||
            this.selected != null && fieldValue.selected != null &&
            this.selected.equals(fieldValue.selected);

        return sameTitle && sameValue && sameSelected;
    }

    /**
     * Generates hashcode represented as an integer for the calling {@link FieldValue} instance.
     * @return The hashcode for the calling {@link FieldValue} instance.
     */
    @Override
    public int hashCode(){

        final int PRIME = 31;
        int hashCode = 1;

        hashCode *= PRIME + this.value.hashCode();

        if(this.title != null){
            hashCode *= PRIME + this.title.hashCode();
        }

        if(this.selected != null){
            hashCode *= PRIME + this.selected.hashCode();
        }

        return hashCode;
    }

    /**
     * Retrieves the textual description of a field value.
     * @return The textual description of a field value.
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * Retrieves the value for the field.
     * @return The value for the field.
     */
    public T getValue(){
        return this.value;
    }

    /**
     * Retrieves whether this value should be considered preselected.
     * @return Indicates whether this value should be considered preselected.
     */
    public Boolean getSelected(){
        return this.selected;
    }
}
