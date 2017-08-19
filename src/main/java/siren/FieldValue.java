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
            return new FieldValue<T>(this.title, this.value, this.selected);
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
    private boolean selected;

    /**
     * Constructs an instance of {@link FieldValue}.
     * @param value The value for the field.
     */
    private FieldValue(T value){
        if(value == null){
            throw new IllegalStateException("'value' cannot be null as it is required.");
        }
        //TODO - 2017-08-19 - Perform type checking on T to make sure it is either a number of a string.
        this.value = value;
    }

    /**
     * Constructs an instance of {@link FieldValue}.
     * @param title The textual description of a field value.
     * @param value The value for the field.
     * @param selected Indicates whether this value should be considered preselected.
     */
    private FieldValue(String title, T value, boolean selected){
        this(value);
        this.title = title;
        this.value = value;
        this.selected = selected;
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
    public boolean getSelected(){
        return this.selected;
    }
}
