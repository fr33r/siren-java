package siren;

import java.util.ArrayList;
import java.util.List;

/**
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

    public static class Builder<T> {

        private String name;
        private String type;
        private String title;
        private T value;

        public Builder<T> name(String name){
            this.name = name;
            return this;
        }

        public Builder<T> title(String title){
            this.title = title;
            return this;
        }

        public Builder<T> type(String type){
            this.type = type;
            return this;
        }

        public Builder<T> value(T value){
            this.value = value;
            return this;
        }

        public Field<T> build(){
            return new Field<T>(this.name, this.type, this.title, this.value);
        }
    }

    private String name;
    private String type;
    private String title;
    private T value;
    private List<String> fieldList;

    private Field(){
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
    }

    public Field(String name, String type, String title, T value){
        this();

        if(!this.fieldList.contains(title)){
            //throw;
        }

        this.name = name;
        this.title = title;
        this.value = value;
        this.type = type;
    }

    public String getName(){
        return this.name;
    }

    public String getType(){
        return this.type;
    }

    public T getValue(){
        return this.value;
    }

    public String getTitle(){
        return this.title;
    }
}
