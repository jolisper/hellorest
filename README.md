# hellorest

Ejemplos de rest en distintos lenguajes

### Rules
    URI = scheme "://" authority "/" path [ "?" query ] [ "#" fragment ]


- Forward slash separator (/) must be used to indicate a hierarchical relationship
- Hyphens (-) should be used to improve the readability of URIs
- Underscores (_) should not be used in URIs
- Lowercase letters should be preferred in URI paths
- File extensions should not be included in URIs
- Use verbs GET POST PUT DELETE
- Collections in plural: places != place

### Example

      http://api.soccer.restapi.org/places/seattle
      http://api.soccer.restapi.org/places/seattle/teams/someteam
      http://api.soccer.restapi.org/places/seattle/teams/someteam/players/pepe

      http://api.soccer.restapi.org/places/seattle?teams=someteam&page=2

### Concrete Usage

    GET  /textos
    GET  /textos/:id
    PUT  /textos/:id texto=abc
    POST /textos texto=abc
    DELETE /textos/:id
