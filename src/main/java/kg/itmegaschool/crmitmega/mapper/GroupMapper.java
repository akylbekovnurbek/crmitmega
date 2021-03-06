package kg.itmegaschool.crmitmega.mapper;

import kg.itmegaschool.crmitmega.model.dto.GroupDto;
import kg.itmegaschool.crmitmega.model.entity.Group;
import org.mapstruct.factory.Mappers;

public interface GroupMapper extends BaseMapper<Group, GroupDto> {
    GroupMapper INSTANCE = Mappers.getMapper(GroupMapper.class);
}
