package domain.entity;

import domain.Task;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "Executor")
@Data
public class Executor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ExecutorId")
    private int executorId;
    @Column(name = "FirstName")
    private String firstName;
    @Column(name = "LastName")
    private String lastName;
    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "Tasks")
    private List<Task> tasks;

}