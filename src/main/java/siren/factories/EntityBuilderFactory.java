package siren.factories;

import siren.Entity;

/**
 * Constructs instances of {@link EntityBuilderFactory}.
 * @author jonfreer
 * @since 8/18/17
 */
public class EntityBuilderFactory implements BuilderFactory<Entity.Builder> {

    /**
     * Constructs an instance of {@link EntityBuilderFactory}.
     */
    public EntityBuilderFactory() {}

    /**
     * Constructs an instance of {@link EntityBuilderFactory}.
     * @return An instance of {@link EntityBuilderFactory}.
     */
    @Override
    public Entity.Builder create() {
        return new Entity.Builder();
    }
}
