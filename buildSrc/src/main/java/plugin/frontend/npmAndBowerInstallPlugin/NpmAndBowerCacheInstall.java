package plugin.frontend.npmAndBowerInstallPlugin;

import org.apache.tools.ant.taskdefs.condition.Os;
import org.gradle.api.tasks.Exec;

public class NpmAndBowerCacheInstall extends Exec {
	public NpmAndBowerCacheInstall() {
		if (Os.isFamily(Os.FAMILY_WINDOWS)) {
			commandLine("npm-cache.cmd", "install");
		} else {
			commandLine("npm-cache", "install");
		}
	}
}
