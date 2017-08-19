package siren;

/**
 * Identifies the possible field types. This is a subset
 * of the input types specified by HTML5.
 * @author jonfreer
 * @since 8/19/17
 */
public enum FieldType {

    /**
     * Represents the input type of 'hidden'.
     */
    HIDDEN          ("hidden"),

    /**
     * Represents the input type of 'text'.
     */
    TEXT            ("text"),

    /**
     * Represents the input type of 'search'.
     */
    SEARCH          ("search"),

    /**
     * Represents the input type of 'tel'.
     */
    TEL             ("tel"),

    /**
     * Represents the input type of 'url'.
     */
    URL             ("url"),

    /**
     * Represents the input type of 'email'.
     */
    EMAIL           ("email"),

    /**
     * Represents the input type of 'password'.
     */
    PASSWORD        ("password"),

    /**
     * Represents the input type of 'datetime'.
     */
    DATETIME        ("datetime"),

    /**
     * Represents the input type of 'date'.
     */
    DATE            ("date"),

    /**
     * Represents the input type of 'month'.
     */
    MONTH           ("month"),

    /**
     * Represents the input type of 'week'.
     */
    WEEK            ("week"),

    /**
     * Represents the input type of 'time'.
     */
    TIME            ("time"),

    /**
     * Represents the input type of 'datetime-local'.
     */
    DATETIME_LOCAL  ("datetime-local"),

    /**
     * Represents the input type of 'number'.
     */
    NUMBER          ("number"),

    /**
     * Represents the input type of 'range'.
     */
    RANGE           ("range"),

    /**
     * Represents the input type of 'color'.
     */
    COLOR           ("color"),

    /**
     * Represents the input type of 'checkbox'.
     */
    CHECKBOX        ("checkbox"),

    /**
     * Represents the input type of 'radio'.
     */
    RADIO           ("radio"),

    /**
     * Represents the input type of 'file'.
     */
    FILE            ("file")
    ;

    /**
     * The input type of the field.
     */
    String fieldType;

    /**
     * Constructs the enum provided the textual representation
     * of the field type.
     * @param fieldType The textual representation of the field type.
     */
    FieldType(String fieldType){
        this.fieldType = fieldType;
    }

    /**
     * Retrieves a textual representation of the field type.
     * @return A textual representation of the field type.
     */
    @Override
    public String toString(){
        return this.fieldType;
    }
}
