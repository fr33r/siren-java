package siren;

import org.junit.Assert;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author jonfreer
 * @since 9/9/17
 */
public class RelationTester {

    @Test
    public void constructor_registeredRelationAsString_outcomeIs_instanceCreated() throws URISyntaxException {

        //arrange.
        final String edit = Relation.EDIT;

        //action.
        Relation editRelation = new Relation(edit);

        //assert.
        Assert.assertNotNull(editRelation);
    }

    @Test
    public void constructor_extensionRelationAsString_outcomeIs_instanceCreated() throws URISyntaxException {

        //arrange.
        final String foo = "http://www.linkrelations.com/foo";

        //action.
        Relation fooRelation = new Relation(foo);

        //assert.
        Assert.assertNotNull(fooRelation);
    }

    @Test
    public void constructor_extensionRelationAsURI_outcomeIs_instanceCreated() throws URISyntaxException {

        //arrange.
        final URI foo = new URI("http://www.linkrelations.com/foo");

        //action.
        Relation fooRelation = new Relation(foo);

        //assert.
        Assert.assertNotNull(fooRelation);
    }

    @Test(expected = URISyntaxException.class)
    public void constructor_invalidRelationAsString_outcomeIs_URISyntaxException() throws URISyntaxException {

        //arrange.
        final String foo = ":::";

        //action.
        new Relation(foo);
    }

    @Test
    public void isExtension_outcomeIs_isExtensionRetrieved() throws URISyntaxException {

        //arrange.
        final URI foo = new URI("http://www.linkrelations.com/foo");

        //action.
        Relation fooRelation = new Relation(foo);
        Boolean actualIsExtension = fooRelation.isExtension();

        //assert.
        Assert.assertTrue(actualIsExtension);
    }

    @Test
    public void equals_instancesAreEqual_outcomeIs_true() throws URISyntaxException {

        //arrange.
        final String rel = "testRel";

        Relation relation1 = new Relation(rel);
        Relation relation2 = new Relation(rel);

        //action.
        boolean areEqual = relation1.equals(relation2);

        //assert.
        Assert.assertTrue(areEqual);
    }

    @Test
    public void equals_instanceIsNull_outcomeIs_false() throws URISyntaxException {

        //arrange.
        final String rel = "testRel";

        Relation relation1 = new Relation(rel);
        Relation relation2 = null;

        //action.
        boolean areEqual = relation1.equals(relation2);

        //assert.
        Assert.assertFalse(areEqual);
    }

    @Test
    public void equals_mismatchingClass_outcomeIs_false() throws URISyntaxException {

        //arrange.
        final String rel = "testRel";

        Relation relation1 = new Relation(rel);

        Object relation2 = new Object();

        //action.
        boolean areEqual = relation1.equals(relation2);

        //assert.
        Assert.assertFalse(areEqual);
    }

    @Test
    public void equals_instancesAreNotEqual_outcomeIs_false() throws URISyntaxException {

        //arrange.
        final String rel = "testRel";
        final String otherRel = "otherRel";

        Relation relation1 = new Relation(rel);
        Relation relation2 = new Relation(otherRel);

        //action.
        boolean areEqual = relation1.equals(relation2);

        //assert.
        Assert.assertFalse(areEqual);
    }

    @Test
    public void hashCode_outcomeIs_hashCodeGenerated() throws URISyntaxException {

        //arrange.
        final int PRIME = 31;
        int expectedHashCode = 1;
        final String rel = "testRel";

        Relation relation = new Relation(rel);

        expectedHashCode *= PRIME + rel.hashCode();
        expectedHashCode *= PRIME + relation.isExtension().hashCode();

        //action.
        int actualHashCode = relation.hashCode();

        //assert.
        Assert.assertEquals(expectedHashCode, actualHashCode);
    }
}
