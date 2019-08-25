package plugin.release.managerplugin.git;

import org.eclipse.jgit.api.Git;
import org.gradle.api.Project;
import org.gradle.api.logging.Logger;
import plugin.release.managerplugin.GradleProjectHolder;

abstract class AbstractGitManager {

	protected Project project;
	protected Logger logger;
	private Git git;

	protected void initGradleProject() {
		Project projectInstance = GradleProjectHolder.get();
		this.project = projectInstance;
		this.logger = projectInstance.getLogger();
	}

	protected Git getWrapper() {
		if (this.git == null) {
			throw new NullPointerException("Git repository is not initialized");
		} else {
			return this.git;
		}
	}

	protected void setWrapper(Git git) {
		this.git = git;
	}
}
