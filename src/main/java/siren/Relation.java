package siren;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import siren.serializers.RelationSerializer;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jonfreer
 * @since 8/13/17
 */
@JsonSerialize(using = RelationSerializer.class)
public class Relation {

    /**
     * Refers to a resource that is the subject of the link's context.
     *
     * @see <a href="https://tools.ietf.org/html/rfc6903#section-2">RFC6903 Section 2</a>
     */
    public static final String ABOUT = "about";

    /**
     * Refers to a substitute for this context.
     *
     * @see <a href="http://www.w3.org/TR/html5/links.html#link-type-alternate">
     *          http://www.w3.org/TR/html5/links.html#link-type-alternate
     *      </a>
     */
    public static final String ALTERNATE = "alternate";

    /**
     * Refers to an appendix.
     *
     * @see <a href="http://www.w3.org/TR/1999/REC-html401-19991224">
     *          http://www.w3.org/TR/1999/REC-html401-19991224
     *      </a>
     */
    public static final String APPENDIX = "appendix";

    /**
     * Refers to a collection of records, documents, or other materials of historical interest.
     *
     * @see <a href="http://www.w3.org/TR/2011/WD-html5-20110113/links.html#rel-archives">
     *          http://www.w3.org/TR/2011/WD-html5-20110113/links.html#rel-archives
     *      </a>
     */
    public static final String ARCHIVES = "archives";

    /**
     * Refers to the context's author.
     *
     * @see <a href="http://www.w3.org/TR/html5/links.html#link-type-author">
     *          http://www.w3.org/TR/html5/links.html#link-type-author
     *      </a>
     */
    public static final String AUTHOR = "author";

    /**
     * Identifies the entity that blocks access to a resource following receipt of a legal demand.
     *
     * @see <a href="http://www.iana.org/go/rfc7725">RFC7725</a>
     */
    public static final String BLOCKED_BY = "blocked-by";

    /**
     * Gives a permanent link to use for bookmarking purposes.
     *
     * @see <a href="http://www.w3.org/TR/html5/links.html#link-type-bookmark">
     *          http://www.w3.org/TR/html5/links.html#link-type-bookmark
     *      </a>
     */
    public static final String BOOKMARK = "bookmark";

    /**
     * Designates the preferred version of a resource (the IRI and its contents).
     *
     * @see <a href="http://www.iana.org/go/rfc6596">RFC6596</a>
     */
    public static final String CANONICAL = "canonical";

    /**
     * Refers to a chapter in a collection of resources.
     *
     * @see <a href="http://www.w3.org/TR/1999/REC-html401-19991224">
     *          http://www.w3.org/TR/1999/REC-html401-19991224
     *      </a>
     */
    public static final String CHAPTER = "chapter";

    /**
     * The target IRI points to a resource which represents the collection resource for the context IRI.
     *
     * @see <a href="http://www.iana.org/go/rfc6573">RFC6573</a>
     */
    public static final String COLLECTION = "collection";

    /**
     * Refers to a table of contents.
     *
     * @see <a href="http://www.w3.org/TR/1999/REC-html401-19991224">
     *          http://www.w3.org/TR/1999/REC-html401-19991224
     *      </a>
     */
    public static final String CONTENTS = "contents";

    /**
     * The document linked to was later converted to the document that contains this link relation.
     * For example, an RFC can have a link to the Internet-Draft that became the RFC; in that case,
     * the link relation would be "convertedFrom".
     *
     * @see <a href="http://www.iana.org/go/rfc7991">RFC7991</a>
     */
    public static final String CONVERTED_FROM = "convertedFrom";

    /**
     * Refers to a copyright statement that applies to the link's context.
     *
     * @see <a href="http://www.w3.org/TR/1999/REC-html401-19991224">
     *          http://www.w3.org/TR/1999/REC-html401-19991224
     *      </a>
     */
    public static final String COPYRIGHT = "copyright";

    /**
     * The target IRI points to a resource where a submission form can be obtained.
     *
     * @see <a href="http://www.iana.org/go/rfc6861">RFC6861</a>
     */
    public static final String CREATE_FORM = "create-form";

