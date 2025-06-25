package Feedback;

public class CustomerFeedback extends Feedback {
    public CustomerFeedback(String comment, int rating) {
        super(comment, rating);
    }

    @Override
    protected int calculatePoints(int rating) {
        return rating * 10;
    }
    
}
