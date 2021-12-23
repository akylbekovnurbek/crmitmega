package kg.itmegaschool.crmitmega.service;

import kg.itmegaschool.crmitmega.model.dto.GroupDto;
import kg.itmegaschool.crmitmega.model.request.CreateGroupRequest;
import org.springframework.stereotype.Service;

@Service
public interface GroupService {
    GroupDto create (CreateGroupRequest request);
    GroupDto find (Long id);
}
