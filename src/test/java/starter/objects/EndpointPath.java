package starter.objects;

public interface EndpointPath {

    String NEW_USERS_ENDPOINT = "https://jsonplaceholder.typicode.com/users/{Id}";

    String NEW_POST_ENDPOINT = "https://jsonplaceholder.typicode.com/posts/{Id}";

    String NEW_COMMENT_ENDPOINT = "https://jsonplaceholder.typicode.com/comments/{Id}";

    String NEW_ALBUM_ENDPOINT = "https://jsonplaceholder.typicode.com/albums/{Id}";

    String NEW_PHOTOS_ENDPOINT = "https://jsonplaceholder.typicode.com/photos/{Id}";

    String POSTS_COMMENTS_ENDPOINT = "https://jsonplaceholder.typicode.com/posts/{Id}/comments";

    String ALBUMS_PHOTOS_ENDPOINT = "https://jsonplaceholder.typicode.com/albums/{Id}/photos";

    String NEW_USER_BODY = "src/test/java/resources/validusersbody.json";

    String NEW_COMMENTS_BODY = "src/test/java/resources/validcommentsbody.json";

    String NEW_POSTS_BODY = "src/test/java/resources/validpostsbody.json";

    String NEW_ALBUM_BODY = "src/test/java/resources/validalbumsbody.json";

    String NEW_PHOTOS_BODY = "src/test/java/resources/validphotosbody.json";

    String USERS_ENDPOINT = "https://jsonplaceholder.typicode.com/users";

    String ALBUMS_ENDPOINT = "https://jsonplaceholder.typicode.com/albums";

    String POSTS_ENDPOINT = "https://jsonplaceholder.typicode.com/posts";

    String USERS_ONE_ALBUMS_ENDPOINT = "https://jsonplaceholder.typicode.com/users/{Id}/albums";

    String USERS_ONE_POSTS_ENDPOINT = "https://jsonplaceholder.typicode.com/users/{Id}/posts";

    String USERS_ONE_TODOS_ENDPOINT = "https://jsonplaceholder.typicode.com/users/{Id}/todos";

    String POST_ENDPOINT = "https://jsonplaceholder.typicode.com/posts/{Id}";

    String ALBUM_ENDPOINT = "https://jsonplaceholder.typicode.com/albums/{Id}";
}
