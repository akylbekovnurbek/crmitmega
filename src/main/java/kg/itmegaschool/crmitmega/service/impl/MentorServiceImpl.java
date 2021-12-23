package kg.itmegaschool.crmitmega.service.impl;

import kg.itmegaschool.crmitmega.exceptions.CourseNotFoundException;
import kg.itmegaschool.crmitmega.exceptions.MentorNotFoundException;
import kg.itmegaschool.crmitmega.mapper.CourseTypeMapper;
import kg.itmegaschool.crmitmega.mapper.MentorMapper;
import kg.itmegaschool.crmitmega.model.dto.MentorDto;
import kg.itmegaschool.crmitmega.model.entity.Mentor;
import kg.itmegaschool.crmitmega.model.request.CreateMentorRequest;
import kg.itmegaschool.crmitmega.repository.MentorRepository;
import kg.itmegaschool.crmitmega.service.MentorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MentorServiceImpl implements MentorService {

    @Autowired
    private final MentorRepository mentorRepository;

    @Override
    public MentorDto create(CreateMentorRequest request) {

        MentorDto mentorDto = MentorDto
                .builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .build();

      mentorDto.setId(mentorRepository.save(MentorMapper.INSTANCE.toEntity(mentorDto)).getId());
    return mentorDto;

    }

    @Override
    public MentorDto read(Long id) {
        return MentorMapper.INSTANCE.toDto(mentorRepository.findByIdAndIsDeletedFalse(id).orElseThrow(() -> new MentorNotFoundException("Mentor with id=" + id + " not found.")));

    }

    @Override
    public MentorDto update(MentorDto mentorDto) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }
}
