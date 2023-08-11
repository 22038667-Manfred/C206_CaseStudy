

import java.time.LocalDateTime;

/**
 * 
 */
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Feedback {

    private LocalDateTime date;  // Date and time when the feedback was provided
    private int rating;          // Rating given by the user (e.g., on a scale of 1 to 5)
    private String message;      // User's feedback message

    // Constructor
    public Feedback(LocalDateTime date, int rating, String message) {
        this.date = date;
        this.rating = rating;
        this.message = message;
    }

    // Getters and setters
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

    // Driver class for testing
    public static class FeedbackManager {
        private List<Feedback> feedbackList;

        public FeedbackManager() {
            feedbackList = new ArrayList<>();
        }

        // Add new feedback
        public void addFeedback(Feedback feedback) {
            feedbackList.add(feedback);
        }

        // View all feedbacks
        public List<Feedback> viewAllFeedbacks() {
            return feedbackList;
        }

        // Delete existing feedback
        public boolean deleteFeedback(Feedback feedback) {
            return feedbackList.remove(feedback);
        }
    }

    public static void main(String[] args) {
        FeedbackManager feedbackManager = new FeedbackManager();

        // Adding new feedback
        LocalDateTime feedbackDate = LocalDateTime.now();
        Feedback feedback1 = new Feedback(feedbackDate, 5, "Great system!");
        Feedback feedback2 = new Feedback(feedbackDate.minusDays(1), 3, "Needs improvement");

        feedbackManager.addFeedback(feedback1);
        feedbackManager.addFeedback(feedback2);

        // Viewing all feedbacks
        List<Feedback> allFeedbacks = feedbackManager.viewAllFeedbacks();
        for (Feedback feedback : allFeedbacks) {
            System.out.println("Date: " + feedback.getDate());
            System.out.println("Rating: " + feedback.getRating());
            System.out.println("Message: " + feedback.getMessage());
            System.out.println();
        }

        // Deleting feedback
        feedbackManager.deleteFeedback(feedback1);

        // Viewing all feedbacks after deletion
        List<Feedback> remainingFeedbacks = feedbackManager.viewAllFeedbacks();
        for (Feedback feedback : remainingFeedbacks) {
            System.out.println("Date: " + feedback.getDate());
            System.out.println("Rating: " + feedback.getRating());
            System.out.println("Message: " + feedback.getMessage());
            System.out.println();
        }
    }
}
