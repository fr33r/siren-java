package siren.factories;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import siren.EmbeddedRepresentationSubEntity;

/**
 * @author jonfreer
 * @since 8/20/17
 */
public class EmbeddedRepresentationSubEntityBuilderFactoryTester {

    private BuilderFactory<EmbeddedRepresentationSubEntity.Builder> embeddedRepSubEntityBuilderFactory;

    public EmbeddedRepresentationSubEntityBuilderFactoryTester(){}

    @Before
    public void setup(){
        this.embeddedRepSubEntityBuilderFactory =
                new EmbeddedRepresentationSubEntityBuilderFactory();
    }

    @Test
    public void create_outcomeIs_newEmbeddedRepresentationSubEntityBuilderInstance(){

        //action.
        EmbeddedRepresentationSubEntity.Builder embeddedRepSubEntityBuilder =
                this.embeddedRepSubEntityBuilderFactory.create();

        //assert.
        Assert.assertNotNull(embeddedRepSubEntityBuilder);
    }

    @After
    public void tearDown(){
        this.embeddedRepSubEntityBuilderFactory = null;
    }
}
