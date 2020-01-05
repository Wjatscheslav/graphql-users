package com.tarasenko.graphqlusers;

import java.io.File;
import java.net.URL;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;

@Component
public class GraphQLProvider
{
  private GraphQL graphQL;

  @Bean
  public GraphQL graphQL()
  {
    return graphQL;
  }

  @PostConstruct
  public void init() throws Exception
  {
    this.graphQL = buildGraphQL();
  }

  private GraphQL buildGraphQL() throws Exception
  {
    URL schemaUrl = this.getClass().getClassLoader().getResource("schema.graphqls");
    File schemaFile = new File(schemaUrl.toURI());
    GraphQLSchema graphQLSchema = buildSchema(schemaFile);

    return GraphQL.newGraphQL(graphQLSchema).build();
  }

  private GraphQLSchema buildSchema(File schema)
  {
    TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schema);
    SchemaGenerator generator = new SchemaGenerator();
    RuntimeWiring runtimeWiring = buildWiring();

    return generator.makeExecutableSchema(typeRegistry, runtimeWiring);
  }

  private RuntimeWiring buildWiring()
  {
    return RuntimeWiring.newRuntimeWiring().build();
  }

}
