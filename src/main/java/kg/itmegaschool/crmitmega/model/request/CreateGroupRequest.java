package kg.itmegaschool.crmitmega.model.request;

import kg.itmegaschool.crmitmega.model.entity.Course;
import kg.itmegaschool.crmitmega.model.entity.Mentor;
import kg.itmegaschool.crmitmega.model.entity.Student;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalTime;
import java.util.List;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CreateGroupRequest {
    Long mentorId;
    Long courseId;
    String groupName;

    List<Student> students;
    LocalTime classTime;
}
