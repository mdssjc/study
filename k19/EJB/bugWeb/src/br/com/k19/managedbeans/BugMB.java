package br.com.k19.managedbeans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.k19.entities.Bug;
import br.com.k19.entities.Project;
import br.com.k19.sessionbeans.BugRepository;
import br.com.k19.sessionbeans.ProjectRepository;
import lombok.Getter;
import lombok.Setter;

@Named
@RequestScoped
public class BugMB {

    @Inject
    private BugRepository     bugRepository;

    @Inject
    private ProjectRepository projectRepository;

    @Getter
    private Bug               bug = new Bug();

    @Getter
    @Setter
    private Long              projectId;

    private List<Bug>         bugs;

    public void save() {
        Project project = projectRepository.findById(projectId);
        bug.setProject(project);

        if (getBug().getId() == null) {
            bugRepository.add(getBug());
        } else {
            bugRepository.edit(getBug());
        }

        bug = new Bug();
        bugs = null;
    }

    public void delete(Long id) {
        bugRepository.removeById(id);
        bugs = null;
    }

    public void prepareEdit(Long id) {
        bug = bugRepository.findById(id);
    }

    public List<Bug> getBugs() {
        if (bugs == null) {
            bugs = bugRepository.findAll();
        }
        return bugs;
    }
}