    /**
     * Refers to a resource containing the most recent item(s) in a collection of resources.
     *
     * @see <a href="http://www.iana.org/go/rfc5005">RFC5005</a>
     */
    public static final String CURRENT = "current";

    /**
     * Refers to a resource providing information about the link's context.
     *
     * @see <a href="http://www.w3.org/TR/powder-dr/#assoc-linking">
     *          http://www.w3.org/TR/powder-dr/#assoc-linking
     *      </a>
     */
    public static final String DESCRIBED_BY = "describedby";

    /**
     * The relationship A 'describes' B asserts that resource A provides a description of resource B.
     * There are no constraints on the format or representation of either A or B, neither are there
     * any further constraints on either resource.
     *
     * @see <a href="http://www.iana.org/go/rfc6892">RFC6892</a>
     */
    public static final String DESCRIBES = "describes";

    /**
     * Refers to a list of patent disclosures made with respect to material for which 'disclosure'
     * relation is specified.
     *
     * @see <a href="http://www.iana.org/go/rfc6579">RFC6579</a>
     */
    public static final String DISCLOSURE = "disclosure";

    /**
     * Used to indicate an origin that will be used to fetch required resources for the link context,
     * and that the user agent ought to resolve as early as possible.
     *
     * @see <a href="https://www.w3.org/TR/resource-hints/">
     *          https://www.w3.org/TR/resource-hints/
     *      </a>
     */
    public static final String DNS_PREFETCH = "dns-prefetch";

    /**
     * Refers to a resource whose available representations are byte-for-byte identical with the
     * corresponding representations of the context IRI.
     *
     * @see <a href="http://www.iana.org/go/rfc6249">RFC6249</a>
     */
    public static final String DUPLICATE = "duplicate";

    /**
     * Refers to a resource that can be used to edit the link's context.
     *
     * @see <a href="http://www.iana.org/go/rfc5023">RFC5023</a>
     */
    public static final String EDIT = "edit";

    /**
     * The target IRI points to a resource where a submission form for editing associated resource can be obtained.
     *
     * @see <a href="http://www.iana.org/go/rfc6861">RFC6861</a>
     */
    public static final String EDIT_FORM = "edit-form";

    /**
     * Refers to a resource that can be used to edit media associated with the link's context.
     *
     * @see <a href="http://www.iana.org/go/rfc5023">RFC5023</a>
     */
    public static final String EDIT_MEDIA = "edit-media";

    /**
     * Identifies a related resource that is potentially large and might require special handling.
     *
     * @see <a href="http://www.iana.org/go/rfc4287">RFC4287</a>
     */
    public static final String ENCLOSURE = "enclosure";

    /**
     * An IRI that refers to the furthest preceding resource in a series of resources.
     *
     * @see <a href="http://www.iana.org/go/draft-nottingham-rfc5988bis-08">
     *          http://www.iana.org/go/draft-nottingham-rfc5988bis-08
     *      </a>
     */
    public static final String FIRST = "first";

    /**
     * Refers to a glossary of terms.
     *
     * @see <a href="http://www.w3.org/TR/1999/REC-html401-19991224">
     *          http://www.w3.org/TR/1999/REC-html401-19991224
     *      </a>
     */
    public static final String GLOSSARY = "glossary";

    /**
     * Refers to context-sensitive help.
     *
     * @see <a href="http://www.w3.org/TR/html5/links.html#link-type-help">
     *          http://www.w3.org/TR/html5/links.html#link-type-help
     *      </a>
     */
    public static final String HELP = "help";

    /**
     * Refers to a resource hosted by the server indicated by the link context.
     *
     * @see <a href="http://www.iana.org/go/rfc6690">RFC6690</a>
     */
    public static final String HOSTS = "hosts";

    /**
     * Refers to a hub that enables registration for notification of updates to the context.
     *
     * @see <a href="http://pubsubhubbub.googlecode.com/">http://pubsubhubbub.googlecode.com/</a>
     */
    public static final String HUB = "hub";

