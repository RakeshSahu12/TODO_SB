package com.nt.Repo;



import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.Entity.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
