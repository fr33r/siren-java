package siren.factories;

import siren.Builder;

/**
 * Defines the contract that all types choosing
 * to be a {@link BuilderFactory} must abide by.
 * @author jonfreer
 * @since 8/18/17
 */
public interface BuilderFactory<T extends Builder> {

    /**
     * Constructs an instance of {@link T}.
     * @return An instance of {@link T}.
     */
    T create();
}
