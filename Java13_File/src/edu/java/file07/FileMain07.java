package edu.java.file07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import edu.java.file05.Product;

public class FileMain07 {

	public static void main(String[] args) {
		// TODO 
		// 1. ArrayList<Student> 객체 생성
		// 2. 1,000,000개의 Student 객체를 리스트에 저장 - Random
		// 3. 리스트를 students.dat 파일에 씀. (직렬화해서)
		// 4. 파일에서 데이터를 읽어서 역직렬화 -> 읽은 데이터 확인.

		
		List<Student> students = new ArrayList<>();
		Random rd = new Random();
		
		for (int i = 0; i < 1_000_000; i++) {
			Score score = new Score(rd.nextInt(101), rd.nextInt(101), rd.nextInt(101));
			Student student = new Student(i, "NAME_"+i, score);
			students.add(student);
		}
		System.out.println("students number: " + students.size());
		String file = "data/students.dat";
		
		FileOutputStream out = null;
		BufferedOutputStream bout = null;
		ObjectOutputStream oout = null;
		
		try {
			out = new FileOutputStream(file);
			bout = new BufferedOutputStream(out);
			oout = new ObjectOutputStream(bout);
			
			long start = System.currentTimeMillis(); // 쓰기 시작 시간
			oout.writeObject(students); // 리스트를 직렬화
			long end = System.currentTimeMillis();
			System.out.println("students write: " + (end - start) + "ms");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oout.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		try (
				FileInputStream in = new FileInputStream(file);
				BufferedInputStream bin = new BufferedInputStream(in);
				ObjectInputStream oin= new ObjectInputStream(bin);
		) {
			long start = System.currentTimeMillis(); 
			List<Student> result = (ArrayList<Student>) oin.readObject();
			long end = System.currentTimeMillis();
			System.out.println("read 경과 시간:" + (end - start) + "ms");
			System.out.println("size = " + result.size());
			System.out.println(result.get(1));
		} catch (Exception e) {
			e.printStackTrace();
		}

	
	}

}