    /**
     * Refers to an icon representing the link's context.
     *
     * @see <a href="http://www.w3.org/TR/html5/links.html#link-type-icon">
     *          http://www.w3.org/TR/html5/links.html#link-type-icon
     *      </a>
     */
    public static final String ICON = "icon";

    /**
     * Refers to an index.
     *
     * @see <a href="http://www.w3.org/TR/1999/REC-html401-19991224">
     *          http://www.w3.org/TR/1999/REC-html401-19991224
     *      </a>
     */
    public static final String INDEX = "index";

    /**
     * The target IRI points to a resource that is a member of the collection represented by the context IRI.
     *
     * @see <a href="http://www.iana.org/go/rfc6573">RFC6573</a>
     */
    public static final String ITEM = "item";

    /**
     * An IRI that refers to the furthest following resource in a series of resources.
     *
     * @see <a href="http://www.iana.org/go/draft-nottingham-rfc5988bis-08">
     *          http://www.iana.org/go/draft-nottingham-rfc5988bis-08
     *      </a>
     */
    public static final String LAST = "last";

    /**
     * Points to a resource containing the latest (e.g., current) version of the context.
     *
     * @see <a href="http://www.iana.org/go/rfc5829">RFC5829</a>
     */
    public static final String LATEST_VERSION = "latest-version";

    /**
     * Refers to a license associated with this context.
     *
     * @see <a href="http://www.iana.org/go/rfc4946">RFC4946</a>
     */
    public static final String LICENSE = "license";

    /**
     * Refers to further information about the link's context, expressed as a LRDD ("Link-based Resource
     * Descriptor Document") resource. See [RFC6415] for information about processing this relation type
     * in host-meta documents. When used elsewhere, it refers to additional links and other metadata.
     * Multiple instances indicate additional LRDD resources. LRDD resources MUST have an "application/xrd+xml"
     * representation, and MAY have others.
     *
     * @see <a href="http://www.iana.org/go/rfc6415">RFC6415</a>
     */
    public static final String LRDD = "lrdd";

    /**
     * The Target IRI points to a Memento, a fixed resource that will not change state anymore.
     *
     * @see <a href="http://www.iana.org/go/rfc7089">RFC7089</a>
     */
    public static final String MEMENTO = "memento";

    /**
     * Refers to a resource that can be used to monitor changes in an HTTP resource.
     *
     * @see <a href="http://www.iana.org/go/rfc5989">RFC5989</a>
     */
    public static final String MONITOR = "monitor";

    /**
     * Refers to a resource that can be used to monitor changes in a specified group of HTTP resources.
     *
     * @see <a href="http://www.iana.org/go/rfc5989">RFC5989</a>
     */
    public static final String MONITOR_GROUP = "monitor-group";

    /**
     * Indicates that the link's context is a part of a series, and that the next in the series is the link target.
     *
     * @see <a href="http://www.w3.org/TR/html5/links.html#link-type-next">
     *          http://www.w3.org/TR/html5/links.html#link-type-next
     *      </a>
     */
    public static final String NEXT = "next";

    /**
     * Refers to the immediately following archive resource.
     *
     * @see <a href="http://www.iana.org/go/rfc5005">RFC5005</a>
     */
    public static final String NEXT_ARCHIVE = "next-archive";

    /**
     * Indicates that the context’s original author or publisher does not endorse the link target.
     *
     * @see <a href="http://www.w3.org/TR/html5/links.html#link-type-nofollow">
     *          http://www.w3.org/TR/html5/links.html#link-type-nofollow
     *      </a>
     */
    public static final String NO_FOLLOW = "nofollow";

    /**
     * Indicates that no referrer information is to be leaked when following the link.
     *
     * @see <a href="http://www.w3.org/TR/html5/links.html#link-type-noreferrer">
     *          http://www.w3.org/TR/html5/links.html#link-type-noreferrer
     *      </a>
     */
    public static final String NO_REFERRER = "noreferrer";

    /**
     * The Target IRI points to an Original Resource.
     *
     * @see <a href="http://www.iana.org/go/rfc7089">RFC7089</a>
     */
    public static final String ORIGINAL = "original";

