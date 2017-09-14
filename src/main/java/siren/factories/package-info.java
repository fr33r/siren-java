/**
 * Provides classes that are responsible for the construction of
 * other siren classes. The factories defined in this package
 * alleviate the burden of client applications needing to manage
 * the logic of creating instances of other siren classes, such as
 * {@link siren.Entity}.
 *
 * A common practical use case of these factories is dependency injection.
 * Utilizing dependency injection, client applications can control the
 * object lifecycle of instances of the factory classes, while using them to
 * generate instances of other siren classes in the class receiving the injection.
 *
 * @author jonfreer
 * @since 9/13/17
 */
package siren.factories;