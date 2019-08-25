package plugin.frontend.npmAndBowerInstallPlugin;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class NpmAndBowerInstallPlugin implements Plugin<Project> {
	@Override
	public void apply(Project project) {
		project.getTasks().create("npm_install", NpmInstall.class);
		project.getTasks().create("npm_and_bower_cache_install", NpmAndBowerCacheInstall.class);
		project.getTasks().create("npm_rimraf_remove_node_modules", NpmRimrafRemoveNodeModules.class);
	}
}
