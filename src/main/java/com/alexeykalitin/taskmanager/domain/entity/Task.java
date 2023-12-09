package com.alexeykalitin.taskmanager.domain.entity;

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
    private Author executorId;
    @Column(name = "Comments")
    private String comments;
}
