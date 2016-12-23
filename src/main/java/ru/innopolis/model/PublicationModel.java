package ru.innopolis.model;

public class PublicationModel extends BaseModel {
    private static final long serialVersionUID = -8118805303486862415L;
    private String title;
    private String content;
    private ProfileModel profileModel;

    public PublicationModel() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ProfileModel getProfileModel() {
        return profileModel;
    }

    public void setProfileModel(ProfileModel profileModel) {
        this.profileModel = profileModel;
    }
}
