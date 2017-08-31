package siren;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jonfreer
 * @since 8/20/17
 */
public class ActionTester {

    private Action.Builder actionBuilder;

    public ActionTester(){}

    @Before
    public void setup(){
        this.actionBuilder = new Action.Builder();
    }

    @Test(expected = IllegalArgumentException.class)
    public void name_nullName_outcomeIs_IllegalArgumentException() {

        //arrange.
        final String name = null;

        //action.
        this.actionBuilder.name(name).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void href_nullHref_outcomeIs_IllegalArgumentException() {

        //arrange.
        final String name = "testName";
        final URI href = null;

        //action.
        this.actionBuilder.name(name).href(href).build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void field_nullfield_outcomeIs_IllegalArgumentException() {

        //arrange.
        final Field field = null;

        //action.
        this.actionBuilder.field(field).build();
    }

    @Test
    public void getKlass_outcomeIs_KlassRetrieved() throws URISyntaxException {

        //arrange.
        final String name = "nameTest";
        final String klass1 = "klassTest1";
        final String klass2 = "klassTest2";
        final List<String> klass = new ArrayList<String>();
        klass.add(klass1);
        klass.add(klass2);
        final String uri = "http://www.example.com/href";
        final URI href = new URI(uri);
        Action action =
                this.actionBuilder
                        .name(name)
                        .href(href)
                        .klass(klass1)
                        .klass(klass2)
                        .build();

        //action.
        List<String> actualClass = action.getKlass();

        //assert.
        Assert.assertEquals(2, actualClass.size());
        Assert.assertEquals(klass, actualClass);
    }

    @Test
    public void getKlass_nullClass_outcomeIs_Null() throws URISyntaxException {

        //arrange.
        final String name = "nameTest";
        final String uri = "http://www.example.com/href";
        final URI href = new URI(uri);
        Action action =
                this.actionBuilder
                        .name(name)
                        .href(href)
                        .build();

        //action.
        List<String> actualClass = action.getKlass();

        //assert.
        Assert.assertNull(actualClass);
    }

    @Test
    public void getName_outcomeIs_NameRetrieved() throws URISyntaxException {

        //arrange.
        final String name = "nameTest";
        final String uri = "http://www.example.com/href";
        final URI href = new URI(uri);
        Action action =
                this.actionBuilder
                        .name(name)
                        .href(href)
                        .build();

        //action.
        String actualName = action.getName();

        //assert.
        Assert.assertEquals(name, actualName);
    }

    @Test
    public void getTitle_outcomeIs_TitleRetrieved() throws URISyntaxException {

        //arrange.
        final String name = "nameTest";
        final String title = "titleTest";
        final String uri = "http://www.example.com/href";
        final URI href = new URI(uri);
        Action action =
                this.actionBuilder
                        .name(name)
                        .href(href)
                        .title(title)
                        .build();

        //action.
        String actualTitle = action.getTitle();

        //assert.
        Assert.assertEquals(title, actualTitle);
    }

    @Test
    public void getMethod_outcomeIs_MethodRetrieved() throws URISyntaxException {

        //arrange.
        final String name = "nameTest";
        final HttpMethod method = HttpMethod.POST;
        final String uri = "http://www.example.com/href";
        final URI href = new URI(uri);
        Action action =
                this.actionBuilder
                        .name(name)
                        .href(href)
                        .method(method)
                        .build();

        //action.
        HttpMethod actualMethod = action.getMethod();

        //assert.
        Assert.assertEquals(method, actualMethod);
    }

    @Test
    public void getHref_outcomeIs_HrefRetrieved() throws URISyntaxException {

        //arrange.
        final String name = "nameTest";
        final String uri = "http://www.example.com/href";
        final URI href = new URI(uri);
        Action action =
                this.actionBuilder
                        .name(name)
                        .href(href)
                        .build();

        //action.
        String actualHref = action.getHref();

        //assert.
        Assert.assertEquals(href.toString(), actualHref);
    }

    @Test
    public void getType_outcomeIs_TypeRetrieved() throws URISyntaxException {

        //arrange.
        final String name = "nameTest";
        final String type = "typeTest";
        final String uri = "http://www.example.com/href";
        final URI href = new URI(uri);
        Action action =
                this.actionBuilder
                        .name(name)
                        .href(href)
                        .type(type)
                        .build();

        //action.
        String actualType = action.getType();

        //assert.
        Assert.assertEquals(type, actualType);
    }

    @Test
    public void getFields_outcomeIs_FieldsRetrieved() throws URISyntaxException {

        //arrange.
        final String name = "nameTest";
        final Field<String> field1 =
                new Field.Builder<String>()
                        .name(name)
                        .value("fieldTest1")
                        .build();

        final Field<String> field2 =
                new Field.Builder<String>()
                        .name(name)
                        .value("fieldTest2")
                        .build();
        final List<Field<String>> fields =
                new ArrayList<Field<String>>();
        fields.add(field1);
        fields.add(field2);
        final String type = "typeTest";
        final String uri = "http://www.example.com/href";
        final URI href = new URI(uri);
        Action action =
                this.actionBuilder
                        .name(name)
                        .field(field1)
                        .field(field2)
                        .href(href)
                        .type(type)
                        .build();

        //action.
        List<Field> actualFields = action.getFields();

        //assert.
        Assert.assertEquals(2, actualFields.size());
        Assert.assertEquals(fields, actualFields);
    }

    @Test
    public void getFields_nullFields_outcomeIs_null() throws URISyntaxException {

        //arrange.
        final String name = "nameTest";
        final String type = "typeTest";
        final String uri = "http://www.example.com/href";
        final URI href = new URI(uri);
        Action action =
                this.actionBuilder
                        .name(name)
                        .href(href)
                        .type(type)
                        .build();

        //action.
        List<Field> actualFields = action.getFields();

        //assert.
        Assert.assertNull(actualFields);
    }

    @After
    public void tearDown(){
        this.actionBuilder = null;
    }
}
