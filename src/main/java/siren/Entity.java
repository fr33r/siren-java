package siren;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An Entity is a URI-addressable resource that has properties and actions associated with it.
 * It may contain sub-entities and navigational links.
 * @author jonfreer
 * @since 8/13/17
 */
public class Entity extends EntityBase{

    /**
     * Constructs instances of {@link Entity}.
     */
    public static class Builder implements siren.Builder<Entity>{

        private List<String> klass;
        private Map<String, Object> properties;
        private List<Action> actions;
        private List<Link> links;
        private List<EntityBase> subEntities;
        private String title;

        /**
         * Adds the class provided to the current state of the builder.
         * @param klass Describes the nature of an entity's content based on the current representation.
         *              Possible values are implementation-dependent and should be documented.
         * @return The builder this method is called on.
         */
        public Builder klass(String klass){
            if(klass == null){
                throw new IllegalArgumentException("'klass' cannot be null.");
            }
            if(this.klass == null) {
                this.klass = new ArrayList<String>();
            }
            this.klass.add(klass);
            return this;
        }

        /**
         * Adds the property provided to the current state of the builder.
         * @param propertyKey The key portion of a key-value pair that describes the state of an entity.
         * @param propertyValue The value portion of a key-value pair that describes the state of an entity.
         * @param <T> The type of the value portion of a key-value pair that describes the state of an entity.
         * @return The builder this method is called on.
         */
        public <T> Builder property(String propertyKey, T propertyValue){
            if(propertyKey == null){
                throw new IllegalArgumentException("'propertyKey' cannot be null.");
            }
            if(this.properties == null){
                this.properties = new HashMap<String, Object>();
            }
            this.properties.put(propertyKey, propertyValue);
            return this;
        }

        /**
         * Adds the action provided to the current state of the builder.
         * @param action An action showing an available behavior an entity exposes.
         * @return The builder this method is called on.
         */
        public Builder action(Action action){
            if(action == null){
                throw new IllegalArgumentException("'action' cannot be null.");
            }
            if(this.actions == null){
                this.actions = new ArrayList<Action>();
            }
            this.actions.add(action);
            return this;
        }

        /**
         * Adds the link provided to the current state of the builder.
         * @param link A navigational link, distinct from an entity relationship.
         *             Link items should contain a `rel` attribute to describe the relationship
         *             and an `href` attribute to point to the target URI.
         *             Entities should include a link `rel` to `self`.
         * @return The builder this method is called on.
         */
        public Builder link(Link link){
            if(link == null){
                throw new IllegalArgumentException("'link' cannot be null.");
            }
            if(this.links == null){
                this.links = new ArrayList<Link>();
            }
            this.links.add(link);
            return this;
        }

        /**
         * Adds the sub-entity provided to the current state of the builder.
         * @param subEntity A sub-entity represented as an embedded link or an embedded entity representation.
         * @return The builder this method is called on.
         */
        public Builder subEntity(EntityBase subEntity){
            if(subEntity == null){
                throw new IllegalArgumentException("'subEntity' cannot be null.");
            }
            if(this.subEntities == null){
                this.subEntities = new ArrayList<>();
            }
            this.subEntities.add(subEntity);
            return this;
        }

        /**
         * Adds the title provided to the current state of the builder.
         * @param title Descriptive text about the entity.
         * @return The builder this method is called on.
         */
        public Builder title(String title){
            this.title = title;
            return this;
        }

        /**
         * Clears the state of the builder.
         */
        @Override
        public void clear() {
            this.klass = null;
            this.properties = null;
            this.actions = null;
            this.links = null;
            this.title = null;
            this.subEntities = null;
        }

        /**
         * Constructs an instance with the
         * current state of the builder.
         *
         * @return Instance with the current state of the builder.
         */
        @Override
        public Entity build() {
            return new Entity(this.klass, this.properties, this.actions, this.links, this.title, this.subEntities);
        }
    }

    /**
     * A set of key-value pairs that describe the state of the entity.
     */
    private Map<String, Object> properties;

    /**
     * A list of actions that show available behaviors the entity exposes.
     */
    private List<Action> actions;

    /**
     * A list of items that describe navigational links, distinct from entity relationships.
     */
    private List<Link> links;

