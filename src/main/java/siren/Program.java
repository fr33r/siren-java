package siren;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import siren.factories.*;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author jonfreer
 * @since 8/13/17
 */
public class Program {

    public static void main(String[] args) throws JsonProcessingException, URISyntaxException {

        //create builder factories.
        EntityBuilderFactory entityBuilderFactory =
            new EntityBuilderFactory();

        EmbeddedLinkSubEntityBuilderFactory embeddedLinkSubEntityBuilderFactory =
                new EmbeddedLinkSubEntityBuilderFactory();

        EmbeddedRepresentationSubEntityBuilderFactory embeddedRepSubEntityBuilderFactory =
                new EmbeddedRepresentationSubEntityBuilderFactory();

        LinkBuilderFactory linkBuilderFactory =
                new LinkBuilderFactory();

        ActionBuilderFactory actionBuilderFactory =
                new ActionBuilderFactory();

        FieldBuilderFactory fieldBuilderFactory =
                new FieldBuilderFactory();

        //construct builders.

        Entity.Builder entityBuilder =
               entityBuilderFactory.create();

        EmbeddedLinkSubEntity.Builder embeddedLinkSubEntityBuilder =
                embeddedLinkSubEntityBuilderFactory.create();

        EmbeddedRepresentationSubEntity.Builder embeddedRepSubEntityBuilder =
                embeddedRepSubEntityBuilderFactory.create();

        Link.Builder linkBuilder =
                linkBuilderFactory.create();

        Action.Builder actionBuilder =
                actionBuilderFactory.create();

        Field.Builder<String> fieldBuilder =
                fieldBuilderFactory.create();

        Field.Builder<String> orderNumberBuilder =
                new Field.Builder<String>();

        Field.Builder productCodeBuilder =
                new Field.Builder();

        Field.Builder quantityBuilder =
                new Field.Builder();
/*
        Link selfLink = null;
        Link previousLink = null;
        Link nextLink = null;
        Link selfLink2 = null;

        selfLink =
                linkBuilder
                    .rel("self")
                    .href(new URI("http://api.x.io/orders/42"))
                    .build();
        linkBuilder.clear();
        selfLink2 =
                linkBuilder
                        .rel("self")
                        .href(new URI("http://api.x.io/customers/pj123"))
                        .build();
        linkBuilder.clear();
        previousLink =
                linkBuilder
                        .rel("previous")
                        .href(new URI("http://api.x.io/orders/41"))
                        .build();
        linkBuilder.clear();
        nextLink =
                linkBuilder
                        .rel("next")
                        .href(new URI("http://api.x.io/orders/43"))
                        .build();

        Field<String> orderNumber =
            fieldBuilder
                    .name("orderNumber")
                    .type(FieldType.HIDDEN)
                    .value("42")
                    .build();

        fieldBuilder.clear();

        Field productCode =
                fieldBuilder
                        .name("productCode")
                        .type(FieldType.TEXT)
                        .build();

        fieldBuilder.clear();

        Field quantity =
                fieldBuilder
                        .name("quantity")
                        .type(FieldType.NUMBER)
                        .build();

        Action action1 =
                actionBuilder
                    .name("add-item")
                    .title("Add Item")
                    .method(HttpMethod.POST)
                    .href(new URI("http://api.x.io/orders/42/items"))
                    .type("application/x-www-form-urlencoded")
                    .field(orderNumber)
                    .field(productCode)
                    .field(quantity)
                    .build();

        EmbeddedLinkSubEntity subEntity1 =
            embeddedLinkSubEntityBuilder
                    .klass("items")
                    .klass("collection")
                    .rel("http://x.io/rels/order-items")
                    .href(new URI("http://api.x.io/orders/42/items"))
                    .build();

        EmbeddedRepresentationSubEntity subEntity2 =
                embeddedRepSubEntityBuilder
                    .rel("http://x.io/rels/customer")
                    .klass("info")
                    .klass("collection")
                    .property("customerId", "pj123")
                    .property("name", "Peter Joseph")
                    .link(selfLink2)
                    .build();

        Entity entity =
            entityBuilder
                    .klass("order")
                    .property("orderNumber", 42)
                    .property("itemCount", 3)
                    .property("status", "pending")
                    .subEntity(subEntity1)
                    .subEntity(subEntity2)
                    .action(action1)
                    .link(selfLink)
                    .link(previousLink)
                    .link(nextLink)
                    .build();
         */

        Link selfLink =
                linkBuilder
                        .rel("self")
                        .href(new URI("http://freer.ddns.net/api/guests/1000"))
                        .build();

        Action deleteAction =
                actionBuilder
                        .name("delete-guest")
                        .title("Delete Guest")
                        .method(HttpMethod.DELETE)
                        .href(new URI("http://freer.ddns.net/api/guests/1000"))
                        .build();

        Entity entity =
                entityBuilder
                        .klass("guest")
                        .property("firstName", "Jon")
                        .property("lastName", "Freer")
                        .link(selfLink)
                        .action(deleteAction)
                        .build();

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        System.out.println(mapper.writeValueAsString(entity));
    }
}
