package Feedback;

public abstract class Feedback {
    protected String comment;
    protected int rating;
    protected int points;

    public Feedback(String comment, int rating) {
        this.comment = comment;
        this.rating = rating;
        this.points = calculatePoints(rating);
    }

    protected abstract int calculatePoints(int rating);

    public void displayFeedback() {
        System.out.println("Comment: " + comment);
        System.out.println("Rating: " + rating + "/5");
        System.out.println("Points: " + points);
    }

    public int getPoints() {
        return points;
    }
}

