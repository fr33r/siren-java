package siren;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * A sub-entity containing an href value. One difference is that a
 * sub-entity MUST contain a rel attribute to describe its relationship
 * to the parent entity.
 * @author jonfreer
 * @since 8/13/17
 */
public class EmbeddedLinkSubEntity extends EntityBase {

    /**
     * Constructs an instance of {@link EmbeddedLinkSubEntity.Builder}.
     */
    public static class Builder implements siren.Builder<EmbeddedLinkSubEntity>{

        private List<String> rel;
        private URI href;
        private String type;
        private List<String> klass;
        private String title;

        /**
         * Constructs an instance of {@link EmbeddedLinkSubEntity.Builder}.
         */
        public Builder(){}

        /**
         * Adds the class provided to the current state of the builder.
         * @param className Describes the nature of an entity's content based on the current representation.
         *                  Possible values are implementation-dependent and should be documented.
         * @return The builder this method is called on.
         */
        public Builder klass(String className){
            if(this.klass == null){
                this.klass = new ArrayList<String>();
            }
            this.klass.add(className);
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
         * Adds the type provided to the current state of the builder.
         * @param type Defines media type of the linked resource, per Web Linking (RFC5988).
         *             For the syntax, see RFC2045 (section 5.1), RFC4288 (section 4.2), RFC6838 (section 4.2).
         * @return The builder this method is called on.
         */
        public Builder type(String type){
            this.type = type;
            return this;
        }

        /**
         * Adds the href to the current state of the builder.
         * @param href The URI of the linked sub-entity.
         * @return The builder this method is called on.
         */
        public Builder href(URI href) {
            this.href = href;
            return this;
        }

        /**
         * Clears the state of the builder.
         */
        @Override
        public void clear() {
            this.type = null;
            this.href = null;
            this.rel = null;
            this.klass = null;
            this.title = null;
        }

        /**
         * Constructs an instance of {@link EmbeddedLinkSubEntity} with the
         * current state of the builder.
         *
         * @return Instance of {@link EmbeddedLinkSubEntity} with the current state of the builder.
         */
        @Override
        public EmbeddedLinkSubEntity build() {
            // TODO 2017-08-15 - FREER - Do some checking that required state has been set.
            return new EmbeddedLinkSubEntity(this.klass, this.title, this.rel, this.href, this.type);
        }
    }

    /**
     *  Defines the relationship of the sub-entity to its parent, per Web Linking (RFC5899).
     */
    private List<String> rel;

    /**
     * The URI of the linked sub-entity.
     */
    private URI href;

    /**
     *  Defines media type of the linked resource, per Web Linking (RFC5988).
     *  For the syntax, see RFC2045 (section 5.1), RFC4288 (section 4.2), RFC6838 (section 4.2).
     */
    private String type;

    /**
     * Constructs an instance of {@link EmbeddedLinkSubEntity}.
     * @param klass Describes the nature of an entity's content based on the current
     *              representation. Possible values are implementation-dependent and should be documented.
     * @param title Descriptive text about the entity.
     * @param rel Defines the relationship of the sub-entity to its parent, per Web Linking (RFC5899).
     * @param href The URI of the linked sub-entity.
     */
    private EmbeddedLinkSubEntity(List<String> klass, String title, List<String> rel, URI href){
        super(klass, title);

        if(rel == null){
            throw new IllegalArgumentException("'rel' cannot be null as it is required.");
        }

        if(href == null){
            throw new IllegalArgumentException("'href' cannot be null as it is required.");
        }
        this.rel = rel;
        this.href = href;
    }

    /**
     * Constructs an instance of {@link EmbeddedLinkSubEntity}.
     * @param klass Describes the nature of an entity's content based on the current
     *              representation. Possible values are implementation-dependent and should be documented.
     * @param title Descriptive text about the entity.
     * @param rel Defines the relationship of the sub-entity to its parent, per Web Linking (RFC5899).
     * @param href The URI of the linked sub-entity.
     * @param type Defines the relationship of the sub-entity to its parent, per Web Linking (RFC5899).
     */
    private EmbeddedLinkSubEntity(List<String> klass, String title, List<String> rel, URI href, String type){
        this(klass, title, rel, href);

        this.type = type;
    }

    /**
     * Determines if the instance of {@link Object} provided is
     * equal to the calling {@link EmbeddedLinkSubEntity} instance.
     * @param obj The instance of {@link Object} being examined.
     * @return {@code true} if the instances are equal; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj){
        if(obj == null || this.getClass() != obj.getClass()) return false;

        EmbeddedLinkSubEntity embeddedLinkSubEntity =
                (EmbeddedLinkSubEntity) obj;

        boolean superIsEqual = super.equals(embeddedLinkSubEntity);
        boolean relIsEqual =
                this.rel == null && embeddedLinkSubEntity.rel == null ||
                this.rel != null && embeddedLinkSubEntity.rel != null &&
                this.rel.equals(embeddedLinkSubEntity.rel);
        boolean hrefIsEqual =
                this.href == null && embeddedLinkSubEntity.href == null ||
                this.href != null && embeddedLinkSubEntity.href != null &&
                this.href.equals(embeddedLinkSubEntity.href);
        boolean typeIsEqual =
                this.type == null && embeddedLinkSubEntity.type == null ||
                this.type != null && embeddedLinkSubEntity.type != null &&
                this.type.equals(embeddedLinkSubEntity.type);

        return superIsEqual && relIsEqual && hrefIsEqual && typeIsEqual;
    }

    /**
     * Generates hashcode represented as an integer for the calling {@link EmbeddedRepresentationSubEntity} instance.
     * @return The hashcode for the calling {@link EmbeddedLinkSubEntity} instance.
     */
    @Override
    public int hashCode(){
        final int PRIME = 31;
        int hashCode = super.hashCode();

        if(this.rel != null){
            hashCode *= PRIME + this.rel.hashCode();
        }

        if(this.href != null){
            hashCode *= PRIME + this.href.hashCode();
        }

        if(this.type != null){
            hashCode *= PRIME + this.type.hashCode();
        }

        return hashCode;
    }

    /**
     * Retrieves the relationship of the sub-entity to its parent, per Web Linking (RFC5899).
     * @return The relationship of the sub-entity to its parent.
     *
     * @see <a href="http://tools.ietf.org/html/rfc5899">RFC5899</a>
     */
    public List<String> getRel(){
        if(this.rel == null) return this.rel;
        List<String> relCopy = new ArrayList<String>();
        relCopy.addAll(this.rel);
        return relCopy;
    }

    /**
     * Retrieves the URI of the linked sub-entity.
     * @return The URI of the linked sub-entity.
     */
    public URI getHref(){
        return this.href;
    }

    /**
     * Retrieves the media type of the linked resource, per Web Linking (RFC5988).
     * For the syntax, see RFC2045 (section 5.1), RFC4288 (section 4.2), RFC6838 (section 4.2)
     * @return The media type of the linked resource.
     */
    public String getType(){
        return this.type;
    }
}
