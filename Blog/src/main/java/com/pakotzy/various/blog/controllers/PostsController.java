package com.pakotzy.various.blog.controllers;

import com.pakotzy.various.blog.forms.PostForm;
import com.pakotzy.various.blog.models.Post;
import com.pakotzy.various.blog.services.NotificationService;
import com.pakotzy.various.blog.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/posts")
public class PostsController {
	@Autowired
	private PostService postService;
	@Autowired
	private NotificationService notifyService;

	@RequestMapping("/view/{id}")
	public String view(@PathVariable("id") Long id, Model model) {
		Post post = postService.findById(id);

		if (post == null) {
			notifyService.addErrorMessage("Cannot find post #" + id);
			return "redirect:/";
		}

		model.addAttribute("post", post);
		return "posts/view";
	}

	@RequestMapping("")
	public String index(Model model) {
		List<Post> posts = postService.findAll();

		if (posts.isEmpty()) {
			notifyService.addErrorMessage("Cannot find any posts");
			return "redirect:/";
		}

		model.addAttribute("posts", posts);
		return "posts/index";
	}

	@PostMapping("delete")
	public String delete(Long id) {
		try {
			postService.deleteById(id);
		} catch (RuntimeException ex) {
			notifyService.addErrorMessage("No post found");
		}

		notifyService.addInfoMessage("Deletion Successful");
		return "redirect:/";
	}

	@RequestMapping("edit")
	public String editPage(Long id, Model model) {
		PostForm postForm = new PostForm();
		Post post = postService.findById(id);

		postForm.setTitle(post.getTitle());
		postForm.setBody(post.getBody());
		postForm.setId(post.getId());

		model.addAttribute("postForm", postForm);
		return "posts/create";
	}

	@RequestMapping("/create")
	public String createPage(PostForm postForm, Model model) {
		return "posts/create";
	}

	@PostMapping("/save")
	public String save(@Valid PostForm postForm, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			notifyService.addErrorMessage("Invalid post format!");
			return "posts/create";
		}

		Post post;
		if (postForm.getId() != null) {
			post = postService.edit(new Post(postForm.getId(), postForm.getTitle(), postForm.getBody(), null));
		} else {
			post = postService.create(new Post(null, postForm.getTitle(), postForm.getBody(), null));
		}

		if (post == null) {
			notifyService.addErrorMessage("Can't save the post!");
			return "posts/create";
		}

		notifyService.addInfoMessage("Post successfully saved!");
		return view(post.getId(), model);
	}
}
