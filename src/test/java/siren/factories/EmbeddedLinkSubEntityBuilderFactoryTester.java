package siren.factories;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import siren.EmbeddedLinkSubEntity;

/**
 * @author jonfreer
 * @since 8/20/17
 */
public class EmbeddedLinkSubEntityBuilderFactoryTester {

    private BuilderFactory<EmbeddedLinkSubEntity.Builder> embeddedLinkSubEntityBuilderFactory;

    public EmbeddedLinkSubEntityBuilderFactoryTester(){}

    @Before
    public void setup(){
        this.embeddedLinkSubEntityBuilderFactory =
                new EmbeddedLinkSubEntityBuilderFactory();
    }

    @Test
    public void create_outcomeIs_newEmbeddedLinkSubEntityBuilderInstance(){

        //action.
        EmbeddedLinkSubEntity.Builder embeddedLinkSubEntityBuilder =
                this.embeddedLinkSubEntityBuilderFactory.create();

        //assert.
        Assert.assertNotNull(embeddedLinkSubEntityBuilder);
    }

    @After
    public void tearDown(){
        this.embeddedLinkSubEntityBuilderFactory = null;
    }
}
