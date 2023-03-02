package com.producter.basketballcard.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

import com.producter.basketballcard.model.Player;
import com.producter.basketballcard.model.Response.ErrorResponseModel;
import com.producter.basketballcard.model.Response.SuccessResponseModel;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureGraphQlTester
public class PlayerControllerTest {

    @Autowired 
    GraphQlTester graphQlTester;

    @Test
    void testAddPlayer() {
        // language=GraphQL
        String gMutation = """
            mutation {
                addPlayer(name: \"kobe\", surname: \"bryant\", position: 1){
                    __typename ... on SuccessResponseModel {
                        data{
                            id
                            name
                            surname
                            position{
                                id
                                name
                                shortName
                            }
                        }
                    }
                
                    __typename ... on ErrorResponseModel {
                        errorMessage
                    }
                }
            }   
        """;

        graphQlTester.document(gMutation)
        .execute().path("addPlayer").entity(SuccessResponseModel.class)
        .satisfies(
            response -> {
                assertTrue(!response.getError());
            }
        );
    }
    @Test
    void testFindAllPlayers() {
        // language=GraphQL
        String gQuery = """
            query {
                findAllPlayers{
                  id
                  name
                  surname
                  position{
                      id
                      name
                      shortName
                  }
                }
            }    
        """;
       var players = graphQlTester.document(gQuery).execute().path("findAllPlayers").entityList(Player.class);
       assertNotNull(players);
    }

    @Test
    void testDeletePlayer() {
         // language=GraphQL
         String gMutation = """
            mutation {
                deletePlayer(id: 0){
                    __typename ... on ErrorResponseModel {
                        error
                        errorMessage
                    }
                }   
            }
        """;

        graphQlTester.document(gMutation)
        .execute().path("deletePlayer").entity(ErrorResponseModel.class)
        .satisfies(
            response -> {
                assertTrue(response.getError());
            }
        );    }


}
