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
		// mp3���Ͼȿ� �ִ� ���ϸ���� �迭�� ��������
		
		
		StringBuilder builder = new StringBuilder();
		// StringBuilder��� �Լ� : ���ڸ� �������ִ� �Լ�
		for(String title : songList){
			builder.append(title+" | ");}
		
		System.out.println(builder);
		System.out.println("-------------------------------------");
		
		// ����� ���̿� | �� ����������.
		
		String result = builder.toString();
		String[] arr = result.split("\\| ");
		
		for(String string : arr){
			System.out.println(string);}
	}
}
