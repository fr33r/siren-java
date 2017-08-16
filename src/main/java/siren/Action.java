package siren;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jonfreer
 * @since 8/13/17
 */
public class Action {

    public static class Builder {

        private String name;
        private String title;
        private String method;
        private String href;
        private List<Field> fields;
        private String type;

        public Builder name(String name){
            this.name = name;
            return this;
        }

        public Builder title(String title){
            this.title = title;
            return this;
        }

        public Builder method(String method){
            this.method = method;
            return this;
        }

        public Builder href(String href){
            this.href = href;
            return this;
        }

        public Builder type(String type){
            this.type = type;
            return this;
        }

        public Builder field(Field field){
            if(this.fields == null){
                this.fields = new ArrayList<Field>();
            }
            this.fields.add(field);
            return this;
        }

        public Action build(){
            return new Action(this.name, this.title, this.method, this.href, this.fields);
        }
    }

    private String name;
    private String title;
    private String method;
    private String href;
    private List<Field> fields;
    private String type;

    protected Action(){
        this.fields = new ArrayList<Field>();
    }

    public Action(String name, String title, String method, String href, List<Field> fields){
        this.name   = name;
        this.title  = title;
        this.method = method;
        this.href   = href;
        this.fields = fields;
        this.type   = "application/x-www-form-urlencoded";
    }

    public Action(String name, String title, String method, String href, List<Field> fields, String type){
        this.name   = name;
        this.title  = title;
        this.method = method;
        this.href   = href;
        this.fields = fields;
        this.type = type;
    }

    public Action(Action action){
        this.name   = action.name;
        this.title  = action.title;
        this.method = action.method;
        this.href   = action.href;
        this.fields = action.fields;
    }

    public String getName(){
        return this.name;
    }

    public String getTitle(){
        return this.title;
    }

    public String getMethod(){
        return this.method;
    }

    public String getHref(){
        return this.href;
    }

    public String getType()
    {
        return this.type;
    }

    public List<Field> getFields(){
        return this.fields;
    }

}
