class Tweet {
    public int userId;
    public int tweetId;
    public int time;
    public Tweet(int userId, int tweetId, int time) {
        this.userId = userId;
        this.tweetId = tweetId;
        this.time = time;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof Tweet))
            return false;
        Tweet t = (Tweet)o;
        return t.tweetId == this.tweetId;
    }
}

class TweetComparator implements Comparator<Tweet> {
    @Override
    public int compare(Tweet t1, Tweet t2) {
        // acs order
        return t1.time - t2.time;
    }
}

class Twitter {
    // key : userId, value : List of Tweet Id
    // a tweet list will be used like a queue
    private Map<Integer, Set<Tweet>> tweetRepo = null;
    // key : userId, value : List of follwing users.
    private Map<Integer, Set<Integer>> userFollowers = null;
    private int time = 0;
    
    /** Initialize your data structure here. */
    public Twitter() {
        tweetRepo = new HashMap<>();
        userFollowers = new HashMap<>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Set<Tweet> tweets = tweetRepo.getOrDefault(userId, new HashSet<>());
        Set<Integer> followers = userFollowers.getOrDefault(userId, new HashSet<>());
        time++;
        // add tweet for my side
        tweets.add(new Tweet(userId, tweetId, time));
        tweetRepo.put(userId, tweets);

        // post my tweet to my followers 
        for(Integer followerId : followers) {
            Set<Tweet> followerTweets = tweetRepo.getOrDefault(followerId, new HashSet<>());
            followerTweets.add(new Tweet(userId, tweetId, time));
            tweetRepo.put(followerId, followerTweets);
        }
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> ret = new ArrayList<>();
        List<Tweet> userTweets = new ArrayList<>(tweetRepo.getOrDefault(userId, new HashSet<>()));
        Collections.sort(userTweets, new TweetComparator());
        for(int i = userTweets.size() - 1; i >= 0; i--) {
            ret.add(userTweets.get(i).tweetId);
            if(ret.size() >= 10) break;
        }
        return ret;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        // no op
        if(followerId == followeeId) return;
        // add follower to followeeId
        Set<Integer> followers = userFollowers.getOrDefault(followeeId, new HashSet<>());
        if(!followers.add(followerId)) return; // already following.
        userFollowers.put(followeeId, followers);
        // and add followeeId's tweets to followerId's tweet.
        Set<Tweet> followeeTweets = tweetRepo.getOrDefault(followeeId, new HashSet<>());
        // extract followeeTweets only
        Set<Tweet> followeeTweetsExtracted = new HashSet<>();
        for(Tweet t : followeeTweets) {
            if(t.userId == followeeId) followeeTweetsExtracted.add(t);
        }
        Set<Tweet> userTweets = tweetRepo.getOrDefault(followerId, new HashSet<>());
        userTweets.addAll(followeeTweetsExtracted);
        tweetRepo.put(followerId, userTweets);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        // no op
        if(followerId == followeeId) return;
        // remove follower from followeeId
        Set<Integer> followers = userFollowers.getOrDefault(followeeId, new HashSet<>());
        if(!followers.remove(followerId)) return; // not following.
        userFollowers.put(followeeId, followers);
        // remove followee tweets from followers tweet.
        Set<Tweet> olduserTweets = tweetRepo.getOrDefault(followerId, new HashSet<>());
        Set<Tweet> newuserTweets = new HashSet<>();
        for(Tweet t : olduserTweets) {
            if(t.userId != followeeId) newuserTweets.add(t);
        }
        tweetRepo.put(followerId, newuserTweets);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
