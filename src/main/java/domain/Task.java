package domain;

import domain.entity.Author;
import domain.entity.Executor;
import domain.entity.Priority;
import domain.entity.Status;
import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TaskId")
    private int id;
    @Column(name = "Title")
    private String title;
    @Column(name = "Description")
    private String description;
    @Column(name = "Status")
    private Status status;
    @Column(name = "Priority")
    private Priority priority;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AuthorId")
    private Author authorId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ExecutorId")
    private Executor executorId;
    @Column(name = "Comments")
    private String comments;
}
