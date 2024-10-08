package com.example.demo2.service;

import com.example.demo2.model.User;
import com.example.demo2.model.Post;
import com.example.demo2.repository.UserRepository;
import com.example.demo2.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Autowired
    public UserService(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User userDetails) {
        User user = userRepository.findById(id).orElseThrow();
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public Post addPostToUser(Long userId, Post post) {
        User user = userRepository.findById(userId).orElseThrow();
        post.setUser(user); // Associate the post with the user
        return postRepository.save(post); // Save the post
    }

    public List<Post> getUserPosts(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        return user.getPosts();
    }
}
