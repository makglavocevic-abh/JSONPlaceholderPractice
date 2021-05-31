package starter.objects;

public interface EndpointPath {

    String specificUser = "/users/{Id}";

    String specificPost = "/posts/{Id}";

    String specificComment = "/comments/{Id}";

    String specificAlbum = "/albums/{Id}";

    String specificPhoto = "/photos/{Id}";

    String specificTodos = "/todos/{Id}";

    String commentPOST = "/posts/{Id}/comments";

    String photosPOST = "/albums/{Id}/photos";

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

    String userAlbums = "/users/{Id}/albums";

    String userPosts = "/users/{Id}/posts";

    String userTodos = "/users/{Id}/todos";

}
