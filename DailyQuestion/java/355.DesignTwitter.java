package DailyQuestion.java;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

class DesignTwitter {
    /**
     * 用户 id 和推文（单链表）的对应关系
     */
    private Map<Integer, Tweet> twitter;

    /**
     * 用户 id 和他关注的用户列表的对应关系
     */
    private Map<Integer, Set<Integer>> followings;

    /**
     * 全局使用的时间戳字段，用户每发布一条推文之前 + 1
     */
    private static int timestamp = 0;

    PriorityQueue<Tweet> priorityQueue = new PriorityQueue<>(((o1, o2) -> o2.timestamp - o1.timestamp));

    /** Initialize your data structure here. */
    public Twitter() {
        twitter = new HashMap<>();
        followings = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        Tweet temp = twitter.get(userId);
        if(temp != null){
            while (temp != null){
                if(temp.next == null){
                    temp.next = new Tweet(tweetId, ++timestamp);
                    temp = null;
                    break;
                }
                temp = temp.next;
            }
        }else {
            twitter.put(userId, new Tweet(tweetId, ++timestamp));
        }
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> tempSet = followings.get(userId);
        List<Integer> list = new ArrayList<>();
        priorityQueue.clear();
        if(twitter.containsKey(userId)){
            Tweet tt = twitter.get(userId);
            while (tt != null){
                priorityQueue.offer(tt);
                tt = tt.next;
            }

        }
        if(tempSet != null){
            for(Integer tempUserId : tempSet){
                Tweet tempTw = twitter.get(tempUserId);
                if(tempTw != null){
                    while (tempTw != null){
                        priorityQueue.offer(tempTw);
                        tempTw = tempTw.next;
                    }
                }
            }
        }
        int count = 0;
        while (!priorityQueue.isEmpty() && count<3){
            Tweet temptw = priorityQueue.poll();
            if(temptw != null){
                list.add(temptw.id);
            }
            count++;
        }
        return  list;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(followerId == followeeId){
            return;
        }
        if(followings.get(followerId) != null){
            followings.get(followerId).add(followeeId);
        }else {
            Set<Integer> set = new HashSet();
            set.add(followeeId);
            followings.put(followerId,set);
        }
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = followings.get(followerId);
        if(set != null && set.contains(followeeId)){
            set.remove(followeeId);
        }
    }

    public static void main(String[] args) {
        /**
         *
         ["Twitter","postTweet","follow","follow","getNewsFeed","postTweet","getNewsFeed","getNewsFeed","unfollow","getNewsFeed","getNewsFeed","unfollow","getNewsFeed","getNewsFeed"]
         [[],[1,5],[1,2],[2,1],[2],[2,6],[1],[2],[2,1],[1],[2],[1,2],[1],[2]]
         * */
        Twitter tw = new Twitter();
        tw.postTweet(1,5);
        tw.follow(1,2);
        tw.follow(2,1);
        tw.postTweet(1,8);
        tw.postTweet(1,3);
        System.out.println(tw.getNewsFeed(1));
        System.out.println(tw);

    }
    /**
     * 推文类，是一个单链表（结点视角）
     */
    private class Tweet {
        /**
         * 推文 id
         */
        private int id;

        /**
         * 发推文的时间戳
         */
        private int timestamp;
        private Tweet next;

        public Tweet(int id, int timestamp) {
            this.id = id;
            this.timestamp = timestamp;
        }
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