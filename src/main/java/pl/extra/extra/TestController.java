package pl.extra.extra;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    SlackRequestRepo requestRepo;
    List<SlackResponseDto> responseDtos = new ArrayList<>();

    @RequestMapping("/")
    public String hello() {
        return "hello";
    }

    @PostMapping("/sayHello")
    public SlackResponse sayHelloToSlack(@ModelAttribute SlackRequest slackRequest) {
        SlackResponse slackResponse = new SlackResponse();
        SlackResponseDto slackResponseDto = new SlackResponseDto();
        slackResponse.setText(slackRequest.getText());
        slackResponseDto.setText(slackRequest.getText());
        responseDtos.add(slackResponseDto);
        requestRepo.save(slackRequest);
        return slackResponse;
    }

    @GetMapping("/request")
    public List<SlackResponseDto> getRequests() {
        return responseDtos;
    }

    @GetMapping("/slackRequest")
    public List<SlackRequest> getSlackRequests() {
        return requestRepo.findAll();
    }
}
