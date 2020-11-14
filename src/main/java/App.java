import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;
public class App {
    public static void main(String[] args) {
        staticFileLocation("public");
        get("/",(req,res)->{
            ArrayList<Post> allPosts = Post.getAll();
            Map<String,Object> model =  new HashMap<String, Object>();
            model.put("posts",allPosts);
            return new ModelAndView(model,"index.hbs");
        },new HandlebarsTemplateEngine());
        get("/add-blog",(req,res)-> {
            Map<String,Object> model =  new HashMap<String, Object>();
            return new ModelAndView(model,"add-blog.hbs");
        },new HandlebarsTemplateEngine());
        post("/posts/new", (req,res)->{
            Map<String,Object> model=new HashMap<String, Object>();
            String title = req.queryParams("title");
            String titleDescription=req.queryParams("titleDescription");
            String content=req.queryParams("content");
            Post newPost = new Post(title,titleDescription,content);
            model.put("post",newPost);
            return new ModelAndView(model,"success.hbs");
        }, new HandlebarsTemplateEngine());
        get("/posts/new",(req,res)->{
          Map<String,Object> model = new HashMap<String, Object>();
          return  new ModelAndView(model,"add-blog.hbs");
        },new HandlebarsTemplateEngine());
    }
}
