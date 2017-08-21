package siren.factories;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import siren.Field;

/**
 * @author jonfreer
 * @since 8/20/17
 */
public class FieldBuilderFactoryTester {

    private BuilderFactory<Field.Builder> fieldBuilderFactory;

    public FieldBuilderFactoryTester(){}

    @Before
    public void setup(){
        this.fieldBuilderFactory = new FieldBuilderFactory();
    }

    @Test
    public void create_outcomeIs_newFieldBuilderInstance(){

        //action.
        Field.Builder fieldBuilder =
                this.fieldBuilderFactory.create();

        //assert.
        Assert.assertNotNull(fieldBuilder);
    }

    @After
    public void tearDown(){
        this.fieldBuilderFactory = null;
    }
}
