package com.freely.freely.services;

import com.freely.freely.DTO.ProjectDTO;

import java.util.List;

public interface ProjectUpdateService {
    ProjectDTO addUpdate(Integer id, String description);
    List<ProjectDTO> getProjectUpdates(Integer id);
}
