package com.week4.prod_ready_features.prod_ready_features.controllers;

import com.week4.prod_ready_features.prod_ready_features.entities.PostEntity;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/audit")
public class AuditController {

    private EntityManagerFactory entityManagerFactory;

    @GetMapping(path = "/posts/{postId}")
    List<PostEntity> getPostRevisions(@PathVariable Long postId){
        AuditReader reader = AuditReaderFactory.get(entityManagerFactory.createEntityManager());

        List<Number> revisions = reader.getRevisions(PostEntity.class, postId);
        return revisions.stream()
                .map(revisionNumber -> reader.find(PostEntity.class, postId, revisionNumber))
                .collect(Collectors.toList());
    }
}
