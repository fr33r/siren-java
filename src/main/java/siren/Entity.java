package siren;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jonfreer
 * @since 8/13/17
 */
public class Entity extends EntityBase{

    public static class Builder implements siren.Builder<Entity>{

        private List<String> classes;
        private Map<String, Object> properties;
        private List<Action> actions;
        private List<Link> links;
        private List<EntityBase> subEntities;
        private String title;

        public Builder klass(String className){
            if(this.classes == null) {
                this.classes = new ArrayList<String>();
            }
            this.classes.add(className);
            return this;
        }

        public Builder klasses(List<String> classNames){
            if(this.classes == null) {
                this.classes = new ArrayList<String>();
            }
            this.classes.addAll(classNames);
            return this;
        }

        List<String> getKlasses(){
            return this.classes;
        }

        public <T> Builder property(String propertyKey, T propertyValue){
            if(this.properties == null){
                this.properties = new HashMap<String, Object>();
            }
            this.properties.put(propertyKey, propertyValue);
            return this;
        }

        public Builder properties(Map<String, Object> properties){
            if(this.properties == null){
                this.properties = new HashMap<String, Object>();
            }
            this.properties.putAll(properties);
            return this;
        }

        Map<String, Object> getProperties(){
            return this.properties;
        }

        public Builder action(Action action){
            if(this.actions == null){
                this.actions = new ArrayList<Action>();
            }
            this.actions.add(action);
            return this;
        }

        public Builder actions(List<Action> actions){
            if(this.actions == null){
                this.actions = new ArrayList<>();
            }
            this.actions.addAll(actions);
            return this;
        }

        List<Action> getActions(){
            return this.actions;
        }

        public Builder link(Link link){
            if(this.links == null){
                this.links = new ArrayList<Link>();
            }
            this.links.add(link);
            return this;
        }

        public Builder links(List<Link> links){
            if(this.links == null){
                this.links = new ArrayList<>();
            }
            this.links.addAll(links);
            return this;
        }

        List<Link> getLinks(){
            return this.links;
        }

        public Builder subEntity(EntityBase subEntity){
            if(this.subEntities == null){
                this.subEntities = new ArrayList<>();
            }
            this.subEntities.add(subEntity);
            return this;
        }

        List<EntityBase> getSubEntities(){
            return this.subEntities;
        }

        public Builder title(String title){
            this.title = title;
            return this;
        }

        String getTitle(){
            return this.title;
        }

        /**
         * Clears the state of the builder.
         */
        @Override
        public void clear() {
            this.classes = null;
            this.properties = null;
            this.actions = null;
            this.links = null;
            this.title = null;
            this.subEntities = null;
        }

        /**
         * Constructs an instance with the
         * current state of the builder.
         *
         * @return Instance with the current state of the builder.
         */
        @Override
        public Entity build() {
            return new Entity(this.classes, this.properties, this.actions, this.links, this.title, this.subEntities);
        }
    }

    private Map<String, Object> properties;
    private List<Action> actions;
    private List<Link> links;
    private List<EntityBase> subEntities;

    Entity(){
        super();
        this.properties = new HashMap<String, Object>();
        this.actions = new ArrayList<Action>();
        this.links = new ArrayList<Link>();
        this.subEntities = new ArrayList<EntityBase>();
    }

    Entity(
        List<String> classes,
        Map<String,
        Object> properties,
        List<Action> actions,
        List<Link> links,
        String title,
        List<EntityBase> subEntities
    ){
        super(classes, title);
        this.properties = properties;
        this.actions = actions;
        this.links = links;
        this.subEntities = subEntities;
    }

    public Map<String, Object> getProperties(){
        if(this.properties == null) return this.properties;
        Map<String, Object> propertiesCopy = new HashMap<String, Object>();
        propertiesCopy.putAll(this.properties);
        return propertiesCopy;
    }

    public List<Action> getActions(){
        if(this.actions == null) return this.actions;
        List<Action> actionsCopy = new ArrayList<Action>();
        actionsCopy.addAll(this.actions);
        return actionsCopy;
    }

    public List<Link> getLinks(){
        if(this.links == null) return this.links;
        List<Link> linksCopy = new ArrayList<Link>();
        linksCopy.addAll(this.links);
        return linksCopy;
    }

    public List<EntityBase> getEntities(){
        if(this.subEntities == null) return this.subEntities;
        List<EntityBase> subEntitiesCopy = new ArrayList<EntityBase>();
        subEntitiesCopy.addAll(this.subEntities);
        return subEntitiesCopy;
    }

    public boolean equals(Object obj){
        if(obj == null || this.getClass() != obj.getClass()) return false;

        Entity entity = (Entity)obj;

        boolean superIsEqual = super.equals(entity);
        boolean sameProperties = this.properties.equals(entity.properties);
        boolean sameActions = this.actions.equals(entity.actions);
        boolean sameLinks = this.links.equals(entity.links);

        return superIsEqual && sameProperties && sameActions && sameLinks;
    }

    public int hashCode(){

        final int prime = 31;
        int hashCode = 1;

        hashCode = super.hashCode();

        if(this.properties != null){
            hashCode *= prime + this.properties.hashCode();
        }

        if(this.actions != null){
            hashCode *= prime + this.actions.hashCode();
        }

        if(this.links != null){
            hashCode *= prime + this.links.hashCode();
        }

        return hashCode;
    }

}