    /**
     * ndicates a resource where payment is accepted.
     *
     * @see <a href="http://www.iana.org/go/draft-nottingham-rfc5988bis-08">
     *          http://www.iana.org/go/draft-nottingham-rfc5988bis-08
     *      </a>
     */
    public static final String PAYMENT = "payment";

    /**
     * Gives the address of the pingback resource for the link context.
     *
     * @see <a href="http://www.hixie.ch/specs/pingback/pingback">
     *          http://www.hixie.ch/specs/pingback/pingback
     *      </a>
     */
    public static final String PINGBACK = "pingback";

    /**
     * Used to indicate an origin that will be used to fetch required resources for the link context.
     * Initiating an early connection, which includes the DNS lookup, TCP handshake, and optional TLS negotiation,
     * allows the user agent to mask the high latency costs of establishing a connection.
     *
     * @see <a href="https://www.w3.org/TR/resource-hints/">
     *          https://www.w3.org/TR/resource-hints/
     *      </a>
     */
    public static final String PRECONNECT = "preconnect";

    /**
     * Points to a resource containing the predecessor version in the version history.
     *
     * @see <a href="http://www.iana.org/go/rfc5829">RFC5829</a>
     */
    public static final String PREDECESSOR_VERSION = "predecessor-version";

    /**
     * The prefetch link relation type is used to identify a resource that might be required by the next navigation
     * from the link context, and that the user agent ought to fetch, such that the user agent can deliver a faster
     * response once the resource is requested in the future.
     *
     * @see <a href="http://www.w3.org/TR/resource-hints/">http://www.w3.org/TR/resource-hints/</a>
     */
    public static final String PREFETCH = "prefetch";

    /**
     * Refers to a resource that should be loaded early in the processing of the link's context,
     * without blocking rendering.
     *
     * @see <a href="http://www.w3.org/TR/preload/">http://www.w3.org/TR/preload/</a>
     */
    public static final String PRELOAD = "preload";

    /**
     * Used to identify a resource that might be required by the next navigation from the link context,
     * and that the user agent ought to fetch and execute, such that the user agent can deliver a
     * faster response once the resource is requested in the future.
     *
     * @see <a href="https://www.w3.org/TR/resource-hints/">https://www.w3.org/TR/resource-hints/</a>
     */
    public static final String PRERENDER = "prerender";

    /**
     * Indicates that the link's context is a part of a series, and that the previous in the series is the link target.
     *
     * @see <a href="http://www.w3.org/TR/html5/links.html#link-type-prev">
     *          http://www.w3.org/TR/html5/links.html#link-type-prev
     *      </a>
     */
    public static final String PREV = "prev";

    /**
     * Refers to a resource that provides a preview of the link's context.
     *
     * @see <a href="http://www.iana.org/go/rfc6903">RFC6903 Section 3</a>
     */
    public static final String PREVIEW = "preview";

    /**
     * Refers to the previous resource in an ordered series of resources. Synonym for "prev".
     *
     * @see <a href="http://www.w3.org/TR/1999/REC-html401-19991224">
     *          http://www.w3.org/TR/1999/REC-html401-19991224
     *      </a>
     */
    public static final String PREVIOUS = "previous";

    /**
     * Refers to the immediately preceding archive resource.
     *
     * @see <a href="http://www.iana.org/go/rfc5005">RFC5005</a>
     */
    public static final String PREV_ARCHIVE = "prev-archive";

    /**
     * Refers to a privacy policy associated with the link's context.
     *
     * @see <a href="http://www.iana.org/go/rfc6903">RFC6903 Section 4</a>
     */
    public static final String PRIVACY_POLICY = "privacy-policy";

    /**
     * Identifying that a resource representation conforms to a certain profile, without affecting the
     * non-profile semantics of the resource representation.
     *
     * @see <a href="http://www.iana.org/go/rfc6906">RFC6906</a>
     */
    public static final String PROFILE = "profile";

    /**
     * Identifies a related resource.
     *
     * @see <a href="http://www.iana.org/go/rfc4287">RFC4287</a>
     */
    public static final String RELATED = "related";

