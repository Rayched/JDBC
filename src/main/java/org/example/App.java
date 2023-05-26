package org.example;

import org.example.container.Container;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    public void run(){
        Scanner sc = Container.scanner;
        List<Article> articles = new ArrayList<>();
        int articleLastId = 0; //게시물 번호

        while(true){
            System.out.printf("명령어) ");
            String cmd = sc.nextLine();

            //게시물 작성 logic
            if(cmd.equals("usr/article/write")){
                System.out.println("=== 게시물 등록 ===");
                System.out.printf("제목) ");
                String title = sc.nextLine();
                System.out.printf("내용) ");
                String content = sc.nextLine();
                int id = ++articleLastId;

                Article article = new Article(id, title, content);
                System.out.println("생성된 게시물 객체: " + article);

                articles.add(article);

                System.out.printf("%d번 게시물이 등록되었습니다.\n", article.id);
            }
            //작성한 게시물 리스트 조회
            else if(cmd.equals("usr/article/list")){
                System.out.println("=== 게시물 리스트 ===");
            }
            //프로그램 종료
            else if (cmd.equals("exit")){
                System.out.println("프로그램 종료");
                break;
            }
            else {
                System.out.println("잘못된 명령어 입력입니다.");
            }
        }
        sc.close(); //반복문을 빠져나오면 Scanner 명령어 입력받기를 종료한다.
    }
}
