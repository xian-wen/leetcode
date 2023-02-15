import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode id=332 lang=java
 *
 * [332] Reconstruct Itinerary
 *
 * https://leetcode.com/problems/reconstruct-itinerary/description/
 *
 * algorithms
 * Hard (41.16%)
 * Likes:    4497
 * Dislikes: 1641
 * Total Accepted:    321.4K
 * Total Submissions: 780.7K
 * Testcase Example:  '[["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]'
 *
 * You are given a list of airline tickets where tickets[i] = [fromi, toi]
 * represent the departure and the arrival airports of one flight. Reconstruct
 * the itinerary in order and return it.
 * 
 * All of the tickets belong to a man who departs from "JFK", thus, the
 * itinerary must begin with "JFK". If there are multiple valid itineraries,
 * you should return the itinerary that has the smallest lexical order when
 * read as a single string.
 * 
 * 
 * For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than
 * ["JFK", "LGB"].
 * 
 * 
 * You may assume all tickets form at least one valid itinerary. You must use
 * all the tickets once and only once.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: tickets = [["MUC","LHR"],["JFK","MUC"],["SFO","SJC"],["LHR","SFO"]]
 * Output: ["JFK","MUC","LHR","SFO","SJC"]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: tickets =
 * [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is
 * ["JFK","SFO","ATL","JFK","ATL","SFO"] but it is larger in lexical order.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= tickets.length <= 300
 * tickets[i].length == 2
 * fromi.length == 3
 * toi.length == 3
 * fromi and toi consist of uppercase English letters.
 * fromi != toi
 * 
 * 
 */

// @lc code=start
class Solution {
    Map<String, Queue<String>> map;

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<>();
        for (List<String> t : tickets) {
            String from = t.get(0), to = t.get(1);
            map.computeIfAbsent(from, k -> new PriorityQueue<>()).add(to);
        }

        List<String> path = new LinkedList<>();
        fly("JFK", path);
        return path;
    }

    /**
     * Post-order DFS.
     */
    private void fly(String start, List<String> path) {
        Queue<String> pq = map.get(start);
        while (pq != null && !pq.isEmpty()) {
            String next = pq.poll();
            fly(next, path);
        }
        
        path.add(0, start);
    }
}
// @lc code=end

