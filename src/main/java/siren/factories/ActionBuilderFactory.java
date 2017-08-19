package siren.factories;

import siren.Action;

/**
 * Constructs instances of {@link Action.Builder}.
 * @author jonfreer
 * @since 8/19/17
 */
public class ActionBuilderFactory implements BuilderFactory<Action.Builder> {

    /**
     * Constructs an instance {@link ActionBuilderFactory}.
     */
    public ActionBuilderFactory() {}

    /**
     * Constructs an instance of {@link Action.Builder}.
     * @return An instance of {@link Action.Builder}.
     */
    @Override
    public Action.Builder create() {
        return new Action.Builder();
    }
}
