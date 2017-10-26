package pl.extra.extra;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/")
    public String hello() {
        return "hello";
    }

    @PostMapping("/sayHello")
    public SlackResponse sayHelloToSlack(@ModelAttribute SlackRequest slackRequest) {
        slackRequest.getText();
        return new SlackResponse();
    }
}
