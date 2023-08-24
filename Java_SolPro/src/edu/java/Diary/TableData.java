package edu.java.Diary;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.table.AbstractTableModel;

// 테이블에 뿌려 줄 데이터 생성
public class TableData extends AbstractTableModel{
	private List<AccBookDto> list;
	private String[] headers = {"제목", "글쓴이", "작성일"};
	public TableData(){
		updateList();
	}
	
	public String getColumnName(int cell){
		return headers[cell];
	}
	
	public void updateList(){
		list = new ArrayList<>();
		try{			
			// 파일 있으면 불러옴
			// 없으면 안되기 때문에 try-catch
			
			Scanner sc = new Scanner(new File("data/csv/data.csv"));
			for(int i = 0; sc.hasNextLine();i++){
				String[] data = sc.nextLine().split(",");
				if(i != 0){
					AccBookDto t = new AccBookDto(
							data[0]
							, data[1]
							, Double.parseDouble(data[2])
							);
//					TransactionBuilder tb = new TransactionBuilder(t);
//					t = tb
//							.name(data[0])
//							.type(data[1])
//							.amount(Double.parseDouble(data[2]))
//							.note(data[3])
//							.transaction();
					list.add(t);
				}
			}
		    sc.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	// 컬럼 몇 개 인지
	public int getColumnCount() {
		
		return 3;
	}
	
	// 행 몇 개 인지
	public int getRowCount() {
		System.out.println("list.size() : "+list.size());
		return list.size();
	}
	// 테이블 몇 열에 무슨 행이 들어가야 하는지
	public Object getValueAt(int row, int cell) {
		switch(cell){
			case 0:
				return list.get(row).getName();
			case 1:
				return list.get(row).getType();
			case 2:
				return list.get(row).getAmount();

		}
		return null;
	}

	public void refresh(){
		updateList();
		super.fireTableDataChanged();
	}
}
