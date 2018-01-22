package squares;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Squares_main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//double x[] = {0.0,0.3,0.6,0.9,1.2,1.5,1.8};
		//double y[] = { 4.0, 4.9, 4.2,5.0, 4.6, 5.2,5.8 };
		Squares_main smain = new Squares_main();
		double x[] = smain.getCSV1("csv/x.csv",7);
		double y[] = smain.getCSV1("csv/y.csv",7);
		
		double theta[] = new double[2];

		Squares_lib slib = new Squares_lib(x, y);

		double value[] = new double[100];
		
		for(int i = 0; i < 100; i++){
			theta = slib.getDx();
			System.out.println(i+" : theta[0] = "+theta[0]);
			System.out.println(i+" : theta[1] = "+theta[1]);
			System.out.println(i+" : Objective function = "+slib.getObject());
			
			value[i] = slib.getObject();
		}

		Graph graph = new Graph(value);
		graph.setBounds(5,5,655,455);
		graph.setVisible(true);
		
	}

	public double[] getCSV1(String path, int n) { //CSVから1次元データ取り込み(n:データ数)
		//CSVから取り込み
		double csvdata[] = new double[n];
		try {
			File f = new File(path);
			BufferedReader br = new BufferedReader(new FileReader(f));
				 
			String[] data = new String[n];
			String line = br.readLine();
			data = line.split(",", 0);
			line = br.readLine();
			br.close();
			
			// CSVから読み込んだ配列の中身を取り込み
			for(int i = 0; i < data.length; i++) {
				csvdata[i] = Double.parseDouble(data[i]);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("CSV取り込み = "+Arrays.toString(csvdata));
		return csvdata;
		//CSVから取り込みここまで
	}

	
}
