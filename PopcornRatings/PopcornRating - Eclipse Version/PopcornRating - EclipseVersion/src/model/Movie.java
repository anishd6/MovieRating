package model;

public class Movie {
	
	private String title;
	private int rating; // 1 - 5 stars
	private int year;
	private int length; //minutes
	private int id;
	private String genre; 
	private String director;
	private String starring;
	private String story_line;
	
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(int year, String title, String director, String starring) {
		super();
		this.year = year;
		this.title = title;
		this.director = director;
		this.starring = starring;
	}

	public String getTitle() {
		return title;
	}
	public String getStory_line() {
		return story_line;
	}
	public void setStory_line(String story_line) {
		this.story_line = story_line;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int lenght) {
		this.length = lenght;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getStarring() {
		return starring;
	}
	public void setStarring(String starring) {
		this.starring = starring;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
