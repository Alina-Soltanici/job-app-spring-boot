package com.embarks.firstjobapp.job.controller;

import com.embarks.firstjobapp.job.model.Job;
import com.embarks.firstjobapp.job.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/jobs")
@RequiredArgsConstructor
public class JobController {
    private final JobService jobService;

    @GetMapping
    public List<Job> findAll() {
        List<Job> jobs = jobService.findAll ();
        return jobs;
    }

    @PostMapping
    public ResponseEntity<String> addJob(@RequestBody Job job) {
       jobService.createJob (job);
       return ResponseEntity.status (HttpStatus.CREATED).body ("Job " + job.getTitle () +  " has been added successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobById(@PathVariable(name = "id") Long id) {
        jobService.deleteJobById(id);
        return ResponseEntity.status (HttpStatus.OK).body ("Job wth id " + id + " has been deleted successfully!");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobById(@PathVariable Long id, @RequestBody Job job) {
        Job updatedJob = jobService.updateJobById(id, job);
        return ResponseEntity.status(HttpStatus.OK).body ("Job " + job.getTitle () +  " has been updated successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable(name = "id") Long id) {
        Job job = jobService.getJobById(id);
        return ResponseEntity.status (HttpStatus.OK).body (job);
    }
}
