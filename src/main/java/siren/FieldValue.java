package siren;

/**
 * @author jonfreer
 * @since 8/13/17
 */
public class FieldValue<T> {

    public static class Builder<T> {

        private String title;
        private T value;
        private boolean selected;

        public FieldValue<T> build(){
            if (this.value == null){
                //throw.
            }
            return new FieldValue<T>(this.title, this.value, this.selected);
        }
    }

    private String title;
    private T value;
    private boolean selected;

    public FieldValue(T value){
        this.value = value;
    }

    public FieldValue(String title, T value, boolean selected){
        this.title = title;
        this.value = value;
        this.selected = selected;
    }

    public String getTitle(){
        return this.title;
    }

    public T getValue(){
        return this.value;
    }

    public boolean getSelected(){
        return this.selected;
    }
}