    /**
     * A list of related sub-entities.
     */
    private List<EntityBase> subEntities;

    /**
     * Constructs an instance of {@link Entity}.
     */
    Entity(){
        super();
    }

    /**
     * Constructs an instance of {@link Entity}.
     * @param klass Describes the nature of an entity's content based on the current representation.
     *              Possible values are implementation-dependent and should be documented.
     * @param properties A set of key-value pairs that describe the state of an entity.
     * @param actions A collection of actions; actions show available behaviors an entity exposes.
     * @param links A collection of items that describe navigational links, distinct from entity relationships.
     *              Link items should contain a `rel` attribute to describe the relationship and an `href` attribute
     *              to point to the target URI. Entities should include a link `rel` to `self`.
     * @param title Descriptive text about the entity.
     * @param subEntities A collection of embedded link entities or embedded representation entities.
     *
     * @see <a href="http://tools.ietf.org/html/rfc5899">RFC5899</a>
     */
    Entity(
        List<String> klass,
        Map<String, Object> properties,
        List<Action> actions,
        List<Link> links,
        String title,
        List<EntityBase> subEntities
    ){
        super(klass, title);
        this.properties = properties;
        this.actions = actions;
        this.links = links;
        this.subEntities = subEntities;
    }

    /**
     * Retrieves the properties.
     * @return The map of the properties.
     */
    public Map<String, Object> getProperties(){
        if(this.properties == null) return this.properties;
        Map<String, Object> propertiesCopy = new HashMap<String, Object>();
        propertiesCopy.putAll(this.properties);
        return propertiesCopy;
    }

    /**
     * Retrieves the actions.
     * @return The list of the actions.
     */
    public List<Action> getActions(){
        if(this.actions == null) return this.actions;
        List<Action> actionsCopy = new ArrayList<Action>();
        actionsCopy.addAll(this.actions);
        return actionsCopy;
    }

    /**
     * Retrieves the links.
     * @return The list of links.
     */
    public List<Link> getLinks(){
        if(this.links == null) return this.links;
        List<Link> linksCopy = new ArrayList<Link>();
        linksCopy.addAll(this.links);
        return linksCopy;
    }

    /**
     * Retrieves the sub-entities.
     * @return The list of the sub-entities.
     */
    public List<EntityBase> getEntities(){
        if(this.subEntities == null) return this.subEntities;
        List<EntityBase> subEntitiesCopy = new ArrayList<EntityBase>();
        subEntitiesCopy.addAll(this.subEntities);
        return subEntitiesCopy;
    }

    /**
     * Determines if the instance of {@link Object} provided is
     * equal to the calling {@link Entity} instance.
     * @param obj The instance of {@link Object} being examined.
     * @return {@code true} if the instances are equal; {@code false} otherwise.
     */
    public boolean equals(Object obj){
        if(obj == null || this.getClass() != obj.getClass()) return false;

        Entity entity = (Entity)obj;

        boolean superIsEqual = super.equals(entity);
        boolean sameProperties =
                this.properties == null && entity.properties == null ||
                this.properties != null && entity.properties != null &&
                entity.properties.equals(entity.properties);
        boolean sameActions =
                this.actions == null && entity.actions == null ||
                this.actions != null && entity.actions != null &&
                this.actions.equals(entity.actions);
        boolean sameLinks =
                this.links == null && entity.links == null ||
                this.links != null && entity.links != null &&
                this.links.equals(entity.links);
        boolean sameSubEntities =
                this.subEntities == null && entity.subEntities == null ||
                this.subEntities != null && entity.subEntities != null &&
                this.subEntities.equals(entity.subEntities);

        return superIsEqual && sameProperties && sameActions && sameLinks && sameSubEntities;
    }

    /**
     * Generates hashcode represented as an integer for the calling {@link Entity} instance.
     * @return The hashcode for the calling {@link Entity} instance.
     */
    public int hashCode(){

        final int prime = 31;
        int hashCode = 1;

        hashCode = super.hashCode();

        if(this.properties != null){
            hashCode *= prime + this.properties.hashCode();
        }

        if(this.actions != null){
            hashCode *= prime + this.actions.hashCode();
        }

        if(this.links != null){
            hashCode *= prime + this.links.hashCode();
        }

        return hashCode;
    }
}