    /**
     * Identifies the root of RESTCONF API as configured on this HTTP server. The "restconf" relation defines
     * the root of the API defined in RFC8040. Subsequent revisions of RESTCONF will use alternate relation
     * values to support protocol versioning.
     *
     * @see <a href="http://www.iana.org/go/rfc8040">RFC8040</a>
     */
    public static final String RESTCONF = "restconf";

    /**
     * Identifies a resource that is a reply to the context of the link.
     *
     * @see <a href="http://www.iana.org/go/rfc4685">RFC4685</a>
     */
    public static final String REPLIES = "replies";

    /**
     * Refers to a resource that can be used to search through the link's context and related resources.
     *
     * @see <a href="http://www.opensearch.org/Specifications/OpenSearch/1.1">
     *          http://www.opensearch.org/Specifications/OpenSearch/1.1
     *      </a>
     */
    public static final String SEARCH = "search";

    /**
     * Refers to a section in a collection of resources.
     *
     * @see <a href="http://www.w3.org/TR/1999/REC-html401-19991224">http://www.w3.org/TR/1999/REC-html401-19991224</a>
     */
    public static final String SECTION = "section";

    /**
     * Conveys an identifier for the link's context.
     *
     * @see <a href="http://www.iana.org/go/rfc4287">RFC4287</a>
     */
    public static final String SELF = "self";

    /**
     * Indicates a URI that can be used to retrieve a service document.
     *
     * @see <a href="http://www.iana.org/go/rfc5023">RFC5023</a>
     */
    public static final String SERVICE = "service";

    /**
     * Refers to the first resource in a collection of resources.
     *
     * @see <a href="http://www.w3.org/TR/1999/REC-html401-19991224">http://www.w3.org/TR/1999/REC-html401-19991224</a>
     */
    public static final String START = "start";

    /**
     * Refers to a stylesheet.
     *
     * @see <a href="http://www.w3.org/TR/html5/links.html#link-type-stylesheet">
     *          http://www.w3.org/TR/html5/links.html#link-type-stylesheet
     *      </a>
     */
    public static final String STYLESHEET = "stylesheet";

    /**
     * Refers to a resource serving as a subsection in a collection of resources.
     *
     * @see <a href="http://www.w3.org/TR/1999/REC-html401-19991224">http://www.w3.org/TR/1999/REC-html401-19991224</a>
     */
    public static final String SUBSECTION = "subsection";

    /**
     * Points to a resource containing the successor version in the version history.
     *
     * @see <a href="http://www.iana.org/go/rfc5829">RFC5829</a>
     */
    public static final String SUCCESSOR_VERSION = "successor-version";

    /**
     * Gives a tag (identified by the given address) that applies to the current document.
     *
     * @see <a href="http://www.w3.org/TR/html5/links.html#link-type-tag">
     *          http://www.w3.org/TR/html5/links.html#link-type-tag
     *      </a>
     */
    public static final String TAG = "tag";

    /**
     * Refers to the terms of service associated with the link's context.
     *
     * @see <a href="http://www.iana.org/go/rfc6903">RFC6903 Section 5</a>
     */
    public static final String TERMS_OF_SERVICE = "terms-of-service";

    /**
     * The Target IRI points to a TimeGate for an Original Resource.
     *
     * @see <a href="http://www.iana.org/go/rfc7089">RFC7089</a>
     */
    public static final String TIME_GATE = "timegate";

    /**
     * The Target IRI points to a TimeMap for an Original Resource.
     *
     * @see <a href="http://www.iana.org/go/rfc7089">RFC7089</a>
     */
    public static final String TIME_MAP = "timemap";

    /**
     * Refers to a resource identifying the abstract semantic type of which the link's context is considered
     * to be an instance.
     *
     * @see <a href="http://www.iana.org/go/rfc6903">RFC6903 Section 6</a>
     */
    public static final String TYPE = "type";

