package siren.factories;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import siren.Entity;

/**
 * @author jonfreer
 * @since 8/20/17
 */
public class EntityBuilderFactoryTester {

    private BuilderFactory<Entity.Builder> entityBuilderFactory;

    public EntityBuilderFactoryTester(){}

    @Before
    public void setup(){
        this.entityBuilderFactory = new EntityBuilderFactory();
    }

    @Test
    public void create_outcomeIs_newEntityBuilderInstance(){

        //action.
        Entity.Builder entityBuilder =
                this.entityBuilderFactory.create();

        //assert.
        Assert.assertNotNull(entityBuilder);
    }

    @After
    public void tearDown(){
        this.entityBuilderFactory = null;
    }
}
