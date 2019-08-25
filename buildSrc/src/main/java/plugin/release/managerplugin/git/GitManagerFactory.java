package plugin.release.managerplugin.git;

public class GitManagerFactory {
	public static GitManager getManager() {
		return new DefaultGitManager();
	}
}