    /**
     * Refers to a parent document in a hierarchy of documents.
     *
     * @see <a href="http://www.iana.org/go/draft-nottingham-rfc5988bis-08">
     *          http://www.iana.org/go/draft-nottingham-rfc5988bis-08
     *      </a>
     */
    public static final String UP = "up";

    /**
     * Points to a resource containing the version history for the context.
     *
     * @see <a href="http://www.iana.org/go/rfc5829">RFC5829</a>
     */
    public static final String VERSION_HISTORY = "version-history";

    /**
     * Identifies a resource that is the source of the information in the link's context.
     *
     * @see <a href="http://www.iana.org/go/rfc4287">RFC4287</a>
     */
    public static final String VIA = "via";

    /**
     * Identifies a target URI that supports the Webmention protcol. This allows clients that mention a
     * resource in some form of publishing process to contact that endpoint and inform it that this
     * resource has been mentioned.
     *
     * @see <a href="http://www.w3.org/TR/webmention/">http://www.w3.org/TR/webmention/</a>
     */
    public static final String WEB_MENTION = "webmention";

    /**
     * Points to a working copy for this resource.
     *
     * @see <a href="http://www.iana.org/go/rfc5829">RFC5829</a>
     */
    public static final String WORKING_COPY = "working-copy";

    /**
     * Points to the versioned resource from which this working copy was obtained.
     *
     * @see <a href="http://www.iana.org/go/rfc5829">RFC5829</a>
     */
    public static final String WORKING_COPY_OF = "working-copy-of";

    private String rel;
    private Boolean isExtension;

    /**
     * Constructs an instance of {@link Relation}.
     * @param rel The textual representation of the relation.
     * @throws URISyntaxException Thrown if the textual representation of the relation
     * is not a registered relation, and is not a valid URI. All extension relations must
     * be in the form of a URI.
     */
    public Relation(String rel) throws URISyntaxException {
        if(rel == null){
            throw new IllegalArgumentException("'rel' cannot be null.");
        }

        List<String> registeredRelationTypes = new ArrayList<>();
        registeredRelationTypes.add(ABOUT);
        registeredRelationTypes.add(ALTERNATE);
        registeredRelationTypes.add(APPENDIX);
        registeredRelationTypes.add(ARCHIVES);
        registeredRelationTypes.add(AUTHOR);
        registeredRelationTypes.add(BLOCKED_BY);
        registeredRelationTypes.add(BOOKMARK);
        registeredRelationTypes.add(CANONICAL);
        registeredRelationTypes.add(CHAPTER);
        registeredRelationTypes.add(COLLECTION);
        registeredRelationTypes.add(CONTENTS);
        registeredRelationTypes.add(CONVERTED_FROM);
        registeredRelationTypes.add(COPYRIGHT);
        registeredRelationTypes.add(CREATE_FORM);
        registeredRelationTypes.add(CURRENT);
        registeredRelationTypes.add(DESCRIBED_BY);
        registeredRelationTypes.add(DESCRIBES);
        registeredRelationTypes.add(DISCLOSURE);
        registeredRelationTypes.add(DNS_PREFETCH);
        registeredRelationTypes.add(DUPLICATE);
        registeredRelationTypes.add(EDIT);
        registeredRelationTypes.add(EDIT_FORM);
        registeredRelationTypes.add(EDIT_MEDIA);
        registeredRelationTypes.add(ENCLOSURE);
        registeredRelationTypes.add(FIRST);
        registeredRelationTypes.add(GLOSSARY);
        registeredRelationTypes.add(HELP);
        registeredRelationTypes.add(HOSTS);
        registeredRelationTypes.add(HUB);
        registeredRelationTypes.add(ICON);
        registeredRelationTypes.add(INDEX);
        registeredRelationTypes.add(ITEM);
        registeredRelationTypes.add(LAST);
        registeredRelationTypes.add(LATEST_VERSION);
        registeredRelationTypes.add(LICENSE);
        registeredRelationTypes.add(LRDD);
        registeredRelationTypes.add(MEMENTO);
        registeredRelationTypes.add(MONITOR);
        registeredRelationTypes.add(MONITOR_GROUP);
        registeredRelationTypes.add(NEXT);
        registeredRelationTypes.add(NEXT_ARCHIVE);
        registeredRelationTypes.add(NO_FOLLOW);
        registeredRelationTypes.add(NO_REFERRER);
        registeredRelationTypes.add(ORIGINAL);
        registeredRelationTypes.add(PAYMENT);
        registeredRelationTypes.add(PINGBACK);
        registeredRelationTypes.add(PRECONNECT);
        registeredRelationTypes.add(PREDECESSOR_VERSION);
        registeredRelationTypes.add(PREFETCH);
        registeredRelationTypes.add(PRELOAD);
        registeredRelationTypes.add(PRERENDER);
        registeredRelationTypes.add(PREV);
        registeredRelationTypes.add(PREVIEW);
        registeredRelationTypes.add(PREVIOUS);
        registeredRelationTypes.add(PREV_ARCHIVE);
        registeredRelationTypes.add(PRIVACY_POLICY);
        registeredRelationTypes.add(PROFILE);
        registeredRelationTypes.add(RELATED);
        registeredRelationTypes.add(RESTCONF);
        registeredRelationTypes.add(REPLIES);
        registeredRelationTypes.add(SEARCH);
        registeredRelationTypes.add(SECTION);
        registeredRelationTypes.add(SELF);
        registeredRelationTypes.add(SERVICE);
        registeredRelationTypes.add(START);
        registeredRelationTypes.add(STYLESHEET);
        registeredRelationTypes.add(SUBSECTION);
        registeredRelationTypes.add(SUCCESSOR_VERSION);
        registeredRelationTypes.add(TAG);
        registeredRelationTypes.add(TERMS_OF_SERVICE);
        registeredRelationTypes.add(TIME_GATE);
        registeredRelationTypes.add(TIME_MAP);
        registeredRelationTypes.add(TYPE);
        registeredRelationTypes.add(UP);
        registeredRelationTypes.add(VERSION_HISTORY);
        registeredRelationTypes.add(VIA);
        registeredRelationTypes.add(WEB_MENTION);
        registeredRelationTypes.add(WORKING_COPY);
        registeredRelationTypes.add(WORKING_COPY_OF);

        if(this.isExtension = !registeredRelationTypes.contains(rel)){
            this.rel = new URI(rel).toString();
        }else{
            this.rel = rel;
        }

    }

