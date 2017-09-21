package siren;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * Represent navigational transitions.
 * @author jonfreer
 * @since 8/13/17
 */
public class Link {

    /**
     * Constructs instances of {@link Link}.
     */
    public static class Builder implements siren.Builder<Link>{

        private List<String> klass;
        private String title;
        private String type;
        private List<Relation> rel;
        private URI href;

        /**
         * Constructs an instance of {@link Link.Builder}.
         */
        public Builder(){}

        /**
         * Adds the relation provided to the current state of the builder.
         * @param rel Defines the relationship of the link to its
         *            entity, per Web Linking (RFC5988) and Link Relations.
         * @return The builder this method is called on.
         *
         * @throws URISyntaxException Thrown if the textual representation of the relation
         * is not a registered relation, and is not a valid URI. All extension relations must
         * be in the form of a URI.
         *
         * @see <a href="http://tools.ietf.org/html/rfc5988">RFC5988</a>
         * @see <a href="http://www.iana.org/assignments/link-relations/link-relations.xhtml">
         *          Link Relations
         *      </a>
         */
        public Builder rel(String rel) throws URISyntaxException {
            if(rel == null){
                throw new IllegalArgumentException("'rel' cannot be null.");
            }
            return this.rel(new Relation(rel));
        }

        /**
         * Adds the relation provided to the current state of the builder.
         * @param rel Defines the relationship of the link to its
         *            entity, per Web Linking (RFC5988) and Link Relations.
         * @return The builder this method is called on.
         *
         * @see <a href="http://tools.ietf.org/html/rfc5988">RFC5988</a>
         * @see <a href="http://www.iana.org/assignments/link-relations/link-relations.xhtml">
         *          Link Relations
         *      </a>
         */
        public Builder rel(URI rel) {
            if(rel == null){
                throw new IllegalArgumentException("'rel' cannot be null.");
            }
            return this.rel(new Relation(rel));
        }

        /**
         * Adds the relation provided to the current state of the builder.
         * @param rel Defines the relationship of the link to its
         *            entity, per Web Linking (RFC5988) and Link Relations
         * @return The builder this method is called on.
         *
         * @see <a href="http://tools.ietf.org/html/rfc5988">RFC5988</a>
         * @see <a href="http://www.iana.org/assignments/link-relations/link-relations.xhtml">
         *          Link Relations
         *      </a>
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
         * @param rels Defines the relationships of the link to its
         *             entity, per Web Linking (RFC5988) and Link Relations.
         * @return The builder this method is called on.
         *
         * @throws URISyntaxException Thrown if the textual representation of the relation
         * is not a registered relation, and is not a valid URI. All extension relations must
         * be in the form of a URI.
         *
         * @see <a href="http://tools.ietf.org/html/rfc5988">RFC5988</a>
         * @see <a href="http://www.iana.org/assignments/link-relations/link-relations.xhtml">
         *          Link Relations
         *      </a>
         */
        public Builder rels(String... rels) throws URISyntaxException {
            for(String rel : rels){
                this.rel(rel);
            }
            return this;
        }

        /**
         * Adds the relations provided to the current state of the builder.
         * @param rels Defines the relationships of the link to its
         *             entity, per Web Linking (RFC5988) and Link Relations.
         * @return The builder this method is called on.
         *
         * @see <a href="http://tools.ietf.org/html/rfc5988">RFC5988</a>
         * @see <a href="http://www.iana.org/assignments/link-relations/link-relations.xhtml">
         *          Link Relations
         *      </a>
         */
        public Builder rels(URI... rels){
            for(URI rel : rels){
                this.rel(rel);
            }
            return this;
        }

        /**
         * Adds the relations provided to the current state of the builder.
         * @param rels Defines the relationships of the link to its
         *             entity, per Web Linking (RFC5988) and Link Relations.
         * @return The builder this method is called on.
         *
         * @see <a href="http://tools.ietf.org/html/rfc5988">RFC5988</a>
         * @see <a href="http://www.iana.org/assignments/link-relations/link-relations.xhtml">
         *          Link Relations
         *      </a>
         */
        public Builder rels(Relation... rels){
            for(Relation rel : rels) {
                this.rel(rel);
            }
            return this;
        }

