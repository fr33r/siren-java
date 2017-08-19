package siren;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a control inside of an action.
 * @author jonfreer
 * @since 8/13/17
 */
public class Field<T> {

    public static final String HIDDEN           = "hidden";
    public static final String TEXT             = "text";
    public static final String SEARCH           = "search";
    public static final String TEL              = "tel";
    public static final String URL              = "url";
    public static final String EMAIL            = "email";
    public static final String PASSWORD         = "password";
    public static final String DATETIME         = "datetime";
    public static final String DATE             = "date";
    public static final String MONTH            = "month";
    public static final String WEEK             = "week";
    public static final String TIME             = "time";
    public static final String DATETIME_LOCAL   = "datetime-local";
    public static final String NUMBER           = "number";
    public static final String RANGE            = "range";
    public static final String COLOR            = "color";
    public static final String CHECKBOX         = "checkbox";
    public static final String RADIO            = "radio";
    public static final String FILE             = "file";

    /**
     * Constructs an instance of {@link Field.Builder}.
     */
    public static class Builder<T> implements siren.Builder<Field<T>>{

        private String name;
        private String type;
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
        public Builder<T> type(String type){
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
    private String type;

    /**
     * Textual annotation of a field. Clients may use this as a label.
     */
    private String title;

    /**
     * The value assigned to the field.
     */
    private T value;

    /**
     * Represents a list of all valid field types.
     */
    private List<String> fieldList;

    /**
     * Constructs an instance of {@link Field}.
     * @param name The name describing the control. Field names MUST be unique
     *             within the set of fields for an action.
     */
    private Field(String name){

        if(this.name == null){
            throw new IllegalArgumentException("'name' cannot be null as it is required.");
        }

        this.fieldList = new ArrayList<String>();
        this.fieldList.add(HIDDEN);
        this.fieldList.add(TEXT);
        this.fieldList.add(SEARCH);
        this.fieldList.add(TEL);
        this.fieldList.add(URL);
        this.fieldList.add(EMAIL);
        this.fieldList.add(PASSWORD);
        this.fieldList.add(DATETIME);
        this.fieldList.add(DATE);
        this.fieldList.add(MONTH);
        this.fieldList.add(WEEK);
        this.fieldList.add(TIME);
        this.fieldList.add(DATETIME_LOCAL);
        this.fieldList.add(NUMBER);
        this.fieldList.add(RANGE);
        this.fieldList.add(COLOR);
        this.fieldList.add(CHECKBOX);
        this.fieldList.add(RADIO);
        this.fieldList.add(FILE);

        if(!this.fieldList.contains(type)){
            throw new IllegalArgumentException("the value for 'type' is not valid.");
        }
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
    private Field(String name, String type, String title, T value){
        this(name);
        this.name = name;
        this.title = title;
        this.value = value;
        this.type = type;
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
    public String getType(){
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
