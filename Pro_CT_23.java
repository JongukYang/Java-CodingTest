import java.util.ArrayList;

public class Pro_CT_23 {
    public String solution(int n) {
        String answer = "";
        ArrayList<String> s = new ArrayList<String>();
        String su = "수";
        String bak = "박";
        for(int i = 0; i<n; i++ ) {
            if(i == 0 || i % 2 == 0) {
                s.add(su);
            } else {
                s.add(bak);
            }
        }

        for(int i = 0; i<s.toArray().length; i++) {
            answer += s.get(i);
        }
//        for(String item : s) {
//            answer += item;
//        }
//        System.out.println(s.toString());

        return answer;
//        return new String(new char [n/2+1]).replace("\0", "수박").substring(0,n);
    }

    public static void main(String[] args) {
        Pro_CT_23 sol = new Pro_CT_23();
        int n = 3;
        System.out.println(sol.solution(n));
    }
}

//for (int i = 0; i < n; i++)
//        result += i % 2 == 0 ? "수" : "박";
//        return result;
//        }

//    StringBuffer sf = new StringBuffer();
//        for (int i=1; i<=n; ++i) {
//                sf.append(i%2==1?"수":"박");
//                }
//                return sf.toString();
//                }