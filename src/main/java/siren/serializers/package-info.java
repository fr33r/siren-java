/**
 * Provides the classes necessary for proper serialization and deserialization
 * of other siren classes in accordance to the siren specification.
 *
 * Without the existence of this package, the instances of the siren classes such
 * as {@link siren.Entity} will not serialize or deserialize in accordance to the
 * siren specification.
 *
 * These classes currently leverage Jackson for serializing and deserializing JSON.
 * Jackson was chosen due to its high adoption in the community, as well as it's
 * ability to easily customize the serialization and deserialization process.
 *
 * @author jonfreer
 * @since 9/13/17
 */
package siren.serializers;