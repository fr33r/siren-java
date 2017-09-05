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
public class FieldTester {

    private Field.Builder<List<FieldValue<String>>> fieldBuilder;

    public FieldTester(){}

    @Before
    public void setup(){
        this.fieldBuilder = new Field.Builder<>();
    }

    @Test(expected = IllegalArgumentException.class)
    public void value_unsupportedValueType_outcomeIs_IllegalArgumentException(){

        //arrange.
        Field.Builder fieldBuilder = new Field.Builder();
        final String name = "nameTest";
        final Object value = new Object();

        //action.
        fieldBuilder
                .name(name)
                .value(value)
                .build();
    }

    @Test(expected = IllegalArgumentException.class)
    public void name_nullName_outcomeIs_IllegalArgumentException(){

        //arrange.
        final String name = null;

        //action.
        fieldBuilder
                .name(name)
                .build();
    }

    @Test
    public void clear_outcomeIs_BuilderCleared(){

        //arrange.
        final String name = "testName";
        final String nameAfterClear = "newTestName";
        final String value = "testValue";
        final String title = "testTitle";
        final FieldType type = FieldType.CHECKBOX;

        FieldValue<String> fieldValue =
                new FieldValue.Builder<String>()
                    .value(value)
                    .build();

        List<FieldValue<String>> listOfFieldValues =
                new ArrayList<FieldValue<String>>();

        listOfFieldValues.add(fieldValue);

        this.fieldBuilder
                .name(name)
                .value(listOfFieldValues)
                .type(type)
                .title(title);

        //action.
        this.fieldBuilder.clear();

        //assert.
        Field field = this.fieldBuilder.name(nameAfterClear).build();

        Assert.assertNull(field.getTitle());
        Assert.assertNull(field.getType());
        Assert.assertNull(field.getValue());
        Assert.assertEquals(nameAfterClear, field.getName());
    }

    @Test
    public void getName_outcomeIs_NameRetrieved() {

        //arrange.
        final String name = "nameTest";
        Field field =
                this.fieldBuilder
                        .name(name)
                        .build();

        //action.
        String actualName = field.getName();

        //assert.
        Assert.assertEquals(name, actualName);
    }

    @Test
    public void getTitle_outcomeIs_TitleRetrieved() {

        //arrange.
        final String title = "titleTest";
        final String name = "nameTest";
        Field field =
                this.fieldBuilder
                        .name(name)
                        .title(title)
                        .build();

        //action.
        String actualTitle = field.getTitle();

        //assert.
        Assert.assertEquals(title, actualTitle);
    }

    @Test
    public void getTitle_nullTitle_outcomeIs_Null() {

        //arrange.
        final String name = "nameTest";
        Field field =
                this.fieldBuilder
                        .name(name)
                        .build();

        //action.
        String actualTitle = field.getTitle();

        //assert.
        Assert.assertNull(actualTitle);
    }

    @Test
    public void getType_outcomeIs_TypeRetrieved() {

        //arrange.
        final String name = "nameTest";
        final FieldType type = FieldType.TEXT;
        Field field =
                this.fieldBuilder
                        .type(type)
                        .name(name)
                        .build();

        //action.
        FieldType actualType = field.getType();

        //assert.
        Assert.assertEquals(type, actualType);
    }

    @Test
    public void getValue_outcomeIs_ValueRetrieved() {

        //arrange.
        final FieldValue.Builder<String> fieldValueBuilder =
                new FieldValue.Builder<String>();

        final String name = "nameTest";
        final FieldValue<String> valueAsString =
                fieldValueBuilder
                        .value("value")
                        .build();

        List<FieldValue<String>> valueList =
                new ArrayList<>();

        valueList.add(valueAsString);

        Field<List<FieldValue<String>>> field =
                this.fieldBuilder
                        .value(valueList)
                        .name(name)
                        .build();

        //action.
        List<FieldValue<String>> actualListOfFieldValues =
                field.getValue();

        //assert.
        Assert.assertEquals(valueList, actualListOfFieldValues);
    }

    @Test
    public void equals_instancesAreEqualWithNulls_outcomeIs_true(){

        //arrange.
        final String name = "testName";

        Field<List<FieldValue<String>>> field1 = this.fieldBuilder
            .name(name)
            .build();

        this.fieldBuilder.clear();

        Field<List<FieldValue<String>>> field2 = this.fieldBuilder
            .name(name)
            .build();

        //action.
        boolean areEqual = field1.equals(field2);

        //assert.
        Assert.assertTrue(areEqual);
    }

    @Test
    public void equals_instancesAreEqual_outcomeIs_true(){

        //arrange.
        final String value = "testValue";
        final Boolean isSelected = true;
        final String name = "testName";
        final String title = "testTitle";
        final FieldType type = FieldType.HIDDEN;

        FieldValue.Builder<String> fieldValueBuilder =
            new FieldValue.Builder<String>();

        FieldValue<String> fieldValue =
            fieldValueBuilder
                .value(value)
                .selected(isSelected)
                .title(title)
                .build();

        List<FieldValue<String>> fieldValueList =
            new ArrayList<FieldValue<String>>();
        fieldValueList.add(fieldValue);

        Field<List<FieldValue<String>>> field1 = this.fieldBuilder
            .title(title)
            .value(fieldValueList)
            .name(name)
            .type(type)
            .build();

        this.fieldBuilder.clear();

        Field<List<FieldValue<String>>> field2 = this.fieldBuilder
            .title(title)
            .value(fieldValueList)
            .name(name)
            .type(type)
            .build();

        //action.
        boolean areEqual = field1.equals(field2);

        //assert.
        Assert.assertTrue(areEqual);
    }

