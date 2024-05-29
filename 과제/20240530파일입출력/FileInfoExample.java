package file;

import java.io.*;

public class FileInfoExample {

    public static void main(String[] args) throws IOException {

        File imgDir = new File("C:/Temp/images");//생성자 호출, 매개변수로 pathname(경로) 전달
        File testFile = new File("C:/Temp/test.txt");//위와 같다

        if(imgDir.exists() == false) {//이미지 디렉터리가 존재하지 않는 경우 실행
            imgDir.mkdirs();//이미지 디렉터리를 만든다
            System.out.println(imgDir.getName() + "을 생성합니다.");
        }
        if(testFile.exists() == false) {//testfile이 존재하지 않는 경우 실행
            testFile.createNewFile();
            System.out.println(testFile.getName() + "을 생성합니다.");
        }

        File tempDir = new File("C:/Temp");//생성자 호출하며 매개변수로 pathname 전달
        File[] contents = tempDir.listFiles();//temp 디렉터리에 있는 파일 및 서브 디렉터리 목록 반환
        System.out.println(tempDir.getName() + "의 내용을 출력합니다.");
        for(File file : contents) {//향상된 for문, content 배열에 있는 요소를 순서대로 지역변수 file에 전달
            System.out.print("\t" + file.getName());//getName() : 파일의 이름을 반환
            if (file.isDirectory()) {//만약 file이 dir인 경우 실행
                System.out.print("<DIR>");
            }
            else {//dir이 아닌 나머지 경우 실행
                System.out.print("<"+file.length() + ">");//파일 길이 반환
            }
            System.out.println();
        }

    }

}
