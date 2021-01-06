package com.example.githubapiparsingapp

import com.google.gson.annotations.SerializedName

data class UsersUsernameRepos(
    var stargazers_count: String? = null,
    var pushed_at: String? = null,
    var subscription_url: String? = null,
    var language: String? = null,
    var branches_url: String? = null,
    var issue_comment_url: String? = null,
    var labels_url: String? = null,
    var subscribers_url: String? = null,
    var releases_url: String? = null,
    var svn_url: String? = null,
    var id: String? = null,
    var forks: String? = null,
    var archive_url: String? = null,
    var git_refs_url: String? = null,
    var forks_url: String? = null,
    var statuses_url: String? = null,
    var ssh_url: String? = null,
    private var license: License? = null,
    var full_name: String? = null,
    var size: String? = null,
    var languages_url: String? = null,
    var html_url: String? = null,
    var collaborators_url: String? = null,
    var clone_url: String? = null,
    var name: String? = null,
    var pulls_url: String? = null,
    var default_branch: String? = null,
    var hooks_url: String? = null,
    var trees_url: String? = null,
    var tags_url: String? = null,
    @SerializedName("private")
    var privates: String? = null,
    var contributors_url: String? = null,
    var has_downloads: String? = null,
    var notifications_url: String? = null,
    var open_issues_count: String? = null,
    var description: String? = null,
    var created_at: String? = null,
    var watchers: String? = null,
    var keys_url: String? = null,
    var deployments_url: String? = null,
    var has_projects: String? = null,
    var archived: String? = null,
    var has_wiki: String? = null,
    var updated_at: String? = null,
    var comments_url: String? = null,
    var stargazers_url: String? = null,
    var disabled: String? = null,
    var git_url: String? = null,
    var has_pages: String? = null,
    private var owner: Owner? = null,
    var commits_url: String? = null,
    var compare_url: String? = null,
    var git_commits_url: String? = null,
    var blobs_url: String? = null,
    var git_tags_url: String? = null,
    var merges_url: String? = null,
    var downloads_url: String? = null,
    var has_issues: String? = null,
    var url: String? = null,
    var contents_url: String? = null,
    var milestones_url: String? = null,
    var teams_url: String? = null,
    var fork: String? = null,
    var issues_url: String? = null,
    var events_url: String? = null,
    var issue_events_url: String? = null,
    var assignees_url: String? = null,
    var open_issues: String? = null,
    var watchers_count: String? = null,
    var node_id: String? = null,
    var forks_count: String? = null
)