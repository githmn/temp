import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import client.ISCRClient;
import core.ISCRParameter;


public class Main {

	public static void main(String args[]){
		new Main().exec();
	}
	
	private void exec(){

		String etlPath = "C:/ETLDatabase/ETL8/";
		File srcDirs[] = new File(etlPath).listFiles();

		for(File srcDir : srcDirs){

			File srcFiles[] = srcDir.listFiles();

			for(File srcFile : srcFiles){

				BufferedImage srcImg = null;
				try {
					srcImg = ImageIO.read(srcFile);

				} catch (IOException e) {
					e.printStackTrace();
					return;
				}

				// 認識パラメータ作成
				ISCRParameter param = new ISCRParameter();
				param.apiKey = "TEbGHTG6oJ4BoW7lOuMQul1IfUJwLEXz";
				param.topNum = 3;
				param.attribute = ISCRParameter.ATTRIBUTE.ASCII;
				param.scored = true;

				// 認識オブジェクト作成
				ISCRClient client = new ISCRClient();

				// 認識
				String resStr = client.recognition(srcImg, param);
				
				System.out.println(srcFile.getName() + " : " + resStr);
				
			}
		}


	}
	
}
