package ZUA.ys.gitLab;

import org.gitlab4j.api.GitLabApi;
import org.gitlab4j.api.GitLabApiException;
import org.gitlab4j.api.models.Project;

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


        try {

            GitLabApi gitLabApi = GitLabApi.oauth2Login("http://10.0.11.44:1000","shuai.yang", "yang1103");
            List<Project> a =  gitLabApi.getProjectApi().getProjects();
        } catch (GitLabApiException e) {
            e.printStackTrace();
        }
    }


}
