package com.anassdevops.quiz;

import java.util.ArrayList;
import java.util.stream.Stream;

import com.anassdevops.quiz.dto.AppUserDto;
import com.anassdevops.quiz.entity.*;
import com.anassdevops.quiz.service.AuthService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.anassdevops.quiz.repository.CategoryRepository;
import com.anassdevops.quiz.repository.QuestionRepository;
import com.anassdevops.quiz.repository.QuizRepository;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@SpringBootApplication
@AllArgsConstructor
public class Application implements CommandLineRunner {
	
	CategoryRepository categoryRepository;
	QuizRepository quizRepository;
	QuestionRepository questionRepository;

	AuthService authService;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

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
		
		Category c = categoryRepository.findById(1L).get();
		Quiz quiz = new Quiz();
		quiz.setTitle("Core Java Quiz");
		quiz.setDescription("Core Java Quiz");
		quiz.setDetails("There are a list of core java quizzes such as basics quiz, oops quiz, string handling quiz, array quiz, exception handling quiz, collection framework quiz");
		quiz.setCategory(c);
		Quiz qu = quizRepository.save(quiz);
		
		Question question = new Question();
		question.setQuiz(qu);
		question.setDescription("What is a correct syntax to output \"Hello World\" in Java?");
		question.setOption1("Console.WriteLine(\"Hello World\");");
		question.setOption2("System.out.println(\"Hello World\");");
		question.setOption3("echo(\"Hello World\");");
		question.setOption4("print (\"Hello World\");");
		question.setCorrectAnswer(CorrectAnswer.option2);
		questionRepository.save(question);

		Question question1 = new Question();
		question1.setQuiz(qu);
		question1.setDescription("How do you insert COMMENTS in Java code?");
		question1.setOption1("// This is a comment");
		question1.setOption2("/* This is a comment");
		question1.setOption3("# This is a comment");
		question1.setOption4("*/ This is a comment");
		question1.setCorrectAnswer(CorrectAnswer.option1);
		questionRepository.save(question1);

		question1 = new Question();
		question1.setQuiz(qu);
		question1.setDescription("Which data type is used to create a variable that should store text?");
		question1.setOption1("Txt");
		question1.setOption2("string");
		question1.setOption3("String");
		question1.setOption4("myString");
		question1.setCorrectAnswer(CorrectAnswer.option3);
		questionRepository.save(question1);

		question1 = new Question();
		question1.setQuiz(qu);
		question1.setDescription("How do you create a variable with the numeric value 5?");
		question1.setOption1("x = 5;");
		question1.setOption2("float x = 5;");
		question1.setOption3("num x = 5");
		question1.setOption4("int x = 5;");
		question1.setCorrectAnswer(CorrectAnswer.option4);
		questionRepository.save(question1);

		question1 = new Question();
		question1.setQuiz(qu);
		question1.setDescription("How do you create a variable with the floating number 2.8?");
		question1.setOption1("x = 2.8f;");
		question1.setOption2("byte x = 2.8f");
		question1.setOption3("float x = 2.8f;");
		question1.setOption4("int x = 2.8f;");
		question1.setCorrectAnswer(CorrectAnswer.option3);
		questionRepository.save(question1);

		AppUserDto appUser1 = new AppUserDto("admin", "1234", "1234");
		AppUserDto appUser2 = new AppUserDto("user1", "1234", "1234");
		AppUserDto appUser3 = new AppUserDto("user2", "1234", "1234");
		authService.addAppUser(appUser1);
		authService.addAppUser(appUser2);
		authService.addAppUser(appUser3);

		AppRole appRole1 = new AppRole(null, "ADMIN", new ArrayList<>());
		AppRole appRole2 = new AppRole(null, "USER", new ArrayList<>());
		AppRole appRole3 = new AppRole(null, "CONSUMER", new ArrayList<>());
		authService.addAppRole(appRole1);
		authService.addAppRole(appRole2);
		authService.addAppRole(appRole3);

		authService.addRoleToUser("ADMIN","admin");
		authService.addRoleToUser("USER","admin");
		authService.addRoleToUser( "CONSUMER","admin");
		authService.addRoleToUser("USER", "user1");
		authService.addRoleToUser("USER", "user2");
	}
	
	

}
