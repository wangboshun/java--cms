package cms.controller.admin;

import cms.controller.ControllerBase;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Admin/")
public class IndexController extends ControllerBase {

    @RequestMapping("Index")
    public String Index() {
        return "admin/index";
    }

    @RequestMapping("Welcome")
    public String Welcome() {
        return "admin/welcome";
    }

}
