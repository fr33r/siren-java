package siren;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents an available behavior an entity exposes.
 * @author jonfreer
 * @since 8/13/17
 */
public class Action {

    /**
     * Constructs an instance of {@link Action.Builder}.
     */
    public static class Builder implements siren.Builder<Action>{

        private String name;
        private String title;
        private HttpMethod method;
        private URI href;
        private List<Field> fields;
        private String type;
        private List<String> klass;

        /**
         * Adds the name provided to the current state of the builder.
         * @param name A string that identifies the action to be performed.
         * @return The builder this method is called on.
         */
        public Builder name(String name){
            this.name = name;
            return this;
        }

        /**
         * Adds the title provided to the current state of the builder.
         * @param title Descriptive text about the action.
         * @return The builder this method is called on.
         */
        public Builder title(String title){
            this.title = title;
            return this;
        }

        /**
         * Adds the method provided to the current state of the builder.
         * @param method An enumerated attribute mapping to a protocol method.
         * @return The builder this method is called on.
         */
        public Builder method(HttpMethod method){
            this.method = method;
            return this;
        }

        /**
         * Adds the href provided to the current state of the builder.
         * @param href The URI of the action.
         * @return The builder this method is called on.
         */
        public Builder href(URI href){
            this.href = href;
            return this;
        }

        /**
         * Adds the type provided to the current state of the builder.
         * @param type The encoding type for the request.
         * @return The builder this method is called on.
         */
        public Builder type(String type){
            this.type = type;
            return this;
        }

        /**
         * Adds the field provided to the current state of the builder.
         * @param field Represent a control inside of the action.
         * @return The builder this method is called on.
         */
        public Builder field(Field field){
            if(field == null){
                throw new IllegalArgumentException("'field' cannot be null.");
            }
            if(this.fields == null){
                this.fields = new ArrayList<Field>();
            }
            this.fields.add(field);
            return this;
        }

        /**
         * Adds the class provided to the current state of the builder.
         * @param klass Describes the nature of an action based on the current representation.
         * @return The builder this method is called on.
         */
        public Builder klass(String klass){
            if(this.klass == null){
                this.klass = new ArrayList<String>();
            }
            this.klass.add(klass);
            return this;
        }

        /**
         * Clears the state of the builder.
         */
        @Override
        public void clear() {
            this.klass = null;
            this.title = null;
            this.name = null;
            this.fields = null;
            this.method = null;
            this.href = null;
        }

        /**
         * Constructs an instance of {@link Action} with the
         * current state of the builder.
         *
         * @return Instance of {@link Action} with the current state of the builder.
         */
        @Override
        public Action build() {
            // TODO 2017-08-15 - FREER - Do some checking that required state has been set.
            return new Action(
                    this.name,
                    this.title,
                    this.method,
                    this.href,
                    this.fields,
                    this.type,
                    this.klass
            );
        }
    }

    private String name;
    private String title;
    private HttpMethod method;
    private URI href;
    private List<Field> fields;
    private String type;
    private List<String> klass;
    private static final String DEFAULT_TYPE = "application/x-www-form-urlencoded";

    /**
     * Constructs an instance of {@link Action}.
     * @param name A string that identifies the action to be performed. Action names
     *             MUST be unique within the set of actions for an entity. The behaviour
     *             of clients when parsing a Siren document that violates this constraint is undefined.
     * @param href The URI of the action.
     */
    private Action(String name, URI href){
        if(name == null){
            throw new IllegalArgumentException("'name' cannot be null as it is required.");
        }

        if(href == null){
            throw new IllegalArgumentException("'href' cannot be null as it is required.");
        }
        this.name = name;
        this.href = href;
    }

    /**
     * Constructs an instance of {@link Action}.
     * @param name A string that identifies the action to be performed. Action names
     *             MUST be unique within the set of actions for an entity. The behaviour
     *             of clients when parsing a Siren document that violates this constraint is undefined.
     * @param title Descriptive text about the action.
     * @param method An enumerated attribute mapping to a protocol method. For HTTP,
     *               these values may be GET, PUT, POST, DELETE, or PATCH. As new methods
     *               are introduced, this list can be extended. If this attribute is omitted,
     *               GET should be assumed.
     * @param href The URI of the action.
     * @param fields Represent controls inside of actions.
     * @param type The encoding type for the request.
     * @param klass Describes the nature of an action based on the current
     *              representation. Possible values are implementation-dependent
     *              and should be documented.
     */
    private Action(String name, String title, HttpMethod method, URI href, List<Field> fields, String type, List<String> klass){
        this(name, href);

        this.title  = title;
        this.method = HttpMethod.GET;
        this.fields = fields;
        this.type   = DEFAULT_TYPE;
        this.klass  = klass;

        if(method != null) this.method = method;
        if(type != null) this.type = type;
    }

