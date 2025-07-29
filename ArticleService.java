package com.codility.tasks.hibernate.crud.solution;

import com.codility.tasks.hibernate.crud.ArticleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Transactional
public class ArticleService {

```
@Autowired
private ArticleRepository articleRepository;

public Optional<ArticleDTO> findById(Long id) {
return articleRepository.findById(id)
.map(this::convertToDTO);
}

public List<ArticleDTO> findByTitle(String title) {
return articleRepository.findByTitle(title).stream()
.map(this::convertToDTO)
.collect(Collectors.toList());
}

public Long create(ArticleDTO articleDTO) {
Article article = new Article(
articleDTO.getTitle(),
articleDTO.getContent(),
articleDTO.getTags()
);
Article saved = articleRepository.save(article);
return saved.getId();
}

public void update(Long id, ArticleDTO articleDTO) {
Optional<Article> optionalArticle = articleRepository.findById(id);
if (optionalArticle.isPresent()) {
Article article = optionalArticle.get();
article.setTitle(articleDTO.getTitle());
article.setContent(articleDTO.getContent());
article.setTags(articleDTO.getTags() != null ?
new ArrayList<>(articleDTO.getTags()) : new ArrayList<>());
articleRepository.save(article);
}
}

public void delete(Long id) {
articleRepository.deleteById(id);
}

private ArticleDTO convertToDTO(Article article) {
ArticleDTO dto = new ArticleDTO();
dto.setTitle(article.getTitle());
dto.setContent(article.getContent());
dto.setTags(article.getTags() != null ?
new ArrayList<>(article.getTags()) : new ArrayList<>());
return dto;
}
```

}
