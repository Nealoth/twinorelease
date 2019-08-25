package plugin.release.managerplugin.git;

public interface GitManager {

	void init();

	void checkBranch(String branchName);

	void createReleaseBranch(String project);

	void checkoutTo(String branchName);

}
