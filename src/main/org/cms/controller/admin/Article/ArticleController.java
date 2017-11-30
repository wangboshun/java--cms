package cms.controller.admin.Article;

import cms.controller.ControllerBase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Article/")
public class ArticleController extends ControllerBase {


    @RequestMapping("Index")
    public String Index() {
        return "admin/article/article";
    }

    @RequestMapping("Add")
    public String Add() {
        return "admin/article/article-edit";
    }
}
