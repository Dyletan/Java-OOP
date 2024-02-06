package data;
import messages.*;

import java.io.Serializable;
import java.util.*;

import messages.Comment;

public class News implements Serializable {
    private Topic topic;
    private String title;
    private String content;
    private Boolean pinned;
    private Vector<Comment> comments;
    {
    	comments = new Vector<Comment>();
    }

    public News() {

    }

    public News(Topic topic, String title, String content, Boolean pinned) {
        this.topic = topic;
        this.title = title;
        this.content = content;
        this.pinned = pinned;
    }

    public void addComment(Comment comment){
        comments.add(comment);
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getPinned() {
        return pinned;
    }

    public void setPinned(Boolean pinned) {
        this.pinned = pinned;
    }

    public Vector<Comment> getComments() {
        return comments;
    }

    public void setComments(Vector<Comment> comments) {
        this.comments = comments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return topic == news.topic && Objects.equals(content, news.content) && Objects.equals(pinned, news.pinned) && Objects.equals(comments, news.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topic, content, pinned, comments);
    }

    @Override
    public String toString() {
        return topic + " " 
        		+ title + "\n"
                + content + "\n" 
        		+ comments;
    }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}
