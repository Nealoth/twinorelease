package plugin.frontend.npmAndBowerInstallPlugin;

import org.apache.tools.ant.taskdefs.condition.Os;
import org.gradle.api.tasks.Exec;

public class NpmInstall extends Exec {
	public NpmInstall() {
		if (Os.isFamily(Os.FAMILY_WINDOWS)) {
			commandLine("npm.cmd", "install");
		} else {
			commandLine("npm", "install");
		}
	}
}
