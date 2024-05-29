package file;

import java.io.*;

public class CharStreamExample {

    public static void main(String[] args) throws IOException {
        String orgFilename = "D1_Student.txt";//원본 파일 저장
        String copiedFilename = "D1_Student_copied.txt";//복사할 파일 이름 저장

        try {
            FileReader fr = new FileReader(orgFilename);//filereader의 생성자 호출, 매개변수로 경로 전달
            FileWriter fw =new FileWriter(copiedFilename);//filewrither의 생성자 호출, 매개변수로 경로 전달
            copyCharData(fr, fw);//chardata를 copy하는 메서드 호출
            //copyCharArrData(fr, fw);
            fw.flush();//버퍼 비우기
            fw.close();//입력스트림 닫기
            fr.close();//출력스트림 닫기
            System.out.println(orgFilename + " 복사가 완료되었습니다.");
        } catch (FileNotFoundException e) {//파일을 찾을 수 없는 경우
            System.out.println(e.getMessage());//에러메시지를 출력
        }

    }

    private static void copyCharArrData(FileReader fr, FileWriter fw) throws IOException {
        /*
        버퍼를 이용하여 빠르게 복사하는 메서드
        실험 결과 copychardata보다 수십배 이상 빠름
         */
        char[] charArrData = new char[100];//버퍼 배열
        while (fr.read(charArrData) != -1) {//읽고 그 값을 char버퍼에 저장, 읽어온 값이 -1이 아니면 반복
            System.out.print(charArrData);
            fw.write(charArrData);//chararrdata에 있는 값을 write한다
        }

    }

    private static void copyCharData(FileReader fr, FileWriter fw) throws IOException {
        int charData;
        while ((charData = fr.read()) != -1) {//읽고 그 값을 chardata에 저장, 읽어온 값이 -1이 아니면 반복
            System.out.print((char)charData);
            fw.write(charData);//chardata에 있는 값을 쓴다.
        }
    }


}
