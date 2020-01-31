package mybatis_study_teacher.services;

import mybatis_study_teacher.dto.Tutor;
import mybatis_study_teacher.mappers.TutorMapperImpl;

public class TutorUIService {
	private TutorMapperImpl tutorMapper;
	
	public TutorUIService() {
		tutorMapper = TutorMapperImpl.getInstance();
	}

	public Tutor showTutors(Tutor tutor) {
		return tutorMapper.selectTutorByTutorId(tutor);
	}
	
	public void addTutor(Tutor tutor) {
		tutorMapper.insertTutor(tutor);
	}
	
	public void removeTutor(int tutorId) {
		tutorMapper.deleteTutor(tutorId);
	}
	
}
