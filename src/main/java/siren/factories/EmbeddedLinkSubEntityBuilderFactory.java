package siren.factories;

import siren.EmbeddedLinkSubEntity;

/**
 * Constructs instances of {@link EmbeddedLinkSubEntity.Builder}.
 * @author jonfreer
 * @since 8/18/17
 */
public class EmbeddedLinkSubEntityBuilderFactory implements BuilderFactory<EmbeddedLinkSubEntity.Builder> {

    /**
     * Constructs an instance of {@link EmbeddedLinkSubEntityBuilderFactory}.
     */
    public EmbeddedLinkSubEntityBuilderFactory(){}

    /**
     * Constructs an instance of {@link EmbeddedLinkSubEntity.Builder}.
     * @return An instance of {@link EmbeddedLinkSubEntity.Builder}.
     */
    @Override
    public EmbeddedLinkSubEntity.Builder create() {
        return new EmbeddedLinkSubEntity.Builder();
    }
}
