package siren;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author jonfreer
 * @since 8/22/17
 */
public class EntityTester {

    private Entity.Builder entityBuilder;

    public EntityTester(){}

    @Before
    public void setup(){
        this.entityBuilder = new Entity.Builder();
    }

    @Test(expected = IllegalArgumentException.class)
    public void klass_nullKlass_outcomeIs_IllegalArgumentException() {

        //arrange.
        final String klass = null;

        //action.
        this.entityBuilder.klass(klass);
    }

    @Test(expected = IllegalArgumentException.class)
    public void property_nullPropertyKey_outcomeIs_IllegalArgumentException() {

        //arrange.
        final String propertyKey = null;
        final String propertyValue = "value";

        //action.
        this.entityBuilder.property(propertyKey, propertyValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void action_nullAction_outcomeIs_IllegalArgumentException() {

        //arrange.
        final Action action = null;

        //action.
        this.entityBuilder.action(action);
    }

    @Test(expected = IllegalArgumentException.class)
    public void link_nullLink_outcomeIs_IllegalArgumentException() {

        //arrange.
        final Link link = null;

        //action.
        this.entityBuilder.link(link);
    }

    @Test(expected = IllegalArgumentException.class)
    public void subEntity_nullSubEntity_outcomeIs_IllegalArgumentException() {

        //arrange.
        final EmbeddedLinkSubEntity subEntity = null;

        //action.
        this.entityBuilder.subEntity(subEntity);
    }

    @Test
    public void getProperties_outcomeIs_propertiesRetrieved(){

        //arrange.
        final String propertyKey = "key";
        final String propertyValue = "value";

        //action.
        Entity actualEntity =
                this.entityBuilder
                        .property(propertyKey, propertyValue)
                        .build();

        //assert.
        Assert.assertEquals(propertyValue, actualEntity.getProperties().get(propertyKey));
    }

    @Test
    public void getActions_outcomeIs_actionsRetrieved() throws URISyntaxException {

        //arrange.
        final Action.Builder actionBuilder = new Action.Builder();
        Action action = actionBuilder
                .name("actionName")
                .href(new URI("http://www.example.com/someaction"))
                .build();

        //action.
        Entity actualEntity =
                this.entityBuilder
                        .action(action)
                        .build();

        //assert.
        Assert.assertEquals(action, actualEntity.getActions().get(0));
    }

    @Test
    public void getLinks_outcomeIs_linksRetrieved() throws URISyntaxException {

        //arrange.
        final Link.Builder linkBuilder = new Link.Builder();
        Link link =
                linkBuilder
                        .rel("testRel")
                        .href(new URI("http://www.example.com"))
                        .build();

        //action.
        Entity actualEntity =
                this.entityBuilder
                        .link(link)
                        .build();

        //assert.
        Assert.assertEquals(link, actualEntity.getLinks().get(0));
    }

    @Test
    public void getEntities_outcomeIs_subEntitiesRetrieved() throws URISyntaxException {

        //arrange.
        final EmbeddedLinkSubEntity.Builder subEntityBuilder =
                new EmbeddedLinkSubEntity.Builder();
        EmbeddedLinkSubEntity subEntity =
                subEntityBuilder
                        .rel("testRel")
                        .href(new URI("http://www.example.com"))
                        .build();

        //action.
        Entity actualEntity =
                this.entityBuilder
                        .subEntity(subEntity)
                        .build();

        //assert.
        Assert.assertEquals(subEntity, actualEntity.getEntities().get(0));
    }

    @Test
    public void equals_instancesAreEqual_outcomeIs_true() throws URISyntaxException {

        //arrange.
        final Action.Builder actionBuilder = new Action.Builder();
        final Action action = actionBuilder
                .name("actionName")
                .href(new URI("http://www.example.com/someaction"))
                .build();

        Entity entity1 = this.entityBuilder
                .klass("testClass")
                .title("testTitle")
                .action(action)
                .build();

        this.entityBuilder.clear();

        Entity entity2 = this.entityBuilder
                .klass("testClass")
                .title("testTitle")
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
        final Action.Builder actionBuilder = new Action.Builder();
        final Action action = actionBuilder
                .name("actionName")
                .href(new URI("http://www.example.com/someaction"))
                .build();

        Entity entity1 = this.entityBuilder
                .klass("testClass")
                .title("testTitle")
                .action(action)
                .build();

        this.entityBuilder.clear();

        Entity entity2 = null;

        //action.
        boolean areEqual = entity1.equals(entity2);

        //assert.
        Assert.assertFalse(areEqual);
    }

    @Test
    public void equals_mismatchingClass_outcomeIs_false() throws URISyntaxException {

        //arrange.
        final Action.Builder actionBuilder = new Action.Builder();
        final Action action = actionBuilder
                .name("actionName")
                .href(new URI("http://www.example.com/someaction"))
                .build();

        Entity entity1 = this.entityBuilder
                .klass("testClass")
                .title("testTitle")
                .action(action)
                .build();

        this.entityBuilder.clear();

        Object entity2 = new Object();

        //action.
        boolean areEqual = entity1.equals(entity2);

        //assert.
        Assert.assertFalse(areEqual);
    }

    @Test
    public void equals_instancesAreNotEqual_outcomeIs_false() throws URISyntaxException {

        //arrange.
        final Action.Builder actionBuilder = new Action.Builder();
        final Action action = actionBuilder
                .name("actionName")
                .href(new URI("http://www.example.com/someaction"))
                .build();

        Entity entity1 = this.entityBuilder
                .klass("testClass")
                .title("testTitle")
                .action(action)
                .build();

        this.entityBuilder.clear();

        Entity entity2 = this.entityBuilder
                .klass("testClassThatIsDifferent") //different class.
                .title("testTitle")
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
        final int prime = 31;
        int expectedHashCode = 1;
        final Action.Builder actionBuilder = new Action.Builder();
        final Action action = actionBuilder
                .name("actionName")
                .href(new URI("http://www.example.com/someaction"))
                .build();
        Entity entity = this.entityBuilder
                .klass("testClass")
                .title("testTitle")
                .action(action)
                .build();

        expectedHashCode *= prime + entity.getTitle().hashCode();
        expectedHashCode *= prime + entity.getKlass().hashCode();
        expectedHashCode *= prime + entity.getActions().hashCode();

        //action.
        int actualHashCode = entity.hashCode();

        //assert.
        Assert.assertEquals(expectedHashCode, actualHashCode);
    }

    @After
    public void tearDown(){
        this.entityBuilder = null;
    }
}
