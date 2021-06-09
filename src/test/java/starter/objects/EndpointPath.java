package starter.objects;

public interface EndpointPath {

    String specificUser = "/users/{id}";

    String specificPost = "/posts/{id}";

    String specificComment = "/comments/{id}";

    String specificAlbum = "/albums/{id}";

    String specificPhoto = "/photos/{id}";

    String specificTodos = "/todos/{id}";

    String commentPOST = "/posts/{id}/comments";

    String photosPOST = "/albums/{id}/photos";

    String userBody = "src/test/java/resources/validusersbody.json";

    String commentBody = "src/test/java/resources/validcommentsbody.json";

    String postsBody = "src/test/java/resources/validpostsbody.json";

    String albumsBody = "src/test/java/resources/validalbumsbody.json";

    String photosBody = "src/test/java/resources/validphotosbody.json";

    String todosBody = "src/test/java/resources/validtodosbody.json";

    String todosChangeStatusBody = "src/test/java/resources/todocompleted.json";

    String usersEndpoint = "/users";

    String todosEndpoint = "/todos";

    String albumsEndpoint = "/albums";

    String postsEndpoint = "/posts";

    String userAlbums = "/users/{id}/albums";

    String userPosts = "/users/{id}/posts";

    String userTodos = "/users/{id}/todos";

}
