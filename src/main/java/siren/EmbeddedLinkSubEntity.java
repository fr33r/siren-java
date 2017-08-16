package siren;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jonfreer
 * @since 8/13/17
 */
public class EmbeddedLinkSubEntity extends EntityBase {

    public static class Builder {

        private List<String> rel;
        private String href;
        private String type;
        private List<String> classes;
        private String title;

        public Builder klass(String className){
            if(this.classes == null){
                this.classes = new ArrayList<>();
            }
            this.classes.add(className);
            return this;
        }

        public Builder klasses(List<String> classNames){
            if(this.classes == null){
                this.classes = new ArrayList<>();
            }
            this.classes.addAll(classNames);
            return this;
        }

        public Builder title(String title){
            this.title = title;
            return this;
        }

        public Builder rel(String rel){
            if(this.rel == null){
                this.rel = new ArrayList<>();
            }
            this.rel.add(rel);
            return this;
        }

        public Builder type(String type){
            this.type = type;
            return this;
        }

        public Builder href(String href) throws URISyntaxException {
            this.href = new URI(href).toString();
            return this;
        }

        public Builder href(URI href) {
            this.href = href.toString();
            return this;
        }

        public EmbeddedLinkSubEntity build() {
            return new EmbeddedLinkSubEntity(this.classes, this.title, this.rel, this.href, this.type);
        }
    }

    private List<String> rel;
    private String href;
    private String type;

    public EmbeddedLinkSubEntity(List<String> classes, String title, List<String> rel, String href, String type){
        super(classes, title);
        this.rel = rel;
        this.href = href;
        this.type = type;
    }

    public List<String> getRel(){
        return this.rel;
    }

    public String getHref(){
        return this.href;
    }

    public String getType(){
        return this.type;
    }
}
