package siren;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

/**
 * @author jonfreer
 * @since 8/20/17
 */
public class LinkTester {

    private Link.Builder linkBuilder;

    public LinkTester(){}

    @Before
    public void setup(){
        this.linkBuilder = new Link.Builder();
    }

    @Test(expected = IllegalArgumentException.class)
    public void rel_nullRel_outcomeIs_IllegalArgumentException() {

        //arrange.
        final String rel = null;

        //action.
        this.linkBuilder.rel(rel).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void klass_nullKlass_outcomeIs_IllegalArgumentException() {

        //arrange.
        final String klass = null;

        //action.
        this.linkBuilder.klass(klass).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void href_nullHref_outcomeIs_IllegalArgumentException() {

        //arrange.
        final String href = null;

        //action.
        this.linkBuilder.rel(href).build();
    }

    @Test
    public void getRel_outcomeIs_RelRetrieved() throws URISyntaxException {

        //arrange.
        final String uri = "http://www.example.com/href";
        final String rel = "relTest";
        final URI href = new URI(uri);
        Link link = this.linkBuilder.rel(rel).href(href).build();

        //action.
        List<String> actualRel = link.getRel();

        //assert.
        Assert.assertEquals(1, actualRel.size());
        Assert.assertEquals(actualRel.get(0), rel);
    }

    @Test
    public void getKlass_outcomeIs_ClassRetrieved() throws URISyntaxException {

        //arrange.
        final String klass = "klassTest";
        final String uri = "http://www.example.com/href";
        final URI href = new URI(uri);
        Link link =
                this.linkBuilder
                        .rel("relTest")
                        .href(href)
                        .klass(klass)
                        .build();

        //action.
        List<String> actualClass = link.getKlass();

        //assert.
        Assert.assertEquals(1, actualClass.size());
        Assert.assertEquals(klass, actualClass.get(0));
    }

    @Test
    public void getKlass_nullClass_outcomeIs_Null() throws URISyntaxException {

        //arrange.
        final String klass = "klassTest";
        final String uri = "http://www.example.com/href";
        final URI href = new URI(uri);
        Link link =
                this.linkBuilder
                        .rel("relTest")
                        .href(href)
                        .build();

        //action.
        List<String> actualClass = link.getKlass();

        //assert.
        Assert.assertNull(actualClass);
    }

    @Test
    public void getTitle_outcomeIs_TitleRetrieved() throws URISyntaxException {

        //arrange.
        final String title = "titleTest";
        final String uri = "http://www.example.com/href";
        final URI href = new URI(uri);
        Link link =
                this.linkBuilder
                        .rel("relTest")
                        .href(href)
                        .title(title)
                        .build();

        //action.
        String actualTitle = link.getTitle();

        //assert.
        Assert.assertEquals(title, actualTitle);
    }

    @Test
    public void getTitle_nullTitle_outcomeIs_Null() throws URISyntaxException {

        //arrange.
        final String uri = "http://www.example.com/href";
        final URI href = new URI(uri);
        Link link =
                this.linkBuilder
                        .rel("relTest")
                        .href(href)
                        .build();

        //action.
        String actualTitle = link.getTitle();

        //assert.
        Assert.assertNull(actualTitle);
    }

    @Test
    public void getType_outcomeIs_TypeRetrieved() throws URISyntaxException {

        //arrange.
        final String type = "typeTest";
        final String uri = "http://www.example.com/href";
        final URI href = new URI(uri);
        Link link =
                this.linkBuilder
                        .rel("relTest")
                        .href(href)
                        .type(type)
                        .build();

        //action.
        String actualType = link.getType();

        //assert.
        Assert.assertEquals(type, actualType);
    }

    @Test
    public void getType_nullTitle_outcomeIs_Null() throws URISyntaxException {

        //arrange.
        final String uri = "http://www.example.com/href";
        final URI href = new URI(uri);
        Link link =
                this.linkBuilder
                        .rel("relTest")
                        .href(href)
                        .build();

        //action.
        String actualType = link.getType();

        //assert.
        Assert.assertNull(actualType);
    }

    @Test
    public void getHref_outcomeIs_HrefRetrieved() throws URISyntaxException {

        //arrange.
        final String uri = "http://www.example.com/href";
        final URI href = new URI(uri);
        Link link =
                this.linkBuilder
                        .rel("relTest")
                        .href(href)
                        .build();

        //action.
        String actualHref = link.getHref();

        //assert.
        Assert.assertEquals(href.toString(), actualHref);
    }

    @After
    public void tearDown(){
        this.linkBuilder = null;
    }
}
