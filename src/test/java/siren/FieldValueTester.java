package siren;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        Assert.assertFalse(fieldValue.getSelected());
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
    public void getSelected_notSpecified_outcomeIs_False() {

        //arrange.
        final String value = "valueTest";
        FieldValue<String> field =
                this.fieldValueBuilder
                        .value(value)
                        .build();

        //action.
        Boolean actualSelected = field.getSelected();

        //assert.
        Assert.assertFalse(actualSelected);
    }

    @Test
    public void equals_instancesAreEqualWithNulls_outcomeIs_true(){

        //arrange.
        final String value = "testValue";

        FieldValue<String> fieldValue1 = this.fieldValueBuilder
            .value(value)
            .build();

        this.fieldValueBuilder.clear();

        FieldValue<String> fieldValue2 = this.fieldValueBuilder
            .value(value)
            .build();

        //action.
        boolean areEqual = fieldValue1.equals(fieldValue2);

        //assert.
        Assert.assertTrue(areEqual);
    }

    @Test
    public void equals_instancesAreEqual_outcomeIs_true(){

        //arrange.
        final String value = "testValue";
        final String title = "testTitle";
        final Boolean selected = true;

        FieldValue<String> fieldValue1 = this.fieldValueBuilder
            .value(value)
            .title(title)
            .selected(selected)
            .build();

        this.fieldValueBuilder.clear();

        FieldValue<String> fieldValue2 = this.fieldValueBuilder
            .value(value)
            .title(title)
            .selected(selected)
            .build();

        //action.
        boolean areEqual = fieldValue1.equals(fieldValue2);

        //assert.
        Assert.assertTrue(areEqual);
    }

    @Test
    public void equals_instanceIsNull_outcomeIs_false(){

        //arrange.
        final String value = "testValue";
        final String title = "testTitle";
        final Boolean selected = true;

        FieldValue<String> fieldValue1 = this.fieldValueBuilder
            .value(value)
            .title(title)
            .selected(selected)
            .build();

        this.fieldValueBuilder.clear();

        FieldValue<String> fieldValue2 = null;

        //action.
        boolean areEqual = fieldValue1.equals(fieldValue2);

        //assert.
        Assert.assertFalse(areEqual);
    }

    @Test
    public void equals_mismatchingClass_outcomeIs_false(){

        //arrange.
        final String value = "testValue";
        final String title = "testTitle";
        final Boolean selected = true;

        FieldValue<String> fieldValue1 = this.fieldValueBuilder
            .value(value)
            .title(title)
            .selected(selected)
            .build();

        this.fieldValueBuilder.clear();

        Object fieldValue2 = new Object();

        //action.
        boolean areEqual = fieldValue1.equals(fieldValue2);

        //assert.
        Assert.assertFalse(areEqual);
    }

    @Test
    public void equals_instancesAreNotEqual_outcomeIs_false(){

        //arrange.
        final String value = "testValue";
        final String title = "testTitle";
        final String otherTitle = "otherTestTitle";
        final Boolean selected = true;

        FieldValue<String> fieldValue1 = this.fieldValueBuilder
            .value(value)
            .title(title)
            .selected(selected)
            .build();

        this.fieldValueBuilder.clear();

        FieldValue<String> fieldValue2 = this.fieldValueBuilder
            .value(value)
            .title(otherTitle) //title is different.
            .selected(selected)
            .build();

        //action.
        boolean areEqual = fieldValue1.equals(fieldValue2);

        //assert.
        Assert.assertFalse(areEqual);
    }

    @Test
    public void hashCode_outcomeIs_hashCodeGenerated(){

        //arrange.
        final int PRIME = 31;
        int expectedHashCode = 1;
        final String value = "testValue";
        final String title = "testTitle";
        final Boolean selected = true;

        FieldValue<String> fieldValue = this.fieldValueBuilder
            .value(value)
            .title(title)
            .selected(selected)
            .build();

        expectedHashCode *= PRIME + fieldValue.getTitle().hashCode();
        expectedHashCode *= PRIME + fieldValue.getValue().hashCode();
        expectedHashCode *= PRIME + fieldValue.getSelected().hashCode();

        //action.
        int actualHashCode = fieldValue.hashCode();

        //assert.
        Assert.assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    public void hashCode_optionalMembersNotSpecified_outcomeIs_hashCodeGenerated(){

        //arrange.
        final int PRIME = 31;
        int expectedHashCode = 1;
        final String value = "testValue";

        FieldValue<String> fieldValue = this.fieldValueBuilder
            .value(value)
            .build();

        expectedHashCode *= PRIME + fieldValue.getValue().hashCode();
        expectedHashCode *= PRIME + fieldValue.getSelected().hashCode();

        //action.
        int actualHashCode = fieldValue.hashCode();

        //assert.
        Assert.assertEquals(expectedHashCode, actualHashCode);
    }

    @After
    public void tearDown(){
        this.fieldValueBuilder = null;
    }
}
