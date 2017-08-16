package siren;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * Represent navigational transitions.
 * @author jonfreer
 * @since 8/13/17
 */
public class Link {

    /**
     * A builder for Link instances.
     */
    public static class Builder implements siren.Builder<Link>{

        private List<String> classes;
        private String title;
        private String type;
        private List<String> rel;
        private URI href;

        /**
         * Constructs an instance of {@link Link.Builder}.
         */
        public Builder(){}

        /**
         * Adds the relation provided to the current state of the builder.
         * @param rel Defines the relationship of the link to its
         *            entity, per Web Linking (RFC5988) and Link Relations.
         * @see <a href="http://tools.ietf.org/html/rfc5988">RFC5988</a>
         * @see <a href="http://www.iana.org/assignments/link-relations/link-relations.xhtml">
         *      Link Relations
         *     </a>
         * @return The builder this method is called on.
         */
        public Builder rel(String rel){
            if(this.rel == null){
                this.rel = new ArrayList<String>();
            }
            this.rel.add(rel);
            return this;
        }

        /**
         * Sets the current state of the builder to have the href provided.
         * @param href The URI of the linked resource.
         * @return The builder this method is called on.
         */
        public Builder href(URI href){
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
            if(this.classes == null){
                this.classes = new ArrayList<String>();
            }
            this.classes.add(klass);
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
            this.classes = null;
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
            // TODO 2017-08-15 - FREER - Do some checking that required state has been set.
            return new Link(this.rel, this.href);
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
    private List<String> rel;

    /**
     * The URI of the linked resource. Required.
     */
    private String href;

    /**
     * Describes aspects of the link based on the current
     * representation. Possible values are implementation-dependent
     * and should be documented.
     */
    private List<String> classes;

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
     * Constructs a link.
     * @param rel Defines the relationship of the link to its entity,
     *            per Web Linking (RFC5988) and Link Relations.
     * @param href The URI of the linked resource.
     */
    private Link(List<String> rel, URI href){
        if(rel == null){
            throw new IllegalArgumentException("'rel' cannot be null as it is required.");
        }

        if(href == null){
            throw new IllegalArgumentException("'href' cannot be null as it is required.");
        }
        this.rel = rel;
        this.href = href.toString();
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
    public List<String> getRel(){
        List<String> relCopy = new ArrayList<String>();
        relCopy.addAll(this.rel);
        return relCopy;
    }

    /**
     * Retrieves the class for the link.
     * @return List of strings describing aspects of the link based
     * on the current representation. Possible values are
     * implementation-dependent and should be documented.
     */
    public List<String> getClasses(){
        List<String> classesCopy = new ArrayList<String>();
        classesCopy.addAll(this.classes);
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
    public String getHref(){
        return this.href;
    }
}