    @Test
    public void equals_instanceIsNull_outcomeIs_false(){

        //arrange.
        final String value = "testValue";
        final Boolean isSelected = true;
        final String name = "testName";
        final String title = "testTitle";
        final FieldType type = FieldType.HIDDEN;

        FieldValue.Builder<String> fieldValueBuilder =
            new FieldValue.Builder<String>();

        FieldValue<String> fieldValue =
            fieldValueBuilder
                .value(value)
                .selected(isSelected)
                .title(title)
                .build();

        List<FieldValue<String>> fieldValueList =
            new ArrayList<FieldValue<String>>();
        fieldValueList.add(fieldValue);

        Field<List<FieldValue<String>>> field1 = this.fieldBuilder
            .title(title)
            .value(fieldValueList)
            .name(name)
            .type(type)
            .build();

        Field<List<FieldValue<String>>> field2 = null;

        //action.
        boolean areEqual = field1.equals(field2);

        //assert.
        Assert.assertFalse(areEqual);
    }

    @Test
    public void equals_mismatchingClass_outcomeIs_false(){

        //arrange.
        final String value = "testValue";
        final Boolean isSelected = true;
        final String name = "testName";
        final String title = "testTitle";
        final FieldType type = FieldType.HIDDEN;

        FieldValue.Builder<String> fieldValueBuilder =
            new FieldValue.Builder<String>();

        FieldValue<String> fieldValue =
            fieldValueBuilder
                .value(value)
                .selected(isSelected)
                .title(title)
                .build();

        List<FieldValue<String>> fieldValueList =
            new ArrayList<FieldValue<String>>();
        fieldValueList.add(fieldValue);

        Field<List<FieldValue<String>>> field1 = this.fieldBuilder
            .title(title)
            .value(fieldValueList)
            .name(name)
            .type(type)
            .build();

        this.fieldBuilder.clear();

        Object field2 = new Object();

        //action.
        boolean areEqual = field1.equals(field2);

        //assert.
        Assert.assertFalse(areEqual);
    }

    @Test
    public void equals_instancesAreNotEqual_outcomeIs_false(){

        //arrange.
        final String value = "testValue";
        final Boolean isSelected = true;
        final String name = "testName";
        final String otherName = "otherTestName";
        final String title = "testTitle";
        final FieldType type = FieldType.HIDDEN;

        FieldValue.Builder<String> fieldValueBuilder =
            new FieldValue.Builder<String>();

        FieldValue<String> fieldValue =
            fieldValueBuilder
                .value(value)
                .selected(isSelected)
                .title(title)
                .build();

        List<FieldValue<String>> fieldValueList =
            new ArrayList<FieldValue<String>>();
        fieldValueList.add(fieldValue);

        Field<List<FieldValue<String>>> field1 = this.fieldBuilder
            .title(title)
            .value(fieldValueList)
            .name(name)
            .type(type)
            .build();

        this.fieldBuilder.clear();

        Field<List<FieldValue<String>>> field2 = this.fieldBuilder
            .title(title)
            .value(fieldValueList)
            .name(otherName) //names are different.
            .type(type)
            .build();

        //action.
        boolean areEqual = field1.equals(field2);

        //assert.
        Assert.assertFalse(areEqual);
    }

    @Test
    public void hashCode_outcomeIs_hashCodeGenerated(){

        //arrange.
        final int PRIME = 31;
        int expectedHashCode = 1;
        final String value = "testValue";
        final Boolean isSelected = true;
        final String name = "testName";
        final String title = "testTitle";
        final FieldType type = FieldType.HIDDEN;

        FieldValue.Builder<String> fieldValueBuilder =
            new FieldValue.Builder<String>();

        FieldValue<String> fieldValue =
            fieldValueBuilder
                .value(value)
                .selected(isSelected)
                .title(title)
                .build();

        List<FieldValue<String>> fieldValueList =
            new ArrayList<FieldValue<String>>();
        fieldValueList.add(fieldValue);

        Field<List<FieldValue<String>>> field = this.fieldBuilder
            .title(title)
            .value(fieldValueList)
            .name(name)
            .type(type)
            .build();

        expectedHashCode *= PRIME + field.getTitle().hashCode();
        expectedHashCode *= PRIME + field.getType().hashCode();
        expectedHashCode *= PRIME + field.getName().hashCode();
        expectedHashCode *= PRIME + field.getValue().hashCode();

        //action.
        int actualHashCode = field.hashCode();

        //assert.
        Assert.assertEquals(expectedHashCode, actualHashCode);
    }

    @Test
    public void hashCode_membersAreNull_outcomeIs_hashCodeGenerated(){

        //arrange.
        final int PRIME = 31;
        int expectedHashCode = 1;
        final String name = "testName";

        Field<List<FieldValue<String>>> field = this.fieldBuilder
            .name(name)
            .build();

        expectedHashCode *= PRIME + field.getName().hashCode();

        //action.
        int actualHashCode = field.hashCode();

        //assert.
        Assert.assertEquals(expectedHashCode, actualHashCode);
    }

    @After
    public void tearDown(){
        this.fieldBuilder = null;
    }
}
