package ru.innopolis.model.dto;

/**
 * This class is used to transfer data to publication table
 */
public class PublicationDTO {
    private int authorId;
    private String title;
    private String content;

    public PublicationDTO(int authorId, String title, String content) {
        this.authorId = authorId;
        this.title = title;
        this.content = content;
    }

    public PublicationDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTille(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }
}
