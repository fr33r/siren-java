package siren;

import java.net.URI;
import java.net.URISyntaxException;
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

        private List<Relation> rel;
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
         *              Possible values are implementation-dependent and should be documented.
         * @return The builder this method is called on.
         */
        public Builder klass(String klass){
            if(klass == null){
                throw new IllegalArgumentException("'klass' cannot be null.");
            }
            if(this.klass == null) {
                this.klass = new ArrayList<>();
            }
            this.klass.add(klass);
            return this;
        }

        /**
         * Adds the classes provided to the current state of the builder.
         * @param klasses Descriptions of the nature of an entity's content based on the current representation.
         *                Possible values are implementation-dependent and should be documented.
         * @return The builder this method is called on.
         */
        public Builder klasses(String... klasses){
            for(String klass : klasses){
                this.klass(klass);
            }
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
                this.properties = new HashMap<>();
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
                this.actions = new ArrayList<>();
            }
            this.actions.add(action);
            return this;
        }

        /**
         * Adds the actions provided to the current state of the builder.
         * @param actions Actions showing an available behavior an entity exposes.
         * @return The builder this method is called on.
         */
        public Builder actions(Action... actions){
            for(Action action : actions){
                this.action(action);
            }
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
                this.links = new ArrayList<>();
            }
            this.links.add(link);
            return this;
        }

        /**
         * Adds the links provided to the current state of the builder.
         * @param links Navigational links, distinct from an entity relationship.
         *              Link items should contain a `rel` attribute to describe the relationship
         *              and an `href` attribute to point to the target URI.
         *              Entities should include a link `rel` to `self`.
         * @return The builder this method is called on.
         */
        public Builder links(Link... links){
            for(Link link : links){
                this.link(link);
            }
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
         * Adds the sub-entities provided to the current state of the builder.
         * @param subEntities Sub-entities represented individually as an embedded link or
         *                    an embedded entity representation.
         * @return The builder this method is called on.
         */
        public Builder subEntities(EntityBase... subEntities){
            for(EntityBase subEntity : subEntities){
                this.subEntity(subEntity);
            }
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
         * @throws URISyntaxException Thrown if the textual representation of the relation
         * is not a registered relation, and is not a valid URI. All extension relations must
         * be in the form of a URI.
         *
         * @see <a href="http://tools.ietf.org/html/rfc5899">RFC5899</a>
         */
        public Builder rel(String rel) throws URISyntaxException {
            if(rel == null){
                throw new IllegalArgumentException("'rel' cannot be null.");
            }
            return this.rel(new Relation(rel));
        }

        /**
         * Adds the relation provided to the current state of the builder.
         * @param rel The relationship of the sub-entity to its parent, per Web Linking (RFC5899).
         * @return The builder this method is called on.
         *
         * @see <a href="http://tools.ietf.org/html/rfc5899">RFC5899</a>
         */
        public Builder rel(URI rel) {
            if(rel == null){
                throw new IllegalArgumentException("'rel' cannot be null.");
            }
            return this.rel(new Relation(rel));
        }

        /**
         * Adds the relation provided to the current state of the builder.
         * @param rel The relationship of the sub-entity to its parent, per Web Linking (RFC5899).
         * @return The builder this method is called on.
         *
         * @see <a href="http://tools.ietf.org/html/rfc5899">RFC5899</a>
         */
        public Builder rel(Relation rel) {
            if(rel == null){
                throw new IllegalArgumentException("'rel' cannot be null.");
            }
            if(this.rel == null){
                this.rel = new ArrayList<>();
            }
            this.rel.add(rel);
            return this;
        }

        /**
         * Adds the relations provided to the current state of the builder.
         * @param rels The relationships of the sub-entity to its parent, per Web Linking (RFC5899).
         * @return The builder this method is called on.
         *
         * @throws URISyntaxException Thrown if the textual representation of the relation
         * is not a registered relation, and is not a valid URI. All extension relations must
         * be in the form of a URI.
         *
         * @see <a href="http://tools.ietf.org/html/rfc5899">RFC5899</a>
         */
        public Builder rels(String... rels) throws URISyntaxException {
            for(String rel : rels){
                this.rel(rel);
            }
            return this;
        }

        /**
         * Adds the relations provided to the current state of the builder.
         * @param rels The relationships of the sub-entity to its parent, per Web Linking (RFC5899).
         * @return The builder this method is called on.
         *
         * @see <a href="http://tools.ietf.org/html/rfc5899">RFC5899</a>
         */
        public Builder rels(URI... rels){
            for(URI rel : rels){
                this.rel(rel);
            }
            return this;
        }

        /**
         * Adds the relations provided to the current state of the builder.
         * @param rels The relationships of the sub-entity to its parent, per Web Linking (RFC5899).
         * @return The builder this method is called on.
         *
         * @see <a href="http://tools.ietf.org/html/rfc5899">RFC5899</a>
         */
        public Builder rels(Relation... rels){
            for(Relation rel : rels){
                this.rel(rel);
            }
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
    private List<Relation> rel;

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
            List<Relation> rel,
            List<EntityBase> subEntities
    ){
        super(klass, properties, actions, links, title, subEntities);

        if(rel == null){
            throw new IllegalArgumentException("'rel' cannot be null as it is required.");
        }

        if(rel.size() < 1){
            throw new IllegalStateException("'rel' must contain at least one element.");
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

        boolean sameSuper = super.equals(embeddedRepSubEntity);
        boolean sameRel = rel.equals(embeddedRepSubEntity.rel);

        return sameSuper && sameRel;
    }

    /**
     * Generates hashcode represented as an integer for the calling {@link EmbeddedRepresentationSubEntity} instance.
     * @return The hashcode for the calling {@link EmbeddedRepresentationSubEntity} instance.
     */
    @Override
    public int hashCode(){
        final int PRIME = 31;
        int hashCode = super.hashCode();

        hashCode *= PRIME + this.rel.hashCode();

        return hashCode;
    }

    /**
     * Retrieves the relationship of the sub-entity to its parent, per Web Linking (RFC5899).
     * @return String representing the relationship of the sub-entity to its parent, per Web Linking (RFC5899).
     *
     * @see <a href="http://tools.ietf.org/html/rfc5899">RFC5899</a>
     */
    public List<Relation> getRel(){
        if(this.rel == null) return this.rel;
        List<Relation> relCopy = new ArrayList<>();
        relCopy.addAll(this.rel);
        return relCopy;
    }
}
