package jj.function;

import java.util.Arrays;
import java.util.List;

public class StreamPractice01 {
	
	public void practice1() {
		/*
		 * [AS-IS] 기존 코딩 방식
		 * List에 담긴 단어들 에서 특정 스펠링이 들어가있는 단어의 개수를 구하기
		 * 
		 * */
		System.out.println("#### (1-asis) [AS-IS] List 단어 개수 찾기");
		List<String> words = Arrays.asList("jjong", "qqqqiii", "qwelkjiojv", "11238njdnfo", "11112344nnjn"); // o포함 3개
		long count = 0;
		for(String rs : words) {
			if(rs.contains("o")) {
				count++;
			}
		}
		System.out.println("count : " + count); // 결과 : 3

		/*
		 * [TO-BE] 기존 코딩 방식
		 * List에 담긴 단어들 에서 특정 스펠링이 들어가있는 단어의 개수를 구하기
		 * 
		 * */
		System.out.println("#### (1-tobe) [TO-BE] List 단어 개수 찾기");
		count = 0; // 변수 위에서 가져다 씀
		count = words.stream()
				.filter(rs -> rs.contains("o"))
				.count(); // count() 반환형은 long 타입이다.
		System.out.println("count : " + count); // 결과 : 3
		
	}
	
	public void practice2 () {
		/*
		 * stream 중개연산 함수 사용해보기
		 * 1. map 사용
		 * 
		 * */
		System.out.println("#### (map) stream 중개연산 함수 사용해보기");
		List<String> words = Arrays.asList("jjong", "qqqqiii", "qwelkjiojv", "11238njdnfo", "11112344nnjn"); // o포함 3개
		words.parallelStream()
			.map(rs -> rs.toUpperCase())
			.forEach(rs -> System.out.println(rs));
	}
	
	public void practice3 () {
		/*
		 * stream 중개연산 함수 사용해보기
		 * 2. peek 사용
		 * 
		 * */
		System.out.println("#### (peek) stream 중개연산 함수 사용해보기");
		int [] intArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		Arrays.stream(intArr)
			.filter(rs -> rs%2 == 0)
			.peek(System.out::println)
			.sum();
	}
	
	public void practice4 () {
		/*
		 * stream 중개연산 함수 사용해보기
		 * 3. sorted 사용
		 * 
		 * */
		System.out.println("#### (sorted) stream 중개연산 함수 사용해보기");
		int [] intArr = {5, 2, 7, 8, 4, 8, 4, 5, 7};
		Arrays.stream(intArr)
			.sorted()
			//.forEach(System.out::println); // 이렇게 출력해도 되지만
			.forEach(rs -> System.out.print(rs + " "));
		System.out.println();
	}
	
}














