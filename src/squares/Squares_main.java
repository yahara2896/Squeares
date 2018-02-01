package squares;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
		double value2[][] = new double[100][4];
		
		for(int i = 0; i < 100; i++){
			theta = slib.getDx();
			System.out.println(i+" : theta[0] = "+theta[0]);
			System.out.println(i+" : theta[1] = "+theta[1]);
			System.out.println(i+" : Objective function = "+slib.getObject());
			
			value[i] = slib.getObject();
			value2[i][0] = i;
			value2[i][1] = slib.getObject();
			value2[i][2] = theta[0];
			value2[i][3] = theta[1];
			
		}

		Graph graph = new Graph(value);
		graph.setBounds(5,5,655,455);
		graph.setVisible(true);
		
		smain.writeCSV("csv/result.csv", value2);
		
	}

	public double[] getCSV1(String path, int n) { //CSV����1�����f�[�^��荞��(n:�f�[�^��)
		//CSV�����荞��
		double csvdata[] = new double[n];
		try {
			File f = new File(path);
			BufferedReader br = new BufferedReader(new FileReader(f));
				 
			String[] data = new String[n];
			String line = br.readLine();
			data = line.split(",", 0);
			line = br.readLine();
			br.close();
			
			// CSV����ǂݍ��񂾔z��̒��g����荞��
			for(int i = 0; i < data.length; i++) {
				csvdata[i] = Double.parseDouble(data[i]);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.println("CSV��荞�� = "+Arrays.toString(csvdata));
		return csvdata;
		//CSV�����荞�݂����܂�
	}

	
	public void writeCSV(String path, double[][] value) {
		try {
			FileWriter fw = new FileWriter(path, true); //true:�ǋL�Afalse:�㏑��
			PrintWriter pw = new PrintWriter(new BufferedWriter(fw));
			//���e���w�肷��
			for(int i = 0; i < value.length; i++) {
				for(int j = 0; j < value[0].length; j++) {
					pw.print(value[i][j]);
					pw.print(",");
					//pw.println();
				}
				pw.println();
			}
	        pw.println();
	        //�t�@�C���ɏ����o��
		    pw.close();
	
	        //�I�����b�Z�[�W����ʂɏo�͂���
	        System.out.println("�o�͊��� : "+path);
		}catch(IOException e) {
			e.printStackTrace();
		}

	}
}
		
	

