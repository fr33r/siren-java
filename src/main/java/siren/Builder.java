package siren;

/**
 * Defines the contract that all types choosing
 * to be a {@link Builder} must abide by.
 *
 * @author jonfreer
 * @since 8/14/17
 */
public interface Builder<T> {

    /**
     * Clears the state of the builder.
     */
    void clear();

    /**
     * Constructs an instance of {@link T} with the
     * current state of the builder.
     * @return Instance of {@link T} with the current state of the builder.
     */
    T build();
}
