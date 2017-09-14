/**
 * Provides the classes that grant client applications the ability
 * to leverage the power of the siren specification.
 *
 * Each siren class instance can be built using a corresponding builder class instance.
 * The builder classes provide fine-grain control, while also exposing
 * an intuitive and terse API.
 *
 * Note that instances of the siren classes (excluding the builder classes) in this
 * package are purposefully immutable. Immutability by itself carries with it it's fair
 * share of benefits, but was further chosen to eliminate the risk of calling code
 * causing incorrect serialization or deserialization of the siren classes.
 * In other words, it was recognized that the action of serializing and deserializing
 * the instances of the siren classes shouldn't alter the state of those instances,
 * justifying immutability as a technique of ensuring this philosophy was enforced.
 *
 * @author jonfreer
 * @since 9/13/17
 */
package siren;