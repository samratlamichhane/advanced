package com.restapi.practice.service;

import com.restapi.practice.model.Blog;
import com.restapi.practice.repo.BlogRespository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    Logger logger = LoggerFactory.getLogger(BlogServiceImpl.class);

    @Autowired
    BlogRespository blogRespository;

    @Override
    public List<Blog> index() {
        logger.info("this is in index method in blogserviceImpl");
        return blogRespository.findAll();
    }

    @Override
    public Optional<Blog> show(String id) {
        int blogId = Integer.parseInt(id);
        return this.blogRespository.findById(blogId);
    }

    @Override
    public List<Blog> search(Map<String, String> body) {
        String searchTerm = body.get("text");
        return blogRespository.findByTitleContainingOrContentContaining(searchTerm, searchTerm);
    }

    @Override
    public void create(Blog body) {
        String title = body.getTitle();
        String content = body.getContent();
        blogRespository.save(new Blog(title, content));
    }

    @Override
    public Blog update(Blog body) {
        String content = body.getContent();
        String title = body.getTitle();
        int id = body.getId();

        return blogRespository.save(new Blog(id, title, content));
    }

    @Override
    public boolean delete(String id) {
        int blogId = Integer.parseInt(id);
        this.blogRespository.deleteById(blogId);
        return true;
    }

    @Override
    public Blog change(String id, Blog blog) {
        int i = Integer.parseInt(id);
        Optional<Blog> result = blogRespository.findById(i);
        //result.(a->a.getId()i);


        return this.blogRespository.save(new Blog());
    }
}
