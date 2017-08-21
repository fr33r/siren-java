package siren.factories;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import siren.Link;

/**
 * @author jonfreer
 * @since 8/20/17
 */
public class LinkBuilderFactoryTester {

    private BuilderFactory<Link.Builder> linkBuilderFactory;

    public LinkBuilderFactoryTester(){}

    @Before
    public void setup(){
        this.linkBuilderFactory = new LinkBuilderFactory();
    }

    @Test
    public void create_outcomeIs_newLinkBuilderInstance(){

        //action.
        Link.Builder actionLinkBuilder =
                this.linkBuilderFactory.create();

        //assert.
        Assert.assertNotNull(actionLinkBuilder);
    }

    @After
    public void tearDown(){
        this.linkBuilderFactory = null;
    }
}
