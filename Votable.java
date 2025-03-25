public interface Votable {
    int getVoteCount();
    void vote(User user, int value);
}
