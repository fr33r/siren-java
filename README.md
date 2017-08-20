# siren-java 

[![Build Status](https://travis-ci.org/freerjm/siren-java.svg?branch=master)](https://travis-ci.org/freerjm/siren-java)

An Java implementation of Siren, which is a hypermedia specification for representing entities.

## Overview

Behold, a lightweight library enabling your Java applications to harness the power of Siren,
a hypermedia specification for representing entities.

## What is Siren?

Siren is a hypermedia specification that provides the ability to express entities, as well various
other features such as links, actions, sub-entities, and more. The Siren specification can be observed
in the author's [GitHub repository](https://github.com/kevinswiber/siren), or on
[HyperSchema](http://hyperschema.org/mediatypes/siren).

## Example Usage

```
// construct some factories.
EntityBuilderFactory entityBuilderFactory = new EntityBuilderFactory();
LinkBuilderFactory linkBuilderFactory = new LinkBuilderFactory();
ActionBuilderFactory actionBuilderFactory = new ActionBuilderFactory();
 
// construct some builders using factories.
Entity.Builder entityBuilder = entityBuilderFactory.create();
Link.Builder linkBuilder = linkBuilderFactory.create();
Action.Builder actionBuilder = actionBuilder.create();
 
// construct entity.
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
        .link(selfLink)
        .action(delete-guest)
        .build();
 
// ... serialize ...
```