        /**
         * Sets the current state of the builder to have the href provided.
         * @param href The URI of the linked resource.
         * @return The builder this method is called on.
         */
        public Builder href(URI href){
            if(href == null){
                throw new IllegalArgumentException("'href' cannot be null.");
            }
            this.href = href;
            return this;
        }

        /**
         * Adds the class provided to the current state of the builder.
         * @param klass Describes aspects of the link based on the current
         *              representation. Possible values are implementation-dependent
         *              and should be documented.
         * @return The builder this method is called on.
         */
        public Builder klass(String klass){
            if(klass == null){
                throw new IllegalArgumentException("'klass' cannot be null.");
            }
            if(this.klass == null){
                this.klass = new ArrayList<>();
            }
            this.klass.add(klass);
            return this;
        }

        /**
         * Adds the classes provided to the current state of the builder.
         * @param klasses Describes aspects of the link based on the current
         *                representation. Possible values are implementation-dependent
         *                and should be documented.
         * @return The builder this method is called on.
         */
        public Builder klasses(String... klasses){
            for(String klass : klasses){
                this.klass(klass);
            }
            return this;
        }

        /**
         * Sets current state of the builder to have the title provided.
         * @param title Text describing the nature of a link.
         * @return The builder this method is called on.
         */
        public Builder title(String title){
            this.title = title;
            return this;
        }

        /**
         * Sets the current state of the builder to have the type provided.
         * @param type Defines media type of the linked resource, per Web Linking
         *             (RFC5988). For the syntax, see RFC2045 (section 5.1),
         *             RFC4288 (section 4.2), RFC6838 (section 4.2)
         * @see <a href="http://tools.ietf.org/html/rfc5988">RFC5988</a>
         * @see <a href="http://tools.ietf.org/html/rfc2045">RFC2045</a>
         * @see <a href="http://tools.ietf.org/html/rfc4288">RFC4288</a>
         * @see <a href="http://tools.ietf.org/html/rfc6838">RFC6838</a>
         * @return The builder this method is called on.
         */
        public Builder type(String type){
            // TODO 2017-08-15 - FREER - Instead of String, utilize MediaType.
            this.type = type;
            return this;
        }

        /**
         * Clears the state of the builder.
         */
        @Override
        public void clear() {
            this.klass = null;
            this.title = null;
            this.type = null;
            this.rel = null;
            this.href = null;
        }

        /**
         * Constructs a {@link Link} instance with the current state of the builder.
         *
         * @return Instance of {@link Link} with the current state of the builder.
         */
        @Override
        public Link build() {
            return new Link(this.rel, this.href, this.title, this.type, this.klass);
        }
    }

    /**
     * Defines the relationship of the link to its entity,
     * per Web Linking (RFC5988) and Link Relations. Required.
     *
     * @see <a href="http://tools.ietf.org/html/rfc5988">RFC5988</a>
     * @see <a href="http://www.iana.org/assignments/link-relations/link-relations.xhtml">
     *          Link Relations
     *      </a>
     */
    private List<Relation> rel;

    /**
     * The URI of the linked resource. Required.
     */
    private URI href;

    /**
     * Describes aspects of the link based on the current
     * representation. Possible values are implementation-dependent
     * and should be documented.
     */
    private List<String> klass;

    /**
     * Text describing the nature of a link.
     */
    private String title;

    /**
     * Defines media type of the linked resource, per Web Linking (RFC5988).
     * For the syntax, see RFC2045 (section 5.1), RFC4288 (section 4.2),
     * RFC6838 (section 4.2)
     *
     * @see <a href="http://tools.ietf.org/html/rfc5988">RFC5988</a>
     * @see <a href="http://tools.ietf.org/html/rfc2045">RFC2045</a>
     * @see <a href="http://tools.ietf.org/html/rfc4288">RFC4288</a>
     * @see <a href="http://tools.ietf.org/html/rfc6838">RFC6838</a>
     */
    private String type;

