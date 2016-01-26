import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ����ǥ������ �̿��ؼ� õ���� �޸� ���
 *
 */
public class CommaRegexNewExam {

    public static void main(String[] args) {
        
        
        printResult("150000000"); //��ȯ�� ���������� ���ڿ�
        printResult("15000.123");
        printResult("100");
        printResult("100.123");
        printResult(""); 
        printResult(null);
        printResult("abc");
        
    }
    
    //�׽�Ʈ�� ��� ����
    public static void printResult(String strInputNum) {
        System.out.println("\n��========================");
        System.out.println("�Է�: "+strInputNum);
        String strOuputNum = CommaRegexNewExam.setComma(strInputNum);
        System.out.println("========================");
        System.out.println("��ȯ��� : "+strOuputNum);
        System.out.println("========================��");        
    }
    
    /**
     * ����ǥ������ �̿��ؼ� õ���� �޸� ���
     * @param num ���������� ���ڿ�
     * @return 
     */
    public static String setComma(String num) {
        
        //Null üũ
        if(num == null || num.isEmpty()) return "0"; 
    
        //�������°� �ƴ� ���ڿ��ϰ�� ����Ʈ 0���� ��ȯ 
        String numberExpr = "^[-+]?(0|[1-9][0-9]*)(\\.[0-9]+)?([eE][-+]?[0-9]+)?$";
        boolean isNumber = num.matches(numberExpr);
        if (!isNumber) return "0";             
    
        String strResult = num; //����� ����� ������ ����
        Pattern p = Pattern.compile("(^[+-]?\\d+)(\\d{3})"); //����ǥ���� 
        Matcher regexMatcher = p.matcher(num); 
        
        int cnt = 0;
        while(regexMatcher.find()) {                
            strResult = regexMatcher.replaceAll("$1,$2"); //ġȯ : �׷�1 + "," + �׷�2
                
            System.out.println("����("+ (++cnt) +"):"+strResult);
                
            //ġȯ�� ���ڿ��� �ٽ� matcher��ü ��� 
            //regexMatcher = p.matcher(strResult); 
            regexMatcher.reset(strResult); 
        }        
        return strResult;
    }
    
    public static String setComma(int num) {        
        return setComma(String.valueOf(num));
    }
    
}