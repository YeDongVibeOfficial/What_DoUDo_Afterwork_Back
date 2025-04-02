package afterwork.backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import afterwork.backend.domain.SendInformDomain;
import afterwork.backend.mapper.SendInformMapper;

@Service
public class SendInformService {
    private final SendInformMapper sendInformMapper;

    public SendInformService(SendInformMapper sendInformMapper) {
        this.sendInformMapper = sendInformMapper;
    }

    // public List<SendInformDomain> getAllSendInform() {
    //     return sendInformMapper.getAllSendInform();
    // }
    public List<SendInformDomain> getAllSendInform() {
        List<SendInformDomain> sendInformList = sendInformMapper.getAllSendInform();
        return sendInformList;
    }
    
}
