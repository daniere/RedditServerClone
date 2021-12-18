package com.example.demo.controller;

import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.PostRequest;
import com.example.demo.dto.PostResponse;
import com.example.demo.service.PostService;

import java.util.List;

import static org.springframework.http.ResponseEntity.status;

@RestController
@RequestMapping("/api/posts/")
@AllArgsConstructor
public class PostController {
	@Autowired
    private  PostService postService;

    @PostMapping
    public ResponseEntity<Void> createPost(@RequestBody PostRequest postRequest) {
        postService.save(postRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PostResponse>> getAllPosts() {
        return status(HttpStatus.OK).body(postService.getAllPosts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PostResponse> getPost(@PathVariable Long id) {
        return status(HttpStatus.OK).body(postService.getPost(id));
    }

    @GetMapping("by-subreddit/{id}")
    public ResponseEntity<List<PostResponse>> getPostsBySubreddit(Long id) {
        return status(HttpStatus.OK).body(postService.getPostsBySubreddit(id));
    }

    @GetMapping("by-user/{name}")
    public ResponseEntity<List<PostResponse>> getPostsByUsername(@PathVariable String name) {
        return status(HttpStatus.OK).body(postService.getPostsByUsername(name));
    }
}
