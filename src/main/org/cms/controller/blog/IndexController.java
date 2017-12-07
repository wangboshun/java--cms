package cms.controller.blog;

import cms.controller.ControllerBase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Blog/")
public class IndexController extends ControllerBase {

    @RequestMapping("Index")
    public String Index() {
        return "blog/index";
    }

}
