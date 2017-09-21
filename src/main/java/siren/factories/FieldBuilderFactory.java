package siren.factories;

import siren.Field;

/**
 * Constructs instances of {@link Field.Builder}.
 * @author jonfreer
 * @since 8/19/17
 */
public class FieldBuilderFactory<T> implements BuilderFactory<Field.Builder<T>> {

    /**
     * Constructs an instance of {@link FieldBuilderFactory}.
     */
    public FieldBuilderFactory() {}

    /**
     * Constructs an instance of {@link Field.Builder}.
     *
     * @return An instance of {@link Field.Builder}.
     */
    @Override
    public Field.Builder<T> create() {
        return new Field.Builder<>();
    }
}
