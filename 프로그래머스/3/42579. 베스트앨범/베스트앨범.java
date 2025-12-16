import java.util.*;

class Song {
    int play;
    int index;
    
    Song(int play, int index) {
        this.play = play;
        this.index = index;
    }
}

class Solution {    
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, List<Song>> map = new HashMap<>();
        List<String> genre = new ArrayList<>();
        HashMap<String, Integer> pSum = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            if (!map.containsKey(genres[i])) {
                map.put(genres[i], new ArrayList<>());
                genre.add(genres[i]);
                pSum.put(genres[i], 0);
            }
            
            map.get(genres[i]).add(new Song(plays[i], i));
            int sum = pSum.get(genres[i]);
            pSum.put(genres[i], sum+plays[i]);
        }
        
        int len = genre.size();
        
        for (int i = 0; i < len; i++) {
            map.get(genre.get(i)).sort((o1, o2) -> {
                if (o1.play == o2.play) return o1.index - o2.index;
                return o2.play - o1.play;
            });

        }
        
        genre.sort((o1, o2) -> pSum.get(o2) - pSum.get(o1));
        
        int ans = 0;
        for (int i = 0; i < len; i++) {
            if (map.get(genre.get(i)).size() >= 2) ans += 2;
            else ans += 1;
        }
        
        int[] answer = new int[ans];
        int a = 0;
        for (int i = 0; i < len; i++) {
            if (map.get(genre.get(i)).size() >= 2) {
                answer[a++] = map.get(genre.get(i)).get(0).index;
                answer[a++] = map.get(genre.get(i)).get(1).index;
            } else {
                answer[a++] = map.get(genre.get(i)).get(0).index;
            }
        }
        
        return answer;
    }
}