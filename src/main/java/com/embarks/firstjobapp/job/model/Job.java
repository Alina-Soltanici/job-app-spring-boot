package com.embarks.firstjobapp.job.model;

import com.embarks.firstjobapp.company.model.Company;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @SequenceGenerator (name = "jobs_generator_sequence", sequenceName = "jobs_sequence", allocationSize = 1)
    @GeneratedValue(strategy = SEQUENCE, generator = "jobs_generator_sequence")
    @Column(name = "id", updatable = false)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "minSalary", nullable = false)
    private Double minSalary;

    @Column(name = "maxSalary", nullable = false)
    private Double maxSalary;

    @Column(name = "location", nullable = false)
    private String location;

    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;
}
