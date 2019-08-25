package plugin.release.managerplugin.git;

import lombok.SneakyThrows;
import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

import java.io.File;

import static org.eclipse.jgit.api.Git.wrap;

class DefaultGitManager extends AbstractGitManager implements GitManager {

	@Override
	@SneakyThrows
	public void init() {
		initGradleProject();

		FileRepositoryBuilder repositoryBuilder = new FileRepositoryBuilder();
		repositoryBuilder.setMustExist(true);
		repositoryBuilder.findGitDir(new File(System.getProperty("user.dir")));
		setWrapper(wrap(repositoryBuilder.build()));

		logger.quiet("Git repository found and initialized");
	}

	@Override
	@SneakyThrows
	public void checkBranch(String branchName) {
		Git wrapper = getWrapper();
		String currentBranch = wrapper.getRepository().getBranch();
		if (!currentBranch.equals(branchName)) {
			throw new IllegalStateException(String.format("Wrong branch. Current branch is %s but expected %s", currentBranch, branchName));
		}

		logger.quiet("Current branch ({}) successfully checked", branchName);
	}

	@Override
	@SneakyThrows
	public void createReleaseBranch(String project) {
		Git wrapper = getWrapper();

		//TODO: make git tag resolving
		String releaseBranchName = "release/" + project;

		logger.quiet("Making pull before release branch will created");
		wrapper.pull().call();

		logger.quiet("Start checkouting to " + releaseBranchName);
		wrapper.checkout()
				.setCreateBranch(true)
				.setName(releaseBranchName)
				.call();
	}

	@Override
	@SneakyThrows
	public void checkoutTo(String branchName) {
		Git wrapper = getWrapper();

		wrapper.checkout()
				.setCreateBranch(false)
				.setName(branchName)
				.call();
	}
}
