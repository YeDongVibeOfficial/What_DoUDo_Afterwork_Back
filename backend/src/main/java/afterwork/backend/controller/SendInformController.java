package afterwork.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import afterwork.backend.domain.SendInformDomain;
import afterwork.backend.model.SendInformResponse;
import afterwork.backend.service.SendInformService;

@RestController
@RequestMapping("/sendInform")
public class SendInformController {
    private final SendInformService sendInformService;

    public SendInformController(SendInformService sendInformService) {
        this.sendInformService = sendInformService;
    }

    // @GetMapping("/list")
    // public List<SendInformDomain> getSendInformList() {
    //     return sendInformService.getAllSendInform();
    // }
    @GetMapping("/list")
    public ResponseEntity<SendInformResponse> getSendInformList() {
        List<SendInformDomain> sendInformList = sendInformService.getAllSendInform();
        System.out.println("Fetched Data: " + sendInformList);
        SendInformResponse response = new SendInformResponse("success", sendInformList);
        return ResponseEntity.ok(response);
    }
}
