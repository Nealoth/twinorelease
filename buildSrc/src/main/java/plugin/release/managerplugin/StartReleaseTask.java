package plugin.release.managerplugin;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import plugin.release.managerplugin.git.GitManager;
import plugin.release.managerplugin.git.GitManagerFactory;

import java.util.Optional;

import static plugin.release.managerplugin.ProjectNameResolver.projectNameValid;


public class StartReleaseTask extends DefaultTask {

	private final GitManager gitManager = GitManagerFactory.getManager();

	@TaskAction
	public void run() {
		GradleProjectHolder.init(getProject());
		gitManager.init();
		gitManager.checkBranch("develop");

		String projectProperty = Optional
				.ofNullable(getProject().getProperties().get("releaseProject"))
				.map(Object::toString)
				.map(String::toLowerCase)
				.orElseThrow(() -> new IllegalArgumentException("Property 'releaseProject' is not defined!"));

		if (!projectNameValid(projectProperty)) {
			throw new IllegalArgumentException(String.format("Project %s not supported", projectProperty));
		}

//		gitManager.createReleaseBranch(projectProperty);

	}

}
