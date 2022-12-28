package com.anassdevops.quiz.service.imp;

import java.util.List;

import com.anassdevops.quiz.dto.QuestionDTO;
import com.anassdevops.quiz.entity.Quiz;
import com.anassdevops.quiz.repository.QuizRepository;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import com.anassdevops.quiz.entity.Question;
import com.anassdevops.quiz.repository.QuestionRepository;
import com.anassdevops.quiz.service.QuestionService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class QuestionServiceImp implements QuestionService{
	
	QuestionRepository questionRepository;
	QuizRepository quizRepository;

	@Override
	public List<Question> getQuestions() {
		return questionRepository.findAll();
	}

	@Override
	public Question addQuestion(QuestionDTO questionDTO) {
		Question question = new Question();
		question.setDescription(questionDTO.getDescription());
		question.setOption1(questionDTO.getOption1());
		question.setOption2(questionDTO.getOption2());
		question.setOption3(questionDTO.getOption3());
		question.setOption4(questionDTO.getOption4());
		question.setCorrectAnswer(questionDTO.getCorrectAnswer());
		Quiz quiz = quizRepository.findById(Long.parseLong(questionDTO.getQuizId())).get();
		question.setQuiz(quiz);
		return questionRepository.save(question);
	}

	@Override
	public Question updateQuestion(Question question) {
		Question q = questionRepository.findById(question.getId()).get();
		q.setDescription(question.getDescription());
		q.setOption1(question.getOption1());
		q.setOption2(question.getOption2());
		q.setOption3(question.getOption3());
		q.setOption4(question.getOption4());
		q.setCorrectAnswer(question.getCorrectAnswer());
		return questionRepository.save(q);
	}

	@Override
	public List<Question> getQuestionsByQuizId(String quizId) {
		return questionRepository.findByQuizId(Long.parseLong(quizId));
	}

	@Override
	public Question getQuestionsById(String id) {
		return questionRepository.findById(Long.parseLong(id)).get();
	}


}
