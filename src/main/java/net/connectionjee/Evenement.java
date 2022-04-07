package net.connectionjee;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "evenement")
public class Evenement {
	
	@Id
	@Column(name = "id")    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int eventid;
	
	private String title;
	
	private String date_d;
	
	private String timm_db;
	
	private String description;
	
	private String url;

	public int getEventid() {
		return eventid;
	}

	public void setEventid(int eventid) {
		this.eventid = eventid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDate_d() {
		return date_d;
	}

	public void setDate_d(String date_d) {
		this.date_d = date_d;
	}

	public String getTimm_db() {
		return timm_db;
	}

	public void setTimm_db(String timm_db) {
		this.timm_db = timm_db;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
	@Override
    public String toString() {
        return "[" + this.title + "]";
    }

	
	
	

}
