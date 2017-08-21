package siren.factories;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import siren.Action;

/**
 * @author jonfreer
 * @since 8/20/17
 */
public class ActionBuilderFactoryTester {

    private BuilderFactory<Action.Builder> actionBuilderFactory;

    public ActionBuilderFactoryTester() {}

    @Before
    public void setup(){
        this.actionBuilderFactory = new ActionBuilderFactory();
    }

    @Test
    public void create_outcomeIs_newActionBuilderInstance(){

        //action.
        Action.Builder actualActionBuilder =
                this.actionBuilderFactory.create();

        //assert.
        Assert.assertNotNull(actualActionBuilder);
    }

    @After
    public void tearDown(){
        this.actionBuilderFactory = null;
    }
}
