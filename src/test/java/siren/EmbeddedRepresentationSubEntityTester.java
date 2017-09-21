package siren;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author jonfreer
 * @since 8/27/17
 */
public class EmbeddedRepresentationSubEntityTester {

    private EmbeddedRepresentationSubEntity.Builder embeddedRepSubEntityBuilder;

    public EmbeddedRepresentationSubEntityTester(){}

    @Before
    public void setup(){
        this.embeddedRepSubEntityBuilder =
            new EmbeddedRepresentationSubEntity.Builder();
    }

    @Test(expected = IllegalArgumentException.class)
    public void klass_nullKlass_outcomeIs_IllegalArgumentException() {

        //arrange.
        final String klass = null;

        //action.
        this.embeddedRepSubEntityBuilder.klass(klass);
    }

    @Test(expected = IllegalArgumentException.class)
    public void rel_nullRelAsString_outcomeIs_IllegalArgumentException() throws URISyntaxException {

        //arrange.
        final String rel = null;

        //action.
        this.embeddedRepSubEntityBuilder.rel(rel).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void rel_nullRelAsURI_outcomeIs_IllegalArgumentException() throws URISyntaxException {

        //arrange.
        final URI rel = null;

        //action.
        this.embeddedRepSubEntityBuilder.rel(rel).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void rel_nullRelAsRelation_outcomeIs_IllegalArgumentException() throws URISyntaxException {

        //arrange.
        final Relation rel = null;

        //action.
        this.embeddedRepSubEntityBuilder.rel(rel).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void property_nullPropertyKey_outcomeIs_IllegalArgumentException() {

        //arrange.
        final String propertyKey = null;
        final String propertyValue = "value";

        //action.
        this.embeddedRepSubEntityBuilder
            .property(propertyKey, propertyValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void action_nullAction_outcomeIs_IllegalArgumentException() {

        //arrange.
        final Action action = null;

        //action.
        this.embeddedRepSubEntityBuilder.action(action);
    }

    @Test(expected = IllegalArgumentException.class)
    public void link_nullLink_outcomeIs_IllegalArgumentException() {

        //arrange.
        final Link link = null;

        //action.
        this.embeddedRepSubEntityBuilder.link(link);
    }

    @Test(expected = IllegalArgumentException.class)
    public void subEntity_nullSubEntity_outcomeIs_IllegalArgumentException() {

        //arrange.
        final EmbeddedLinkSubEntity subEntity = null;

        //action.
        this.embeddedRepSubEntityBuilder.subEntity(subEntity);
    }

    @Test
    public void getProperties_outcomeIs_propertiesRetrieved() throws URISyntaxException {

        //arrange.
        final String propertyKey = "key";
        final String propertyValue = "value";
        final String rel = "testRel";

        //action.
        Entity actualEntity =
            this.embeddedRepSubEntityBuilder
                .rel(rel)
                .property(propertyKey, propertyValue)
                .build();

        //assert.
        Assert.assertEquals(propertyValue, actualEntity.getProperties().get(propertyKey));
    }

    @Test
    public void getActions_outcomeIs_actionsRetrieved() throws URISyntaxException {

        //arrange.
        final Action.Builder actionBuilder = new Action.Builder();
        final String rel = "testRel";
        final String actionName1 = "actionName";
        final String actionName2 = "otherActionName";
        final URI actionHref1 = new URI("http://www.example.com/someaction");
        final URI actionHref2 = new URI("http://www.example.com/otheraction");

        Action action1 = actionBuilder
            .name(actionName1)
            .href(actionHref1)
            .build();

        actionBuilder.clear();

        Action action2 = actionBuilder
            .name(actionName2)
            .href(actionHref2)
            .build();

        //action.
        Entity actualEntity =
            this.embeddedRepSubEntityBuilder
                .rel(rel)
                .actions(action1, action2)
                .build();

        //assert.
        Assert.assertEquals(action1, actualEntity.getActions().get(0));
        Assert.assertEquals(action2, actualEntity.getActions().get(1));

    }

    @Test
    public void getLinks_outcomeIs_linksRetrieved() throws URISyntaxException {

        //arrange.
        final Link.Builder linkBuilder = new Link.Builder();
        final String rel1 = "testRel";
        final String rel2 = "testRel2";
        final String rel3 = "testRel2=3";
        final URI href = new URI("http://www.example.com");

        Link link1 =
            linkBuilder
                .rel(rel1)
                .href(href)
                .build();

        linkBuilder.clear();

        Link link2 =
            linkBuilder
                .rel(rel2)
                .href(href)
                .build();

        //action.
        Entity actualEntity =
            this.embeddedRepSubEntityBuilder
                .rel(rel3)
                .links(link1, link2)
                .build();

        //assert.
        Assert.assertEquals(link1, actualEntity.getLinks().get(0));
        Assert.assertEquals(link2, actualEntity.getLinks().get(1));
    }

    @Test
    public void getEntities_outcomeIs_subEntitiesRetrieved() throws URISyntaxException {

        //arrange.
        final EmbeddedLinkSubEntity.Builder subEntityBuilder =
            new EmbeddedLinkSubEntity.Builder();
        final String rel1 = "testRel1";
        final String rel2 = "testRel2";
        final String rel3 = "testRel3";
        final String rel4 = "testRel4";
        final URI href = new URI("http://www.example.com");

        EmbeddedLinkSubEntity subEntity1 =
            subEntityBuilder
                .rel(rel1)
                .href(href)
                .build();

        subEntityBuilder.clear();

        EmbeddedLinkSubEntity subEntity2 =
            subEntityBuilder
                .rel(rel2)
                .href(href)
                .build();

        //action.
        Entity actualEntity =
            this.embeddedRepSubEntityBuilder
                .rels(rel3, rel4)
                .subEntities(subEntity1, subEntity2)
                .build();

        //assert.
        Assert.assertEquals(subEntity1, actualEntity.getEntities().get(0));
        Assert.assertEquals(subEntity2, actualEntity.getEntities().get(1));

    }

    @Test
    public void equals_instancesAreEqual_outcomeIs_true() throws URISyntaxException {

        //arrange.
        final String rel1 = "testRel";
        final String rel2 = "testRel2";
        final Relation relation1 = new Relation(rel1);
        final Relation relation2 = new Relation(rel2);
        final String klass1 = "testKlass1";
        final String klass2 = "testKlass2";
        final String title = "testTitle";

        final Action.Builder actionBuilder = new Action.Builder();
        final Action action = actionBuilder
            .name("actionName")
            .href(new URI("http://www.example.com/someaction"))
            .build();

        Entity entity1 = this.embeddedRepSubEntityBuilder
            .rels(relation1, relation2)
            .klasses(klass1, klass2)
            .title(title)
            .action(action)
            .build();

        this.embeddedRepSubEntityBuilder.clear();

        Entity entity2 = this.embeddedRepSubEntityBuilder
            .rels(relation1, relation2)
            .klasses(klass1, klass2)
            .title(title)
            .action(action)
            .build();

        //action.
        boolean areEqual = entity1.equals(entity2);

        //assert.
        Assert.assertTrue(areEqual);
    }

    @Test
    public void equals_instanceIsNull_outcomeIs_false() throws URISyntaxException {

        //arrange.
        final String rel = "testRel";
        final Action.Builder actionBuilder = new Action.Builder();
        final Action action = actionBuilder
            .name("actionName")
            .href(new URI("http://www.example.com/someaction"))
            .build();

        Entity entity1 = this.embeddedRepSubEntityBuilder
            .rel(rel)
            .klass("testClass")
            .title("testTitle")
            .action(action)
            .build();

        this.embeddedRepSubEntityBuilder.clear();

        Entity entity2 = null;

        //action.
        boolean areEqual = entity1.equals(entity2);

        //assert.
        Assert.assertFalse(areEqual);
    }

    @Test
    public void equals_mismatchingClass_outcomeIs_false() throws URISyntaxException {

        //arrange.
        final String rel = "testRel";
        final Action.Builder actionBuilder = new Action.Builder();
        final Action action = actionBuilder
            .name("actionName")
            .href(new URI("http://www.example.com/someaction"))
            .build();

        Entity entity1 = this.embeddedRepSubEntityBuilder
            .rel(rel)
            .klass("testClass")
            .title("testTitle")
            .action(action)
            .build();

        this.embeddedRepSubEntityBuilder.clear();

        Object entity2 = new Object();

        //action.
        boolean areEqual = entity1.equals(entity2);

        //assert.
        Assert.assertFalse(areEqual);
    }

    @Test
    public void equals_instancesAreNotEqual_outcomeIs_false() throws URISyntaxException {

        //arrange.
        final String rel = "testRel";
        final String actionName = "actionName";
        final URI href = new URI("http://www.example.com/someaction");
        final String klass = "testClass";
        final String title = "testTitle";

        final Action.Builder actionBuilder = new Action.Builder();
        final Action action = actionBuilder
            .name(actionName)
            .href(href)
            .build();

        Entity entity1 = this.embeddedRepSubEntityBuilder
            .rel(rel)
            .klass(klass)
            .title(title)
            .action(action)
            .build();

        this.embeddedRepSubEntityBuilder.clear();

        Entity entity2 = this.embeddedRepSubEntityBuilder
            .rel(rel)
            .klass("testClassThatIsDifferent") //different class.
            .title(title)
            .action(action)
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
        final URI rel1 = new URI("http://www.example.com/relation1");
        final URI rel2 = new URI("http://www.example.com/relation2");

        final Action.Builder actionBuilder = new Action.Builder();
        final Action action = actionBuilder
            .name("actionName")
            .href(new URI("http://www.example.com/someaction"))
            .build();
        EmbeddedRepresentationSubEntity embeddedRepresentationSubEntity =
            this.embeddedRepSubEntityBuilder
                .rels(rel1, rel2)
                .klass("testClass")
                .title("testTitle")
                .action(action)
                .build();

        expectedHashCode *= PRIME + embeddedRepresentationSubEntity.getTitle().hashCode();
        expectedHashCode *= PRIME + embeddedRepresentationSubEntity.getKlass().hashCode();
        expectedHashCode *= PRIME + embeddedRepresentationSubEntity.getActions().hashCode();
        expectedHashCode *= PRIME + embeddedRepresentationSubEntity.getRel().hashCode();

        //action.
        int actualHashCode = embeddedRepresentationSubEntity.hashCode();

        //assert.
        Assert.assertEquals(expectedHashCode, actualHashCode);
    }

    @After
    public void tearDown(){
        this.embeddedRepSubEntityBuilder = null;
    }
}
