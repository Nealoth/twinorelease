package plugin.release.managerplugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class TwinoReleaseManagementPlugin implements Plugin<Project> {

	@Override
	public void apply(Project project) {
		project.getTasks().create("startRelease", StartReleaseTask.class);
	}

}
