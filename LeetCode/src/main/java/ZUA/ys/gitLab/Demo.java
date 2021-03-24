package ZUA.ys.gitLab;

import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.models.Commit;
import org.gitlab4j.api.models.Issue;

import java.util.ArrayList;
import java.util.List;

/**
 * Description
 *
 * @author YS
 * @date 2020/11/23 17:51
 */
public class Demo {
    public static void main(String[] args) {
        // Create a GitLabApi instance to communicate with your GitLab server
        //GitLabApi gitLabApi = new GitLabApi("http://10.0.11.44:1000", "MRxYv7nPh57ndhATL5zk");
        // Get the list of projects your account has access to



        //GitLabApi gitLabApi = new GitLabApi(GitLabApi.ApiVersion.V3, "http://10.0.11.44:1000", "MRxYv7nPh57ndhATL5zk");
        //List<Project> a =  gitLabApi.getProjectApi().getProjects();

       //Project o  = gitLabApi.getProjectApi().getProject("anytxn_v2_biz/anytxn-common-manager");
       //List<Namespace> namespaces= gitLabApi.getNamespaceApi().getNamespaces();

        //System.out.println(decideCoordinateExist("anytxn_v2_biz/anytxn-common-manager"));
        getCommitMsg("anytxn_v2_biz/anytxn-common-manager");
    }

    public static Boolean decideCoordinateExist(String coordinate){
        GitLabApi gitLabApi = new GitLabApi(GitLabApi.ApiVersion.V3, "http://10.0.11.44:1000", "MRxYv7nPh57ndhATL5zk");
        try {
            gitLabApi.getProjectApi().getProject(coordinate);
        } catch (GitLabApiException e) {

            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    public static void getCommitMsg(String projectIdOrPath){
        GitLabApi gitLabApi = new GitLabApi(GitLabApi.ApiVersion.V3, "http://10.0.11.44:1000", "MRxYv7nPh57ndhATL5zk");
        List<Commit> res = new ArrayList<>();
        List<Issue> issues = new ArrayList<>();
        try {
            res = gitLabApi.getCommitsApi().getCommits(projectIdOrPath);
            issues = gitLabApi.getIssuesApi().getIssues();
        } catch (GitLabApiException e) {
            e.printStackTrace();
        }
        res.forEach(a->System.out.println(a.getMessage()));
        issues.forEach(a->System.out.println(a.toString()));
    }

}
