package com.embarks.firstjobapp.job.impl;

import com.embarks.firstjobapp.exception.ResourceNotFoundException;
import com.embarks.firstjobapp.job.model.Job;
import com.embarks.firstjobapp.job.repository.JobRepository;
import com.embarks.firstjobapp.job.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    @Override
    public List<Job> findAll() {
        return jobRepository.findAll();
    }

    @Override
    public void createJob(Job job) {
       jobRepository.save (job);
    }

    @Override
    public void deleteJobById(Long id) {
       Job job = jobRepository.findById (id)
               .orElseThrow (() -> new ResourceNotFoundException ("Job", id));
       jobRepository.delete (job);
    }

    @Override
    public Job getJobById(Long id) {
        Job job = jobRepository.findById (id)
                .orElseThrow (()-> new ResourceNotFoundException ("Job", id));
        return job;
    }

    @Override
    public Job updateJobById(Long id, Job updateJob) {
        Job existingJob = jobRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Job", id));


        existingJob.setTitle(updateJob.getTitle() != null ? updateJob.getTitle() : existingJob.getTitle());
        existingJob.setDescription(updateJob.getDescription() != null ? updateJob.getDescription() : existingJob.getDescription());
        existingJob.setMinSalary(updateJob.getMinSalary() != null ? updateJob.getMinSalary() : existingJob.getMinSalary());
        existingJob.setMaxSalary(updateJob.getMaxSalary() != null ? updateJob.getMaxSalary() : existingJob.getMaxSalary());
        existingJob.setLocation(updateJob.getLocation() != null ? updateJob.getLocation() : existingJob.getLocation());

        return jobRepository.save(existingJob);
    }

}
