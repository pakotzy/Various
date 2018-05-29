package com.pakotzy.various.blog.services;

import com.pakotzy.various.blog.models.Post;
import com.pakotzy.various.blog.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class PostServiceJpaImpl implements PostService{
	@Autowired
	private PostRepository postRepository;

	@Override
	public List<Post> findAll() {
		return postRepository.findAll();
	}

	@Override
	public List<Post> findLatest5() {
		return postRepository.findLatest5Posts(new PageRequest(0, 5));
	}

	@Override
	public Post findById(Long id) {
		return postRepository.findById(id).orElse(null);
	}

	@Override
	public Post create(Post post) {
		return postRepository.save(post);
	}

	@Override
	public Post edit(Post post) {
		return postRepository.save(post);
	}

	@Override
	public void deleteById(Long id) {
		postRepository.deleteById(id);
	}
}
