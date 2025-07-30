package b6_lld_inmemory_search;

import java.util.Date;

public class Document {
    private String name;
    private String content;
    private String author;
    private Date publishDate;
    private Date lastUpdatedDate;
    private Date lastSearchedDate;

    public Document(String name, String content, String author) {
        this.name = name;
        this.content = content;
        this.author = author;
        this.publishDate = new Date();
        this.lastUpdatedDate = new Date();
        this.lastSearchedDate = null;
    }

	public String getName() {
		return name;
	}

	public String getContent() {
		return content;
	}

	public String getAuthor() {
		return author;
	}

	public Date getPublishDate() {
		return publishDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public Date getLastSearchedDate() {
		return lastSearchedDate;
	}
}
