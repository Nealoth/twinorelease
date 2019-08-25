package plugin.release.managerplugin;

import org.gradle.api.Project;

public class GradleProjectHolder {

	private static Project projectInstance;

	private GradleProjectHolder() {
	}

	public static void init(Project project) {
		if (projectInstance == null)
			projectInstance = project;
	}

	public static Project get() {
		if (projectInstance == null) {
			throw new NullPointerException("Project instance is not initialized yet");
		} else {
			return projectInstance;
		}
	}
}
