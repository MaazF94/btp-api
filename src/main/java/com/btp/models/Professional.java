package com.btp.models;

public class Professional {
    
    private int professionalId;
    private int userId;
    private String companyName;
    private int isActive;
    private String categoryName;
    private String professionName;
    private String jobTitle;
    private double avgRating;
    private int yearsOfExperience;
    private int queueSize;
    private int replyTime;
    private String aboutMe;
    private String jobDescription;
    private String fullName;

    public Professional() {
    }

    public Professional(int professionalId, int userId, String companyName, int isActive, String categoryName,
                        String professionName, String jobTitle, double avgRating, int yearsOfExperience,
                        int queueSize, int replyTime, String aboutMe, String jobDescrtiption, String fullName) {
        this.professionalId = professionalId;
        this.userId = userId;
        this.companyName = companyName;
        this.isActive = isActive;
        this.categoryName = categoryName;
        this.professionName = professionName;
        this.jobTitle = jobTitle;
        this.avgRating = avgRating;
        this.yearsOfExperience = yearsOfExperience;
        this.queueSize = queueSize;
        this.replyTime = replyTime;
        this.aboutMe = aboutMe;
        this.jobDescription = jobDescrtiption;
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "Professional [aboutMe=" + aboutMe + ", avgRating=" + avgRating + ", categoryName=" + categoryName
                + ", companyName=" + companyName + ", isActive=" + isActive + ", jobDescription=" + jobDescription
                + ", jobTitle=" + jobTitle + ", professionName=" + professionName + ", professionalId=" + professionalId
                + ", queueSize=" + queueSize + ", replyTime=" + replyTime + ", userId=" + userId
                + ", yearsOfExperience=" + yearsOfExperience + ", fullName=" + fullName + "]";
    }

    /**
     * @return the professionalId
     */
    public int getProfessionalId() {
        return professionalId;
    }

    /**
     * @param professionalId the professionalId to set
     */
    public void setProfessionalId(int professionalId) {
        this.professionalId = professionalId;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName the companyName to set
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the isActive
     */
    public int getIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    /**
     * @return the categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * @param categoryName the categoryName to set
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * @return the professionName
     */
    public String getProfessionName() {
        return professionName;
    }

    /**
     * @param professionName the professionName to set
     */
    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    /**
     * @return the jobTitle
     */
    public String getJobTitle() {
        return jobTitle;
    }

    /**
     * @param jobTitle the jobTitle to set
     */
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    /**
     * @return the avgRating
     */
    public double getAvgRating() {
        return avgRating;
    }

    /**
     * @param avgRating the avgRating to set
     */
    public void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    /**
     * @return the yearsOfExperience
     */
    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    /**
     * @param yearsOfExperience the yearsOfExperience to set
     */
    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    /**
     * @return the queueSize
     */
    public int getQueueSize() {
        return queueSize;
    }

    /**
     * @param queueSize the queueSize to set
     */
    public void setQueueSize(int queueSize) {
        this.queueSize = queueSize;
    }

    /**
     * @return the replyTime
     */
    public int getReplyTime() {
        return replyTime;
    }

    /**
     * @param replyTime the replyTime to set
     */
    public void setReplyTime(int replyTime) {
        this.replyTime = replyTime;
    }

    /**
     * @return the aboutMe
     */
    public String getAboutMe() {
        return aboutMe;
    }

    /**
     * @param aboutMe the aboutMe to set
     */
    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    /**
     * @return the jobDescription
     */
    public String getJobDescription() {
        return jobDescription;
    }

    /**
     * @param jobDescription the jobDescription to set
     */
    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}