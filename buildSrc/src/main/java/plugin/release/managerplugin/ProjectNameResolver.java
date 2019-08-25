package plugin.release.managerplugin;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ProjectNameResolver {

	private static Set<TwinoProject> projects;

	static {
		projects = new HashSet<>();
		Collections.addAll(projects, TwinoProject.values());
	}

	public static boolean projectNameValid(String projectName) {
		return projects
				.stream()
				.anyMatch(project -> project.toString().equalsIgnoreCase(projectName));
	}
}