    /**
     * Determines if the instance of {@link Object} provided is
     * equal to the calling {@link Action} instance.
     * @param obj The instance of {@link Action} being examined.
     * @return {@code true} if the instances are equal; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj){
        if (obj == null || obj.getClass() != this.getClass()) return false;

        Action action = (Action)obj;

        boolean sameName =
            this.name == null && action.name == null ||
            this.name != null && action.name != null &&
            this.name.equals(action.name);

        boolean sameTitle =
            this.title == null && action.title == null ||
            this.title != null && action.title != null &&
            this.title.equals(action.title);

        boolean sameMethod =
            this.method == null && action.method == null ||
            this.method != null && action.method != null &&
            this.method.equals(action.method);

        boolean sameHref =
            this.href == null && action.href == null ||
            this.href != null && action.href != null &&
            this.href.equals(action.href);

        boolean sameFields =
            this.fields == null && action.fields == null ||
            this.fields != null && action.fields != null &&
            this.fields.equals(action.fields);

        boolean sameType =
            this.type == null && action.type == null ||
            this.type != null && action.type != null &&
            this.type.equals(action.title);

        boolean sameKlass =
            this.klass == null && action.klass == null ||
            this.klass != null && action.klass != null &&
            this.klass.equals(action.klass);

        return sameName && sameTitle && sameMethod && sameHref &&
            sameFields && sameType && sameKlass;
    }

    /**
     * Generates hashcode represented as an integer for the calling {@link Action} instance.
     * @return The hashcode for the calling {@link Action} instance.
     */
    @Override
    public int hashCode(){

        final int PRIME = 31;
        int hashCode = 1;

        if (this.name != null) {
            hashCode *= PRIME + this.name.hashCode();
        }

        if (this.title != null) {
            hashCode *= PRIME + this.title.hashCode();
        }

        if (this.method != null) {
            hashCode *= PRIME + this.method.hashCode();
        }

        if (this.href != null) {
            hashCode *= PRIME + this.href.hashCode();
        }

        if (this.fields != null) {
            hashCode *= PRIME + this.fields.hashCode();
        }

        if (this.type != null) {
            hashCode *= PRIME + this.type.hashCode();
        }

        if (this.klass != null) {
            hashCode *= PRIME + this.klass.hashCode();
        }

        return hashCode;
    }

    /**
     * Retrieves the class for the action. The class describes the nature
     * of an action based on the current representation. Possible values
     * are implementation-dependent and should be documented.
     * @return The class of the action.
     */
    public List<String> getKlass(){
        if(this.klass == null) return this.klass;
        List<String> klassCopy = new ArrayList<String>();
        klassCopy.addAll(this.klass);
        return klassCopy;
    }

    /**
     * Retrieves the name of the action. The name identifies the action to be performed.
     * @return The name of the action.
     */
    public String getName(){
        return this.name;
    }

    /**
     * Retrieves the title of the action. The title is descriptive text about the action.
     * @return The title of the action.
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * Retrieves the method of the action. The method is an enumerated attribute
     * mapping to a protocol method.
     * @return The method of the action.
     */
    public HttpMethod getMethod(){
        return this.method;
    }

    /**
     * Retrieves the href of the action. The href is the URI of the action.
     * @return The href of the action.
     */
    public String getHref(){
        return this.href.toString();
    }

    /**
     * Retrieves the type of the action. The type is the encoding type for the request.
     * @return The type of the action.
     */
    public String getType()
    {
        return this.type;
    }

    /**
     * Retrieves the fields associated with the action.
     * @return The fields associated with the action.
     */
    public List<Field> getFields(){
        if(this.fields == null) return this.fields;
        List<Field> fieldsCopy = new ArrayList<Field>();
        fieldsCopy.addAll(this.fields);
        return fieldsCopy;
    }

}
