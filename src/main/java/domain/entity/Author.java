package domain.entity;

import domain.Task;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Author")
@Data
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AuthorId")
    private int authorId;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "Tasks")
    private List<Task> tasks;
}
