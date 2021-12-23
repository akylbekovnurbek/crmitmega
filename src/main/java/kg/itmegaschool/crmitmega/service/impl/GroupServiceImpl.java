package kg.itmegaschool.crmitmega.service.impl;

import kg.itmegaschool.crmitmega.exceptions.MentorNotFoundException;
import kg.itmegaschool.crmitmega.mapper.CourseMapper;
import kg.itmegaschool.crmitmega.mapper.GroupMapper;
import kg.itmegaschool.crmitmega.mapper.MentorMapper;
import kg.itmegaschool.crmitmega.model.dto.CourseDto;
import kg.itmegaschool.crmitmega.model.dto.GroupDto;
import kg.itmegaschool.crmitmega.model.dto.MentorDto;
import kg.itmegaschool.crmitmega.model.entity.Group;
import kg.itmegaschool.crmitmega.model.request.CreateGroupRequest;
import kg.itmegaschool.crmitmega.repository.GroupRepository;
import kg.itmegaschool.crmitmega.service.CourseService;
import kg.itmegaschool.crmitmega.service.GroupService;
import kg.itmegaschool.crmitmega.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository groupRepository;
    private MentorService mentorService;
    private CourseService courseService;

    @Override
    public GroupDto create(CreateGroupRequest request) {

        MentorDto mentorDto = mentorService.read(request.getMentorId());
        CourseDto courseDto = courseService.read(request.getCourseId());

        Group group = Group
                .builder()
                .mentor(MentorMapper.INSTANCE.toEntity(mentorDto))
                .course(CourseMapper.INSTANCE.toEntity(courseDto))
                .groupName(request.getGroupName())
                .classTime(request.getClassTime())
                .build();

        groupRepository.save(group);
        return GroupMapper.INSTANCE.toDto(group);
    }
    @Override
    public GroupDto find(Long id){
        return GroupMapper.INSTANCE.toDto(groupRepository.findByIdAndIsDeletedFalse(id).orElseThrow(() -> new MentorNotFoundException("Mentor with id=" + id + " not found.")));
    }

}
