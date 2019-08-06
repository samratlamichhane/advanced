package com.restapi.practice.service;

import com.restapi.practice.model.Blog;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BlogService {
    List<Blog> index();
    Optional<Blog> show(@PathVariable String id);
    List<Blog> search(@RequestBody Map<String, String> body);
    void create(@RequestBody Blog body);
    Blog update( @RequestBody Blog body);
    boolean delete(@PathVariable String id);
    Blog change(@PathParam("id") String id, @RequestBody Blog blog);
}
