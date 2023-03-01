package com.felipeleal.workshopmongo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.felipeleal.workshopmongo.domain.Post;
import com.felipeleal.workshopmongo.resources.util.URL;
import com.felipeleal.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
	
	@Autowired
	private PostService postService;
		
	@GetMapping(value = "/{id}")
	public ResponseEntity<Post> findById(@PathVariable String id){
		Post obj = postService.findById(id);
		return ResponseEntity.ok().body(obj);		
	}
	 
	@GetMapping(value = "/titlesearch")  //RequestParam é um parametro de url com o valor value = x (ex: posts/tittlesearch? text = requestparam)
	public ResponseEntity<List<Post>> findByIdTitle(@RequestParam(value="text",defaultValue="") String text){  
		//decode é para decodificar a query vinda da URL (vem codificada para nao ter caracteres especiais)
		text = URL.decodeParam(text);
		List<Post> list = postService.findByTitle(text);
		return ResponseEntity.ok().body(list);		
	}
						
}
