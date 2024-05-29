package file;

import java.io.*; //필요 입출력 클래스들 너무 많길래 하나로 줄임

public class ByteStreamExample {

    public static void main(String[] args) throws IOException {
        String orgFilename = "C:/text01.txt"; // 원본 파일 경로 저장
        String copiedFilename = "C:/text01_copied.txt"; // 복사 파일 경로 저장
        try {
            FileInputStream fis = new FileInputStream(orgFilename); // 원본 파일을 읽기 위해 생성
            FileOutputStream fos = new FileOutputStream(copiedFilename); // 복사 파일을 쓰기 위해 생성
            copyEachOneByte(fis, fos); // byte 단위로 복사하는 메서드
            //copyEachKByte(fis, fos); // kb 단위로 복사하는 메서드
            fos.flush(); // 버퍼 비우기(모두 출력)
            fos.close(); // 스트림 닫기
            fis.close(); // 스트림 닫기
            System.out.println("복사가 완료되었습니다.");
        } catch (FileNotFoundException e) { //예외처리
            System.out.println(e.getMessage()); //예외 메시지 출력
        }
    }

    private static void copyEachOneByte(FileInputStream fis, FileOutputStream fos) throws IOException {
        int byteInput; // 데이터를 저장할 변수
        while ((byteInput = fis.read()) != -1) { // 파일의 끝이 아닐 때까지 한 byte씩 읽음
            fos.write(byteInput); // 읽어들인 byte를 출력 스트림에 씀
        }
    }

    private static void copyEachKByte(FileInputStream fis, FileOutputStream fos) throws IOException {
        byte kbInput[] = new byte[1024];
        int bytesRead;// 실제 읽어들인 바이트 수
        while ((bytesRead = fis.read(kbInput)) != -1) { // 파일의 끝이 아닐 때까지(-1) kb단위로 읽음
            fos.write(kbInput, 0, bytesRead); // 읽어들인 바이트 수만큼 출력 스트림에 씀
        }
    }

}
