package com.freely.freely.services;

import com.freely.freely.DTO.ProjectDTO;

import java.util.List;

public interface ProjectManagementService {
    ProjectDTO createProject(ProjectDTO projectDTO);
    ProjectDTO getProject(Integer id);
    List<ProjectDTO> getProjects();
}
