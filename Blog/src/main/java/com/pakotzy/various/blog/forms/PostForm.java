package com.pakotzy.various.blog.forms;

import javax.validation.constraints.NotNull;

public class PostForm {
	private Long id;

	@NotNull
	private String title;

	@NotNull
	private String body;

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
}
