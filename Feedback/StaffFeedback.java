package Feedback;

public class StaffFeedback extends Feedback {
    public StaffFeedback(String comment, int rating) {
        super(comment, rating);
    }

    @Override
    protected int calculatePoints(int rating) {
        // Staff feedback points calculation: 5 points for each star
        return rating * 5;
    }
}
