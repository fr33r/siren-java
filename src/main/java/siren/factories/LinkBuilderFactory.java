package siren.factories;

import siren.Link;

/**
 * Constructs instances of {@link Link.Builder}.
 * @author jonfreer
 * @since 8/19/17
 */
public class LinkBuilderFactory implements BuilderFactory<Link.Builder> {

    /**
     * Constructs an instance of {@link LinkBuilderFactory}.
     */
    public LinkBuilderFactory() {}

    /**
     * Constructs an instance of {@link LinkBuilderFactory}.
     * @return
     */
    @Override
    public Link.Builder create() {
        return new Link.Builder();
    }
}
