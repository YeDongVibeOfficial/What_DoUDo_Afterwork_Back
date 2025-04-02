package afterwork.backend.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import afterwork.backend.domain.SendInformDomain;

@Mapper
public interface  SendInformMapper {
    List<SendInformDomain> getAllSendInform();
}
