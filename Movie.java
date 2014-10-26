package coolshot;

import javax.persistence.*;
import java.util.Date;
import java.util.Collection;

@Entity
public class Movie {
	@Id
	private int id;
	private String title;
	private String summary;
	private String imgUrl;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
	private Date updatedDate;
        
	public Movie() {}
	public Movie(int id) { this.id = id; }

	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	public String getTitle() { return title; }
	public void setTitle(String title) { this.title = title; }
	public String getSummary() { return summary; }
	public void setSummary(String summary) { this.summary = summary; }
	public String getImgUrl() { return imgUrl; }
	public void setImgUrl(String imgUrl) { this.imgUrl = imgUrl; }
	public Date getUpdatedDate() { return updatedDate; }
	public void setUpdatedDate(Date updatedDate) { this.updatedDate = updatedDate; }
    
    public String toString() {
        return "Movie: " + "[" + id + "] " + title + ". Last update: " + updatedDate.toString();
    }
}
