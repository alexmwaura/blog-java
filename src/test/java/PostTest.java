import org.junit.*;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class PostTest {
    @Test
    public void getInstance_returnIsInstanceOfPost_true(){
        Post myPost = new Post("blog1","the first blog","its a simple test blog");
        assertEquals(true,myPost instanceof Post);
    }
    @Test
    public void getPublished_isFalseAfterInstantiation_false() throws Exception{
        Post myPost = new Post("blog1","the first blog","its a simple test blog");
        assertEquals(false,myPost.getPublished());
    }
    @Test
    public void getCreatedAt_instantiatesWithCurrentTime_today(){
        Post myPost = setUpNewPost();
        assertEquals(LocalDateTime.now().getDayOfWeek(),myPost.getCreatedAt().getDayOfWeek());
    }
    public Post setUpNewPost(){
        return new Post("blog1","the first blog","its a simple test blog");
    }
    @Test
    public void getId_postInstantiateWithAnId_1(){
        Post.clearAllPost();
        Post myPost = setUpNewPost();
        assertEquals(1,myPost.getId());
    }
    @Test
    public void findReturnsCorrectPost() throws Exception {
        Post post = setUpNewPost();
        assertEquals(1, Post.findById(post.getId()).getId());
    }
    @Test
    public void findReturnsCorrectPostWhenMoreThanOnePostExists() throws Exception {
        Post post = setUpNewPost();
        Post myPost = new Post("blog2","the second blog","its a simple test blog twice");
        assertEquals(2, Post.findById(myPost.getId()).getId());
    }
}