import java.time.LocalDateTime;
import java.util.ArrayList;

public class Post {
    private String title;
    private String titleDescription;
    private String content;
    private boolean published;
    private LocalDateTime createdAt;
    private int id;
    private static ArrayList<Post> instances = new ArrayList<Post>();
    public Post(String title,String titleDescription, String content){
       this.title=title;
       this.titleDescription=titleDescription;
       this.content = content;
       this.published=false;
       this.createdAt=LocalDateTime.now();
       instances.add(this);
       this.id=instances.size();
    }
    public static ArrayList<Post> getAll(){
        return instances;
    }
    public static void clearAllPost(){
        instances.clear();
    }
    public boolean getPublished(){
        return this.published;
    }
    public String getTitle(){
        return title;
    }
    public String getTitleDescription(){
        return titleDescription;
    }
    public String getContent(){
        return content;
    }
    public LocalDateTime getCreatedAt(){
        return createdAt;
    }
    public int getId(){
        return id;
    }
    public static Post findById(int id){
        return instances.get(id-1);
    }
}
