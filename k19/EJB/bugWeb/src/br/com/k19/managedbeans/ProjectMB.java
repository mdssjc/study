package br.com.k19.managedbeans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.k19.entities.Project;
import br.com.k19.sessionbeans.ProjectRepository;
import lombok.Getter;

@Named
@RequestScoped
public class ProjectMB {

    @Inject
    private ProjectRepository projectRepository;

    @Getter
    private Project           project = new Project();

    private List<Project>     projects;

    public void save() {
        if (getProject().getId() == null) {
            projectRepository.add(getProject());
        } else {
            projectRepository.edit(getProject());
        }
        project = new Project();
        projects = null;
    }

    public void delete(Long id) {
        projectRepository.removeById(id);
        projects = null;
    }

    public void prepareEdit(Long id) {
        project = projectRepository.findById(id);
    }

    public List<Project> getProjects() {
        if (projects == null) {
            projects = projectRepository.findAll();
        }
        return projects;
    }
}
