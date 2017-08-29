package siren;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * An embedded entity representation that contains all the characteristics of a typical entity.
 * One difference is that a sub-entity MUST contain a rel attribute to describe its relationship to the parent entity.
 * @author jonfreer
 * @since 8/13/17
 */
public class EmbeddedRepresentationSubEntity extends Entity {

    /**
     * Constructs an instance of {@link EmbeddedRepresentationSubEntity.Builder}.
     */
    public static class Builder implements siren.Builder<EmbeddedRepresentationSubEntity>{

        private List<String> rel;
        private List<String> klass;
        private Map<String, Object> properties;
        private List<Action> actions;
        private List<Link> links;
        private List<EntityBase> subEntities;
        private String title;

        /**
         * Constructs an instance of {@link EmbeddedRepresentationSubEntity.Builder}.
         */
        public Builder(){}

        /**
         * Adds the class provided to the current state of the builder.
         * @param klass Describes the nature of an entity's content based on the current representation.
         *                  Possible values are implementation-dependent and should be documented.
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
         * Adds the relation provided to the current state of the builder.
         * @param rel The relationship of the sub-entity to its parent, per Web Linking (RFC5899).
         * @return The builder this method is called on.
         *
         * @see <a href="http://tools.ietf.org/html/rfc5899">RFC5899</a>
         */
        public Builder rel(String rel){
            if(rel == null){
                throw new IllegalArgumentException("'rel' cannot be null.");
            }
            if(this.rel == null){
                this.rel = new ArrayList<String>();
            }
            this.rel.add(rel);
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
            this.rel = null;
            this.subEntities = null;
        }

        /**
         * Constructs an instance with the
         * current state of the builder.
         *
         * @return Instance with the current state of the builder.
         */
        @Override
        public EmbeddedRepresentationSubEntity build() {
            // TODO 2017-08-15 - FREER - Do some checking that required state has been set.
            return new EmbeddedRepresentationSubEntity(
                    this.klass,
                    this.properties,
                    this.actions,
                    this.links,
                    this.title,
                    this.rel,
                    this.subEntities
            );
        }
    }

    /**
     * Defines the relationship of the sub-entity to its parent, per Web Linking (RFC5899).
     *
     * @see <a href="http://tools.ietf.org/html/rfc5988">RFC5988</a>
     */
    private List<String> rel;

    /**
     * Constructs an instance of {@link EmbeddedRepresentationSubEntity}.
     * @param klass Describes the nature of an entity's content based on the current representation.
     *                Possible values are implementation-dependent and should be documented.
     * @param properties A set of key-value pairs that describe the state of an entity.
     * @param actions A collection of actions; actions show available behaviors an entity exposes.
     * @param links A collection of items that describe navigational links, distinct from entity relationships.
     *              Link items should contain a `rel` attribute to describe the relationship and an `href` attribute
     *              to point to the target URI. Entities should include a link `rel` to `self`.
     * @param title Descriptive text about the entity.
     * @param rel Defines the relationship of the sub-entity to its parent, per Web Linking (RFC5899).
     * @param subEntities A collection of embedded link entities or embedded representation entities.
     *
     * @see <a href="http://tools.ietf.org/html/rfc5899">RFC5899</a>
     */
    private EmbeddedRepresentationSubEntity(
            List<String> klass,
            Map<String, Object> properties,
            List<Action> actions,
            List<Link> links,
            String title,
            List<String> rel,
            List<EntityBase> subEntities
    ){
        super(klass, properties, actions, links, title, subEntities);

        if(rel == null){
            throw new IllegalArgumentException("'rel' cannot be null as it is required.");
        }
        this.rel = rel;
    }

    /**
     * Determines if the instance of {@link Object} provided is
     * equal to the calling {@link EmbeddedRepresentationSubEntity} instance.
     * @param obj The instance of {@link Object} being examined.
     * @return {@code true} if the instances are equal; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj){
        if(obj == null || this.getClass() != obj.getClass()) return false;

        EmbeddedRepresentationSubEntity embeddedRepSubEntity =
                (EmbeddedRepresentationSubEntity)obj;

        boolean superIsEqual = super.equals(embeddedRepSubEntity);
        boolean relIsEqual =
                this.rel == null && embeddedRepSubEntity == null ||
                this.rel != null && embeddedRepSubEntity != null &&
                this.rel.equals(embeddedRepSubEntity.rel);

        return superIsEqual && relIsEqual;
    }

    /**
     * Generates hashcode represented as an integer for the calling {@link EmbeddedRepresentationSubEntity} instance.
     * @return The hashcode for the calling {@link EmbeddedRepresentationSubEntity} instance.
     */
    @Override
    public int hashCode(){
        final int prime = 31;
        int hashCode = super.hashCode();

        if(this.rel != null){
            hashCode *= prime + this.rel.hashCode();
        }

        return hashCode;
    }

    /**
     * Retrieves the relationship of the sub-entity to its parent, per Web Linking (RFC5899).
     * @return String representing the relationship of the sub-entity to its parent, per Web Linking (RFC5899).
     *
     * @see <a href="http://tools.ietf.org/html/rfc5899">RFC5899</a>
     */
    public List<String> getRel(){
        if(this.rel == null) return this.rel;
        List<String> relCopy = new ArrayList<String>();
        relCopy.addAll(this.rel);
        return relCopy;
    }
}
