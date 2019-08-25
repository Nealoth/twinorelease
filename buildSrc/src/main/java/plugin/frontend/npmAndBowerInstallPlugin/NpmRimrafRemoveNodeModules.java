package plugin.frontend.npmAndBowerInstallPlugin;

import org.apache.tools.ant.taskdefs.condition.Os;
import org.gradle.api.tasks.Exec;

public class NpmRimrafRemoveNodeModules extends Exec {
	public NpmRimrafRemoveNodeModules() {
		if (Os.isFamily(Os.FAMILY_WINDOWS)) {
			commandLine("rimraf.cmd", "node_modules");
		} else {
			commandLine("rimraf", "node_modules");
		}
	}
}
