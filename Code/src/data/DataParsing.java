package data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import Model.irisObject;


public class DataParsing {
	private int dataSize;
	
	public  String[] readFile(File file) throws IOException{
		FileReader freader = new FileReader(file);
		BufferedReader reader = new BufferedReader(freader);
		String totalData[] = new String [totalSize(file)];
		String row="";
		
		 this.dataSize=0;
		try {
			//System.out.println("within getData's Try block"+reader.readLine());	
				while((row=reader.readLine())!=null){
					//System.out.println(row);
					totalData[this.dataSize]=row;
					this.dataSize=this.dataSize+1;
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return totalData;
	}
	
	
	public int getTotalSize(){
		return this.dataSize;
	}
	
	public int totalSize(File f) throws IOException{
		LineNumberReader  lineNumber = new LineNumberReader(new FileReader(f));
		lineNumber.skip(Long.MAX_VALUE);
		//System.out.println(lineNumber.getLineNumber() + 1); 
		lineNumber.close();
		return lineNumber.getLineNumber() + 1;
	}
	
	public ArrayList<irisObject> instances(String [] totalData){
		ArrayList<irisObject> iris = new ArrayList<irisObject>();
		
		for(int i=0; i<totalData.length;i++){
			String tmp =totalData[i];
			StringTokenizer token = new StringTokenizer(tmp,",");
			int count =0;
			while(token.hasMoreTokens()){
				//System.out.println(token.nextToken()+" "+token.nextToken()+" "+token.nextToken()+" "+token.nextToken()+token.nextToken());
				iris.add(new irisObject(Double.parseDouble(token.nextToken()), Double.parseDouble(token.nextToken()), Double.parseDouble(token.nextToken()), Double.parseDouble(token.nextToken()), token.nextToken()));
				//iris.get(i).printCase(iris.get(i));
			}
		}
		
		return iris;
	}

}
