package newbies.java16.crmapp.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import newbies.java16.crmapp.dao.ProjectDao;
import newbies.java16.crmapp.dto.ProjectDto;
import newbies.java16.crmapp.model.Project;

public class ProjectService {
	private ProjectDao dao;

	public ProjectService() {
		dao = new ProjectDao();
	}

	public List<Project> projectDtoToProject() {
		List<Project> projects = new ArrayList<Project>();
		try {
			for (ProjectDto dto : dao.findAll()) {
				Project project = new Project();
				project.setNameOfManager(dto.getNameOfManager());
				project.setEndDate(dto.getEndDate());
				project.setName(dto.getName());
				project.setOwner(dto.getOwner());
				project.setStartDate(dto.getStartDate());
				projects.add(project);
			}
		} catch (SQLException e) {
			System.out.println("Fail to connect");
		}
		return projects;
	}
	public int findIdByName(String name) {
		return dao.findIdByName(name);
	}
	public void update(String start_day, String end_date, int id) {
		try {
			dao.update(start_day, end_date, id);
		} catch (SQLException e) {
			System.out.println("Fail to connect");
		}
	}
	public void createProject(Project project) throws SQLException {
		dao.createProject(project);
	}
}