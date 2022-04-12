import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
public class AdminController{

    @RequestMapping(value ={"/admin"}, method = RequestMethod.GET)
	public String getAdminPage() {
		return "admin";
	}
}