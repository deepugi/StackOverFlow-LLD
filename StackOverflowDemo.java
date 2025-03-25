import java.util.Arrays;
import java.util.List;

public class StackOverflowDemo {


    public static  void main(String[] args){


        StackOverflow demo = new StackOverflow();




        //create users

       User deepa =  demo.createUser("Deepa", "deepav@gmail.com");
       User ayaan =  demo.createUser("Ayaan", "ayaan@gmail.com");
       User anjana = demo.createUser("Anjana", "anjana@gmail.com");


       //deepa asks the question
    Question deepaQuestion1 = demo.askQuestion(deepa, "how is earth formed?", "Can someone explain on how earth is formed", Arrays.asList("earth", "formation") );



    //anjana answers the question
        Answer anjanaAnswer = demo.answerQuestion(anjana, deepaQuestion1, "Earth formed few billion years ago from matter");



        // ayaan comments on the question of deepas
        demo.addComment(ayaan,  deepaQuestion1, "Great  Question" );


        //deepa comments on anjana answer

        demo.addComment(deepa, anjanaAnswer, "Such a great explanation ! I really loved your way of explaining the question ");


        //ayaan vote question and answer
        demo.voteQuestion(ayaan, deepaQuestion1, 1 ); // upvote;

        demo.voteAnswer(ayaan, anjanaAnswer, 1);


        //deepa accepts anjanas answer

        demo.acceptAnswer(anjanaAnswer);



        System.out.println("Question"+ deepaQuestion1.getTitle() );

        System.out.println("Asked by "+ deepaQuestion1.getAuthor().getUsername());

        System.out.println("Tags"+ deepaQuestion1.getTags().stream().map(Tag :: getName).reduce((a, b) -> a+","+b).orElse("") );

        System.out.println("Votes"  + deepaQuestion1.getVoteCount());
        System.out.println("Comments: " + deepaQuestion1.getComments().size());

        System.out.println("\nAnswer by " + anjanaAnswer.getAuthor().getUsername() + ":");
        System.out.println(anjanaAnswer.getContent());
        System.out.println("Votes: " + anjanaAnswer.getVoteCount());
        System.out.println("Accepted: " + anjanaAnswer.isAccepted());
        System.out.println("Comments: " + anjanaAnswer.getComments().size());


        System.out.println("\nUser Reputations:");
        System.out.println("deepa: " + deepa.getReputation());
        System.out.println("ayan: " + ayaan.getReputation());
        System.out.println("anjana: " + anjana.getReputation());

        System.out.println("\nSearch Results for 'earth':");
        List<Question> searchResults = demo.searchQuestions("earth");
        for (Question q : searchResults) {
            System.out.println(q.getTitle());
        }


        // Demonstrate getting questions by user
        System.out.println("\ndeepa's Questions:");
        List<Question> bobQuestions = demo.getQuestionsByUser(deepa);
        for (Question q : bobQuestions) {
            System.out.println(q.getTitle());
        }

    }


}
