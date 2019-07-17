package controller;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import Model.irisObject;
import data.DataParsing;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Training Data Path 30 instances
		//String filePath = "F:/Practice/KNN/src/data/trainDataset_30.txt";
		//String filePath = "F:/Practice/KNN/src/data/trainDataset_90.txt";
		String filePath = "F:/Practice/KNN/src/data/trainDataset_105.txt";
		File trainingDataFile = new File(filePath);
		
		// Testing Data Path
		String testfilePath = "F:/Practice/KNN/src/data/testDataset.txt";
		File testDataFile = new File(testfilePath);
		
		DataParsing parsingObj = new DataParsing();
		ArrayList<irisObject> irisData = new ArrayList<irisObject>();
		ArrayList<irisObject> irisTestData = new ArrayList<irisObject>();
		double instanceDistances[]=null;
		int tp_tn_Count=0;
		int sizeOfTestData=0;
		
		
		try {
				String[] data = parsingObj.readFile(trainingDataFile);		
				String[] testData = parsingObj.readFile(testDataFile);
				instanceDistances= new double[data.length];
				
				irisData = parsingObj.instances(data);
				irisTestData = parsingObj.instances(testData);
				sizeOfTestData =irisTestData.size();
				System.out.println("Test Data Size"+irisTestData.size());
					
				// K = Number of Nearest Number 
					int k=7;  // nearest neighbor
					// loop for test data to be compared with train data 
					for( int i=0; i < irisTestData.size(); i++ ){
						
						// loop of train data base
						for( int j=0; j < irisData.size(); j++ ){
							// calling method to compute distance
							instanceDistances[j] = irisData.get(j).computeDistance(irisData.get(j), irisTestData.get(i));
							irisData.get(j).setDistance(instanceDistances[j]);
						
						}
						
						
						irisData.sort(new DistanceComp());

						int index= NearestNeighbors(irisData,k);
					
						String actual = irisTestData.get(i).getValue();
						String predicted = irisData.get(index).getValue();
						System.out.println("Actual :"+actual);
						
						System.out.println("Predicted :"+predicted);
						
						if(predicted.equals(actual)){
							tp_tn_Count++;
						}
					}
					
					System.out.println("Accuracy: "+(double)tp_tn_Count/sizeOfTestData);
				
					
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static int NearestNeighbors(ArrayList<irisObject> irisData, int nearestNeighb){
		
		int voteCount[] = new int[nearestNeighb];
		String []kNN = new String[nearestNeighb];
		for(int i=0; i<nearestNeighb; i++){
			//System.out.println(i+" :"+cases[i].getDistance());
			
			kNN[i] = Double.parseDouble(new DecimalFormat("##.####").format(irisData.get(i).getDistance()))+"";
			 
		}
		
		
		int count=1;
		for (int i = 0; i < kNN.length; i++) { 	
			for (int j = i + 1; j < kNN.length; j++) { 
				if (kNN[i].equals(kNN[j]) ) {
					
					voteCount[i] = count+1;
				}

			}
			
		}
		
		
		  int maxIndex = 0;
		    for (int i = 1; i < voteCount.length; i++) {
		        int newnumber = voteCount[i];
		        if ((newnumber > voteCount[maxIndex])) {
		            maxIndex = i;
		        }
		    }
		    
		return maxIndex;
	}

}
