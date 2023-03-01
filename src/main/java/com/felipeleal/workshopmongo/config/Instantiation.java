package com.felipeleal.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.felipeleal.workshopmongo.domain.Post;
import com.felipeleal.workshopmongo.domain.User;
import com.felipeleal.workshopmongo.dto.AuthorDTO;
import com.felipeleal.workshopmongo.dto.CommentDTO;
import com.felipeleal.workshopmongo.repository.PostRepository;
import com.felipeleal.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
		
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");
		data.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User maria = new User(null,"Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Ferreira", "alex@gmail.com");
		User joao = new User(null, "João Colomarte", "joao@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, joao));
		
		Post post1 = new Post(null, data.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo, abraços", new AuthorDTO(maria));
		Post post2 = new Post(null, data.parse("23/03/2018"), "Bom dia", "Acordei muito puto hoje kkk", new AuthorDTO(joao));
		
		CommentDTO c1 = new CommentDTO("Salve carai!", data.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Momentos estravagantes!", data.parse("21/03/2018"), new AuthorDTO(joao));
		CommentDTO c3 = new CommentDTO("Curupira cabuloso", data.parse("21/03/2018"), new AuthorDTO(alex));
		
		post1.getComments().addAll(Arrays.asList(c1,c2));	
		post2.getComments().addAll(Arrays.asList(c3));	
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		
		userRepository.save(maria);
		
	}
	
}
