package siren.factories;

import siren.EmbeddedRepresentationSubEntity;

/**
 * Constructs instances of {@link EmbeddedRepresentationSubEntity.Builder}.
 * @author jonfreer
 * @since 8/19/17
 */
public class EmbeddedRepresentationSubEntityBuilderFactory
        implements BuilderFactory<EmbeddedRepresentationSubEntity.Builder> {

    /**
     * Constructs an instance of {@link EmbeddedRepresentationSubEntityBuilderFactory}.
     */
    public EmbeddedRepresentationSubEntityBuilderFactory() {}

    /**
     * Constructs an instance of {@link EmbeddedRepresentationSubEntity.Builder}.
     * @return
     */
    @Override
    public EmbeddedRepresentationSubEntity.Builder create() {
        return new EmbeddedRepresentationSubEntity.Builder();
    }
}
