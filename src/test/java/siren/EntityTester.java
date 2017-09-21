package siren;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public void getKlass_outcomeIs_classRetrieved(){

        //arrange.
        final String klass1 = "klass1";
        final String klass2 = "klass2";
        List<String> klass = new ArrayList<String>();
        klass.add(klass1);
        klass.add(klass2);

        //action.
        Entity actualEntity =
            this.entityBuilder
                .klasses(klass1, klass2)
                .build();

        //assert.
        Assert.assertEquals(klass, actualEntity.getKlass());
    }

    @Test
    public void getProperties_outcomeIs_propertiesRetrieved(){

        //arrange.
        final String propertyKey1 = "key1";
        final String propertyValue1 = "value1";
        final String propertyKey2 = "key2";
        final String propertyValue2 = "value2";
        final Map<String, Object> properties =
            new HashMap<>();
        properties.put(propertyKey1, propertyValue1);
        properties.put(propertyKey2, propertyValue2);

        //action.
        Entity actualEntity =
            this.entityBuilder
                .property(propertyKey1, propertyValue1)
                .property(propertyKey2, propertyValue2)
                .build();

        //assert.
        Assert.assertEquals(properties, actualEntity.getProperties());
    }

    @Test
    public void getActions_outcomeIs_actionsRetrieved() throws URISyntaxException {

        //arrange.
        final Action.Builder actionBuilder = new Action.Builder();
        Action action1 = actionBuilder
            .name("actionName1")
            .href(new URI("http://www.example.com/someaction"))
            .build();

        actionBuilder.clear();

        Action action2 = actionBuilder
            .name("actionName2")
            .href(new URI("http://www.example.com/someotheraction"))
            .build();

        List<Action> actions = new ArrayList<Action>();
        actions.add(action1);
        actions.add(action2);

        //action.
        Entity actualEntity =
            this.entityBuilder
                .actions(action1, action2)
                .build();

        //assert.
        Assert.assertEquals(actions, actualEntity.getActions());
    }

    @Test
    public void getLinks_outcomeIs_linksRetrieved() throws URISyntaxException {

        //arrange.
        final Link.Builder linkBuilder = new Link.Builder();
        Link link1 =
            linkBuilder
                .rel("testRel1")
                .href(new URI("http://www.example.com/something"))
                .build();

        linkBuilder.clear();

        Link link2 =
            linkBuilder
                .rel("testRel2")
                .href(new URI("http://www.example.com/somethingelse"))
                .build();

        List<Link> links = new ArrayList<Link>();
        links.add(link1);
        links.add(link2);

        //action.
        Entity actualEntity =
            this.entityBuilder
                .links(link1, link2)
                .build();

        //assert.
        Assert.assertEquals(links, actualEntity.getLinks());
    }

    @Test
    public void getEntities_outcomeIs_subEntitiesRetrieved() throws URISyntaxException {

        //arrange.
        final EmbeddedLinkSubEntity.Builder subEntityBuilder =
            new EmbeddedLinkSubEntity.Builder();
        EmbeddedLinkSubEntity subEntity1 =
            subEntityBuilder
                .rel("testRel1")
                .href(new URI("http://www.example.com/something"))
                .build();

        subEntityBuilder.clear();

        EmbeddedLinkSubEntity subEntity2 =
            subEntityBuilder
                .rel("testRel2")
                .href(new URI("http://www.example.com/somethingelse"))
                .build();

        List<EntityBase> subEntities = new ArrayList<EntityBase>();
        subEntities.add(subEntity1);
        subEntities.add(subEntity2);

        //action.
        Entity actualEntity =
            this.entityBuilder
                .subEntities(subEntity1, subEntity2)
                .build();

        //assert.
        Assert.assertEquals(subEntities, actualEntity.getEntities());
    }

    @Test
    public void equals_instancesAreEqualWithNulls_outcomeIs_true(){
        //arrange.
        Entity entity1 = this.entityBuilder.build();

        this.entityBuilder.clear();

        Entity entity2 = this.entityBuilder.build();

        //action.
        boolean areEqual = entity1.equals(entity2);

        //assert.
        Assert.assertTrue(areEqual);
    }

    @Test
    public void equals_instancesAreEqual_outcomeIs_true() throws URISyntaxException {

        //arrange.
        final Link.Builder linkBuilder = new Link.Builder();
        final Link link = linkBuilder
            .href(new URI("http://www.example.com/someaction"))
            .rel("rel")
            .title("title")
            .build();
        final String key = "key";
        final String value = "value";
        final Action.Builder actionBuilder = new Action.Builder();
        final Action action = actionBuilder
            .name("actionName")
            .href(new URI("http://www.example.com/someaction"))
            .build();
        final EmbeddedLinkSubEntity.Builder embeddedLinkSubEntityBuilder =
            new EmbeddedLinkSubEntity.Builder();
        final EmbeddedLinkSubEntity embeddedLinkSubEntity =
            embeddedLinkSubEntityBuilder
                .href(new URI("http://www.example.com/someaction"))
                .rel("somerel")
                .title("title")
                .build();

        Entity entity1 = this.entityBuilder
            .klass("testClass")
            .title("testTitle")
            .property(key, value)
            .link(link)
            .action(action)
            .subEntity(embeddedLinkSubEntity)
            .build();

        this.entityBuilder.clear();

        Entity entity2 = this.entityBuilder
            .klass("testClass")
            .title("testTitle")
            .property(key, value)
            .link(link)
            .action(action)
            .subEntity(embeddedLinkSubEntity)
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
        final int PRIME = 31;
        int expectedHashCode = 1;
        final String key = "key";
        final String value = "value";
        final Action.Builder actionBuilder = new Action.Builder();
        final Action action = actionBuilder
            .name("actionName")
            .href(new URI("http://www.example.com/someaction"))
            .build();
        final Link.Builder linkBuilder = new Link.Builder();
        final Link link = linkBuilder
            .href(new URI("http://www.example.com/someotheraction"))
            .rel("rel")
            .title("title")
            .build();
        Entity entity = this.entityBuilder
            .property(key, value)
            .klass("testClass")
            .title("testTitle")
            .action(action)
            .link(link)
            .build();

        expectedHashCode *= PRIME + entity.getTitle().hashCode();
        expectedHashCode *= PRIME + entity.getKlass().hashCode();
        expectedHashCode *= PRIME + entity.getActions().hashCode();
        expectedHashCode *= PRIME + entity.getProperties().hashCode();
        expectedHashCode *= PRIME + entity.getLinks().hashCode();

        //action.
        int actualHashCode = entity.hashCode();

        //assert.
        Assert.assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    public void hashCode_membersAreNull_outcomeIs_hashCodeGenerated() throws URISyntaxException {

        //arrange.
        int expectedHashCode = 1;

        Entity entity = this.entityBuilder.build();

        //action.
        int actualHashCode = entity.hashCode();

        //assert.
        Assert.assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    public void defaultConstructor_outcomeIs_emptyInstance(){

        //action.
        Entity entity = new Entity();

        //assert.
        Assert.assertNull(entity.getKlass());
        Assert.assertNull(entity.getProperties());
        Assert.assertNull(entity.getTitle());
        Assert.assertNull(entity.getActions());
        Assert.assertNull(entity.getLinks());
        Assert.assertNull(entity.getEntities());
    }

    @After
    public void tearDown(){
        this.entityBuilder = null;
    }
}
