import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 정규표현식을 이용해서 천단위 콤마 찍기
 *
 */
public class CommaRegexNewExam {

    public static void main(String[] args) {
        
        
        printResult("150000000"); //변환할 숫자형태의 문자열
        printResult("15000.123");
        printResult("100");
        printResult("100.123");
        printResult(""); 
        printResult(null);
        printResult("abc");
        
    }
    
    //테스트를 출력 포맷
    public static void printResult(String strInputNum) {
        System.out.println("\n『========================");
        System.out.println("입력: "+strInputNum);
        String strOuputNum = CommaRegexNewExam.setComma(strInputNum);
        System.out.println("========================");
        System.out.println("변환결과 : "+strOuputNum);
        System.out.println("========================』");        
    }
    
    /**
     * 정규표현식을 이용해서 천단위 콤마 찍기
     * @param num 숫자형태의 문자열
     * @return 
     */
    public static String setComma(String num) {
        
        //Null 체크
        if(num == null || num.isEmpty()) return "0"; 
    
        //숫자형태가 아닌 문자열일경우 디폴트 0으로 반환 
        String numberExpr = "^[-+]?(0|[1-9][0-9]*)(\\.[0-9]+)?([eE][-+]?[0-9]+)?$";
        boolean isNumber = num.matches(numberExpr);
        if (!isNumber) return "0";             
    
        String strResult = num; //출력할 결과를 저장할 변수
        Pattern p = Pattern.compile("(^[+-]?\\d+)(\\d{3})"); //정규표현식 
        Matcher regexMatcher = p.matcher(num); 
        
        int cnt = 0;
        while(regexMatcher.find()) {                
            strResult = regexMatcher.replaceAll("$1,$2"); //치환 : 그룹1 + "," + 그룹2
                
            System.out.println("과정("+ (++cnt) +"):"+strResult);
                
            //치환된 문자열로 다시 matcher객체 얻기 
            //regexMatcher = p.matcher(strResult); 
            regexMatcher.reset(strResult); 
        }        
        return strResult;
    }
    
    public static String setComma(int num) {        
        return setComma(String.valueOf(num));
    }
    
}