    /**
     * Constructs an instance of {@link Relation} that is an extension relation.
     * @param rel The URI representation of the extension relation.
     */
    public Relation(URI rel){
        if(rel == null){
            throw new IllegalArgumentException("'rel' cannot be null.");
        }

        this.isExtension = true;
        this.rel = rel.toString();
    }

    /**
     * Determines if the instance of {@link Object} provided is
     * equal to the calling {@link Relation} instance.
     * @param obj The instance of {@link Object} being examined.
     * @return {@code true} if the instances are equal; {@code false} otherwise.
     */
    @Override
    public boolean equals(Object obj){
        if (obj == null || this.getClass() != obj.getClass()) return false;

        Relation relation = (Relation)obj;
        boolean sameRel = this.rel.equals(relation.rel);
        boolean sameIsExtension = this.isExtension.equals(relation.isExtension);

        return sameIsExtension && sameRel;
    }

    /**
     * Generates hashcode represented as an integer for the calling {@link Relation} instance.
     * @return The hash code for the calling {@link Relation} instance.
     */
    @Override
    public int hashCode(){

        final int PRIME = 31;
        int hashCode = 1;

        hashCode *= PRIME + this.rel.hashCode();
        hashCode *= PRIME + this.isExtension.hashCode();

        return hashCode;
    }

    /**
     * Indicates whether the calling {@link Relation} instance is an extension relation.
     * @return {@code true} if the calling {@link Relation} instance is an extension relation;
     * {@code false} otherwise.
     */
    public Boolean isExtension(){
        return this.isExtension;
    }

    /**
     * Retrieves a textual representation of the relation.
     * @return A textual representation of the relation.
     */
    @Override
    public String toString(){
        return this.rel;
    }
}
