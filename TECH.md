## Types

    type Player {
        id: ID!
        name: String!
        surname: String!
        position: Position!
    }

    type Position {
        id: ID!
        name: String!
        shortName: String!
    }

Position IDs are static values. PositionID list:

    1: Point guard
    2: Shooting guard 
    3: Small forward
    4: Power forward
    5: Center

## Query

    findAllPlayers(): [Player]


## Mutation

    addPlayer(name: String!, surname: String!, position: ID!): BaseResponseModel!
    deletePlayer(id: ID!): BaseResponseModel!


## ResponseModels

    record BaseResponseModel(boolean error);

    record SuccessResponseModel(data: Player[]) extends BaseResponseModel

    record ErrorResponseModel(errorMessage: String) extends BaseResponseModel


Lifecycle

    Client -> Controller
    Controller -> Resolver 
    Resolver -> Service
    Service -> Repository
    Repository <-> Entity | EntityList
    Repository --> Service
    Service --> Resolver
    Resolver --> Controller
    Controller --> Client


## Unit Tests
Unit tests run on same db. It can do run on H2 when testing but was not necessary for that

based on this source for test:
`https://docs.spring.io/spring-graphql/docs/1.1.3-SNAPSHOT/reference/html/#testing`