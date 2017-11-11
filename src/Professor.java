public class Professor {
    // Create a Professor object with the following!
    //      Difficulty Level
    //      Ratings Average (out of 5)
    //      Number of Ratings
    // Ensure the Professor get passed on the possibleSchedules
    private int difficulty, numRatings;
    private double ratingsAverage;

    public Professor() {

    }

    public int getDifficulty()
    {
        return difficulty;
    }

    public void setDifficulty(int difficulty)
    {
        this.difficulty = difficulty;
    }

    public int getNumRatings()
    {
        return numRatings;
    }

    public void setNumRatings(int numRatings)
    {
        this.numRatings = numRatings;
    }

    public double getRatingsAverage()
    {
        return ratingsAverage;
    }

    public void setRatingsAverage(double ratingsAverage)
    {
        this.ratingsAverage = ratingsAverage;
    }
}