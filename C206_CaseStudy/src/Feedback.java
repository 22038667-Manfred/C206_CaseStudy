

import java.time.LocalDateTime;

/**
 * 
 */
public class Feedback {

	public LocalDateTime date;
	public int rating;
	public String message;
	public Feedback(LocalDateTime date, int rating, String message) {
		this.date = date;
		this.rating = rating;
		this.message = message;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
