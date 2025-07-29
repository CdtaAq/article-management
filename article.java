import lombok.*;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = “article”)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Article {

```
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;

@Column(nullable = false)
private String title;

@Column(columnDefinition = "TEXT")
private String content;

@ElementCollection
@CollectionTable(name = "article_tags", joinColumns = @JoinColumn(name = "article_id"))
@Column(name = "tag")
private List<String> tags = new ArrayList<>();

// Constructor matching ArticleDTO
public Article(String title, String content, List<String> tags) {
this.title = title;
this.content = content;
this.tags = tags != null ? new ArrayList<>(tags) : new ArrayList<>();
}
```

}