    /**
     * Constructs an instance of {@link Link}.
     * @param rel Defines the relationship of the link to its entity,
     *            per Web Linking (RFC5988) and Link Relations.
     * @param href The URI of the linked resource.
     */
    private Link(List<Relation> rel, URI href){
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
     * Constructs an instance of {@link Link}.
     * @param rel Defines the relationship of the link to its entity,
     *            per Web Linking (RFC5988) and Link Relations.
     * @param href The URI of the linked resource.
     * @param title Text describing the nature of a link.
     * @param type The media type of the linked resource, per Web Linking (RFC5988).
     *             For the syntax, see RFC2045 (section 5.1), RFC4288 (section 4.2), RFC6838 (section 4.2).
     * @param klass List of strings describing aspects of the link based on the current representation.
     *              Possible values are implementation-dependent and should be documented.
     */
    private Link(List<Relation> rel, URI href, String title, String type, List<String> klass){
        this(rel, href);

        this.title = title;
        this.type = type;
        this.klass = klass;
    }
    /**
     * Determines if the instance of {@link Object} provided is
     * equal to the calling {@link Link} instance.
     * @param obj The instance of {@link Link} being examined.
     * @return {@code true} if the instances are equal; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj){

        if(obj == null || obj.getClass() != this.getClass()) return false;

        Link link = (Link)obj;

        boolean sameRel = this.rel.equals(link.rel);
        boolean sameHref = this.href.equals(link.href);

        boolean sameTitle =
            this.title == null && link.title == null ||
            this.title != null && link.title != null &&
            this.title.equals(link.title);

        boolean sameType =
            this.type == null && link.type == null ||
            this.type != null && link.type != null &&
            this.type.equals(link.type);

        boolean sameKlass =
            this.klass == null && link.klass == null ||
            this.klass != null && link.klass != null &&
            this.klass.equals(link.klass);

        return sameRel && sameTitle && sameHref && sameKlass && sameType;
    }

    /**
     * Generates hashcode represented as an integer for the calling {@link Link} instance.
     * @return The hashcode for the calling {@link Link} instance.
     */
    @Override
    public int hashCode(){

        final int PRIME = 31;
        int hashCode = 1;

        hashCode *= PRIME + this.rel.hashCode();
        hashCode *= PRIME + this.href.hashCode();

        if(this.title != null){
            hashCode *= PRIME + this.title.hashCode();
        }

        if(this.type != null){
            hashCode *= PRIME + this.type.hashCode();
        }

        if(this.klass != null){
            hashCode *= PRIME + this.klass.hashCode();
        }

        return hashCode;
    }


    /**
     * Retrieves the relationship of the link to its entity.
     * @return The relationship of the link to its entity,
     * per Web Linking (RFC5988) and Link Relations.
     *
     * @see <a href="http://tools.ietf.org/html/rfc5988">RFC5988</a>
     * @see <a href="http://www.iana.org/assignments/link-relations/link-relations.xhtml">
     *      Link Relations
     *     </a>
     */
    public List<Relation> getRel(){
        if(this.rel == null) return this.rel;
        List<Relation> relCopy = new ArrayList<>();
        relCopy.addAll(this.rel);
        return relCopy;
    }

    /**
     * Retrieves the class for the link.
     * @return List of strings describing aspects of the link based
     * on the current representation. Possible values are
     * implementation-dependent and should be documented.
     */
    @JsonProperty("class")
    public List<String> getKlass(){
        if(this.klass == null) return this.klass;
        List<String> classesCopy = new ArrayList<>();
        classesCopy.addAll(this.klass);
        return classesCopy;
    }

    /**
     * Retrieves the title of the link.
     * @return String describing the nature of a link.
     */
    public String getTitle(){
        return this.title;
    }

    /**
     * Retrieves the link's type.
     * @return The media type of the linked resource, per
     * Web Linking (RFC5988). For the syntax, see RFC2045 (section 5.1),
     * RFC4288 (section 4.2), RFC6838 (section 4.2).
     *
     * @see <a href="http://tools.ietf.org/html/rfc5988">RFC5988</a>
     * @see <a href="http://tools.ietf.org/html/rfc2045">RFC2045</a>
     * @see <a href="http://tools.ietf.org/html/rfc4288">RFC4288</a>
     * @see <a href="http://tools.ietf.org/html/rfc6838">RFC6838</a>
     */
    public String getType(){
        return this.type;
    }

    /**
     * Retrieves the URI of the linked resource.
     * @return The URI of the linked resource.
     */
    public URI getHref(){
        return this.href;
    }
}
