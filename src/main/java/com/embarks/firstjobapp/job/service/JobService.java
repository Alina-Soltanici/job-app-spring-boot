package com.embarks.firstjobapp.job.service;
import com.embarks.firstjobapp.job.model.Job;
import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);
    void deleteJobById(Long id);
    Job getJobById(Long id);
    Job updateJobById(Long id, Job updateJob);
}
