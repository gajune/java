package crowl.news.model;

public class NewsUI {
	String title;
	String contents;
	String address;
	String id;

	public NewsUI(String title, String contents, String address, String id) {
		this.title = title;
		this.contents = contents;
		this.id = id;
		this.address = address;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
