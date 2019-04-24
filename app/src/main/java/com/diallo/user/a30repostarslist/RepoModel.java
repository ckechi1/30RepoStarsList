package com.diallo.user.a30repostarslist;

public class RepoModel {
    private String repoName;
    private String repoDescription;
    private int repoStars ;
    private String ownerUsername;
    private String ownerPhoto;

    public RepoModel() {
    }

    public RepoModel(String repoName, String repoDescription, int repoStars, String ownerUsername, String ownerPhoto) {
        this.repoName = repoName;
        this.repoDescription = repoDescription;
        this.repoStars = repoStars;
        this.ownerUsername = ownerUsername;
        this.ownerPhoto = ownerPhoto;
    }

    public String getRepoName() {
        return repoName;
    }

    public void setRepoName(String repoName) {
        this.repoName = repoName;
    }

    public String getRepoDescription() {
        return repoDescription;
    }

    public void setRepoDescription(String repoDescription) {
        this.repoDescription = repoDescription;
    }

    public int getRepoStars() {
        return repoStars;
    }

    public void setRepoStars(int repoStars) {
        this.repoStars = repoStars;
    }

    public String getOwnerUsername() {
        return ownerUsername;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }

    public String getOwnerPhoto() {
        return ownerPhoto;
    }

    public void setOwnerPhoto(String ownerPhoto) {
        this.ownerPhoto = ownerPhoto;
    }
}
