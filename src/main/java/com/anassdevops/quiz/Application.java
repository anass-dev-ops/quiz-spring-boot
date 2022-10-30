package com.anassdevops.quiz;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anassdevops.quiz.entity.Category;
import com.anassdevops.quiz.entity.CorrectAnswer;
import com.anassdevops.quiz.entity.Question;
import com.anassdevops.quiz.entity.Quiz;
import com.anassdevops.quiz.repository.CategoryRepository;
import com.anassdevops.quiz.repository.QuestionRepository;
import com.anassdevops.quiz.repository.QuizRepository;

import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class Application implements CommandLineRunner {
	
	CategoryRepository categoryRepository;
	QuizRepository quizRepository;
	QuestionRepository questionRepository;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Stream.of("Programming", "general Knowlegde", "Mathematic").forEach(c -> {
			Category category = new Category();
			category.setName(c);
			category.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Ut eget rhoncus nibh, non viverra massa. Nullam rutrum tincidunt est at bibendum. Duis interdum dolor a sem lobortis interdum");
			categoryRepository.save(category);
		});	
		
//		Category c = categoryRepository.findById(1L).get();
//		Quiz quiz = new Quiz();
//		quiz.setTitle("Core Java Quiz");
//		quiz.setDescription("Core Java Quiz");
//		quiz.setDetails("There are a list of core java quizzes such as basics quiz, oops quiz, string handling quiz, array quiz, exception handling quiz, collection framework quiz");
//		quiz.setCategory(c);
//		Quiz qu = quizRepository.save(quiz);
//		
//		Question question = new Question();
//		question.setQuiz(qu);
//		question.setDescription("What is a correct syntax to output \"Hello World\" in Java?");
//		question.setOption1("Console.WriteLine(\"Hello World\");");
//		question.setOption2("System.out.println(\"Hello World\");");
//		question.setOption3("echo(\"Hello World\");");
//		question.setOption4("print (\"Hello World\");");
//		question.setCorrectAnswer(CorrectAnswer.option2);
//		questionRepository.save(question);
		
		
		
		
	}
	
	

}
