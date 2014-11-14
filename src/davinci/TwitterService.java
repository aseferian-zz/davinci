package davinci;

import java.util.List;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TwitterService {

	public static void main(String[] args) {
		TwitterFactory factory = new TwitterFactory();
	    AccessToken accessToken = loadAccessToken();
	    Twitter twitter = factory.getInstance();
	    twitter.setOAuthConsumer("LcYigF6S4kPubzm2OvYalK4I6", "LLy3kjPzvkQrkYGENiSiKFi7le86KHr87u0X3ed1inUD18UR1d");
	    twitter.setOAuthAccessToken(accessToken);
		
        try {
            Query query = new Query("manuel");
            QueryResult result;
            do {
                result = twitter.search(query);
                List<Status> tweets = result.getTweets();
                for (Status tweet : tweets) {
                    System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
                }
            } while ((query = result.nextQuery()) != null);
            System.exit(0);
        } catch (TwitterException te) {
            te.printStackTrace();
            System.out.println("Failed to search tweets: " + te.getMessage());
            System.exit(-1);
        }
	}
	
	 private static AccessToken loadAccessToken(){
	    String token = "64247236-KSLX1HF4vnSMVlzW4bziBxGZy3mWWR56bZcRbpqzc";
	    String tokenSecret = "N2wZ1AMYSlD88sK4nLjqh7IN4CgfHd3NXzWSX0u1u9Pa4";
	    return new AccessToken(token, tokenSecret);
	  }

}
