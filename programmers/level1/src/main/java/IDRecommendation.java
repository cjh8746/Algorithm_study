import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

//https://programmers.co.kr/learn/courses/30/lessons/72410
public class IDRecommendation {
    //1단계 new_id의 모든 대문자를 대응되는 소문자로 치환합니다.
    //2단계 new_id에서 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자를 제거합니다.
    //3단계 new_id에서 마침표(.)가 2번 이상 연속된 부분을 하나의 마침표(.)로 치환합니다.
    //4단계 new_id에서 마침표(.)가 처음이나 끝에 위치한다면 제거합니다.
    //5단계 new_id가 빈 문자열이라면, new_id에 "a"를 대입합니다.
    //6단계 new_id의 길이가 16자 이상이면, new_id의 첫 15개의 문자를 제외한 나머지 문자들을 모두 제거합니다.
    //만약 제거 후 마침표(.)가 new_id의 끝에 위치한다면 끝에 위치한 마침표(.) 문자를 제거합니다.
    //7단계 new_id의 길이가 2자 이하라면, new_id의 마지막 문자를 new_id의 길이가 3이 될 때까지 반복해서 끝에 붙입니다.
    public static String IDRecommendation(String new_id) {

        //1
        String lower_id = new_id.toLowerCase();

        //2
        String str = lower_id.replaceAll("[^a-z0-9-_.]","");

        //3
       str = str.replaceAll("[.]{2,}",".");

       //4
        str = str.replaceAll("^[.]","");
        str = str.replaceAll("[.]$","");

        //5
        if (str.length() == 0) {
            str = "a";
        }

        String id_5 = str;

        //6
        if (id_5.length() > 15) {
           id_5 = id_5.substring(0,15);
           id_5 = id_5.replaceAll("[.]$","");
        }

        //7
        if (id_5.length() < 3) {
            for (int i = id_5.length(); i < 3; i++) {
                id_5 += id_5.charAt(id_5.length() - 1);
            }
        }

        String answer = id_5;

        return answer;
    }

    public static void main(String[] args) {
        String input = "...!@BaT#*..y.abcdefghijklm";

        System.out.println(IDRecommendation(input));
    }


}
