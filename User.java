
import java.util.*;
import java.util.List;

public class User {

    private final String username;
    private final int id;
    private final  String email;
    private final List<Question> questions;
    private final List<Answer> answers;
    private final List<Comment> comments;
    private int reputation;


//    private static final int re
//    private List<Tags> tags;
   private static final int QUESTION_REPUTATION = 5;
    private static final int ANSWER_REPUTATION = 10;
    private static final int COMMENT_REPUTATION = 2;


   public User(int id , String username, String email ){

        this.username = username;
        this.id = id;
        this.email = email;

        this.reputation = 0;
        this.questions = new ArrayList<>();
        this.answers = new ArrayList<>();
        this.comments =  new ArrayList<>();
    }

    public Question askQuestion(String title, String Content, List<String> tags ){
       Question question = new Question(this, title, Content, tags);
       questions.add(question);
       updateReputation(QUESTION_REPUTATION);
       return question;
    }


    public Answer answerQuestion(Question question, String Content ){
       Answer answer = new Answer(this, question, Content);
       answers.add(answer);
       updateReputation(ANSWER_REPUTATION);
       return  answer;
   }

   public Comment addComment(Commentable commentable, String content ){
       Comment comment = new Comment(this, content);
       comments.add(comment);
       commentable.addComment(comment);
       updateReputation(COMMENT_REPUTATION);
       return comment;
   }

  public  synchronized void updateReputation(int value){
    reputation += value;
    if(this.reputation <0){
        this.reputation = 0;
    }
  }



    public int getId() { return id; }
    public String getUsername() { return username; }
    public int getReputation() { return reputation; }
    public List<Question> getQuestions() { return new ArrayList<>(questions); }
    public List<Answer> getAnswers() { return new ArrayList<>(answers); }
    public List<Comment> getComments() { return new ArrayList<>(comments); }


























}
