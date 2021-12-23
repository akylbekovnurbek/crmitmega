package kg.itmegaschool.crmitmega.service;

import kg.itmegaschool.crmitmega.model.dto.CourseDto;
import kg.itmegaschool.crmitmega.model.dto.MentorDto;
import kg.itmegaschool.crmitmega.model.request.CourseCreateRequest;
import kg.itmegaschool.crmitmega.model.request.CreateMentorRequest;
import org.springframework.stereotype.Service;

@Service
public interface MentorService {
    MentorDto create(CreateMentorRequest request);

    MentorDto read(Long id);

    MentorDto update(MentorDto mentorDto);

    void delete(Long id);
}
