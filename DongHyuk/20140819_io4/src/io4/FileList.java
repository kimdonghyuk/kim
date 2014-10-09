package io4;

import java.io.File;
import java.util.Arrays;

public class FileList {
	// bad code
	public static void main(String[] args)throws Exception{
		
		String dirName = "C"
				+ ":\\zzz\\mp3";
		File mp3Dir = new File(dirName);
		String[] songList = mp3Dir.list();
		
		// System.out.println(Arrays.toString(songList));
		// mp3파일안에 있는 파일명들을 배열로 저장해줌
		
		
		StringBuilder builder = new StringBuilder();
		// StringBuilder라는 함수 : 문자를 구분해주는 함수
		for(String title : songList){
			builder.append(title+" | ");}
		
		System.out.println(builder);
		System.out.println("-------------------------------------");
		
		// 제목들 사이에 | 를 구분지어줌.
		
		String result = builder.toString();
		String[] arr = result.split("\\| ");
		
		for(String string : arr){
			System.out.println(string);}
	}
}
