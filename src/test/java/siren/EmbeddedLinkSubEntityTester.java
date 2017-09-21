package siren;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jonfreer
 * @since 8/28/17
 */
public class EmbeddedLinkSubEntityTester {

    private EmbeddedLinkSubEntity.Builder embeddedLinkSubEntityBuilder;

    public EmbeddedLinkSubEntityTester(){}

    @Before
    public void setup(){
        this.embeddedLinkSubEntityBuilder = new EmbeddedLinkSubEntity.Builder();
    }

    @Test(expected = IllegalArgumentException.class)
    public void rel_nullRelAsString_outcomeIs_IllegalArgumentException() throws URISyntaxException {

        //arrange.
        final String rel = null;

        //action.
        this.embeddedLinkSubEntityBuilder.rel(rel).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void rel_nullRelAsURI_outcomeIs_IllegalArgumentException() throws URISyntaxException {

        //arrange.
        final URI rel = null;

        //action.
        this.embeddedLinkSubEntityBuilder.rel(rel).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void rel_nullRelAsRelation_outcomeIs_IllegalArgumentException() throws URISyntaxException {

        //arrange.
        final Relation rel = null;

        //action.
        this.embeddedLinkSubEntityBuilder.rel(rel).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void href_nullHref_outcomeIs_IllegalArgumentException() throws URISyntaxException {

        //arrange.
        final String rel = "testRel";
        final URI href = null;

        //action.
        this.embeddedLinkSubEntityBuilder.rel(rel).href(href).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void klass_nullKlass_outcomeIs_IllegalArgumentException() throws URISyntaxException {

        //arrange.
        final String klass = null;

        //action.
        this.embeddedLinkSubEntityBuilder.klass(klass);
    }

    @Test
    public void getHref_outcomeIs_HrefRetrieved() throws URISyntaxException {

        //arrange.
        final URI href = new URI("https://www.example.com/");
        final String rel = "testRel";

        //action.
        EmbeddedLinkSubEntity actualEntity =
            this.embeddedLinkSubEntityBuilder
                .rel(rel)
                .href(href)
                .build();

        //assert.
        Assert.assertEquals(href, actualEntity.getHref());
    }

    @Test
    public void getRel_outcomeIs_RelRetrieved() throws URISyntaxException {

        //arrange.
        final URI href = new URI("https://www.example.com/");
        final URI rel1 = new URI("https://www.examples.com/relation");
        final URI rel2 = new URI("https://www.examples.com/anotherRelation");
        final List<Relation> rels = new ArrayList<>();
        rels.add(new Relation(rel1));
        rels.add(new Relation(rel2));

        //action.
        EmbeddedLinkSubEntity actualEntity =
            this.embeddedLinkSubEntityBuilder
                .rels(rel1, rel2)
                .href(href)
                .build();

        //assert.
        Assert.assertEquals(rels, actualEntity.getRel());
    }

    @Test
    public void getType_outcomeIs_TypeRetrieved() throws URISyntaxException {

        //arrange.
        final URI href = new URI("https://www.example.com/");
        final String rel = "testRel";
        final String type = "testType";

        //action.
        EmbeddedLinkSubEntity actualEntity =
            this.embeddedLinkSubEntityBuilder
                .type(type)
                .rel(rel)
                .href(href)
                .build();

        //assert.
        Assert.assertEquals(type, actualEntity.getType());
    }

    @Test
    public void equals_instancesAreEqual_outcomeIs_true() throws URISyntaxException {

        //arrange.
        final URI href = new URI("https://www.example.com/");
        final String rel = "testRel";
        final String anotherRel = "anotherRel";
        final Relation relation = new Relation(rel);
        final Relation anotherRelation = new Relation(anotherRel);
        final String type = "testType";
        final String klass = "testClass";
        final String anotherKlass = "anotherClass";
        final String title = "testTitle";

        EmbeddedLinkSubEntity entity1 =
            this.embeddedLinkSubEntityBuilder
                .klasses(klass, anotherKlass)
                .title(title)
                .href(href)
                .rels(rel, anotherRel)
                .type(type)
                .build();

        this.embeddedLinkSubEntityBuilder.clear();

        EmbeddedLinkSubEntity entity2 =
            this.embeddedLinkSubEntityBuilder
                .klasses(klass, anotherKlass)
                .title(title)
                .href(href)
                .rels(relation, anotherRelation)
                .type(type)
                .build();

        //action.
        boolean areEqual = entity1.equals(entity2);

        //assert.
        Assert.assertTrue(areEqual);
    }

    @Test
    public void equals_instanceIsNull_outcomeIs_false() throws URISyntaxException {

        //arrange.
        final URI href = new URI("https://www.example.com/");
        final String rel = "testRel";

        EmbeddedLinkSubEntity entity1 = this.embeddedLinkSubEntityBuilder
            .klass("testClass")
            .title("testTitle")
            .href(href)
            .rel(rel)
            .build();

        this.embeddedLinkSubEntityBuilder.clear();

        EmbeddedLinkSubEntity entity2 = null;

        //action.
        boolean areEqual = entity1.equals(entity2);

        //assert.
        Assert.assertFalse(areEqual);
    }

    @Test
    public void equals_mismatchingClass_outcomeIs_false() throws URISyntaxException {

        //arrange.
        final URI href = new URI("https://www.example.com/");
        final String rel = "testRel";

        EmbeddedLinkSubEntity entity1 = this.embeddedLinkSubEntityBuilder
            .klass("testClass")
            .title("testTitle")
            .href(href)
            .rel(rel)
            .build();

        this.embeddedLinkSubEntityBuilder.clear();

        Object entity2 = new Object();

        //action.
        boolean areEqual = entity1.equals(entity2);

        //assert.
        Assert.assertFalse(areEqual);
    }

    @Test
    public void equals_instancesAreNotEqual_outcomeIs_false() throws URISyntaxException {

        //arrange.
        final URI href = new URI("https://www.example.com/");
        final String rel = "testRel";

        EmbeddedLinkSubEntity entity1 = this.embeddedLinkSubEntityBuilder
            .klass("testClass")
            .title("testTitle")
            .href(href)
            .rel(rel)
            .build();

        this.embeddedLinkSubEntityBuilder.clear();

        EmbeddedLinkSubEntity entity2 = this.embeddedLinkSubEntityBuilder
            .klass("testClassThatIsDifferent") //different class.
            .title("testTitle")
            .href(href)
            .rel(rel)
            .build();

        //action.
        boolean areEqual = entity1.equals(entity2);

        //assert.
        Assert.assertFalse(areEqual);
    }

    @Test
    public void hashCode_outcomeIs_hashCodeGenerated() throws URISyntaxException {

        //arrange.
        final int PRIME = 31;
        int expectedHashCode = 1;
        final URI href = new URI("https://www.example.com/");
        final String rel = "testRel";
        final String type = "testType";

        EmbeddedLinkSubEntity entity =
            this.embeddedLinkSubEntityBuilder
                .klass("testClass")
                .title("testTitle")
                .href(href)
                .rel(rel)
                .type(type)
                .build();

        expectedHashCode *= PRIME + entity.getTitle().hashCode();
        expectedHashCode *= PRIME + entity.getKlass().hashCode();
        expectedHashCode *= PRIME + entity.getRel().hashCode();
        expectedHashCode *= PRIME + entity.getHref().hashCode();
        expectedHashCode *= PRIME + entity.getType().hashCode();

        //action.
        int actualHashCode = entity.hashCode();

        //assert.
        Assert.assertEquals(expectedHashCode, actualHashCode);
    }

    @After
    public void tearDown(){
        this.embeddedLinkSubEntityBuilder = null;
    }
}
