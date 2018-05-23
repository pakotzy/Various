package com.pakotzy.various.blog.controllers;

import com.pakotzy.various.blog.models.Post;
import com.pakotzy.various.blog.services.NotificationService;
import com.pakotzy.various.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class PostsController {
	@Autowired
	private PostService postService;
	@Autowired
	private NotificationService notifyService;

	@RequestMapping("/posts/view/{id}")
	public String view(@PathVariable("id") Long id, Model model) {
		Post post = postService.findById(id);

		if (post == null) {
			notifyService.addErrorMessage("Cannot find post #" + id);
			return "redirect:/";
		}

		model.addAttribute("post", post);
		return "posts/view";
	}

	@RequestMapping("/posts")
	public String index(Model model) {
		List<Post> posts = postService.findAll();

		if (posts.isEmpty()) {
			notifyService.addErrorMessage("Cannot find any posts");
			return "redirect:/";
		}

		model.addAttribute("posts", posts);
		return "posts/index";
	}

	@PostMapping("/posts/view/{id}")
	public String delete(@PathVariable("id") Long id) {
		try {
			postService.deleteById(id);
		} catch (RuntimeException ex) {
			notifyService.addErrorMessage("No post found");
		}

		notifyService.addInfoMessage("Deletion Successful");
		return "redirect:/";
	}
}
