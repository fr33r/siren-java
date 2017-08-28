package siren;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author jonfreer
 * @since 8/27/17
 */
public class FieldValueTester {

    private FieldValue.Builder<String> fieldValueBuilder;

    public FieldValueTester(){}

    @Before
    public void setup(){
        this.fieldValueBuilder = new FieldValue.Builder<String>();
    }

    @Test(expected = IllegalArgumentException.class)
    public void value_nullValue_outcomeIs_IllegalArgumentException(){

        //arrange.
        final String value = null;

        //action.
        this.fieldValueBuilder.value(value);
    }

    @Test(expected = IllegalArgumentException.class)
    public void value_unsupportedValueType_outcomeIs_IllegalArgumentException(){

        //arrange.
        FieldValue.Builder fieldValueBuilder = new FieldValue.Builder();
        final Object value = new Object();

        //action.
        fieldValueBuilder
                .value(value)
                .build();
    }

    @Test
    public void clear_outcomeIs_BuilderCleared(){

        //arrange.
        final Boolean selected = true;
        final String valueAfterClear = "newTestValue";
        final String value = "testValue";
        final String title = "testTitle";
        final FieldType type = FieldType.CHECKBOX;

        this.fieldValueBuilder
                .value(value)
                .selected(selected)
                .title(title);

        //action.
        this.fieldValueBuilder.clear();

        //assert.
        FieldValue fieldValue = this.fieldValueBuilder.value(valueAfterClear).build();

        Assert.assertNull(fieldValue.getTitle());
        Assert.assertNull(fieldValue.getSelected());
        Assert.assertEquals(valueAfterClear, fieldValue.getValue());
    }

    @Test
    public void getTitle_outcomeIs_TitleRetrieved() {

        //arrange.
        final String title = "titleTest";
        final String value = "valueTest";
        FieldValue<String> fieldValue =
                this.fieldValueBuilder
                        .title(title)
                        .value(value)
                        .build();

        //action.
        String actualTitle = fieldValue.getTitle();

        //assert.
        Assert.assertEquals(title, actualTitle);
    }

    @Test
    public void getTitle_nullTitle_outcomeIs_Null() {

        //arrange.
        final String value = "valueTest";
        FieldValue<String> field =
                this.fieldValueBuilder
                        .value(value)
                        .build();

        //action.
        String actualTitle = field.getTitle();

        //assert.
        Assert.assertNull(actualTitle);
    }

    @Test
    public void getSelected_outcomeIs_SelectedRetrieved() {

        //arrange.
        final String value = "valueTest";
        final Boolean selected = true;
        FieldValue<String> fieldValue =
                this.fieldValueBuilder
                        .value(value)
                        .selected(selected)
                        .build();

        //action.
        Boolean actualSelected = fieldValue.getSelected();

        //assert.
        Assert.assertEquals(selected, actualSelected);
    }

    @Test
    public void getSelected_nullSelected_outcomeIs_Null() {

        //arrange.
        final String value = "valueTest";
        FieldValue<String> field =
                this.fieldValueBuilder
                        .value(value)
                        .build();

        //action.
        Boolean actualSelected = field.getSelected();

        //assert.
        Assert.assertNull(actualSelected);
    }

    @After
    public void tearDown(){
        this.fieldValueBuilder = null;
    }
}
